package com.foxc.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.foxc.user.vo.JsonVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    @GetMapping(value = "/user/findById/{id}")
    public JsonVO findUserById(@PathVariable(value = "id") Integer id){
        Map<String,Object> user = new HashMap<>();
        user.put("userId",id);
        user.put("userName", "张三");
        user.put("age", 12);
        JsonVO jsonVO = new JsonVO();
        jsonVO.put("user", user);
        log.info("foxc-provide-user->/user/findById/{},user=>{}",id, JSONObject.toJSONString(jsonVO));
        return jsonVO;
    }

}
