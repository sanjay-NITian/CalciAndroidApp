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
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.calci.R;


public class DataFragment extends Fragment {
    EditText dataValue1;
    TextView dataValue2;
    String ut1 = "ms",ut2 = "ms";

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
        dataValue1 = view.findViewById(R.id.data_value_tv1);
        dataValue2 = view.findViewById(R.id.data_value_tv2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ut1 = (String) parent.getItemAtPosition(position);
                ut1=ut1.substring(ut1.lastIndexOf(" ")+2,ut1.length()-1);
                unit1.setText(ut1);

                dataValue2.setText(convert(ut1,ut2,dataValue1.getText().toString()));

                dataValue1.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        dataValue2.setText(convert(ut1,ut2,dataValue1.getText().toString()));
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

                dataValue2.setText(convert(ut1,ut2,dataValue1.getText().toString()));

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
            case "bit" :
                switch (u2){
                    case "bit" : return sameUnit(val);
                    case "B": return bitToB(val);
                    case "KB" : return bitToKB(val);
                    case "MB":  return bitToMB(val);
                    case "GB": return bitToGB(val);
                    case "TB": return bitToTB(val);
                    default:return "";
                }
            case "B":
                switch (u2){
                    case "bit" : return bToBit(val);
                    case "B": return sameUnit(val);
                    case "KB" : return bToKB(val);
                    case "MB": return bToMB(val);
                    case "GB": return bToGB(val);
                    case "TB": return bToTB(val);
                    default:return "";
                }
            case "KB" :
                switch (u2){
                    case "bit" : return kbToBit(val);
                    case "B": return kbToB(val);
                    case "KB" : return sameUnit(val);
                    case "MB": return kbToMB(val);
                    case "GB": return kbToGB(val);
                    case "TB": return kbToTB(val);
                    default:return "";
                }
            case "MB":
                switch (u2){
                    case "bit" : return mbToBit(val);
                    case "B": return mbToB(val);
                    case "KB" : return mbToKB(val);
                    case "MB": return sameUnit(val);
                    case "GB": return mbToGB(val);
                    case "TB": return mbToTB(val);
                    default:return "";
                }
            case "GB":
                switch (u2){
                    case "bit" : return gbToBit(val);
                    case "B": return gbToB(val);
                    case "KB" : return gbToKB(val);
                    case "MB": return gbToMB(val);
                    case "GB": return sameUnit(val);
                    case "TB": return gbToTB(val);
                    default:return "";
                }
            case "TB":
                switch (u2){
                    case "bit" : return tbToBit(val);
                    case "B": return tbToB(val);
                    case "KB" : return tbToKB(val);
                    case "MB": return tbToMB(val);
                    case "GB": return tbToGB(val);
                    case "TB": return sameUnit(val);
                    default:return "";
                }
            default:
                return "";
        }
    }

    public String sameUnit(String u){
        return u;
    }
    public String bitToB(String val){
        if(val.equals("")) return "";
        return String.valueOf(0.125 * Double.parseDouble(val));
    }
    public String bitToKB(String val){
        if(val.equals("")) return "";
        return String.valueOf(0.0001220703 * Double.parseDouble(val));
    }
    public String bitToMB(String val){
        if(val.equals("")) return "";
        return String.valueOf(1.19209290E-7 * Double.parseDouble(val));
    }
    public String bitToGB(String val){
        if(val.equals("")) return "";
        return String.valueOf(1.16415322E-10 * Double.parseDouble(val));
    }
    public String bitToTB(String val){
        if(val.equals("")) return "";
        return String.valueOf(1.13686838E-13 * Double.parseDouble(val));
    }

    public String bToBit(String val){
        if(val.equals("")) return "";
        return String.valueOf(8 * Double.parseDouble(val));
    }
    public String bToKB(String val){
        if(val.equals("")) return "";
        return String.valueOf(0.0009765625 * Double.parseDouble(val));
    }
    public String bToMB(String val){
        if(val.equals("")) return "";
        return String.valueOf(9.53674316E-7 * Double.parseDouble(val));
    }
    public String bToGB(String val){
        if(val.equals("")) return "";
        return String.valueOf(9.31322575E-10 * Double.parseDouble(val));
    }
    public String bToTB(String val){
        if(val.equals("")) return "";
        return String.valueOf(9.09494702E-13 * Double.parseDouble(val));
    }

    public String kbToBit(String val){
        if(val.equals("")) return "";
        return String.valueOf(8192 * Double.parseDouble(val));
    }
    public String kbToB(String val){
        if(val.equals("")) return "";
        return String.valueOf(1024 * Double.parseDouble(val));
    }
    public String kbToMB(String val){
        if(val.equals("")) return "";
        return String.valueOf(0.0009765625 * Double.parseDouble(val));
    }
    public String kbToGB(String val){
        if(val.equals("")) return "";
        return String.valueOf(9.53674316E-7 * Double.parseDouble(val));
    }
    public String kbToTB(String val){
        if(val.equals("")) return "";
        return String.valueOf(9.31322575E-10 * Double.parseDouble(val));
    }

    public String mbToBit(String val){
        if(val.equals("")) return "";
        return String.valueOf(8388608 * Double.parseDouble(val));
    }
    public String mbToB(String val){
        if(val.equals("")) return "";
        return String.valueOf(1048576  * Double.parseDouble(val));
    }
    public String mbToKB(String val){
        if(val.equals("")) return "";
        return String.valueOf(1024 * Double.parseDouble(val));
    }
    public String mbToGB(String val){
        if(val.equals("")) return "";
        return String.valueOf(0.001 * Double.parseDouble(val));
    }
    public String mbToTB(String val){
        if(val.equals("")) return "";
        return String.valueOf(0.0009765625 * Double.parseDouble(val));
    }

    public String gbToBit(String val){
        if(val.equals("")) return "";
        return String.valueOf(8.589934592E9 * Double.parseDouble(val));
    }
    public String gbToB(String val){
        if(val.equals("")) return "";
        return String.valueOf(1073741824 * Double.parseDouble(val));
    }
    public String gbToKB(String val){
        if(val.equals("")) return "";
        return String.valueOf(1048576 * Double.parseDouble(val));
    }
    public String gbToMB(String val){
        if(val.equals("")) return "";
        return String.valueOf(1024 * Double.parseDouble(val));
    }
    public String gbToTB(String val){
        if(val.equals("")) return "";
        return String.valueOf(0.0009765625 * Double.parseDouble(val));
    }

    public String tbToBit(String val){
        if(val.equals("")) return "";
        return String.valueOf(8.796093022208E12 * Double.parseDouble(val));
    }
    public String tbToB(String val){
        if(val.equals("")) return "";
        return String.valueOf(1.099511627776E12 * Double.parseDouble(val));
    }
    public String tbToKB(String val){
        if(val.equals("")) return "";
        return String.valueOf(1.073741824E9 * Double.parseDouble(val));
    }
    public String tbToMB(String val){
        if(val.equals("")) return "";
        return String.valueOf(1048576 * Double.parseDouble(val));
    }
    public String tbToGB(String val){
        if(val.equals("")) return "";
        return String.valueOf(1024 * Double.parseDouble(val));
    }

}