package com.example.activity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import com.example.core.IntentRedirector;
import com.example.core.WidgetDisplayer;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-8-5
 * Time: 下午7:50
 */
public class Decorator extends MenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decorator);

        Button logonBtn = (Button) findViewById(R.id.logonBtn);
        logonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("toLoginForm");
                startActivity(intent);
            }
        });

        Button shopBtn = (Button) findViewById(R.id.shopBtn);
        shopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("shopName", "星运超市");
                intent.setClass(Decorator.this, ShopForm.class);
                startActivity(intent);
            }
        });

        Button widgetBtn = (Button) findViewById(R.id.widgetBtn);
        widgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentRedirector.redirect(Decorator.this, Widget.class);
            }
        });


        Spinner widgetSelect = (Spinner) findViewById(R.id.selectBtn);
        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.widgets, android.R.layout.simple_spinner_dropdown_item);
        widgetSelect.setAdapter(adapter);
        widgetSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                WidgetDisplayer displayer = new WidgetDisplayer(Decorator.this);
                displayer.display();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        Button listBtn = (Button) findViewById(R.id.listBtn);
        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentRedirector.redirect(Decorator.this, ListData.class);
            }
        });

        Button recordBtn = (Button) findViewById(R.id.recordBtn);
        recordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("audio/amr");
                startActivityForResult(intent, 3);
            }
        });

        Button videoBtn = (Button) findViewById(R.id.videoBtn);
        videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0);
                startActivityForResult(intent, 2);
            }
        });

        Button dialBtn = (Button) findViewById(R.id.dialBtn);
        dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:1001011"));
                startActivity(intent);
            }
        });

        Button locationBtn = (Button) findViewById(R.id.locationBtn);
        locationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {

                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {

                    }

                    @Override
                    public void onProviderEnabled(String provider) {
                        Toast toast = Toast.makeText(Decorator.this, R.string.provider_enable, Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.BOTTOM, 0, 0);
                        toast.show();
                    }

                    @Override
                    public void onProviderDisabled(String provider) {
                        Toast toast = Toast.makeText(Decorator.this, R.string.provider_disable, Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.BOTTOM, 0, 0);
                        toast.show();
                    }
                });

                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                Toast toast = Toast.makeText(Decorator.this, "当前位置信息｛经度：" + location.getLatitude() + "；纬度：" + location.getLongitude() + "；海拔：" + location.getAltitude() + "｝", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                toast.show();
            }
        });
    }
}
