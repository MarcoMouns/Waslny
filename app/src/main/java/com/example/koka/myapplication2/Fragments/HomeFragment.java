package com.example.koka.myapplication2.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.koka.myapplication2.R;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private Spinner spinner1, spinner2;
    private Button btnSubmit;
    private TextView textView;
    String theWay;
    String note;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        spinner1 = (Spinner) view.findViewById(R.id.spinner);
        spinner2 = (Spinner) view.findViewById(R.id.spinner2);
        final List<String> list1 = new ArrayList<String>();
        /*list1.add("1- Shobra El Kheima");
        list1.add("2- Koliet El-Zeraa");
        list1.add("3- Mezallat");
        list1.add("4- Khalafawy");
        list1.add("5- Sainte Teresa");*/
        list1.add(getResources().getString(R.string.Shobra_El_Kheima));
        list1.add(getResources().getString(R.string.Koliet_El_Zeraa));
        list1.add(getResources().getString(R.string.Mezallat));
        list1.add(getResources().getString(R.string.Khalafawy));
        list1.add(getResources().getString(R.string.Sainte_Teresa));
        list1.add(getResources().getString(R.string.Road_El_Farag));
        list1.add(getResources().getString(R.string.Massara));
        list1.add(getResources().getString(R.string.Al_Shohadaa));
        list1.add(getResources().getString(R.string.Ataba));
        list1.add(getResources().getString(R.string.Mohamed_Naguib));
        list1.add(getResources().getString(R.string.Al_Sadat));
        list1.add(getResources().getString(R.string.Opera));
        list1.add(getResources().getString(R.string.Dokki));
        list1.add(getResources().getString(R.string.Bohooth));
        list1.add(getResources().getString(R.string.Cairo_University));
        list1.add(getResources().getString(R.string.Faisal));
        list1.add(getResources().getString(R.string.Giza));
        list1.add(getResources().getString(R.string.Omm_el_Misryeen));
        list1.add(getResources().getString(R.string.Sakiat_Mekki));
        list1.add(getResources().getString(R.string.El_Mounib));


        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_item, list1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter1);
        spinner2.setAdapter(dataAdapter1);

        textView = view.findViewById(R.id.textView_result);
        btnSubmit = view.findViewById(R.id.buttn_start);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < list1.size(); i++) {
                    if (String.valueOf(spinner1.getSelectedItem()) == list1.get(i)) {
                        for (int j = 0; j < list1.size(); j++) {
                            if (String.valueOf(spinner2.getSelectedItem()) == list1.get(j)) {
                                if (j == 7 || j == 10) {
                                    note =getResources().getString(R.string.note1) ;
                                } else if (j == 8) {
                                    note =getResources().getString(R.string.note2) ;
                                } else {
                                    note = "";
                                }

                                int x = j - i;
                                if (x < 0) {
                                    theWay = getResources().getString(R.string.Shobra_way);
                                    textView.setText(getResources().getString(R.string.The_way)+ "\t"+theWay +
                                            getResources().getString(R.string.Number_of_Station) +"\t" +Math.abs(x) +
                                            getResources().getString(R.string.Average_time) + "\t"+Math.abs(x * 5) + getResources().getString(R.string.Minutes)+note);
                                } else if (x > 0) {
                                    theWay = getResources().getString(R.string.Giza_way);
                                    textView.setText(getResources().getString(R.string.The_way)+ "\t"+theWay +
                                            getResources().getString(R.string.Number_of_Station) + "\t"+Math.abs(x) +
                                            getResources().getString(R.string.Average_time) + "\t"+Math.abs(x * 5) + getResources().getString(R.string.Minutes)+note);
                                } else {
                                    Snackbar.make(view, "You have select the same station.", Snackbar.LENGTH_LONG)
                                            .setAction("Action", null).show();
                                }
                            }
                        }
                    }
                }
            }
        });

        return view;
    }
}
