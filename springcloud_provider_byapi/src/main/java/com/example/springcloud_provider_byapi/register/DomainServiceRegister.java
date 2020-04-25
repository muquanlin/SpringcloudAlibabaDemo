package com.example.springcloud_provider_byapi.register;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import test.HelloWordService;

import javax.annotation.PostConstruct;


@Service
public class DomainServiceRegister {

    final private Log logger = LogFactory.getLog(DomainServiceRegister.class);

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${nacos.server.address}")
    private String nacosAddress;

    @Value("${protocol.name}")
    private String protocolName;

    @Autowired
    private HelloWordService helloWordServiceImp;

    @PostConstruct
    public void registDomainService(){
        logger.info("注册服务");
        //IUnitConversionService ius = unitConversionService;
        ApplicationConfig application = new ApplicationConfig();
        application.setName(applicationName);
        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress(nacosAddress);
        // 服务提供者协议配置
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName(protocolName);
        protocol.setPort(-1);
        protocol.setThreads(200);
        // 服务提供者暴露服务配置
        ServiceConfig<HelloWordService> service = new ServiceConfig<>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        service.setApplication(application);
        service.setRegistry(registry); // 多个注册中心可以用setRegistries()
        service.setProtocol(protocol); // 多个协议可以用setProtocols()
        service.setInterface(HelloWordService.class);
        service.setRef(helloWordServiceImp);
        service.setVersion("1.0.0");
        // 暴露及注册服务
        service.export();
    }

}
