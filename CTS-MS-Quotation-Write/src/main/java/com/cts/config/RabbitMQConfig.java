package com.cts.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Bean
	public Exchange exchange() {
		return ExchangeBuilder.fanoutExchange("FDC-QUOTATION-EXCHANGE").build();
	}

	@Bean
	public Queue queue() {
		return QueueBuilder.durable("FDC-QUOTATION-QUEUE").build();
	}

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with("*").noargs();
	}

	@Autowired
	public void configure(AmqpAdmin admin) {		
		admin.declareExchange(exchange());
		admin.declareQueue(queue());
		admin.declareBinding(binding());
	}
	
}
