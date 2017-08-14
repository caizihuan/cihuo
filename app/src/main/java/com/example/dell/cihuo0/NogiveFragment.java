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

public class NogiveFragment extends Fragment {
    private String descs[] = new String[]{};
    private String prices[] = new String[]{};
    private int[] imageIds = new int[]{};
    private Activity orders_activity;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view ;
        if(imageIds.length==0){
            view = inflater.inflate(R.layout.noorders_layout, container, false);
            return view;
        }
        view = inflater.inflate(R.layout.fragment_nogive, container, false);
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
        SimpleAdapter simpleAdapter = new SimpleAdapter(current_context,listItems,R.layout.noestimate_item,
                new String[]{"image","desc","price"},new int[]{R.id.Iv_nogiveOrderitem_image,R.id.Tv_nogiveOrderitem_desc,R.id.Tv_nogiveOrderitem_price});
        GridView gridView = (GridView)view.findViewById(R.id.Gv_nogivefragment_contener);
        gridView.setAdapter(simpleAdapter);
        return view;
    }
}
