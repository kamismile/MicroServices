package com.cts.eventhandler;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import com.cts.bo.CABReservationBO;
import com.cts.event.CABBookOrCancelEvent;

@ProcessingGroup("CABBookOrCancel")
@Component("springManagedCABBookOrCancelHandler")
public class CABBookOrCancelHandler {

	@EventHandler
	public void on(CABBookOrCancelEvent item) {
		CABReservationBO cabReservationBO = (CABReservationBO) item.getReservationBO();
		System.out.println("The Flight Is Booked: " + cabReservationBO);
	}

}
