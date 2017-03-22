package com.cts.config;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.distributed.AnnotationRoutingStrategy;
import org.axonframework.commandhandling.distributed.CommandBusConnector;
import org.axonframework.commandhandling.distributed.CommandRouter;
import org.axonframework.commandhandling.distributed.DistributedCommandBus;
import org.axonframework.serialization.Serializer;
import org.axonframework.springcloud.commandhandling.SpringCloudCommandRouter;
import org.axonframework.springcloud.commandhandling.SpringHttpCommandBusConnector;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AxonCommandBusConfig {

	/*
	 * @Autowired
	 * 
	 * @Qualifier("distributedCommandBus") private CommandBus
	 * distributedCommandBus;
	 * 
	 * 
	 * @Bean("commandGateway") public CommandGatewayFactoryBean
	 * commandGateway(){
	 * 
	 * CommandGatewayFactoryBean commandGatewayFactoryBean=new
	 * CommandGatewayFactoryBean<>();
	 * commandGatewayFactoryBean.setCommandBus(distributedCommandBus); return
	 * new CommandGatewayFactoryBean(); }
	 */
	@Bean
	public CommandRouter springCloudCommandRouter(DiscoveryClient discoveryClient) {
		return new SpringCloudCommandRouter(discoveryClient, new AnnotationRoutingStrategy());
	}

	@Bean
	public CommandBusConnector springHttpCommandBusConnector(@Qualifier("localSegment") CommandBus localSegment,
			RestTemplate restTemplate, Serializer serializer) {

		return new SpringHttpCommandBusConnector(localSegment, restTemplate, serializer);
	}

	
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
	
	@Primary // to make sure this CommandBus implementation is used for
				// autowiring
	@Bean
	public DistributedCommandBus springCloudDistributedCommandBus(CommandRouter commandRouter,
			CommandBusConnector commandBusConnector) {
		return new DistributedCommandBus(commandRouter, commandBusConnector);
	}

}
