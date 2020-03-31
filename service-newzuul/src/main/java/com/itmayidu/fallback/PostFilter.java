package com.itmayidu.fallback;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.route.RibbonCommandContext;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

/**
 * 网关过滤: 在Error和Route之后触发
 * 
 * @author Administrator
 *
 */
@Component
public class PostFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PostFilter.class);

	@Override
	public String filterType() {
		// 异常过滤器
		return "route";
	}

	@Override
	public int filterOrder() {
		// 优先级，数字越大，优先级越低
		return 3;
	}

	@Override
	public boolean shouldFilter() {
		// 是否执行该过滤器，true代表需要过滤
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info(String.format("ZUUL 过滤器:Post >>> %s:%s", request.getMethod(), request.getRequestURL().toString()));
		if (ctx.containsKey("error.status_code")) {
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(404);
			ctx.setResponseBody("{\"result\":\"  request error-404!\"}");// 返回错误内容
			ctx.set("isSuccess", false);
			return ctx;
		}
		return null;

	}

}