package com.cts.event;

import com.cts.bo.ReservationBO;

public class CABBookOrCancelEvent extends BookOrCancelEvent {

	public CABBookOrCancelEvent(ReservationBO reservationBO) {
		super(reservationBO);
	}

}
