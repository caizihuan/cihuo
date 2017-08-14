package com.example.dell.cihuo0;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;

/**
 * Created by dell on 2016/10/29.
 */

public class MyFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 为当前Fragment添加布局文件
        View currentView = inflater.inflate(R.layout.fragment_my, container, false);
        final Activity main_activity = this.getActivity();
        //为我的订单设置点击事件
        final LinearLayout Lv_order=(LinearLayout)currentView.findViewById(R.id.Lv_myfragment_Myorders);
        Lv_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main_activity,OrdersActivity.class);
                startActivity(intent);
            }
        });
        //为我的收货地址设置点击事件
        final LinearLayout Lv_address=(LinearLayout)currentView.findViewById(R.id.Ll_myfragment_Myaddress);
        Lv_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main_activity,AddressActivity.class);
                startActivity(intent);
            }
        });
        //为关于我们设置点击事件
        final LinearLayout Lv_aboutus=(LinearLayout)currentView.findViewById(R.id.Ll_myfragment_Aboutour);
        Lv_aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(main_activity,AboutUsActivity.class);
                startActivity(intent);
            }
        });
       //返回（view）
        return currentView;
    }
}
