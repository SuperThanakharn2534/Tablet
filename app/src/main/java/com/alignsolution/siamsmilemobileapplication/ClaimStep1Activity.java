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
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

//import com.alignsolution.siamsmilemobileapplication.Adapter.ClaimStep1Activity_Adapter;
import com.alignsolution.siamsmilemobileapplication.Adapter.MenuAdapter;
import com.alignsolution.siamsmilemobileapplication.Biz.MenuMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.OpportunityMGR;

import java.util.ArrayList;

/**
 * Created by aligndev on 04-May-17.
 */

public class ClaimStep1Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] planets;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    MenuMGR menuMGR = new MenuMGR();
    OpportunityMGR dataMGR = new OpportunityMGR();
    ListView MenuList;
    private FloatingActionButton fab;
    //dataspinner
    private Spinner dataspiner, dataspinerbrach;
    private ArrayList<String> textlist = new ArrayList<String>();
    private ArrayList<String> brach = new ArrayList<String>();

    //calendate
    private TextView Admission, AccidentDate;
    private ImageButton changeDateAccidentDate, changeDateAddmissionDate;

    private int year;
    private int month;
    private int day;
    static final int DATE_PICKER_ID_Adcident = 1111;
    static final int DATE_PICKER_ID_Admission = 2222;

    //    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_claim_step_1);
        try {
            SetHeader("รับเรื่องสินไหม", false, true);
            SetMenu();
            createview();
            SetProvince();
            createdBrach();
            SetBrach();
            SetCalendarAccident();
            SetCalendarAddmission();

//        ClaimStep1Activity_Adapter adapter1=new ClaimStep1Activity_Adapter(ClaimStep1Activity.this,
//                itemname, arrImg);
//        list1=(ListView)findViewById(R.id.drawerList);
//        list1.setAdapter(adapter1);

            // header
//        getSupportActionBar().setDisplayOptions(getSupportActionBar().getDisplayOptions()
//                | ActionBar.DISPLAY_SHOW_CUSTOM);
//        ImageView imageView = new ImageView(getSupportActionBar().getThemedContext());
//        imageView.setScaleType(ImageView.ScaleType.CENTER);
//        imageView.setImageResource(R.drawable.user);
//        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(
//                Gravity.RIGHT );
//        imageView.setLayoutParams(layoutParams);
//        getSupportActionBar().setCustomView(R.layout.activity_header);

            Button btNext = (Button) findViewById(R.id.btNext);
            btNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent it = new Intent(getBaseContext(), ClaimStep2Activity.class);
                    startActivity(it);
                }
            });

            Button btBrack = (Button) findViewById(R.id.btBrack);
            btBrack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent it = new Intent(getBaseContext(), ClaimPolicyDetailActivity.class);
                    startActivity(it);
                }
            });

            Button btCancle = (Button) findViewById(R.id.btCancle);
            btCancle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent it = new Intent(getBaseContext(), ClaimCustomerAcitivity.class);
                    startActivity(it);
                }
            });



        } catch (Exception e) {
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void SetCalendarAccident() {
        // date pickers AccidentDate
        AccidentDate = (TextView) findViewById(R.id.txtAccidentDate);

        changeDateAccidentDate = (ImageButton) findViewById(R.id.imbAccidentDate);
        // Get current date by calender
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // Show current date
        AccidentDate.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(day).append("/").append(month + 1).append("/")
                .append(year).append(" "));
        // ImageButton listener to show date picker dialog
        changeDateAccidentDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // On button click show datepicker dialog
                showDialog(DATE_PICKER_ID_Adcident);


            }

        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void SetCalendarAddmission() {
        // date pickers AccidentDate
        Admission = (TextView) findViewById(R.id.txtAdmission);

        changeDateAddmissionDate = (ImageButton) findViewById(R.id.AdmissionDate);
        // Get current date by calender
        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // Show current date
        Admission.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(day).append("/").append(month + 1).append("/")
                .append(year).append(" "));
        // ImageButton listener to show date picker dialog
        changeDateAddmissionDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // On button click show datepicker dialog
                showDialog(DATE_PICKER_ID_Admission);

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

        MenuAdapter menuAdapter = new MenuAdapter(ClaimStep1Activity.this,
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

    public void SetProvince() {

        dataspiner = (Spinner) findViewById(R.id.Province);
//        // Adapter ตัวแรก selectlist
//        ArrayAdapter<String> adapterpovince = new ArrayAdapter<String>(this,
//                android.R.layout.simple_dropdown_item_1line, textlist);
//        dataspiner.setAdapter(adapterpovince);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,textlist) {

            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);

                ((TextView) v).setTextSize(18);

                return v;

            }

            public View getDropDownView(int position, View convertView, ViewGroup parent) {

                View v = super.getDropDownView(position, convertView, parent);

                ((TextView) v).setGravity(Gravity.CENTER);

                return v;


            }

        };

        dataspiner.setAdapter(adapter);


    }

    public void SetBrach() {
        dataspinerbrach = (Spinner) findViewById(R.id.Branch);
        //dataspinerbrach.setGravity(Gravity.CENTER_HORIZONTAL);
        // Adapter ตัวแรก selectlist
//        ArrayAdapter<String> adapterbrach = new ArrayAdapter<String>(this,
//                android.R.layout.simple_dropdown_item_1line, brach);
        //dataspinerbrach.setAdapter(adapterbrach);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, brach) {

            public View getView(int position, View convertView, ViewGroup parent) {

                View v = super.getView(position, convertView, parent);

                ((TextView) v).setTextSize(18);

                return v;

            }

            public View getDropDownView(int position, View convertView, ViewGroup parent) {

                View v = super.getDropDownView(position, convertView, parent);

                ((TextView) v).setGravity(Gravity.CENTER);

                return v;

            }


        };

        dataspinerbrach.setAdapter(adapter);
    }






    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case   DATE_PICKER_ID_Adcident:

                return new DatePickerDialog(this, pickerListener, year, month,day);

            case  DATE_PICKER_ID_Admission:
                return new DatePickerDialog(this,pickerListener_Admistion , year,month,day);

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
            AccidentDate.setText(new StringBuilder()
                    .append(day).append("/").append(month + 1).append("/").append(year)
                    .append(" "));


