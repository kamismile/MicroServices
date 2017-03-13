package com.cts.event;

import com.cts.bo.ReservationBO;

public class CABReservationDoneEvent extends ReservationDoneEvent {

	public CABReservationDoneEvent(ReservationBO reservationBO) {
		super(reservationBO);
	}

}
