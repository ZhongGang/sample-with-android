package com.example.activity;

import android.app.Activity;
import android.os.Bundle;
import com.example.view.RectangleView;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-6
 * Time: 下午1:52
 */
public class RectangleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new RectangleView(this));
    }
}
