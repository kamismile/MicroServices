package com.cts.saga;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.saga.SagaEventHandler;
import org.axonframework.eventhandling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import com.cts.command.HotelBookOrCancelCommand;
import com.cts.event.HotelReserveEvent;
import com.cts.event.ReservationEvent;

@Saga
public class ReservationSAGA {

	@Autowired
	private transient CommandGateway commandGateway;

	private String iternaryId;
	private Boolean isHotelBooked = null;
	private Boolean isFlightBooked = null;
	private Boolean isCABBooked = null;

	private Boolean isAllDone() {
		return isCABBooked != null && isHotelBooked != null && isFlightBooked != null;
	}

	@StartSaga
	@SagaEventHandler(associationProperty = "iternaryId")
	public void on(HotelReserveEvent event) {
		iternaryId = event.getResevationBO().getIternaryId();
		// First Reserve The Hotel
		HotelBookOrCancelCommand h_command = new HotelBookOrCancelCommand();
		h_command.setIsBook(true);
		h_command.setReservationBO(event.getResevationBO());
		commandGateway.send(h_command);
	}

}
