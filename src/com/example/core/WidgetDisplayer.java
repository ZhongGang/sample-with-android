package com.example.core;

import android.app.Activity;
import android.content.Intent;
import android.widget.EditText;
import com.example.sample_with_android.Calendar;
import com.example.sample_with_android.Date;
import com.example.sample_with_android.R;
import com.example.sample_with_android.Time;

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

        boolean success = false;

        for (WidgetDisplay widgetDisplay : widgetDisplays) {
            if (widgetDisplay.support()) {
                success = true;
                widgetDisplay.display();
            }
        }

        if (!success) {
            new DateWidgetDisplay(activity).display();
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
            EditText name = (EditText) activity.findViewById(R.id.name);
            String content = name.getText().toString();
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
            return "date";
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
            return "time";
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
            return "calendar";
        }
    }
}
