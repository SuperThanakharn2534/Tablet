package com.alignsolution.siamsmilemobileapplication;

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
import android.widget.ListView;
import android.widget.TextView;

//import com.alignsolution.siamsmilemobileapplication.Adapter.NoticeScoreActivity_Adapter;
import com.alignsolution.siamsmilemobileapplication.Biz.MenuMGR;

/**
 * Created by aligndev on 19-Apr-17.
 */

public class NoticeScoreActivity2 extends AppCompatActivity  {


    TextView textView;
    NoticeScoreActivity_Adpter adapter = new NoticeScoreActivity_Adpter(getApplicationContext());
    public Button button;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_score2);
        textView = (TextView) findViewById(R.id.textView145);
        button = (Button) findViewById(R.id.button35);






    }


}
