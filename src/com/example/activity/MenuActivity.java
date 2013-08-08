package com.example.activity;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-8
 * Time: 上午11:42
 */
public class MenuActivity extends Activity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, Menu.FIRST, 0, "设置");
        menu.add(0, Menu.FIRST + 1, 0, "音乐");
        menu.add(0, Menu.FIRST + 2, 0, "娱乐");
        menu.add(0, Menu.FIRST + 3, 0, "新闻");
        menu.add(0, Menu.FIRST + 4, 0, "视频");
        menu.add(0, Menu.FIRST + 5, 0, "图片");
        menu.add(0, Menu.FIRST + 6, 0, "体育");
        menu.add(0, Menu.FIRST + 7, 0, "国际");
        menu.add(0, Menu.FIRST + 8, 0, "军事");
        menu.add(0, Menu.FIRST + 9, 0, "历史");
        menu.add(0, Menu.FIRST + 10, 0, "退出");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        throw new UnsupportedOperationException("Not yet implemented!");
    }
}
