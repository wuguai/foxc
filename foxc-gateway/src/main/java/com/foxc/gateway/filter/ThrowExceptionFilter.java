package com.foxc.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ThrowExceptionFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        log.info("This is a pre filter, it will throw a RunTimeException");
        RequestContext ctx = RequestContext.getCurrentContext();
        // doSomeThing();
        return null;
    }

    private void doSomeThing() {
        throw new RuntimeException("Exist some errors...");
    }
}
