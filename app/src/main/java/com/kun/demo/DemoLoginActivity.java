package com.kun.demo;

import android.widget.EditText;
import com.kun.androidproject.R;
import com.kun.androidproject.base.BaseActivity;
import com.kun.androidproject.base.NavigationBarView;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_demo_login)
public class DemoLoginActivity extends BaseActivity {

    @ViewById
    NavigationBarView barView;
    @ViewById
    EditText mobile;
    @ViewById
    EditText password;

    @AfterViews
    void initViews(){
        this.setBarView(barView);
        barView.setTitleValue("会员登录");
        barView.setRightTitle("忘记密码");
        barView.hiddenLeft();
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
    }
}
