package com.alignsolution.siamsmilemobileapplication;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alignsolution.siamsmilemobileapplication.Biz.Activity_Match_MGR;

/**
 * Created by aligndev on 19-Apr-17.
 */

public class NoticeScoreActivity_Adpter extends PagerAdapter {
    public   int[] imgs = {R.drawable.match01,R.drawable.match02,R.drawable.match01};
    private LayoutInflater inflater;
    private Context context;
    Activity_Match_MGR open = new Activity_Match_MGR();

    public NoticeScoreActivity_Adpter(Context context){
        this.context =context;

    }

    @Override
    public int getCount() {
        return imgs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout)object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.activity_notice_score2,container,false);
        final ImageView img =(ImageView)view.findViewById(R.id.imageView9);
        final TextView tv = (TextView)view.findViewById(R.id.textView145);
        final Button btswipe = (Button)view.findViewById(R.id.button35);
        int  point = position ;
        final String itemNo = String.valueOf(point);
        btswipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context," ข้อมูลผลิตภัณฑ์/โปรโมชั่น ", Toast.LENGTH_SHORT).show();
                open.OpenPromotion(itemNo, (Activity) v.getContext());
            }
        });
        img.setImageResource(imgs[position]);
        tv.setText("การแข่งขันประจำเดือน มกราคม  ");
        if ( position == 0) {
            tv.setText("การแข่งขันประจำเดือน มกราคม  ");

        } else if (position == 1) {
            tv.setText("สรุปผลการแข่งขันประจำเดือน กุมภาพันธ์ ");
        } else if (position == 2) {
            tv.setText("สรุปการแข่งขันประจำปี มีนาคม ");
        }

        container.addView(view);
        return  view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }
}
