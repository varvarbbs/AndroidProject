package com.kun.androidproject.base;

import android.support.v4.app.Fragment;
import android.view.View;

public abstract class BaseFragment extends Fragment {
    protected NavigationBarView barView;

    protected abstract void onRightButtonClick();

    protected void setBarView(NavigationBarView view){
        barView = view;
        if (barView != null){
            barView.rightView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRightButtonClick();
                }
            });
        }
    }

}
