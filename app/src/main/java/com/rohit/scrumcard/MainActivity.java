package com.rohit.scrumcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.rohit.scrumcard.adapters.CardListingAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> items;
    CardListingAdapter adapter;
    GridView scrumView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        scrumView = (GridView) findViewById(R.id.scrum_view);
        items = new ArrayList<>(Arrays.asList("0", "1/2", "1", "2", "3", "5", "8", "13", "20", "40", "100", "?"));
        adapter = new CardListingAdapter(this, R.layout.card_listing_item, items);

        scrumView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    /**
     * Start New Activity
     *
     * @param intent
     */
    public void startNewActivity(Intent intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
