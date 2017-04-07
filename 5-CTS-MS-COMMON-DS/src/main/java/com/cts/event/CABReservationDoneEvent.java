package com.cts.event;

import com.cts.bo.CABReservationBO;
import com.cts.common.Constants;


public class CABReservationDoneEvent extends BaseEvent{

	private CABReservationBO reservationBO;
	private String iternaryId;
	
	public CABReservationDoneEvent(CABReservationBO reservationBO) {
		this.reservationBO=reservationBO;
		this.iternaryId=reservationBO.getIternaryId();
		setRoutingKey(Constants.SAGA_KEY);
	}
	
	public CABReservationDoneEvent(){
		setRoutingKey(Constants.SAGA_KEY);
    }

	public CABReservationBO getReservationBO() {
		return reservationBO;
	}

	public void setReservationBO(CABReservationBO reservationBO) {
		this.reservationBO = reservationBO;
	}

	public String getIternaryId() {
		return iternaryId;
	}

	public void setIternaryId(String iternaryId) {
		this.iternaryId = iternaryId;
	}
     
	
}
