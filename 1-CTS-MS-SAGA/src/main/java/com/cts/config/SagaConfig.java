package com.cts.config;

import org.axonframework.amqp.eventhandling.spring.SpringAMQPMessageSource;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.eventhandling.EventProcessor;
import org.axonframework.eventhandling.SubscribingEventProcessor;
import org.axonframework.eventhandling.saga.AbstractSagaManager;
import org.axonframework.eventhandling.saga.AnnotatedSagaManager;
import org.axonframework.eventhandling.saga.ResourceInjector;
import org.axonframework.eventhandling.saga.SagaRepository;
import org.axonframework.eventhandling.saga.repository.AnnotatedSagaRepository;
import org.axonframework.eventhandling.saga.repository.SagaStore;
import org.axonframework.messaging.interceptors.TransactionManagingInterceptor;
import org.axonframework.spring.messaging.unitofwork.SpringTransactionManager;
import org.axonframework.spring.saga.SpringResourceInjector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.cts.saga.ReservationSAGA;

@Configuration
public class SagaConfig {

	@Autowired
	@Qualifier("springManagedReadSAGAQueue")
	private SpringAMQPMessageSource eventStore;

	@Autowired
	private SagaStore<Object> sagaStore;
	
	
	@Autowired
	SpringTransactionManager transactionManager;
	
	

	@Bean
	public ResourceInjector resourceInjector() {
		return new SpringResourceInjector();
	}

	@Bean
	public AbstractSagaManager<ReservationSAGA> reservationSagaManager() {
		return new AnnotatedSagaManager<>(ReservationSAGA.class, reservationSAGARepository());
	}

	@Bean
	public SagaRepository<ReservationSAGA> reservationSAGARepository() {
		// TODO Auto-generated method stub
		return new AnnotatedSagaRepository<>(ReservationSAGA.class, sagaStore, resourceInjector());
	}
	
	
	@Bean
	public EventProcessor reservationSagaEventProcessor() {
		SubscribingEventProcessor eventProcessor = new SubscribingEventProcessor("reservationSagaEventProcessor",
				reservationSagaManager(), eventStore);
		eventProcessor.registerInterceptor(new TransactionManagingInterceptor<>(transactionManager));
		eventProcessor.start();
		return eventProcessor;
	}
	
	

}
