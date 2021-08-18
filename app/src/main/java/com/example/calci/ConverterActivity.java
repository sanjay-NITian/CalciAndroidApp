package com.example.calci;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.calci.adapters.FragmentAdapter;
import com.example.calci.fragments.AreaFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ConverterActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;

    //

    Button con7,con8,con9,con_back,con4,con5,con6,con_c,con1,con2,con3,con_up,con_plus_minus,con0,con_dot,con_down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);


        // Hiding the action bar
        getSupportActionBar().setTitle("Unit Converter");

        // Finding the button by their ids
//        con7 = findViewById(R.id.converter_button7);
//        con8 = findViewById(R.id.converter_button8);
//        con9 = findViewById(R.id.converter_button9);
//        con4 = findViewById(R.id.converter_button4);
//        con5 = findViewById(R.id.converter_button5);
//        con6 = findViewById(R.id.converter_button6);
//        con1 = findViewById(R.id.converter_button1);
//        con2 = findViewById(R.id.converter_button2);
//        con3 = findViewById(R.id.converter_button3);
//        con_back = findViewById(R.id.converter_button_back);
//        con_c = findViewById(R.id.converter_button_c);
//        con_plus_minus = findViewById(R.id.converter_btn_plus_min);
//        con0 = findViewById(R.id.converter_button0);
//        con_dot = findViewById(R.id.converter_btn_point);
//        con_down = findViewById(R.id.converter_button_down);
//        con_up = findViewById(R.id.converter_button_up);
//
//
//        // Setting the on click listener on each button
//        con7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onTouchButtonBackgroundEffect(v);
//
//            }
//        });
//
//        con8.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onTouchButtonBackgroundEffect(v);
//
//            }
//        });
//
//        con9.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onTouchButtonBackgroundEffect(v);
//
//            }
//        });
//
//        con0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onTouchButtonBackgroundEffect(v);
//
//            }
//        });
//
//        con1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onTouchButtonBackgroundEffect(v);
//
//            }
//        });
//
//        con2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onTouchButtonBackgroundEffect(v);
//
//            }
//        });
//
//        con3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onTouchButtonBackgroundEffect(v);
//
//            }
//        });
//
//        con4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onTouchButtonBackgroundEffect(v);
//
//            }
//        });
//
//        con5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onTouchButtonBackgroundEffect(v);
//
//            }
//        });
//
//        con6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onTouchButtonBackgroundEffect(v);
//
//            }
//        });
//
//        con_back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onTouchButtonBackgroundEffect(v);
//
//            }
//        });
//
//        con_c.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onTouchButtonBackgroundEffect(v);
//
//            }
//        });
//
//        con_dot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onTouchButtonBackgroundEffect(v);
//
//            }
//        });
//
//        con_down.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onTouchButtonBackgroundEffect(v);
//
//            }
//        });
//
//        con_plus_minus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onTouchButtonBackgroundEffect(v);
//
//
//            }
//        });
//
//        con_up.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onTouchButtonBackgroundEffect(v);
//
//            }
//        });
//
//
//
//        // Getting the intent from the another intent
//        Intent intent = getIntent();
//
//
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager()));

        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }

    public void onTouchButtonBackgroundEffect(View view){
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(45);

        view.setTranslationX(25f);
        view.animate().translationXBy(-25f).setDuration(80);
        view.setTranslationY(25f);
        view.animate().translationYBy(-25f).setDuration(80);
    }

}