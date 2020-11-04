package com.foxc.gateway.fallback;

import com.foxc.gateway.vo.JsonVO;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.ServerWebExchangeDecorator;

@Slf4j
@RestController
public class FoxcUserFallBack {


    @GetMapping(value = "/foxcUserFallBack")
    public JsonVO foxcUserFallBack(ServerWebExchange exchange){
        JsonVO jsonVO = new JsonVO();
        jsonVO.setCode(500);
        Exception exception = exchange.getAttribute(ServerWebExchangeUtils.HYSTRIX_EXECUTION_EXCEPTION_ATTR);
        ServerWebExchange delegate = ((ServerWebExchangeDecorator)exchange).getDelegate();

        log.error("调用服务path={}，rawPath={}，失败", delegate.getRequest().getURI().getPath(),delegate.getRequest().getURI().getRawPath(), exception);
        String exceptionMessage = "";
        if(exception instanceof HystrixTimeoutException){
            exceptionMessage = "调用服务超时";
        } else {
            exceptionMessage = exception.getMessage();
        }
        jsonVO.setMsg(String.format("%s服务不可用，请稍后再试。exception=%s", delegate.getRequest().getURI().getPath(), exceptionMessage));
        return jsonVO;
    }

}
