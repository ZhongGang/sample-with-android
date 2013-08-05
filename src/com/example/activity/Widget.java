package com.example.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.sample_with_android.R;
import com.example.sample_with_android.ShopForm;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-5
 * Time: 下午2:30
 */
public class Widget extends Activity {

    private ProgressDialog progressDialog;
    private ProgressDialog circleProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widgets);

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
    }
}
