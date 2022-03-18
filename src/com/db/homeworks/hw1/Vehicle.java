package com.db.homeworks.hw1;

public abstract class Vehicle implements Comparable<Vehicle> {
    /// Fields

    protected String colour;
    protected boolean functional;

    /// Constructors

    public Vehicle() {
        this.colour = "Black";
        this.functional = true;
    }

    public Vehicle(String colour, boolean functional) {
        this.colour = colour;
        this.functional = functional;
    }

    /// Get/Set

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isFunctional() {
        return functional;
    }

    public void setFunctional(boolean functional) {
        this.functional = functional;
    }

    /// Abstracts

    abstract double charge();

    abstract double profit();

    abstract void display();

    /// Overrides

    /**
     * Compares two Vehicles by their profits
     */
    @Override
    public int compareTo(Vehicle o) {
        return Double.compare(profit(), o.profit());
    }
}
