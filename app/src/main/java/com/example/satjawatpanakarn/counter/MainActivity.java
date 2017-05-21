package com.example.satjawatpanakarn.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int mCounter = 0;
    private TextView tvNumber;
    private Button mBtnReset;
    private Button mBtnIncrease;
    private final  String  STATE_COUNTER = "STATE_COUNTER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tvNumber = (TextView) findViewById(R.id.tv_number);
        mBtnReset = (Button) findViewById(R.id.btn_reset);
        mBtnIncrease = (Button) findViewById(R.id.btn_increase);

        mBtnReset.setOnClickListener(this);
        mBtnIncrease.setOnClickListener(this);

        if(savedInstanceState!=null) {
            mCounter = savedInstanceState.getInt(STATE_COUNTER);
        }

        UpdateNumberOfCounter();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(STATE_COUNTER,mCounter);
    }

    @Override
    public void onClick(View view) {
        if (view == mBtnReset) {
            mCounter = 0;
        }
        if (view == mBtnIncrease) {
            mCounter++;
        }

        UpdateNumberOfCounter();
    }

    private void UpdateNumberOfCounter() {
        tvNumber.setText(String.format("%04d", mCounter));
    }


}
