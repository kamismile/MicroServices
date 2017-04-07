package com.cts.controller;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bo.ReservationBO;
import com.cts.command.ReserveCommand;

@RestController
public class ReservationController {

	@Autowired	
	private CommandGateway commandGateway;

	@PostMapping(value = "/reserve", consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	public CompletableFuture<Object> reserve(@RequestBody ReservationBO reservation) {
		reservation.setIternaryId(UUID.randomUUID().toString());
		ReserveCommand reserveCommand = new ReserveCommand();
		reserveCommand.setReservationBO(reservation);
		
		return commandGateway.send(reserveCommand);
	}

}
