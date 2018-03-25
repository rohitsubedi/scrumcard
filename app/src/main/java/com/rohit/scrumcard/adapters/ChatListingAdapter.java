package com.rohit.scrumcard.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rohit.scrumcard.MainActivity;
import com.rohit.scrumcard.PointActivity;
import com.rohit.scrumcard.R;

import java.util.ArrayList;

/**
 * Created by developer on 25/03/18.
 */

public class ChatListingAdapter extends ArrayAdapter<Integer> {
    protected Context context;
    protected int resource;
    protected ArrayList<Integer> values;

    public ChatListingAdapter(Context context, int resource, ArrayList<Integer> values) {
        super(context, resource, values);

        this.context  = context;
        this.resource = resource;
        this.values   = values;
    }

    @NonNull
    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(this.resource, parent, false);
        final int value = this.values.get(position);
        TextView text = (TextView) rowView.findViewById(R.id.scrum_value);
        RelativeLayout layout = (RelativeLayout) rowView.findViewById(R.id.scrum_relative_layout);

        text.setText(String.valueOf(value));

        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("VALUE", String.valueOf(value));
                Intent intent = new Intent(context, PointActivity.class);

                intent.putExtra("CARD_VALUE", value);
                context.startActivity(intent);
                ((MainActivity) context).startNewActivity(intent);
            }
        });

        return rowView;
    }
}
