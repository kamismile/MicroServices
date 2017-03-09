package com.cts.event;

import com.cts.bo.AbstractReservationBO;

public abstract class BookOrCancelEvent {
	
	private AbstractReservationBO reservationBO;
	
	private Boolean isBook=true;

	public AbstractReservationBO getReservationBO() {
		return reservationBO;
	}

	public void setReservationBO(AbstractReservationBO reservationBO) {
		this.reservationBO = reservationBO;
	}

	public Boolean getIsBook() {
		return isBook;
	}

	public void setIsBook(Boolean isBook) {
		this.isBook = isBook;
	}
	
	

}
