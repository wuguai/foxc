package com.foxc.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.foxc.user.vo.JsonVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @GetMapping("/user/list")
    public JsonVO getUserList() throws InterruptedException {
        List<Map> userList = new ArrayList<>();
        Map<String,Object> user = new HashMap<>();
        user.put("userId",1001);
        user.put("userName", "张三");
        user.put("age", 12);
        userList.add(user);
        JsonVO jsonVO = new JsonVO();
        jsonVO.put("userList", userList);
        log.info("foxc-provide-user->/user/list/,userList=>{}", JSONObject.toJSONString(jsonVO));
        Thread.sleep(6000);
        // 不要期待在gateway中捕捉后端服务的异常
        // System.out.println(1/0);
        log.info("foxc-provide-user->/user/list/ end...");
        return jsonVO;
    }

}
