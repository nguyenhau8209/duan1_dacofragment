package com.example.duan1_pro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ManHinhCho extends AppCompatActivity {
    ImageView imglogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_cho);
        imglogo = findViewById(R.id.imglogo);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.amin);
        imglogo.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ManHinhCho.this,Login.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}