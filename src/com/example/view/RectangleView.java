package com.example.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-6
 * Time: 下午1:49
 */
public class RectangleView extends View {

    public RectangleView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawRect(100, 100, 400, 400, paint);
        paint.setColor(Color.BLUE);
        paint.setTextSize(30);
        canvas.drawText("这是自定义视图组件", 200, 200, paint);
    }
}
