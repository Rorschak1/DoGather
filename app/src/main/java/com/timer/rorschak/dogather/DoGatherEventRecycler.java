package com.timer.rorschak.dogather;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.timer.rorschak.dogather.Beans.EventHolder;

import java.util.List;

/**
 * Created by Rorschak1 on 6/29/16.
 */
public class DoGatherEventRecycler extends RecyclerView.Adapter<DoGatherEventRecycler.MyViewHolder> {


    private List<EventHolder> mEvents;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, desc;
        public ImageView imageview;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.event_text);
            desc = (TextView) view.findViewById(R.id.event_desc);
        }
    }

    public DoGatherEventRecycler(List<EventHolder> events) {
        this.mEvents = events;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_cards, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        EventHolder eventHolder=mEvents.get(position);
        holder.title.setText(eventHolder.getmEventText());
        holder.desc.setText(eventHolder.getmEventDesc());
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }
}
