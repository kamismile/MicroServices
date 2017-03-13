package com.cts.eventhandler;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.cts.bo.HotelReservationBO;
import com.cts.event.HotelBookOrCancelEvent;

@ProcessingGroup("HotelBookOrCancel")
@Component("springManagedHotelBookOrCancelHandler")
public class HotelBookOrCancelHandler {

	@EventHandler
	public void on(HotelBookOrCancelEvent item) {
		HotelReservationBO hotelReservationBO = (HotelReservationBO) item.getReservationBO();
		System.out.println("The Hotel Is Booked: " + hotelReservationBO);
	}

}
