package com.integration.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

//@Component
public class RedeliveryProcessor implements Processor {

    public void process(Exchange exchange) throws Exception {     
        exchange.getIn().setBody("test1");
    }

}