package com.kun.demo;

import com.kun.androidproject.R;
import com.kun.androidproject.base.BaseActivity;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;

@EActivity(R.layout.activity_demo_main)
@Fullscreen
public class DemoMainActivity extends BaseActivity {
    @Override
    protected void onReturn() {

    }

    @Override
    protected void onRightButtonClick() {

    }
}
