package com.qj.face.base;

import static java.lang.String.format;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.qj.face.entity.ZuulEntity;


public interface RequestZuulBase<T> {

	 ResponseEntity<Integer> requestZuulMap(String url ) throws Exception  ;
	
	 ResponseEntity<Integer> requestZuulT(String url ,T t) throws Exception  ;
	
	 List<T> requestZuulListT(String url) throws Exception  ;

	 List<T> requestZuulListTParamT(String url,T t) throws Exception  ;

	ResponseEntity<List>  requestZuulListTParamMap(String url) throws Exception  ;
}
