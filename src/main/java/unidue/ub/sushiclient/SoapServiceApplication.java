package unidue.ub.sushiclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import unidue.ub.sushiclient.service.CounterReportResponse;

@SpringBootApplication
public class SoapServiceApplication {

	public static void main(String[] args) {SpringApplication.run(SoapServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner lookup(SushiClient sushiClient) {
		return args -> {
			String sushiprovider = "MSFT";

			if (args.length > 0) {
				sushiprovider = args[0];
			}
			CounterReportResponse response = sushiClient.getReport(sushiprovider);
			System.err.println(response.getID());
		};
	}

}
