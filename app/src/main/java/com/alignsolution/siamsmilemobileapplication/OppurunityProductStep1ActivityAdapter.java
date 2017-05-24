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

import com.alignsolution.siamsmilemobileapplication.Biz.OppurtunityProduct_MGR;

/**
 * Created by aligndev on 4/10/2017.
 */

public class OppurunityProductStep1ActivityAdapter extends PagerAdapter   {
    public   int[] imgs = {R.drawable.person,R.drawable.group,R.drawable.car,R.drawable.person,R.drawable.group,R.drawable.car};
    private LayoutInflater inflater;
    private Context context;
    OppurtunityProduct_MGR open = new OppurtunityProduct_MGR();

    public OppurunityProductStep1ActivityAdapter(Context context){
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
        final View view = inflater.inflate(R.layout.activity_opportunity_product_step1_swipe,container,false);
        final ImageView img =(ImageView)view.findViewById(R.id.imageView5);
         final TextView tv = (TextView)view.findViewById(R.id.textView175);
         final  Button  btswipe = (Button)view.findViewById(R.id.btswipe);
                int  point = position ;
                final String itemNo = String.valueOf(point);

        btswipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context," แสดงข้อมูลที่เลือก ", Toast.LENGTH_SHORT).show();
                open.OpenPromotion(itemNo, (Activity) v.getContext());
            }
        });

        img.setImageResource(imgs[position]);
                tv.setText("ประกันบุคคล  ");
                if ( position == 0) {
                    tv.setText("ประกันบุคคล  ");

                } else if (position == 1) {
                    tv.setText("ประกันกลุ่ม  " );
                } else if (position == 2) {
                    tv.setText("ประกันรถยนต์  ");
                } else if (position == 3) {
                    tv.setText("ประกันบุคคล  ");
                } else if (position == 4) {
                    tv.setText("ประกันกลุ่ม  ");
                } else if (position == 5) {
                    tv.setText("ประกันรถยนต์  " );
                }

        container.addView(view);
        return  view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.invalidate();
    }



}


