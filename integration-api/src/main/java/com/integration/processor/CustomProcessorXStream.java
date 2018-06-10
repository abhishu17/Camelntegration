package com.integration.processor;

import org.apache.camel.Exchange;

import com.integration.common.Employee;

import java.util.StringTokenizer;
public class CustomProcessorXStream implements org.apache.camel.Processor {
    public void process(Exchange exchange) throws Exception {
        String newBody = exchange.getIn().getBody(String.class);
        StringTokenizer tokenizer = new StringTokenizer(newBody, ",");
        Employee employee = new Employee();
        while (tokenizer.hasMoreElements()){
            employee.setEmployeeID((String) tokenizer.nextElement());
            employee.setName((String) tokenizer.nextElement());
            employee.setSalary((String) tokenizer.nextElement());
        }
        exchange.getIn().setBody(employee);
    }
}