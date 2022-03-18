package com.db.homeworks.hw1;

public class Bus extends Vehicle {
    /// Fields

    private int noPassengers;
    private double ticketPrice;

    /// Constructors

    public Bus() {
        super();
        noPassengers = 0;
        ticketPrice = 2.0;
    }

    public Bus(String colour, boolean functional, int noPassengers, double ticketPrice) {
        super(colour, functional);
        this.noPassengers = noPassengers;
        this.ticketPrice = ticketPrice;
    }

    /// Get/Set

    public int getNoPassengers() {
        return noPassengers;
    }

    public void setNoPassengers(int noPassengers) {
        this.noPassengers = noPassengers;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    /// Overrides

    /**
     * Returns the charge as the product between the ticket price and number of passengers
     * If the vehicle is not functional, charge is 0
     */
    @Override
    double charge() {
        return functional ? ticketPrice * noPassengers : 0.0;
    }

    /**
     * Returns the profit as 25% of the charge
     */
    @Override
    double profit() {
        return .25 * charge();
    }

    /**
     * Displays the objects' attributes to stdout
     */
    @Override
    void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Bus{" + "noPassengers=" + noPassengers + ", ticketPrice=" + ticketPrice + ", " +
                "colour='" + colour + '\'' + ", functional=" + functional + '}';
    }
}
