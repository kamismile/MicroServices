package com.cts.eventhandler;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.cts.bo.FlightReservationBO;
import com.cts.event.FlightBookOrCancelEvent;

@ProcessingGroup("FlightBookOrCancel")
@Component("springManagedFlightBookOrCancelHandler")
public class FlightBookOrCancelHandler {
	
	@EventHandler
	public void on(FlightBookOrCancelEvent item) {
		FlightReservationBO flightReservationBO = (FlightReservationBO) item.getReservationBO();
		System.out.println("The Flight Is Booked: " + flightReservationBO);
	}

}
