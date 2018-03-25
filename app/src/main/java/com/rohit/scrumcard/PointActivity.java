package com.rohit.scrumcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class PointActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_point);
        super.onCreate(savedInstanceState);

        int value = getIntent().getIntExtra("CARD_VALUE", 0);
        TextView point = (TextView) findViewById(R.id.display_value);

        point.setText(String.valueOf(value));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
