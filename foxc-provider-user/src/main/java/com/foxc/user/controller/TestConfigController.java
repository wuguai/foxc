package com.foxc.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RereshScope - 每一次调用调用/refresh方法都会清除所有该类型的bean。下次使用时，就会重新创建，然后注入最新属性变量。
 * @author 41990
 */
@RestController
@RefreshScope
public class TestConfigController {

    @Value("${from}")
    private String from;

    @GetMapping("/from")
    public String from() {
        return this.from;
    }

}
