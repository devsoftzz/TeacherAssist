package com.devsoftzz.teacherassist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class password extends AppCompatActivity {

    private CardView mAttendance,mMarks,mTrakking,mSAS,mSamarth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        mAttendance = findViewById(R.id.Online);
        mAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(password.this,setValues.class);
                    intent.putExtra("Title","ઓનલાઇન હાજરી");
                    intent.putExtra("Type","Attendance");
                    startActivity(intent);
            }
        });

        mMarks = findViewById(R.id.Exam);
        mMarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(password.this,setValues.class);
                    intent.putExtra("Title","પરીક્ષા માર્ક એન્ટ્રી");
                    intent.putExtra("Type","Marks");
                    startActivity(intent);
            }
        });

        mTrakking = findViewById(R.id.DISE);
        mTrakking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(password.this,setValues.class);
                    intent.putExtra("Title","આધાર DISE Child ટ્રેક્કીગ");
                    intent.putExtra("Type","Trakking");
                    startActivity(intent);
            }
        });

        mSAS = findViewById(R.id.SASG);
        mSAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(password.this,setValues.class);
                    intent.putExtra("Title","SAS Gujarat");
                    intent.putExtra("Type","SAS");
                    startActivity(intent);
            }
        });

        mSamarth = findViewById(R.id.SAMARTH2);
        mSamarth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(password.this,samarth_setValue.class);
                    intent.putExtra("Title","Samarth 2");
                    intent.putExtra("Type","Samarth");
                    startActivity(intent);
            }
        });
    }
}
