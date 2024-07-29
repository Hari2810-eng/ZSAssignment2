/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment8_classesobject;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Create Flight DTO class. 
 * Create appropriate instance variables, static variables and methods with appropriate access modifiers.
 * Flight Data Transfer Object (DTO) class.
 * Provides a representation of flight information with appropriate access modifiers.
 * Author: Priya
 */
public class FlightDTO {
    private String flightNumber;
    private String airline;
    private String departureAirport;
    private String arrivalAirport;
    private String departureTime;
    private String arrivalTime;
    private double price;
    private int seatsAvailable;

    private static final String DEFAULT_AIRLINE = "Unknown Airline";
    private static final String DEFAULT_DEPARTURE_AIRPORT = "Unknown Airport";
    private static final String DEFAULT_ARRIVAL_AIRPORT = "Unknown Airport";

    public FlightDTO() {
        this.flightNumber = "Unknown";
        this.airline = DEFAULT_AIRLINE;
        this.departureAirport = DEFAULT_DEPARTURE_AIRPORT;
        this.arrivalAirport = DEFAULT_ARRIVAL_AIRPORT;
        this.departureTime = "Unknown";
        this.arrivalTime = "Unknown";
        this.price = 0.0;
        this.seatsAvailable = 0;
    }

    public FlightDTO(String flightNumber, String airline, String departureAirport, 
                     String arrivalAirport, String departureTime, String arrivalTime, 
                     double price, int seatsAvailable) {
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.price = price;
        this.seatsAvailable = seatsAvailable;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(int seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public static String getDefaultAirline() {
        return DEFAULT_AIRLINE;
    }

    public static String getDefaultDepartureAirport() {
        return DEFAULT_DEPARTURE_AIRPORT;
    }

    public static String getDefaultArrivalAirport() {
        return DEFAULT_ARRIVAL_AIRPORT;
    }

    public String getFlightDetails() {
        return "Flight Details:\n" +
               "Flight Number: " + flightNumber + "\n" +
               "Airline: " + airline + "\n" +
               "Departure Airport: " + departureAirport + "\n" +
               "Arrival Airport: " + arrivalAirport + "\n" +
               "Departure Time: " + departureTime + "\n" +
               "Arrival Time: " + arrivalTime + "\n" +
               "Price: " + price + "\n" +
               "Seats Available: " + seatsAvailable;
    }

    public static boolean isValidFlightNumber(String flightNumber) {
        return flightNumber != null && flightNumber.matches("[A-Z]{2}\\d{3}");
    }


    public static void printDefaultValues() {
        System.out.println("Default Airline: " + DEFAULT_AIRLINE);
        System.out.println("Default Departure Airport: " + DEFAULT_DEPARTURE_AIRPORT);
        System.out.println("Default Arrival Airport: " + DEFAULT_ARRIVAL_AIRPORT);
    }

    public static void main(String[] args) {
        Set<FlightDTO> flights = new HashSet<>();

        flights.add(new FlightDTO("AA123", "American Airlines", "JFK", "LAX", 
                                  "2024-07-27T08:00:00", "2024-07-27T11:00:00", 
                                  299.99, 150));
        flights.add(new FlightDTO("DL456", "Delta Airlines", "ATL", "SFO", 
                                  "2024-07-28T09:00:00", "2024-07-28T12:00:00", 
                                  349.99, 120));
        flights.add(new FlightDTO("UA789", "United Airlines", "ORD", "MIA", 
                                  "2024-07-29T10:00:00", "2024-07-29T14:00:00", 
                                  399.99, 100));

        FlightDTO defaultFlight = new FlightDTO();
        flights.add(defaultFlight);

        FlightDTO.printDefaultValues();
        System.out.println();

        for (FlightDTO flight : flights) {
            System.out.println(flight.getFlightDetails());
            System.out.println("Valid Flight Number: " + FlightDTO.isValidFlightNumber(flight.getFlightNumber()));
            System.out.println();
        }
    }
}
