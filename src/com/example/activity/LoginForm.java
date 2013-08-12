package com.example.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.animation.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginForm extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final Button loginBtn = (Button) findViewById(R.id.login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(LoginForm.this).setTitle(R.string.tip).setMessage(R.string.login).show();
            }
        });

        Button rotateBtn = (Button) findViewById(R.id.rotateBtn);
        rotateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText usernameInput = (EditText) findViewById(R.id.usernameInput);
                EditText passwordInput = (EditText) findViewById(R.id.passwordInput);
                Animation rotateAnimation = new RotateAnimation(0.0f, 360.0f);
                rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                rotateAnimation.setDuration(3000);
                usernameInput.startAnimation(rotateAnimation);

                Animation alphaAnimation = new AlphaAnimation(0, 1);
                alphaAnimation.setDuration(3000);
                passwordInput.startAnimation(alphaAnimation);

                Animation scaleAnimation = new ScaleAnimation(0, 100, 10, 200);
                scaleAnimation.setDuration(3000);
                loginBtn.startAnimation(scaleAnimation);

                TextView passwordLabel = (TextView) findViewById(R.id.password);
                Animation translateAnimation = new TranslateAnimation(0, 0, 0, 400);
                translateAnimation.setDuration(3000);
                passwordLabel.startAnimation(translateAnimation);

//                Animation animation = AnimationUtils.loadAnimation(LoginForm.this, R.anim.rotate);
//                animation.setInterpolator(new AccelerateDecelerateInterpolator());
//                usernameInput.startAnimation(animation);

//                new AlertDialog.Builder(LoginForm.this).setTitle(R.string.tip).setMessage(R.string.login).show();
            }
        });
    }

}
