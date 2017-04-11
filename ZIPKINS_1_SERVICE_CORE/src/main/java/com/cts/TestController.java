package com.cts;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test")
public class TestController {
	private static Logger log = Logger.getLogger(TestController.class);
	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> getInfo() {
		HashMap<String, String> allInfo = new HashMap<>();
		allInfo.put("info".toUpperCase(), "INFORMATION COMING FROM CORE ZIPKIN SERVICE");
		log.info("INFORMATION COMING FROM CORE ZIPKIN SERVICE");
		return new ResponseEntity<HashMap<String, String>>(allInfo, HttpStatus.OK);
	}
}
