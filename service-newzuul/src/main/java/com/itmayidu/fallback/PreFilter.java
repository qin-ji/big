package com.itmayidu.fallback;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 网关过滤: 在请求之前触发
 * @author Administrator
 *
 */
@Component
public class PreFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(PreFilter.class);

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	public boolean shouldFilter() {
		return true;
	}

	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		System.out.println(request.getRemoteAddr());
		log.info(String.format("ZUUL 过滤器:Pre >>> %s:%s", request.getMethod(), request.getRequestURL().toString()));
		
//		ctx.setSendZuulResponse(false);
//		ctx.setResponseStatusCode(401);
		
		
//		Object accessToken = request.getParameter("token");
//		if (accessToken == null) {
//			log.warn("ZUUL >>> token is empty");
//			ctx.setSendZuulResponse(false);
//			ctx.setResponseStatusCode(401);
//			try {
//				ctx.getResponse().getWriter().write("token is empty");
//			} catch (Exception e) {
//			}
//		}
		
		return null;

	}
}
