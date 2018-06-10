package com.integration.service;

import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Route;
import org.apache.camel.main.Main;
import org.apache.camel.main.MainListenerSupport;
import org.apache.camel.main.MainSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.integration.common.AppConfig;
import com.integration.route.CopyFileRouter;


@Component
public class ManagerService {

	
	@Autowired
	private ApplicationContext context;
	
	 private CopyFileRouter app;	
	  
	    @Autowired
	    public void setApp(CopyFileRouter app) {
	        this.app = app;
	    }
	
	
	  public String getVersion()
	  {
		  String version ="1.0";
		  
		  return version;
		  
	  }
	  
	  private Main main;

	  
	  public void information() throws Exception {	  
		    
	        System.out.println("create a Main instance");
	        
	       
	        System.out.println("Application name "+context.getApplicationName() +
	        		"Display name"+ context.getDisplayName()+
	        		
	        		"Display ID"+ context.getId());
	        
	       
	        main = new Main();
	        CamelContext  ctx1 = (CamelContext) context.getBean("camelContext ");
	        
	        System.out.println("Contxt "+ ctx1.getName());
        	List<Route> rotes = ctx1.getRoutes();
        	for(Route r:rotes)
        	{
        		System.out.println("Route "+ r.getId() + r.getClass() + r.getDescription());
        		
        	}
        	
	        List<CamelContext> ctx = main.getCamelContexts();
	        for(CamelContext cf: ctx)
	        {
	        	System.out.println("Contxt "+ cf.getName());
	        	List<Route> rotes1 = cf.getRoutes();
	        	for(Route r:rotes1)
	        	{
	        		System.out.println("Route "+ r.getId() + r.getClass() + r.getDescription());
	        		
	        	}
	        }
	        
	    }
	
	    public void boot() throws Exception {	    	
	        System.out.println("create a Main instance");
	        main = new Main();
	        
	        List<CamelContext> ctx = main.getCamelContexts();
	        for(CamelContext cf: ctx)
	        {
	        	System.out.println("Contxt "+ cf.getName());
	        	List<Route> rotes = cf.getRoutes();
	        	for(Route r:rotes)
	        	{
	        		System.out.println("Route "+ r.getId() + r.getClass() + r.getDescription());
	        		
	        	}
	        }
	        System.out.println("bind MyBean into the registry");
	        main.bind("foo", new MyBean());
	        System.out.println("add routes");
	       // main.addRouteBuilder(app);
	        System.out.println("add event listener");
	        main.addMainListener(new Events());
	        System.out.println("set the properties from a file");
	       // main.setPropertyPlaceholderLocations("example.properties");
	        // run until you terminate the JVM
	        System.out.println("Starting Camel. Use ctrl + c to terminate the JVM.\n");
	        main.run();	  
	    }
	    
	    public void shutdown() throws Exception {	    	
	        System.out.println("create a Main instance");
	        main = new Main();
	        System.out.println("bind MyBean into the registry");
	        main.bind("foo", new MyBean());
	        System.out.println("add routes");
	        //main.addRouteBuilder(app);
	        System.out.println("add event listener");
	        main.addMainListener(new Events());
	        System.out.println("set the properties from a file");
	       // main.setPropertyPlaceholderLocations("example.properties");
	        // run until you terminate the JVM
	        System.out.println("Starting Camel. Use ctrl + c to terminate the JVM.\n");
	        main.run();	  
	    }

	      public static class MyBean {
	        public void callMe() {
	            System.out.println("MyBean.callMe method has been called");
	        }
	    }

	    public static class Events extends MainListenerSupport {

	        @Override
	        public void afterStart(MainSupport main) {
	            System.out.println("MainExample with Camel is now started!");
	        }

	        @Override
	        public void beforeStop(MainSupport main) {
	            System.out.println("MainExample with Camel is now being stopped!");
	        }
	    }
}
