package com.example.core;

import android.app.Activity;
import android.content.Intent;
import android.widget.Spinner;
import com.example.activity.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-3
 * Time: 下午8:37
 */
public class WidgetDisplayer {
    private Activity activity;

    public WidgetDisplayer(Activity activity) {
        this.activity = activity;
    }

    public void display() {
        List<WidgetDisplay> widgetDisplays = new ArrayList<WidgetDisplay>();
        widgetDisplays.add(new DateWidgetDisplay(activity));
        widgetDisplays.add(new TimeWidgetDisplay(activity));
        widgetDisplays.add(new CalendarWidgetDisplay(activity));
        widgetDisplays.add(new WidgetsDisplay(activity));

        for (WidgetDisplay widgetDisplay : widgetDisplays) {
            if (widgetDisplay.support()) {
                widgetDisplay.display();
            }
        }
    }

    interface WidgetDisplay {

        boolean support();

        void display();
    }

    abstract class AbstractWidgetDisplay implements WidgetDisplay {
        private Activity activity;

        protected AbstractWidgetDisplay(Activity activity) {
            this.activity = activity;
        }

        @Override
        public boolean support() {
            Spinner spinner = (Spinner) activity.findViewById(R.id.selectBtn);
            String content = (String) spinner.getSelectedItem();
            return content.trim().equalsIgnoreCase(equalsName());
        }

        @Override
        public void display() {
            Intent intent = new Intent();
            intent.setClass(activity, getWidgetClass());
            activity.startActivity(intent);
        }

        protected abstract Class getWidgetClass();

        protected abstract String equalsName();
    }

    class DateWidgetDisplay extends AbstractWidgetDisplay {

        protected DateWidgetDisplay(Activity activity) {
            super(activity);
        }

        @Override
        protected Class getWidgetClass() {
            return Date.class;
        }

        @Override
        protected String equalsName() {
            return "日期";
        }

    }

    class TimeWidgetDisplay extends AbstractWidgetDisplay {

        protected TimeWidgetDisplay(Activity activity) {
            super(activity);
        }

        @Override
        protected Class getWidgetClass() {
            return Time.class;
        }

        @Override
        protected String equalsName() {
            return "时间";
        }
    }

    class CalendarWidgetDisplay extends AbstractWidgetDisplay {

        protected CalendarWidgetDisplay(Activity activity) {
            super(activity);
        }

        @Override
        protected Class getWidgetClass() {
            return Calendar.class;
        }

        @Override
        protected String equalsName() {
            return "日历";
        }
    }

    class WidgetsDisplay extends AbstractWidgetDisplay {

        protected WidgetsDisplay(Activity activity) {
            super(activity);
        }

        @Override
        protected Class getWidgetClass() {
            return Widget.class;
        }

        @Override
        protected String equalsName() {
            return "组件";
        }
    }
}
