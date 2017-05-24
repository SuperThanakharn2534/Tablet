package com.alignsolution.siamsmilemobileapplication;

import android.app.ActionBar;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import android.widget.Spinner;
import android.widget.TextView;


import com.alignsolution.siamsmilemobileapplication.Adapter.MenuAdapter;
import com.alignsolution.siamsmilemobileapplication.Adapter.OtherMap_Adapter;
import com.alignsolution.siamsmilemobileapplication.Biz.MenuMGR;
import com.alignsolution.siamsmilemobileapplication.Biz.OpportunityMGR;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * Created by aligndev on 19-Apr-17.
 */

public class OtherMap extends AppCompatActivity  implements AdapterView.OnItemClickListener,OnMapReadyCallback{

    private DrawerLayout drawerLayout;
    private ListView opportunitylist;
    private String[] planets;
    public DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    MenuMGR menuMGR = new MenuMGR();
    OpportunityMGR dataMGR = new OpportunityMGR();
    ListView MenuList;


    //spinner
    private Spinner list_type;
    private ArrayList<String> Data = new ArrayList<String>();
    //Map
    private GoogleMap mMap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        try {


            SetHeader("สอบถามข้อมูลเพิ่มเติม",false,false);
            SetMenu();
            SetSpinner();

            //map
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        }catch (Exception e){}


    }

    public  void  SetSpinner(){
        list_type = (Spinner) findViewById(R.id.spinner3);
        createList();
        // Spinner   Adapter ตัวแรก
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, Data);
        list_type.setAdapter(adapter);

    }

    public void selectItem(int position) {
        menuMGR.CustomerMenuSelect(position, this);
    }

    public void SetMenu() {

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        planets = getResources().getStringArray(R.array.CustomerMenu);
        opportunitylist = (ListView) findViewById(R.id.list);
        opportunitylist.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planets));
        opportunitylist.setOnItemClickListener(this);

        //Close and open sideBar
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        MenuAdapter menuAdapter = new MenuAdapter(OtherMap.this,
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

    private void createList() {
        Data.add("เลือก จังหวัดที่ต้องการค้นหา");
        Data.add("กรุงเทพมหานคร ");
        Data.add("กระบี่ ");
        Data.add("กาญจนบุรี ");
        Data.add("กาฬสินธุ์ ");
        Data.add("กำแพงเพชร ");
        Data.add("ขอนแก่น ");
        Data.add("จันทบุรี ");
        Data.add("ฉะเชิงเทรา ");
        Data.add("ชลบุรี ");
        Data.add("ชัยนาท ");
        Data.add("ชัยภูมิ ");
        Data.add("ชุมพร ");
        Data.add("เชียงราย ");
        Data.add("เชียงใหม่ ");
        Data.add("ตรัง ");
        Data.add("ตราด ");
        Data.add("ตาก ");
        Data.add("นครนายก ");
        Data.add("นครปฐม ");
        Data.add("นครพนม ");
        Data.add("นครราชสีมา ");
        Data.add("นครศรีธรรมราช ");
        Data.add("นครสวรรค์ ");
        Data.add("นนทบุรี ");
        Data.add("นราธิวาส ");
        Data.add("น่าน ");
        Data.add("บึงกาฬ ");
        Data.add("บุรีรัมย์ ");
        Data.add("ปทุมธานี ");
        Data.add("ประจวบคีรีขันธ์ ");
        Data.add("ปราจีนบุรี ");
        Data.add("ปัตตานี ");
        Data.add(" พระนครศรีอยุธยา ");
        Data.add("พังงา ");
        Data.add("พัทลุง ");
        Data.add("พิจิตร ");
        Data.add("พิษณุโลก ");
        Data.add("เพชรบุรี ");
        Data.add("เพชรบูรณ์ ");
        Data.add("แพร่ ");
        Data.add("พะเยา ");
        Data.add("ภูเก็ต ");
        Data.add("มหาสารคาม ");
        Data.add("มุกดาหาร ");
        Data.add("แม่ฮ่องสอน ");
        Data.add("ยะลา  ");
        Data.add("ยโสธร  ");
        Data.add("ร้อยเอ็ด  ");
        Data.add("ระนอง  ");
        Data.add("ระยอง  ");
        Data.add("ราชบุรี  ");
        Data.add("ลพบุรี  ");
        Data.add("ลำปาง  ");
        Data.add("ลำพูน  ");
        Data.add("เลย  ");
        Data.add("ศรีสะเกษ  ");
        Data.add("สกลนคร  ");
        Data.add("สงขลา  ");
        Data.add("สตูล  ");
        Data.add("สมุทรปราการ  ");
        Data.add("สมุทรสงคราม  ");
        Data.add("สมุทรสาคร  ");
        Data.add("สระแก้ว  ");
        Data.add("สระบุรี   ");
        Data.add("สิงห์บุรี  ");
        Data.add("สุโขทัย  ");
        Data.add("สุพรรณบุรี  ");
        Data.add("สุราษฎร์ธานี  ");
        Data.add("สุรินทร์  ");
        Data.add("หนองคาย  ");
        Data.add("หนองบัวลำภู  ");
        Data.add("อ่างทอง  ");
        Data.add("อุดรธานี  ");
        Data.add("อุทัยธานี  ");
        Data.add("อุตรดิตถ์  ");
        Data.add("อุบลราชธานี  ");
        Data.add("อำนาจเจริญ ");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in thailand and move the camera
        LatLng Bangkok = new LatLng(13.75633,100.50177);
        LatLng Samootphakarn = new LatLng(13.59556, 100.60722);
        LatLng Siam = new LatLng(13.74609,100.53468);
        LatLng Morchit = new LatLng(13.804159,100.552382);
        LatLng Saimai = new LatLng(13.906578,100.656182);


        mMap.addMarker(new MarkerOptions().position(Bangkok).title("กรุงเทพมหานคร"));
        mMap.addMarker(new MarkerOptions().position(Samootphakarn).title("สมุทรปราการ"));
        mMap.addMarker(new MarkerOptions().position(Siam).title("สถานี สยาม"));
        mMap.addMarker(new MarkerOptions().position(Morchit).title("สถานี  หมอชิต"));
        mMap.addMarker(new MarkerOptions().position(Saimai).title("สายไหม"));

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Saimai,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Morchit,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Siam,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Samootphakarn,10));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Bangkok,10));
        mMap.getUiSettings().setZoomControlsEnabled(true);



    }

}
