package com.example.dell.cihuo0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

public class FoodDescActivity extends Activity {
    private ImageView imageViewback ;
    private TextView imageViewxiadan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_desc);
        imageViewback = (ImageView)findViewById(R.id.Iv_fooddescactvy_back);
        imageViewxiadan = (TextView)findViewById(R.id.Tv_fooddescacty_xiandan);
        imageViewback.setOnClickListener(mBackListener);
        imageViewxiadan.setOnClickListener(mXiadanListener);

    }
    AdapterView.OnClickListener mBackListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Utils.flag = 2;
            Intent intent = new Intent(FoodDescActivity.this,MainActivity.class);
            startActivity(intent);
        }
    };
    AdapterView.OnClickListener mXiadanListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(FoodDescActivity.this,XiadanActivity.class);
            startActivity(intent);
        }
    };
}
