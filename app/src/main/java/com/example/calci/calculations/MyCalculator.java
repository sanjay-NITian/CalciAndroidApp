package com.example.calci.calculations;

import java.util.ArrayList;
import java.util.Stack;

import static java.lang.Double.parseDouble;

public class MyCalculator {

    private String expression;
    public MyCalculator(String expression) {
        this.expression=expression;
    }

    public String calculateExpression(){
        ArrayList<String> al=new ArrayList<>();
        String ops="+-x/^()";
        int i=0;

        while(i<expression.length()){
            if(ops.contains(String.valueOf(expression.charAt(i)))){
                if(i==0){
                    al.add(String.valueOf(expression.charAt(i)));
                    i++;
                }
                else{
                    if(expression.charAt(i)=='-' && expression.charAt(i-1)=='('){
                        al.add(":");
                        i++;
                    }else if(expression.charAt(i)=='+' && expression.charAt(i-1)=='('){
                        al.add(";");
                        i++;
                    }else{
                        al.add(String.valueOf(expression.charAt(i)));
                        i++;
                    }
                }
            }else{
                String temp="";
                while (i<expression.length() && !ops.contains(String.valueOf(expression.charAt(i)))){
                    temp += String.valueOf(expression.charAt(i));
                    i++;
                }
                al.add(temp);
            }
        }

        ArrayList<String> postorder=postOrder(al);
        double result = evalPostOrder(postorder);

        return String.valueOf(result);

    }

    private double evalPostOrder( ArrayList<String> al ){
        Stack<Double> st = new Stack<>();
        String ops="+-x/^:;";
        for(String ele:al){
            if(ops.contains(ele)){ // element is operator
                double value1=0,value2=0;
                if(ele.charAt(0)==':'){
                    value1 = st.pop();
                    value1 = -value1;
                    st.push(value1);
                }else if(ele.charAt(0)==';'){

                }else{
                    value2 = st.pop();
                    value1 = st.pop();
                    switch (ele){
                        case "+":
                            st.push(value1 + value2);
                            break;
                        case "-":
                            st.push(value1 - value2);
                            break;
                        case "x":
                            st.push(value1 * value2);
                            break;
                        case  "/":
                            st.push(value1 / value2);
                            break;
                    }
                }
            }else{ // Element is not operator
                double d= parseDouble(ele);
                st.push(d);
            }
        }
        return st.pop();
    }

    private  ArrayList<String> postOrder(ArrayList<String> al){
//        String postorder="";
        ArrayList<String> result=new ArrayList<>();
        String ops="+-x/^:;()";
        Stack<String> st=new Stack<>();
        for(String ele:al){
            if (ops.contains(ele)) { // element is operator
                char temp;
                temp=ele.charAt(0);
                if(st.empty() || stackOutPrece(temp)>stackInPrece((st.peek()).charAt(0))){
                    st.push(ele);
                }else if(temp==')'){
                    while(stackInPrece((st.peek()).charAt(0)) != 0 ){
//                        postorder += st.pop();
                        result.add(st.pop());
                    }
                    if(!st.empty()){
                        st.pop();
                    }
                }else{
                    while(!st.empty() && stackOutPrece(temp) <= stackInPrece((st.peek()).charAt(0))){
//                        postorder += st.pop();
                        result.add(st.pop());
                    }
                    st.push(ele);
                }
            }else{ // element is not operator
//                postorder += ele;
                result.add(ele);
            }
        }
        while(!st.empty()){
//            postorder+=st.pop();
            result.add(st.pop());
        }
        return result;
    }

    private int stackInPrece(char ch){
        int pre=-1;
        if(ch=='+' || ch=='-'){
            pre=2;
        }else if(ch=='x' || ch=='/'){
            pre=4;
        }else if(ch=='^'){
            pre=5;
        }else if(ch==':' || ch==';'){
            pre=7;
        }else if(ch=='('){
            pre=0;
        }
        return pre;
    }

    private int stackOutPrece(char ch){
        int pre=-1;
        if(ch=='+' || ch=='-'){
            pre=1;
        }else if(ch=='x' || ch=='/'){
            pre=3;
        }else if(ch=='^'){
            pre=6;
        }else if(ch==':' || ch==';'){
            pre=8;
        }else if(ch=='('){
            pre=9;
        }else if(ch==')'){
            pre=0;
        }
        return pre;
    }

}
