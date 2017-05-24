package com.alignsolution.siamsmilemobileapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alignsolution.siamsmilemobileapplication.Adapter.DasboardListOpportunityAdapter;
import com.alignsolution.siamsmilemobileapplication.Adapter.MenuAdapter;
//import com.alignsolution.siamsmilemobileapplication.Adapter.PayDetailActivity_Adapter;
import com.alignsolution.siamsmilemobileapplication.Biz.MenuMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.Opportunity;
import com.alignsolution.siamsmilemobileapplication.Biz.OpportunityMGR;

import java.util.ArrayList;

/**
 * Created by aligndev on 4/12/2017.
 */

public class PayDetailActivity extends AppCompatActivity implements AdapterView.OnItemClickListener  {
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
        setContentView(R.layout.activity_pay2);
        try {

            SetHeader("จัดเก็บเบี้ยค้างชำระ", false,false);
            SetMenu();
            SetData();




        } catch (Exception e) {}
    }

    public void SetData() {


        Button bntNext = (Button)findViewById(R.id.bntNext);
        bntNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),PayCustomerAcitivity.class));
            }
        });


        Button bntBrack = (Button)findViewById(R.id.bntBrack);
        bntBrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),Pay2Activity.class));
            }
        });


        Log.i("LogDATA","ClickButton Cancle");
        Button bntCancle = (Button)findViewById(R.id.bntCancle);
        bntCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),PayCustomerAcitivity.class));
            }
        });

        Log.i("LogDATA","ListView");
        listView = (ListView) findViewById(R.id.opportunitylist);
        ArrayList<Opportunity> oOpportunity = dataMGR.SelectData(this);
        DasboardListOpportunityAdapter adap = new DasboardListOpportunityAdapter(PayDetailActivity.this, oOpportunity);
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

        MenuAdapter menuAdapter = new MenuAdapter(PayDetailActivity.this,
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
