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

public class AllordersFragment extends Fragment {
    private GridView gridView_nomoney,gridView_nogive,gridView_noget,gridView_noestimate;
    private String descs_noestimate[] = new String[]{};
    private String prices_noestimate[] = new String[]{};
    private int[] imageIds_noestimate = new int[]{};
    private String descs_noget[] = new String[]{"【陶记 巧克力蛋糕片300g】 牛奶柠檬味饼干面包片休闲零食糕点心"};
    private String prices_noget[] = new String[]{"￥29.90"};
    private int[] imageIds_noget = new int[]{R.drawable.food2};
    private String descs_nogive[] = new String[]{};
    private String prices_nogive[] = new String[]{};
    private int[] imageIds_nogive = new int[]{};
    private String descs_nomoney[] = new String[]{"五芳斋抹茶夹心麻薯糕点2盒*200g传统特产零食小吃糯米点心"};
    private String prices_nomoney[] = new String[]{"￥24.00"};
    private int[] imageIds_nomoney = new int[]{R.drawable.food4};
    private Activity orders_activity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        if(imageIds_nomoney.length == 0 && imageIds_nogive.length == 0 && imageIds_noget.length == 0 && imageIds_noestimate.length == 0){
            view = inflater.inflate(R.layout.noorders_layout, container, false);
            return view;
        }
        view = inflater.inflate(R.layout.fragment_allorders, container, false);
        orders_activity = this.getActivity();
        Context current_view = orders_activity.getApplicationContext();

        if(imageIds_nomoney.length != 0){
            gridView_nomoney = (GridView)view.findViewById(R.id.Gv_noallordersfragment_nomoney);
            List<Map<String,Object>> listItems = new ArrayList<Map<String, Object>>();
            for(int i = 0;i<imageIds_nomoney.length;i++){
                Map<String,Object> listItem = new HashMap<String,Object>();
                listItem.put("image",imageIds_nomoney[i]);
                listItem.put("desc",descs_nomoney[i]);
                listItem.put("price",prices_nomoney[i]);
                listItems.add(listItem);
            }
            orders_activity = this.getActivity();
            Context current_context = orders_activity.getApplicationContext();
            SimpleAdapter simpleAdapter = new SimpleAdapter(current_context,listItems,R.layout.nomoney_item,
                    new String[]{"image","desc","price"},new int[]{R.id.Iv_nomoneyOrderitem_image,R.id.Tv_nomoneyOrderitem_desc,R.id.Tv_nomoneyOrderitem_price});
            gridView_nomoney.setAdapter(simpleAdapter);
        }
        if(imageIds_nogive.length != 0){
            gridView_nogive = (GridView)view.findViewById(R.id.Gv_noallordersfragment_nogive);
            List<Map<String,Object>> listItems = new ArrayList<Map<String, Object>>();
            for(int i = 0;i<imageIds_nogive.length;i++){
                Map<String,Object> listItem = new HashMap<String,Object>();
                listItem.put("image",imageIds_nogive[i]);
                listItem.put("desc",descs_nogive[i]);
                listItem.put("price",prices_nogive[i]);
                listItems.add(listItem);
            }
            orders_activity = this.getActivity();
            Context current_context = orders_activity.getApplicationContext();
            SimpleAdapter simpleAdapter = new SimpleAdapter(current_context,listItems,R.layout.noestimate_item,
                    new String[]{"image","desc","price"},new int[]{R.id.Iv_nogiveOrderitem_image,R.id.Tv_nogiveOrderitem_desc,R.id.Tv_nogiveOrderitem_price});
            gridView_nogive.setAdapter(simpleAdapter);
        }
        if(imageIds_noget.length != 0){
            gridView_noget = (GridView)view.findViewById(R.id.Gv_noallordersfragment_noget);
            List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
            for (int i= 0;i<prices_noget.length;i++){
                Map<String,Object> listItem = new HashMap
                        <String,Object>();
                listItem.put("image",imageIds_noget[i]);
                listItem.put("desc",descs_noget[i]);
                listItem.put("price",prices_noget[i]);
                listItems.add(listItem);
            }
            orders_activity  = this.getActivity();
            Context current_context = orders_activity.getApplicationContext();
            //创建1个SimpleAdapter
            SimpleAdapter simpleAdapter = new SimpleAdapter(current_context,listItems,R.layout.nogetorder_item,
                    new String[]{"image","desc","price"},new int[]{R.id.Iv_nogetOrderitem_image,R.id.Tv_nogetOrderitem_desc,R.id.Tv_nogetOrderitem_price});
            //为GridView设置Adapter
            gridView_noget.setAdapter(simpleAdapter);
        }
        if(imageIds_noestimate.length != 0){
            gridView_noestimate = (GridView)view.findViewById(R.id.Gv_noallordersfragment_noestimate);
            List<Map<String,Object>> listItems = new ArrayList<Map<String, Object>>();
            for(int i = 0;i<imageIds_noestimate.length;i++){
                Map<String,Object> listItem = new HashMap<String,Object>();
                listItem.put("image",imageIds_noestimate[i]);
                listItem.put("desc",descs_noestimate[i]);
                listItem.put("price",prices_noestimate[i]);
                listItems.add(listItem);
            }
            orders_activity = this.getActivity();
            Context current_context = orders_activity.getApplicationContext();
            SimpleAdapter simpleAdapter = new SimpleAdapter(current_context,listItems,R.layout.noestimate_item,
                    new String[]{"image","desc","price"},new int[]{R.id.Iv_noestimateOrderitem_image,R.id.Tv_noestimateOrderitem_desc,R.id.Tv_noestimateOrderitem_price});
            gridView_noestimate.setAdapter(simpleAdapter);
        }
        return view;
    }
}
