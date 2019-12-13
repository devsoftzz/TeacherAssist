package com.devsoftzz.teacherassist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebPage extends AppCompatActivity {

    private WebView mWebView;
    private String url,user,pass,js;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);

        SharedPreferences mStorage = getSharedPreferences("values",MODE_PRIVATE);
        mWebView = findViewById(R.id.webview);

        url = "";
        user = "";
        pass = "";
        js = "";

        String type = getIntent().getStringExtra("Type");

        switch (type){
            case "Attendance":
                url = "https://www.schoolattendancegujarat.org/";
                user = mStorage.getString("Attendance_User","");
                pass = mStorage.getString("Attendance_Pass","");
                js = "javascript:" +
                        "document.getElementById('Password').value = '" + pass + "';" +
                        "document.getElementById('UserName').value = '" + user + "';" +
                        "document.getElementById('loginbutton').click()";
                this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                break;
            case "Marks":
                url = "http://ssaexam.in/index.php";
                user = mStorage.getString("Marks_User","");
                pass = mStorage.getString("Marks_Pass","");
                js = "javascript:" +
                        "document.getElementById('PASSWORD').value = '" + pass + "';" +
                        "document.getElementById('USERNAME').value = '" + user + "';" +
                        "document.getElementById('loginbutton').click()";
                String newUA= "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0";
                //mWebView.getSettings().setUserAgentString(newUA);
                //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                break;
            case "Trakking":
                url = "http://ssa-elb-spoc-823717838.ap-south-1.elb.amazonaws.com/ssachildtracking/ctelogin.aspx";
                user = mStorage.getString("Trakking_User","");
                pass = mStorage.getString("Trakking_Pass","");
                js = "javascript:" +
                        "document.getElementById('TxtUPass').value = '" + pass + "';" +
                        "document.getElementById('TxtUName').value = '" + user + "';" +
                        "document.getElementById('ImgSubmit').click()";
                this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                break;
            case "SAS":
                user = mStorage.getString("SAS_User","");
                pass = mStorage.getString("SAS_Pass","");
                url = "https://sasgujarat.in/";
//                String prefix = user.substring(2,4);
//                switch (prefix){
//                    case "07":
//                        url = "https://ahmedabad.sasgujarat.in/";
//                        break;
//                    case "13":
//                        url = "https://amreli.sasgujarat.in/";
//                        break;
//                    case "15":
//                        url = "https://anand.sasgujarat.in/";
//                        break;
//                    case "27":
//                        url = "https://aravalli.sasgujarat.in/";
//                        break;
//                    case "02":
//                        url = "http://digital.decbk.in/";
//                        break;
//                    case "21":
//                        url = "https://bharuch.sasgujarat.in/";
//                        break;
//                    case "14":
//                        url = "https://bhavnagar.sasgujarat.in/";
//                        break;
//                    case "28":
//                        url = "https://botad.sasgujarat.in/";
//                        break;
//                    case "32":
//                        url = "https://chhotaudepur.sasgujarat.in/";
//                        break;
//                    case "18":
//                        url = "https://dahod.sasgujarat.in/";
//                        break;
//                    case "23":
//                        url = "https://dang.sasgujarat.in/";
//                        break;
//                    case "29":
//                        url = "https://dwarka.sasgujarat.in/";
//                        break;
//                    case "06":
//                        url = "https://gandhinagar.sasgujarat.in/";
//                        break;
//                    case "30":
//                        url = "https://somnath.sasgujarat.in/";
//                        break;
//                    case "10":
//                        url = "https://jamnagar.sasgujarat.in/";
//                        break;
//                    case "12":
//                        url = "https://junagadh.sasgujarat.in/";
//                        break;
//                    case "16":
//                        url = "https://kheda.sasgujarat.in/";
//                        break;
//                    case "01":
//                        url = "https://kutch.sasgujarat.in/";
//                        break;
//                    case "04":
//                        url = "https://mahesana.sasgujarat.in/";
//                        break;
//                    case "31":
//                        url = "https://mahisagar.sasgujarat.in/";
//                        break;
//                    case "33":
//                        url = "https://morbi.sasgujarat.in/";
//                        break;
//                    case "00":
//                        url = "https://municipal.sasgujarat.in/";
//                        break;
//                    case "20":
//                        url = "https://narmada.sasgujarat.in/";
//                        break;
//                    case "24":
//                        url = "https://navsari.sasgujarat.in/";
//                        break;
//                    case "17":
//                        url = "https://panchmahal.sasgujarat.in/";
//                        break;
//                    case "03":
//                        url = "http://digital.decpatan.in/";
//                        break;
//                    case "11":
//                        url = "https://porbandar.sasgujarat.in/";
//                        break;
//                    case "09":
//                        url = "https://rajkot.sasgujarat.in/";
//                        break;
//                    case "05":
//                        url = "https://sabarkantha.sasgujarat.in/";
//                        break;
//                    case "22":
//                        url = "https://surat.sasgujarat.in/";
//                        break;
//                    case "08":
//                        url = "https://surendranagar.sasgujarat.in/";
//                        break;
//                    case "26":
//                        url = "https://tapi.sasgujarat.in/";
//                        break;
//                    case "19":
//                        url = "https://vadodara.sasgujarat.in/";
//                        break;
//                    case "25":
//                        url = "https://valsad.sasgujarat.in/";
//                        break;
//                    default:
//                        url = "";
//                }
                js = "javascript:" +
                        "document.getElementsByName(\"password\")[0].value = '" + pass + "';" +
                        "document.getElementsByName(\"username\")[0].value = '" + user + "';" +
                        "document.getElementById('ImgSubmit').click()";
                this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                break;
        }

        WebSettings webSettings0 = mWebView.getSettings();
        webSettings0.setJavaScriptEnabled(true);
        webSettings0.setDomStorageEnabled(true);
        webSettings0.setBuiltInZoomControls(true);
        webSettings0.setDisplayZoomControls(false);
        webSettings0.setSupportZoom(true);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Toast.makeText(getApplicationContext(),request.getUrl().toString(),Toast.LENGTH_LONG).show();
                if(request.getUrl().toString().equals("http://ssaexam.in/Products/cms/index.php?modname=Dashboard/dashboard.php")){
                    mWebView.setPadding(0, 0, 0, 0);
                    mWebView.setInitialScale(getScale());
                }
                return super.shouldOverrideUrlLoading(view, request);
            }
            public void onPageFinished(WebView view, final String url) {
                super.onPageFinished(view, url);
                    view.evaluateJavascript(js, new ValueCallback<String>() {
                        @Override
                        public void onReceiveValue(String s) {
                            Log.d("myLogs", "Webview : " + s);
                        }
                    });
            }
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                super.onReceivedSslError(view, handler, error);
                handler.proceed();
            }
        });
        mWebView.setDownloadListener(new DownloadListener() {

            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));

                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,url);
                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
                Toast.makeText(getApplicationContext(), "Downloading File",Toast.LENGTH_LONG).show();
            }
        });
        mWebView.loadUrl(url);
    }
    private int getScale(){
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = display.getWidth();
        Double val = new Double(width)/new Double(960);
        val = val * 100d;
        return val.intValue();
    }
}