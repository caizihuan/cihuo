package com.example.dell.cihuo0;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/10/29.
 */

public class FoodFragment extends Fragment {
    private String[] descs = new String[]{"【葡记 ","【葡记 巧克力蛋糕片","亿罗 手工法式马卡龙","五芳斋抹茶夹心麻薯","台湾老毛头紫芋头酥","陶记鲜奶鸡蛋蒸蛋糕"};
    private String[] prices = new String[]{"¥29.9","¥29.9","¥29.9","¥29.9","¥29.9","¥29.9"};
    private int[] imageIds = new int[]{R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5,R.drawable.food6};
    private Activity main_activity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View cuttentView = inflater.inflate(R.layout.fragment_food, container, false);
        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
        for (int i= 0;i<prices.length;i++){
            Map<String,Object> listItem = new HashMap<String,Object>();
            listItem.put("image",imageIds[i]);
            listItem.put("desc",descs[i]);
            listItem.put("price",prices[i]);
            listItems.add(listItem);
        }
        main_activity = this.getActivity();
        Context main_contex = main_activity.getApplicationContext();
        //创建1个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(main_contex,listItems,R.layout.simple_item,
                new String[]{"image","desc","price"},new int[]{R.id.image,R.id.desc,R.id.price});
        GridView gridView = (GridView) cuttentView.findViewById(R.id.GvfoodGridView);
        //为ListView设置Adapter
        gridView.setAdapter(simpleAdapter);
        //为商品绑定点击事件
        gridView.setOnItemClickListener(itemListener);
        // 为当前Fragment添加布局文件，并返回（view）
        return cuttentView;
    }
    AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent = new Intent(main_activity,FoodDescActivity.class);
            startActivity(intent);
        }
    };
}
