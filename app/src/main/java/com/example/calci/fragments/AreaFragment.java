package com.example.calci.fragments;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.calci.ConverterActivity;
import com.example.calci.R;

public class AreaFragment extends Fragment {
    EditText areaValue1;
    TextView areaValue2;
    String ut1 = "ac",ut2 = "ac";


    public AreaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_area, container, false);

        // finding the views by their ids
        Spinner spinner1 = view.findViewById(R.id.area_spinner1);
        Spinner spinner2 = view.findViewById(R.id.area_spinner2);

        TextView unit1 = view.findViewById(R.id.area_unit_tv1);
        TextView unit2 = view.findViewById(R.id.area_unit_tv2);
        areaValue1 = view.findViewById(R.id.area_value_tv1);
        areaValue2 = view.findViewById(R.id.area_value_tv2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ut1 = (String) parent.getItemAtPosition(position);
                ut1=ut1.substring(ut1.lastIndexOf(" ")+2,ut1.length()-1);
                unit1.setText(ut1);

                areaValue2.setText(convert(ut1,ut2,areaValue1.getText().toString()));

                areaValue1.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        areaValue2.setText(convert(ut1,ut2,areaValue1.getText().toString()));
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

                areaValue2.setText(convert(ut1,ut2,areaValue1.getText().toString()));

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
            case "ac" :
                switch (u2){
                    case "ac" :
                        return sameUnit(val);
                    case "a":
                        return acreToAres(val);
                    case "ha" :
                        return acreToHectares(val);
                    case "cm^2":
                        return acreToSquareCentimetres(val);
                    case "ft^2":
                        return acreToSquareFeet(val);
                    case "in^2":
                        return acreToSquareInches(val);
                    case "m^2":
                        return acreToSquareMetres(val);
                    default:return "";
                }
            case "a":
                switch (u2){
                    case "ac" :
                        return aresToAcres(val);
                    case "a":
                        return sameUnit(val);
                    case "ha" :
                        return aresToHectares(val);
                    case "cm^2":
                        return aresToSquareCentimetres(val);
                    case "ft^2":
                        return aresToSquareFeet(val);
                    case "in^2":
                        return aresToSquareInches(val);
                    case "m^2":
                        return aresToSquareMetres(val);
                    default: return "";
                }
            case "ha" :
                switch (u2){
                    case "ac" : return hectareToAcres(val);
                    case "a": return hectareToAres(val);
                    case "ha" : return sameUnit(val);
                    case "cm^2": return hectareToSquareCentimetres(val);
                    case "ft^2": return hectareToSquareFeet(val);
                    case "in^2": return hectareToSquareInches(val);
                    case "m^2": return hectareToSquareMetres(val);
                    default: return "";
                }
            case "cm^2":
                switch (u2){
                    case "ac" : return squareCentimetresToAcres(val);
                    case "a": return squareCentimetresToAres(val);
                    case "ha" : return squareCentimetresToHectares(val);
                    case "cm^2": return sameUnit(val);
                    case "ft^2": return squareCentimetresToSquareFeet(val);
                    case "in^2": return squareCentimetresToSquareInches(val);
                    case "m^2": return squareCentimetresToSquareMetres(val);
                    default: return "";
                }
            case "ft^2":
                switch (u2){
                    case "ac" : return squareFeetToAcres(val);
                    case "a": return squareFeetToAres(val);
                    case "ha" : return squareFeetToHectare(val);
                    case "cm^2": return squareFeetToSquareCentimetres(val);
                    case "ft^2": return sameUnit(val);
                    case "in^2": return squareFeetToSquareInches(val);
                    case "m^2": return squareFeetToSquareMetres(val);
                    default: return "";
                }
            case "in^2":
                switch (u2){
                    case "ac" : return squareInchesToAcres(val);
                    case "a": return squareInchesToAres(val);
                    case "ha" : return squareInchesToHectares(val);
                    case "cm^2": return squareInchesToSquareCentimetres(val);
                    case "ft^2": return squareInchesToSquareFeet(val);
                    case "in^2": return sameUnit(val);
                    case "m^2": return squareInchesToSquareMetres(val);
                    default: return "";
                }
            case "m^2":
                switch (u2){
                    case "ac" : return squareMetresToAcres(val);
                    case "a": return squareMetresToAres(val);
                    case "ha" : return squareMetresToHectares(val);
                    case "cm^2": return squareMetresToSquareCentimetres(val);
                    case "ft^2": return squareMetresToSquareFeet(val);
                    case "in^2": return squareMetresToSquareInches(val);
                    case "m^2": return sameUnit(val);
                    default: return "";
                }
            default:
                return "";
        }
    }

    public String sameUnit(String u){
        return u;
    }

    public String acreToAres(String acre){
        if(acre.equals("")) return "";
        return String.valueOf(40.4686 * Double.parseDouble(acre));
    }

    public String acreToHectares(String acre){
        if(acre.equals("")) return "";
        return String.valueOf(0.404686 * Double.parseDouble(acre));
    }

    public String acreToSquareCentimetres(String acre){
        if(acre.equals("")) return "";
        return String.valueOf(4.047e+7 * Double.parseDouble(acre));
    }

    public String acreToSquareFeet(String acre){
        if(acre.equals("")) return "";
        return String.valueOf(43560 * Double.parseDouble(acre));
    }

    public String acreToSquareInches(String acre){
        if(acre.equals("")) return "";
        return String.valueOf(6.273e+6 * Double.parseDouble(acre));
    }

    public String acreToSquareMetres(String acre){
        if(acre.equals("")) return "";
        return String.valueOf(4046.86 * Double.parseDouble(acre));
    }

    public String aresToAcres(String are){
        if(are.equals("")) return "";
        return String.valueOf(0.0247105 * Double.parseDouble(are));
    }
    public String aresToHectares(String are){
        if(are.equals("")) return "";
        return String.valueOf(0.01 * Double.parseDouble(are));
    }
    public String aresToSquareCentimetres(String are){
        if(are.equals("")) return "";
        return String.valueOf(1000000 * Double.parseDouble(are));
    }
    public String aresToSquareFeet(String are){
        if(are.equals("")) return "";
        return String.valueOf(1076.39 * Double.parseDouble(are));
    }
    public String aresToSquareInches(String are){
        if(are.equals("")) return "";
        return String.valueOf(155000 * Double.parseDouble(are));
    }
    public String aresToSquareMetres(String are){
        if(are.equals("")) return "";
        return String.valueOf(100 * Double.parseDouble(are));
    }

    public String hectareToAcres(String hec){
        if(hec.equals("")) return "";
        return String.valueOf(2.47105 * Double.parseDouble(hec));
    }
    public String hectareToAres(String hec){
        if(hec.equals("")) return "";
        return String.valueOf(100 * Double.parseDouble(hec));
    }
    public String hectareToSquareCentimetres(String hec){
        if(hec.equals("")) return "";
        return String.valueOf(1e+8 * Double.parseDouble(hec));
    }
    public String hectareToSquareFeet(String hec){
        if(hec.equals("")) return "";
        return String.valueOf(107639 * Double.parseDouble(hec));
    }
    public String hectareToSquareInches(String hec){
        if(hec.equals("")) return "";
        return String.valueOf(1.55e+7 * Double.parseDouble(hec));
    }
    public String hectareToSquareMetres(String hec){
        if(hec.equals("")) return "";
        return String.valueOf(10000 * Double.parseDouble(hec));
    }

    public String squareCentimetresToAcres(String sc){
        if(sc.equals("")) return "";
        return String.valueOf(2.4711e-8 * Double.parseDouble(sc));
    }
    public String squareCentimetresToAres(String sc){
        if(sc.equals("")) return "";
        return String.valueOf(1e-6 * Double.parseDouble(sc));
    }
    public String squareCentimetresToHectares(String sc){
        if(sc.equals("")) return "";
        return String.valueOf(1e-8 * Double.parseDouble(sc));
    }
    public String squareCentimetresToSquareFeet(String sc){
        if(sc.equals("")) return "";
        return String.valueOf(0.00107639 * Double.parseDouble(sc));
    }
    public String squareCentimetresToSquareInches(String sc){
        if(sc.equals("")) return "";
        return String.valueOf(0.155 * Double.parseDouble(sc));
    }
    public String squareCentimetresToSquareMetres(String sc){
        if(sc.equals("")) return "";
        return String.valueOf(1e-4 * Double.parseDouble(sc));
    }

    public String squareFeetToAcres(String sf){
        if(sf.equals("")) return "";
        return String.valueOf(2.2957e-5 * Double.parseDouble(sf));
    }
    public String squareFeetToAres(String sf){
        if(sf.equals("")) return "";
        return String.valueOf(0.00092903 * Double.parseDouble(sf));
    }
    public String squareFeetToHectare(String sf){
        if(sf.equals("")) return "";
        return String.valueOf(9.2903e-6 * Double.parseDouble(sf));
    }
    public String squareFeetToSquareCentimetres(String sf){
        if(sf.equals("")) return "";
        return String.valueOf(929.03 * Double.parseDouble(sf));
    }
    public String squareFeetToSquareInches(String sf){
        if(sf.equals("")) return "";
        return String.valueOf(144 * Double.parseDouble(sf));
    }
    public String squareFeetToSquareMetres(String sf){
        if(sf.equals("")) return "";
        return String.valueOf(0.092903 * Double.parseDouble(sf));
    }

    public String squareInchesToAcres(String si){
        if(si.equals("")) return "";
        return String.valueOf(1.5942e-7 * Double.parseDouble(si));
    }
    public String squareInchesToAres(String si){
        if(si.equals("")) return "";
        return String.valueOf(6.4516e-6 * Double.parseDouble(si));
    }
    public String squareInchesToHectares(String si){
        if(si.equals("")) return "";
        return String.valueOf(6.4516e-8 * Double.parseDouble(si));
    }
    public String squareInchesToSquareCentimetres(String si){
        if(si.equals("")) return "";
        return String.valueOf(6.4516 * Double.parseDouble(si));
    }
    public String squareInchesToSquareFeet(String si){
        if(si.equals("")) return "";
        return String.valueOf(0.00694444 * Double.parseDouble(si));
    }
    public String squareInchesToSquareMetres(String si){
        if(si.equals("")) return "";
        return String.valueOf(0.00064516 * Double.parseDouble(si));
    }

    public String squareMetresToAcres(String sm){
        if(sm.equals("")) return "";
        return String.valueOf(0.000247105 * Double.parseDouble(sm));
    }
    public String squareMetresToAres(String sm){
        if(sm.equals("")) return "";
        return String.valueOf(0.01 * Double.parseDouble(sm));
    }
    public String squareMetresToHectares(String sm){
        if(sm.equals("")) return "";
        return String.valueOf(1e-4 * Double.parseDouble(sm));
    }
    public String squareMetresToSquareCentimetres(String sm){
        if(sm.equals("")) return "";
        return String.valueOf(10000 * Double.parseDouble(sm));
    }
    public String squareMetresToSquareFeet(String sm){
        if(sm.equals("")) return "";
        return String.valueOf(10.7639 * Double.parseDouble(sm));
    }
    public String squareMetresToSquareInches(String sm){
        if(sm.equals("")) return "";
        return String.valueOf(1550 * Double.parseDouble(sm));
    }

}