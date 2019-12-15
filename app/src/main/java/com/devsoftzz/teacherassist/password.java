package com.devsoftzz.teacherassist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class password extends AppCompatActivity {

    private CardView mAttendance,mMarks,mTrakking,mSAS,mSamarth;
    private Intent PasswordIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        PasswordIntent = new Intent(password.this,setValues.class);

        mAttendance = findViewById(R.id.Online);
        mAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSetValue("ઓનલાઇન હાજરી","Attendance");
            }
        });

        mMarks = findViewById(R.id.Exam);
        mMarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSetValue("પરીક્ષા માર્ક એન્ટ્રી","Marks");
            }
        });

        mTrakking = findViewById(R.id.DISE);
        mTrakking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSetValue("આધાર DISE Child ટ્રેક્કીગ","Trakking");
            }
        });

        mSAS = findViewById(R.id.SASG);
        mSAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSetValue("SAS Gujarat","SAS");
            }
        });

        mSamarth = findViewById(R.id.SAMARTH2);
        mSamarth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(password.this,samarth_setValue.class);
                intent.putExtra("Title","Samarth II");
                startActivity(intent);
                finish();
            }
        });
    }

    public void openSetValue(String Title, String Type){
        PasswordIntent.putExtra("Title",Title);
        PasswordIntent.putExtra("Type",Type);
        startActivity(PasswordIntent);
        finish();
    }

}
