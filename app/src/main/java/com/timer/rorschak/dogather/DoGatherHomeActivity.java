package com.timer.rorschak.dogather;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
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

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("total events");
        loadBackdrop();
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

        EventHolder eventHolder4 = new EventHolder("Mad Max: Fury Road", "Action & Adventure");
        eventHolderList.add(eventHolder4);
        EventHolder eventHolder5 = new EventHolder("Mad Max: Fury Road", "Action & Adventure");
        eventHolderList.add(eventHolder5);
        EventHolder eventHolder6 = new EventHolder("Mad Max: Fury Road", "Action & Adventure");
        eventHolderList.add(eventHolder6);
        EventHolder eventHolder7 = new EventHolder("Mad Max: Fury Road", "Action & Adventure");
        eventHolderList.add(eventHolder7);
        EventHolder eventHolder8 = new EventHolder("Mad Max: Fury Road", "Action & Adventure");
        eventHolderList.add(eventHolder8);
        EventHolder eventHolder9 = new EventHolder("Mad Max: Fury Road", "Action & Adventure");
        eventHolderList.add(eventHolder9);
        EventHolder eventHolder10 = new EventHolder("Mad Max: Fury Road", "Action & Adventure");
        eventHolderList.add(eventHolder10);
        EventHolder eventHolder11 = new EventHolder("Mad Max: Fury Road", "Action & Adventure");
        eventHolderList.add(eventHolder11);

        mEventAdapter.notifyDataSetChanged();
    }
    private void loadBackdrop() {
        final ImageView imageView = (ImageView) findViewById(R.id.backdrop);
        Glide.with(this).load(R.drawable.background_cover).centerCrop().into(imageView);
    }
}
