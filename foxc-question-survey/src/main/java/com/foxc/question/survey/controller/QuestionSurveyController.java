package com.foxc.question.survey.controller;

import com.foxc.question.survey.vo.JsonVO;
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
public class QuestionSurveyController {



    private final RestTemplate restTemplate;

    private final LoadBalancerClient loadBalancerClient;

    /*@GetMapping(value = "/hello/{name}")
    public JsonVO hello(@PathVariable(value = "name") String name){
        return this.restTemplate.getForObject("http://localhost:8802/hello/"+name, JsonVO.class);
    }*/

    @GetMapping(value = "/hello1/{name}")
    public JsonVO hello1(@PathVariable(value = "name") String name){
        return this.restTemplate.getForObject("http://foxc-data-tracert/hello/"+name, JsonVO.class);
    }

    @GetMapping(value = "/log-data-tracert-instance")
    public void logDataTracertInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("foxc-data-tracert");
        // 打印当前选择的是哪个节点
        log.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }
}
