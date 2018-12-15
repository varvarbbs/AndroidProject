package com.kun.demo;

import android.content.Intent;
import android.widget.EditText;
import com.kun.androidproject.R;
import com.kun.androidproject.base.BaseActivity;
import com.kun.androidproject.base.MyApplication;
import com.kun.androidproject.base.NavigationBarView;
import org.androidannotations.annotations.*;

@EActivity(R.layout.activity_demo_login)
public class DemoLoginActivity extends BaseActivity {

    @ViewById
    NavigationBarView barView;
    @ViewById
    EditText mobile;
    @ViewById
    EditText password;
    @App
    MyApplication app;

    @AfterViews
    void initViews(){
        this.setBarView(barView);
        barView.setTitleValue("会员登录");
        barView.setRightTitle("忘记密码");
        barView.hiddenLeft();
        //读取上次的登录资料
        DemoLoginModel entity = app.getDaoSession().getDemoLoginModelDao().load(1L);
        if (entity != null){
            mobile.setText(entity.getMobile());
            password.setText(entity.getPassword());
        }
    }

    @Override
    protected void onReturn() {

    }

    @Override
    protected void onRightButtonClick() {

    }

    @Click(R.id.login)
    void loginClick(){
        if (this.isEmtpy(mobile.getText().toString(), "请输入手机号码")){
            return;
        }

        if (this.isEmtpy(password.getText().toString(), "密码不能为空")){
            return;
        }

        DemoLoginModel entity = app.getDaoSession().getDemoLoginModelDao().load(1L);
        if (entity == null){
            entity = new DemoLoginModel();
            entity.setKeyId(1L);
            entity.setMobile(mobile.getText().toString());
            entity.setPassword(password.getText().toString());
            app.getDaoSession().getDemoLoginModelDao().insert(entity);
        }else{
            entity.setMobile(mobile.getText().toString());
            entity.setPassword(password.getText().toString());
            app.getDaoSession().getDemoLoginModelDao().update(entity);
        }

        Intent intent = new Intent(DemoLoginActivity.this, DemoMainActivity_.class);
        this.startActivity(intent);
    }
}
