package com.integration.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {
	 @Value("${inputLocation}")
	 private String inputLocation;
	 @Value("${outputLocation}")
	 private String outputLocation;
	 
	 @Value("${inputCSV}")
	 private String inputCSV;
	 
	 public String getInputCSV() {
		return inputCSV;
	}

	public void setInputCSV(String inputCSV) {
		this.inputCSV = inputCSV;
	}

	@Bean
	 public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	 }

	public String getInputLocation() {
		return inputLocation;
	}

	public void setInputLocation(String inputLocation) {
		this.inputLocation = inputLocation;
	}

	public String getOutputLocation() {
		return outputLocation;
	}

	public void setOutputLocation(String outputLocation) {
		this.outputLocation = outputLocation;
	}	 
	 
	 
} 