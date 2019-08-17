package com.example.flightexcercise.networking;

import android.arch.lifecycle.MutableLiveData;
import com.example.flightexcercise.model.Flight;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlightRepository {

    private static FlightRepository flightRepository;


    public static FlightRepository getInstance() {
        if (flightRepository == null) {
            flightRepository = new FlightRepository();
        }
        return flightRepository;

    }

    private FlightApi flightApi;

    public FlightRepository() {
        flightApi = RetrofitService.createService(FlightApi.class);
    }

    public MutableLiveData<List<Flight>> getFlights() {

        final MutableLiveData<List<Flight>> flightsData = new MutableLiveData<>();
        flightApi.getFlights().enqueue(new Callback<List<Flight>>() {
            @Override
            public void onResponse(Call<List<Flight>> call, Response<List<Flight>> response) {
                if (response.isSuccessful()) {
                    flightsData.setValue(response.body());
                }

            }

            @Override
            public void onFailure(Call<List<Flight>> call, Throwable t) {
                flightsData.setValue(null);
                t.printStackTrace();
            }
        });
        return flightsData;
    }
}
