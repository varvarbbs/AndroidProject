package com.kun.androidproject.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kun.androidproject.R;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.view_navigationbar)
public class NavigationBarView extends RelativeLayout {

    @ViewById(R.id.navigation_bar_left)
    ImageView leftView;
    @ViewById(R.id.navigation_bar_title)
    TextView titleView;
    @ViewById(R.id.navigation_bar_right)
    TextView rightView;

    public NavigationBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
