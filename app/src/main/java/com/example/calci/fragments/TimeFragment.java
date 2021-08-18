package com.example.calci.fragments;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.calci.R;


public class TimeFragment extends Fragment {

    EditText timeValue1;
    TextView timeValue2;
    String ut1 = "ms",ut2 = "ms";

    public TimeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_time, container, false);


        Spinner spinner1 = view.findViewById(R.id.time_spinner1);
        Spinner spinner2 = view.findViewById(R.id.time_spinner2);

        TextView unit1 = view.findViewById(R.id.time_unit_tv1);
        TextView unit2 = view.findViewById(R.id.time_unit_tv2);
        timeValue1 = view.findViewById(R.id.time_value_tv1);
        timeValue2 = view.findViewById(R.id.time_value_tv2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ut1 = (String) parent.getItemAtPosition(position);
                ut1=ut1.substring(ut1.lastIndexOf(" ")+2,ut1.length()-1);
                unit1.setText(ut1);

                timeValue2.setText(convert(ut1,ut2,timeValue1.getText().toString()));

                timeValue1.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        timeValue2.setText(convert(ut1,ut2,timeValue1.getText().toString()));
                        return false;
                    }
                });

//                Toast.makeText(getContext(), (String) parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ut2 = (String) parent.getItemAtPosition(position);
                ut2=ut2.substring(ut2.lastIndexOf(" ")+2,ut2.length()-1);
                unit2.setText(ut2);

                timeValue2.setText(convert(ut1,ut2,timeValue1.getText().toString()));

