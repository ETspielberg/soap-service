package unidue.ub.sushiclient;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import unidue.ub.settings.fachref.Sushiprovider;
import unidue.ub.sushiclient.service.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;

@RequestMapping(value="sushi")
public class SushiClient extends WebServiceGatewaySupport {

    private final static Logger log = LoggerFactory.getLogger(SushiClient.class);

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

        LocalDateTime start = today.minusMonths(2);
        LocalDateTime end = today.minusMonths(1);
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

        CounterReportResponse response = (CounterReportResponse) getWebServiceTemplate()
                .marshalSendAndReceive(provider.getSushiURL(),
                        request,
                        new SoapActionCallback("SushiService:GetReportIn"));

        return response;
    }

}
