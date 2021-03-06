package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-3
 * Time: 下午4:36
 */
public class ShopForm extends Activity {

    private TextView addressLabel;

    private Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            int what = msg.what;
            if (what == 0) {
                addressLabel.setText(String.valueOf(msg.obj));
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        Intent intent = getIntent();
        String shopName = intent.getStringExtra("shopName");
        final EditText nameInput = (EditText) findViewById(R.id.nameInput);
        final EditText addressInput = (EditText) findViewById(R.id.addressInput);
        final EditText descriptionInput = (EditText) findViewById(R.id.descriptionInput);
        descriptionInput.setText(shopName);

        final SharedPreferences preferences = getSharedPreferences("SHOP", MODE_PRIVATE);
        final String nameOfShop = preferences.getString("shopName", "");
        nameInput.setText(nameOfShop);
        String addressOfShop = preferences.getString("shopAddress", "");
        addressInput.setText(addressOfShop);
        String descriptionOfShop = preferences.getString("shopDescription", "");
        descriptionInput.setText(descriptionOfShop);

        Button saveBtn = (Button) findViewById(R.id.save);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor edit = preferences.edit();
                edit.putString("shopName", String.valueOf(nameInput.getText()));
                edit.putString("shopAddress", String.valueOf(addressInput.getText()));
                edit.putString("shopDescription", String.valueOf(descriptionInput.getText()));
                edit.commit();

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

        new Thread(new Runnable() {
            @Override
            public void run() {
                addressLabel = (TextView) findViewById(R.id.addressLabel);
                while (true) {
                    String value = addressLabel.getText().toString();
                    if (value.isEmpty()) {
                        Message message = new Message();
                        message.what = 0;
                        message.obj = "地 址：";
                        handler.sendMessage(message);
                    } else {
                        Message message = new Message();
                        message.what = 0;
                        message.obj = "";
                        handler.sendMessage(message);
                    }

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new UnsupportedOperationException("Not yet implemented!");
                    }
                }
            }
        }).start();
    }


}
