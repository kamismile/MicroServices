package com.cts.aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.apache.log4j.Logger;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.cts.bo.CABReservationBO;
import com.cts.command.CABBookOrCancelCommand;
import com.cts.event.CABBookOrCancelEvent;
import com.cts.event.CABReservationDoneEvent;

import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class CABAggregate {
	
	private static Logger log = Logger.getLogger(CABAggregate.class);
	
	@AggregateIdentifier
	private String cabBookingReferenceNumber;
	
	@CommandHandler
	public CABAggregate(CABBookOrCancelCommand command) {
		log.debug("-------------------------------You are all set Garfiedl! I will book your CAB---------------------------------------");
		apply(new CABBookOrCancelEvent((CABReservationBO)command.getReservationBO()));
		apply(new CABReservationDoneEvent((CABReservationBO)command.getReservationBO()));// Notify
																			// the
																			// saga
																			// to
																			// move
																			// ahead
	}

	@EventSourcingHandler
	protected void on(CABBookOrCancelEvent event) {
		this.cabBookingReferenceNumber = ((CABReservationBO) event.getReservationBO())
				.getReservationId();

	}

	@EventSourcingHandler
	protected void on(CABReservationDoneEvent event) {
		this.cabBookingReferenceNumber = event.getReservationBO().getReservationId();

	}

}
