package com.kun.androidproject.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kun.androidproject.R;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;
import org.w3c.dom.Text;

@EViewGroup(R.layout.view_tabbar_menu)
public class TabbarMenu extends RelativeLayout {

    @ViewById(R.id.menuImage)
    ImageView imageView;
    @ViewById(R.id.menuTitle)
    TextView title;

    public TabbarMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }
}
