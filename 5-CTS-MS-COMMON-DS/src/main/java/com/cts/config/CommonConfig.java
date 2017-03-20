package com.cts.config;

import org.axonframework.amqp.eventhandling.RoutingKeyResolver;
import org.axonframework.serialization.xml.XStreamSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cts.axon.CustomRoutingKeyResolver;

@Configuration
public class CommonConfig {
	
	@Bean(name="routingKeyResolver")
    public RoutingKeyResolver routingKeyResolver() {
        return new CustomRoutingKeyResolver();
    }
	

	
	@Bean(name="serializer")
	public XStreamSerializer serializer()
	{
		return new XStreamSerializer();
	}

}
