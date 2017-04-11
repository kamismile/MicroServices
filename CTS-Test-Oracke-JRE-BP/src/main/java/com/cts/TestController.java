package com.cts;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/information")
public class TestController {

	@RequestMapping(value = "/showinfo", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> getInfo() {
		HashMap<String, String> allInfo = new HashMap<>();
		allInfo.put("java.vm.vendor".toUpperCase(), System.getProperty("java.vm.vendor"));
		allInfo.put("java.vm.version".toUpperCase(), System.getProperty("java.vm.version"));
		allInfo.put("java.vm.name".toUpperCase(), System.getProperty("java.vm.name"));
		return new ResponseEntity<HashMap<String, String>>(allInfo, HttpStatus.OK);
	}

}
