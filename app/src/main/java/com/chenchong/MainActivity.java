package com.chenchong;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.chenchong.view.BottomView;
import com.chenchong.view.BottomView.onStatusListener;

public class MainActivity extends Activity {
    private BottomView mBottomView;
    private View viewMask;
    private ImageView btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initView();
    }

    private void initView() {
        mBottomView = (BottomView)findViewById(R.id.mBottomView);
        viewMask = findViewById(R.id.view_mask);
        btnLogin = (ImageView)findViewById(R.id.btn_login);
        mBottomView.setEnabled(true);
        //设置遮罩阴影层点击消失该界面
        viewMask.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(mBottomView.isShow()){
                    mBottomView.dismiss();
                }
            }
        });
        //设置登录界面状态监听
        mBottomView.setOnStatusListener(new onStatusListener() {

            @Override
            public void onShow() {
                //显示
                viewMask.setVisibility(View.VISIBLE);
            }

            @Override
            public void onDismiss() {
                //隐藏
                viewMask.setVisibility(View.GONE);
            }
        });
        btnLogin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(mBottomView.isShow()){
                    mBottomView.dismiss();
                }else{
                    mBottomView.show();
                }
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if(keyCode ==  KeyEvent.KEYCODE_BACK){
            if(mBottomView.isShow()){
                mBottomView.dismiss();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
