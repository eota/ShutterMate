package com.example.android.camera2basic;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    private WebView webview;
    private String website;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        website = "https://nextchessmove.com/?fen=r1bqkb1r%2Fpp3ppp%2F2n1pn2%2F2pp4%2F3P4%2F4PN2%2FPPP1BPPP%2FRNBQ1RK1+w+kq+-+0+1&flipped=false";

        webview = findViewById(R.id.webView);

        webview.setWebViewClient(new WebViewClient());
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setDomStorageEnabled(true);
        webview.setOverScrollMode(WebView.OVER_SCROLL_NEVER);
        webview.loadUrl(website);
    }
}