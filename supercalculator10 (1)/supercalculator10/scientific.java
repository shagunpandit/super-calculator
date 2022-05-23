package com.calculator.supercalculator10;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.math.MathUtils;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.math.BigDecimal;
import java.math.BigInteger;

public class scientific extends AppCompatActivity {
    String process;
    TextView result;
    String pi = "3.1415926535898";
    boolean op = false;
    boolean br = false;
    Character n;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific);
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
        final Button button45= findViewById(R.id.button45);
        final Button button46= findViewById(R.id.button46);
        final Button button47= findViewById(R.id.button47);
        final Button button48= findViewById(R.id.button48);
        final Button button49= findViewById(R.id.button49);
        final Button button50= findViewById(R.id.button50);
        final Button button51= findViewById(R.id.button51);
        final Button button15= findViewById(R.id.button15);
        final Button button20= findViewById(R.id.button20);
        final Button button24= findViewById(R.id.button24);
        final Button button25= findViewById(R.id.button25);
        final Button button44= findViewById(R.id.button44);
        final Button button26= findViewById(R.id.button26);
        final Button button27= findViewById(R.id.button27);
        final Button button28= findViewById(R.id.button28);
        final Button button34= findViewById(R.id.button34);
        final Button button35= findViewById(R.id.button35);
        final Button button36= findViewById(R.id.button36);
        final Button button37= findViewById(R.id.button37);
        final Button button19= findViewById(R.id.button19);
        final Button button38= findViewById(R.id.button38);
        final Button button39= findViewById(R.id.button39);
        final Button button40= findViewById(R.id.button40);
        final Button button18= findViewById(R.id.button18);
        final Button button41= findViewById(R.id.button41);
        final Button button42= findViewById(R.id.button42);
        final Button button43= findViewById(R.id.button43);
        final Button button17= findViewById(R.id.button17);
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
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(getApplicationContext(),"Enter number first", duration);
                    toast.show();
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
                        if(r.contains("+")||r.contains("*")||r.contains("-")||r.contains("/")||r.contains("^")){
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

                    if(process.contains("+")||process.contains("/")||process.contains("*")||process.contains("^")){
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
                    if(result.length()==0||result.getText().toString().substring(result.getText().toString().length()-1).equals("^")){
                        process = result.getText().toString();
                        String m =process +"-";
                        result.setText(m);
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

                    if(process.contains("+")||process.contains("/")||process.contains("*")||process.contains("^")){
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
        });button30.setOnClickListener(new View.OnClickListener(){
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
                            if (result.getText().toString().charAt(i)=='+'||result.getText().toString().charAt(i)=='-'||result.getText().toString().charAt(i)=='^'||result.getText().toString().charAt(i)=='*'||result.getText().toString().charAt(i)=='/'){
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

        button45.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button45);
                if(op&&!result.getText().toString().contains("+")
                        &&!result.getText().toString().contains("*")
                        &&!result.getText().toString().contains("/") &&!result.getText().toString().contains("(")
                        &&!result.getText().toString().contains(")")&&!result.getText().toString().contains("^")){
                    process = result.getText().toString();
                    Double res = Math.toDegrees(Double.parseDouble(process));
                    result.setText(String.valueOf(res));

                }else {
                    if(result.length()==0){
                        process = result.getText().toString();
                        result.setText("");
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(getApplicationContext(),"Enter number first", duration);
                        toast.show();

                    }else {
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(getApplicationContext(),"Solve this equation first", duration);
                        toast.show();
                    }
                }
            }
        });
        button46.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button46);
                if(op&&!result.getText().toString().contains("+")
                        &&!result.getText().toString().contains("*")
                        &&!result.getText().toString().contains("/") &&!result.getText().toString().contains("(")
                        &&!result.getText().toString().contains(")")&&!result.getText().toString().contains("^")){
                    process = result.getText().toString();
                    Double res = Math.toRadians(Double.parseDouble(process));
                    result.setText(String.valueOf(res));

                }else {
                    if(result.length()==0){
                        process = result.getText().toString();
                        result.setText("");
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(getApplicationContext(),"Enter number first", duration);
                        toast.show();

                    }else {
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(getApplicationContext(),"Solve this equation first", duration);
                        toast.show();
                    }
                }
            }
        });
        button47.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button47);
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
                            Double r = Math.sinh(Double.parseDouble(last));
                            if(String.valueOf(r).contains("Infinity")){
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                toast.show();
                                result.setText("");
                            }else {
                                if(String.valueOf(r).contains("E")){
                                    last =BigDecimal.valueOf(r).toPlainString();
                                }else{
                                    last = String.valueOf(r);
                                }
                                result.setText(last);
                            }

                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
        button48.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button48);
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
                            Double r = Math.cosh(Double.parseDouble(last));
                            if(String.valueOf(r).contains("Infinity")){
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                toast.show();
                                result.setText("");
                            }else {
                                if(String.valueOf(r).contains("E")){
                                    last =BigDecimal.valueOf(r).toPlainString();
                                }else{
                                    last = String.valueOf(r);
                                }
                                result.setText(last);
                            }

                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
        button49.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button49);
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
                            Double r = Math.tanh(Double.parseDouble(last));
                            if(String.valueOf(r).contains("Infinity")){
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                toast.show();
                                result.setText("");
                            }else {
                                if(String.valueOf(r).contains("E")){
                                    last =BigDecimal.valueOf(r).toPlainString();
                                }else{
                                    last = String.valueOf(r);
                                }
                                result.setText(last);
                            }

                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });

        button50.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button50);
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
                            Double r = Double.parseDouble(last);
                            r = Math.log(r+Math.sqrt(r*r+1));
                            if(String.valueOf(r).contains("Infinity")){
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                toast.show();
                                result.setText("");
                            }else {
                                if(String.valueOf(r).contains("E")){
                                    last =BigDecimal.valueOf(r).toPlainString();
                                }else{
                                    last = String.valueOf(r);
                                }
                                result.setText(last);
                            }

                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });

        button51.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button51);
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
                            Double r = Double.parseDouble(last);
                            if(r<1){
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(getApplicationContext(), "Value must greater or equal to 1", duration);
                                toast.show();
                                result.setText("");
                            }else {
                                r = Math.log(r+Math.sqrt(r*r-1));
                                if(String.valueOf(r).contains("Infinity")){
                                    int duration = Toast.LENGTH_LONG;
                                    Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                    toast.show();
                                    result.setText("");
                                }else {
                                    if(String.valueOf(r).contains("E")){
                                        last =BigDecimal.valueOf(r).toPlainString();
                                    }else{
                                        last = String.valueOf(r);
                                    }
                                    result.setText(last);
                                }
                            }


                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });

        button15.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button15);
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
                            Double r = Double.parseDouble(last);
                            if(r<0||r>1){
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(getApplicationContext(), "Value must between 0 and 1", duration);
                                toast.show();
                                result.setText("");
                            }else {
                                r = 0.5*(Math.log((1+r)/(1-r)));
                                if(String.valueOf(r).contains("Infinity")){
                                    int duration = Toast.LENGTH_LONG;
                                    Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                    toast.show();
                                    result.setText("");
                                }else {
                                    if(String.valueOf(r).contains("E")){
                                        last =BigDecimal.valueOf(r).toPlainString();
                                    }else{
                                        last = String.valueOf(r);
                                    }
                                    result.setText(last);
                                }
                            }


                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
        button24.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button24);
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
                            Double r = Math.cos(Math.toRadians(Double.parseDouble(last)));
                            String ls = "";
                            if(String.valueOf(r).contains("E")){
                                String l1 = String.valueOf(r).split("E")[1];
                                if(l1.contains("-")){
                                    ls="0";
                                }else {
                                    ls="";
                                    int duration = Toast.LENGTH_LONG;
                                    Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                    toast.show();
                                }
                            }else{
                                ls = String.valueOf(r);
                            }
                            result.setText(ls);
                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
        button25.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button25);
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
                            Double r = Math.tan(Math.toRadians(Double.parseDouble(last)));
                            String ls = "";
                            if(String.valueOf(r).contains("E")){
                                String l1 = String.valueOf(r).split("E")[1];
                                if(l1.contains("-")){
                                    ls="0";
                                }else {
                                    ls="";
                                    int duration = Toast.LENGTH_LONG;
                                    Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                    toast.show();
                                }
                            }else{
                                ls = String.valueOf(r);
                            }
                            result.setText(ls);
                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
        button26.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button26);
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
                            Double r = Math.sin(Math.toRadians(Double.parseDouble(last)));
                            if(r==0.0){
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                toast.show();
                                r=0.0;
                            }else {
                                r = 1/r;
                            }

                            String ls = "";
                            if(String.valueOf(r).contains("E")){
                                String l1 = String.valueOf(r).split("E")[1];
                                if(l1.contains("-")){
                                    ls="0";
                                }else {
                                    ls="";
                                    int duration = Toast.LENGTH_LONG;
                                    Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                    toast.show();
                                }
                            }else{
                                ls = String.valueOf(r);
                            }
                            result.setText(ls);
                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
        button27.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button27);
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
                            Double r = Math.cos(Math.toRadians(Double.parseDouble(last)));
                            if(r==0.0){
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                toast.show();
                                r=0.0;
                            }else {
                                r = 1/r;
                            }

                            String ls = "";
                            if(String.valueOf(r).contains("E")){
                                String l1 = String.valueOf(r).split("E")[1];
                                if(l1.contains("-")){
                                    ls="0";
                                }else {
                                    ls="";
                                    int duration = Toast.LENGTH_LONG;
                                    Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                    toast.show();
                                }
                            }else{
                                ls = String.valueOf(r);
                            }
                            result.setText(ls);
                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
        button28.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button28);
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
                            if(last.contains("-")){
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(getApplicationContext(), "Value must be positive", duration);
                                toast.show();
                                result.setText("");
                            }else {
                                Double r = Math.log(Double.parseDouble(last));
                                String ls = "";
                                if(String.valueOf(r).contains("E")){
                                    String l1 = String.valueOf(r).split("E")[1];
                                    if(l1.contains("-")){
                                        ls="0";
                                    }else {
                                        ls="";
                                        int duration = Toast.LENGTH_LONG;
                                        Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                        toast.show();
                                    }
                                }else{
                                    if(String.valueOf(r).equals("Infinity")){
                                        int duration = Toast.LENGTH_LONG;
                                        Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                        toast.show();
                                        result.setText("");
                                    }else if(String.valueOf(r).equals("-Infinity")){
                                        int duration = Toast.LENGTH_LONG;
                                        Toast toast = Toast.makeText(getApplicationContext(), "-Infinity", duration);
                                        toast.show();
                                        result.setText("");
                                    }else {
                                        ls = String.valueOf(r);
                                    }

                                }
                                result.setText(ls);
                            }

                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
        button34.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button34);
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
                            if(Double.parseDouble(last)>=-1 && Double.parseDouble(last)<=1){
                                Double r = Math.toDegrees(Math.acos(Double.parseDouble(last)));
                                String ls = "";
                                if(String.valueOf(r).contains("E")){
                                    String l1 = String.valueOf(r).split("E")[1];
                                    if(l1.contains("-")){
                                        ls="0";
                                    }else {
                                        ls="";
                                        int duration = Toast.LENGTH_LONG;
                                        Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                        toast.show();
                                    }
                                }else{
                                    ls = String.valueOf(r);
                                }
                                result.setText(ls);
                            }else {
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(getApplicationContext(), "Value must be between 0 and 1", duration);
                                toast.show();
                                result.setText("");
                            }

                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
        button35.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button35);
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
                            Double r = Math.tan(Math.toRadians(Double.parseDouble(last)));
                            if(r==0.0){
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                toast.show();
                                r=0.0;
                            }else {
                                r = 1/r;
                            }

                            String ls = "";
                            if(String.valueOf(r).contains("E")){
                                String l1 = String.valueOf(r).split("E")[1];
                                if(l1.contains("-")){
                                    ls="0";
                                }else {
                                    ls="";
                                    int duration = Toast.LENGTH_LONG;
                                    Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                    toast.show();
                                }
                            }else{
                                ls = String.valueOf(r);
                            }
                            result.setText(ls);
                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
        button36.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button36);
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
                            Double r = Double.parseDouble(last);
                            if(r==0.0){
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                toast.show();
                                r=0.0;
                            }else {
                                r = 1/r;
                            }

                            String ls = "";
                            if(String.valueOf(r).contains("E")){
                                ls =BigDecimal.valueOf(r).toPlainString();
                            }else{
                                ls = String.valueOf(r);
                            }
                            result.setText(ls);
                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
        button37.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button37);
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
                            if(last.contains("-")){
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(getApplicationContext(), "Value must be positive", duration);
                                toast.show();
                                result.setText("");
                            }else{
                                Double r = Math.log10(Double.parseDouble(last));
                                String ls = "";
                                if(String.valueOf(r).contains("E")){
                                    String l1 = String.valueOf(r).split("E")[1];
                                    if(l1.contains("-")){
                                        ls="0";
                                    }else {
                                        ls="";
                                        int duration = Toast.LENGTH_LONG;
                                        Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                        toast.show();
                                    }
                                }else{
                                    if(String.valueOf(r).equals("Infinity")){
                                        int duration = Toast.LENGTH_LONG;
                                        Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                        toast.show();
                                        result.setText("");
                                    }else if(String.valueOf(r).equals("-Infinity")){
                                        int duration = Toast.LENGTH_LONG;
                                        Toast toast = Toast.makeText(getApplicationContext(), "-Infinity", duration);
                                        toast.show();
                                        result.setText("");
                                    }else {
                                        ls = String.valueOf(r);
                                    }

                                }
                                result.setText(ls);
                            }

                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
        button38.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button38);
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
                            double r = Double.parseDouble(last);
                            if(Integer.parseInt(String.valueOf(r).split("\\.")[1])==0){
                                if((int) (r)<=100){
                                    BigInteger factorial = BigInteger.ONE; for (int i = (int)r; i > 0; i--) { factorial = factorial.multiply(BigInteger.valueOf(i)); }

                                    result.setText(String.valueOf(factorial));
                                }else {
                                    int duration = Toast.LENGTH_LONG;
                                    Toast toast = Toast.makeText(getApplicationContext(), "Max value is 100", duration);
                                    toast.show();
                                    result.setText("");
                                }

                            }else {
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(getApplicationContext(), "Decimal numbers not allowed", duration);
                                toast.show();
                                result.setText("");
                            }


                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
        button39.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button39);
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
                            double r = Double.parseDouble(last);
                            if(String.valueOf(r).contains("-")){
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(getApplicationContext(), "Negative value not allowed", duration);
                                toast.show();
                                result.setText("");
                            }else {
                                r = Math.sqrt(r);
                                if(String.valueOf(r).contains("E")){
                                    last =BigDecimal.valueOf(r).toPlainString();
                                }else{
                                    last = String.valueOf(r);
                                }
                                result.setText(last);
                            }

                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
        button40.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button40);
                if(result.getText().toString().length()==0){
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(getApplicationContext(),"Enter number first", duration);
                    toast.show();
                }else{
                    String l = result.getText().toString().substring(result.getText().toString().length()-1);
                    if(l.equals("+")||l.equals("-")||l.equals("/")||l.equals("*")||l.equals("^")){
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(getApplicationContext(),"Complete the equation", duration);
                        toast.show();
                    }else {
                        process = result.getText().toString();
                        process = process+"^";
                        result.setText(process);
                        op = false;
                    }
                }
            }
        });
        button41.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button41);
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
                            double r = Double.parseDouble(last);
                            if(String.valueOf(r).contains("-")){
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(getApplicationContext(), "Negative value not allowed", duration);
                                toast.show();
                                result.setText("");
                            }else {
                                r = Math.pow(r,0.3333333);
                                if(String.valueOf(r).contains("E")){
                                    last =BigDecimal.valueOf(r).toPlainString();
                                }else{
                                    last = String.valueOf(r);
                                }
                                result.setText(last);
                            }

                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
        button42.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button42);

                if(result.length()==0){
                    result.setText(pi);
                    op=true;
                }else {
                    if(op){
                        process=result.getText().toString();
                        String s=process+"*"+pi;
                        result.setText(s);

                    }else{
                        process=result.getText().toString();
                        result.setText(process+pi);
                        op=true;
                    }
                }
            }
        });
        button43.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button43);
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
                            double r = Double.parseDouble(last);
                            if(String.valueOf(r).contains("-")){
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(getApplicationContext(), "Negative value not allowed", duration);
                                toast.show();
                                result.setText("");
                            }else {
                                r = Math.exp(r);
                                if(String.valueOf(r).contains("E")){
                                    last =BigDecimal.valueOf(r).toPlainString();
                                }else{
                                    last = String.valueOf(r);
                                }
                                result.setText(last);
                            }

                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
        button17.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button17);
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
                            if(last.contains("-")){
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(getApplicationContext(), "Value must be positive", duration);
                                toast.show();
                                result.setText("");
                            }else {
                                Double r = Math.log1p(Double.parseDouble(last));
                                String ls = "";
                                if(String.valueOf(r).contains("E")){
                                    String l1 = String.valueOf(r).split("E")[1];
                                    if(l1.contains("-")){
                                        ls="0";
                                    }else {
                                        ls="";
                                        int duration = Toast.LENGTH_LONG;
                                        Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                        toast.show();
                                    }
                                }else{
                                    if(String.valueOf(r).equals("Infinity")){
                                        int duration = Toast.LENGTH_LONG;
                                        Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                        toast.show();
                                        result.setText("");
                                    }else if(String.valueOf(r).equals("-Infinity")){
                                        int duration = Toast.LENGTH_LONG;
                                        Toast toast = Toast.makeText(getApplicationContext(), "-Infinity", duration);
                                        toast.show();
                                        result.setText("");
                                    }else {
                                        ls = String.valueOf(r);
                                    }

                                }
                                result.setText(ls);
                            }

                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
        button18.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button18);
                if(result.length()==0){
                    result.setText("10^");
                }else {
                    if(op){
                        process=result.getText().toString();
                        String s=process+"*"+"10^";
                        result.setText(s);
                        op=false;
                    }else{
                        if(result.getText().toString().contains("^")){
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(getApplicationContext(),"Solve this equation first", duration);
                            toast.show();
                        }else {
                            process=result.getText().toString();
                            result.setText(process+"10^");
                        }


                    }
                }
            }
        });
        button19.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button19);
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

                                Double r = Math.toDegrees(Math.atan(Double.parseDouble(last)));
                                String ls = "";
                                if(String.valueOf(r).contains("E")){
                                    String l1 = String.valueOf(r).split("E")[1];
                                    if(l1.contains("-")){
                                        ls="0";
                                    }else {
                                        ls="";
                                        int duration = Toast.LENGTH_LONG;
                                        Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                        toast.show();
                                    }
                                }else{
                                    ls = String.valueOf(r);
                                }
                                result.setText(ls);

                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
        button20.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button20);
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
                            Double r = Math.sin(Math.toRadians(Double.parseDouble(last)));
                            result.setText(String.valueOf(r));
                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
        button44.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button44);
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
                            if(Double.parseDouble(last)>=-1 && Double.parseDouble(last)<=1){
                                Double r = Math.toDegrees(Math.asin(Double.parseDouble(last)));
                                String ls = "";
                                if(String.valueOf(r).contains("E")){
                                    String l1 = String.valueOf(r).split("E")[1];
                                    if(l1.contains("-")){
                                        ls="0";
                                    }else {
                                        ls="";
                                        int duration = Toast.LENGTH_LONG;
                                        Toast toast = Toast.makeText(getApplicationContext(), "Infinity", duration);
                                        toast.show();
                                    }
                                }else{
                                    ls = String.valueOf(r);
                                }
                                result.setText(ls);
                            }else {
                                int duration = Toast.LENGTH_LONG;
                                Toast toast = Toast.makeText(getApplicationContext(), "Value must be between 0 and 1", duration);
                                toast.show();
                                result.setText("");
                            }

                        }

                    }else {
                        process = result.getText().toString();
                        result.setText(process);

                    }
                }
            }

        });
    }//eval function
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