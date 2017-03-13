package com.cts.command;

import com.cts.bo.ReservationBO;

public abstract class BookOrCancelCommand {
	
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
	
	

}
