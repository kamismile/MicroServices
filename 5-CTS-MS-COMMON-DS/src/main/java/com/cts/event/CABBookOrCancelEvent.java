package com.cts.event;

import com.cts.bo.CABReservationBO;
import com.cts.common.Constants;


public class CABBookOrCancelEvent extends BaseEvent{

	private CABReservationBO reservationBO;
	private String iternaryId;
	
	
	public CABBookOrCancelEvent(CABReservationBO reservationBO) {
		this.reservationBO=reservationBO;
		this.iternaryId=reservationBO.getIternaryId();
		setRoutingKey(Constants.CAB_KEY);
	}
	
    public CABBookOrCancelEvent(){
    	setRoutingKey(Constants.CAB_KEY);
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
