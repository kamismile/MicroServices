package com.cts.bo;

public class FlightReservationBO extends AbstractReservationBO {
	
	private String flightNumber;
	private String passengerName;
	private String from;
	private String toDestination;
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getToDestination() {
		return toDestination;
	}
	public void setToDestination(String toDestination) {
		this.toDestination = toDestination;
	}
	
	

}
