import com.example.clevertalk.api.common.IUnitConversionService;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;

public class TestHelloWord {
    public static void main(String[] ags){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("springcloud_provider");
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("nacos://10.43.16.238:8848");
        ReferenceConfig<IUnitConversionService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setInterface(IUnitConversionService.class);
        applicationConfig.setRegistry(registryConfig);
        referenceConfig.setApplication(applicationConfig);
        //referenceConfig.setGeneric(true);
        referenceConfig.setVersion("1.0.0");
        //referenceConfig.setCheck(false);
        referenceConfig.setAsync(true);
        referenceConfig.setTimeout(8000);
        IUnitConversionService iUnitConversionService = referenceConfig.get();
        System.out.println(iUnitConversionService);
       // return iUnitConversionService;
    }
}
