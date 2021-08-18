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


public class LengthFragment extends Fragment {
    EditText lengthValue1;
    TextView lengthValue2;
    String ut1 = "mm",ut2 = "mm";

    public LengthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_length, container, false);


        Spinner spinner1 = view.findViewById(R.id.length_spinner1);
        Spinner spinner2 = view.findViewById(R.id.length_spinner2);

        TextView unit1 = view.findViewById(R.id.length_unit_tv1);
        TextView unit2 = view.findViewById(R.id.length_unit_tv2);
        lengthValue1 = view.findViewById(R.id.length_value_tv1);
        lengthValue2 = view.findViewById(R.id.length_value_tv2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ut1 = (String) parent.getItemAtPosition(position);
                ut1=ut1.substring(ut1.lastIndexOf(" ")+2,ut1.length()-1);
                unit1.setText(ut1);

                lengthValue2.setText(convert(ut1,ut2,lengthValue1.getText().toString()));

                lengthValue1.setOnKeyListener(new View.OnKeyListener() {
                    @Override
                    public boolean onKey(View v, int keyCode, KeyEvent event) {
                        lengthValue2.setText(convert(ut1,ut2,lengthValue1.getText().toString()));
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

                lengthValue2.setText(convert(ut1,ut2,lengthValue1.getText().toString()));

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
            case "mm" :
                switch (u2) {
                    case "mm" : return sameUnit(val);
                    case "cm": return millimetreToCentimetres(val);
                    case "m" : return millimetreToMetres(val);
                    case "km": return millimetreToKiloMetres(val);
                    case "in": return millimetreToInches(val);
                    case "ft": return millimetreToFeet(val);
                    case "yd": return millimetreToYard(val);
                    case "mi": return millimetreToMiles(val);
                    case "NM": return millimetreToNauticalMiles(val);
                    case "mil": return millimetreToMils(val);
                    default:
                        return "";
                }
            case "cm":
                switch (u2) {
                    case "mm" : return centimetreToMillimetres(val);
                    case "cm": return sameUnit(val);
                    case "m" : return centimetreToMetres(val);
                    case "km": return centimetreToKiloMetres(val);
                    case "in": return centimetreToInches(val);
                    case "ft": return centimetreToFeet(val);
                    case "yd": return centimetreToYard(val);
                    case "mi": return centimetreToMiles(val);
                    case "NM": return centimetreToNauticalMiles(val);
                    case "mil": return centimetreToMils(val);
                    default:
                        return "";
                }
            case "m" :
                switch (u2) {
                    case "mm" : return metreToMillimetres(val);
                    case "cm": return metreToCentiMetres(val);
                    case "m" : return sameUnit(val);
                    case "km": return metreToKilometres(val);
                    case "in": return metreToInches(val);
                    case "ft": return metreToFeet(val);
                    case "yd": return metreToYards(val);
                    case "mi": return metreToMiles(val);
                    case "NM": return metreToNauticalMiles(val);
                    case "mil": return metreToMils(val);
                    default:
                        return "";
                }
            case "km":
                switch (u2) {
                    case "mm" : return kilometreToMillimetres(val);
                    case "cm": return kilometreToCentiMetres(val);
                    case "m" : return kilometreToMetres(val);
                    case "km": return sameUnit(val);
                    case "in": return kilometreToInches(val);
                    case "ft": return kilometreToFeet(val);
                    case "yd": return kilometreToYards(val);
                    case "mi": return kilometreToMiles(val);
                    case "NM": return kilometreToNauticalMiles(val);
                    case "mil": return kilometreToMils(val);
                    default:
                        return "";
                }
            case "in":
                switch (u2) {
                    case "mm" : return inchesToMillimetres(val);
                    case "cm": return inchesToCentiMetres(val);
                    case "m" : return inchesToMetres(val);
                    case "km": return inchesToKilometres(val);
                    case "in": return sameUnit(val);
                    case "ft": return inchesToFeet(val);
                    case "yd": return inchesToYards(val);
                    case "mi": return inchesToMiles(val);
                    case "NM": return inchesToNauticalMiles(val);
                    case "mil": return inchesToMils(val);
                    default:
                        return "";
                }
            case "ft":
                switch (u2) {
                    case "mm" : return feetToMillimetres(val);
                    case "cm": return feetToCentiMetres(val);
                    case "m" : return feetToMetres(val);
                    case "km": return feetToKilometres(val);
                    case "in": return feetToInches(val);
                    case "ft": return sameUnit(val);
                    case "yd": return feetToYards(val);
                    case "mi": return feetToMiles(val);
                    case "NM": return feetToNauticalMiles(val);
                    case "mil": return feetToMils(val);
                    default:
                        return "";
                }
            case "yd":
                switch (u2) {
                    case "mm" : return yardToMillimetres(val);
                    case "cm": return yardToCentiMetres(val);
                    case "m" : return yardToMetres(val);
                    case "km": return yardToKilometres(val);
                    case "in": return yardToInches(val);
                    case "ft": return yardsToFeet(val);
                    case "yd": return sameUnit(val);
                    case "mi": return yardToMiles(val);
                    case "NM": return yardToNauticalMiles(val);
                    case "mil": return yardToMils(val);
                    default:
                        return "";
                }
            case "mi":
                switch (u2) {
                    case "mm" : return milesToMillimetres(val);
                    case "cm": return milesToCentiMetres(val);
                    case "m" : return milesToMetres(val);
                    case "km": return milesToKilometres(val);
                    case "in": return milesToInches(val);
                    case "ft": return milesToFeet(val);
                    case "yd": return milesToYards(val);
                    case "mi": return sameUnit(val);
                    case "NM": return milesToNauticalMiles(val);
                    case "mil": return milesToMils(val);
                    default:
                        return "";
                }
            case "NM":
                switch (u2) {
                    case "mm" : return nauticalMilesToMillimetres(val);
                    case "cm": return nauticalMilesToCentiMetres(val);
                    case "m" : return nauticalMilesToMetres(val);
                    case "km": return nauticalMilesToKilometres(val);
                    case "in": return nauticalMilesToInches(val);
                    case "ft": return nauticalMilesToFeet(val);
                    case "yd": return nauticalMilesToYards(val);
                    case "mi": return nauticalMilesToMiles(val);
                    case "NM": return sameUnit(val);
                    case "mil": return nauticalMilesToMils(val);
                    default:
                        return "";
                }
            case "mil":
                switch (u2) {
                    case "mm" : return milsToMillimetres(val);
                    case "cm": return milsToCentiMetres(val);
                    case "m" : return milsToMetres(val);
                    case "km": return milsToKilometres(val);
                    case "in": return milsToInches(val);
                    case "ft": return milsToFeet(val);
                    case "yd": return milsToYards(val);
                    case "mi": return milsToMiles(val);
                    case "NM": return milsToNauticalMiles(val);
                    case "mil": return sameUnit(val);
                    default:
                        return "";
                }
            default:
                return "";
        }
    }


    public String sameUnit(String u){
        return u;
    }

    public String millimetreToCentimetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.1 * Double.parseDouble(mm));
    }
    public String millimetreToMetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.001 * Double.parseDouble(mm));
    }
    public String millimetreToKiloMetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.000001 * Double.parseDouble(mm));
    }
    public String millimetreToInches(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0393700787 * Double.parseDouble(mm));
    }
    public String millimetreToFeet(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0032808399 * Double.parseDouble(mm));
    }
    public String millimetreToYard(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0010936133 * Double.parseDouble(mm));
    }
    public String millimetreToMiles(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(6.21371192E-7 * Double.parseDouble(mm));
    }
    public String millimetreToNauticalMiles(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(5.39956803E-7 * Double.parseDouble(mm));
    }
    public String millimetreToMils(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(39.3700787402 * Double.parseDouble(mm));
    }

    public String centimetreToMillimetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(10 * Double.parseDouble(mm));
    }
    public String centimetreToMetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.01 * Double.parseDouble(mm));
    }
    public String centimetreToKiloMetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.00001 * Double.parseDouble(mm));
    }
    public String centimetreToInches(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.3937007874 * Double.parseDouble(mm));
    }
    public String centimetreToFeet(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.032808399 * Double.parseDouble(mm));
    }
    public String centimetreToYard(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.010936133 * Double.parseDouble(mm));
    }
    public String centimetreToMiles(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0000062137 * Double.parseDouble(mm));
    }
    public String centimetreToNauticalMiles(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0000053996 * Double.parseDouble(mm));
    }
    public String centimetreToMils(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(393.7007874016 * Double.parseDouble(mm));
    }


    public String metreToMillimetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(1000 * Double.parseDouble(mm));
    }
    public String metreToCentiMetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(100 * Double.parseDouble(mm));
    }
    public String metreToKilometres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.001 * Double.parseDouble(mm));
    }
    public String metreToInches(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(39.3700787402 * Double.parseDouble(mm));
    }
    public String metreToFeet(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(3.280839895 * Double.parseDouble(mm));
    }
    public String metreToYards(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(1.0936132983 * Double.parseDouble(mm));
    }
    public String metreToMiles(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0006213712 * Double.parseDouble(mm));
    }
    public String metreToNauticalMiles(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0005399568 * Double.parseDouble(mm));
    }
    public String metreToMils(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(39370.078740157 * Double.parseDouble(mm));
    }

    public String kilometreToMillimetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(1000000 * Double.parseDouble(mm));
    }
    public String kilometreToCentiMetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(100000 * Double.parseDouble(mm));
    }
    public String kilometreToMetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(1000 * Double.parseDouble(mm));
    }
    public String kilometreToInches(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(39370.078740157 * Double.parseDouble(mm));
    }
    public String kilometreToFeet(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(3280.8398950131 * Double.parseDouble(mm));
    }
    public String kilometreToYards(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(1093.6132983377 * Double.parseDouble(mm));
    }
    public String kilometreToMiles(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.6213711922 * Double.parseDouble(mm));
    }
    public String kilometreToNauticalMiles(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.5399568035 * Double.parseDouble(mm));
    }
    public String kilometreToMils(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(39370078.740157 * Double.parseDouble(mm));
    }

    public String inchesToMillimetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(25.4 * Double.parseDouble(mm));
    }
    public String inchesToCentiMetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(2.54 * Double.parseDouble(mm));
    }
    public String inchesToMetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0254 * Double.parseDouble(mm));
    }
    public String inchesToKilometres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0000254 * Double.parseDouble(mm));
    }
    public String inchesToFeet(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.083333 * Double.parseDouble(mm));
    }
    public String inchesToYards(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0277777778 * Double.parseDouble(mm));
    }
    public String inchesToMiles(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0000157828 * Double.parseDouble(mm));
    }
    public String inchesToNauticalMiles(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0000137149 * Double.parseDouble(mm));
    }
    public String inchesToMils(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(1000 * Double.parseDouble(mm));
    }

    public String feetToMillimetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(304.8 * Double.parseDouble(mm));
    }
    public String feetToCentiMetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(30.48 * Double.parseDouble(mm));
    }
    public String feetToMetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.3048 * Double.parseDouble(mm));
    }
    public String feetToKilometres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0003048 * Double.parseDouble(mm));
    }
    public String feetToInches(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(12 * Double.parseDouble(mm));
    }
    public String feetToYards(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.3333333 * Double.parseDouble(mm));
    }
    public String feetToMiles(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0001893939 * Double.parseDouble(mm));
    }
    public String feetToNauticalMiles(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0001645788 * Double.parseDouble(mm));
    }
    public String feetToMils(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(12000 * Double.parseDouble(mm));
    }

    public String yardToMillimetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(914.4 * Double.parseDouble(mm));
    }
    public String yardToCentiMetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(91.44 * Double.parseDouble(mm));
    }
    public String yardToMetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.9144 * Double.parseDouble(mm));
    }
    public String yardToKilometres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0009144 * Double.parseDouble(mm));
    }
    public String yardToInches(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(36 * Double.parseDouble(mm));
    }
    public String yardsToFeet(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(3 * Double.parseDouble(mm));
    }
    public String yardToMiles(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0005681818 * Double.parseDouble(mm));
    }
    public String yardToNauticalMiles(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0004937365 * Double.parseDouble(mm));
    }
    public String yardToMils(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(36000 * Double.parseDouble(mm));
    }

    public String milesToMillimetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(1609344 * Double.parseDouble(mm));
    }
    public String milesToCentiMetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(160934.4 * Double.parseDouble(mm));
    }
    public String milesToMetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(1609.344 * Double.parseDouble(mm));
    }
    public String milesToKilometres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(1.609344 * Double.parseDouble(mm));
    }
    public String milesToInches(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(63360 * Double.parseDouble(mm));
    }
    public String milesToFeet(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(5280 * Double.parseDouble(mm));
    }
    public String milesToYards(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(1760 * Double.parseDouble(mm));
    }
    public String milesToNauticalMiles(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.8689762419 * Double.parseDouble(mm));
    }
    public String milesToMils(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(63360000 * Double.parseDouble(mm));
    }

    public String nauticalMilesToMillimetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(1852000 * Double.parseDouble(mm));
    }
    public String nauticalMilesToCentiMetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(185200 * Double.parseDouble(mm));
    }
    public String nauticalMilesToMetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(1852 * Double.parseDouble(mm));
    }
    public String nauticalMilesToKilometres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(1.852 * Double.parseDouble(mm));
    }
    public String nauticalMilesToInches(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(72913.385826772 * Double.parseDouble(mm));
    }
    public String nauticalMilesToFeet(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(6076.1154855643 * Double.parseDouble(mm));
    }
    public String nauticalMilesToYards(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(2025.3718285214 * Double.parseDouble(mm));
    }
    public String nauticalMilesToMiles(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(1.150779448 * Double.parseDouble(mm));
    }
    public String nauticalMilesToMils(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(72913385.826772 * Double.parseDouble(mm));
    }

    public String milsToMillimetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0254 * Double.parseDouble(mm));
    }
    public String milsToCentiMetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.00254 * Double.parseDouble(mm));
    }
    public String milsToMetres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.0000254 * Double.parseDouble(mm));
    }
    public String milsToKilometres(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(2.54E-8 * Double.parseDouble(mm));
    }
    public String milsToInches(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.001 * Double.parseDouble(mm));
    }
    public String milsToFeet(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.00008333 * Double.parseDouble(mm));
    }
    public String milsToYards(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(0.000027777 * Double.parseDouble(mm));
    }
    public String milsToMiles(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(1.578282E-8 * Double.parseDouble(mm));
    }
    public String milsToNauticalMiles(String mm){
        if(mm.equals("")) return "";
        return String.valueOf(1.371490E-8 * Double.parseDouble(mm));
    }


}