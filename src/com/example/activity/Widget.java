package com.example.activity;

import android.app.*;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.GestureDetector;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.*;
import com.example.core.FlashLightController;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-5
 * Time: 下午2:30
 */
public class Widget extends Activity implements GestureDetector.OnGestureListener {

    private ProgressDialog progressDialog;
    private ProgressDialog circleProgressDialog;
    private ToggleButton toggleBtn;
    private GestureDetector gestureDetector = new GestureDetector(Widget.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widgets);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.widgetsGridLayout);
        gridLayout.setFocusable(true);
        gridLayout.setClickable(true);
        gridLayout.setLongClickable(true);
        gestureDetector.setIsLongpressEnabled(true);

        gridLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast toast = Toast.makeText(Widget.this, R.string.touch, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.show();
                return gestureDetector.onTouchEvent(event);
            }
        });

        Button backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Widget.this, ShopForm.class);
                startActivity(intent);
            }
        });

        Button progressBarBtn = (Button) findViewById(R.id.progressBarBtn);
        progressBarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog = new ProgressDialog(Widget.this, ProgressDialog.THEME_DEVICE_DEFAULT_LIGHT);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle(R.string.tip);
                progressDialog.setMessage("进行程度");
                progressDialog.show();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int progress = 0;
                        while ((progress < 100)) {
                            progressDialog.setProgress(progress++);
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                progressDialog.cancel();
                            }
                        }
                        progressDialog.cancel();
                    }
                }).start();
            }
        });

        Button circleProgressBarBtn = (Button) findViewById(R.id.circleProgressBarBtn);
        circleProgressBarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                circleProgressDialog = new ProgressDialog(Widget.this, ProgressDialog.THEME_DEVICE_DEFAULT_LIGHT);
                circleProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                circleProgressDialog.setTitle(R.string.tip);
                circleProgressDialog.setMessage("进行程度");
                circleProgressDialog.show();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int progress = 0;
                        while ((progress < 100)) {
                            circleProgressDialog.setProgress(progress++);
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                circleProgressDialog.cancel();
                            }
                        }
                        circleProgressDialog.cancel();
                    }
                }).start();
            }
        });

        Button dialogBtn = (Button) findViewById(R.id.dialogBtn);
        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(Widget.this).setTitle(R.string.tip).setMessage(R.string.dialog_message).show();
            }
        });

        Button toastBtn = (Button) findViewById(R.id.toastBtn);
        toastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(Widget.this, R.string.save, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.show();
            }
        });

        Button notificationBtn = (Button) findViewById(R.id.notificationBtn);
        notificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                Notification notification = new Notification();
                notification.tickerText = "这是一个通知！";
                notification.icon = android.R.drawable.stat_notify_chat;
                notification.when = System.currentTimeMillis();
                notification.sound = Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "10");
                notification.flags = Notification.FLAG_INSISTENT;
                notification.vibrate = new long[]{0, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};
                Intent intent = new Intent(Widget.this, Widget.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(Widget.this, 0, intent, 0);
                notification.setLatestEventInfo(Widget.this, "下拉通知标题", "下拉通知内容", pendingIntent);

                notificationManager.notify(1, notification);
            }
        });

        Button touchBtn = (Button) findViewById(R.id.touchBtn);
        touchBtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast toast = Toast.makeText(Widget.this, R.string.touch, Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.show();
                return true;
            }
        });

        toggleBtn = (ToggleButton) findViewById(R.id.toggleBtn);
        toggleBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FlashLightController controller = new FlashLightController(isChecked);
                controller.controller();
            }
        });
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Toast toast = Toast.makeText(Widget.this, R.string.gesture_down, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        Toast toast = Toast.makeText(Widget.this, R.string.gesture_show_press, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        Toast toast = Toast.makeText(Widget.this, R.string.gesture_single_tap_up, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Toast toast = Toast.makeText(Widget.this, R.string.gesture_scroll, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Toast toast = Toast.makeText(Widget.this, R.string.gesture_long_press, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Toast toast = Toast.makeText(Widget.this, R.string.gesture_fling, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        return true;
    }
}
