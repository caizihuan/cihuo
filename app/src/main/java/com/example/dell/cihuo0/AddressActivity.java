package com.example.dell.cihuo0;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressActivity extends Activity {
    private String names[]=new String []{"猪头","菜菜","玥玥"};
    private String address[] = new String[]{"河北省石家庄市 南二环东路20号河北师范大学","河北省石家庄市 南二环东路20号河北师范大学","河北省石家庄市 南二环东路20号河北师范大学"};
    private String calls[] = new String[]{"15232123333","15232123333","15232123333"};
    private ImageView imageView_back;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        /*checkBox = (CheckBox)findViewById(R.id.Cb_addressitem_moren);
        textView = (TextView)findViewById(R.id.Tt_addressitem_moren);*/
        imageView_back = (ImageView)findViewById(R.id.backto_Myfragment1);
        //为ListView绑定simpleAdapter，获取数据
        listView = (ListView)findViewById(R.id.Lv_address);
        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
        for (int i= 0;i<names.length;i++){
            Map<String,Object> listItem = new HashMap<String,Object>();
            listItem.put("name",names[i]);
            listItem.put("address",address[i]);
            listItem.put("call",calls[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listItems,R.layout.address_item,
                new String[]{"name","call","address"},new int[]{R.id.Tv_addressitem_name,R.id.Tv_addressitem_call,R.id.Tv_addressitem_address});
        listView.setAdapter(simpleAdapter);
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //转到我的资料页面
                Utils.flag = 3;
                Intent intent = new Intent();
                intent.setClass(AddressActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        /*//复选按钮添加点击事件
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b==true){
                    checkBox.setBackgroundColor(0xFFFFCACA);
                    textView.setText("默认地址");
                    textView.setTextColor(0xFFFC5E5E);
                }else{
                    checkBox.setBackgroundColor(0x000000);
                    textView.setText("设为默认");
                    textView.setTextColor(0x6c6c6c);
                }
            }
        });*/
    }
}
