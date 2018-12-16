package com.kun.androidproject.base;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Toast;
import com.kun.androidproject.helper.StringHelper;

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
        Toast.makeText(this.getActivity(), value, Toast.LENGTH_LONG).show();
    }

}
