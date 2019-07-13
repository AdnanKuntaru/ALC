package com.kuntaru.alc;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AlcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alc);
        //this retrieve the web from xml
        final WebView webView = findViewById(R.id.web_view);
        // this my url
        webView.loadUrl("https://andela.com/alc/");
        // this set the web client to handle some error if found
        webView.setWebViewClient(new webViewClient());

    }

    private class webViewClient extends WebViewClient {
        // this handle the error of ssl
        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
        }
    }

}

