package com.integration.common;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.springframework.stereotype.Service;

@Service
public class RouteManager implements CamelContextAware { 

protected CamelContext camelContext;

public CamelContext getCamelContext() {
 return camelContext;
}

public void setCamelContext(CamelContext camelContext) {
 this.camelContext = camelContext;
}
}