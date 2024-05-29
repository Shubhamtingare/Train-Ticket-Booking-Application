package com.trainapp.ticket_booking.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.trainapp.ticket_booking.model.Ticket;
import org.springframework.stereotype.Repository;

@Repository
public class TicketRepository {
    private final List<Ticket> tickets = new ArrayList<>();

    public void save(Ticket ticket) {
        if (ticket.getId() == null) {
            ticket.setId((long) (tickets.size() + 1));
        }
        tickets.add(ticket);
    }

    public List<Ticket> findAll() {
        return new ArrayList<>(tickets);
    }

    public List<Ticket> findBySection(String section) {
        return tickets.stream()
                .filter(ticket -> ticket.getSeat().getSection().equalsIgnoreCase(section))
                .collect(Collectors.toList());
    }

    public Optional<Ticket> findById(Long id) {
        return tickets.stream()
                .filter(ticket -> ticket.getId().equals(id))
                .findFirst();
    }

    public boolean deleteById(Long id) {
        return tickets.removeIf(ticket -> ticket.getId().equals(id));
    }
}
