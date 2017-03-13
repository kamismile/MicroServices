package com.cts.bo;

public class FlightReservationBO extends ReservationBO {
	
	private String flightNumber;
	private String flightBookingReferenceNumber;
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getFlightBookingReferenceNumber() {
		return flightBookingReferenceNumber;
	}
	public void setFlightBookingReferenceNumber(String flightBookingReferenceNumber) {
		this.flightBookingReferenceNumber = flightBookingReferenceNumber;
	}
	
	
}
