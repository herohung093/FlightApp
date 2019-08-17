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

        arrivalTimeTV = findViewById(R.id.arrivalTimeTV);
        departureTimeTV = findViewById(R.id.departureTimeTV);
        toCityTV = findViewById(R.id.toCityTV);
        fromCityTV = findViewById(R.id.fromCityTV);
        toAirportTV = findViewById(R.id.toAirportTV);
        fromAirportTV = findViewById(R.id.fromAirportTV);
        airFlightCodeTV = findViewById(R.id.airFlightCodeTV);

        loadFlightDetailToView();
    }

    /**
     * bind data to view
     */
    public void loadFlightDetailToView() {
        String convertedArrivalTime = DestructTime.getDate(flight.getArrivalDate())
            .substring(0, DestructTime.getDate(flight.getArrivalDate()).length() - 1);
        String convertedDepartureTime = DestructTime.getDate(flight.getDepartureDate())
            .substring(0, DestructTime.getDate(flight.getDepartureDate()).length() - 1);

        arrivalTimeTV
            .setText(convertedArrivalTime + "\n" + DestructTime.getTime(flight.getArrivalDate()));
        departureTimeTV.setText(
            convertedDepartureTime + "\n" + DestructTime.getTime(flight.getDepartureDate()));
        toCityTV.setText(flight.getArrivalCity().split(",")[0]);
        fromCityTV.setText(flight.getDepartureCity().split(",")[0]);
        toAirportTV.setText(flight.getArrivalAirport());
        fromAirportTV.setText(flight.getDepartureAirport());
        airFlightCodeTV.setText(String.valueOf(flight.getFlightNumber()));

    }
}
