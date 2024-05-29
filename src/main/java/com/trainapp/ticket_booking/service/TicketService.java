package com.trainapp.ticket_booking.service;

import org.springframework.stereotype.Service;

import com.trainapp.ticket_booking.model.Seat;
import com.trainapp.ticket_booking.model.Ticket;
import com.trainapp.ticket_booking.repository.TicketRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private static final double TICKET_PRICE = 20.0;
    private static int seatCounter = 1;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket purchaseTicket(Ticket ticket){
        Seat seat = allocateSeat();

        ticket.setPrice(TICKET_PRICE);
        ticket.setSeat(seat);

        ticketRepository.save(ticket);
        return ticket;
    }

    public Ticket getTicketById(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        return ticket.orElseThrow(() -> new RuntimeException("Ticket not found"));
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public List<Ticket> getTicketsBySection(String section) {
        return ticketRepository.findBySection(section);
    }

    public boolean removeUser(Long id) {
        return ticketRepository.deleteById(id);
    }

    public Ticket modifyTicket(Long id, Ticket modifiedTicket) {
        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
        if (optionalTicket.isPresent()) {
            Ticket existingTicket = optionalTicket.get();
            existingTicket.setSeat(modifiedTicket.getSeat());
            ticketRepository.save(existingTicket);
            return existingTicket;
        } else {
            throw new RuntimeException("Ticket not found");
        }
    }

    private Seat allocateSeat(){
        String section = seatCounter % 2 == 0 ? "B" : "A";

        Seat seat = new Seat(section, seatCounter);
        seatCounter++;
        return seat;
    }
}
