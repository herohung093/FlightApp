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
import com.example.flightexcercise.model.Flight;
import com.example.flightexcercise.viewmodel.FlightsViewModel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    /**
     * to stores flight detail from the API
     * */
    List<Flight> flightsList= new ArrayList<>();
    FlightsViewModel flightsViewModel;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupFlightList();
        flightsViewModel = ViewModelProviders.of(this).get(FlightsViewModel.class);
        flightsViewModel.init();
        flightsViewModel.getFlights().observe(this, flightsResponse ->{
            flightsList.addAll(flightsResponse);
            mAdapter.notifyDataSetChanged();

        });

        /**
         * setup ToolBar
         */
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Trips");
        setSupportActionBar(myToolbar);

    }
    private void setupFlightList(){
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new FlightCardAdapter(this, flightsList, new OnItemClickListener() {
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