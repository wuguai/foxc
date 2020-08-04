package com.foxc.user.controller;

import com.foxc.user.vo.JsonVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
        return jsonVO;
    }

}
