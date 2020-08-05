package com.foxc.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;

/**
 * 该类为Feign配置类
 * 注意：该类不可以写@Configuration注解；如果加了，那么该类不能放在主应用程序上下文@ComponentScan扫描的包中
 */
public class FeignConfiguration {

    /**
     * 将企契约改为feign原生的默认契约。这样就可以使用feign自带的注解了。
     * @return 默认的feign契约
     */
    @Bean
    public Contract feignConTract(){
        return new Contract.Default();
    }
}
