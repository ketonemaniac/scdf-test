package io.spring.dataflow.sample.usagecostlogger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsageCostLoggerKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsageCostLoggerKafkaApplication.class, args);
	}

}
