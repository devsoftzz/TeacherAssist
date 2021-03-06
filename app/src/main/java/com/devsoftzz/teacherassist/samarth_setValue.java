package com.devsoftzz.teacherassist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class samarth_setValue extends AppCompatActivity {

    private TextView mTitle;
    private String title,type;
    private Button mSet;
    private TextInputLayout mUser,mPass,mCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samarth_set_value);

        mTitle = findViewById(R.id.title);
        mSet = findViewById(R.id.set);
        mUser = findViewById(R.id.mobilenum);
        mCode = findViewById(R.id.code);
        mPass = findViewById(R.id.password);

        SharedPreferences mStorage = getSharedPreferences("values",MODE_PRIVATE);
        final SharedPreferences.Editor editor = mStorage.edit();
        final Intent intent = new Intent(samarth_setValue.this,WebPage.class);

        title = getIntent().getStringExtra("Title");
        type = getIntent().getStringExtra("Type");
        mTitle.setText(title);

        mUser.getEditText().setText(mStorage.getString("Samarth_User",""));
        mCode.getEditText().setText(mStorage.getString("Samarth_Code",""));
        mPass.getEditText().setText(mStorage.getString("Samarth_Pass",""));

        mSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u,p,c;
                u = mUser.getEditText().getText().toString().trim();
                p = mPass.getEditText().getText().toString().trim();
                c = mCode.getEditText().getText().toString().trim();
                if(u.equals("") || u.length()!= 10){
                    Toast.makeText(getApplicationContext(),"Enter Phone Number Properly",Toast.LENGTH_LONG).show();
                    return;
                }if(c.equals("") || c.length()!=8){
                    Toast.makeText(getApplicationContext(),"Enter Teacher Code Properly",Toast.LENGTH_LONG).show();
                    return;
                }if(p.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_LONG).show();
                    return;
                }
                editor.putBoolean("Samarth",true);
                editor.putString("Samarth_User",mUser.getEditText().getText().toString());
                editor.putString("Samarth_Pass",mPass.getEditText().getText().toString());
                editor.putString("Samarth_Code",mCode.getEditText().getText().toString());
                editor.commit();
                intent.putExtra("Type","Samarth");
                startActivity(intent);
                finish();
            }
        });
    }
}
