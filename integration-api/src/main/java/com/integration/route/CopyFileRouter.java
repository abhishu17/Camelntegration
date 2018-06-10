package com.integration.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.integration.common.*;
import com.integration.exception.*;
import com.integration.processor.*;

@Component
public class CopyFileRouter extends RouteBuilder {

	  private AppConfig app;	
	  
    @Autowired
    public void setApp(AppConfig app) {
        this.app = app;
    }
	    
    @Override
    public void configure() throws Exception {
    	
    	 onException(CustomException.class).process(new Processor() {
             public void process(Exchange exchange) throws Exception {
                 System.out.println("handling ex");
             }
         });//.onRedelivery(new MessageProcessor()).redeliveryPolicyRef("appRedeliveryPolicyProfile").log("Received body ").handled(true);
    	 
    	 System.out.println("App "+ app);
    	 String inputLocation = app.getInputLocation();// "C:/NEC/Development/ACamel/Files/inputFolder";
    	 System.out.println("input Location "+ inputLocation);
    	// inputLocation ="C:/NEC/Development/ACamel/Files/inputFolder";
    	 String outputLocation =  app.getOutputLocation(); //"C:/NEC/Development/ACamel/Files/outputFolder";
    	 
    	 from("file:"+inputLocation+"?noop=true").process(new MessageProcessor()).to("file:"+outputLocation);
    }

}