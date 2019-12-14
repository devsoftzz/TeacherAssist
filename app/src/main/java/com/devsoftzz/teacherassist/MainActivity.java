package com.devsoftzz.teacherassist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout mAttendance,mMarks,mTrakking,mSAS,mDigital,mSamarth;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SharedPreferences mStorage = getSharedPreferences("values",MODE_PRIVATE);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

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

        mDigital = findViewById(R.id.digital);
        mDigital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStorage.getBoolean("Digital",false)){
                    Intent intent = new Intent(MainActivity.this,WebPage.class);
                    intent.putExtra("Type","Digital");
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this,setValues.class);
                    intent.putExtra("Title","Digital Gujarat");
                    intent.putExtra("Type","Digital");
                    startActivity(intent);
                }
            }
        });

        mSamarth = findViewById(R.id.samarth);
        mSamarth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStorage.getBoolean("Samarth",false)){
                    Intent intent = new Intent(MainActivity.this,WebPage.class);
                    intent.putExtra("Type","Samarth");
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(MainActivity.this,samarth_setValue.class);
                    intent.putExtra("Title","Samarth 2");
                    intent.putExtra("Type","Samarth");
                    startActivity(intent);
                }
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.chane_pass) {
            startActivity(new Intent(MainActivity.this,password.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
