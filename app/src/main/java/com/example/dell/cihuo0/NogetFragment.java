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

public class NogetFragment extends Fragment {
    private String descs[] = new String[]{"【陶记 巧克力蛋糕片300g】 牛奶柠檬味饼干面包片休闲零食糕点心"};
    private String prices[] = new String[]{"￥29.90"};
    private int[] imageIds = new int[]{R.drawable.food2};
    private Activity orders_activity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View current_view = inflater.inflate(R.layout.fragment_noget, container, false);
        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
        for (int i= 0;i<prices.length;i++){
            Map<String,Object> listItem = new HashMap
                    <String,Object>();
            listItem.put("image",imageIds[i]);
            listItem.put("desc",descs[i]);
            listItem.put("price",prices[i]);
            listItems.add(listItem);
        }
        orders_activity  = this.getActivity();
        Context current_context = orders_activity.getApplicationContext();
        //创建1个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(current_context,listItems,R.layout.nogetorder_item,
                new String[]{"image","desc","price"},new int[]{R.id.Iv_nogetOrderitem_image,R.id.Tv_nogetOrderitem_desc,R.id.Tv_nogetOrderitem_price});
        GridView gridView = (GridView) current_view.findViewById(R.id.Gv_nogetfragment_contener);
        //为GridView设置Adapter
        gridView.setAdapter(simpleAdapter);
        // 为当前Fragment添加布局文件，并返回（view）
        return current_view;
    }
}
