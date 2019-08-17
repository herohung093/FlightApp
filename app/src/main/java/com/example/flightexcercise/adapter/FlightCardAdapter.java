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
import com.example.flightexcercise.model.DateItem;
import com.example.flightexcercise.model.Flight;
import com.example.flightexcercise.model.GeneralItem;
import com.example.flightexcercise.model.ListItem;
import java.util.ArrayList;
import java.util.List;

/**
 * Adapter for Recycle list of flight objects
 */
public class FlightCardAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /**
     * Parent activity context
     */
    private Context context;
    /***
     * onItemListener for each item
     */
    private final OnItemClickListener listener;
    /**
     * Common list to hold both general and DateItem objects
     */
    List<ListItem> consolidatedList = new ArrayList<>();

    public FlightCardAdapter(Context context,
        List<ListItem> consolidatedList, OnItemClickListener listener) {
        this.context = context;
        this.consolidatedList = consolidatedList;
        this.listener = listener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        /**
         * Create view base on view type
         * */
        switch (viewType) {

            case ListItem.TYPE_GENERAL:
                View v1 = inflater.inflate(R.layout.flight_card, parent,
                    false);
                viewHolder = new GeneralViewHolder(v1);
                break;

            case ListItem.TYPE_DATE:
                View v2 = inflater.inflate(R.layout.date_item, parent, false);
                viewHolder = new DateViewHolder(v2);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {

        switch (viewHolder.getItemViewType()) {

            case ListItem.TYPE_GENERAL:
                ((GeneralViewHolder) viewHolder).flightTitle.setText(
                    "Flight to " + ((GeneralItem) consolidatedList.get(i)).getFlight()
                        .getArrivalCity().split(",")[0]);
                ((GeneralViewHolder) viewHolder).arrivalCity.setText(
                    ((GeneralItem) consolidatedList.get(i)).getFlight().getArrivalCity()
                        .split(",")[0]);
                ((GeneralViewHolder) viewHolder).departureCity.setText(
                    ((GeneralItem) consolidatedList.get(i)).getFlight().getDepartureCity()
                        .split(",")[0]);
                ((GeneralViewHolder) viewHolder).arrivalAirport.setText(
                    ((GeneralItem) consolidatedList.get(i)).getFlight().getArrivalAirport());
                ((GeneralViewHolder) viewHolder).departureAirport.setText(
                    ((GeneralItem) consolidatedList.get(i)).getFlight().getDepartureAirport());
                ((GeneralViewHolder) viewHolder).numberOfStop.setText("Non-Stop");
                ((GeneralViewHolder) viewHolder).arrivalTime.setText(
                    ((GeneralItem) consolidatedList.get(i)).getFlight().getArrivalDate()
                        .substring(11, 16));
                ((GeneralViewHolder) viewHolder).departureTime.setText(
                    ((GeneralItem) consolidatedList.get(i)).getFlight().getDepartureDate()
                        .substring(11, 16));

                ((GeneralViewHolder) viewHolder)
                    .bind(((GeneralItem) consolidatedList.get(i)).getFlight(), listener, context);

                break;

            case ListItem.TYPE_DATE:
                DateItem dateItem = (DateItem) consolidatedList.get(i);
                DateViewHolder dateViewHolder = (DateViewHolder) viewHolder;
                dateViewHolder.txtTitle.setText(dateItem.getStringDate());

                break;
        }


    }

    @Override
    public int getItemCount() {
        return consolidatedList != null ? consolidatedList.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return consolidatedList.get(position).getType();
    }

    /**
     * View holder for date row item
     */
    class DateViewHolder extends RecyclerView.ViewHolder {

        protected TextView txtTitle;

        public DateViewHolder(View v) {
            super(v);
            this.txtTitle = (TextView) v.findViewById(R.id.date);

        }
    }

    /**
     * View holder for flight row item
     */
    public class GeneralViewHolder extends RecyclerView.ViewHolder {

        protected TextView flightTitle, scheduledDuration, arrivalCity, departureCity, arrivalAirport, departureAirport, numberOfStop, arrivalTime, departureTime;
        protected CardView flightCard;

        public GeneralViewHolder(@NonNull View itemView) {
            super(itemView);
            flightTitle = itemView.findViewById(R.id.flightTitle);
            arrivalCity = itemView.findViewById(R.id.arrivalCity);
            scheduledDuration = itemView.findViewById(R.id.scheduledDuration);
            departureCity = itemView.findViewById(R.id.departureCity);
            arrivalAirport = itemView.findViewById(R.id.arrivalAirport);
            departureAirport = itemView.findViewById(R.id.departureAirport);
            numberOfStop = itemView.findViewById(R.id.numberOfStop);
            arrivalTime = itemView.findViewById(R.id.arrivalTime);
            departureTime = itemView.findViewById(R.id.departureTime);
            flightCard = itemView.findViewById(R.id.flightCard);
        }

        public void bind(final Flight item, final OnItemClickListener listener, Context context) {
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