//            // Show selected date
//            Output3.setText(new StringBuilder()
//                    .append(day).append("/").append(month + 1).append("/").append(year)
//                    .append(" "));

        }
    };


    private DatePickerDialog.OnDateSetListener pickerListener_Admistion = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        @Override
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {

            year  = selectedYear;
            month = selectedMonth;
            day   = selectedDay;

            // Show selected date
            Admission.setText(new StringBuilder()
                    .append(day).append("/").append(month + 1).append("/").append(year)
                    .append(" "));


//            // Show selected date
//            Output3.setText(new StringBuilder()
//                    .append(day).append("/").append(month + 1).append("/").append(year)
//                    .append(" "));

        }
    };




    private void createview() {
        textlist.add("เลือกจังหวัด");
        textlist.add("จังหวัด กรุงเทพมหานคร ");
        textlist.add("จังหวัด กระบี่ ");
        textlist.add("จังหวัด กาญจนบุรี ");
        textlist.add("จังหวัด กาฬสินธุ์ ");
        textlist.add("จังหวัด กำแพงเพชร ");
        textlist.add("จังหวัด ขอนแก่น ");
        textlist.add("จังหวัด จันทบุรี ");
        textlist.add("จังหวัด ฉะเชิงเทรา ");
        textlist.add("จังหวัด ชลบุรี ");
        textlist.add("จังหวัด ชัยนาท ");
        textlist.add("จังหวัด ชัยภูมิ ");
        textlist.add("จังหวัด ชุมพร ");
        textlist.add("จังหวัด เชียงราย ");
        textlist.add("จังหวัด เชียงใหม่ ");
        textlist.add("จังหวัด ตรัง ");
        textlist.add("จังหวัด ตราด ");
        textlist.add("จังหวัด ตาก ");
        textlist.add("จังหวัด นครนายก ");
        textlist.add("จังหวัด นครปฐม ");
        textlist.add("จังหวัด นครพนม ");
        textlist.add("จังหวัด นครราชสีมา ");
        textlist.add("จังหวัด นครศรีธรรมราช ");
        textlist.add("จังหวัด นครสวรรค์ ");
        textlist.add("จังหวัด นนทบุรี ");
        textlist.add("จังหวัด นราธิวาส ");
        textlist.add("จังหวัด น่าน ");
        textlist.add("จังหวัด บึงกาฬ ");
        textlist.add("จังหวัด บุรีรัมย์ ");
        textlist.add("จังหวัด ปทุมธานี ");
        textlist.add("จังหวัด ประจวบคีรีขันธ์ ");
        textlist.add("จังหวัด ปราจีนบุรี ");
        textlist.add("จังหวัด ปัตตานี ");
        textlist.add("จังหวัด พระนครศรีอยุธยา ");
        textlist.add("จังหวัด พังงา ");
        textlist.add("จังหวัด พัทลุง ");
        textlist.add("จังหวัด พิจิตร ");
        textlist.add("จังหวัด พิษณุโลก ");
        textlist.add("จังหวัด เพชรบุรี ");
        textlist.add("จังหวัด เพชรบูรณ์ ");
        textlist.add("จังหวัด แพร่ ");
        textlist.add("จังหวัด พะเยา ");
        textlist.add("จังหวัด ภูเก็ต ");
        textlist.add("จังหวัด มหาสารคาม ");
        textlist.add("จังหวัด มุกดาหาร ");
        textlist.add("จังหวัด แม่ฮ่องสอน ");
        textlist.add("จังหวัด ยะลา  ");
        textlist.add("จังหวัด ยโสธร  ");
        textlist.add("จังหวัด ร้อยเอ็ด  ");
        textlist.add("จังหวัด ระนอง  ");
        textlist.add("จังหวัด ระยอง  ");
        textlist.add("จังหวัด ราชบุรี  ");
        textlist.add("จังหวัด ลพบุรี  ");
        textlist.add("จังหวัด ลำปาง  ");
        textlist.add("จังหวัด ลำพูน  ");
        textlist.add("จังหวัด เลย  ");
        textlist.add("จังหวัด ศรีสะเกษ  ");
        textlist.add("จังหวัด สกลนคร  ");
        textlist.add("จังหวัด สงขลา  ");
        textlist.add("จังหวัด สตูล  ");
        textlist.add("จังหวัด สมุทรปราการ  ");
        textlist.add("จังหวัด สมุทรสงคราม  ");
        textlist.add("จังหวัด สมุทรสาคร  ");
        textlist.add("จังหวัด สระแก้ว  ");
        textlist.add("จังหวัด สระบุรี   ");
        textlist.add("จังหวัด สิงห์บุรี  ");
        textlist.add("จังหวัด สุโขทัย  ");
        textlist.add("จังหวัด สุพรรณบุรี  ");
        textlist.add("จังหวัด สุราษฎร์ธานี  ");
        textlist.add("จังหวัด สุรินทร์  ");
        textlist.add("จังหวัด หนองคาย  ");
        textlist.add("จังหวัด หนองบัวลำภู  ");
        textlist.add("จังหวัด อ่างทอง  ");
        textlist.add("จังหวัด อุดรธานี  ");
        textlist.add("จังหวัด อุทัยธานี  ");
        textlist.add("จังหวัด อุตรดิตถ์  ");
        textlist.add("จังหวัด อุบลราชธานี  ");
        textlist.add("จังหวัด อำนาจเจริญ ");
    }

    private  void  createdBrach(){
        brach.add("เลือกสาขา");
        brach.add("สาขา1");
        brach.add("สาขา2");
        brach.add("สาขา3");
        brach.add("สาขา4");
        brach.add("สาขา5");

    }

}
