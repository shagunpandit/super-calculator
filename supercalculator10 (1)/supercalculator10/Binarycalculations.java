package com.calculator.supercalculator10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class Binarycalculations extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    EditText firstin,secondin;
    TextView operation,binaryres;
    Button calculate;
    static String decimalToBinary(double num, int k_prec)
    {
        String binary = "";

        // Fetch the integral part of decimal number
        int Integral = (int) num;

        // Fetch the fractional part decimal number
        double fractional = num - Integral;

        // Conversion of integral part to
        // binary equivalent
        while (Integral > 0)
        {
            int rem = Integral % 2;

            // Append 0 in binary
            binary += ((char)(rem + '0'));

            Integral /= 2;
        }

        // Reverse string to get original binary
        // equivalent
        binary = reverse(binary);

        // Append point before conversion of
        // fractional part
        binary += ('.');

        // Conversion of fractional part to
        // binary equivalent
        while (k_prec-- > 0)
        {
            // Find next bit in fraction
            fractional *= 2;
            int fract_bit = (int) fractional;

            if (fract_bit == 1)
            {
                fractional -= fract_bit;
                binary += (char)(1 + '0');
            }
            else
            {
                binary += (char)(0 + '0');
            }
        }

        return binary;
    }
    static String reverse(String input)
    {
        char[] temparray = input.toCharArray();
        int left, right = 0;
        right = temparray.length - 1;

        for (left = 0; left < right; left++, right--)
        {
            // Swap values of left and right
            char temp = temparray[left];
            temparray[left] = temparray[right];
            temparray[right] = temp;
        }
        return String.valueOf(temparray);
    }
    static double binaryToDecimal(String binary,
                                  int len)
    {

        // Fetch the radix point
        int point = binary.indexOf('.');

        // Update point if not found
        if (point == -1)
            point = len;

        double intDecimal = 0,
                fracDecimal = 0,
                twos = 1;

        // Convert integral part of binary to decimal
        // equivalent
        for(int i = point - 1; i >= 0; i--)
        {
            intDecimal += (binary.charAt(i) - '0') * twos;
            twos *= 2;
        }

        // Convert fractional part of binary to
        // decimal equivalent
        twos = 2;
        for(int i = point + 1; i < len; i++)
        {
            fracDecimal += (binary.charAt(i) - '0') / twos;
            twos *= 2.0;
        }

        // Add both integral and fractional part
        return intDecimal + fracDecimal;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binarycalculations);
        firstin = findViewById(R.id.drinput2);
        secondin = findViewById(R.id.drinput3);
        operation = findViewById(R.id.textView9);
        binaryres = findViewById(R.id.textView16);
        calculate = findViewById(R.id.button55);
        spinner = findViewById(R.id.spinner2);
        spinner.setOnItemSelectedListener(this);
        String[] choices = getResources().getStringArray(R.array.binchoices);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,choices);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == R.id.spinner2) {

            final String opr = parent.getItemAtPosition(position).toString();
            if(opr.equals("Binary Addition")){
                operation.setText("+");
            }else if(opr.equals("Binary Subtraction")){
                operation.setText("-");
            }else if(opr.equals("Binary Multiplication")){
                operation.setText("*");
            }else{
                operation.setText("/");
            }

            calculate.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    YoYo.with(Techniques.ZoomIn)
                            .duration(500)
                            .repeat(0)
                            .playOn(calculate);
                    String f= firstin.getText().toString();
                    String s = secondin.getText().toString();

                    if(firstin.getText().length()==0||secondin.getText().length()==0){
                        if(firstin.getText().length()==0){
                            firstin.setError("Required");
                        }else {
                            secondin.setError("Required");
                        }
                    }else {
                            if (f.contains("2") || f.contains("3") || f.contains("4") || f.contains("5") || f.contains("6") || f.contains("7") ||
                                    f.contains("8") || f.contains("9")
                                    ||s.contains("2") || s.contains("3") || s.contains("4") || s.contains("5") || s.contains("6") || s.contains("7")
                                    || s.contains("8") || s.contains("9")){
                                if (f.contains("2") || f.contains("3") || f.contains("4") || f.contains("5") || f.contains("6") || f.contains("7") ||
                                        f.contains("8") || f.contains("9")){
                                    firstin.setError("Binary number contains only 1 and 0");
                                }else {
                                    secondin.setError("Binary number contains only 1 and 0");
                                }
                            }else {
                                if(opr.equals("Binary Addition")){
                                    String in1 = firstin.getText().toString();
                                    String in2 = secondin.getText().toString();
                                    if(in1.contains("-")||in2.contains("-")){
                                        Double a=0.0;
                                        Double b=0.0;
                                        if(in1.contains("-")&&in2.contains("-")) {
                                            in1 = in1.replace("-", "");
                                            in2 = in2.replace("-", "");
                                            a = -binaryToDecimal(in1, in1.length());
                                            b = -binaryToDecimal(in2, in2.length());
                                            Double c = a + b;
                                            String res = "-" + decimalToBinary(c, 10);
                                            binaryres.setText(res);
                                        }
                                        else if(in1.contains("-")){
                                            in1 = in1.replace("-","");
                                             a= -binaryToDecimal(in1,in1.length());
                                             b = binaryToDecimal(in2,in2.length());
                                        }else if(in2.contains("-")) {
                                            in2 = in2.replace("-","");
                                            a = binaryToDecimal(in1,in1.length());
                                            b = -binaryToDecimal(in2,in2.length());
                                        }

                                        Double c = a+b;
                                        String res = "";
                                        if(String.valueOf(c).contains("-")){
                                            res = String.valueOf(c).replace("-","");
                                            res = "-"+decimalToBinary(Double.parseDouble(res),10);
                                        }else {
                                            res = decimalToBinary(c,10);
                                        }
                                        binaryres.setText(res);
                                    }else {

                                            Double a = binaryToDecimal(in1,in1.length());
                                            Double b = binaryToDecimal(in2,in2.length());
                                            Double c = a+b;
                                            binaryres.setText(decimalToBinary(c,10));

                                    }

                                }else if(opr.equals("Binary Subtraction")){
                                    String in1 = firstin.getText().toString();
                                    String in2 = secondin.getText().toString();
                                    if(in1.contains("-")||in2.contains("-")){
                                        Double a=0.0;
                                        Double b=0.0;
                                        if(in1.contains("-")&&in2.contains("-")) {
                                            in1 = in1.replace("-", "");
                                            in2 = in2.replace("-", "");
                                            a = -binaryToDecimal(in1, in1.length());
                                            b = -binaryToDecimal(in2, in2.length());
                                            Double c = a - b;
                                            String res = "";
                                            if(String.valueOf(c).contains("-")){
                                                res = String.valueOf(c).replace("-","");
                                                res = "-"+decimalToBinary(Double.parseDouble(res),10);
                                            }else {
                                                res = decimalToBinary(c,10);
                                            }
                                            binaryres.setText(res);
                                        }
                                        else if(in1.contains("-")){
                                            in1 = in1.replace("-","");
                                            a= -binaryToDecimal(in1,in1.length());
                                            b = binaryToDecimal(in2,in2.length());
                                        }else if(in2.contains("-")) {
                                            in2 = in2.replace("-","");
                                            a = binaryToDecimal(in1,in1.length());
                                            b = -binaryToDecimal(in2,in2.length());
                                        }

                                        Double c = a-b;
                                        String res = "";
                                        if(String.valueOf(c).contains("-")){
                                            res = String.valueOf(c).replace("-","");
                                            res = "-"+decimalToBinary(Double.parseDouble(res),10);
                                        }else {
                                            res = decimalToBinary(c,10);
                                        }
                                        binaryres.setText(res);
                                    }else {

                                        Double a = binaryToDecimal(in1,in1.length());
                                        Double b = binaryToDecimal(in2,in2.length());
                                        Double c = a-b;
                                        String res = "";
                                        if(String.valueOf(c).contains("-")){
                                            res = String.valueOf(c).replace("-","");
                                            res = "-"+decimalToBinary(Double.parseDouble(res),10);
                                        }else {
                                            res = decimalToBinary(c,10);
                                        }
                                        binaryres.setText(res);

                                    }
                                }else if(opr.equals("Binary Multiplication")) {
                                    String in1 = firstin.getText().toString();
                                    String in2 = secondin.getText().toString();
                                    if(in1.contains("-")||in2.contains("-")){
                                        Double a=0.0;
                                        Double b=0.0;
                                        if(in1.contains("-")&&in2.contains("-")) {
                                            in1 = in1.replace("-", "");
                                            in2 = in2.replace("-", "");
                                            a = -binaryToDecimal(in1, in1.length());
                                            b = -binaryToDecimal(in2, in2.length());
                                            Double c = a * b;
                                            String res = "";
                                            if(String.valueOf(c).contains("-")){
                                                res = String.valueOf(c).replace("-","");
                                                res = "-"+decimalToBinary(Double.parseDouble(res),10);
                                            }else {
                                                res = decimalToBinary(c,10);
                                            }
                                            binaryres.setText(res);
                                        }
                                        else if(in1.contains("-")){
                                            in1 = in1.replace("-","");
                                            a= -binaryToDecimal(in1,in1.length());
                                            b = binaryToDecimal(in2,in2.length());
                                        }else if(in2.contains("-")) {
                                            in2 = in2.replace("-","");
                                            a = binaryToDecimal(in1,in1.length());
                                            b = -binaryToDecimal(in2,in2.length());
                                        }

                                        Double c = a*b;
                                        String res = "";
                                        if(String.valueOf(c).contains("-")){
                                            res = String.valueOf(c).replace("-","");
                                            res = "-"+decimalToBinary(Double.parseDouble(res),10);
                                        }else {
                                            res = decimalToBinary(c,10);
                                        }
                                        binaryres.setText(res);
                                    }else {

                                        Double a = binaryToDecimal(in1,in1.length());
                                        Double b = binaryToDecimal(in2,in2.length());
                                        Double c = a*b;
                                        String res = "";
                                        if(String.valueOf(c).contains("-")){
                                            res = String.valueOf(c).replace("-","");
                                            res = "-"+decimalToBinary(Double.parseDouble(res),10);
                                        }else {
                                            res = decimalToBinary(c,10);
                                        }
                                        binaryres.setText(res);

                                    }
                                }else{
                                    String in1 = firstin.getText().toString();
                                    String in2 = secondin.getText().toString();
                                    if(in1.contains("-")||in2.contains("-")){
                                        Double a=0.0;
                                        Double b=0.0;
                                        if(in1.contains("-")&&in2.contains("-")) {
                                            in1 = in1.replace("-", "");
                                            in2 = in2.replace("-", "");
                                            a = -binaryToDecimal(in1, in1.length());
                                            b = -binaryToDecimal(in2, in2.length());
                                            Double c = a / b;
                                            String res = "";
                                            if(String.valueOf(c).contains("-")){
                                                res = String.valueOf(c).replace("-","");
                                                res = "-"+decimalToBinary(Double.parseDouble(res),10);
                                            }else {
                                                res = decimalToBinary(c,10);
                                            }
                                            binaryres.setText(res);
                                        }
                                        else if(in1.contains("-")){
                                            in1 = in1.replace("-","");
                                            a= -binaryToDecimal(in1,in1.length());
                                            b = binaryToDecimal(in2,in2.length());
                                        }else if(in2.contains("-")) {
                                            in2 = in2.replace("-","");
                                            a = binaryToDecimal(in1,in1.length());
                                            b = -binaryToDecimal(in2,in2.length());
                                        }

                                        Double c = a/b;
                                        String res = "";
                                        if(String.valueOf(c).contains("-")){
                                            res = String.valueOf(c).replace("-","");
                                            res = "-"+decimalToBinary(Double.parseDouble(res),10);
                                        }else {
                                            res = decimalToBinary(c,10);
                                        }
                                        binaryres.setText(res);
                                    }else {

                                        Double a = binaryToDecimal(in1,in1.length());
                                        Double b = binaryToDecimal(in2,in2.length());
                                        Double c = a/b;
                                        String res = "";
                                        if(String.valueOf(c).contains("-")){
                                            res = String.valueOf(c).replace("-","");
                                            res = "-"+decimalToBinary(Double.parseDouble(res),10);
                                        }else {
                                            res = decimalToBinary(c,10);
                                        }
                                        binaryres.setText(res);

                                    }
                                }
                            }
                        }
                    }
            });
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}