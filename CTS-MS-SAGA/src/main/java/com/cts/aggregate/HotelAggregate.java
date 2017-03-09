package com.cts.aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.cts.bo.HotelReservationBO;
import com.cts.command.HotelBookOrCancelCommand;
import com.cts.event.HotelBookOrCancelEvent;

@Aggregate
public class HotelAggregate {

	@AggregateIdentifier
	private String reservationId;

	@CommandHandler
	public void on(HotelBookOrCancelCommand h_command) {
		HotelBookOrCancelEvent h_event = new HotelBookOrCancelEvent();
		h_event.setIsBook(h_command.getIsBook());
		h_event.setReservationBO(h_command.getReservationBO());
		apply(h_event);
	}

	@EventSourcingHandler
	protected void on(HotelBookOrCancelEvent h_event) {
		this.reservationId = ((HotelReservationBO) h_event.getReservationBO()).getReservationId();
	}

}
