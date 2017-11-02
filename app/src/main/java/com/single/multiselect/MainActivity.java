package com.single.multiselect;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TimePopWindow timePopWindow = new TimePopWindow(this);
        findViewById(R.id.select).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.back).setVisibility(View.VISIBLE);
                findViewById(R.id.show_address).setVisibility(View.VISIBLE);
                timePopWindow.showAtLocation(findViewById(android.R.id.content), Gravity.BOTTOM, 0, 0);
            }
        });
        timePopWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                findViewById(R.id.back).setVisibility(View.GONE);
            }
        });

    }

    public void setAddress(String address) {
        ((TextView) findViewById(R.id.show_address)).setText(address);
    }
}
