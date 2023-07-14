package com.example.logintrial0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webactivity extends AppCompatActivity {

    WebView mWebview;

    @Override
    public void onBackPressed() {
        if (mWebview.canGoBack()) {
            mWebview.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webactivity);

        mWebview = findViewById(R.id.mywebview);

        Intent intent = getIntent();
        String webSite = intent.getStringExtra("links");


        mWebview.setWebViewClient(new WebViewClient());
        mWebview.loadUrl(webSite);

        WebSettings webSettings = mWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }
}