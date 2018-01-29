package com.companyname.appname;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MainActivity extends AppCompatActivity {



    private WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        myWebView = (WebView) findViewById(R.id.webView);


        myWebView.setWebViewClient(new MyBrowser());
        myWebView.setWebChromeClient(new WebChromeClient());
        myWebView.getSettings().setLoadsImagesAutomatically(true);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setDomStorageEnabled(true);
        myWebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        String url="file:///android_asset/index.html";
        myWebView.loadUrl(url);
    }
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }



    }


}
