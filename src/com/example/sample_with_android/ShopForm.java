package com.example.sample_with_android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.example.core.WidgetDisplayer;

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

        Spinner widgetSelect = (Spinner) findViewById(R.id.widgetSelect);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.widgets, android.R.layout.simple_spinner_dropdown_item);
        widgetSelect.setAdapter(adapter);
        widgetSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                TextView name = (TextView) findViewById(R.id.name);
                name.setText(adapter.getItem(i));
                WidgetDisplayer displayer = new WidgetDisplayer(ShopForm.this);
                displayer.display();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }


}
