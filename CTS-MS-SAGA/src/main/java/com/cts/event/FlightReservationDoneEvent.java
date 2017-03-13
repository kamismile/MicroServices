package com.cts.event;

import com.cts.bo.ReservationBO;

public class FlightReservationDoneEvent extends ReservationDoneEvent {

	public FlightReservationDoneEvent(ReservationBO reservationBO) {
		super(reservationBO);
	}

}
