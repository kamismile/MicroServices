package com.cts.event;

import com.cts.bo.HotelReservationBO;
import com.cts.common.Constants;


public class HotelReservationDoneEvent extends BaseEvent{

	private HotelReservationBO reservationBO;
	private String iternaryId;
	
	public HotelReservationDoneEvent(HotelReservationBO reservationBO) {
		this.reservationBO=reservationBO;
		this.iternaryId=reservationBO.getIternaryId();
		setRoutingKey(Constants.SAGA_KEY);
	}
	
	public HotelReservationDoneEvent(){
		setRoutingKey(Constants.SAGA_KEY);
    }

	public HotelReservationBO getReservationBO() {
		return reservationBO;
	}

	public void setReservationBO(HotelReservationBO reservationBO) {
		this.reservationBO = reservationBO;
	}

	public String getIternaryId() {
		return iternaryId;
	}

	public void setIternaryId(String iternaryId) {
		this.iternaryId = iternaryId;
	}
     
	

}
