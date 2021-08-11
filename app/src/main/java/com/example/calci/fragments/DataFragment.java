package com.example.calci.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.calci.R;


public class DataFragment extends Fragment {


    public DataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_data, container, false);

        Spinner spinner1 = view.findViewById(R.id.data_spinner1);
        Spinner spinner2 = view.findViewById(R.id.data_spinner2);

        TextView unit1 = view.findViewById(R.id.data_unit_tv1);
        TextView unit2 = view.findViewById(R.id.data_unit_tv2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String unit = (String) parent.getItemAtPosition(position);
                unit=unit.substring(unit.lastIndexOf(" ")+2,unit.length()-1);
                unit1.setText(unit);

//                Toast.makeText(getContext(), (String) parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String unit = (String) parent.getItemAtPosition(position);
                unit=unit.substring(unit.lastIndexOf(" ")+2,unit.length()-1);
                unit2.setText(unit);

//                Toast.makeText(getContext(), (String) parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        return view;

    }


}