package com.kun.demo;

import android.os.Bundle;
import com.kun.androidproject.R;
import com.kun.androidproject.base.BaseActivity;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;


@EActivity(R.layout.activity_demo_login)
@Fullscreen
public class DemoLoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
