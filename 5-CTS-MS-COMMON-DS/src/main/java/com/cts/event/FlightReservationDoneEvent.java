package com.cts.event;

import com.cts.bo.FlightReservationBO;
import com.cts.common.Constants;


public class FlightReservationDoneEvent extends BaseEvent{

	private FlightReservationBO reservationBO;
	private String iternaryId;
	
	public FlightReservationDoneEvent(FlightReservationBO reservationBO) {
		this.reservationBO=reservationBO;
		this.iternaryId=reservationBO.getIternaryId();
		setRoutingKey(Constants.SAGA_KEY);
	}
	
	public FlightReservationDoneEvent(){
		setRoutingKey(Constants.SAGA_KEY);
	}

	public FlightReservationBO getReservationBO() {
		return reservationBO;
	}

	public void setReservationBO(FlightReservationBO reservationBO) {
		this.reservationBO = reservationBO;
	}

	public String getIternaryId() {
		return iternaryId;
	}

	public void setIternaryId(String iternaryId) {
		this.iternaryId = iternaryId;
	}
	
	


}
