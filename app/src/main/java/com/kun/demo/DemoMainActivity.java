package com.kun.demo;

import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.kun.androidproject.R;
import com.kun.androidproject.base.BaseActivity;
import com.kun.androidproject.base.TabbarMenu;
import org.androidannotations.annotations.*;

@EActivity(R.layout.activity_demo_main)
@Fullscreen
public class DemoMainActivity extends BaseActivity {

    @ViewById
    TabbarMenu firstMenu;
    @ViewById
    TabbarMenu secondMenu;

    int selectIndex = -1;

    @AfterViews
    void initViews(){
        this.initMenu();
        this.selectMenuAtIndex(0);
    }

    @Override
    protected void onReturn() {

    }

    @Override
    protected void onRightButtonClick() {

    }

    @Click(R.id.firstMenu)
    void clickFirst(){
        this.setMenu(true, firstMenu, R.mipmap.demo_menu1_select);
        this.setMenu(false, secondMenu, R.mipmap.demo_menu2);
        this.selectMenuAtIndex(0);
    }

    @Click(R.id.secondMenu)
    void clickSecond(){
        this.setMenu(false, firstMenu, R.mipmap.demo_menu1);
        this.setMenu(true, secondMenu, R.mipmap.demo_menu2_select);
        this.selectMenuAtIndex(1);
    }

    private void initMenu(){
        firstMenu.getTitle().setText("首页");
        this.setMenu(true, firstMenu, R.mipmap.demo_menu1_select);
        secondMenu.getTitle().setText("我的JSON");
        this.setMenu(false, secondMenu, R.mipmap.demo_menu2);
    }

    private void selectMenuAtIndex(int index){
        if (selectIndex == index){
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (index == 0){
            transaction.replace(R.id.frameLayout, DemoFragmentFisrt_.builder().build());
        }else if (index == 1){
            transaction.replace(R.id.frameLayout, DemoFramgentSecond_.builder().build());
        }
        transaction.commit();
    }

    private void setMenu(boolean isSelect, TabbarMenu menu, int resource){
        if (isSelect){
            menu.getImageView().setImageResource(resource);
            menu.getTitle().setTextColor(getResources().getColor(R.color.menuSelect, null));
        }else{
            menu.getImageView().setImageResource(resource);
            menu.getTitle().setTextColor(Color.BLACK);
        }
    }
}
