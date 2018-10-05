package com.example.koka.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.koka.myapplication2.Fragments.ContactsFragment;
import com.example.koka.myapplication2.Helper.LocaleHelper;


public class TempActivity extends AppCompatActivity {

    private static int splash_time_out = 7000;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"en"));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);


        /*ImageView imageView = findViewById(R.id.test);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.about));
        SweetAlertDialog sweetAlertDialog= new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE);
                sweetAlertDialog.setTitleText("Welcome...!");
                sweetAlertDialog.setContentText("WaslnY's App in ur service.");
                sweetAlertDialog.setCustomImage(R.drawable.about).setCancelable(false);
                sweetAlertDialog.show();*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImageView imageView = findViewById(R.id.test);
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.papers));

            }
        }, 1000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                TextView textView1=findViewById(R.id.temp_text_1);
                TextView textView2=findViewById(R.id.temp_text_2);
                textView1.setText(getResources().getString(R.string.welcome));
                textView2.setText(getResources().getString(R.string.welcometext));

            }
        }, 3000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent main_activity_Intent = new Intent(TempActivity.this, MainActivity.class);
                startActivity(main_activity_Intent);
                finish();
            }
        }, splash_time_out);


    }
}
