package com.example.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.SlidingDrawer;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-8
 * Time: 下午2:25
 */
public class DrawerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer);

        SlidingDrawer drawer = (SlidingDrawer) findViewById(R.id.slidingDrawer);

        drawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened() {
                Toast toast = Toast.makeText(DrawerActivity.this, "抽屉打开", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.show();
            }
        });

        drawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
            @Override
            public void onDrawerClosed() {
                Toast toast = Toast.makeText(DrawerActivity.this, "抽屉关闭", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.show();
            }
        });

        drawer.setOnDrawerScrollListener(new SlidingDrawer.OnDrawerScrollListener() {
            @Override
            public void onScrollStarted() {
                Toast toast = Toast.makeText(DrawerActivity.this, "抽屉滚动开始", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.show();
            }

            @Override
            public void onScrollEnded() {
                Toast toast = Toast.makeText(DrawerActivity.this, "抽屉滚动结束", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.show();
            }
        });
    }
}
