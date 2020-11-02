package com.foxc.fallback;

import com.foxc.vo.JsonVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoxcUserFallBack {


    @GetMapping(value = "/foxcUserFallBack")
    public JsonVO foxcUserFallBack(){
        JsonVO jsonVO = new JsonVO();
        jsonVO.setCode(500);
        jsonVO.setMsg(String.format("%s服务不可用，请稍后再试。", "foxc-provider-user-route"));
        return jsonVO;
    }

}
