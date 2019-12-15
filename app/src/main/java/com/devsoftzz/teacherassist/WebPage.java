package com.devsoftzz.teacherassist;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebPage extends AppCompatActivity {

    private WebView mWebView;
    private String url,user,pass,js;
    private ProgressDialog pd;
    private String newUA= "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_page);

        pd = new ProgressDialog(WebPage.this);
        pd.setMessage("Loading...");
        pd.create();
        pd.show();

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
                break;

            case "Marks":

                url = "http://ssaexam.in/index.php";
                user = mStorage.getString("Marks_User","");
                pass = mStorage.getString("Marks_Pass","");

                js = "javascript:" +
                        "document.getElementById('PASSWORD').value = '" + pass + "';" +
                        "document.getElementById('USERNAME').value = '" + user + "';" +
                        "document.getElementById('loginbutton').click()";
                break;
            case "Trakking":

                url = "http://ssa-elb-spoc-823717838.ap-south-1.elb.amazonaws.com/ssachildtracking/ctelogin.aspx";
                user = mStorage.getString("Trakking_User","");
                pass = mStorage.getString("Trakking_Pass","");

                js = "javascript:" +
                        "document.getElementById('TxtUPass').value = '" + pass + "';" +
                        "document.getElementById('TxtUName').value = '" + user + "';" +
                        "document.getElementById('ImgSubmit').click()";
                break;
            case "SAS":
                user = mStorage.getString("SAS_User","");
                pass = mStorage.getString("SAS_Pass","");
                url = "https://sasgujarat.in/";
                js = "javascript:" +
                        "document.getElementsByName(\"password\")[0].value = '" + pass + "';" +
                        "document.getElementsByName(\"username\")[0].value = '" + user + "';" +
                        "document.getElementById('ImgSubmit').click()";
                mWebView.getSettings().setUserAgentString(newUA);
                break;
            case "Digital":
                url = "https://www.digitalgujarat.gov.in/LoginApp/SJEDLogin.aspx";
                user = mStorage.getString("Digital_User","");
                pass = mStorage.getString("Digital_Pass","");
                js = "javascript:" +
                        "document.getElementById('txtUserNm').value = '" + user + "';" +
                        "document.getElementById('txtPassword').value = '" + pass + "';" +
                        "document.getElementById('ImgSubmit').click()";
                mWebView.getSettings().setUserAgentString(newUA);
                break;
            case "Samarth":

                url = "http://samarth2.inshodh.org/user/login";
                user = mStorage.getString("Samarth_User","");
                pass = mStorage.getString("Samarth_Pass","");
                String code = mStorage.getString("Samarth_Code","");
                js = "javascript:" +
                        "document.getElementsByName(\"mobile_no\")[0].value = '" + user + "';" +
                        "document.getElementsByName(\"teacher_code\")[0].value = '" + code + "';" +
                        "document.getElementsByName(\"password\")[0].value = '" + pass + "';" +
                        "document.getElementById(\"registration-form\").submit()";
                mWebView.getSettings().setUserAgentString(newUA);
                break;
        }

        configWebView();
        mWebView.loadUrl(url);
    }

    private void configWebView(){
        WebSettings webSettings0 = mWebView.getSettings();
        webSettings0.setJavaScriptEnabled(true);
        webSettings0.setDomStorageEnabled(true);
        webSettings0.setBuiltInZoomControls(true);
        webSettings0.setDisplayZoomControls(false);
        webSettings0.setSupportZoom(true);
        mWebView.getSettings().setUserAgentString(newUA);
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Toast.makeText(getApplicationContext(),request.getUrl().toString(),Toast.LENGTH_LONG).show();
                String rurl = request.getUrl().toString();
                if(rurl.equals("http://ssaexam.in/Products/cms/index.php?modname=Dashboard/dashboard.php")){
                    mWebView.setPadding(0, 0, 0, 0);
                    mWebView.setInitialScale(getScale());
                }
                if(rurl.equals("http://samarth2.inshodh.org/user/login") ||
                        rurl.equals("https://www.digitalgujarat.gov.in/LoginApp/SJEDLogin.aspx") ||
                        rurl.equals("https://sasgujarat.in/") ||
                        rurl.equals("http://ssa-elb-spoc-823717838.ap-south-1.elb.amazonaws.com/ssachildtracking/ctelogin.aspx") ||
                        rurl.equals("http://ssaexam.in/index.php") ||
                        rurl.equals("https://www.schoolattendancegujarat.org/")){
                    finish();
                }
                pd.show();
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
                try {
                    pd.dismiss();
                }catch (Exception e){}

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
    }
    private int getScale(){
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = display.getWidth();
        Double val = new Double(width)/new Double(960);
        val = val * 100d;
        return val.intValue();
    }
}