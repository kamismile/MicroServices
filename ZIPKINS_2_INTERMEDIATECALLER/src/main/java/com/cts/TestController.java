package com.cts;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cts.proxy.ITestProxy;

@RestController
@RequestMapping("/")
public class TestController {

	@Autowired
	private ITestProxy proxy;
	private static Logger log = Logger.getLogger(TestController.class);

	@RequestMapping(value = "/information", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> getInfo() {
		log.info("INFORMATION COMING FROM CORE ZIPKIN CLIENT SERVICE");
		return proxy.getInfo();
	}
}
