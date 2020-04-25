package com.example.springcloud_consumer;


import org.apache.dubbo.config.annotation.Reference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import test.HelloWordService;

@RestController
@RequestMapping("HelloWord")
public class HelloServiceController {

    Logger logger = LogManager.getLogger(HelloServiceController.class);

    @Reference
    HelloWordService helloWordServiceProvider;

    @RequestMapping(value = "/test", method = {RequestMethod.GET})
    public String test() {
        logger.info("this is consumer");
        return helloWordServiceProvider.hello("region");
    }

}
