package com.cts.event;

import com.cts.bo.ReservationBO;

public class FlightBookOrCancelEvent extends BookOrCancelEvent {

	public FlightBookOrCancelEvent(ReservationBO reservationBO) {
		super(reservationBO);
	}

}
