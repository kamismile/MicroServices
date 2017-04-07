package com.cts.event;

import com.cts.bo.ReservationBO;
import com.cts.common.Constants;


public class ReservationEvent extends BaseEvent{
	
	private String iternaryId;
	
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
		this.iternaryId=resevationBO.getIternaryId();
		setRoutingKey(Constants.SAGA_KEY);
	}
	
	
	public String getIternaryId() {
		return iternaryId;
	}

	public void setIternaryId(String iternaryId) {
		this.iternaryId = iternaryId;
	}

	public ReservationEvent(){
		setRoutingKey(Constants.SAGA_KEY);
		
	}
}
