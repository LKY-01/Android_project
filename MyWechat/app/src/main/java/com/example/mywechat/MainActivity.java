package com.example.mywechat;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager ;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements View.OnClickListener {
//控件控制
    private Fragment mtab1 = new weixinFragment();
    private Fragment mtab2 = new friendFragment();
    private Fragment mtab3 = new tongxunFragment();
    private Fragment mtab4 = new settingFragment();

    private LinearLayout weixin,pengyou,tongxun,shezhi;
    private ImageButton imageButton1,imageButton2,imageButton3,imageButton4;

    private FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
        initFragment();
        setSelect(0);

    }
    //将Fragment进行初始化
    private void initFragment(){
        fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.id_content, mtab1);
        transaction.add(R.id.id_content, mtab2);
        transaction.add(R.id.id_content, mtab3);
        transaction.add(R.id.id_content, mtab4);
        transaction.commit( ) ;
    }
    private void initView() {
        weixin =  findViewById(R.id.weixin);
        pengyou = findViewById(R.id.friend);
        tongxun = findViewById(R.id.tongxun);
        shezhi =  findViewById(R.id.setting);

        imageButton1 = findViewById(R.id.imageButton1);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton3 = findViewById(R.id.imageButton3);
        imageButton4 = findViewById(R.id.imageButton4);
    }

        private void hide(FragmentTransaction transaction){
        transaction.hide(mtab1);
        transaction.hide(mtab2);
        transaction.hide(mtab3);
        transaction.hide(mtab4);
        transaction.commit();
    }

    private void setSelect(int i){
        FragmentTransaction transaction=fm.beginTransaction();
        hide(transaction);
        switch (i){
            case 0 :
                Log.d("selection","1");
                transaction.show(mtab1);
                imageButton1.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1 :
                transaction.show(mtab2);
                imageButton2.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2 :
                transaction.show(mtab3);
                imageButton3.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3 :
                transaction.show(mtab4);
                imageButton4.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View view) {
        resetImgs();
        switch (view.getId()){
                case R.id.imageButton1:
                setSelect(0);
                break;
            case R.id.imageButton2:
                setSelect(1);
                break;
            case R.id.imageButton3:
                setSelect(2);
                break;
            case R.id.imageButton4 :
                setSelect(3);
                break;
            default:
                break;

        }
    }

    //让图片全部变灰
    private void resetImgs(){
        imageButton1.setImageResource (R.drawable.tab_weixin_normal);
        imageButton2.setImageResource(R.drawable.tab_find_frd_normal);
        imageButton3.setImageResource(R.drawable.tab_address_normal);
        imageButton4.setImageResource(R.drawable.tab_settings_normal);
    }
    //缩小监听范围
    private void initEvent(){
        imageButton1.setOnClickListener(this) ;
        imageButton2.setOnClickListener (this) ;
        imageButton3.setOnClickListener (this) ;
        imageButton4.setOnClickListener (this) ;
    }
}
