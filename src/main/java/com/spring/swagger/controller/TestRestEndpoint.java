package com.spring.swagger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * This is a test controller to test the exposed api endpoint
 */
@RestController
@RequestMapping("/test")
public class TestRestEndpoint {

    @GetMapping("")
    Map<String, String> testIndex(){
        Map<String, String> result = new HashMap<>();
        result.put("Hello","test");
        return result;
    }
}
