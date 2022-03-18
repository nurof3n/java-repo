package com.db.homeworks.hw1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BusStation {
    /// Fields

    private final Vehicle[] vehicles;

    /// Constructors

    public BusStation(int noVehicles) {
        vehicles = new Vehicle[noVehicles];
    }

    public BusStation(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }

    /// Instance methods

    /**
     * Changes a vehicle in the array
     *
     * @param o   new vehicle
     * @param idx position to change
     */
    public void changeVehicle(Vehicle o, int idx) {
        vehicles[idx] = o;
    }

    /**
     * Displays all the vehicles to stdout
     */
    public void showAllVehicles() {
        for (var vehicle : vehicles) {
            vehicle.display();
        }
    }

    /**
     * Computes the total profit of all the vehicles and displays it to stdout
     */
    public void showTotalProfit() {
        double profit = 0.0;
        for (var vehicle : vehicles) {
            profit += vehicle.profit();
        }

        System.out.println(profit);
    }

    /**
     * Sorts the vehicles in ascending order by profit
     */
    public void sortVehicles() {
        Arrays.sort(vehicles);
    }

    /// Static methods

    public static void main(String[] args) {
        BusStation busStation = new BusStation(5);
        busStation.changeVehicle(new Taxi(), 0);
        busStation.changeVehicle(new Taxi("Green", true, 2, 15.0), 1);
        busStation.changeVehicle(new Taxi("Yellow", false, 5, 500.0), 2);
        busStation.changeVehicle(new Bus("Red", false, 10, 1.0), 3);
        busStation.changeVehicle(new Bus("Red", true, 20, 2.5), 4);

        System.out.println("The list of vehicles before sorting is:");
        busStation.showAllVehicles();
        busStation.sortVehicles();
        System.out.println("The list of vehicles after sorting is:");
        busStation.showAllVehicles();
        System.out.print("The total profit is: ");
        busStation.showTotalProfit();
    }
}
