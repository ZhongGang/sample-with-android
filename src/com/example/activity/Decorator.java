package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import com.example.core.IntentRedirector;
import com.example.core.WidgetDisplayer;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-5
 * Time: 下午7:50
 */
public class Decorator extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decorator);

        Button logonBtn = (Button) findViewById(R.id.logonBtn);
        logonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentRedirector.redirect(Decorator.this, LoginForm.class);
            }
        });

        Button shopBtn = (Button) findViewById(R.id.shopBtn);
        shopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("shopName", "星运超市");
                intent.setClass(Decorator.this, ShopForm.class);
                startActivity(intent);
            }
        });

        Button widgetBtn = (Button) findViewById(R.id.widgetBtn);
        widgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentRedirector.redirect(Decorator.this, Widget.class);
            }
        });


        Spinner widgetSelect = (Spinner) findViewById(R.id.selectBtn);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.widgets, android.R.layout.simple_spinner_dropdown_item);
        widgetSelect.setAdapter(adapter);
        widgetSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                WidgetDisplayer displayer = new WidgetDisplayer(Decorator.this);
                displayer.display();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        Button listBtn = (Button) findViewById(R.id.listBtn);
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentRedirector.redirect(Decorator.this, ListData.class);
            }
        });

        Button recordBtn = (Button) findViewById(R.id.recordBtn);
        recordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("audio/amr");
                startActivityForResult(intent, 3);
            }
        });

        Button videoBtn = (Button) findViewById(R.id.videoBtn);
        videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0);
                startActivityForResult(intent, 2);
            }
        });
    }
}
