package com.calculator.supercalculator10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;
import java.util.List;

public class Equations extends AppCompatActivity {

    EditText a,b,c,a1,b1,c1,d;
    TextView roots;
    Double qx2,qx,q,res3,res4,res5,constant1, constant,cx3,cx2,cx,determinant,l,imgres;
    String res1, res2,e;
    AdView ad;

    public void normal(View view) {
        Intent normal = new Intent(this,MainActivity.class);
        startActivity(normal);
    }
    public void scientific(View View) {
        Intent scientific = new Intent(this, scientific.class);
        startActivity(scientific);
    }

    public void dr(View view) {
        Intent dr = new Intent(this,dr.class);
        startActivity(dr);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equations);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        ad = findViewById(R.id.AdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        ad.loadAd(adRequest);


        final Button button65 = findViewById(R.id.button65);
        button65.setOnClickListener(new View.OnClickListener(){
           public void onClick(View v){
            YoYo.with(Techniques.ZoomIn)
                    .duration(500)
                    .repeat(0)
                    .playOn(button65);
            }
        });
        final Button button66 = findViewById(R.id.button66);
        button66.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                YoYo.with(Techniques.ZoomIn)
                        .duration(500)
                        .repeat(0)
                        .playOn(button66);
            }
        });
        a = (EditText) findViewById(R.id.qx2);
        b = (EditText) findViewById(R.id.qx);
        c = (EditText) findViewById(R.id.q);
        a1 = (EditText)findViewById(R.id.cx3);
        b1 = (EditText)findViewById(R.id.cx2);
        c1 = (EditText)findViewById(R.id.cx);
        d = (EditText) findViewById(R.id.c);
        roots = findViewById(R.id.textView6);

        button65.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( a.length()==0)
                { a.setError( "Required!" );
                } else if (b.length()==0){
                    b.setError( "Required!" );
                } else if (c.length()==0){
                    c.setError( "Required!" );
                }else{
                    qx2 = Double.parseDouble(a.getText().toString());
                    qx = Double.parseDouble(b.getText().toString());
                    q = Double.parseDouble(c.getText().toString());
                    determinant = qx*qx - 4 * qx2*q;
                    if(determinant>=0){
                        res1 = Double.toString((-qx + Math.sqrt(determinant))/(2*qx2));
                        res2 = Double.toString((-qx - Math.sqrt(determinant))/(2*qx2));
                        String rreal = "Roots are" + " " +  res1 + " and " + res2;
                        roots.setText(rreal);
                    }
                    else{
                        res1 = Double.toString(-qx/(2*qx2));
                        res2 = Double.toString(Math.sqrt(-determinant)/(2*qx2));
                        String rimag= res1+" + "+res2+"i";
                        String rreal = res1+" - "+ res2+"i";
                        String r = rimag+ " and "+ rreal;
                        roots.setText(r);
                    }
                }

            }
        });
        button66.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( a1.length()==0)
                { a1.setError( "Required!" );
                } else if (b1.length()==0){
                    b1.setError( "Required!" );
                } else if (c1.length()==0){
                    c1.setError( "Required!" );
                }else if (d.length()==0) {
                    d.setError("Required!");
                }else{
                    cx3 = Double.parseDouble(a1.getText().toString());
                    cx2 = Double.parseDouble(b1.getText().toString());
                    cx =Double.parseDouble(c1.getText().toString());
                    constant = Double.parseDouble(d.getText().toString());
                    constant1 = Math.abs(constant);
                    List<Double> list=new ArrayList<Double>();
                    List<String> rootlist=new ArrayList<String>();
                    for(double i =1; i<constant1+1;i++){
                        if (constant1%i==0){
                            list.add(i);
                            list.add(-i);
                        }
                    }
                    for(double i:list){
                        l =i;
                        if((cx3*l*l*l+cx2*l*l+cx*l+constant)!=0){
                            ;
                        }else {
                            String i1 = String.valueOf(l);
                            rootlist.add(i1);
                        }
                    }
                    if (rootlist.size()==1){
                        e = rootlist.get(0);
                        double e1 = Double.parseDouble(e);
                        res3 = -(cx2+cx3*e1)/(2*cx3);
                        res4 = cx2*cx2-4*cx3*cx-2*cx3*e1*cx2-3*cx3*cx3*e1*e1;
                        res5 = Math.abs(res4);
                        imgres = (Math.sqrt(res5))/(2*cx3);
                        String rlast = e +" , "+ res3.toString()+ "+" + "("+imgres.toString()+"i"+")"+" , "+res3.toString()+"-"+"("+imgres.toString()+"i"+")";
                        roots.setText(rlast);
                    }
                    else if(rootlist.size()==0) {
                       roots.setText("Enter correct equation or No roots");
                    }else{
                        String rlast = rootlist.get(0)+" , "+rootlist.get(1)+" , "+ rootlist.get(2);
                        roots.setText(rlast);
                    }
                }

            }
        });
    }
}