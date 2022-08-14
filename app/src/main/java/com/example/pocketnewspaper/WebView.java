package com.example.pocketnewspaper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebViewClient;

public class WebView extends AppCompatActivity {

    Toolbar toolbar;
     android.webkit.WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        getSupportActionBar().hide();


        toolbar = findViewById(R.id.toolbar);
       web = findViewById(R.id.web);


       Intent intent = getIntent();
       String url = intent.getStringExtra("url");
       web.setWebViewClient(new WebViewClient());
       web.loadUrl(url);



    }
}