package com.cts.aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.cts.bo.FlightReservationBO;
import com.cts.command.FlightBookOrCancelCommand;
import com.cts.event.FlightBookOrCancelEvent;
import com.cts.event.FlightReservationDoneEvent;

@Aggregate
public class FlightAggregate {

	@AggregateIdentifier
	private String flightBookingReferenceNumber;

	@CommandHandler
	public FlightAggregate(FlightBookOrCancelCommand command) {
		apply(new FlightBookOrCancelEvent(command.getReservationBO()));
		apply(new FlightReservationDoneEvent(command.getReservationBO()));// Notify
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

	}

	@EventSourcingHandler
	protected void on(FlightReservationDoneEvent event) {
		this.flightBookingReferenceNumber = ((FlightReservationBO) event.getResevationBO())
				.getFlightBookingReferenceNumber();

	}

}
