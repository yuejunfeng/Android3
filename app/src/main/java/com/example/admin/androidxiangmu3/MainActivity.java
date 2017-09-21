package com.example.admin.androidxiangmu3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.androidxiangmu3.view.AddsubView;

public class MainActivity extends AppCompatActivity {

    private AddsubView add1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add1 = (AddsubView) findViewById(R.id.add1);
        add1.setmMaxValue(100);
        add1.setmMinValue(1);
    }
}
