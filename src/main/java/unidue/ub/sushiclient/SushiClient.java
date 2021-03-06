package unidue.ub.sushiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.jdom2.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.apache.commons.httpclient.HttpClient;
import unidue.ub.media.analysis.Counter;
import unidue.ub.media.analysis.CounterTools;
import unidue.ub.settings.fachref.Sushiprovider;
import unidue.ub.sushiclient.service.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.soap.*;
import java.io.*;
import java.lang.Exception;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value="sushi")
public class SushiClient extends WebServiceGatewaySupport {

    private final static String namespaceCounter = "http://www.niso.org/schemas/sushi/counter";

    private final static String namespaceSushi = "http://www.niso.org/schemas/sushi";

    private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private int release = 4;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String reportType;

    private ObjectMapper mapper = new ObjectMapper();

    @Value("${ub.statistics.data.url}")
    private String dataUrl;

    public SushiClient() {
        LocalDateTime TODAY  = LocalDateTime.now();
        int timeshift;
        if (TODAY.getDayOfMonth() < 15)
            timeshift = 3;
        else
            timeshift = 2;
        startTime = LocalDateTime.now().minusMonths(timeshift).withDayOfMonth(1);
        endTime =  LocalDateTime.now().minusMonths(timeshift-1).withDayOfMonth(1).minusDays(1);
        release = 4;
        reportType = "JR1";
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int release) {
        this.release = release;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    private final static Logger log = LoggerFactory.getLogger(SushiClient.class);

    private final WebServiceTemplate webServiceTemplate = getWebServiceTemplate();

    public CounterReportResponse getReport(String sushiproviderName) throws IOException, SOAPException {

        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        log.info("retrieving data for sushiprovider number " + sushiproviderName);

        Sushiprovider provider = mapper.readValue(new URL("http://localhost:11300/sushiprovider/" + sushiproviderName),
                Sushiprovider.class);
        log.info("read sushiprovider " + provider.getName());
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("coun", namespaceCounter);
        envelope.addNamespaceDeclaration("sus", namespaceSushi);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement reportRequest = soapBody.addChildElement("ReportRequest", "coun");
        reportRequest.setAttribute("ID", provider.getSushiRequestorID());
        reportRequest.setAttribute("Created", ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));

        SOAPElement requestor = reportRequest.addChildElement("Requestor", "sus");
        SOAPElement requestorID = requestor.addChildElement("ID", "sus");
        requestorID.addTextNode(provider.getSushiRequestorID());

        if (!provider.getSushiRequestorName().isEmpty()) {
            SOAPElement requestorName = requestor.addChildElement("Name", "sus");
            requestorName.addTextNode(provider.getSushiRequestorName());
        }

        if (!provider.getSushiRequestorEmail().isEmpty()) {
            SOAPElement requestorEmail = requestor.addChildElement("Email", "sus");
            requestorEmail.addTextNode(provider.getSushiRequestorEmail());
        }

        SOAPElement customerReference = reportRequest.addChildElement("CustomerReference", "sus");
        SOAPElement customerReferenceID = customerReference.addChildElement("ID","sus");
        customerReferenceID.addTextNode(provider.getSushiCustomerReferenceID());

        if (!provider.getSushiCustomerReferenceName().isEmpty()) {
            SOAPElement customerReferenceName = customerReference.addChildElement("Name","sus");
            customerReferenceName.addTextNode(provider.getSushiCustomerReferenceName());
        }

        SOAPElement reportDefinition = reportRequest.addChildElement("ReportDefinition","sus");
        reportDefinition.setAttribute("Release", String.valueOf(release));
        reportDefinition.setAttribute("Name", reportType);

        SOAPElement filters = reportDefinition.addChildElement("Filters","sus");
        SOAPElement usageDataRange = filters.addChildElement("UsageDateRange","sus");

        SOAPElement begin = usageDataRange.addChildElement("Begin","sus");
        begin.addTextNode(startTime.format(dtf));

        SOAPElement end = usageDataRange.addChildElement("End","sus");
        end.setTextContent(endTime.format(dtf));

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", "SushiService:GetReportIn");

        soapMessage.saveChanges();

        SOAPMessage soapResponse = soapConnection.call(soapMessage, provider.getSushiURL());
        List<Counter> counters = new ArrayList<>();
        try {
            counters = CounterTools.convertSOAPMessageToCounters(soapResponse);
            write(counters);
        } catch (Exception e) {

        }
        CounterReportResponse response = new CounterReportResponse();

        try {
            Unmarshaller unmarshaller = JAXBContext.newInstance(CounterReportResponse.class).createUnmarshaller();
            response = (CounterReportResponse) unmarshaller.unmarshal(soapResponse.getSOAPBody().extractContentAsDocument());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return response;
    }

    public void write(List list) throws Exception {
        for (Object counter : list) {
                String json = mapper.writeValueAsString(counter);
                HttpClient client = new HttpClient();
                PostMethod post = new PostMethod(dataUrl + "/journalcounter");
                RequestEntity entity = new StringRequestEntity(json, "application/json", null);
                post.setRequestEntity(entity);
                int status = client.executeMethod(post);
                log.info("posted counter with return status " + status);
        }
    }

}
