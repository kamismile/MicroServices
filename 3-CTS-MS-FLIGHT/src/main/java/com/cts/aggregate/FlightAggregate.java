package com.cts.aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.apache.log4j.Logger;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.cts.bo.FlightReservationBO;
import com.cts.command.FlightBookOrCancelCommand;
import com.cts.event.FlightBookOrCancelEvent;
import com.cts.event.FlightReservationDoneEvent;
import com.cts.eventhandler.FlightBookOrCancelHandler;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class FlightAggregate {
	private static Logger log = Logger.getLogger(FlightAggregate.class);

	@AggregateIdentifier
	private String flightBookingReferenceNumber;

	@CommandHandler
	public FlightAggregate(FlightBookOrCancelCommand command) {		
		//log.info("***************Wake Up***********************");
		apply(new FlightBookOrCancelEvent((FlightReservationBO)command.getReservationBO()));
		apply(new FlightReservationDoneEvent((FlightReservationBO)command.getReservationBO()));// Notify
																			// the
																			// saga
																			// to
																			// move
																			// ahead
	}

	@EventSourcingHandler
	protected void on(FlightBookOrCancelEvent event) {
		
		this.flightBookingReferenceNumber = ((FlightReservationBO) event.getReservationBO())
				.getFlightBookingReferenceNumber();
		log.info("------FlightBookOrCancelEvent-----------");	

	}

	@EventSourcingHandler
	protected void on(FlightReservationDoneEvent event) {		
		this.flightBookingReferenceNumber = event.getReservationBO().getFlightBookingReferenceNumber();
		log.info("------FlightReservationDoneEvent-----------");	}

}
