package com.cts.event;

import com.cts.bo.ReservationBO;

public class HotelReservationDoneEvent extends ReservationDoneEvent {

	public HotelReservationDoneEvent(ReservationBO reservationBO) {
		super(reservationBO);
	}

}