//                Toast.makeText(getContext(), (String) parent.getItemAtPosition(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }


    public String convert(String u1,String u2,String val){
        switch (u1) {
            case "ms" :
                switch (u2){
                    case "ms" : return sameUnit(val);
                    case "s": return msToS(val);
                    case "min" : return msToMin(val);
                    case "h": return msToH(val);
                    case "d": return msToD(val);
                    case "wk": return msToWk(val);
                    default:return "";
                }
            case "s":
                switch (u2){
                    case "ms" : return sToMs(val);
                    case "s": return sameUnit(val);
                    case "min" : return sToMin(val);
                    case "h": return sToH(val);
                    case "d": return sToD(val);
                    case "wk": return sToWk(val);
                    default:return "";
                }
            case "min" :
                switch (u2){
                    case "ms" : return minToMs(val);
                    case "s": return minToS(val);
                    case "min" : return sameUnit(val);
                    case "h": return minToH(val);
                    case "d": return minToD(val);
                    case "wk": return minToWk(val);
                    default:return "";
                }
            case "h":
                switch (u2){
                    case "ms" : return hToMs(val);
                    case "s": return hToS(val);
                    case "min" : return hToMin(val);
                    case "h": return sameUnit(val);
                    case "d": return hToD(val);
                    case "wk": return hToWk(val);
                    default:return "";
                }
            case "d":
                switch (u2){
                    case "ms" : return dToMs(val);
                    case "s": return dToS(val);
                    case "min" : return dToMin(val);
                    case "h": return dToH(val);
                    case "d": return sameUnit(val);
                    case "wk": return dToWk(val);
                    default:return "";
                }
            case "wk":
                switch (u2){
                    case "ms" : return wkToMs(val);
                    case "s": return wkToS(val);
                    case "min" : return wkToMin(val);
                    case "h": return wkToH(val);
                    case "d": return wkToD(val);
                    case "wk": return sameUnit(val);
                    default:return "";
                }
            default:
                return "";
        }
    }

    public String sameUnit(String u){
        return u;
    }
    public String msToS(String val){
        if(val.equals("")) return "";
        return String.valueOf(0.001 * Double.parseDouble(val));
    }
    public String msToMin(String val){
        if(val.equals("")) return "";
        return String.valueOf(0.0000166667 * Double.parseDouble(val));
    }
    public String msToH(String val){
        if(val.equals("")) return "";
        return String.valueOf(2.77777778E-7 * Double.parseDouble(val));
    }
    public String msToD(String val){
        if(val.equals("")) return "";
        return String.valueOf(1.15740741E-8 * Double.parseDouble(val));
    }
    public String msToWk(String val){
        if(val.equals("")) return "";
        return String.valueOf(1.65343915E-9 * Double.parseDouble(val));
    }

    public String sToMs(String val){
        if(val.equals("")) return "";
        return String.valueOf(1000 * Double.parseDouble(val));
    }
    public String sToMin(String val){
        if(val.equals("")) return "";
        return String.valueOf(0.0166666667 * Double.parseDouble(val));
    }
    public String sToH(String val){
        if(val.equals("")) return "";
        return String.valueOf(0.0002777778 * Double.parseDouble(val));
    }
    public String sToD(String val){
        if(val.equals("")) return "";
        return String.valueOf(0.0000115741 * Double.parseDouble(val));
    }
    public String sToWk(String val){
        if(val.equals("")) return "";
        return String.valueOf(0.0000016534 * Double.parseDouble(val));
    }

    public String minToMs(String val){
        if(val.equals("")) return "";
        return String.valueOf(60000 * Double.parseDouble(val));
    }
    public String minToS(String val){
        if(val.equals("")) return "";
        return String.valueOf(60 * Double.parseDouble(val));
    }
    public String minToH(String val){
        if(val.equals("")) return "";
        return String.valueOf(0.0166666667 * Double.parseDouble(val));
    }
    public String minToD(String val){
        if(val.equals("")) return "";
        return String.valueOf(0.0006944444 * Double.parseDouble(val));
    }
    public String minToWk(String val){
        if(val.equals("")) return "";
        return String.valueOf(0.0000992063 * Double.parseDouble(val));
    }

    public String hToMs(String val){
        if(val.equals("")) return "";
        return String.valueOf(3600000 * Double.parseDouble(val));
    }
    public String hToS(String val){
        if(val.equals("")) return "";
        return String.valueOf(3600 * Double.parseDouble(val));
    }
    public String hToMin(String val){
        if(val.equals("")) return "";
        return String.valueOf(60 * Double.parseDouble(val));
    }
    public String hToD(String val){
        if(val.equals("")) return "";
        return String.valueOf(0.0416666667 * Double.parseDouble(val));
    }
    public String hToWk(String val){
        if(val.equals("")) return "";
        return String.valueOf(0.005952381 * Double.parseDouble(val));
    }

    public String dToMs(String val){
        if(val.equals("")) return "";
        return String.valueOf(86400000 * Double.parseDouble(val));
    }
    public String dToS(String val){
        if(val.equals("")) return "";
        return String.valueOf(86400 * Double.parseDouble(val));
    }
    public String dToMin(String val){
        if(val.equals("")) return "";
        return String.valueOf(1440 * Double.parseDouble(val));
    }
    public String dToH(String val){
        if(val.equals("")) return "";
        return String.valueOf(24 * Double.parseDouble(val));
    }
    public String dToWk(String val){
        if(val.equals("")) return "";
        return String.valueOf(0.1428571429 * Double.parseDouble(val));
    }

    public String wkToMs(String val){
        if(val.equals("")) return "";
        return String.valueOf(604800000 * Double.parseDouble(val));
    }
    public String wkToS(String val){
        if(val.equals("")) return "";
        return String.valueOf(604800 * Double.parseDouble(val));
    }
    public String wkToMin(String val){
        if(val.equals("")) return "";
        return String.valueOf(10080 * Double.parseDouble(val));
    }
    public String wkToH(String val){
        if(val.equals("")) return "";
        return String.valueOf(168 * Double.parseDouble(val));
    }
    public String wkToD(String val){
        if(val.equals("")) return "";
        return String.valueOf(7 * Double.parseDouble(val));
    }

}