package com.example.flightexcercise.networking;

import com.example.flightexcercise.model.Flight;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FlightApi {

    @GET("developer-test-flights-list.json?alt=media&token=81d93056-9c7f-451d-94b6-3e88eb6fa9ad/")
    Call<List<Flight>> getFlights();
}
