package com.cts.event;

import com.cts.bo.ReservationBO;

public class HotelBookOrCancelEvent extends BookOrCancelEvent {

	public HotelBookOrCancelEvent(ReservationBO reservationBO) {
		super(reservationBO);
	}

}
