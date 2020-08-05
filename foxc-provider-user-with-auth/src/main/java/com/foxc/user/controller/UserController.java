package com.foxc.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.foxc.user.vo.JsonVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    @GetMapping(value = "/user/findById/{id}")
    public JsonVO findUserById(@PathVariable(value = "id") Integer id){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            UserDetails user = (UserDetails)principal;
            Collection<? extends GrantedAuthority> collection = user.getAuthorities();
            collection.stream().forEach(c ->{
                log.info("当前用户是{}，角色是{}",user.getUsername(),c.getAuthority());
            });
        }
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
