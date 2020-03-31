package com.itmayidu.ratelimit;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.stereotype.Component;

import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.RateLimitKeyGenerator;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties.Policy;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties.Policy.MatchType;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.config.properties.RateLimitProperties.Policy.Type;
import com.marcosbarbero.cloud.autoconfigure.zuul.ratelimit.support.RateLimitUtils;
@Component
public class KeyGenerator implements RateLimitKeyGenerator {
	
	private final RateLimitProperties properties;
    private final RateLimitUtils rateLimitUtils;
	
    public KeyGenerator(RateLimitProperties properties,RateLimitUtils rateLimitUtils){
    	this.properties = properties;
    	this.rateLimitUtils = rateLimitUtils;
    }
    
	@Override
	public String key(HttpServletRequest request, Route route, Policy policy) {

		final List<Type> types = policy.getType().stream().map(MatchType::getType).collect(Collectors.toList());
		//增加的matchers判断
		final List<String> matchers = policy.getType().stream().map(MatchType::getMatcher).collect(Collectors.toList());
		
        final StringJoiner joiner = new StringJoiner(":");
        joiner.add(properties.getKeyPrefix());
        if (route != null) {
            joiner.add(route.getId());
        }
        if (!types.isEmpty()) {
            if (types.contains(Type.URL) && route != null) {
                joiner.add(route.getPath());
            }
            if (types.contains(Type.ORIGIN)) {
                joiner.add(rateLimitUtils.getRemoteAddress(request));
            }
            if (types.contains(Type.USER)) {
                joiner.add(rateLimitUtils.getUser(request));
            }
        }
		//增加的matchers判断
        if (!matchers.isEmpty()) {
            //判断matchers里是否包含当前访问的url，如果包含，则追加当前的path
            //源码中就是因为少了这个判断，导致不同url生成的key一样
            if (matchers.contains(route.getPath()) && route != null) {
                joiner.add(route.getPath());
            }
            if (matchers.contains(rateLimitUtils.getRemoteAddress(request))) {
                joiner.add(rateLimitUtils.getRemoteAddress(request));
            }
            if (matchers.contains(rateLimitUtils.getUser(request))) {
                joiner.add(rateLimitUtils.getUser(request));
            }
        }
        return joiner.toString();
	}
}
