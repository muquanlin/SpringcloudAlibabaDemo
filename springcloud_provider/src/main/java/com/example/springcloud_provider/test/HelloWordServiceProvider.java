package com.example.springcloud_provider.test;

import org.apache.dubbo.config.annotation.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import test.HelloWordService;

@Service
public class HelloWordServiceProvider implements HelloWordService {

    Logger logger = LogManager.getLogger(HelloWordServiceProvider.class);

    @Override
    public String hello(String name) {
        logger.info("this is provider");
        return "Hello "+ name + " this is provider";
    }
}
