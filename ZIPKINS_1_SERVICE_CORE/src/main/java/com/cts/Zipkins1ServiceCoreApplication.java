package com.cts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.autoconfig.TraceAutoConfiguration;
import org.springframework.cloud.sleuth.stream.SleuthStreamAutoConfiguration;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.config.ChannelBindingAutoConfiguration;
import org.springframework.cloud.stream.messaging.Sink;


@EnableDiscoveryClient
@SpringBootApplication
public class Zipkins1ServiceCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(Zipkins1ServiceCoreApplication.class, args);
	}
}
