package com.trainapp.ticket_booking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.trainapp.ticket_booking.model.Ticket;
import com.trainapp.ticket_booking.service.TicketService;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/purchase")
    public Ticket purchaseTicket(@RequestBody Ticket ticket){
        return ticketService.purchaseTicket(ticket);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
    return new ResponseEntity<>(ticketService.getTicketById(id),HttpStatus.OK);
}

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return new ResponseEntity<>(ticketService.getAllTickets(),HttpStatus.OK);
    }

    @GetMapping("/section/{section}")
    public ResponseEntity<List<Ticket>> getTicketsBySection(@PathVariable String section) {
        return new ResponseEntity<>(ticketService.getTicketsBySection(section),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> removeUser(@PathVariable Long id) {
        boolean isRemoved = ticketService.removeUser(id);
        if (isRemoved) {
            return new ResponseEntity<>("User removed successfully.",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found.",HttpStatus.NOT_FOUND);

        }
    }

    @PutMapping("/{id}")
    public Ticket modifyTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
        return ticketService.modifyTicket(id, ticket);
    }
}
