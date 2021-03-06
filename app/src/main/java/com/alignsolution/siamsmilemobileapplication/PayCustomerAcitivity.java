package com.alignsolution.siamsmilemobileapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

//import com.alignsolution.siamsmilemobileapplication.Adapter.ClaimCustomerActivity_Adapter;
import com.alignsolution.siamsmilemobileapplication.Adapter.DasboardListOpportunityAdapter;
import com.alignsolution.siamsmilemobileapplication.Adapter.MenuAdapter;
//import com.alignsolution.siamsmilemobileapplication.Adapter.PayCustomerActivity_Adapter;
import com.alignsolution.siamsmilemobileapplication.Biz.MenuMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.Opportunity;
import com.alignsolution.siamsmilemobileapplication.Biz.OpportunityMGR;

import java.util.ArrayList;

/**
 * Created by aligndev on 04-May-17.
 */

public class PayCustomerAcitivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] planets;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    MenuMGR menuMGR = new MenuMGR();
    OpportunityMGR dataMGR = new OpportunityMGR();
    ListView MenuList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_customer);
        try {

            SetHeader("จัดเก็บเบี้ยค้างชำระ", false, false);
            SetMenu();
            SetData();

//        final ListView listView = (ListView) findViewById(R.id.DataList);
//
//        // Defined Array values to show in ListView
//        String[] values = new String[] {" ณเดช  รักดี                            1033445565986                0877438884                        กรุงเทพฯ           test1@gmail.com",
//            " สมชาติ  นาดี                           1300112255990                0814432244                         เชียงใหม่          test2@gmail.com",
//                    " สมหญิง  เงินนาค                       1300112255990                0814432244                        สงขลา            test3@gmail.com"
//        };


        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.activity_list_item, android.R.id.text1, values){
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent){
//                /// Get the Item from ListView
//                View view = super.getView(position, convertView, parent);
//
//                TextView tv = (TextView) view.findViewById(android.R.id.text1);
//
//                // Set the text size 25 dip for ListView each item
//                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,16);
//
//
//                //set Color ListView
//                if (position % 2 == 0) {
//
//                    view.setBackgroundColor(Color.parseColor("#A7EEFF"));
//                } else {
//                    view.setBackgroundColor(Color.parseColor("#B9E2FA"));
//                }
//
//
//                // Return the view
//                return view;
//            }
//        };
//        // Assign adapter to ListView
//        listView.setAdapter(adapter);



        }catch (Exception e){}
    }
    public void SetData() {

        listView = (ListView) findViewById(R.id.DataList);
        ArrayList<Opportunity> oOpportunity = dataMGR.SelectData(this);
        DasboardListOpportunityAdapter adap = new DasboardListOpportunityAdapter(PayCustomerAcitivity.this, oOpportunity);
        listView.setAdapter(adap);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                int itemPosition = position;
//                Intent myIntent = new Intent(getBaseContext(), OppurunityProductStep1Activity.class);
//                startActivity(myIntent);
//            }
//        });

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Item Click Listener
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {

                        // ListView Clicked item index
                        int itemPosition     = position;
                        switch (position){
                            case  0:
                                //Toast.makeText(activity," ข้อมูลผลิตภัณฑ์/โปรโมชั่น ", Toast.LENGTH_SHORT).show();
                                //myIntent =new Intent(activity,Activity_Opportunity2.class);
                                Intent myIntent = new Intent(getBaseContext(),Pay2Activity.class);
                                startActivity(myIntent);
                                break;
                            case  1:
                                //Toast.makeText(activity," ข้อมูลผลิตภัณฑ์/โปรโมชั่น ", Toast.LENGTH_SHORT).show();
                                //myIntent =new Intent(activity,Activity_Opportunity2.class);
                                //Intent myIntent = new Intent(getBaseContext(),LoginActivity.class);
                                // activity.startActivity(myIntent);

                                break;
                            default:
                                break;

                        }
                    }

                });

            }

        });





    }

    public void selectItem(int position) {
        menuMGR.CustomerMenuSelect(position, this);
    }

    public void SetMenu() {

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        planets = getResources().getStringArray(R.array.CustomerMenu);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planets));
        listView.setOnItemClickListener(this);

        //Close and open sideBar
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MenuAdapter menuAdapter = new MenuAdapter(PayCustomerAcitivity.this,
                menuMGR.MenuText(), menuMGR.MenuImg());
        MenuList = (ListView) findViewById(R.id.list);
        MenuList.setAdapter(menuAdapter);


    }

    public void SetHeader(String TextTitle, boolean ShowAddButton, boolean ShowNotify) {

        getSupportActionBar().setDisplayOptions(getSupportActionBar().getDisplayOptions()
                | ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.activity_header);

        TextView Title = (TextView) getSupportActionBar().getCustomView().findViewById(R.id.txtTitle);
        Title.setText(TextTitle);

        if (!ShowAddButton) {
            ImageButton btnAdd = (ImageButton) getSupportActionBar().getCustomView().findViewById(R.id.btnAdd);
            btnAdd.setVisibility(View.GONE);
        }

        if (!ShowNotify) {

            ImageView imgNotify = (ImageView) getSupportActionBar().getCustomView().findViewById(R.id.imgnotify);
            imgNotify.setVisibility(View.GONE);
        }


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this,planets[position]+ "   was selected ", Toast.LENGTH_SHORT).show();

        selectItem(position);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
