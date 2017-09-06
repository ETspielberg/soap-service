package unidue.ub.sushiclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SushiConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("unidue.ub.sushiclient.service");
        return marshaller;
    }

    @Bean
    public SushiClient sushiClient(Jaxb2Marshaller marshaller) {
        SushiClient client = new SushiClient();
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.setDefaultUri("http://sushi4.scholarlyiq.com/SushiService.svc");
        return client;
    }
}
