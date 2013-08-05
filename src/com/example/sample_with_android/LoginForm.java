package com.example.sample_with_android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import com.example.core.FlashLightController;

public class LoginForm extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button loginBtn = (Button) findViewById(R.id.login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(LoginForm.this).setTitle(R.string.tip).setMessage(R.string.login).show();
            }
        });

        Button redirectBtn = (Button) findViewById(R.id.redirect);
        redirectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("shopName", "星运超市");
                intent.setClass(LoginForm.this, ShopForm.class);
                startActivity(intent);
            }
        });
    }

}
