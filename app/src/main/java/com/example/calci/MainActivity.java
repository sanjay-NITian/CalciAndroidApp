package com.example.calci;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calci.calculations.MyCalculator;

public class MainActivity extends AppCompatActivity {

    // this is temporary code
    Button btn_c, btn_paren, btn_mod, btn_div, btn_mul, btn_hyp, btn_plus, btn_equal, btn_point, btn0, btn_plus_min, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

    ImageView converterPic,history,advance,cut;

    TextView tv1,tv2;

    /**
     * mention here if you are resetting the String expression
     */
    String expression="";
    int parenthesis_count=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // finding the textview one and two using their ids
        tv1=findViewById(R.id.tv1);
        tv2=findViewById(R.id.tv2);

//        getSupportActionBar().setTitle("Calculator --Advanced");
        getSupportActionBar().hide();

        btn_c = findViewById(R.id.btn_c);
        btn_paren = findViewById(R.id.btn_paren);
        btn_mod = findViewById(R.id.btn_mod);
        btn_div = findViewById(R.id.btn_div);
        btn_mul = findViewById(R.id.btn_mul);
        btn_hyp = findViewById(R.id.btn_hyp);
        btn_plus = findViewById(R.id.btn_plus);
        btn_equal = findViewById(R.id.btn_equal);
        btn_point = findViewById(R.id.btn_point);
        btn_plus_min = findViewById(R.id.btn_plus_min);
        btn0 = findViewById(R.id.button0);
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);
        btn5 = findViewById(R.id.button5);
        btn6 = findViewById(R.id.button6);
        btn7 = findViewById(R.id.button7);
        btn8 = findViewById(R.id.button8);
        btn9 = findViewById(R.id.button9);

        // Finding the converter using by id
        converterPic = findViewById(R.id.converter);
        history = findViewById(R.id.imageHistory);
        advance = findViewById(R.id.imageAdvance);
        cut = findViewById(R.id.cut);

        // Setting the on click listener for the history
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                Toast.makeText(MainActivity.this, "We will coming soon", Toast.LENGTH_SHORT).show();
            }
        });

        // Setting the on click listener for the advance button
        advance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                Toast.makeText(MainActivity.this, "We are working on advance feature", Toast.LENGTH_SHORT).show();
            }
        });

        // Setting the on click listener for the cut button
        cut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                /**
                 * Logic starts here
                 */
                int expression_length=expression.length();
                if(expression_length!=0){
                    if(expression.endsWith(")")){
                        parenthesis_count ++;
                    }
                    else if(expression.endsWith("(")){
                        parenthesis_count --;
                    }
                    expression = expression.substring(0,expression_length-1);
                }

                tv1.setText(expression);

                /**
                 * adding to result
                 */
                try{
                    MyCalculator mc= new MyCalculator(expression);
                    String result = mc.calculateExpression();
                    tv2.setText(result);
                }catch (Exception e){
                    tv2.setText("");
                }
            }
        });

        // Setting the on click listener to the converter pic and going to the another activity
        converterPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Setting the translation to the image picture
                onTouchButtonBackgroundEffect(v);

                Intent intent = new Intent(MainActivity.this, ConverterActivity.class);
                startActivity(intent);
                // Setting the back button in second activity : <activity android:name=".ConverterActivity" android:parentActivityName=".MainActivity">

            }
        });


        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                expression = "";
                parenthesis_count = 0;
                tv1.setText(expression);
                tv2.setText(expression);
            }
        });

        btn_paren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                // Logic starts here
                int expression_length=expression.length();
                if(expression_length==0 || expression.endsWith("(")){
                    expression += "(";
                    parenthesis_count ++;
                }
                else if (expression.charAt(expression_length-1)>=48 && expression.charAt(expression_length-1)<=57){
                    if(parenthesis_count == 0){
                        expression += "x(";
                        parenthesis_count ++;
                    }else{
                        expression += ")";
                        parenthesis_count --;
                    }
                }
                else if(expression.charAt(expression_length-1)=='+' || expression.charAt(expression_length-1) == '-' || expression.charAt(expression_length-1) == 'x' || expression.charAt(expression_length-1) == '/'){
                    expression += "(";
                    parenthesis_count ++;
                }
                else if(expression.charAt(expression_length-1) == ')' && parenthesis_count == 0){
                    expression += "x(";
                    parenthesis_count ++;
                }
                else if(expression.charAt(expression_length-1) == ')' && parenthesis_count != 0){
                    expression += ")";
                    parenthesis_count --;
                }
                else if(expression.charAt(expression_length-1) == '.' && parenthesis_count == 0){
                    expression += "x(";
                    parenthesis_count ++;
                }
                else if(expression.charAt(expression_length-1) == '.' && parenthesis_count != 0){
                    expression += ")";
                    parenthesis_count --;
                }
                else if(expression.charAt(expression_length-1) == '%' && parenthesis_count != 0){
                    expression += ")";
                    parenthesis_count --;
                }
                else if(expression.charAt(expression_length-1) == '%' && parenthesis_count == 0){
                    expression += "x(";
                    parenthesis_count ++;
                }// Logic ends here

                // Setting the text
                tv1.setText(expression);

                /**
                 * adding to result
                 */
                try{
                    MyCalculator mc= new MyCalculator(expression);
                    String result = mc.calculateExpression();
                    tv2.setText(result);
                }catch (Exception e){
                    tv2.setText("");
                }

            }
        });

        btn_mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                /**
                 * Logic starts from here
                 */
