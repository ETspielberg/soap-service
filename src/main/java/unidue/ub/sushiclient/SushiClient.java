package unidue.ub.sushiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import unidue.ub.settings.fachref.Sushiprovider;
import unidue.ub.sushiclient.service.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.soap.*;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.Exception;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Iterator;

@RequestMapping(value="sushi")
public class SushiClient extends WebServiceGatewaySupport {

    private final static Logger log = LoggerFactory.getLogger(SushiClient.class);

    private final WebServiceTemplate webServiceTemplate = getWebServiceTemplate();

    public CounterReportResponse getReport(String sushiproviderName) throws IOException {

        log.info("retrieving data for sushiprovider number " + sushiproviderName);

        ObjectMapper mapper = new ObjectMapper();
        Sushiprovider provider = mapper.readValue(new URL("http://localhost:11300/sushiprovider/" + sushiproviderName),
                Sushiprovider.class);
        log.info("read sushiprovider " + provider.getName());

        ReportRequest request = new ReportRequest();

        CustomerReference reference = new CustomerReference();
        reference.setID(provider.getSushiCustomerReferenceID());

        // create the Requestor object
        Requestor requestor = new Requestor();
        requestor.setID(provider.getSushiRequestorID());
        if (!provider.getSushiRequestorName().isEmpty())
            requestor.setName(provider.getSushiRequestorName());

        // create the ReportDefinition
        ReportDefinition definition = new ReportDefinition();
        definition.setRelease(String.valueOf(provider.getSushiRelease()));
        definition.setName("JR1");

        // createFilters
        ReportDefinition.Filters filters = new ReportDefinition.Filters();
        Range range = new Range();
        LocalDateTime today = LocalDateTime.now();

        LocalDateTime start = today.minusMonths(3);
        LocalDateTime end = today.minusMonths(2);
        try {
            range.setBegin(DatatypeFactory.newInstance().newXMLGregorianCalendar(start.toString()));
            range.setEnd(DatatypeFactory.newInstance().newXMLGregorianCalendar(end.toString()));
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        filters.setUsageDateRange(range);
        definition.setFilters(filters);

        // build the request
        request.setCustomerReference(reference);
        request.setRequestor(requestor);
        request.setReportDefinition(definition);
        request.setID(provider.getSushiRequestorID());
        try {
            request.setCreated(DatatypeFactory.newInstance().newXMLGregorianCalendar(LocalDateTime.now().toString()));
        } catch (DatatypeConfigurationException e1) {
            e1.printStackTrace();
        }

        CounterReportResponse response = (CounterReportResponse) webServiceTemplate
                .marshalSendAndReceive(//provider.getSushiURL(),
                        "http://localhost:5555",
                        request,
                        new WebServiceMessageCallback() {
                            @Override
                            public void doWithMessage(WebServiceMessage webServiceMessage) throws IOException, TransformerException {
                                SaajSoapMessage message = (SaajSoapMessage) webServiceMessage;
                                MimeHeaders mimeHeaders = message.getSaajMessage().getMimeHeaders();
                                mimeHeaders.setHeader("SOAPAction","SushiService:GetReportIn");
                                try {
                                    SOAPEnvelope envelope = message.getSaajMessage().getSOAPPart().getEnvelope();
                                    envelope.removeNamespaceDeclaration("SOAP-ENV");
                                    envelope.addNamespaceDeclaration("soap", "http://schemas.xmlsoap.org/soap/envelope/");
                                    envelope.setPrefix("soap");
                                    message.getSaajMessage().getSOAPHeader().setPrefix("soap");
                                    Iterator<SOAPElement> iterator = message.getSaajMessage().getSOAPBody().getChildElements();
                                    log.info("removing namespaces");
                                        while (iterator.hasNext()) {

                                            SOAPElement element = iterator.next();
                                            log.info("dealing with element " + element.getNodeName());
                                            if (element.hasChildNodes()) {
                                                Iterator<SOAPElement> childIterator = element.getChildElements();
                                                while (childIterator.hasNext()) {
                                                    SOAPElement child = (SOAPElement) childIterator.next();
                                                    log.info("dealing with element " + child.getNodeName());
                                                    child.removeNamespaceDeclaration("sus");
                                                    log.info("removed namespace sus");
                                                }
                                            }
                                            element.removeNamespaceDeclaration("ns3");
                                            log.info("removed namespace ns3");
                                            element.removeNamespaceDeclaration("ns4");
                                            log.info("removed namespace ns4");
                                        }

                                    SOAPBody body = message.getSaajMessage().getSOAPBody();
                                    body.setPrefix("soap");
                                    SOAPFault fault = message.getSaajMessage().getSOAPBody().getFault();
                                    if (fault != null) {
                                        fault.setPrefix("soap");
                                    }

                                } catch (SOAPException e) {
                                    e.printStackTrace();
                                    log.info("could not set soap prefix");
                                }
                            }
                        });
        return response;
    }

}
