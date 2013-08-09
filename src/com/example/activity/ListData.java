package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-4
 * Time: 上午2:49
 */
public class ListData extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list);

        Intent intent = getIntent();
        boolean bootstrap = intent.getBooleanExtra("bootstrap", false);
        if (bootstrap) {
            Toast toast = Toast.makeText(this, "这是由开机自启动通知运行进入的这个界面！", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0, 0);
            toast.show();
        }

        ListView listView = (ListView) findViewById(R.id.listView);
        ListAdapter listAdapter = ArrayAdapter.createFromResource(this, R.array.listData, android.R.layout.simple_expandable_list_item_1);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CharSequence[] strings = getResources().getTextArray(R.array.listData);
                Toast toast = new Toast(ListData.this);
                LayoutInflater inflate = getLayoutInflater();
                View linearLayout = inflate.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toast_linear_layout));
                TextView textView = (TextView) linearLayout.findViewById(R.id.message);
                textView.setText("你选择了{" + strings[position].toString() + "}");
                toast.setView(linearLayout);

                ImageView imageView = (ImageView) linearLayout.findViewById(R.id.toastImage);
                imageView.setImageResource(R.drawable.launcher);

                toast.setDuration(Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.show();
            }
        });

        Button backBtn = (Button) findViewById(R.id.back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(ListData.this, Decorator.class);
                startActivity(intent);
            }
        });
    }
}
