package com.example.flightexcercise.model;

public class GeneralItem extends ListItem {

    private Flight flight;

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public int getType() {
        return TYPE_GENERAL;
    }
}
