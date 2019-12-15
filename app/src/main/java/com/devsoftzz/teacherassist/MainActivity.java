package com.devsoftzz.teacherassist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;

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
    private SharedPreferences mStorage;
    private Intent WebIntent,PasswordIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebIntent = new Intent(MainActivity.this,WebPage.class);
        PasswordIntent = new Intent(MainActivity.this,setValues.class);
        mStorage = getSharedPreferences("values",MODE_PRIVATE);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mAttendance = findViewById(R.id.attendance);
        mAttendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStorage.getBoolean("Attendance",false)){
                    openWebpage("Attendance");
                }else {
                    openSetValue("ઓનલાઇન હાજરી","Attendance");
                }
            }
        });

        mMarks = findViewById(R.id.marks);
        mMarks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStorage.getBoolean("Marks",false)){
                    openWebpage("Marks");
                }else {
                    openSetValue("પરીક્ષા માર્ક એન્ટ્રી","Marks");
                }
            }
        });

        mTrakking = findViewById(R.id.Trakking);
        mTrakking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStorage.getBoolean("Trakking",false)){
                    openWebpage("Trakking");
                }else {
                    openSetValue("આધાર DISE Child ટ્રેક્કીગ","Trakking");
                }
            }
        });

        mSAS = findViewById(R.id.SAS);
        mSAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStorage.getBoolean("SAS",false)){
                    openWebpage("SAS");
                }else {
                    openSetValue("SAS Gujarat","SAS");
                }
            }
        });

        mDigital = findViewById(R.id.digital);
        mDigital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    openWebpage("Digital");
            }
        });

        mSamarth = findViewById(R.id.samarth);
        mSamarth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mStorage.getBoolean("Samarth",false)){
                    openWebpage("Samarth");
                }else {
                    Intent intent = new Intent(MainActivity.this,samarth_setValue.class);
                    intent.putExtra("Title","Samarth II");
                    startActivity(intent);
                }
            }
        });

    }

    public void openWebpage(String Type){
        WebIntent.putExtra("Type",Type);
        startActivity(WebIntent);
    }

    public void openSetValue(String Title, String Type){
        PasswordIntent.putExtra("Title",Title);
        PasswordIntent.putExtra("Type",Type);
        startActivity(PasswordIntent);
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
        if(id == R.id.share){
            String shareMessage ="*શિક્ષક સહાયક*\n" +
                    "\n" +
                    "        શિક્ષકોને ઓનલાઇન ડેટા સબમિટ કરવા માટે સરળ અને ઉપયોગી એન્ડ્રોઈડ મોબાઈલ એપ છે.\n" +
                    "\n" +
                    "જેમાં,\n" +
                    "*ઓનલાઇન હાજરી,*\n" +
                    "*આધાર DISE Child ટ્રેકિંગ,*\n" +
                    "*Samarth ll,*\n" +
                    "*Digital Gujarat,*\n" +
                    "*SAS Gujarat,*\n" +
                    "*SSA Exam*\n" +
                    "જેવી વેબસાઇટ્સનો સમાવેશ કરવામાં આવેલ છે. જેથી એક જ એપમાં બધું ઉપલબ્ધ થઈ શકે.\n" +
                    "\n" +
                    "નીચે આપેલ લિંક પરથી ડાઉનલોડ કરો.\n";
            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID;

            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "શિક્ષક સહાયક");
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
            shareIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            startActivity(Intent.createChooser(shareIntent, "Choose To Proceed"));
        }
        return super.onOptionsItemSelected(item);
    }
}
