package com.foxc.movie.controller;

import com.foxc.movie.vo.JsonVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MovieController {

    private final RestTemplate restTemplate;

    private final LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/user/findById/{id}")
    public JsonVO findUserById(@PathVariable(name = "id") Integer id){
        JsonVO jsonVO = restTemplate.getForObject("http://localhost:8001/user/findById/" + id, JsonVO.class);
        log.info("restTemplate.getForObject.findUserById=>{}", jsonVO);
        return jsonVO;
    }

    @GetMapping(value = "/user/findById2/{id}")
    public JsonVO findUserById2(@PathVariable(name = "id") Integer id){
        JsonVO jsonVO = restTemplate.getForObject("http://foxc-provider-user/user/findById/" + id, JsonVO.class);
        log.info("restTemplate.getForObject.findUserById=>{}", jsonVO);
        return jsonVO;
    }

    @GetMapping("/log-user-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("foxc-provider-user");
        // 打印当前选择的是哪个节点
        log.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }
}
