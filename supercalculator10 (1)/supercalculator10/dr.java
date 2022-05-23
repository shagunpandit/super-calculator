package com.calculator.supercalculator10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.math.MathUtils;

import android.content.Intent;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.ScrollingMovementMethod;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.math.BigDecimal;
import java.util.ArrayList;

public class dr extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Button button52;
    EditText drin;
    TextView one,two,binarytext,octaltext,hextext,decitext,signmtext,sign1text,sign2text,tens,nines;
    String in;
    private Spinner spinner;
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


    public void scientific(View View) {
        Intent scientific = new Intent(this, scientific.class);
        startActivity(scientific);
    }



    public void equations(View view) {
        Intent equations = new Intent(this, Equations.class);
        startActivity(equations);
    }

    public void dr(View view) {
        Intent dr = new Intent(this, dr.class);
        startActivity(dr);
    }

    public void normal(View view) {
        Intent normal = new Intent(this, MainActivity.class);
        startActivity(normal);
    }
    static String decimalToOctal(double num, int k_prec)
    {
        String octal = "";

        // Fetch the integral part of decimal number
        int Integral = (int) num;

        // Fetch the fractional part decimal number
        double fractional = num - Integral;

        // Conversion of integral part to

        while (Integral > 0)
        {
            int rem = Integral % 8;


            octal += String.valueOf(rem);

            Integral /= 8;
        }

        // Reverse string to get original binary
        // equivalent
        octal = reverse(octal);

        // Append point before conversion of
        // fractional part
        octal += ('.');

        while (k_prec-- > 0)
        {
            // Find next bit in fraction
            fractional *= 8;
            int fract_bit = (int) fractional;

            octal+=fract_bit;
            fractional-=fract_bit;
        }

        return octal;
    }
    static String decimalToHexa(double num, int k_prec)
    {
        String hex = "";

        // Fetch the integral part of decimal number
        int Integral = (int) num;

        // Fetch the fractional part decimal number
        double fractional = num - Integral;

        // Conversion of integral part to

        while (Integral > 0)
        {
            int rem = Integral % 16;

            if (rem>=10){
                if (rem==10){
                    hex += "A";

                    Integral /= 16;
                }else if(rem==11){
                    hex+="B";
                    Integral/=16;
                }
                else if(rem==12){
                    hex+="C";
                    Integral/=16;
                }else if(rem==13){
                    hex+="D";
                    Integral/=16;
                }else if(rem==14){
                    hex+="E";
                    Integral/=16;
                }else if(rem==15){
                    hex+="F";
                    Integral/=16;
                }
            }else {
                hex += String.valueOf(rem);

                Integral /= 16;
            }

        }

        // Reverse string to get original binary
        // equivalent
        hex = reverse(hex);

        // Append point before conversion of
        // fractional part
        hex += ('.');

        while (k_prec-- > 0)
        {
            // Find next bit in fraction
            fractional *= 16;
            int fract_bit = (int) fractional;
            if(fract_bit>=10){
                if(fract_bit==10){
                   hex+="A";
                   fractional-=fract_bit;
                }else if(fract_bit==11){
                    hex+="B";
                    fractional-=fract_bit;
                }else if(fract_bit==12){
                    hex+="C";
                    fractional-=fract_bit;
                }else if(fract_bit==13){
                    hex+="D";
                    fractional-=fract_bit;
                }else if(fract_bit==14){
                    hex+="E";
                    fractional-=fract_bit;
                }else if(fract_bit==15){
                    hex+="F";
                    fractional-=fract_bit;
                }
            }else {
                hex+=fract_bit;
                fractional-=fract_bit;
            }

        }

        return hex;
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
    static String octaltoDecimal(String octal)
    {
        String otd="";
        if(octal.contains(".")){
            String first = octal.split("\\.")[0];
            String second = octal.split("\\.")[1];
            double main=0;
            double frac = 0;
            int s = 0;
            int t =1;
            for(int i=first.length()-1;i>=0;i--){
                Integer a = Integer.parseInt(String.valueOf(first.charAt(i)));
                main += Math.pow(8,s)*a;
                s++;
            }
            for(int j=0;j<second.length();j++){
                Integer b = Integer.parseInt(String.valueOf(second.charAt(j)));
                frac+=(1/Math.pow(8,t))*b;
                t++;
            }
            String m = String.valueOf(main).split("\\.")[0];
            String fr = String.valueOf(frac).split("\\.")[1];
            otd=m+"."+fr;
            return otd;
        }else{
            double p=0;
            int s = 0;
            for(int i=octal.length()-1;i>=0;i--){
                Integer a = Integer.parseInt(String.valueOf(octal.charAt(i)));
                p += Math.pow(8,s)*a;
                s++;
            }
            otd = String.valueOf(p);
            return otd;
        }
    }
    static String hexatoDecimal(String hexa)
    {
        String htd="";
        if(hexa.contains(".")){
            String first = hexa.split("\\.")[0];
            String second = hexa.split("\\.")[1];
            double main=0;
            double frac = 0;
            int s = 0;
            int t =1;
            for(int i=first.length()-1;i>=0;i--){
                Character c = first.charAt(i);
                if (c=='A'){
                    String f="10";
                    Integer a = Integer.parseInt(f);
                    main += Math.pow(16,s)*a;
                    s++;
                }else if(c=='B'){
                    String f="11";
                    Integer a = Integer.parseInt(f);
                    main += Math.pow(16,s)*a;
                    s++;

                }else if(c=='C'){
                    String f="12";
                    Integer a = Integer.parseInt(f);
                    main += Math.pow(16,s)*a;
                    s++;
                }else if(c=='D'){
                    String f="13";
                    Integer a = Integer.parseInt(f);
                    main += Math.pow(16,s)*a;
                    s++;
                }else if(c=='E'){
                    String f="14";
                    Integer a = Integer.parseInt(f);
                    main += Math.pow(16,s)*a;
                    s++;
                }else if(c=='F'){
                    String f="15";
                    Integer a = Integer.parseInt(f);
                    main += Math.pow(16,s)*a;
                    s++;
                }else {
                    Integer a = Integer.parseInt(String.valueOf(c));
                    main += Math.pow(16,s)*a;
                    s++;
                }


            }
            for(int j=0;j<second.length();j++){
                Character d = second.charAt(j);
                if (d=='A'){
                    String f="10";
                    Integer b = Integer.parseInt(f);
                    frac+=(1/Math.pow(16,t))*b;
                    t++;
                }else if(d=='B'){
                    String f="11";
                    Integer b = Integer.parseInt(f);
                    frac+=(1/Math.pow(16,t))*b;
                    t++;

                }else if(d=='C'){
                    String f="12";
                    Integer b = Integer.parseInt(f);
                    frac+=(1/Math.pow(16,t))*b;
                    t++;
                }else if(d=='D'){
                    String f="13";
                    Integer b = Integer.parseInt(f);
                    frac+=(1/Math.pow(16,t))*b;
                    t++;
                }else if(d=='E'){
                    String f="14";
                    Integer b = Integer.parseInt(f);
                    frac+=(1/Math.pow(16,t))*b;
                    t++;
                }else if(d=='F'){
                    String f="15";
                    Integer b = Integer.parseInt(f);
                    frac+=(1/Math.pow(16,t))*b;
                    t++;
                }else {
                    Integer b = Integer.parseInt(String.valueOf(d));
                    frac+=(1/Math.pow(16,t))*b;
                    t++;
                }

            }
            String m = String.valueOf(main).split("\\.")[0];
            String fr = String.valueOf(frac).split("\\.")[1];
            htd=m+"."+fr;
            return htd;
        }else{
            double p=0;
            int s = 0;
            for(int i=hexa.length()-1;i>=0;i--){
                Character n = hexa.charAt(i);
                if (n=='A'){
                    String f="10";
                    Integer a = Integer.parseInt(f);
                    p += Math.pow(16,s)*a;
                    s++;
                }else if(n=='B'){
                    String f="11";
                    Integer a = Integer.parseInt(f);
                    p += Math.pow(16,s)*a;
                    s++;

                }else if(n=='C'){
                    String f="12";
                    Integer a = Integer.parseInt(f);
                    p += Math.pow(16,s)*a;
                    s++;
                }else if(n=='D'){
                    String f="13";
                    Integer a = Integer.parseInt(f);
                    p += Math.pow(16,s)*a;
                    s++;
                }else if(n=='E'){
                    String f="14";
                    Integer a = Integer.parseInt(f);
                    p += Math.pow(16,s)*a;
                    s++;
                }else if(n=='F'){
                    String f="15";
                    int a = Integer.parseInt(f);
                    p += Math.pow(16,s)*a;
                    s++;
                }else {
                    int a = Integer.parseInt(String.valueOf(n));
                    p += Math.pow(16,s)*a;
                    s++;
                }

            }
            hexa = String.valueOf(p);
            return hexa;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr);
        drin = (EditText) findViewById(R.id.drinput);
        one = findViewById(R.id.textView10);
        two= findViewById(R.id.textView11);
        button52 = findViewById(R.id.button52);
        binarytext = findViewById(R.id.textView12);
        octaltext = findViewById(R.id.textView13);
        hextext = findViewById(R.id.textView14);
        decitext = findViewById(R.id.textView15);
        spinner = findViewById(R.id.spinner);
        signmtext = findViewById(R.id.textView5);
        sign1text = findViewById(R.id.textView8);
        sign2text = findViewById(R.id.textView7);
        tens = findViewById(R.id.textView26);
        nines = findViewById(R.id.niness);
        spinner.setOnItemSelectedListener(this);
        String[] choices = getResources().getStringArray(R.array.choices);
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,choices);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        octaltext.setMovementMethod(new ScrollingMovementMethod());
        hextext.setMovementMethod(new ScrollingMovementMethod());
        binarytext.setMovementMethod(new ScrollingMovementMethod());
        decitext.setMovementMethod(new ScrollingMovementMethod());
        one.setMovementMethod(new ScrollingMovementMethod());
        two.setMovementMethod(new ScrollingMovementMethod());
        signmtext.setMovementMethod(new ScrollingMovementMethod());
        sign2text.setMovementMethod(new ScrollingMovementMethod());
        sign1text.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == R.id.spinner){

        final String value = parent.getItemAtPosition(position).toString();
        if(value.equals("Binary Calculations")){
            Intent bc = new Intent(this, Binarycalculations.class);
            startActivity(bc);
            finish();
        }
        one.setText("1s Complement");
        two.setText("2s Complement");
        binarytext.setText("Binary");
        octaltext.setText("Octal");
        hextext.setText("Hexa");
        decitext.setText("Decimal");
        signmtext.setText("Sign Magnitude");
        sign1text.setText("Sign 1s Complement");
        sign2text.setText("Sign 2s Complement");
        tens.setText("10s Complement");
        nines.setText("9s Complement");

            button52.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    YoYo.with(Techniques.ZoomIn)
                            .duration(500)
                            .repeat(0)
                            .playOn(button52);
                    String d = "Decimal";
                    String b = "Binary";
                    String o = "Octal";
                    String h = "Hexadecimal";
                    in = drin.getText().toString();

                    if(drin.length()==0){
                        drin.setError("Required");
                    }else{
                        if(value.equals(d)) {
                            if(in.contains("-")){
                                int count = 0;
                                for(int i =0;i<in.length();i++){
                                    if(in.charAt(i)=='-'){
                                        count++;
                                    }
                                }
                                if(count==1){
                                    if(in.charAt(0)=='-' && in.length()>1){
                                        in = in.replace("-","");
                                        if(in.matches("-?\\d+(\\.\\d+)?")){
                                            double r = Double.parseDouble(in);
                                            String binres = decimalToBinary(r,10);
                                            SpannableStringBuilder mb = new SpannableStringBuilder("Binary\n"+"-"+binres);

                                            StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);

                                            mb.setSpan(bss, 0,6, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            binarytext.setText(mb);

                                            String octres = decimalToOctal(r,10);
                                            SpannableStringBuilder mo = new SpannableStringBuilder("Octal\n"+"-"+octres);

                                            mo.setSpan(bss, 0,5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            octaltext.setText(mo);

                                            String hexres = decimalToHexa(r,10);
                                            SpannableStringBuilder mh = new SpannableStringBuilder("Hexadecimal\n"+"-"+hexres);

                                            mh.setSpan(bss, 0,11, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            hextext.setText(mh);

                                            SpannableStringBuilder md = new SpannableStringBuilder("Decimal\n"+"-"+in);

                                            md.setSpan(bss, 0,7, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            decitext.setText(md);

                                            String onescomp="";
                                            for (int i = 0; i < binres.length(); i++) {
                                                if(binres.charAt(i)=='0'){
                                                    onescomp+="1";
                                                }else if(binres.charAt(i)=='1'){
                                                    onescomp+="0";
                                                }else if(binres.charAt(i)=='.'){
                                                    onescomp+=".";
                                                }


                                            }
                                            SpannableStringBuilder mone = new SpannableStringBuilder("1s Complement\n"+"-"+onescomp);

                                            mone.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            one.setText(mone);

                                            String twoscomp="";
                                            char add = '1';
                                            for(int i=onescomp.length()-1; i>=0;i--){
                                                if(onescomp.charAt(i)=='.'){
                                                    twoscomp+=".";
                                                }
                                                else if(onescomp.charAt(i)==add){
                                                    if(add=='1'){
                                                        twoscomp+="0";
                                                    }else {
                                                        twoscomp+="0";
                                                    }
                                                }else{
                                                    twoscomp+="1";
                                                    add='0';
                                                }

                                            }
                                            twoscomp = reverse(twoscomp);
                                            SpannableStringBuilder mtwo = new SpannableStringBuilder("2s Complement\n"+"-"+twoscomp);

                                            mtwo.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            two.setText(mtwo);
                                            if(Double.parseDouble(in)<=2147483647){
                                                String binfirst = binres.split("\\.")[0];
                                                while (binfirst.length()<32){
                                                    binfirst = '0'+binfirst;
                                                }
                                                String finalsign = binfirst+"."+binres.split("\\.")[1];
                                                finalsign = finalsign.replaceFirst("0","1");
                                                SpannableStringBuilder sm = new SpannableStringBuilder("Sign Magnitude\n"+finalsign);

                                                sm.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                                signmtext.setText(sm);
                                                String sonescomp="";
                                                finalsign = finalsign.replaceFirst("1","0");
                                                for (int i = 0; i < finalsign.length(); i++) {
                                                    if(finalsign.charAt(i)=='0'){
                                                        sonescomp+="1";
                                                    }else if(finalsign.charAt(i)=='1'){
                                                        sonescomp+="0";
                                                    }else if(finalsign.charAt(i)=='.'){
                                                        sonescomp+=".";
                                                    }

                                                }
                                                SpannableStringBuilder sone = new SpannableStringBuilder("Sign 1s Complement\n"+sonescomp);

                                                sone.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                                sign1text.setText(sone);
                                                String stwoscomp="";

                                                char ad = '1';
                                                for(int i=sonescomp.length()-1; i>=0;i--){
                                                    if(sonescomp.charAt(i)=='.'){
                                                        stwoscomp+=".";
                                                    }
                                                    else if(sonescomp.charAt(i)==ad){
                                                        if(ad=='1'){
                                                            stwoscomp+="0";
                                                        }else {
                                                            stwoscomp+="0";
                                                        }
                                                    }else{
                                                        stwoscomp+="1";
                                                        ad='0';
                                                    }

                                                }
                                                stwoscomp = reverse(stwoscomp);

                                                SpannableStringBuilder stwo = new SpannableStringBuilder("Sign 2s Complement\n"+stwoscomp);

                                                stwo.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                                sign2text.setText(stwo);

//                                                10s complement
                                                int l = (int) Double.parseDouble(in.replace("-",""));
                                                String p =String.valueOf(l);
                                                double tenres=0.0;
                                                if(l==0){

                                                    if(Double.parseDouble(in)==0.0){
                                                        tenres=0.0;
                                                    }else{
                                                        tenres = 1-Double.parseDouble(in);
                                                    }
                                                }else {
                                                    tenres = Math.pow(10,p.length())-Double.parseDouble("-"+in);
                                                }

                                                SpannableStringBuilder ten = new SpannableStringBuilder("10s Complement\n"+BigDecimal.valueOf(tenres).toPlainString());

                                                ten.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                tens.setText(ten);

                                                if(Double.parseDouble(in)==0.0){
                                                    SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+"0");

                                                    nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                    nines.setText(nine);
                                                }else {
                                                    String mn = BigDecimal.valueOf(Double.parseDouble(in)).toPlainString();
                                                    double z=0.0;
                                                    if(mn.contains(".")){
                                                        String x = mn.split("\\.")[0];
                                                        String y = mn.split("\\.")[1];

                                                        if(x.equals("0")){
                                                            z = 1- Math.pow(10,-y.length())+Double.parseDouble(in);
                                                        }else if(y.equals("0")) {
                                                            z = Math.pow(10,x.length())-1+Double.parseDouble(in);
                                                        }else {
                                                            z = Math.pow(10,x.length())-Math.pow(10,-y.length())+Double.parseDouble(in);
                                                        }
                                                    }else{
                                                        if(mn.equals("0")){
                                                            z=0;
                                                        }else {
                                                            z = Math.pow(10,in.length())-1+Double.parseDouble(in);

                                                        }
                                                    }
                                                    SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+BigDecimal.valueOf(z).toPlainString());

                                                    nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                                        nines.setText(nine);

                                                }




                                            }else {
                                                SpannableStringBuilder same = new SpannableStringBuilder("For signed representation Value must be less than 2147483647");
                                                same.setSpan(bss, 0,60, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                signmtext.setText(same);
                                                sign1text.setText(same);
                                                sign2text.setText(same);
                                                SpannableStringBuilder wten = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                                wten.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                tens.setText(wten);
                                                SpannableStringBuilder wnine = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                                wnine.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                nines.setText(wnine);

                                            }
                                        }else {
                                            drin.setError("Decimal number contains only numbers");
                                        }


                                    }
                                    else {
                                        drin.setError("Decimal number contains only numbers");
                                    }
                                }else {
                                    drin.setError("Decimal number contains only numbers");
                                }

                            }else{
                                if(in.matches("-?\\d+(\\.\\d+)?")){


                                    double r = Double.parseDouble(in);
                                    String binres = decimalToBinary(r,10);
                                    SpannableStringBuilder mb = new SpannableStringBuilder("Binary\n"+binres);

                                    StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);

                                    mb.setSpan(bss, 0,6, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                    binarytext.setText(mb);

                                    String octres = decimalToOctal(r,10);
                                    SpannableStringBuilder mo = new SpannableStringBuilder("Octal\n"+octres);

                                    mo.setSpan(bss, 0,5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                    octaltext.setText(mo);

                                    String hexres = decimalToHexa(r,10);
                                    SpannableStringBuilder mh = new SpannableStringBuilder("Hexadecimal\n"+hexres);

                                    mh.setSpan(bss, 0,11, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                    hextext.setText(mh);

                                    SpannableStringBuilder md = new SpannableStringBuilder("Decimal\n"+in);

                                    md.setSpan(bss, 0,7, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                    decitext.setText(md);

                                    String onescomp="";
                                    for (int i = 0; i < binres.length(); i++) {
                                        if(binres.charAt(i)=='0'){
                                            onescomp+="1";
                                        }else if(binres.charAt(i)=='1'){
                                            onescomp+="0";
                                        }else if(binres.charAt(i)=='.'){
                                            onescomp+=".";
                                        }


                                    }
                                    SpannableStringBuilder mone = new SpannableStringBuilder("1s Complement\n"+onescomp);

                                    mone.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                    one.setText(mone);

                                    String twoscomp="";
                                    char add = '1';
                                    for(int i=onescomp.length()-1; i>=0;i--){
                                        if(onescomp.charAt(i)=='.'){
                                            twoscomp+=".";
                                        }
                                        else if(onescomp.charAt(i)==add){
                                            if(add=='1'){
                                                twoscomp+="0";
                                            }else {
                                                twoscomp+="0";
                                            }
                                        }else{
                                            twoscomp+="1";
                                            add='0';
                                        }

                                    }
                                    twoscomp = reverse(twoscomp);
                                    SpannableStringBuilder mtwo = new SpannableStringBuilder("2s Complement\n"+twoscomp);

                                    mtwo.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                    two.setText(mtwo);

                                    if(Double.parseDouble(in)<=2147483647){
                                        String binfirst = binres.split("\\.")[0];
                                        while (binfirst.length()<32){
                                            binfirst = '0'+binfirst;
                                        }
                                        String finalsign = binfirst+"."+binres.split("\\.")[1];
                                        SpannableStringBuilder sm = new SpannableStringBuilder("Sign Magnitude\n"+finalsign);

                                        sm.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                        signmtext.setText(sm);
                                        SpannableStringBuilder sone = new SpannableStringBuilder("Sign 1s Complement\n"+finalsign);

                                        sone.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                        sign1text.setText(sone);

                                        SpannableStringBuilder stwo = new SpannableStringBuilder("Sign 2s Complement\n"+finalsign);

                                        stwo.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                        sign2text.setText(stwo);

                                        int l = (int) Double.parseDouble(in);
                                            String p =String.valueOf(l);
                                            double tenres=0.0;
                                            if(l==0){
                                                if(Double.parseDouble(in)==0.0){
                                                    tenres=0.0;
                                                }else{
                                                    tenres = 1-Double.parseDouble(in);
                                                }

                                            }else {
                                                tenres = Math.pow(10,p.length())-Double.parseDouble(in);
                                            }

                                            SpannableStringBuilder ten = new SpannableStringBuilder("10s Complement\n"+BigDecimal.valueOf(tenres).toPlainString());

                                            ten.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            tens.setText(ten);
                                        if(Double.parseDouble(in)==0.0){
                                            SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+"0");

                                            nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            nines.setText(nine);
                                        }else {
                                            String mn = BigDecimal.valueOf(Double.parseDouble(in)).toPlainString();
                                            double z=0.0;
                                            if(mn.contains(".")){
                                                String x = mn.split("\\.")[0];
                                                String y = mn.split("\\.")[1];

                                                if(x.equals("0")){
                                                    z = 1- Math.pow(10,-y.length())-Double.parseDouble(in);
                                                }else if(y.equals("0")) {
                                                    z = Math.pow(10,x.length())-1-Double.parseDouble(in);
                                                }else {
                                                    z = Math.pow(10,x.length())-Math.pow(10,-y.length())-Double.parseDouble(in);
                                                }
                                            }else{
                                                if(mn.equals("0")){
                                                    z=0;
                                                }else {
                                                    z = Math.pow(10,in.length())-1-Double.parseDouble(in);

                                                }
                                            }

                                            SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+BigDecimal.valueOf(z).toPlainString());

                                            nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                            nines.setText(nine);

                                        }

                                    }else {
                                        SpannableStringBuilder same = new SpannableStringBuilder("For signed representation Value must be less than 2147483647");
                                        same.setSpan(bss, 0,60, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        signmtext.setText(same);
                                        sign1text.setText(same);
                                        sign2text.setText(same);
                                        SpannableStringBuilder wten = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                        wten.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        tens.setText(wten);
                                        SpannableStringBuilder wnine = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                        wnine.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        nines.setText(wnine);


                                    }

                                }else {
                                    drin.setError("Decimal number contains only numbers");
                                }
                            }

                        }else if(value.equals(b)){
                            if(in.contains("-")){
                                int count = 0;
                                for(int i =0;i<in.length();i++){
                                    if(in.charAt(i)=='-'){
                                        count++;
                                    }
                                }
                                if(count==1) {
                                    if (in.charAt(0) == '-'&& in.length()>1) {
                                        in = in.replace("-","");
                                        if(in.matches("-?\\d+(\\.\\d+)?")){
                                            if(in.contains("2")||in.contains("3")||in.contains("4")||in.contains("5")||in.contains("6")||in.contains("7")||in.contains("8")||in.contains("9")){
                                                drin.setError("Binary number contain only 0 and 1");
                                            }else {
                                                double btd = binaryToDecimal(in,in.length());
                                                String btds = String.valueOf(btd);
                                                SpannableStringBuilder md = new SpannableStringBuilder("Decimal\n"+"-"+btds);

                                                StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);

                                                md.setSpan(bss, 0,7, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                decitext.setText(md);

                                                SpannableStringBuilder mb = new SpannableStringBuilder("Binary\n"+"-"+in);


                                                mb.setSpan(bss, 0,6, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                binarytext.setText(mb);

                                                String octres = decimalToOctal(btd,10);
                                                SpannableStringBuilder mo = new SpannableStringBuilder("Octal\n"+"-"+octres);

                                                mo.setSpan(bss, 0,5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                octaltext.setText(mo);

                                                String hexres = decimalToHexa(btd,10);
                                                SpannableStringBuilder mh = new SpannableStringBuilder("Hexadecimal\n"+"-"+hexres);

                                                mh.setSpan(bss, 0,11, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                hextext.setText(mh);

                                                String onescomp="";
                                                for (int i = 0; i < in.length(); i++) {
                                                    if(in.charAt(i)=='0'){
                                                        onescomp+="1";
                                                    }else if(in.charAt(i)=='1'){
                                                        onescomp+="0";
                                                    }else if(in.charAt(i)=='.'){
                                                        onescomp+=".";
                                                    }


                                                }
                                                SpannableStringBuilder mone = new SpannableStringBuilder("1s Complement\n"+"-"+onescomp);

                                                mone.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                one.setText(mone);

                                                String twoscomp="";
                                                char add = '1';
                                                for(int i=onescomp.length()-1; i>=0;i--){
                                                    if(onescomp.charAt(i)=='.'){
                                                        twoscomp+=".";
                                                    }
                                                    else if(onescomp.charAt(i)==add){
                                                        if(add=='1'){
                                                            twoscomp+="0";
                                                        }else {
                                                            twoscomp+="0";
                                                        }
                                                    }else{
                                                        twoscomp+="1";
                                                        add='0';
                                                    }

                                                }
                                                twoscomp = reverse(twoscomp);
                                                SpannableStringBuilder mtwo = new SpannableStringBuilder("2s Complement\n"+"-"+twoscomp);

                                                mtwo.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                two.setText(mtwo);
                                                if(btd<=2147483647){
                                                    in = decimalToBinary(btd,10);
                                                    String binfirst = in.split("\\.")[0];
                                                    while (binfirst.length()<32){
                                                        binfirst = '0'+binfirst;
                                                    }
                                                    String finalsign = binfirst+"."+in.split("\\.")[1];
                                                    finalsign = finalsign.replaceFirst("0","1");
                                                    SpannableStringBuilder sm = new SpannableStringBuilder("Sign Magnitude\n"+finalsign);

                                                    sm.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                                    signmtext.setText(sm);

                                                    String sonescomp="";
                                                    finalsign = finalsign.replaceFirst("1","0");
                                                    for (int i = 0; i < finalsign.length(); i++) {
                                                        if(finalsign.charAt(i)=='0'){
                                                            sonescomp+="1";
                                                        }else if(finalsign.charAt(i)=='1'){
                                                            sonescomp+="0";
                                                        }else if(finalsign.charAt(i)=='.'){
                                                            sonescomp+=".";
                                                        }

                                                    }
                                                    SpannableStringBuilder sone = new SpannableStringBuilder("Sign 1s Complement\n"+sonescomp);

                                                    sone.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                                    sign1text.setText(sone);
                                                    String stwoscomp="";

                                                    char ad = '1';
                                                    for(int i=sonescomp.length()-1; i>=0;i--){
                                                        if(sonescomp.charAt(i)=='.'){
                                                            stwoscomp+=".";
                                                        }
                                                        else if(sonescomp.charAt(i)==ad){
                                                            if(ad=='1'){
                                                                stwoscomp+="0";
                                                            }else {
                                                                stwoscomp+="0";
                                                            }
                                                        }else{
                                                            stwoscomp+="1";
                                                            ad='0';
                                                        }

                                                    }
                                                    stwoscomp = reverse(stwoscomp);

                                                    SpannableStringBuilder stwo = new SpannableStringBuilder("Sign 2s Complement\n"+stwoscomp);

                                                    stwo.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                                    sign2text.setText(stwo);

//                                                    10s complement
                                                    btds = btds.replace("-","");
                                                    int l = (int) Double.parseDouble(btds);
                                                    String p =String.valueOf(l);
                                                    double tenres=0.0;
                                                    if(l==0){

                                                        if(Double.parseDouble(btds)==0.0){
                                                            tenres=0.0;
                                                        }else{
                                                            tenres = 1-Double.parseDouble(btds);
                                                        }
                                                    }else {
                                                        tenres = Math.pow(10,p.length())-Double.parseDouble("-"+btds);
                                                    }

                                                    SpannableStringBuilder ten = new SpannableStringBuilder("10s Complement\n"+BigDecimal.valueOf(tenres).toPlainString());

                                                    ten.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                    tens.setText(ten);

                                                    if(Double.parseDouble(btds)==0.0){
                                                        SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+"0");

                                                        nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                        nines.setText(nine);
                                                    }else {
                                                        String mn = BigDecimal.valueOf(Double.parseDouble(btds)).toPlainString();
                                                        double z=0.0;
                                                        if(mn.contains(".")){
                                                            String x = mn.split("\\.")[0];
                                                            String y = mn.split("\\.")[1];

                                                            if(x.equals("0")){
                                                                z = 1- Math.pow(10,-y.length())+Double.parseDouble(btds);
                                                            }else if(y.equals("0")) {
                                                                z = Math.pow(10,x.length())-1+Double.parseDouble(btds);
                                                            }else {
                                                                z = Math.pow(10,x.length())-Math.pow(10,-y.length())+Double.parseDouble(btds);
                                                            }
                                                        }else{
                                                            if(mn.equals("0")){
                                                                z=0;
                                                            }else {
                                                                z = Math.pow(10,btds.length())-1+Double.parseDouble(btds);

                                                            }
                                                        }
                                                        SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+BigDecimal.valueOf(z).toPlainString());

                                                        nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                                        nines.setText(nine);

                                                    }


                                                }else {
                                                    SpannableStringBuilder same = new SpannableStringBuilder("For signed representation Value must be less than 2147483647");
                                                    same.setSpan(bss, 0,60, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                    signmtext.setText(same);
                                                    sign1text.setText(same);
                                                    sign2text.setText(same);
                                                    SpannableStringBuilder wten = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                                    wten.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                    tens.setText(wten);
                                                    SpannableStringBuilder wnine = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                                    wnine.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                    nines.setText(wnine);

                                                }
                                            }
                                        }else {
                                            drin.setError("Binary number contain only 0 and 1");
                                        }

                                    } else {

                                        drin.setError("Binary number contain only 0 and 1");
                                    }
                                }else {
                                    drin.setError("Binary number contain only 0 and 1");
                                }

                            }else{
                                if(in.matches("-?\\d+(\\.\\d+)?")){
                                    if(in.contains("2")||in.contains("3")||in.contains("4")||in.contains("5")||in.contains("6")||in.contains("7")||in.contains("8")||in.contains("9")){
                                        drin.setError("Binary number contain only 0 and 1");
                                    }else {
                                        double btd = binaryToDecimal(in,in.length());
                                        String btds = String.valueOf(btd);
                                        SpannableStringBuilder md = new SpannableStringBuilder("Decimal\n"+btds);

                                        StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);

                                        md.setSpan(bss, 0,7, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        decitext.setText(md);

                                        SpannableStringBuilder mb = new SpannableStringBuilder("Binary\n"+in);


                                        mb.setSpan(bss, 0,6, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        binarytext.setText(mb);

                                        String octres = decimalToOctal(btd,10);
                                        SpannableStringBuilder mo = new SpannableStringBuilder("Octal\n"+octres);

                                        mo.setSpan(bss, 0,5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        octaltext.setText(mo);

                                        String hexres = decimalToHexa(btd,10);
                                        SpannableStringBuilder mh = new SpannableStringBuilder("Hexadecimal\n"+hexres);

                                        mh.setSpan(bss, 0,11, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        hextext.setText(mh);

                                        String onescomp="";
                                        for (int i = 0; i < in.length(); i++) {
                                            if(in.charAt(i)=='0'){
                                                onescomp+="1";
                                            }else if(in.charAt(i)=='1'){
                                                onescomp+="0";
                                            }else if(in.charAt(i)=='.'){
                                                onescomp+=".";
                                            }


                                        }
                                        SpannableStringBuilder mone = new SpannableStringBuilder("1s Complement\n"+onescomp);

                                        mone.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        one.setText(mone);

                                        String twoscomp="";
                                        char add = '1';
                                        for(int i=onescomp.length()-1; i>=0;i--){
                                            if(onescomp.charAt(i)=='.'){
                                                twoscomp+=".";
                                            }
                                            else if(onescomp.charAt(i)==add){
                                                if(add=='1'){
                                                    twoscomp+="0";
                                                }else {
                                                    twoscomp+="0";
                                                }
                                            }else{
                                                twoscomp+="1";
                                                add='0';
                                            }

                                        }
                                        twoscomp = reverse(twoscomp);
                                        SpannableStringBuilder mtwo = new SpannableStringBuilder("2s Complement\n"+twoscomp);

                                        mtwo.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        two.setText(mtwo);
                                        if(btd<=2147483647){
                                            in = decimalToBinary(btd,10);
                                            String binfirst = in.split("\\.")[0];
                                            while (binfirst.length()<32){
                                                binfirst = '0'+binfirst;
                                            }
                                            String finalsign = binfirst+"."+in.split("\\.")[1];
                                            SpannableStringBuilder sm = new SpannableStringBuilder("Sign Magnitude\n"+finalsign);

                                            sm.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                            signmtext.setText(sm);
                                            SpannableStringBuilder sone = new SpannableStringBuilder("Sign 1s Complement\n"+finalsign);

                                            sone.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                            sign1text.setText(sone);

                                            SpannableStringBuilder stwo = new SpannableStringBuilder("Sign 2s Complement\n"+finalsign);

                                            stwo.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                            sign2text.setText(stwo);
                                            int l = (int) Double.parseDouble(btds);
                                            String p =String.valueOf(l);
                                            double tenres=0.0;
                                            if(l==0){
                                                if(Double.parseDouble(btds)==0.0){
                                                    tenres=0.0;
                                                }else{
                                                    tenres = 1-Double.parseDouble(btds);
                                                }

                                            }else {
                                                tenres = Math.pow(10,p.length())-Double.parseDouble(btds);
                                            }

                                            SpannableStringBuilder ten = new SpannableStringBuilder("10s Complement\n"+BigDecimal.valueOf(tenres).toPlainString());

                                            ten.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            tens.setText(ten);
                                            if(Double.parseDouble(btds)==0.0){
                                                SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+"0");

                                                nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                nines.setText(nine);
                                            }else {
                                                String mn = BigDecimal.valueOf(Double.parseDouble(btds)).toPlainString();
                                                double z=0.0;
                                                if(mn.contains(".")){
                                                    String x = mn.split("\\.")[0];
                                                    String y = mn.split("\\.")[1];

                                                    if(x.equals("0")){
                                                        z = 1- Math.pow(10,-y.length())-Double.parseDouble(btds);
                                                    }else if(y.equals("0")) {
                                                        z = Math.pow(10,x.length())-1-Double.parseDouble(btds);
                                                    }else {
                                                        z = Math.pow(10,x.length())-Math.pow(10,-y.length())-Double.parseDouble(btds);
                                                    }
                                                }else{
                                                    if(mn.equals("0")){
                                                        z=0;
                                                    }else {
                                                        z = Math.pow(10,btds.length())-1-Double.parseDouble(btds);

                                                    }
                                                }
                                                SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+BigDecimal.valueOf(z).toPlainString());

                                                nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                                nines.setText(nine);

                                            }

                                        }else {
                                            SpannableStringBuilder same = new SpannableStringBuilder("For signed representation Value must be less than 2147483647");
                                            same.setSpan(bss, 0,60, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            signmtext.setText(same);
                                            sign1text.setText(same);
                                            sign2text.setText(same);
                                            SpannableStringBuilder wten = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                            wten.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            tens.setText(wten);
                                            SpannableStringBuilder wnine = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                            wnine.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            nines.setText(wnine);

                                        }
                                    }
                                }else {
                                    drin.setError("Binary number contain only 0 and 1");
                                }
                            }



                        }else if(value.equals(o)) {
                            if(in.contains("-")){
                                int count = 0;
                                for(int i =0;i<in.length();i++){
                                    if(in.charAt(i)=='-'){
                                        count++;
                                    }
                                }
                                if(count==1) {
                                    if (in.charAt(0) == '-'&& in.length()>1) {
                                        in = in.replace("-","");
                                        if(in.matches("-?\\d+(\\.\\d+)?")){
                                            if(in.contains("8")||in.contains("9")){
                                                drin.setError("Octal number contain number between 1 to 7");
                                            }else {
                                                String res = octaltoDecimal(in);
                                                SpannableStringBuilder md = new SpannableStringBuilder("Decimal\n"+"-"+res);

                                                StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);

                                                md.setSpan(bss, 0,7, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                decitext.setText(md);

                                                double oct = Double.parseDouble(res);
                                                String bin = decimalToBinary(oct,10);
                                                SpannableStringBuilder mb = new SpannableStringBuilder("Binary\n"+"-"+bin);

                                                mb.setSpan(bss, 0,6, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                binarytext.setText(mb);

                                                SpannableStringBuilder mo = new SpannableStringBuilder("Octal\n"+"-"+in);

                                                mo.setSpan(bss, 0,5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                octaltext.setText(mo);

                                                String hex = decimalToHexa(oct,10);
                                                SpannableStringBuilder mh = new SpannableStringBuilder("Hexadecimal\n"+"-"+hex);

                                                mh.setSpan(bss, 0,11, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                hextext.setText(mh);

                                                String onescomp="";
                                                for (int i = 0; i < bin.length(); i++) {
                                                    if(bin.charAt(i)=='0'){
                                                        onescomp+="1";
                                                    }else if(bin.charAt(i)=='1'){
                                                        onescomp+="0";
                                                    }else if(bin.charAt(i)=='.'){
                                                        onescomp+=".";
                                                    }


                                                }
                                                SpannableStringBuilder mone = new SpannableStringBuilder("1s Complement\n"+"-"+onescomp);


                                                mone.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                one.setText(mone);

                                                String twoscomp="";
                                                char add = '1';
                                                for(int i=onescomp.length()-1; i>=0;i--){
                                                    if(onescomp.charAt(i)=='.'){
                                                        twoscomp+=".";
                                                    }
                                                    else if(onescomp.charAt(i)==add){
                                                        if(add=='1'){
                                                            twoscomp+="0";
                                                        }else {
                                                            twoscomp+="0";
                                                        }
                                                    }else{
                                                        twoscomp+="1";
                                                        add='0';
                                                    }

                                                }
                                                twoscomp = reverse(twoscomp);
                                                SpannableStringBuilder mtwo = new SpannableStringBuilder("2s Complement\n"+"-"+twoscomp);

                                                mtwo.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                two.setText(mtwo);
                                                if(Double.parseDouble(res)<=2147483647){
                                                    String binfirst = bin.split("\\.")[0];
                                                    while (binfirst.length()<32){
                                                        binfirst = '0'+binfirst;
                                                    }
                                                    String finalsign = binfirst+"."+bin.split("\\.")[1];
                                                    finalsign = finalsign.replaceFirst("0","1");
                                                    SpannableStringBuilder sm = new SpannableStringBuilder("Sign Magnitude\n"+finalsign);

                                                    sm.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                                    signmtext.setText(sm);
                                                    String sonescomp="";
                                                    finalsign = finalsign.replaceFirst("1","0");
                                                    for (int i = 0; i < finalsign.length(); i++) {
                                                        if(finalsign.charAt(i)=='0'){
                                                            sonescomp+="1";
                                                        }else if(finalsign.charAt(i)=='1'){
                                                            sonescomp+="0";
                                                        }else if(finalsign.charAt(i)=='.'){
                                                            sonescomp+=".";
                                                        }

                                                    }
                                                    SpannableStringBuilder sone = new SpannableStringBuilder("Sign 1s Complement\n"+sonescomp);

                                                    sone.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                                    sign1text.setText(sone);
                                                    String stwoscomp="";

                                                    char ad = '1';
                                                    for(int i=sonescomp.length()-1; i>=0;i--){
                                                        if(sonescomp.charAt(i)=='.'){
                                                            stwoscomp+=".";
                                                        }
                                                        else if(sonescomp.charAt(i)==ad){
                                                            if(ad=='1'){
                                                                stwoscomp+="0";
                                                            }else {
                                                                stwoscomp+="0";
                                                            }
                                                        }else{
                                                            stwoscomp+="1";
                                                            ad='0';
                                                        }

                                                    }
                                                    stwoscomp = reverse(stwoscomp);

                                                    SpannableStringBuilder stwo = new SpannableStringBuilder("Sign 2s Complement\n"+stwoscomp);

                                                    stwo.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                                    sign2text.setText(stwo);
                                                    res = res.replace("-","");
                                                    int l = (int) Double.parseDouble(res);
                                                    String p =String.valueOf(l);
                                                    double tenres=0.0;
                                                    if(l==0){

                                                        if(Double.parseDouble(res)==0.0){
                                                            tenres=0.0;
                                                        }else{
                                                            tenres = 1-Double.parseDouble(res);
                                                        }
                                                    }else {
                                                        tenres = Math.pow(10,p.length())-Double.parseDouble("-"+res);
                                                    }

                                                    SpannableStringBuilder ten = new SpannableStringBuilder("10s Complement\n"+BigDecimal.valueOf(tenres).toPlainString());

                                                    ten.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                    tens.setText(ten);

                                                    if(Double.parseDouble(res)==0.0){
                                                        SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+"0");

                                                        nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                        nines.setText(nine);
                                                    }else {
                                                        String mn = BigDecimal.valueOf(Double.parseDouble(res)).toPlainString();
                                                        double z=0.0;
                                                        if(mn.contains(".")){
                                                            String x = mn.split("\\.")[0];
                                                            String y = mn.split("\\.")[1];

                                                            if(x.equals("0")){
                                                                z = 1- Math.pow(10,-y.length())+Double.parseDouble(res);
                                                            }else if(y.equals("0")) {
                                                                z = Math.pow(10,x.length())-1+Double.parseDouble(res);
                                                            }else {
                                                                z = Math.pow(10,x.length())-Math.pow(10,-y.length())+Double.parseDouble(res);
                                                            }
                                                        }else{
                                                            if(mn.equals("0")){
                                                                z=0;
                                                            }else {
                                                                z = Math.pow(10,res.length())-1+Double.parseDouble(res);

                                                            }
                                                        }
                                                        SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+BigDecimal.valueOf(z).toPlainString());

                                                        nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                                        nines.setText(nine);

                                                    }



                                                }else {
                                                    SpannableStringBuilder same = new SpannableStringBuilder("For signed representation Value must be less than 2147483647");
                                                    same.setSpan(bss, 0,60, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                    signmtext.setText(same);
                                                    sign1text.setText(same);
                                                    sign2text.setText(same);
                                                    SpannableStringBuilder wten = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                                    wten.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                    tens.setText(wten);
                                                    SpannableStringBuilder wnine = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                                    wnine.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                    nines.setText(wnine);

                                                }
                                            }
                                        }else {
                                            drin.setError("Octal number contain number between 1 to 7");
                                        }

                                    } else {

                                        drin.setError("Octal number contain number between 1 to 7");
                                    }
                                }else {
                                    drin.setError("Octal number contain number between 1 to 7");
                                }

                            }else{
                                if(in.matches("-?\\d+(\\.\\d+)?")){
                                    if(in.contains("8")||in.contains("9")){
                                        drin.setError("Octal number contain number between 1 to 7");
                                    }else {
                                        String res = octaltoDecimal(in);
                                        SpannableStringBuilder md = new SpannableStringBuilder("Decimal\n"+res);

                                        StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);

                                        md.setSpan(bss, 0,7, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        decitext.setText(md);

                                        double oct = Double.parseDouble(res);
                                        String bin = decimalToBinary(oct,10);
                                        SpannableStringBuilder mb = new SpannableStringBuilder("Binary\n"+bin);

                                        mb.setSpan(bss, 0,6, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        binarytext.setText(mb);

                                        SpannableStringBuilder mo = new SpannableStringBuilder("Octal\n"+in);

                                        mo.setSpan(bss, 0,5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        octaltext.setText(mo);

                                        String hex = decimalToHexa(oct,10);
                                        SpannableStringBuilder mh = new SpannableStringBuilder("Hexadecimal\n"+hex);

                                        mh.setSpan(bss, 0,11, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        hextext.setText(mh);

                                        String onescomp="";
                                        for (int i = 0; i < bin.length(); i++) {
                                            if(bin.charAt(i)=='0'){
                                                onescomp+="1";
                                            }else if(bin.charAt(i)=='1'){
                                                onescomp+="0";
                                            }else if(bin.charAt(i)=='.'){
                                                onescomp+=".";
                                            }


                                        }
                                        SpannableStringBuilder mone = new SpannableStringBuilder("1s Complement\n"+onescomp);


                                        mone.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        one.setText(mone);

                                        String twoscomp="";
                                        char add = '1';
                                        for(int i=onescomp.length()-1; i>=0;i--){
                                            if(onescomp.charAt(i)=='.'){
                                                twoscomp+=".";
                                            }
                                            else if(onescomp.charAt(i)==add){
                                                if(add=='1'){
                                                    twoscomp+="0";
                                                }else {
                                                    twoscomp+="0";
                                                }
                                            }else{
                                                twoscomp+="1";
                                                add='0';
                                            }

                                        }
                                        twoscomp = reverse(twoscomp);
                                        SpannableStringBuilder mtwo = new SpannableStringBuilder("2s Complement\n"+twoscomp);

                                        mtwo.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        two.setText(mtwo);
                                        if(Double.parseDouble(res)<=2147483647){
                                            String binfirst = bin.split("\\.")[0];
                                            while (binfirst.length()<32){
                                                binfirst = '0'+binfirst;
                                            }
                                            String finalsign = binfirst+"."+bin.split("\\.")[1];
                                            SpannableStringBuilder sm = new SpannableStringBuilder("Sign Magnitude\n"+finalsign);

                                            sm.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                            signmtext.setText(sm);
                                            SpannableStringBuilder sone = new SpannableStringBuilder("Sign 1s Complement\n"+finalsign);

                                            sone.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                            sign1text.setText(sone);

                                            SpannableStringBuilder stwo = new SpannableStringBuilder("Sign 2s Complement\n"+finalsign);

                                            stwo.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                            sign2text.setText(stwo);
                                            int l = (int) Double.parseDouble(res);
                                            String p =String.valueOf(l);
                                            double tenres=0.0;
                                            if(l==0){
                                                if(Double.parseDouble(res)==0.0){
                                                    tenres=0.0;
                                                }else{
                                                    tenres = 1-Double.parseDouble(res);
                                                }

                                            }else {
                                                tenres = Math.pow(10,p.length())-Double.parseDouble(res);
                                            }

                                            SpannableStringBuilder ten = new SpannableStringBuilder("10s Complement\n"+BigDecimal.valueOf(tenres).toPlainString());

                                            ten.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            tens.setText(ten);
                                            if(Double.parseDouble(res)==0.0){
                                                SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+"0");

                                                nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                nines.setText(nine);
                                            }else {
                                                String mn = BigDecimal.valueOf(Double.parseDouble(res)).toPlainString();
                                                double z=0.0;
                                                if(mn.contains(".")){
                                                    String x = mn.split("\\.")[0];
                                                    String y = mn.split("\\.")[1];

                                                    if(x.equals("0")){
                                                        z = 1- Math.pow(10,-y.length())-Double.parseDouble(res);
                                                    }else if(y.equals("0")) {
                                                        z = Math.pow(10,x.length())-1-Double.parseDouble(res);
                                                    }else {
                                                        z = Math.pow(10,x.length())-Math.pow(10,-y.length())-Double.parseDouble(res);
                                                    }
                                                }else{
                                                    if(mn.equals("0")){
                                                        z=0;
                                                    }else {
                                                        z = Math.pow(10,res.length())-1-Double.parseDouble(res);

                                                    }
                                                }
                                                SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+BigDecimal.valueOf(z).toPlainString());

                                                nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                                nines.setText(nine);

                                            }



                                        }else {
                                            SpannableStringBuilder same = new SpannableStringBuilder("For signed representation Value must be less than 2147483647");
                                            same.setSpan(bss, 0,60, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            signmtext.setText(same);
                                            sign1text.setText(same);
                                            sign2text.setText(same);
                                            SpannableStringBuilder wten = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                            wten.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            tens.setText(wten);
                                            SpannableStringBuilder wnine = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                            wnine.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            nines.setText(wnine);

                                        }



                                    }
                                }else {
                                    drin.setError("Octal number contain number between 1 to 7");
                                }
                            }

                        }else if(value.equals(h)) {
                            if(in.contains("-")){
                                int count = 0;
                                for(int i =0;i<in.length();i++){
                                    if(in.charAt(i)=='-'){
                                        count++;
                                    }
                                }
                                if(count==1) {
                                    if (in.charAt(0) == '-'&& in.length()>1) {
                                        in = in.replace("-","");
                                        if(in.matches("-?\\d+(\\.\\d+)?")){
                                            String hex = hexatoDecimal(in);
                                            double hd = Double.parseDouble(hex);
                                            SpannableStringBuilder md = new SpannableStringBuilder("Decimal\n"+"-"+hex);

                                            StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
                                            md.setSpan(bss, 0,7, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                            decitext.setText(md);

                                            SpannableStringBuilder mh = new SpannableStringBuilder("Hexadecimal\n"+"-"+in);


                                            mh.setSpan(bss, 0,11, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            hextext.setText(mh);

                                            String oct = decimalToOctal(hd,10);
                                            SpannableStringBuilder mo = new SpannableStringBuilder("Octal\n"+"-"+oct);

                                            mo.setSpan(bss, 0,5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            octaltext.setText(mo);

                                            String bin = decimalToBinary(hd,10);
                                            SpannableStringBuilder mb = new SpannableStringBuilder("Binary\n"+"-"+bin);


                                            mb.setSpan(bss, 0,6, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            binarytext.setText(mb);

                                            String onescomp="";
                                            for (int i = 0; i < bin.length(); i++) {
                                                if(bin.charAt(i)=='0'){
                                                    onescomp+="1";
                                                }else if(bin.charAt(i)=='1'){
                                                    onescomp+="0";
                                                }else if(bin.charAt(i)=='.'){
                                                    onescomp+=".";
                                                }


                                            }
                                            SpannableStringBuilder mone = new SpannableStringBuilder("1s Complement\n"+"-"+onescomp);


                                            mone.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            one.setText(mone);

                                            String twoscomp="";
                                            char add = '1';
                                            for(int i=onescomp.length()-1; i>=0;i--){
                                                if(onescomp.charAt(i)=='.'){
                                                    twoscomp+=".";
                                                }
                                                else if(onescomp.charAt(i)==add){
                                                    if(add=='1'){
                                                        twoscomp+="0";
                                                    }else {
                                                        twoscomp+="0";
                                                    }
                                                }else{
                                                    twoscomp+="1";
                                                    add='0';
                                                }

                                            }
                                            twoscomp = reverse(twoscomp);
                                            SpannableStringBuilder mtwo = new SpannableStringBuilder("2s Complement\n"+"-"+twoscomp);

                                            mtwo.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            two.setText(mtwo);
                                            if(Double.parseDouble(hex)<=2147483647){
                                                String binfirst = bin.split("\\.")[0];
                                                while (binfirst.length()<32){
                                                    binfirst = '0'+binfirst;
                                                }
                                                String finalsign = binfirst+"."+bin.split("\\.")[1];
                                                finalsign = finalsign.replaceFirst("0","1");
                                                SpannableStringBuilder sm = new SpannableStringBuilder("Sign Magnitude\n"+finalsign);

                                                sm.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                                signmtext.setText(sm);
                                                String sonescomp="";
                                                finalsign = finalsign.replaceFirst("1","0");
                                                for (int i = 0; i < finalsign.length(); i++) {
                                                    if(finalsign.charAt(i)=='0'){
                                                        sonescomp+="1";
                                                    }else if(finalsign.charAt(i)=='1'){
                                                        sonescomp+="0";
                                                    }else if(finalsign.charAt(i)=='.'){
                                                        sonescomp+=".";
                                                    }

                                                }
                                                SpannableStringBuilder sone = new SpannableStringBuilder("Sign 1s Complement\n"+sonescomp);

                                                sone.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                                sign1text.setText(sone);
                                                String stwoscomp="";

                                                char ad = '1';
                                                for(int i=sonescomp.length()-1; i>=0;i--){
                                                    if(sonescomp.charAt(i)=='.'){
                                                        stwoscomp+=".";
                                                    }
                                                    else if(sonescomp.charAt(i)==ad){
                                                        if(ad=='1'){
                                                            stwoscomp+="0";
                                                        }else {
                                                            stwoscomp+="0";
                                                        }
                                                    }else{
                                                        stwoscomp+="1";
                                                        ad='0';
                                                    }

                                                }
                                                stwoscomp = reverse(stwoscomp);

                                                SpannableStringBuilder stwo = new SpannableStringBuilder("Sign 2s Complement\n"+stwoscomp);

                                                stwo.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                                sign2text.setText(stwo);
                                                hex = hex.replace("-","");
                                                int l = (int) Double.parseDouble(hex);
                                                String p =String.valueOf(l);
                                                double tenres=0.0;
                                                if(l==0){

                                                    if(Double.parseDouble(hex)==0.0){
                                                        tenres=0.0;
                                                    }else{
                                                        tenres = 1-Double.parseDouble(hex);
                                                    }
                                                }else {
                                                    tenres = Math.pow(10,p.length())-Double.parseDouble("-"+hex);
                                                }

                                                SpannableStringBuilder ten = new SpannableStringBuilder("10s Complement\n"+BigDecimal.valueOf(tenres).toPlainString());

                                                ten.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                tens.setText(ten);
                                                if(Double.parseDouble(hex)==0.0){
                                                    SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+"0");

                                                    nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                    nines.setText(nine);
                                                }else {
                                                    String mn = BigDecimal.valueOf(Double.parseDouble(hex)).toPlainString();
                                                    double z=0.0;
                                                    if(mn.contains(".")){
                                                        String x = mn.split("\\.")[0];
                                                        String y = mn.split("\\.")[1];

                                                        if(x.equals("0")){
                                                            z = 1- Math.pow(10,-y.length())+Double.parseDouble(hex);
                                                        }else if(y.equals("0")) {
                                                            z = Math.pow(10,x.length())-1+Double.parseDouble(hex);
                                                        }else {
                                                            z = Math.pow(10,x.length())-Math.pow(10,-y.length())+Double.parseDouble(hex);
                                                        }
                                                    }else{
                                                        if(mn.equals("0")){
                                                            z=0;
                                                        }else {
                                                            z = Math.pow(10,hex.length())-1+Double.parseDouble(hex);

                                                        }
                                                    }
                                                    SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+BigDecimal.valueOf(z).toPlainString());

                                                    nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                                    nines.setText(nine);

                                                }



                                            }else {
                                                SpannableStringBuilder same = new SpannableStringBuilder("For signed representation Value must be less than 2147483647");
                                                same.setSpan(bss, 0,60, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                signmtext.setText(same);
                                                sign1text.setText(same);
                                                sign2text.setText(same);
                                                SpannableStringBuilder wten = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                                wten.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                tens.setText(wten);
                                                SpannableStringBuilder wnine = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                                wnine.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                nines.setText(wnine);

                                            }

                                        }else {
                                            boolean c = true;
                                            int co = 0;
                                            for(int j = 0;j<in.length();j++){
                                                if(in.charAt(j)=='.'){
                                                    co++;
                                                }
                                            }
                                            if(co>1||in.charAt(in.length()-1)=='.'||(in.length()==1&&in==".")){

                                                c = false;
                                            }
                                            for(int i=0;i<in.length();i++){
                                                if(in.charAt(i)=='A'||in.charAt(i)=='B'||in.charAt(i)=='C'||in.charAt(i)=='D'||in.charAt(i)=='E'||in.charAt(i)=='F'||in.charAt(i)=='.'||Character.isDigit(in.charAt(i))){

                                                }else {
                                                    c=false;
                                                }
                                            }
                                            if(c){
                                                String hex = hexatoDecimal(in);
                                                double hd = Double.valueOf(hex);
                                                SpannableStringBuilder md = new SpannableStringBuilder("Decimal\n"+"-"+hex);

                                                StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
                                                md.setSpan(bss, 0,7, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                                decitext.setText(md);

                                                SpannableStringBuilder mh = new SpannableStringBuilder("Hexadecimal\n"+"-"+in);


                                                mh.setSpan(bss, 0,11, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                hextext.setText(mh);

                                                String oct = decimalToOctal(hd,10);
                                                SpannableStringBuilder mo = new SpannableStringBuilder("Octal\n"+"-"+oct);

                                                mo.setSpan(bss, 0,5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                octaltext.setText(mo);

                                                String bin = decimalToBinary(hd,10);
                                                SpannableStringBuilder mb = new SpannableStringBuilder("Binary\n"+"-"+bin);


                                                mb.setSpan(bss, 0,6, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                binarytext.setText(mb);

                                                String onescomp="";
                                                for (int i = 0; i < bin.length(); i++) {
                                                    if(bin.charAt(i)=='0'){
                                                        onescomp+="1";
                                                    }else if(bin.charAt(i)=='1'){
                                                        onescomp+="0";
                                                    }else if(bin.charAt(i)=='.'){
                                                        onescomp+=".";
                                                    }


                                                }
                                                SpannableStringBuilder mone = new SpannableStringBuilder("1s Complement\n"+"-"+onescomp);


                                                mone.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                one.setText(mone);

                                                String twoscomp="";
                                                char add = '1';
                                                for(int i=onescomp.length()-1; i>=0;i--){
                                                    if(onescomp.charAt(i)=='.'){
                                                        twoscomp+=".";
                                                    }
                                                    else if(onescomp.charAt(i)==add){
                                                        if(add=='1'){
                                                            twoscomp+="0";
                                                        }else {
                                                            twoscomp+="0";
                                                        }
                                                    }else{
                                                        twoscomp+="1";
                                                        add='0';
                                                    }

                                                }
                                                twoscomp = reverse(twoscomp);
                                                SpannableStringBuilder mtwo = new SpannableStringBuilder("2s Complement\n"+"-"+twoscomp);

                                                mtwo.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                two.setText(mtwo);

                                                if(Double.parseDouble(hex)<=2147483647){
                                                    String binfirst = bin.split("\\.")[0];
                                                    while (binfirst.length()<32){
                                                        binfirst = '0'+binfirst;
                                                    }
                                                    String finalsign = binfirst+"."+bin.split("\\.")[1];
                                                    finalsign = finalsign.replaceFirst("0","1");
                                                    SpannableStringBuilder sm = new SpannableStringBuilder("Sign Magnitude\n"+finalsign);

                                                    sm.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                                    signmtext.setText(sm);
                                                    String sonescomp="";
                                                    finalsign = finalsign.replaceFirst("1","0");
                                                    for (int i = 0; i < finalsign.length(); i++) {
                                                        if(finalsign.charAt(i)=='0'){
                                                            sonescomp+="1";
                                                        }else if(finalsign.charAt(i)=='1'){
                                                            sonescomp+="0";
                                                        }else if(finalsign.charAt(i)=='.'){
                                                            sonescomp+=".";
                                                        }

                                                    }
                                                    SpannableStringBuilder sone = new SpannableStringBuilder("Sign 1s Complement\n"+sonescomp);

                                                    sone.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                                    sign1text.setText(sone);
                                                    String stwoscomp="";

                                                    char ad = '1';
                                                    for(int i=sonescomp.length()-1; i>=0;i--){
                                                        if(sonescomp.charAt(i)=='.'){
                                                            stwoscomp+=".";
                                                        }
                                                        else if(sonescomp.charAt(i)==ad){
                                                            if(ad=='1'){
                                                                stwoscomp+="0";
                                                            }else {
                                                                stwoscomp+="0";
                                                            }
                                                        }else{
                                                            stwoscomp+="1";
                                                            ad='0';
                                                        }

                                                    }
                                                    stwoscomp = reverse(stwoscomp);

                                                    SpannableStringBuilder stwo = new SpannableStringBuilder("Sign 2s Complement\n"+stwoscomp);

                                                    stwo.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                                    sign2text.setText(stwo);
                                                    hex = hex.replace("-","");
                                                    int l = (int) Double.parseDouble(hex);
                                                    String p =String.valueOf(l);
                                                    double tenres=0.0;
                                                    if(l==0){

                                                        if(Double.parseDouble(hex)==0.0){
                                                            tenres=0.0;
                                                        }else{
                                                            tenres = 1-Double.parseDouble(hex);
                                                        }
                                                    }else {
                                                        tenres = Math.pow(10,p.length())-Double.parseDouble("-"+hex);
                                                    }

                                                    SpannableStringBuilder ten = new SpannableStringBuilder("10s Complement\n"+BigDecimal.valueOf(tenres).toPlainString());

                                                    ten.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                    tens.setText(ten);
                                                    if(Double.parseDouble(hex)==0.0){
                                                        SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+"0");

                                                        nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                        nines.setText(nine);
                                                    }else {
                                                        String mn = BigDecimal.valueOf(Double.parseDouble(hex)).toPlainString();
                                                        double z=0.0;
                                                        if(mn.contains(".")){
                                                            String x = mn.split("\\.")[0];
                                                            String y = mn.split("\\.")[1];

                                                            if(x.equals("0")){
                                                                z = 1- Math.pow(10,-y.length())+Double.parseDouble(hex);
                                                            }else if(y.equals("0")) {
                                                                z = Math.pow(10,x.length())-1+Double.parseDouble(hex);
                                                            }else {
                                                                z = Math.pow(10,x.length())-Math.pow(10,-y.length())+Double.parseDouble(hex);
                                                            }
                                                        }else{
                                                            if(mn.equals("0")){
                                                                z=0;
                                                            }else {
                                                                z = Math.pow(10,hex.length())-1+Double.parseDouble(hex);

                                                            }
                                                        }
                                                        SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+BigDecimal.valueOf(z).toPlainString());

                                                        nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                                        nines.setText(nine);

                                                    }



                                                }else {
                                                    SpannableStringBuilder same = new SpannableStringBuilder("For signed representation Value must be less than 2147483647");
                                                    same.setSpan(bss, 0,60, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                    signmtext.setText(same);
                                                    sign1text.setText(same);
                                                    sign2text.setText(same);
                                                    SpannableStringBuilder wten = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                                    wten.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                    tens.setText(wten);
                                                    SpannableStringBuilder wnine = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                                    wnine.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                    nines.setText(wnine);

                                                }
                                            }
                                            else {
                                                drin.setError("Hexadecimal contains only 1-9 and ABCDEF character");
                                            }
                                        }

                                    } else {

                                        drin.setError("Hexadecimal contains only 1-9 and ABCDEF character");
                                    }
                                }else {
                                    drin.setError("Hexadecimal contains only 1-9 and ABCDEF character");
                                }
                            }else{

                                if(in.matches("-?\\d+(\\.\\d+)?")){
                                    String hex = hexatoDecimal(in);
                                    double hd = Double.parseDouble(hex);
                                    SpannableStringBuilder md = new SpannableStringBuilder("Decimal\n"+hex);

                                    StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
                                    md.setSpan(bss, 0,7, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                    decitext.setText(md);

                                    SpannableStringBuilder mh = new SpannableStringBuilder("Hexadecimal\n"+in);


                                    mh.setSpan(bss, 0,11, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                    hextext.setText(mh);

                                    String oct = decimalToOctal(hd,10);
                                    SpannableStringBuilder mo = new SpannableStringBuilder("Octal\n"+oct);

                                    mo.setSpan(bss, 0,5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                    octaltext.setText(mo);

                                    String bin = decimalToBinary(hd,10);
                                    SpannableStringBuilder mb = new SpannableStringBuilder("Binary\n"+bin);


                                    mb.setSpan(bss, 0,6, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                    binarytext.setText(mb);

                                    String onescomp="";
                                    for (int i = 0; i < bin.length(); i++) {
                                        if(bin.charAt(i)=='0'){
                                            onescomp+="1";
                                        }else if(bin.charAt(i)=='1'){
                                            onescomp+="0";
                                        }else if(bin.charAt(i)=='.'){
                                            onescomp+=".";
                                        }


                                    }
                                    SpannableStringBuilder mone = new SpannableStringBuilder("1s Complement\n"+onescomp);


                                    mone.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                    one.setText(mone);

                                    String twoscomp="";
                                    char add = '1';
                                    for(int i=onescomp.length()-1; i>=0;i--){
                                        if(onescomp.charAt(i)=='.'){
                                            twoscomp+=".";
                                        }
                                        else if(onescomp.charAt(i)==add){
                                            if(add=='1'){
                                                twoscomp+="0";
                                            }else {
                                                twoscomp+="0";
                                            }
                                        }else{
                                            twoscomp+="1";
                                            add='0';
                                        }

                                    }
                                    twoscomp = reverse(twoscomp);
                                    SpannableStringBuilder mtwo = new SpannableStringBuilder("2s Complement\n"+twoscomp);

                                    mtwo.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                    two.setText(mtwo);
                                    if(Double.parseDouble(hex)<=2147483647){
                                        String binfirst = bin.split("\\.")[0];
                                        while (binfirst.length()<32){
                                            binfirst = '0'+binfirst;
                                        }
                                        String finalsign = binfirst+"."+bin.split("\\.")[1];
                                        SpannableStringBuilder sm = new SpannableStringBuilder("Sign Magnitude\n"+finalsign);

                                        sm.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                        signmtext.setText(sm);
                                        SpannableStringBuilder sone = new SpannableStringBuilder("Sign 1s Complement\n"+finalsign);

                                        sone.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                        sign1text.setText(sone);

                                        SpannableStringBuilder stwo = new SpannableStringBuilder("Sign 2s Complement\n"+finalsign);

                                        stwo.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                        sign2text.setText(stwo);
                                        int l = (int) Double.parseDouble(hex);
                                        String p =String.valueOf(l);
                                        double tenres=0.0;
                                        if(l==0){
                                            if(Double.parseDouble(hex)==0.0){
                                                tenres=0.0;
                                            }else{
                                                tenres = 1-Double.parseDouble(hex);
                                            }

                                        }else {
                                            tenres = Math.pow(10,p.length())-Double.parseDouble(hex);
                                        }

                                        SpannableStringBuilder ten = new SpannableStringBuilder("10s Complement\n"+BigDecimal.valueOf(tenres).toPlainString());

                                        ten.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        tens.setText(ten);
                                        if(Double.parseDouble(hex)==0.0){
                                            SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+"0");

                                            nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            nines.setText(nine);
                                        }else {
                                            String mn = BigDecimal.valueOf(Double.parseDouble(hex)).toPlainString();
                                            double z=0.0;
                                            if(mn.contains(".")){
                                                String x = mn.split("\\.")[0];
                                                String y = mn.split("\\.")[1];

                                                if(x.equals("0")){
                                                    z = 1- Math.pow(10,-y.length())-Double.parseDouble(hex);
                                                }else if(y.equals("0")) {
                                                    z = Math.pow(10,x.length())-1-Double.parseDouble(hex);
                                                }else {
                                                    z = Math.pow(10,x.length())-Math.pow(10,-y.length())-Double.parseDouble(hex);
                                                }
                                            }else{
                                                if(mn.equals("0")){
                                                    z=0;
                                                }else {
                                                    z = Math.pow(10,hex.length())-1-Double.parseDouble(hex);

                                                }
                                            }
                                            SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+BigDecimal.valueOf(z).toPlainString());

                                            nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                            nines.setText(nine);

                                        }



                                    }else {
                                        SpannableStringBuilder same = new SpannableStringBuilder("For signed representation Value must be less than 2147483647");
                                        same.setSpan(bss, 0,60, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        signmtext.setText(same);
                                        sign1text.setText(same);
                                        sign2text.setText(same);
                                        SpannableStringBuilder wten = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                        wten.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        tens.setText(wten);
                                        SpannableStringBuilder wnine = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                        wnine.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        nines.setText(wnine);

                                    }
                                }else{
                                    boolean c = true;
                                    int count = 0;
                                    for(int j = 0;j<in.length();j++){
                                        if(in.charAt(j)=='.'){
                                            count++;
                                        }
                                    }
                                    if(count>1||in.charAt(in.length()-1)=='.'||(in.length()==1&&in==".")){

                                        c = false;
                                    }

                                    for(int i=0;i<in.length();i++){
                                        if(in.charAt(i)=='A'||in.charAt(i)=='B'||in.charAt(i)=='C'||in.charAt(i)=='D'||in.charAt(i)=='E'||in.charAt(i)=='F'||in.charAt(i)=='.'||Character.isDigit(in.charAt(i))){

                                        }else {
                                            c=false;
                                        }
                                    }
                                    if(c){
                                        String hex = hexatoDecimal(in);
                                        double hd = Double.parseDouble(hex);
                                        SpannableStringBuilder md = new SpannableStringBuilder("Decimal\n"+hex);

                                        StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
                                        md.setSpan(bss, 0,7, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                        decitext.setText(md);

                                        SpannableStringBuilder mh = new SpannableStringBuilder("Hexadecimal\n"+in);


                                        mh.setSpan(bss, 0,11, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        hextext.setText(mh);

                                        String oct = decimalToOctal(hd,10);
                                        SpannableStringBuilder mo = new SpannableStringBuilder("Octal\n"+oct);

                                        mo.setSpan(bss, 0,5, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        octaltext.setText(mo);

                                        String bin = decimalToBinary(hd,10);
                                        SpannableStringBuilder mb = new SpannableStringBuilder("Binary\n"+bin);


                                        mb.setSpan(bss, 0,6, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        binarytext.setText(mb);

                                        String onescomp="";
                                        for (int i = 0; i < bin.length(); i++) {
                                            if(bin.charAt(i)=='0'){
                                                onescomp+="1";
                                            }else if(bin.charAt(i)=='1'){
                                                onescomp+="0";
                                            }else if(bin.charAt(i)=='.'){
                                                onescomp+=".";
                                            }


                                        }
                                        SpannableStringBuilder mone = new SpannableStringBuilder("1s Complement\n"+onescomp);


                                        mone.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        one.setText(mone);

                                        String twoscomp="";
                                        char add = '1';
                                        for(int i=onescomp.length()-1; i>=0;i--){
                                            if(onescomp.charAt(i)=='.'){
                                                twoscomp+=".";
                                            }
                                            else if(onescomp.charAt(i)==add){
                                                if(add=='1'){
                                                    twoscomp+="0";
                                                }else {
                                                    twoscomp+="0";
                                                }
                                            }else{
                                                twoscomp+="1";
                                                add='0';
                                            }

                                        }
                                        twoscomp = reverse(twoscomp);
                                        SpannableStringBuilder mtwo = new SpannableStringBuilder("2s Complement\n"+twoscomp);

                                        mtwo.setSpan(bss, 0,13, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                        two.setText(mtwo);

                                        if(Double.parseDouble(hex)<=2147483647){
                                            String binfirst = bin.split("\\.")[0];
                                            while (binfirst.length()<32){
                                                binfirst = '0'+binfirst;
                                            }
                                            String finalsign = binfirst+"."+bin.split("\\.")[1];
                                            SpannableStringBuilder sm = new SpannableStringBuilder("Sign Magnitude\n"+finalsign);

                                            sm.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                            signmtext.setText(sm);
                                            SpannableStringBuilder sone = new SpannableStringBuilder("Sign 1s Complement\n"+finalsign);

                                            sone.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                            sign1text.setText(sone);

                                            SpannableStringBuilder stwo = new SpannableStringBuilder("Sign 2s Complement\n"+finalsign);

                                            stwo.setSpan(bss, 0,18, Spannable.SPAN_INCLUSIVE_INCLUSIVE);


                                            sign2text.setText(stwo);
                                            int l = (int) Double.parseDouble(hex);
                                            String p =String.valueOf(l);
                                            double tenres=0.0;
                                            if(l==0){
                                                if(Double.parseDouble(hex)==0.0){
                                                    tenres=0.0;
                                                }else{
                                                    tenres = 1-Double.parseDouble(hex);
                                                }

                                            }else {
                                                tenres = Math.pow(10,p.length())-Double.parseDouble(hex);
                                            }

                                            SpannableStringBuilder ten = new SpannableStringBuilder("10s Complement\n"+BigDecimal.valueOf(tenres).toPlainString());

                                            ten.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            tens.setText(ten);
                                            if(Double.parseDouble(hex)==0.0){
                                                SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+"0");

                                                nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                                nines.setText(nine);
                                            }else {
                                                String mn = BigDecimal.valueOf(Double.parseDouble(hex)).toPlainString();
                                                double z=0.0;
                                                if(mn.contains(".")){
                                                    String x = mn.split("\\.")[0];
                                                    String y = mn.split("\\.")[1];

                                                    if(x.equals("0")){
                                                        z = 1- Math.pow(10,-y.length())-Double.parseDouble(hex);
                                                    }else if(y.equals("0")) {
                                                        z = Math.pow(10,x.length())-1-Double.parseDouble(hex);
                                                    }else {
                                                        z = Math.pow(10,x.length())-Math.pow(10,-y.length())-Double.parseDouble(hex);
                                                    }
                                                }else{
                                                    if(mn.equals("0")){
                                                        z=0;
                                                    }else {
                                                        z = Math.pow(10,hex.length())-Double.parseDouble(hex);

                                                    }
                                                }
                                                SpannableStringBuilder nine = new SpannableStringBuilder("9s Complement\n"+BigDecimal.valueOf(z).toPlainString());

                                                nine.setSpan(bss, 0,14, Spannable.SPAN_INCLUSIVE_INCLUSIVE);

                                                nines.setText(nine);

                                            }

                                        }else {
                                            SpannableStringBuilder same = new SpannableStringBuilder("For signed representation Value must be less than 2147483647");
                                            same.setSpan(bss, 0,60, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            signmtext.setText(same);
                                            sign1text.setText(same);
                                            sign2text.setText(same);
                                            SpannableStringBuilder wten = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                            wten.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            tens.setText(wten);
                                            SpannableStringBuilder wnine = new SpannableStringBuilder("Decimal Value must be less than 2147483647");
                                            wnine.setSpan(bss, 0,42, Spannable.SPAN_INCLUSIVE_INCLUSIVE);
                                            nines.setText(wnine);

                                        }
                                    }
                                    else {
                                        drin.setError("Hexadecimal contains only 1-9 and ABCDEF character");
                                    }
                                }
                            }



                        }
                    }
                    String right = decitext.getText().toString();
                    if(right.equals("Decimal")){

                    }else{
                        if(Double.parseDouble(right.replace("Decimal\n", ""))>2147483647||Double.parseDouble(right.replace("Decimal\n", ""))<-2147483647){
                            int duration = Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(getApplicationContext(), "Max value allowed is 214 Crore", duration);
                            toast.show();

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


