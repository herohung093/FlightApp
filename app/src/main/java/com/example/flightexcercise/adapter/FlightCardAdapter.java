package com.example.flightexcercise.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.flightexcercise.R;
import com.example.flightexcercise.model.Flight;
import java.util.List;

public class FlightCardAdapter extends RecyclerView.Adapter<FlightCardAdapter.ViewHolder>{
    private Context context;
    private List<Flight> flightsList;
    private final OnItemClickListener listener;
    public FlightCardAdapter(Context context,
        List<Flight> flightsList, OnItemClickListener listener) {
        this.context = context;
        this.flightsList = flightsList;
        this.listener = listener;
    }


    @Override
    public FlightCardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.flight_card,viewGroup,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FlightCardAdapter.ViewHolder viewHolder, int i) {
        viewHolder.flightTitle.setText("Flight to "+flightsList.get(i).getArrivalCity().split(",")[0]);
        viewHolder.arrivalCity.setText(flightsList.get(i).getArrivalCity().split(",")[0]);
        viewHolder.departureCity.setText(flightsList.get(i).getDepartureCity().split(",")[0]);
        viewHolder.arrivalAirport.setText(flightsList.get(i).getArrivalAirport());
        viewHolder.departureAirport.setText(flightsList.get(i).getDepartureAirport());
        viewHolder.numberOfStop.setText("Non-Stop");
        viewHolder.arrivalTime.setText(flightsList.get(i).getArrivalDate().substring(11,16));
        viewHolder.departureTime.setText(flightsList.get(i).getDepartureDate().substring(11,16));

        viewHolder.bind(flightsList.get(i),listener, context);

    }

    @Override
    public int getItemCount() {
        return flightsList.size();
    }
    public void setFlightsList(List<Flight> flightsList){
        this.flightsList = flightsList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        protected TextView flightTitle
            , scheduledDuration
            , arrivalCity
            , departureCity
            , arrivalAirport
            , departureAirport
            , numberOfStop
            , arrivalTime
            , departureTime;
        protected CardView flightCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            flightTitle = itemView.findViewById(R.id.flightTitle);
            arrivalCity = itemView.findViewById(R.id.arrivalCity);
            scheduledDuration= itemView.findViewById(R.id.scheduledDuration);
            departureCity= itemView.findViewById(R.id.departureCity);
            arrivalAirport= itemView.findViewById(R.id.arrivalAirport);
            departureAirport= itemView.findViewById(R.id.departureAirport);
            numberOfStop= itemView.findViewById(R.id.numberOfStop);
            arrivalTime= itemView.findViewById(R.id.arrivalTime);
            departureTime= itemView.findViewById(R.id.departureTime);
            flightCard = itemView.findViewById(R.id.flightCard);
        }
        public void bind(final Flight item, final OnItemClickListener listener, Context context){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item, context);
                }
            });
        }
    }
    public interface OnItemClickListener {
        void onItemClick(Flight item, Context context);

    }

}


