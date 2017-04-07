package com.cts.event;

public abstract class BaseEvent {
	
	protected  String routingKey;

	public String getRoutingKey() {
		return routingKey;
	}

	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}
	
	

}
