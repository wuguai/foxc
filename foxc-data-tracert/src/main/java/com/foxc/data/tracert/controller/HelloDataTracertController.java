package com.foxc.data.tracert.controller;

import com.foxc.data.tracert.controller.vo.JsonVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloDataTracertController {

    @GetMapping("/hello/{name}")
    @ResponseBody
    public JsonVO helloFoxc(@PathVariable(value = "name") String name){
        JsonVO jsonVO = new JsonVO();
        jsonVO.setCode(200);
        jsonVO.setMsg(String.format("hello foxc %s", name));
        return jsonVO;
    }

}
