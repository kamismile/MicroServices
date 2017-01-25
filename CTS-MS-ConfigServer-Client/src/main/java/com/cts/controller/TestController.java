package com.cts.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {
	
	@Value("${test-word}")
	private String testName;
	
	
	@CrossOrigin
	@RequestMapping("/showname")
	public String showName(){
		return "The Name is "+testName;
	}

}
