package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        Intent intent = getIntent();
        String shopName = intent.getStringExtra("shopName");
        EditText descriptionInput = (EditText) findViewById(R.id.description);
        descriptionInput.setText(shopName);

        Button saveBtn = (Button) findViewById(R.id.save);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                new AlertDialog.Builder(ShopForm.this).setTitle(R.string.tip).setMessage(R.string.save).show();
                Toast.makeText(ShopForm.this, R.string.save, Toast.LENGTH_LONG).show();
            }
        });

        Button backBtn = (Button) findViewById(R.id.back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ShopForm.this, Decorator.class);
                startActivity(intent);
            }
        });
    }


}
