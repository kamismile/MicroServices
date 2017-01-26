package com.cts.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bo.TestBO;

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
	@ApiOperation(value = "View Something the Specific info of the product")
	@RequestMapping(value = "/showname", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> showName() {
		TestBO test = new TestBO();
		test.setId(UUID.randomUUID().toString());
		test.setName(testName);
		return new ResponseEntity<TestBO>(test, HttpStatus.FOUND);
	}
}
