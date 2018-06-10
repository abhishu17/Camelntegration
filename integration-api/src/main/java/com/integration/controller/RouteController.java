package com.integration.controller;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.integration.common.RouteManager;
import com.integration.model.Person;
import com.integration.model.RouteStatus;
import com.integration.service.ManagerService;
import com.integration.service.PersonService;

@RestController
@RequestMapping("/routes")
public class RouteController {

	@Autowired
	ManagerService ms;

	@Autowired
    private RouteManager camelContext;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Model model) {
      
        System.out.println("Dashboard");
        List<Route> routes = camelContext.getCamelContext().getRoutes();
        System.out.println("No "+ routes.size());
        List<RouteStatus> routeStatuses = new ArrayList<RouteStatus>();
        for (Route r : routes) {
            RouteStatus rs = new RouteStatus();
            rs.setId(r.getId());
            rs.setServiceStatus(camelContext.getCamelContext().getRouteStatus(r.getId()));
            routeStatuses.add(rs);
        }

        model.addAttribute("routeStatuses", routeStatuses);

        return "dashboard";
    }

    @RequestMapping(value = "/dashboard/{routeId}/start", method = RequestMethod.GET)
    public String startRoute(@PathVariable String routeId) {
        try {
        	camelContext.getCamelContext().startRoute(routeId);
            }
        catch (Exception e) {
            //LOG.error("failed to start camel context [" + camelContext + "]");
        }

        return "redirect:/dashboard";
     }

    @RequestMapping(value = "/dashboard/{routeId}/stop", method = RequestMethod.GET)
    public String stopRoute(@PathVariable String routeId) {
        try {
        	camelContext.getCamelContext().stopRoute(routeId);
            
        } catch (Exception e) {
           // LOG.error("failed to stop camel context [" + camelContext + "]");
        }
        return "redirect:/dashboard";
        }
  
}

