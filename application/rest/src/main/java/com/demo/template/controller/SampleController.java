package com.demo.template.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class SampleController {

    @Value("${sample.config.planet:World!}")
    private String planet;

    @Value("${spring.cloud.config.uri:Default}")
    private String source;

    protected Logger logger = Logger.getLogger(SampleController.class
            .getName());

    public SampleController() {
    }

    @RequestMapping("/hello")
    public String hello() {
        return "Hello " + planet + " from " + source;
    }

}
