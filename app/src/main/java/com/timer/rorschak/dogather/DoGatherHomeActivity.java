package com.timer.rorschak.dogather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.timer.rorschak.dogather.Beans.EventHolder;
import java.util.ArrayList;
import java.util.List;

/**
 * DoGatherHomeActivity.java - HomeActivity of dogather app
 * @author  Rorschak1
 * @version 1.0
 */
public class DoGatherHomeActivity extends AppCompatActivity {

    private List<EventHolder> eventHolderList = new ArrayList<>();
    RecyclerView recyclerView;
    private DoGatherEventRecycler mEventAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_gather_home);

        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        mEventAdapter=new DoGatherEventRecycler(eventHolderList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mEventAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        EventHolder eventHolder = new EventHolder("Mad Max: Fury Road", "Action & Adventure");
        eventHolderList.add(eventHolder);

        EventHolder eventHolder1 = new EventHolder("Mad Max: nice", "Action & Adventure");
        eventHolderList.add(eventHolder1);

        EventHolder eventHolder2 = new EventHolder("Mad Max: boo", "Action & Adventure");
        eventHolderList.add(eventHolder2);
        EventHolder eventHolder3 = new EventHolder("Mad Max: Fury Road", "Action & Adventure");
        eventHolderList.add(eventHolder3);

        mEventAdapter.notifyDataSetChanged();
    }
}
