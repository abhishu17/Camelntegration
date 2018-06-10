/*package com.integration.route;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.integration.common.ExampleServices;
import com.integration.common.MyBean;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.model.rest.RestBindingMode;
//import javax.ws.rs.core.MediaType;
@Component
class RestApi extends RouteBuilder {

	@Value("${server.port}")
	String serverPort;
	    
	@Value("${baeldung.api.path}")
	String contextPath;
	
	
	 
    @Override
    public void configure() {

        CamelContext context = new DefaultCamelContext();

        
        // http://localhost:8080/camel/api-doc
        restConfiguration().contextPath(contextPath) //
            .port(serverPort)
            .enableCORS(true)
            .apiContextPath("/api-doc")
            .apiProperty("api.title", "Test REST API")
            .apiProperty("api.version", "v1")
            .apiProperty("cors", "true") // cross-site
            .apiContextRouteId("doc-api")
            .component("servlet")
            .bindingMode(RestBindingMode.json)
            .dataFormatProperty("prettyPrint", "true");
        
        
        rest("/api/").description("Teste REST Service")
            .id("api-route")
            .post("/bean")
           // .produces(MediaType.APPLICATION_JSON)
           // .consumes(MediaType.APPLICATION_JSON)
//            .get("/hello/{place}")
            .bindingMode(RestBindingMode.auto)
            .type(MyBean.class)
            .enableCORS(true)
//            .outType(OutBean.class)

            .to("direct:remoteService");
        
   
        from("direct:remoteService")
            .routeId("direct-route")
            .tracing()
            .log(">>> ${body.id}")
            .log(">>> ${body.name}")
            .transform().simple("blue ${in.body.name}")                
            .process(new Processor() {
                public void process(Exchange exchange) throws Exception {
                    MyBean bodyIn = (MyBean) exchange.getIn().getBody();
                    
                    ExampleServices.example(bodyIn);

                    exchange.getIn().setBody(bodyIn);
                    System.out.println("dddddddd");
                }
            })
            .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201));
    }
}
*/