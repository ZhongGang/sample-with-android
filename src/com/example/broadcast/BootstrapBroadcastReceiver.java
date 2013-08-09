package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.example.activity.ListData;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-7
 * Time: 下午9:35
 */
public class BootstrapBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, ListData.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("bootstrap", true);
        context.startActivity(i);
    }
}
