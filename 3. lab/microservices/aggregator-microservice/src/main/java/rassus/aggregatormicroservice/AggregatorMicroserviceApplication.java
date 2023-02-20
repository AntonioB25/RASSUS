package rassus.aggregatormicroservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

//@Configuration
@SpringBootApplication
public class AggregatorMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AggregatorMicroserviceApplication.class, args);
	}

}
