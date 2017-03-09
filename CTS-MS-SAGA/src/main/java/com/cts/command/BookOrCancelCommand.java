package com.cts.command;

import com.cts.bo.AbstractReservationBO;

public abstract class BookOrCancelCommand {
	
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
