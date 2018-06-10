/*package com.integration.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.integration.common.AppConfig;
import com.integration.common.AppConstants;
import com.integration.exception.CustomException;
import com.integration.processor.CSV2XMLTransform;
import com.integration.processor.MessageProcessor;


@Component
public class CSVtoXMLRoute extends RouteBuilder {

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
    	 
   	 
    	 
    	 from("file:"+app.getInputCSV()+"?noop=true")
    	 .process(new CSV2XMLTransform())
    	 .to("file:"+app.getOutputLocation()+"?fileName=emp.xml");
    }

}*/