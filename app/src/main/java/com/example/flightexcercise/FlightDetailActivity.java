package com.example.flightexcercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.flightexcercise.model.Flight;
import com.example.flightexcercise.util.DestructTime;

public class FlightDetailActivity extends AppCompatActivity {

    private TextView arrivalTimeTV, departureTimeTV, toCityTV, fromCityTV, toAirportTV, fromAirportTV, airFlightCodeTV;
    Intent intentReceiver;
    Flight flight;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_detail);

        intentReceiver = getIntent();
        flight = (Flight) intentReceiver.getSerializableExtra("flight");
        System.out.println(flight);
        arrivalTimeTV = findViewById(R.id.arrivalTimeTV);
        departureTimeTV = findViewById(R.id.departureTimeTV);
        toCityTV = findViewById(R.id.toCityTV);
        fromCityTV = findViewById(R.id.fromCityTV);
        toAirportTV = findViewById(R.id.toAirportTV);
        fromAirportTV = findViewById(R.id.fromAirportTV);
        airFlightCodeTV = findViewById(R.id.airFlightCodeTV);
        loadFlightDetailToView();
    }

    public void loadFlightDetailToView(){
        arrivalTimeTV.setText(DestructTime.getDate(flight.getArrivalDate()) +"\n"+DestructTime.getTime(flight.getArrivalDate()));
        departureTimeTV.setText(DestructTime.getDate(flight.getDepartureDate())+"\n"+DestructTime.getTime(flight.getDepartureDate()));
        toCityTV.setText(flight.getArrivalCity().split(",")[0]);
        fromCityTV.setText(flight.getDepartureCity().split(",")[0]);
        toAirportTV.setText(flight.getArrivalAirport());
        fromAirportTV.setText(flight.getDepartureAirport());
        airFlightCodeTV.setText(String.valueOf(flight.getFlightNumber()));

    }
}
