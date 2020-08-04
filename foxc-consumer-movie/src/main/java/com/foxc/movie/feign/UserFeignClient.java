package com.foxc.movie.feign;

import com.foxc.movie.vo.JsonVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "foxc-provider-user")
public interface UserFeignClient {

    @GetMapping(value = "/user/findById/{id}")
    public JsonVO findUserById(@PathVariable(name = "id") Integer id);

}
