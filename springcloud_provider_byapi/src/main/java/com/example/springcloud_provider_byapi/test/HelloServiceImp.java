package com.example.springcloud_provider_byapi.test;

import com.example.springcloud_provider_byapi.register.DomainServiceRegister;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import test.HelloWordService;

@Service
public class HelloServiceImp implements HelloWordService {

    final private Log logger = LogFactory.getLog(DomainServiceRegister.class);

    @Override
    public String hello(String name) {
        logger.info("api regist call service");
        return "hello "+name + " this is provider by api";
    }
}