//                if(expression.isEmpty() || expression.endsWith("+") || expression.endsWith("-") || expression.endsWith("x") || expression.endsWith("/") || expression.endsWith("%") || expression.endsWith("(")){
//                    Toast.makeText(MainActivity.this, "Invalid format used.", Toast.LENGTH_SHORT).show();
//                }
//                else if(!expression.isEmpty()){
//                    expression += "%";
//                }
//
//                tv1.setText(expression);

                Toast.makeText(MainActivity.this, "I am not in use.", Toast.LENGTH_SHORT).show();
            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                /**
                 * Logic starts here
                 */
                int expression_length=expression.length();
                if(expression_length!=0){
                    if(expression.endsWith("x") || expression.endsWith("-") || expression.endsWith("+") || expression.endsWith("/")){
                        if(expression.charAt(expression_length-2)=='(' && (expression.endsWith("+") || expression.endsWith("-"))){
                            expression = expression.substring(0,expression_length-1);
                        }else{
                            expression = expression.substring(0,expression_length-1) + "/";
                        }
                    }else if(!expression.endsWith("(")){
                        expression += "/";
                    }
                }

                tv1.setText(expression);

                /**
                 * adding to result
                 */
                try{
                    MyCalculator mc= new MyCalculator(expression);
                    String result = mc.calculateExpression();
                    tv2.setText(result);
                }catch (Exception e){
                    tv2.setText("");
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                addNumbersToExpression("7");
                tv1.setText(expression);


                /**
                 * adding to result
                 */
                try{
                    MyCalculator mc= new MyCalculator(expression);
                    String result = mc.calculateExpression();
                    tv2.setText(result);
                }catch (Exception e){
                    tv2.setText("error");
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                addNumbersToExpression("8");
                tv1.setText(expression);

                /**
                 * adding to result
                 */
                try{
                    MyCalculator mc= new MyCalculator(expression);
                    String result = mc.calculateExpression();
                    tv2.setText(result);
                }catch (Exception e){
                    tv2.setText("");
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);
                addNumbersToExpression("9");
                tv1.setText(expression);

                /**
                 * adding to result
                 */
                try{
                    MyCalculator mc= new MyCalculator(expression);
                    String result = mc.calculateExpression();
                    tv2.setText(result);
                }catch (Exception e){
                    tv2.setText("");
                }
            }
        });

        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                /**
                 *
                 * this
                 *  Logic starts here
                 */

                int expression_length=expression.length();
                if(expression_length!=0){
                    if(expression.endsWith("x") || expression.endsWith("-") || expression.endsWith("+") || expression.endsWith("/")){
                        if(expression.charAt(expression_length-2)=='(' && (expression.endsWith("+") || expression.endsWith("-"))){
                            expression = expression.substring(0,expression_length-1);
                        }else{
                            expression = expression.substring(0,expression_length-1) + "x";
                        }
                    }else if(!expression.endsWith("(")){
                        expression += "x";
                    }
                }

                tv1.setText(expression);

                /**
                 * adding to result
                 */
                try{
                    MyCalculator mc= new MyCalculator(expression);
                    String result = mc.calculateExpression();
                    tv2.setText(result);
                }catch (Exception e){
                    tv2.setText("");
                }
            }
        });


        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                addNumbersToExpression("4");
                tv1.setText(expression);

                /**
                 * adding to result
                 */
                try{
                    MyCalculator mc= new MyCalculator(expression);
                    String result = mc.calculateExpression();
                    tv2.setText(result);
                }catch (Exception e){
                    tv2.setText("");
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                addNumbersToExpression("5");
                tv1.setText(expression);

                /**
                 * adding to result
                 */
                try{
                    MyCalculator mc= new MyCalculator(expression);
                    String result = mc.calculateExpression();
                    tv2.setText(result);
                }catch (Exception e){
                    tv2.setText("");
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                addNumbersToExpression("6");
                tv1.setText(expression);

                /**
                 * adding to result
                 */
                try{
                    MyCalculator mc= new MyCalculator(expression);
                    String result = mc.calculateExpression();
                    tv2.setText(result);
                }catch (Exception e){
                    tv2.setText("");
                }
            }
        });

        btn_hyp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                /**
                 * Logic starts here
                 */
                int expression_length=expression.length();
                if(expression_length!=0){
                    if(expression.endsWith("x") || expression.endsWith("-") || expression.endsWith("+") || expression.endsWith("/")){
                        expression = expression.substring(0,expression_length-1) + "-";
                    }else{
                        expression += "-";
                    }
                }

                tv1.setText(expression);

                /**
                 * adding to result
                 */
                try{
                    MyCalculator mc= new MyCalculator(expression);
                    String result = mc.calculateExpression();
                    tv2.setText(result);
                }catch (Exception e){
                    tv2.setText("");
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                addNumbersToExpression("1");
                tv1.setText(expression);

                /**
                 * adding to result
                 */
                try{
                    MyCalculator mc= new MyCalculator(expression);
                    String result = mc.calculateExpression();
                    tv2.setText(result);
                }catch (Exception e){
                    tv2.setText("");
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                addNumbersToExpression("2");
                tv1.setText(expression);

                /**
                 * adding to result
                 */
                try{
                    MyCalculator mc= new MyCalculator(expression);
                    String result = mc.calculateExpression();
                    tv2.setText(result);
                }catch (Exception e){
                    tv2.setText("");
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                addNumbersToExpression("3");
                tv1.setText(expression);

                /**
                 * adding to result
                 */
                try{
                    MyCalculator mc= new MyCalculator(expression);
                    String result = mc.calculateExpression();
                    tv2.setText(result);
                }catch (Exception e){
                    tv2.setText("");
                }
            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                /**
                 * Logic starts here
                 */
                int expression_length=expression.length();
                if(expression_length!=0){
                    if(expression.endsWith("x") || expression.endsWith("-") || expression.endsWith("+") || expression.endsWith("/")){
                        expression = expression.substring(0,expression_length-1) + "+";
                    }else{
                        expression += "+";
                    }
                }

                tv1.setText(expression);

                /**
                 * adding to result
                 */
                try{
                    MyCalculator mc= new MyCalculator(expression);
                    String result = mc.calculateExpression();
                    tv2.setText(result);
                }catch (Exception e){
                    tv2.setText("");
                }
            }
        });

        btn_plus_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                Toast.makeText(MainActivity.this, "We will update soon", Toast.LENGTH_SHORT).show();
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                addNumbersToExpression("0");
                tv1.setText(expression);

                /**
                 * adding to result
                 */
                try{
                    MyCalculator mc= new MyCalculator(expression);
                    String result = mc.calculateExpression();
                    tv2.setText(result);
                }catch (Exception e){
                    tv2.setText("");
                }
            }
        });

        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                /**
                 * Logic starts from here
                 */
