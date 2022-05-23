package com.calculator.supercalculator10;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity {
    String process;
    TextView result;
    boolean op = false;
    AdView ad;
    public void scientific(View View) {
        Intent scientific = new Intent(this, scientific.class);
        startActivity(scientific);
    }

    public void equations(View view) {
        Intent equations = new Intent(this,Equations.class);
        startActivity(equations);
    }
    public void dr(View view) {
        Intent dr = new Intent(this,dr.class);
        startActivity(dr);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        ad = findViewById(R.id.AdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        ad.loadAd(adRequest);
        this.setTitle("Super Calculator");
        final Button button = findViewById(R.id.button);
        final Button button2 = findViewById(R.id.button2);
        final Button button3 = findViewById(R.id.button3);
        final Button button4 = findViewById(R.id.button4);
        final Button button5 = findViewById(R.id.button5);
        final Button button6 = findViewById(R.id.button6);
        final Button button7 = findViewById(R.id.button7);
        final Button button8 = findViewById(R.id.button8);
        final Button button9 = findViewById(R.id.button9);
        final Button button10 = findViewById(R.id.button10);
        final Button button11= findViewById(R.id.button11);
        final Button button12= findViewById(R.id.button12);
        final Button button13= findViewById(R.id.button13);
        final Button button14= findViewById(R.id.button14);
        final Button button16= findViewById(R.id.button16);
        final Button button33= findViewById(R.id.button33);
        final Button button29= findViewById(R.id.button29);
        final Button button30= findViewById(R.id.button30);
        final Button button31= findViewById(R.id.button31);
        final Button button32= findViewById(R.id.button32);
        result = findViewById(R.id.input1);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button);
                result.setText("");
                op=false;
            }
        });
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button2);
                if(result.length()==0){
                    result.setText("");
                }else{
                    if(result.length()==1){
                        op=false;
                        String bc = result.getText().toString();
                        bc = bc.substring(0,bc.length()-1);
                        result.setText(bc);
                    }else {
                        process = result.getText().toString();
                        Character n =process.charAt((process.length()-2));
                        String r = n.toString();
                        if(r.contains("+")||r.contains("*")||r.contains("-")||r.contains("/")){
                            String bc = result.getText().toString();
                            bc = bc.substring(0,bc.length()-1);
                            result.setText(bc);
                            op=false;
                        }else {
                            String bc = result.getText().toString();
                            bc = bc.substring(0,bc.length()-1);
                            result.setText(bc);
                            op=true;
                        }
                    }
                }
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button3);

                if(result.length()==0) {
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter any number", duration);
                    toast.show();
                }else{

                    process = result.getText().toString();

                    if(process.contains("+")||process.contains("/")||process.contains("*")){
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(getApplicationContext(), "Complete the equation", duration);
                            toast.show();


                    }else {
                        if(process.substring(1).contains("-")){
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(getApplicationContext(), "Complete the equation", duration);
                            toast.show();
                        }else {
                            Double val = Double.parseDouble(process);
                            val = -1*val;
                            String plusminus = String.valueOf(val);
                            String last ="";
                            if(plusminus.contains("E")){
                                last = BigDecimal.valueOf(val).toPlainString();
                            }else{
                                last = plusminus;
                            }
                            result.setText(last);
                        }

                    }


                }

            }
        });
        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button4);
                if (op){
                    process = result.getText().toString();
                    String divide =process+"/";
                    result.setText(divide);
                };
                op =false;

            }
        });
        button5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button5);
                process = result.getText().toString();
                String seven =process + "7";
                result.setText(seven);
                op=true;
            }
        });
        button6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button6);
                process = result.getText().toString();
                String eight =process + "8";
                result.setText(eight);
                op=true;
            }
        });
        button7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button7);
                process = result.getText().toString();
                String nine = process + "9";
                result.setText(nine);
                op=true;
            }
        });
        button8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button8);
                if(op){
                    process = result.getText().toString();
                    String multiply =process +"*";
                    result.setText(multiply);
                }
                op=false;
            }
        });
        button9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button9);
                process = result.getText().toString();
                String four=process + "4";
                result.setText(four);
                op=true;
            }
        });
        button10.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button10);
                process = result.getText().toString();
                String five = process + "5";
                result.setText(five);
                op=true;
            }
        });
        button11.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button11);
                process = result.getText().toString();
                String six =process + "6";
                result.setText(six);
                op=true;
            }
        });
        button12.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button12);
                if(op){
                    process = result.getText().toString();
                    String minus =process +"-";
                    result.setText(minus);
                }else {
                    if(result.getText().toString().length()==0){
                        process = result.getText().toString();
                        String minus =process +"-";
                        result.setText(minus);
                        op=false;
                    }
                }
                op=false;
            }
        });
        button13.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button13);
                process = result.getText().toString();
                String one =process + "1";
                result.setText(one);
                op=true;
            }
        });
        button14.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button14);
                process = result.getText().toString();
                String two =process + "2";
                result.setText(two);
                op=true;
            }
        });
        button16.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button16);
                process = result.getText().toString();
                String three = process + "3";
                result.setText(three);
                op=true;
            }
        });
        button33.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button33);
                if(op){
                    process = result.getText().toString();
                    String plus =process +"+";
                    result.setText(plus);
                }
                op=false;
            }
        });
        button29.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button29);
                if(result.length()==0) {
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter any number", duration);
                    toast.show();
                }else{

                    process = result.getText().toString();

                    if(process.contains("+")||process.contains("/")||process.contains("*")){
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(getApplicationContext(), "Complete the equation", duration);
                        toast.show();


                    }else {
                        if(process.substring(1).contains("-")){
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(getApplicationContext(), "Complete the equation", duration);
                            toast.show();
                        }else {
                            Double val = Double.parseDouble(process);
                            val = val/100;
                            String plusminus = String.valueOf(val);
                            String last ="";
                            if(plusminus.contains("E")){
                                last = BigDecimal.valueOf(val).toPlainString();
                            }else{
                                last = plusminus;
                            }
                            result.setText(last);
                        }

                    }


                }

            }
        });
        button30.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button30);
                process = result.getText().toString();
                String zero = process + "0";
                result.setText(zero);
                op=true;
            }
        });
        button31.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button31);
                if(op){
                    if(result.getText().toString().contains(".")){
                        String a = "";
                        for(int i=result.getText().toString().length()-1; i>=0;i--){
                            if (result.getText().toString().charAt(i)=='+'||result.getText().toString().charAt(i)=='-'||result.getText().toString().charAt(i)=='*'||result.getText().toString().charAt(i)=='/'){
                                break;
                            }else{
                                a+=result.getText().toString().charAt(i);
                            }

                        }
                        if(a.contains(".")){
                            String res=result.getText().toString();
                            result.setText(res);
                        }else{
                            process = result.getText().toString();
                            String point = process + ".";
                            result.setText(point);
                            op=false;
                        }

                    }else{
                        process = result.getText().toString();
                        String point = process + ".";
                        result.setText(point);
                        op=false;
                    }
                }

            }
        });
        button32.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button32);
                if(result.getText().toString().length()==0){
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter any number", duration);
                    toast.show();
                }else {
                    String s = result.getText().toString().substring(result.getText().toString().length()-1);
                    if(s.equals("+")||s.equals("-")||s.equals("/")||s.equals("*")||s.equals(".")){
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(getApplicationContext(), "Complete the equation", duration);
                        toast.show();
                    }
                    if(op){
                        String res= result.getText().toString();

                        String Replacedstr = res.replace("/","/").replace("*","*");
                        double lastresult=eval(Replacedstr);
                        String last ="";
                        if(String.valueOf(lastresult).contains("E")){
                            last =BigDecimal.valueOf(lastresult).toPlainString();
                        }else{
                            last = String.valueOf(lastresult);
                        }
                        if(last.contains("Infinity")){
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                            toast.show();
                            result.setText("");
                        }else{
                            result.setText(last);
                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }

            }
        });
    }
    //eval function
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("log")) x = Math.log10(x);
                    else if (func.equals("ln")) x = Math.log(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}