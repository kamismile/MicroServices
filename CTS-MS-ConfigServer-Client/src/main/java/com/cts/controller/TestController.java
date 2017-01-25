package com.cts.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RefreshScope
@RestController
@Api(value = "TestAPI", description = "Operations pertaining to Online Store")
@RequestMapping("/test")
public class TestController {

	@Value("${test-word}")
	private String testName;

	@CrossOrigin
	@ApiOperation(value = "View the Specific info of the product")
	@RequestMapping(value = "/showname", method = RequestMethod.GET)
	public String showName() {
		return "The Name is " + testName;
	}
}
