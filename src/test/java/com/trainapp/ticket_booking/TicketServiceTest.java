package com.trainapp.ticket_booking;


import com.trainapp.ticket_booking.model.Seat;
import com.trainapp.ticket_booking.model.Ticket;
import com.trainapp.ticket_booking.model.User;
import com.trainapp.ticket_booking.repository.TicketRepository;
import com.trainapp.ticket_booking.service.TicketService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TicketServiceTest {
    private TicketService ticketService;
    private TicketRepository ticketRepository;

    @BeforeEach
    public void setUp() {
        ticketRepository = new TicketRepository();
        ticketService = new TicketService(ticketRepository);
    }

    @Test
    public void testPurchaseTicket() {
        User user = new User("John", "Doe", "john.doe@example.com");
        Ticket ticket = new Ticket(null, "London", "France", user, 0, null);

        Ticket purchasedTicket = ticketService.purchaseTicket(ticket);

        assertNotNull(purchasedTicket);
        assertEquals(20.0, purchasedTicket.getPrice());
        assertNotNull(purchasedTicket.getSeat());
        assertEquals("London", purchasedTicket.getFrom());
        assertEquals("France", purchasedTicket.getTo());
        assertEquals(user, purchasedTicket.getUser());
    }

    @Test
    public void testViewAllTickets() {
        User user1 = new User("John", "Doe", "john.doe@example.com");
        Ticket ticket1 = new Ticket(null, "London", "France", user1, 0, null);
        ticketService.purchaseTicket(ticket1);

        User user2 = new User("Jane", "Smith", "jane.smith@example.com");
        Ticket ticket2 = new Ticket(null, "London", "France", user2, 0, null);
        ticketService.purchaseTicket(ticket2);

        List<Ticket> tickets = ticketService.getAllTickets();

        assertEquals(2, tickets.size());
    }
}

