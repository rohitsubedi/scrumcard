package com.rohit.scrumcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.GridView;

import com.rohit.scrumcard.adapters.ChatListingAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> items;
    ChatListingAdapter adapter;
    GridView scrumView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        scrumView = (GridView) findViewById(R.id.scrum_view);
        items = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8, 13, 20, 40, 100));
        adapter = new ChatListingAdapter(this, R.layout.card_listing_item, items);

        scrumView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    /**
     * Start New Activity
     *
     * @param intent
     */
    public void startNewActivity(Intent intent)
    {
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
