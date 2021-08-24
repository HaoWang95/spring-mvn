package com.spring.swagger.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TaskDiscoveryClient {
    @Autowired
    private EurekaDiscoveryClient client;

    public ResponseEntity<List<ServiceInstance>> serviceInstanceByApplication(){
        List<ServiceInstance> serviceInstances = client.getInstances("taskService");
        if (serviceInstances.isEmpty()){
            return null;
        }
        return ResponseEntity.ok(serviceInstances);
    }
}
