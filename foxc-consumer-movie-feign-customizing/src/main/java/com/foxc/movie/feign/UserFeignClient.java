package com.foxc.movie.feign;

import com.foxc.config.FeignConfiguration;
import com.foxc.movie.vo.JsonVO;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 使用@FeignClient的configuration属性指定配置类，同时，将findUserById上的SpringMVC注解修改为Feign自带的注解
 */
@FeignClient(name = "foxc-provider-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {

//    @GetMapping(value = "/user/findById/{id}")
    @RequestLine(("GET /user/findById/{id}"))
    public JsonVO findUserById(@Param("id") Integer id);

}
