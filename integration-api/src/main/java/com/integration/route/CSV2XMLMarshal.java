/*package com.integration.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.XStreamDataFormat;

import com.integration.common.Employee;
import com.integration.processor.CustomProcessorXStream;

import java.util.HashMap;
import java.util.Map;
public class CSV2XMLMarshal extends RouteBuilder{
    public void configure() throws Exception {
        from("direct:csvinput")
                .process(new CustomProcessorXStream())
                //.marshal().xstream()
                .marshal(populateStreamDef())
                .to("log:?level=INFO&showBody=true")
                .to("mock:output");
    }
    
    private XStreamDataFormat populateStreamDef() {
        XStreamDataFormat xstreamDefinition = new XStreamDataFormat();
        Map<String, String> aliases = new HashMap<String, String>();
        aliases.put("Employee", Employee.class.getName());
        xstreamDefinition.setAliases(aliases);
        return xstreamDefinition;
    }
}*/