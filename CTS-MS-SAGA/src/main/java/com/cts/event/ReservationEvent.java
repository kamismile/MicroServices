package com.cts.event;

import com.cts.bo.ReservationBO;

public class ReservationEvent {
	
	private ReservationBO resevationBO;

	public ReservationBO getResevationBO() {
		return resevationBO;
	}

	public void setResevationBO(ReservationBO resevationBO) {
		this.resevationBO = resevationBO;
	}

	public ReservationEvent(ReservationBO resevationBO) {
		super();
		this.resevationBO = resevationBO;
	}
	
	public ReservationEvent(){
		
	}
}
