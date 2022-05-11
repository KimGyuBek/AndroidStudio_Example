package com.example.webviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private String url = "https://www.naver.com";//점속하려는 url


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true); //javascript 허용
        webView.loadUrl(url); // 특정 url주소를 load
        webView.setWebChromeClient(new WebChromeClient()); //chrome setting
        webView.setWebViewClient(new WebViewClientClass());

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { //특정 다양한 android의 key들을 입력했을때 동작 지정
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) { //뒤로가기 키가 눌렸고 webview가 뒤로 갈 수 있으면
            webView.goBack(); //webview를 뒤로 가게 한다
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) { //현재 page url을 읽어오는 method
            view.loadUrl(url);
            return true;
        }
    }
}