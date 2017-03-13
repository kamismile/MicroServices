package com.cts.event;

import com.cts.bo.ReservationBO;

public class ReservationDoneEvent extends ReservationEvent {
	
	public ReservationDoneEvent(ReservationBO resevationBO){
		super(resevationBO);
	}

}
