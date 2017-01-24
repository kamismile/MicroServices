package com.cts.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Value("${test-word}")
	private String testName;
	
	
	@RequestMapping("/showname")
	public String showName(){
		return "The Name is "+testName;
	}

}
