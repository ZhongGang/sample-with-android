package com.example.core;

import android.app.Activity;
import android.content.Intent;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-5
 * Time: 下午11:04
 */
public class IntentRedirector {

    public static void redirect(Activity activity, Class clazz) {
        Intent intent = new Intent();
        intent.setClass(activity, clazz);
        activity.startActivity(intent);
    }
}
