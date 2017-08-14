package com.example.dell.cihuo0;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2016/11/3.
 */

public class NomoneyFragment extends Fragment {
    private String descs[] = new String[]{"五芳斋抹茶夹心麻薯糕点2盒*200g传统特产零食小吃糯米点心"};
    private String prices[] = new String[]{"￥24.00"};
    private int[] imageIds = new int[]{R.drawable.food4};
    private Activity orders_activity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view ;
        if(imageIds.length==0){
            view = inflater.inflate(R.layout.noorders_layout, container, false);
            return view;
        }
        view = inflater.inflate(R.layout.fragment_nomoney, container, false);
        List<Map<String,Object>> listItems = new ArrayList<Map<String, Object>>();
        for(int i = 0;i<imageIds.length;i++){
            Map<String,Object> listItem = new HashMap<String,Object>();
            listItem.put("image",imageIds[i]);
            listItem.put("desc",descs[i]);
            listItem.put("price",prices[i]);
            listItems.add(listItem);
        }
        orders_activity = this.getActivity();
        Context current_context = orders_activity.getApplicationContext();
        SimpleAdapter simpleAdapter = new SimpleAdapter(current_context,listItems,R.layout.nomoney_item,
                new String[]{"image","desc","price"},new int[]{R.id.Iv_nomoneyOrderitem_image,R.id.Tv_nomoneyOrderitem_desc,R.id.Tv_nomoneyOrderitem_price});
        GridView gridView = (GridView)view.findViewById(R.id.Gv_nomoneyfragment_contener);
        gridView.setAdapter(simpleAdapter);
        return view;
    }
}
