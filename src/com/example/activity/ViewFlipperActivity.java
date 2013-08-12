package com.example.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;
import android.widget.ViewFlipper;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-12
 * Time: 下午9:29
 */
public class ViewFlipperActivity extends Activity implements GestureDetector.OnGestureListener {

    private ViewFlipper viewFlipper;
    private GestureDetector gestureDetector = new GestureDetector(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.views);

        LayoutInflater layoutInflater = getLayoutInflater();
        View decoratorView = layoutInflater.inflate(R.layout.decorator, null);
        View widgetView = layoutInflater.inflate(R.layout.widgets, null);
        View loginView = layoutInflater.inflate(R.layout.login, null);
        View shopView = layoutInflater.inflate(R.layout.shop, null);

        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        viewFlipper.addView(decoratorView);
        viewFlipper.addView(widgetView);
        viewFlipper.addView(loginView);
        viewFlipper.addView(shopView);

        viewFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(ViewFlipperActivity.this, "ViewFlipper点击事件触发了！", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });

//        viewFlipper.setAutoStart(true);
//        viewFlipper.setFlipInterval(3000);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        gestureDetector.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        float x1 = e1.getX();
        float x2 = e2.getX();
        if (x1 - x2 > 100) {
//            viewFlipper.setInAnimation(inFromRightAnimation());
//            viewFlipper.setOutAnimation(outToLeftAnimation());
            viewFlipper.showNext();
            return true;
        }

        if (x2 - x1 > 100) {
//            viewFlipper.setInAnimation(inFromLeftAnimation());
//            viewFlipper.setOutAnimation(outToRightAnimation());
            viewFlipper.showPrevious();
            return true;
        }

        return false;
    }

    /**
     * 定义从右侧进入的动画效果
     *
     * @return
     */
    protected Animation inFromRightAnimation() {
        Animation inFromRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromRight.setDuration(3000);
        inFromRight.setInterpolator(new AccelerateInterpolator());
        return inFromRight;
    }

    /**
     * 定义从左侧退出的动画效果
     *
     * @return
     */
    protected Animation outToLeftAnimation() {
        Animation outtoLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outtoLeft.setDuration(3000);
        outtoLeft.setInterpolator(new AccelerateInterpolator());
        return outtoLeft;
    }

    /**
     * 定义从左侧进入的动画效果
     *
     * @return
     */
    protected Animation inFromLeftAnimation() {
        Animation inFromLeft = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, -1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        inFromLeft.setDuration(3000);
        inFromLeft.setInterpolator(new AccelerateInterpolator());
        return inFromLeft;
    }

    /**
     * 定义从右侧退出时的动画效果
     *
     * @return
     */
    protected Animation outToRightAnimation() {
        Animation outtoRight = new TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, +1.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f);
        outtoRight.setDuration(3000);
        outtoRight.setInterpolator(new AccelerateInterpolator());
        return outtoRight;
    }
}
