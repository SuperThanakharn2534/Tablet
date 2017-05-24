package com.alignsolution.siamsmilemobileapplication.Adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alignsolution.siamsmilemobileapplication.Biz.Opportunity;
import com.alignsolution.siamsmilemobileapplication.DasboardActivity;
import com.alignsolution.siamsmilemobileapplication.OpportunityListActivity;
import com.alignsolution.siamsmilemobileapplication.R;

import java.util.ArrayList;

/**
 * Created by aligndev on 02-May-17.
 */

public class OpportunityListAdapter extends BaseAdapter {
    ArrayList<Opportunity> _opportunity;
    private LayoutInflater l_Inflater;
    private Context mCtx;

    public static class ViewHolder {
        TextView Name;
        TextView Id_card;
        TextView PhoneNumber;
        TextView Province;
        TextView E_Mail;
    }

    public OpportunityListAdapter(Context c, ArrayList<Opportunity> pOpportunityObject) {
        _opportunity = pOpportunityObject;
        l_Inflater = LayoutInflater.from(c);
        this.mCtx = c;
    }

    public int getCount() {
        return _opportunity.size();
    }

    @Override
    public Object getItem(int position) {
        return _opportunity.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DasboardListOpportunityAdapter.ViewHolder holder;
        String fullname;
        try {
            if (convertView == null) {


                convertView = l_Inflater.inflate(R.layout.activity_column_dasboard, null);
                holder = new DasboardListOpportunityAdapter.ViewHolder();
                holder.Name = (TextView) convertView.findViewById(R.id.Name);
                holder.Id_card = (TextView) convertView.findViewById(R.id.Id_card);
                holder.PhoneNumber = (TextView) convertView.findViewById(R.id.PhoneNumber);
                holder.Province = (TextView) convertView.findViewById(R.id.Province);
                holder.E_Mail  = (TextView) convertView.findViewById(R.id.E_Mail);

                convertView.setTag(holder);

            } else {
                holder = (DasboardListOpportunityAdapter.ViewHolder) convertView.getTag();
            }
            Opportunity oOpportunityObject = _opportunity.get(position);
            fullname = String.format("%s %s", oOpportunityObject.getFirstName(), oOpportunityObject.getLastName());
            holder.Name.setText(fullname);
            holder.Id_card.setText(oOpportunityObject.getCardNo());
            holder.PhoneNumber.setText(oOpportunityObject.getPhoneNumber1());
            holder.Province.setText(oOpportunityObject.getProvince());
            holder.E_Mail.setText(oOpportunityObject.getEmail());

            // color ListView
            if (position % 2 == 0) {

                convertView.setBackgroundResource(R.color.txtdata1);
            } else {
                convertView.setBackgroundResource(R.color.txtdata2);
            }

        } catch (Exception e) {
            Log.i("Err Log", "getView : " + Log.getStackTraceString(e));
        }
        return convertView;
    }
}

