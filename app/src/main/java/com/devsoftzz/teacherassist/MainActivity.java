package com.devsoftzz.teacherassist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout mAttendance,mMarks,mTrakking,mSAS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final SharedPreferences mStorage = getSharedPreferences("values",MODE_PRIVATE);

        mAttendance = findViewById(R.id.attendance);
        mAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStorage.getBoolean("Attendance",false)){
                    Intent intent = new Intent(MainActivity.this,WebPage.class);
                    intent.putExtra("Type","Attendance");
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this,setValues.class);
                    intent.putExtra("Title","ઓનલાઇન હાજરી");
                    intent.putExtra("Type","Attendance");
                    startActivity(intent);
                }
            }
        });

        mMarks = findViewById(R.id.marks);
        mMarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStorage.getBoolean("Marks",false)){
                    Intent intent = new Intent(MainActivity.this,WebPage.class);
                    intent.putExtra("Type","Marks");
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this,setValues.class);
                    intent.putExtra("Title","પરીક્ષા માર્ક એન્ટ્રી");
                    intent.putExtra("Type","Marks");
                    startActivity(intent);
                }
            }
        });

        mTrakking = findViewById(R.id.Trakking);
        mTrakking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStorage.getBoolean("Trakking",false)){
                    Intent intent = new Intent(MainActivity.this,WebPage.class);
                    intent.putExtra("Type","Trakking");
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this,setValues.class);
                    intent.putExtra("Title","આધાર DISE Child ટ્રેક્કીગ");
                    intent.putExtra("Type","Trakking");
                    startActivity(intent);
                }
            }
        });

        mSAS = findViewById(R.id.SAS);
        mSAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStorage.getBoolean("SAS",false)){
                    Intent intent = new Intent(MainActivity.this,WebPage.class);
                    intent.putExtra("Type","SAS");
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this,setValues.class);
                    intent.putExtra("Title","SAS Gujarat");
                    intent.putExtra("Type","SAS");
                    startActivity(intent);
                }
            }
        });

    }
}
