package com.example.flightexcercise.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.example.flightexcercise.model.Flight;
import com.example.flightexcercise.networking.FlightRepository;
import java.util.List;

public class FlightsViewModel extends ViewModel {
    private MutableLiveData<List<Flight>> mutableLiveData;
    private FlightRepository flightRepository;

    public void init(){
        if(mutableLiveData == null){
            mutableLiveData = new MutableLiveData<>();
        }
        flightRepository = FlightRepository.getInstance();
        mutableLiveData = flightRepository.getFlights();

    }

    public LiveData<List<Flight>> getFlights(){
        return mutableLiveData;
    }

}
