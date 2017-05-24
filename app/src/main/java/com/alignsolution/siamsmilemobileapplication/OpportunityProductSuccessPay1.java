package com.alignsolution.siamsmilemobileapplication;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alignsolution.siamsmilemobileapplication.Adapter.MenuAdapter;
import com.alignsolution.siamsmilemobileapplication.Biz.MenuMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.OpportunityMGR;

/**
 * Created by aligndev on 4/11/2017.
 */

public class OpportunityProductSuccessPay1 extends AppCompatActivity  implements AdapterView.OnItemClickListener{
    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] planets;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    MenuMGR menuMGR = new MenuMGR();
    OpportunityMGR dataMGR = new OpportunityMGR();
    ListView MenuList;

    //calendate
    private TextView carlendar;
    private ImageButton  changeDate;

    private int year;
    private int month;
    private int day;
    static final int DATE_PICKER_ID = 1111;

    String itemNo;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunity_product_salecloss1);
        try {

            SetHeader("ผู้มุ่งหวัง/ปิดการขาย", false, false);
            SetMenu();
            SetData();
            SetCalendar();

           // itemNo = getIntent().getExtras().getString("itemNo");

            Button btnNext = (Button)findViewById(R.id.Next);
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getBaseContext(),OpportunityProductSuccessPay2.class));

                }
            });

            Button btCancle = (Button)findViewById(R.id.btCancle);
            btCancle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getBaseContext(),OpportunityDetailActivity.class));
                }
            });

            Button btBrack = (Button)findViewById(R.id.btBrack);
            btBrack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getBaseContext(),OppurunityProductStep1Activity.class);
                    //intent.putExtra("itemNo",itemNo.toString());
                    startActivity(intent);

                }
            });




        }catch (Exception e){
            Log.i("Err Log", "OpportunityProductSaleClossActivity : " + Log.getStackTraceString(e));
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void SetCalendar() {
        // date pickers AccidentDate
        carlendar = (TextView) findViewById(R.id.edtDate);

        changeDate= (ImageButton) findViewById(R.id.imbDate);
        // Get current date by calender
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // Show current date
        carlendar.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(day).append("/").append(month + 1).append("/")
                .append(year).append(" "));
        // ImageButton listener to show date picker dialog
        changeDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // On button click show datepicker dialog
                showDialog(DATE_PICKER_ID);

            }

        });

    }


    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case   DATE_PICKER_ID:

                return new DatePickerDialog(this, pickerListener, year, month,day);


        }
        return  null;
    }

    private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        @Override
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {

            year  = selectedYear;
            month = selectedMonth;
            day   = selectedDay;

            // Show selected date
            carlendar.setText(new StringBuilder()
                    .append(day).append("/").append(month + 1).append("/").append(year)
                    .append(" "));

        }
    };



    public void SetData() {



//        listView = (ListView) findViewById(R.id.opportunitylist);
//        ArrayList<Opportunity> oOpportunity = dataMGR.SelectData(this);
//        OpportunityProductSaleClossAdapter adap = new OpportunityProductSaleClossAdapter(OpportunityProductSuccessPay1.this, oOpportunity);
//        listView.setAdapter(adap);

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

        MenuAdapter menuAdapter = new MenuAdapter(OpportunityProductSuccessPay1.this,
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
