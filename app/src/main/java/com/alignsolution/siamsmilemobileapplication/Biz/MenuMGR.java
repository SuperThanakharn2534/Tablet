package com.alignsolution.siamsmilemobileapplication.Biz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.alignsolution.siamsmilemobileapplication.OtherMenuActivity;
import com.alignsolution.siamsmilemobileapplication.ComplainAcitivity;
import com.alignsolution.siamsmilemobileapplication.ClaimCustomerAcitivity;
import com.alignsolution.siamsmilemobileapplication.EditPassworActivity;
import com.alignsolution.siamsmilemobileapplication.LoginActivity;
import com.alignsolution.siamsmilemobileapplication.NoticeMenuActivity;
import com.alignsolution.siamsmilemobileapplication.OpportunityListActivity;
import com.alignsolution.siamsmilemobileapplication.PayCustomerAcitivity;
import com.alignsolution.siamsmilemobileapplication.R;


/**
 * Created by aligndev on 4/4/2017.
 */



public class MenuMGR extends AppCompatActivity {


    private Intent myIntent;

    public  Integer[] MenuImg(){
        final Integer[] arrImg = {
                R.drawable.tl1,
                R.drawable.tl2,
                R.drawable.tl3,
                R.drawable.tl4,
                R.drawable.tl5,
                R.drawable.tl6,
                R.drawable.tl7,
                R.drawable.tl8
        };
        return arrImg ;
    }
    public    String[] MenuText(){

        String[] itemname ={
                "ผู้มุ่งหวัง/ปิดการขาย",
                "บริการเคลมสุขภาพ",
                "จัดเก็บเบี้ยค้างชำระ",
                "ประกาศ/ข้อมูลการแข่งขัน",
                "สอบถามข้อมูลเพิ่มเติม",
                "ข้อเสนอแนะ/ร้องเรียน",
                "แก้ไข  Password",
                "Log Out"
        };
        return  itemname ;
    }

      public  void  CustomerMenuSelect(int position , Activity activity ){

          Log.i("ERROR 0","SHOW ERROR");

          switch (position)
          {
              case  0:
                  Log.i("ERROR ","SHOW ERROR");
                  Toast.makeText(activity," ข้อมูลผลิตภัณฑ์/โปรโมชั่น ", Toast.LENGTH_SHORT).show();
                  myIntent =new Intent(activity,OpportunityListActivity.class);
                  activity.startActivity(myIntent);
                  break;
              case 1:
                  //loadSelection(position);
                  //Toast.makeText(this," บริการเครมสุขภาพ ON MOBILE ", Toast.LENGTH_SHORT).show();
                  myIntent =new Intent(activity,ClaimCustomerAcitivity.class);
                  activity.startActivity(myIntent);
                  break;

              case 2:
                  //Toast.makeText(this,"ชำระเบีย ", Toast.LENGTH_SHORT).show();
                  myIntent =new Intent(activity,PayCustomerAcitivity.class);
                  activity.startActivity(myIntent);
                  break;
              case 3:
                 // Toast.makeText(this,"ประกาศ / ข้อมูลการแข่งขัน", Toast.LENGTH_SHORT).show();
                  myIntent =new Intent(activity,NoticeMenuActivity.class);
                  activity.startActivity(myIntent);
                  break;
              case 4:
                  //Toast.makeText(this," ข้อมูลเพิ่มเติม", Toast.LENGTH_SHORT).show();
                  myIntent =new Intent(activity,OtherMenuActivity.class);
                  activity.startActivity(myIntent);
                  break;
              case 5:
              // Toast.makeText(this,"ข้อมูลเสนอแนะ / ร้องเรียน ", Toast.LENGTH_SHORT).show();
                  Log.i("ERROR 1","SHOW ERROR");
              myIntent =new Intent(activity,ComplainAcitivity.class);
                  Log.i("ERROR 2","SHOW ERROR");
                  activity.startActivity(myIntent);
              break;

              case 6:
                  // Toast.makeText(this,"แก้ไขรหัสผ่าน", Toast.LENGTH_SHORT).show();
                  myIntent =new Intent(activity,EditPassworActivity.class);
                  activity.startActivity(myIntent);
                  break;
              case 7:
                  //Toast.makeText(this," Log Out ", Toast.LENGTH_SHORT).show();
                  myIntent =new Intent(activity,LoginActivity.class);
                  activity.startActivity(myIntent);
                  break;

              default:
                  break;

          }

      }


}
