package com.example.flightexcercise.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Flight implements Serializable {
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("departure_date")
    @Expose
    private String departureDate;
    @SerializedName("airline_code")
    @Expose
    private String airlineCode;
    @SerializedName("flight_number")
    @Expose
    private int flightNumber;
    @SerializedName("departure_city")
    @Expose
    private String departureCity;
    @SerializedName("departure_airport")
    @Expose
    private String departureAirport;
    @SerializedName("arrival_city")
    @Expose
    private String arrivalCity;
    @SerializedName("arrival_airport")
    @Expose
    private String arrivalAirport;
    @SerializedName("scheduled_duration")
    @Expose
    private String scheduledDuration;
    @SerializedName("arrival_date")
    @Expose
    private String arrivalDate;

    public Flight(long id, String departureDate, String airlineCode, int flightNumber,
        String departureCity, String departureAirport, String arrivalCity,
        String arrivalAirport, String scheduledDuration, String arrivalDate) {
        this.id = id;
        this.departureDate = departureDate;
        this.airlineCode = airlineCode;
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.departureAirport = departureAirport;
        this.arrivalCity = arrivalCity;
        this.arrivalAirport = arrivalAirport;
        this.scheduledDuration = scheduledDuration;
        this.arrivalDate = arrivalDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getScheduledDuration() {
        return scheduledDuration;
    }

    public void setScheduledDuration(String scheduledDuration) {
        this.scheduledDuration = scheduledDuration;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public String toString() {
        return "Flight{" +
            "id=" + id +
            ", departureDate=" + departureDate +
            ", airlineCode='" + airlineCode + '\'' +
            ", flightNumber=" + flightNumber +
            ", departureCity='" + departureCity + '\'' +
            ", departureAirport='" + departureAirport + '\'' +
            ", arrivalCity='" + arrivalCity + '\'' +
            ", arrivalAirport='" + arrivalAirport + '\'' +
            ", scheduledDuration='" + scheduledDuration + '\'' +
            ", arrivalDate=" + arrivalDate +
            '}';
    }
}
