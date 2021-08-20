package com.spring.swagger.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskDiscoveryClient {
    @Autowired
    private DiscoveryClient discoveryClient;

    public ResponseEntity<List<ServiceInstance>> serviceInstanceByApplication(){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("taskService");
        if (serviceInstances.isEmpty()){
            return null;
        }
        return ResponseEntity.ok(serviceInstances);
    }
}
