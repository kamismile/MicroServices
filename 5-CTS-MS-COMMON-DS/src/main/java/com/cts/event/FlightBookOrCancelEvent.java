package com.cts.event;

import com.cts.bo.FlightReservationBO;
import com.cts.common.Constants;


public class FlightBookOrCancelEvent extends BaseEvent{

	
	private FlightReservationBO reservationBO;
	private String iternaryId;
	
	public FlightBookOrCancelEvent(FlightReservationBO reservationBO) {
		this.reservationBO=reservationBO;
		this.iternaryId=reservationBO.getIternaryId();
		setRoutingKey(Constants.FLIGHT_KEY);
	}
	
	public FlightBookOrCancelEvent(){
		setRoutingKey(Constants.FLIGHT_KEY);
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
