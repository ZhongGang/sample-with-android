package com.example.activity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

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

        final List<String> contacts = new ArrayList<String>();
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, new String[]{ContactsContract.Contacts.DISPLAY_NAME}, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            contacts.add(name);
        }

        cursor.close();

        ListView listView = (ListView) findViewById(R.id.listView);
//        ListAdapter listAdapter = ArrayAdapter.createFromResource(this, R.array.listData, android.R.layout.simple_expandable_list_item_1);
        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, contacts);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                CharSequence[] strings = getResources().getTextArray(R.array.listData);
                Toast toast = new Toast(ListData.this);
                LayoutInflater inflate = getLayoutInflater();
                View linearLayout = inflate.inflate(R.layout.toast, (ViewGroup) findViewById(R.id.toast_linear_layout));
                TextView textView = (TextView) linearLayout.findViewById(R.id.message);
                textView.setText("你选择了{" + contacts.get(position) + "}");
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
