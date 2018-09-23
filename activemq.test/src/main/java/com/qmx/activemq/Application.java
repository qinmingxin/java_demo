package com.qmx.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableJms
public class Application { 

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
