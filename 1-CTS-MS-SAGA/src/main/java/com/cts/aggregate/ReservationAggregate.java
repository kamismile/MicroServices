package com.cts.aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

import org.apache.log4j.Logger;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.cts.command.ReserveCommand;
import com.cts.event.ReservationEvent;

import lombok.NoArgsConstructor;

@Aggregate
@NoArgsConstructor
public class ReservationAggregate {
	private static Logger log = Logger.getLogger(ReservationAggregate.class);
	@AggregateIdentifier
	private String iternaryId;

	@CommandHandler
	public ReservationAggregate(ReserveCommand reserveCommand) {
		log.debug("--------------------Knock Knock!!! Garfield wants to go for a vacation----------------------------");
		apply(new ReservationEvent(reserveCommand.getReservationBO()));
	}

	@EventSourcingHandler
	protected void on(ReservationEvent event) {
		this.iternaryId = event.getResevationBO().getIternaryId();
	}

}
