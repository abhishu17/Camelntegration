package com.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.integration.controller","com.integration.service",
	"com.integration.route","com.integration.common"})
public class IntegrationAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(IntegrationAppApplication.class, args);
	}
}
