package com.trainapp.ticket_booking.model;

public class Ticket {
    private Long id;
    private String from;
    private String to;
    private User user;
    private double price;
    private Seat seat;

    //constructors
    public Ticket() {
    }

    public Ticket(Long id, String from, String to, User user, double price, Seat seat) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.user = user;
        this.price = price;
        this.seat = seat;
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    //toString method
    @Override
    public String toString() {
        return "Ticket [id=" + id + ", from=" + from + ", to=" + to + ", user=" + user + ", price=" + price + ", seat="
                + seat + "]";
    }

    
}
