package com.example.dell.cihuo0;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OrdersActivity extends Activity {
    private ImageView imageViewback;
    private TextView mTvall,mTvnomoney,mTvnogive,mTvnoget,mTvnoenamite;
    private AllordersFragment mAll;
    private NomoneyFragment mNomoney;
    private NogiveFragment mNogive;
    private NogetFragment mNoget;
    private NoestimateFragment mNoestimate;
    private LinearLayout morders_acty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        //1、获取界面控件
        getViews();
        //2、注册事件监听器
        setListener();
        //3、设置默认页面
        setDefaultPage();
    }

    //1、获取界面控件
    public void getViews(){
        imageViewback = (ImageView)findViewById(R.id.Iv_ordersacty_back);
        mTvall = (TextView)findViewById(R.id.Tv_ordersacty_all);
        mTvnomoney = (TextView)findViewById(R.id.Tv_ordersacty_nomoney);
        mTvnogive = (TextView)findViewById(R.id.Tv_ordersacty_nogive);
        mTvnoget = (TextView)findViewById(R.id.Tv_ordersacty_noget);
        mTvnoenamite = (TextView)findViewById(R.id.Tv_ordersacty_estimate);
        morders_acty = (LinearLayout)findViewById(R.id.activity_orders);

    }
    //2、注册事件监听器
    public void setListener(){
        myListener listener = new myListener();
        mTvall.setOnClickListener(listener);
        mTvnomoney.setOnClickListener(listener);
        mTvnogive.setOnClickListener(listener);
        mTvnoget.setOnClickListener(listener);
        mTvnoenamite.setOnClickListener(listener);
        imageViewback.setOnClickListener(backListener);
    }
    //3、设置默认页面
    public void setDefaultPage(){
        mTvall.setTextColor(0xFFFF5500);
        //1、获取一个FragmentManager对象
        FragmentManager fm = getFragmentManager();
        //2、获取FragmentTransaction对象
        FragmentTransaction transaction = fm.beginTransaction();
        mAll = new AllordersFragment();
        //3、设置页面
        transaction.replace(R.id.orders_banner, mAll);
        //4、执行更改
        transaction.commit();
    }

    //backListener监听器
    View.OnClickListener backListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Utils.flag=3;
            Intent intent = new Intent(OrdersActivity.this,MainActivity.class);
            startActivity(intent);
        }
    };
    //myListener监听器
    class myListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            //1、获取一个FragmentManager对象
            FragmentManager fm = getFragmentManager();
            //2、获取FragmentTransaction对象
            FragmentTransaction transaction = fm.beginTransaction();
            switch (view.getId()){
                case R.id.Tv_ordersacty_all:
                    if(mAll == null){
                        mAll = new AllordersFragment();
                    }
                    mTvall.setTextColor(0xFFFF5500);
                    mTvnomoney.setTextColor(0xFF515151);
                    mTvnogive.setTextColor(0xFF515151);
                    mTvnoget.setTextColor(0xFF515151);
                    mTvnoenamite.setTextColor(0xFF515151);
                    //设置页面
                    transaction.replace(R.id.orders_banner,mAll);
                    break;
                case R.id.Tv_ordersacty_nomoney:
                    if(mNomoney == null){
                        mNomoney = new NomoneyFragment();
                    }
                    mTvall.setTextColor(0xFF515151);
                    mTvnomoney.setTextColor(0xFFFF5500);
                    mTvnogive.setTextColor(0xFF515151);
                    mTvnoget.setTextColor(0xFF515151);
                    mTvnoenamite.setTextColor(0xFF515151);
                    //设置页面
                    transaction.replace(R.id.orders_banner,mNomoney);
                    break;
                case R.id.Tv_ordersacty_nogive:
                    if(mNogive == null){
                        mNogive = new NogiveFragment();
                    }
                    mTvall.setTextColor(0xFF515151);
                    mTvnomoney.setTextColor(0xFF515151);
                    mTvnogive.setTextColor(0xFFFF5500);
                    mTvnoget.setTextColor(0xFF515151);
                    mTvnoenamite.setTextColor(0xFF515151);
                    //设置页面
                    transaction.replace(R.id.orders_banner,mNogive);
                    break;
                case R.id.Tv_ordersacty_noget:
                    if(mNoget == null){
                        mNoget = new NogetFragment();
                    }
                    mTvall.setTextColor(0xFF515151);
                    mTvnomoney.setTextColor(0xFF515151);
                    mTvnogive.setTextColor(0xFF515151);
                    mTvnoget.setTextColor(0xFFFF5500);
                    mTvnoenamite.setTextColor(0xFF515151);
                    //设置页面
                    transaction.replace(R.id.orders_banner,mNoget);
                    break;
                case R.id.Tv_ordersacty_estimate:
                    if(mNoestimate == null){
                        mNoestimate = new NoestimateFragment();
                    }
                    mTvall.setTextColor(0xFF515151);
                    mTvnomoney.setTextColor(0xFF515151);
                    mTvnogive.setTextColor(0xFF515151);
                    mTvnoget.setTextColor(0xFF515151);
                    mTvnoenamite.setTextColor(0xFFFF5500);
                    //设置页面
                    transaction.replace(R.id.orders_banner,mNoestimate);
                    break;
            }
            //4、执行更改
            transaction.commit();
            morders_acty.invalidate();
        }
    }
}
