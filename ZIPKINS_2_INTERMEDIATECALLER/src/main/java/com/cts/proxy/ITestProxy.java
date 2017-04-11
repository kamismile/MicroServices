package com.cts.proxy;

import java.util.HashMap;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@FeignClient("ZIPKIN-CORE-SERVICE")
public interface ITestProxy {
	@RequestMapping(value = "/test/info", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<HashMap<String, String>> getInfo();

}
