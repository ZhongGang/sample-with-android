package com.example.sample_with_android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-3
 * Time: 下午4:36
 */
public class ShopForm extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        Button saveBtn = (Button) findViewById(R.id.save);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(ShopForm.this).setTitle(R.string.tip).setMessage(R.string.save).show();
            }
        });

        Button backBtn = (Button) findViewById(R.id.back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ShopForm.this, LoginForm.class);
                startActivity(intent);
            }
        });

        Button timeViewBtn = (Button) findViewById(R.id.timeView);
        timeViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ShopForm.this, Time.class);
                startActivity(intent);
            }
        });

        Button dateViewBtn = (Button) findViewById(R.id.dateView);
        dateViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ShopForm.this, Date.class);
                startActivity(intent);
            }
        });

        Button calendarViewBtn = (Button) findViewById(R.id.calendarView);
        calendarViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ShopForm.this, Calendar.class);
                startActivity(intent);
            }
        });
    }


}
