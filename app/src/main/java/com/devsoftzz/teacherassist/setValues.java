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
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class setValues extends AppCompatActivity {

    private ConstraintLayout mBack;
    private TextView mTitle;
    private String title,type;
    private Button mSet;
    private TextInputLayout mUser,mPass;
    private SharedPreferences mStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_values);

        mBack = findViewById(R.id.back);
        mTitle = findViewById(R.id.title);
        mSet = findViewById(R.id.set);
        mUser = findViewById(R.id.username);
        mPass = findViewById(R.id.password);
        mStorage = getSharedPreferences("values",MODE_PRIVATE);
        final SharedPreferences.Editor editor = mStorage.edit();
        final Intent intent = new Intent(setValues.this,WebPage.class);
        title = getIntent().getStringExtra("Title");
        type = getIntent().getStringExtra("Type");

        initialSetup();
        mSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user,pass;
                user = mUser.getEditText().getText().toString().trim();
                pass = mPass.getEditText().getText().toString().trim();
                if(user.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter Username",Toast.LENGTH_LONG).show();
                }else if(pass.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_LONG).show();
                }else {
                    switch (type) {
                        case "Attendance":
                            editor.putBoolean("Attendance", true);
                            editor.putString("Attendance_User", mUser.getEditText().getText().toString());
                            editor.putString("Attendance_Pass", mPass.getEditText().getText().toString());
                            editor.commit();
                            intent.putExtra("Type", "Attendance");
                            startActivity(intent);
                            finish();
                            break;
                        case "Marks":
                            editor.putBoolean("Marks", true);
                            editor.putString("Marks_User", mUser.getEditText().getText().toString());
                            editor.putString("Marks_Pass", mPass.getEditText().getText().toString());
                            editor.commit();
                            intent.putExtra("Type", "Marks");
                            startActivity(intent);
                            finish();
                            break;
                        case "Trakking":
                            editor.putBoolean("Trakking", true);
                            editor.putString("Trakking_User", mUser.getEditText().getText().toString());
                            editor.putString("Trakking_Pass", mPass.getEditText().getText().toString());
                            editor.commit();
                            intent.putExtra("Type", "Trakking");
                            startActivity(intent);
                            finish();
                            break;
                        case "SAS":
                            editor.putBoolean("SAS", true);
                            editor.putString("SAS_User", mUser.getEditText().getText().toString());
                            editor.putString("SAS_Pass", mPass.getEditText().getText().toString());
                            editor.commit();
                            intent.putExtra("Type", "SAS");
                            startActivity(intent);
                            finish();
                            break;
                    }
                }
            }
        });
    }

    public void initialSetup(){
        mTitle.setText(title);
        switch (type){
            case "Attendance":
                mBack.setBackgroundColor(Color.rgb(255,236,1));
                mUser.getEditText().setText(mStorage.getString("Attendance_User",""));
                mPass.getEditText().setText(mStorage.getString("Attendance_Pass",""));
                break;
            case "Marks":
                mBack.setBackgroundColor(Color.rgb(0, 83, 173));
                mUser.getEditText().setText(mStorage.getString("Marks_User",""));
                mPass.getEditText().setText(mStorage.getString("Marks_Pass",""));
                break;
            case "Trakking":
                mBack.setBackgroundColor(Color.rgb(161, 158, 205));
                mUser.getEditText().setText(mStorage.getString("Trakking_User",""));
                mPass.getEditText().setText(mStorage.getString("Trakking_Pass",""));
                break;
            case "SAS":
                mBack.setBackgroundColor(Color.rgb(255, 109, 49));
                mUser.getEditText().setText(mStorage.getString("SAS_User",""));
                mPass.getEditText().setText(mStorage.getString("SAS_Pass",""));
                break;
            case "Digital":
                mBack.setBackgroundColor(Color.rgb(239, 89, 123));
                mUser.getEditText().setText(mStorage.getString("Digital_User",""));
                mPass.getEditText().setText(mStorage.getString("Digital_Pass",""));
                break;
        }
    }
}
