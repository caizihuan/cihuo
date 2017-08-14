package com.example.dell.cihuo0;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity {
    private LinearLayout mLlhome, mLlfood, mLlmy,mLlshopcar;
    private LinearLayout mLayout;
    //声明Fragment属性
    private HomeFragment mHome;
    private FoodFragment mFood;
    private MyFragment mMy;
    private ShopcarFragment mShopcar;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //1、获取界面控件
        getViews();
        //2、注册事件监听器
        setListener();
        //3、设置默认页面
        setDefaultPage();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        switch (Utils.flag){
            case 1://显示默认页面
                setDefaultPage();
                break;
            case 2://显示全部宝贝页面
                setFoodPage();
                break;
            case 3://显示我的资料页面
                setMyPage();
                break;
        }
    }

    //1、获取界面控件
    private void getViews() {
        mLayout = (LinearLayout) findViewById(R.id.activity_main);
        mLlhome = (LinearLayout) findViewById(R.id.LLmainhome);
        mLlfood = (LinearLayout) findViewById(R.id.Llmainfood);
        mLlmy = (LinearLayout) findViewById(R.id.Llmainmy);
        mLlshopcar = (LinearLayout)findViewById(R.id.Ll_mainactuty_shopcar);
    }

    //2、注册事件监听器
    private void setListener() {
        MyListener listener = new MyListener();
        mLlhome.setOnClickListener(listener);
        mLlfood.setOnClickListener(listener);
        mLlmy.setOnClickListener(listener);
        mLlshopcar.setOnClickListener(listener);
    }

    //3、设置默认的页面（fragment页面）
    private void setDefaultPage() {
        //1、获取一个FragmentManager对象
        FragmentManager fm = getFragmentManager();
        //2、获取FragmentTransaction对象
        FragmentTransaction transaction = fm.beginTransaction();
        mHome = new HomeFragment();
        //3、设置页面
        transaction.replace(R.id.contaner, mHome);
        //4、执行更改
        transaction.commit();
    }
    //3、设置fragment页面
    private void setFoodPage() {
        //1、获取一个FragmentManager对象
        FragmentManager fm = getFragmentManager();
        //2、获取FragmentTransaction对象
        FragmentTransaction transaction = fm.beginTransaction();
        mFood = new FoodFragment();
        //3、设置页面
        transaction.replace(R.id.contaner, mFood);
        //4、执行更改
        transaction.commit();
    }
    //3、设置我的fragment页面
    private void setMyPage() {
        //1、获取一个FragmentManager对象
        FragmentManager fm = getFragmentManager();
        //2、获取FragmentTransaction对象
        FragmentTransaction transaction = fm.beginTransaction();
        mMy = new MyFragment();
        //3、设置页面
        transaction.replace(R.id.contaner, mMy);
        //4、执行更改
        transaction.commit();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
    //设置fragment点击监听器
    class MyListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            //1、获取一个FragmentManager对象
            FragmentManager fm = getFragmentManager();
            //2、获取FragmentTransaction对象
            FragmentTransaction transaction = fm.beginTransaction();
            switch (view.getId()) {
                case R.id.LLmainhome:
                    if (mHome == null) {
                        mHome = new HomeFragment();
                    }
                    //3、设置页面
                    transaction.replace(R.id.contaner, mHome);
                    break;
                case R.id.Llmainfood:
                    if (mFood == null) {
                        mFood = new FoodFragment();
                    }
                    //3、设置页面
                    transaction.replace(R.id.contaner, mFood);
                    break;
                case R.id.Llmainmy:
                    if (mMy == null) {
                        mMy = new MyFragment();
                    }
                    //3、设置页面
                    transaction.replace(R.id.contaner, mMy);
                    break;
                case R.id.Ll_mainactuty_shopcar:
                    if (mShopcar == null) {
                        mShopcar = new ShopcarFragment();
                    }
                    //3、设置页面
                    transaction.replace(R.id.contaner, mShopcar);
                    break;
            }
            //4、执行更改
            transaction.commit();
            mLayout.invalidate();
        }
    }
}
