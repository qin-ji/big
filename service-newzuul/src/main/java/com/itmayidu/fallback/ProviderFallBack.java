package com.itmayidu.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.itmayidu.base.CustomRouteLocator;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义Zuul回退机制处理器。
 */
@Slf4j
@Component
public class ProviderFallBack   implements ZuulFallbackProvider{
    //指定要处理的 service。
    @Override
    public String getRoute() {
//        api服务id，如果需要所有调用都支持回退，则return "*"或return null
        return "service-order-feign";
    }
    /**
     * 如果请求用户服务失败，返回什么信息给消费者客户端 ,降级操作
     */
	@Override
	public ClientHttpResponse fallbackResponse() {
		 return new ClientHttpResponse() {
	            /**
	             * 网关向api服务请求是失败了，但是消费者客户端向网关发起的请求是OK的，
	             * 不应该把api的404,500等问题抛给客户端
	             * 网关和api服务集群对于客户端来说是黑盒子
	             */
	            @Override
	            public HttpStatus getStatusCode() throws IOException {
	                return HttpStatus.OK;
	            }
	 
	 
	            @Override
	            public int getRawStatusCode() throws IOException {
	                return 200;
	            }
	 
	            @Override
	            public String getStatusText() throws IOException {
	                return "ok";
	            }
	 
	            @Override
	            public void close() {
	            		
	            }
	 
	            @SuppressWarnings({ "unchecked", "rawtypes" })
				@Override
	            public InputStream getBody() throws IOException {
	                log.info("ZUUL >>> 请求错误 getBody() ");
	                Map r = new HashMap();
	                r.put("state", "9999");
	                r.put("msg", "系统错误，请求失败");
	                //返回异常信息
	                return new ByteArrayInputStream(JSONObject.toJSONString(r).getBytes("UTF-8"));
	 
	            }
	 
	            @Override
	            public HttpHeaders getHeaders() {
	            	 HttpHeaders headers = new HttpHeaders();
	                 MediaType mt = new MediaType("application", "json", Charset.forName("UTF-8"));
	                 headers.setContentType(mt);
	                 return headers;
	            }
	        };
	}
 
}
