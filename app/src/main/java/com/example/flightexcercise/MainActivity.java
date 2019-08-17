package com.example.flightexcercise;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.example.flightexcercise.adapter.FlightCardAdapter;
import com.example.flightexcercise.adapter.FlightCardAdapter.OnItemClickListener;
import com.example.flightexcercise.model.DateItem;
import com.example.flightexcercise.model.Flight;
import com.example.flightexcercise.model.GeneralItem;
import com.example.flightexcercise.model.ListItem;
import com.example.flightexcercise.viewmodel.FlightsViewModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     * common list
     */
    List<ListItem> consolidatedList = new ArrayList<>();
    /**
     * A Dictionary with key is Date, and value is a list of flight have the same departure Date
     */
    HashMap<String, List<Flight>> groupedHashMap;
    FlightsViewModel flightsViewModel;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flightsViewModel = ViewModelProviders.of(this).get(FlightsViewModel.class);
        flightsViewModel.init();
        /**
         * observe changes from LiveData
         * */
        flightsViewModel.getFlights().observe(this, flightsResponse -> {
            groupedHashMap = groupDataIntoHashMap(flightsResponse);
            constructConsolidatedList();
            setupFlightList();
        });

        /**
         * setup ToolBar
         */
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Trips");
        setSupportActionBar(myToolbar);

    }

    /**
     * Construct both date and General items.
     */
    private void constructConsolidatedList() {
        for (String date : groupedHashMap.keySet()) {
            DateItem dateItem = new DateItem(date);
            consolidatedList.add(dateItem);

            for (Flight flight : groupedHashMap.get(date)) {
                GeneralItem generalItem = new GeneralItem();
                generalItem.setFlight(flight);
                consolidatedList.add(generalItem);
            }
        }
    }

    private HashMap<String, List<Flight>> groupDataIntoHashMap(List<Flight> flightsList) {

        HashMap<String, List<Flight>> groupedHashMap = new HashMap<>();

        for (Flight flight : flightsList) {

            String hashMapKey = flight.getDepartureDate();

            if (groupedHashMap.containsKey(hashMapKey)) {
                // The key is already in the HashMap; add the flight object
                // against the existing key.
                groupedHashMap.get(hashMapKey).add(flight);
            } else {
                // The key is not there in the HashMap; create a new key-value pair
                List<Flight> list = new ArrayList<>();
                list.add(flight);
                groupedHashMap.put(hashMapKey, list);
            }
        }

        return groupedHashMap;
    }

    private void setupFlightList() {
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new FlightCardAdapter(this, consolidatedList, new OnItemClickListener() {
            /**
             * moving to new activity with a flight detail
             * */
            @Override
            public void onItemClick(Flight item, Context context) {
                Intent moveToFlightDetail = new Intent(context, FlightDetailActivity.class);
                moveToFlightDetail.putExtra("flight", item);
                context.startActivity(moveToFlightDetail);

            }

        });

        recyclerView.setAdapter(mAdapter);
    }

}