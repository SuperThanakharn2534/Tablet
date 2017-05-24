package com.alignsolution.siamsmilemobileapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

//import com.alignsolution.siamsmilemobileapplication.Adapter.ClaimStep2Activity_Adapter;
import com.alignsolution.siamsmilemobileapplication.Adapter.MenuAdapter;
import com.alignsolution.siamsmilemobileapplication.Biz.MenuMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.OpportunityMGR;

/**
 * Created by aligndev on 18-Apr-17.
 */

public class ClaimStep2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] planets;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    MenuMGR menuMGR = new MenuMGR();
    OpportunityMGR dataMGR = new OpportunityMGR();
    ListView MenuList;
//    private FloatingActionButton fab;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claim_step_2);
        try{
            SetHeader("รับเรื่องสินไหม", false, true);
            SetMenu();
            SetData();




        }catch (Exception e){}
    }
   public void SetData(){

       Button btNext = (Button) findViewById(R.id.btNext);
       btNext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent it = new Intent(getBaseContext(),ClaimStep3Activity.class);
               startActivity(it);
           }
       });

       Button btBrack = (Button) findViewById(R.id.btBrack);
       btBrack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent it = new Intent(getBaseContext(),ClaimStep1Activity.class);
               startActivity(it);
           }
       });

       Button btCancle = (Button) findViewById(R.id.btCancle);
       btCancle.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent it = new Intent(getBaseContext(),ClaimCustomerAcitivity.class);
               startActivity(it);
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

        MenuAdapter menuAdapter = new MenuAdapter(ClaimStep2Activity.this,
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
