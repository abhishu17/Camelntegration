package com.integration.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.integration.exception.CustomException;

@Component
public class MessageProcessor  implements Processor{
	
	 public void process(Exchange exchange) throws Exception {
		 String a = exchange.getIn().getBody(String.class);
	        System.out.println("hello----> " + a + " Route id "+ exchange.getFromRouteId() + "::" +
	        		exchange.getExchangeId() + ":: " + exchange.getContext().getName());
	        if (a.equalsIgnoreCase("test"))
	            throw new CustomException();
	        
	    }

}
