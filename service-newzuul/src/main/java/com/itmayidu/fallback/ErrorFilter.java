package com.itmayidu.fallback;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
 
/**
 * 网关过滤: 处理请求发生错误时被触发
 * @author Administrator
 *
 */
@Component
public class ErrorFilter extends ZuulFilter {
 
    private static Logger log = LoggerFactory.getLogger(ErrorFilter.class);
 
    @Override
    public String filterType() {
        //异常过滤器
        return "error";
    }
 
    @Override
    public int filterOrder() {
        //优先级，数字越大，优先级越低
        return 2;
    }
 
    @Override
    public boolean shouldFilter() {
        //是否执行该过滤器，true代表需要过滤
        return true;
    }
 
    @Override
    public Object run() {
		
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
    	log.info(String.format("ZUUL 过滤器:Error >>> %s:%s", request.getMethod(), request.getRequestURL().toString()));
    	
        ctx.setSendZuulResponse(false);
		ctx.setResponseStatusCode(-1);
		ctx.setResponseBody("{\"result\":\" error!\"}");// 返回错误内容
        log.info("ZUUL >>> 进入异常过滤器");
        return null;
 
    }
 
}