package com.trainapp.ticket_booking.model;

public class Seat {
    private String section;
    private int seatNumber;


    //constructors
    public Seat() {}
    
    public Seat(String section, int seatNumber) {
        this.section = section;
        this.seatNumber = seatNumber;
    }

    // Getters and Setters
    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    //toString() method
    @Override
    public String toString() {
        return "Seat [section=" + section + ", seatNumber=" + seatNumber + "]";
    }

    
}
