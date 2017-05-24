package com.alignsolution.siamsmilemobileapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by aligndev on 04-May-17.
 */

public class Pay2ActivityAdapter_list extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;
    public Pay2ActivityAdapter_list(Activity context,
                                           String[] web, Integer[] imageId) {
        super(context, R.layout.activity_claim_policy_list, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.activity_claim_policy_list, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.textView137);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView18);
        txtTitle.setText(web[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}
