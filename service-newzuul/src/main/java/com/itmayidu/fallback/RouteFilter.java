package com.itmayidu.fallback;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
 
/**
 * 网关过滤: 处理请求时触发
 * @author Administrator
 *
 */
@Component
public class RouteFilter extends ZuulFilter {
 
    private static Logger log = LoggerFactory.getLogger(RouteFilter.class);
 
    @Override
    public String filterType() {
        return "route";
    }
 
    @Override
    public int filterOrder() {
        //优先级，数字越大，优先级越低
        return 1;
    }
 
    @Override
    public boolean shouldFilter() {
        //是否执行该过滤器，true代表需要过滤
        return true;
    }
 
    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
//    	System.out.println(ctx.getThrowable().getMessage());
    	HttpServletRequest request = ctx.getRequest();
    	log.info(String.format("ZUUL 过滤器:Route >>> %s:%s", request.getMethod(), request.getRequestURL().toString()));
//        ctx.setSendZuulResponse(false);// 过滤该请求，不对其进行路由
//        ctx.setResponseStatusCode(404);// 返回错误码
//        ctx.setResponseBody("{\"result\":\" is not this request!\"}");// 返回错误内容
//        ctx.set("isSuccess", false);
        return null;
 
    }
 
}