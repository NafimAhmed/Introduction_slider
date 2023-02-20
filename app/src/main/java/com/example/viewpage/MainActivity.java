package com.example.viewpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ViewPager mSLiderViewPager;
    LinearLayout mDotLinearLayout;
    Button backbtn,nextbtn, skipbtn;

    TextView[] dots;
    ViewPageAdapter viewPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backbtn=findViewById(R.id.backbtn);
        nextbtn=findViewById(R.id.nextbtn);
        skipbtn=findViewById(R.id.skipbtn);



        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getItem(0)>0){

                    mSLiderViewPager.setCurrentItem(getItem(-1),true);

                }



            }
        });


        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getItem(0)<3){
                    mSLiderViewPager.setCurrentItem(getItem(1),true);

                }else{
                    Intent intent=new Intent(MainActivity.this,MainScreen.class);
                    startActivity(intent);
                    finish();
                }

            }
        });


        skipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,MainScreen.class);
                startActivity(intent);
                finish();

            }
        });


        mSLiderViewPager=(ViewPager) findViewById(R.id.SliderViewPager);
        mDotLinearLayout=(LinearLayout) findViewById(R.id.indicatorLayout);

        viewPageAdapter=new ViewPageAdapter(this);
        mSLiderViewPager.setAdapter(viewPageAdapter);

        setUpIndicator(0);
        mSLiderViewPager.addOnPageChangeListener(viewListener);

    }


    public void setUpIndicator(int position){

        dots=new TextView[4];

        mDotLinearLayout.removeAllViews();




        for(int i=0;i<dots.length;i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.purple_200));
            mDotLinearLayout.addView(dots[i]);
        }


        dots[position].setTextColor(getResources().getColor(R.color.white));






    }


    ViewPager.OnPageChangeListener viewListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            setUpIndicator(position);

            if(position>0){
                backbtn.setVisibility(View.VISIBLE);
            }else{
                backbtn.setVisibility(View.GONE);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    private int getItem(int i){
        return mSLiderViewPager.getCurrentItem()+i;
    }




}