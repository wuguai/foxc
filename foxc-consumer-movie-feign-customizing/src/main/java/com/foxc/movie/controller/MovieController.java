package com.foxc.movie.controller;

import com.alibaba.fastjson.JSONObject;
import com.foxc.movie.feign.UserFeignClient;
import com.foxc.movie.vo.JsonVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MovieController {

    private final UserFeignClient userFeignClient;

    @GetMapping(value = "/user/findById/{id}")
    public JsonVO findUserById(@PathVariable(name = "id") Integer id){
        JsonVO jsonVO = userFeignClient.findUserById(id);
        log.info("userFeignClient.findUserById=>{}", JSONObject.toJSONString(jsonVO));
        return jsonVO;
    }
}
