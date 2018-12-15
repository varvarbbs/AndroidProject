package com.kun.androidproject.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kun.androidproject.R;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.view_navigationbar)
public class NavigationBarView extends RelativeLayout {

    @ViewById(R.id.navigation_bar_left)
    public View leftView;
    @ViewById(R.id.navigation_bar_leftImage)
    public ImageView leftImageView;
    @ViewById(R.id.navigation_bar_title)
    public TextView titleView;
    @ViewById(R.id.navigation_bar_right)
    public TextView rightView;

    public NavigationBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setTitleValue(String title){
        titleView.setText(title);
    }

    public void setRightTitle(String title){
        rightView.setText(title);
    }

    public void hiddenLeft(){
        leftView.setVisibility(View.GONE);
    }

    public void hiddenRight(){
        rightView.setVisibility(View.GONE);
    }

    public void setImage(int resourceId){
        leftImageView.setImageResource(resourceId);
    }

}
