package com.devsoftzz.teacherassist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class setValues extends AppCompatActivity {

    private ConstraintLayout mBack;
    private TextView mTitle;
    private String title,type;
    private Button mSet;
    private TextInputLayout mUser,mPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_values);

        mBack = findViewById(R.id.back);
        mTitle = findViewById(R.id.title);
        mSet = findViewById(R.id.set);
        mUser = findViewById(R.id.username);
        mPass = findViewById(R.id.password);

        SharedPreferences mStorage = getSharedPreferences("values",MODE_PRIVATE);
        final SharedPreferences.Editor editor = mStorage.edit();
        final Intent intent = new Intent(setValues.this,WebPage.class);

        title = getIntent().getStringExtra("Title");
        type = getIntent().getStringExtra("Type");
        mTitle.setText(title);
        switch (type){
            case "Attendance":
                mBack.setBackgroundColor(Color.rgb(255,236,1));
                break;
            case "Marks":
                mBack.setBackgroundColor(Color.rgb(0, 83, 173));
                break;
            case "Trakking":
                mBack.setBackgroundColor(Color.rgb(161, 158, 205));
                break;
            case "SAS":
                mBack.setBackgroundColor(Color.rgb(255, 109, 49));
                break;
        }

        mSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (type){
                    case "Attendance":
                        editor.putBoolean("Attendance",true);
                        editor.putString("Attendance_User",mUser.getEditText().getText().toString());
                        editor.putString("Attendance_Pass",mPass.getEditText().getText().toString());
                        editor.commit();
                        intent.putExtra("Type","Attendance");
                        startActivity(intent);
                        finish();
                        break;
                    case "Marks":
                        editor.putBoolean("Marks",true);
                        editor.putString("Marks_User",mUser.getEditText().getText().toString());
                        editor.putString("Marks_Pass",mPass.getEditText().getText().toString());
                        editor.commit();
                        intent.putExtra("Type","Marks");
                        startActivity(intent);
                        finish();
                        break;
                    case "Trakking":
                        editor.putBoolean("Trakking",true);
                        editor.putString("Trakking_User",mUser.getEditText().getText().toString());
                        editor.putString("Trakking_Pass",mPass.getEditText().getText().toString());
                        editor.commit();
                        intent.putExtra("Type","Trakking");
                        startActivity(intent);
                        finish();
                        break;
                    case "SAS":
                        editor.putBoolean("SAS",true);
                        editor.putString("SAS_User",mUser.getEditText().getText().toString());
                        editor.putString("SAS_Pass",mPass.getEditText().getText().toString());
                        editor.commit();
                        intent.putExtra("Type","SAS");
                        startActivity(intent);
                        finish();
                        break;
                }
            }
        });
    }
}
