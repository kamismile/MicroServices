package com.cts.event;

import com.cts.bo.ReservationBO;

public abstract class BookOrCancelEvent {
	
	private ReservationBO reservationBO;
	
	private Boolean isBook=true;

	public ReservationBO getReservationBO() {
		return reservationBO;
	}

	public void setReservationBO(ReservationBO reservationBO) {
		this.reservationBO = reservationBO;
	}

	public Boolean getIsBook() {
		return isBook;
	}

	public void setIsBook(Boolean isBook) {
		this.isBook = isBook;
	}

	public BookOrCancelEvent(ReservationBO reservationBO) {
		super();
		this.reservationBO = reservationBO;
	}
	
	public BookOrCancelEvent(){
		
	}
	
	

}
