package com.alignsolution.siamsmilemobileapplication;

import android.app.ActionBar;
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

import com.alignsolution.siamsmilemobileapplication.Adapter.MenuAdapter;
//import com.alignsolution.siamsmilemobileapplication.Adapter.NoticeNewsActivity_Adapter;
import com.alignsolution.siamsmilemobileapplication.Biz.OpportunityMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.OppurtunityProduct_MGR;
import com.alignsolution.siamsmilemobileapplication.Biz.MenuMGR;

/**
 * Created by aligndev on 18-Apr-17.
 */

public class NoticeNewsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] planets;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    MenuMGR menuMGR = new MenuMGR();
    OpportunityMGR dataMGR = new OpportunityMGR();
    ListView MenuList;
    OppurtunityProduct_MGR mainmenu = new OppurtunityProduct_MGR() ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_news);
        try {


            SetHeader("ประกาศ / ข้อมูลการแข่งขัน", false, false);
            SetMenu();
            SetData();


        }catch (Exception e){}


    }

     public  void  SetData(){

         // Get ListView object from xml 1
         final ListView listView = (ListView) findViewById(R.id.newsList2);

         // Defined Array values to show in ListView
         String[] values = new String[] {"งานประจำปี 2560 บริษัท สยามสไมล์โบรกเกอร์(ประเทศไทย)จำกัด"
                 ,"งานสโมสรนักขายเกรด A ครั้งที่1"
                 ,"Pre Suppervisor's Camp 2016"
                 ,"งานสโมสรนักขายเกรด A ครั้งที่2"
                 ,"Pre Suppervisor's Camp 2016"
                 ,"งานสโมสรนักขายเกรด A ครั้งที่3"
                 ,"Pre Suppervisor's Camp 2016"};

         // Define a new Adapter
         // First parameter - Context
         // Second parameter - Layout for the row
         // Third parameter - ID of the TextView to which the data is written
         // Forth - the Array of data

         ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                 android.R.layout.activity_list_item, android.R.id.text1, values){
             @Override
             public View getView(int position, View convertView, ViewGroup parent){
                 /// Get the Item from ListView
                 View view = super.getView(position, convertView, parent);

                 TextView tv = (TextView) view.findViewById(android.R.id.text1);

                 // Set the text size 25 dip for ListView each item
                 tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);

                 if(position %2 == 1)
                 {
                     // Set a background color for ListView regular row/item
                     view.setBackgroundResource(R.color.txtdata1);
                 }
                 else
                 {
                     // Set the background color for alternate row/item
                     view.setBackgroundResource(R.color.txtdata2);
                 }

                 // Return the view
                 return view;
             }
         };
         // Assign adapter to ListView
         listView.setAdapter(adapter2);

         //////////////////////////////////////

         // Get ListView object from xml 2
         final ListView listView3 = (ListView) findViewById(R.id.newsList3);

         // Defined Array values to show in ListView
         String[] values3 = new String[] {"ชื่อ - นามสกุล  : คุณกนก  มาดี  เบอร์โทร : 0912345678"
                 ,"ชื่อ - นามสกุล  :  คุณกันยา  เดือนงาม  เบอร์โทร : 0899914466"
                 ,"ชื่อ - นามสกุล  :  คุณนพดล  มากมี  เบอร์โทร : 0834235577"};

         // Define a new Adapter
         // First parameter - Context
         // Second parameter - Layout for the row
         // Third parameter - ID of the TextView to which the data is written
         // Forth - the Array of data

         ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
                 android.R.layout.activity_list_item, android.R.id.text1, values3){
             @Override
             public View getView(int position, View convertView, ViewGroup parent){
                 /// Get the Item from ListView
                 View view = super.getView(position, convertView, parent);

                 TextView tv = (TextView) view.findViewById(android.R.id.text1);

                 // Set the text size 25 dip for ListView each item
                 tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);

                 if(position %2 == 1)
                 {
                     // Set a background color for ListView regular row/item
                     view.setBackgroundResource(R.color.txtdata1);
                 }
                 else
                 {
                     // Set the background color for alternate row/item
                     view.setBackgroundResource(R.color.txtdata2);
                 }

                 // Return the view
                 return view;
             }
         };
         // Assign adapter to ListView
         listView3.setAdapter(adapter3);






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

        MenuAdapter menuAdapter = new MenuAdapter(NoticeNewsActivity.this,
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
