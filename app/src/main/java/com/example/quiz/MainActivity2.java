package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    TextView qn,score;
    EditText ans;
    Button submit;
    ConstraintLayout constraintLayout;
    int scr=0,pr=0,tq=-10;
    long st=0,end=0,time=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


            submit = findViewById(R.id.submit);

            submit.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {
                        tq--;
                        Random random = new Random();
                        int a = random.nextInt(100);
                        int b = random.nextInt(100);
                        int sum = a + b;
                        qn = findViewById(R.id.qn);
                        qn.setText("" + a + " + " + b + " = ...");
                        if(tq==0) {
                            end=System.currentTimeMillis();
                            time=(end-st)/1000;
                            if(time<=14)
                                qn.setText("Level cracked");
                            else
                                qn.setText("Time taken : " + time + "\n Enter the no. of Question to play again:");
                        }
                        ans = findViewById(R.id.ans);
                        int user_ans = Integer.parseInt(ans.getText().toString());
                        if(tq<0) {
                            scr=0;
                            tq = user_ans;
                            st=System.currentTimeMillis();
                        }
                    constraintLayout = findViewById(R.id.ly);
                        ans.setText("");
                        if (user_ans == pr) {
                            scr++;
                            score.setText("Score : " + scr);
                            constraintLayout.setBackgroundResource(R.color.green);
                        }
                        else
                            constraintLayout.setBackgroundResource(R.color.red);

                    score = findViewById(R.id.score);
                        //scr++;
                        //score.setText("Score : "+scr);
                        pr = sum;


                }
            });


    }

}