package com.example.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

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

        ListView listView = (ListView) findViewById(R.id.listView);
        ListAdapter listAdapter = ArrayAdapter.createFromResource(this, R.array.listData, android.R.layout.simple_expandable_list_item_1);
        listView.setAdapter(listAdapter);

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
