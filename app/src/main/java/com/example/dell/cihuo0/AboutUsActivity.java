package com.example.dell.cihuo0;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutUsActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        ImageView back_imageView = (ImageView)findViewById(R.id.backto_Myfragment);
        back_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //转到我的资料页面
                Utils.flag = 3;
                Intent intent = new Intent();
                intent.setClass(AboutUsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
