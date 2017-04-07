package com.cts.axon;

import org.apache.log4j.Logger;
import org.axonframework.amqp.eventhandling.RoutingKeyResolver;
import org.axonframework.eventhandling.EventMessage;


import com.cts.event.BaseEvent;

public class CustomRoutingKeyResolver implements RoutingKeyResolver {
	
	private static Logger log = Logger.getLogger(CustomRoutingKeyResolver.class);

	@Override
	public String resolveRoutingKey(EventMessage<?> eventMessage) {
		// TODO Auto-generated method stub
		log.info("----------------------------------------------------");
		log.info(((BaseEvent) eventMessage.getPayload()).getRoutingKey());		
		log.info("----------------------------------------------------");
		return ((BaseEvent) eventMessage.getPayload()).getRoutingKey();
	}

}
