package com.alignsolution.siamsmilemobileapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.alignsolution.siamsmilemobileapplication.Adapter.MenuAdapter;
import com.alignsolution.siamsmilemobileapplication.Adapter.OpportunityListAdapter;
import com.alignsolution.siamsmilemobileapplication.Biz.Opportunity;
//import com.alignsolution.siamsmilemobileapplication.Biz.OpportunityListMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.OpportunityMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.OppurtunityProduct_MGR;
import com.alignsolution.siamsmilemobileapplication.Biz.MenuMGR;

import java.util.ArrayList;

/**
 * Created by aligndev on 4/9/2017.
 */

public class OpportunityDetailActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private DrawerLayout drawerLayout;
    private ListView opportunitydatalist;
    private String[] planets;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    MenuMGR menuMGR = new MenuMGR();
    OppurtunityProduct_MGR dataMGR = new OppurtunityProduct_MGR();
    ListView MenuList;
   // OppurtunityProduct_MGR inproduct_detail = new OppurtunityProduct_MGR() ;
    private Spinner dataspiner;
    private ArrayList<String> textlist = new ArrayList<String>();
    EditText txtFirstName,txtLastName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opportunity_detail);
       try {


        SetHeader("เพิ่มลูกค้าผู้มุ่งหวังใหม่",false,false);
        SetMenu();
        SetData();
        createview();
        SetSpinner();

           txtFirstName =(EditText)findViewById(R.id.txtFirstName);
           txtLastName = (EditText)findViewById(R.id.txtLastName );
//        final EditText txtOpportunityNo = (EditText)findViewById(R.id.txtOpportunityNo);
//        final EditText txtCardNo = (EditText) findViewById(R.id.txtCardNo);
//        final EditText txtPhoneNumber1=(EditText)findViewById(R.id.txtPhoneNumber1);
//        final EditText txtPhoneNumeber2=(EditText)findViewById(R.id.txtPhoneNumeber2);
//        final EditText txtemail = (EditText)findViewById(R.id.txtemail);
//        final EditText txtLineid = (EditText)findViewById(R.id.txtLineid);
//        final EditText txtaddress=(EditText)findViewById(R.id.txtaddress);
//        final Spinner  Province =(Spinner)findViewById(R.id.spinner);
//        final EditText txtcomment=(EditText)findViewById(R.id.txtcomment);

           Button cmd = (Button) findViewById(R.id.btclick);
        cmd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adddata();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),OppurunityProductStep1Activity.class);
                startActivity(intent);
            }
        });


//
//
//    // Defined Array values to show in ListView
//        String[] values = new String[] {"1234567890123     คุณสมชาย ศรีสุข     0899911234     กทม     Somchaisresook@gmail.com     100%"
//                ,"1234567890123     คุณสมชาย ศรีสุข     0899911234     กทม     Somchaisresook@gmail.com     20%"
//                ,"1234567890123     คุณสมชาย ศรีสุข     0899911234     กทม     Somchaisresook@gmail.com     30%"
//                ,"1234567890123     คุณสมชาย ศรีสุข     0899911234     กทม     Somchaisresook@gmail.com     90%"
//                ,"1234567890123     คุณสมชาย ศรีสุข     0899911234     กทม     Somchaisresook@gmail.com     80%"
//                ,"1234567890123     คุณสมชาย ศรีสุข     0899911234     กทม     Somchaisresook@gmail.com     50%" };
//
//    // Define a new Adapter
//    // First parameter - Context
//    // Second parameter - Layout for the row
//    // Third parameter - ID of the TextView to which the data is written
//    // Forth - the Array of data
//
//    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//            android.R.layout.activity_list_item, android.R.id.text1, values)
//    {
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent){
//            /// Get the Item from ListView
//            View view = super.getView(position, convertView, parent);
//
//            TextView tv = (TextView) view.findViewById(android.R.id.text1);
//            // Set the text size 25 dip for ListView each item
//            tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,18);
//
//            // color ListView
//            if (position % 2 == 0) {
//
//                view.setBackgroundColor(Color.parseColor("#A7EEFF"));
//            } else {
//                view.setBackgroundColor(Color.parseColor("#B9E2FA"));
//            }
//
//            // Return the view
//            return view;
//        }
//    };
//
//
//
//    // Assign adapter to ListView
//        opportunitydatalist.setAdapter(adapter);
//
//    // ListView Item Click Listener
//        opportunitydatalist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view,
//        int position, long id) {
//
//            // ListView Clicked item index
//            int itemPosition     = position;
//            String itemNo = String.valueOf(itemPosition);
//
//            inproduct_detail.OpenPromotion(itemNo ,(Activity) view.getContext());
//
//        }
//
//    });
//

       }catch (Exception e){}

}

   public  void adddata(){
       //Opportuni opportunityListMGR = new OpportunityListMGR();
       OpportunityMGR opportunityMGR = new OpportunityMGR();
       Opportunity opportunity=new Opportunity();
       boolean result;
       opportunity.setFirstName(txtFirstName.getText().toString());
       opportunity.setLastName(txtLastName.getText().toString());
//                opportunity.setOpportunityNo(txtOpportunityNo.getText().toString());
//                opportunity.setCardNo(txtCardNo.getText().toString());
//                opportunity.setPhoneNumber1(txtPhoneNumber1.getText().toString());
//                opportunity.setPhoneNumber2(txtPhoneNumeber2.getText().toString());
//                opportunity.setEmail(txtemail.getText().toString());
//                opportunity.setLineId(txtLineid.getText().toString());
//                opportunity.setAddress(txtaddress.getText().toString());

       result  = opportunityMGR.InsertData(opportunity,getBaseContext());
       Log.i("Opp_InsertData","Show_Result = "+String.valueOf(result));

       //Intent it2 = new Intent(getBaseContext(),Nav_Activity.class);
       Intent it2 = new Intent(getBaseContext(),OpportunityListActivity.class);
       startActivity(it2);

   }

   public  void SetSpinner(){

       dataspiner = (Spinner) findViewById(R.id.spinner);
       // Adapter ตัวแรก selectlist
       ArrayAdapter<String> adapterpovince = new ArrayAdapter<String>(this,
               android.R.layout.simple_dropdown_item_1line, textlist);
       dataspiner.setAdapter(adapterpovince);

   }

    public void SetData() {

        opportunitydatalist = (ListView) findViewById(R.id.opportunitydatalist);
        ArrayList<Opportunity> oOpportunity = dataMGR.SelectData(this);
        OpportunityListAdapter adap = new OpportunityListAdapter(OpportunityDetailActivity.this, oOpportunity);
        opportunitydatalist.setAdapter(adap);
        opportunitydatalist.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                int itemPosition = position;
                Intent myIntent = new Intent(getBaseContext(), OppurunityProductStep1Activity.class);
                startActivity(myIntent);
            }
        });

    }

    public void selectItem(int position) {
        menuMGR.CustomerMenuSelect(position, this);
    }

    public void SetMenu() {

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        planets = getResources().getStringArray(R.array.CustomerMenu);
        opportunitydatalist = (ListView) findViewById(R.id.list);
        opportunitydatalist.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planets));
        opportunitydatalist.setOnItemClickListener(this);

        //Close and open sideBar
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MenuAdapter menuAdapter = new MenuAdapter(OpportunityDetailActivity.this,
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
}
