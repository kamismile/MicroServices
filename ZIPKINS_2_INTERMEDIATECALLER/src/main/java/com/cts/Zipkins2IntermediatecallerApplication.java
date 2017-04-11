package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Zipkins2IntermediatecallerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Zipkins2IntermediatecallerApplication.class, args);
	}
}
