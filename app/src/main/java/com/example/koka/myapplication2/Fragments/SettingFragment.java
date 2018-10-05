package com.example.koka.myapplication2.Fragments;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Conference;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.koka.myapplication2.Helper.LocaleHelper;
import com.example.koka.myapplication2.MainActivity;
import com.example.koka.myapplication2.R;
import com.example.koka.myapplication2.TempActivity;

import java.util.Locale;

import io.paperdb.Paper;

import static android.content.Context.MODE_PRIVATE;


public class SettingFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_setting, container, false);

        Paper.init(this.getContext());

        String language = Paper.book().read("language");
        if (language == null)
            Paper.book().write("language", "en");

        updateView((String) Paper.book().read("language"));

        final RadioButton radioButtonen = view.findViewById(R.id.check_en);
        final RadioButton radioButtonar = view.findViewById(R.id.check_ar);
        Button button = view.findViewById(R.id.ok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main_activity_Intent = new Intent(getContext(), TempActivity.class);
                if (radioButtonar.isChecked()) {
                    Paper.book().write("language", "ar");
                    updateView((String) Paper.book().read("language"));
                    startActivity(main_activity_Intent);
                    getActivity().finish();

                } else if (radioButtonen.isChecked()) {
                    Paper.book().write("language", "en");
                    updateView((String) Paper.book().read("language"));
                    startActivity(main_activity_Intent);
                    getActivity().finish();
                } else {
                    Snackbar.make(view, getResources().getString(R.string.Nothing_Selected), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });


        return view;
    }

    private void updateView(String language) {
        Context context = LocaleHelper.setLocale(this.getContext(), language);
//        Resources resources = context.getResources();
//        tvlang.setText(resources.getString(R.string.settingtext));

    }














    /* private void setLocale(String ar) {

        Locale locale = new Locale(ar);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getContext().getResources().updateConfiguration(config, getContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getContext().getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", ar);
        editor.apply();
    }

    public void loadLocale() {

        SharedPreferences preferences = getContext().getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String lang = preferences.getString("My_Lang", "");
        setLocale(lang);

    }*/


}
