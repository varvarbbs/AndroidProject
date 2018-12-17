package com.kun.demo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ListView;
import com.google.gson.Gson;
import com.kun.androidproject.R;
import com.kun.androidproject.base.BaseFragment;
import com.kun.androidproject.base.NavigationBarView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import org.androidannotations.annotations.*;
import org.androidannotations.rest.spring.annotations.RestService;

@EFragment(R.layout.fragment_demo_framgent_second)
public class DemoFramgentSecond extends BaseFragment {

    @ViewById
    NavigationBarView barView;
    @ViewById
    ListView listView;
    @ViewById
    SmartRefreshLayout smartRefreshLayout;
    @RestService
    DemoRestClient restClient;

    private DemoDataList datas = new DemoDataList();
    private int page = 0;
    private int size = 20;
    private DemoAdapter adapter;

    @Override
    protected void onRightButtonClick() {

    }

    @AfterViews
    void initViews(){
        this.setBarView(barView);
        barView.hiddenLeft();
        barView.hiddenRight();
        barView.setTitleValue("listview Demo");
        //上拉刷新
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                loadFisrtData();
            }
        });
        //下拉加载更多
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                loadMore();
            }
        });
        adapter = new DemoAdapter(this.getContext(), datas);
        listView.setAdapter(adapter);
        loadFisrtData();
    }

    @Background
    void loadFisrtData(){
        page = 1;
        String json = restClient.getData();
        Gson gson = new Gson();
        DemoDataList list = gson.fromJson(json, DemoDataList.class);
        datas.clear();
        this.addData(page, list);
        loadFirstFinish();
    }

    private void addData(int page, DemoDataList list){
        int start = (page - 1) * size;
        for (int i = start; i< start+ size; i++){
            if (list.size() <= i){
                return;
            }
            datas.add(list.get(i));
        }
    }

    @UiThread
    void loadFirstFinish(){
        smartRefreshLayout.finishRefresh();
        adapter.notifyDataSetChanged();
    }

    @Background
    void loadMore(){
        page++;
        String json = restClient.getData();
        Gson gson = new Gson();
        DemoDataList list = gson.fromJson(json, DemoDataList.class);
        this.addData(page, list);
        loadMoreFinish();
    }

    @UiThread
    void loadMoreFinish(){
        smartRefreshLayout.finishLoadMore();
        adapter.notifyDataSetChanged();;
    }
}