//                TODO: Here is a catch for multiple point(dots)
                int expression_length=expression.length();
                if(expression_length == 0 || (expression.charAt(expression_length-1)=='+' || expression.charAt(expression_length-1)=='-' || expression.charAt(expression_length-1)=='x' || expression.charAt(expression_length-1)=='/' || expression.charAt(expression_length-1)=='(')){
                    expression += "0.";
                }
                else if(expression.charAt(expression_length-1)==')' || expression.charAt(expression_length-1)=='%'){
                    expression += "x0.";
                }
                else if(expression.charAt(expression_length-1) >= '0' && expression.charAt(expression_length-1)<='9'){
                    expression += ".";
                }

                tv1.setText(expression);


                /**
                 * adding to result
                 */
                try{
                    MyCalculator mc= new MyCalculator(expression);
                    String result = mc.calculateExpression();
                    tv2.setText(result);
                }catch (Exception e){
                    tv2.setText("");
                }

            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTouchButtonBackgroundEffect(v);

                /**
                 * adding to result
                 */
                try{
                    MyCalculator mc= new MyCalculator(expression);
                    String result = mc.calculateExpression();

                    tv1.setText(result);
                    tv2.setText("");
                    if(result.contains("-")){
                        expression = "("+result;
                        parenthesis_count ++;
                    }
                    else{
                        expression = result;
                    }

                }catch (Exception e){
                    tv2.setText("Invalid Expression");
                }

            }
        });


    }

    public void addNumbersToExpression(String number){
        if(expression.endsWith(")") || expression.endsWith("%")){
            expression += "x"+number;
        }
        else{
            expression += number;
        }
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
