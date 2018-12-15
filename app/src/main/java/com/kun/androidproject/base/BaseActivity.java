package com.kun.androidproject.base;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import com.kun.androidproject.helper.StringHelper;

public abstract class BaseActivity extends AppCompatActivity {

    protected NavigationBarView barView;

    protected abstract void onReturn();
    protected abstract void onRightButtonClick();

    protected void setBarView(NavigationBarView view){
        barView = view;
        if (barView != null){
            barView.leftView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onReturn();
                    BaseActivity.this.finish();
                }
            });

            barView.rightView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRightButtonClick();
                }
            });
        }
    }

    /**
     * 判断内容是否空, 是否需要提示
     * @param value
     * @param tips
     * @return
     */
    public boolean isEmtpy(String value, String tips){
        if (StringHelper.isEmtpy(value)){
            if (!StringHelper.isEmtpy(tips)){
                this.showToast(tips);
            }
            return true;
        }
        return false;
    }

    /**
     * 显示提示
     * @param value
     */
    public void showToast(String value){
        Toast.makeText(this, value, Toast.LENGTH_LONG);
    }


}
