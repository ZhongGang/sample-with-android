package com.example.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;

public class LoginForm extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Button loginBtn = (Button) findViewById(R.id.login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText usernameInput = (EditText) findViewById(R.id.usernameInput);
                Animation animation = new RotateAnimation(0.0f, 360.0f);
                animation.setInterpolator(new AccelerateDecelerateInterpolator());
                animation.setDuration(3000);
                usernameInput.startAnimation(animation);

                new AlertDialog.Builder(LoginForm.this).setTitle(R.string.tip).setMessage(R.string.login).show();
            }
        });

        Button backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("shopName", "星运超市");
                intent.setClass(LoginForm.this, Decorator.class);
                startActivity(intent);
            }
        });
    }

}
