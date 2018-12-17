package com.kun.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.kun.androidproject.R;

import java.util.List;

public class DemoAdapter extends BaseAdapter {

    private Context context;
    private DemoDataList list;

    public DemoAdapter(Context context, DemoDataList list) {
        super();
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        // 若无可重用的 view 则进行加载
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater mInflater = LayoutInflater.from(context);
            convertView = mInflater.inflate(R.layout.view_demo_cell, null);
            viewHolder.title = (TextView)convertView.findViewById(R.id.title);
            viewHolder.subTitle = (TextView)convertView.findViewById(R.id.subTitle);
            convertView.setTag(viewHolder);
        }else{ // 否则进行重用
            viewHolder = (ViewHolder)convertView.getTag();
        }
        DemoData data = list.get(position);
        viewHolder.title.setText(data.getName());
        viewHolder.subTitle.setText(data.getEmail());
        return convertView;
    }

    class ViewHolder{
        TextView title;
        TextView subTitle;
    }
}
