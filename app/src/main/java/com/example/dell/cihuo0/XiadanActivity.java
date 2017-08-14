package com.example.dell.cihuo0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XiadanActivity extends Activity {
    private String[] descs = new String[]{"陶记鲜奶鸡蛋蒸蛋糕"};
    private String[] prices = new String[]{"¥29.9"};
    private int[] imageIds = new int[]{R.drawable.food4};
    private ImageView imageView_back;
    private ListView listView_fooddesc;
    private TextView textView_queren;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiadan);
        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
        for (int i= 0;i<prices.length;i++){
            Map<String,Object> listItem = new HashMap<String,Object>();
            listItem.put("image",imageIds[i]);
            listItem.put("desc",descs[i]);
            listItem.put("price",prices[i]);
            listItems.add(listItem);
        }
        //创建1个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this.getApplicationContext(),listItems,R.layout.xiadan_item,
                new String[]{"image","desc","price"},new int[]{R.id.image,R.id.desc,R.id.price});
        GridView gridView = (GridView) this.findViewById(R.id.GvfoodGridView);
        listView_fooddesc = (ListView)findViewById(R.id.Lv_xiadanqueren_fooddesc);
        //为ListView设置Adapter
        listView_fooddesc.setAdapter(simpleAdapter);
        getViews();
        setListeners();
    }
    public void getViews(){
        imageView_back = (ImageView)findViewById(R.id.backto_fooddescacty);

        textView_queren = (TextView)findViewById(R.id.Tv_xiadanacty_queren);
    }
    public void setListeners(){
        View.OnClickListener mListener = new backListener();
        imageView_back.setOnClickListener(mListener);
        textView_queren.setOnClickListener(new querenListener());
    }
    class backListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Utils.flag = 2;
            Intent intent = new Intent(XiadanActivity.this,MainActivity.class);
            startActivity(intent);
        }
    };
    class querenListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Utils.flag = 1;
            Intent intent = new Intent(XiadanActivity.this,MainActivity.class);
            startActivity(intent);
        }
    };
}
