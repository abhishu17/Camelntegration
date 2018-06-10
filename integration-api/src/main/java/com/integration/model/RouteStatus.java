package com.integration.model;

import org.apache.camel.ServiceStatus;

public class RouteStatus {
    private String id;
    private ServiceStatus serviceStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(ServiceStatus serviceStatus) {
        this.serviceStatus = serviceStatus;
    }
}