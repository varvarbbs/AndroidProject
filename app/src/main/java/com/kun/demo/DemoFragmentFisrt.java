package com.kun.demo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;
import android.widget.TextView;
import com.google.gson.Gson;
import com.kun.androidproject.R;
import com.kun.androidproject.base.BaseFragment;
import com.kun.androidproject.base.NavigationBarView;
import org.androidannotations.annotations.*;
import org.androidannotations.rest.spring.annotations.RestService;

@EFragment(R.layout.fragment_demo_fragment_fisrt)
public class DemoFragmentFisrt extends BaseFragment {

    @ViewById
    EditText ipInput;
    @ViewById
    TextView idView;
    @ViewById
    TextView nameView;
    @ViewById
    TextView emailView;
    @ViewById
    NavigationBarView barView;
    @RestService
    DemoRestClient restClient;

    @Override
    protected void onRightButtonClick() {
        if (this.isEmtpy(ipInput.getText().toString(), "请输入有效的IP地址")){
            return;
        }
        this.loadData(ipInput.getText().toString());
    }

    @AfterViews
    void initViews(){
        this.setBarView(barView);
        barView.setTitleValue("REST提交测试");
        barView.setRightTitle("点击查询");
        barView.hiddenLeft();
    }

    @Background
    void loadData(String ip){
        try{
            String json = restClient.getData();
            DemoDataList list = new Gson().fromJson(json, DemoDataList.class);
            if (list != null && !list.isEmpty()){
                updateUI(list.get(0));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @UiThread
    void updateUI(DemoData data){
        if (data != null){
            ipInput.setText("读取成功");
            idView.setText("ID: " + data.getId());
            nameView.setText("Name: " + data.getName());
            emailView.setText("Email: " + data.getEmail());
        }
    }


}
