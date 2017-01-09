package com.example.nalini.webviewdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Process;
import android.preference.PreferenceManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    private ProgressBar progressBar;

    private SwipeRefreshLayout swipeRefreshLayout;

    private SharedPreferences sharedPreferences;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);

        webView=(WebView)findViewById(R.id.webview);

        progressBar=(ProgressBar)findViewById(R.id.progressbar);

        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swiperefrashlayout);

        progressBar.setVisibility(View.GONE);

        webView.loadUrl("http://google.com");

        WebSettings webSettings=webView.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webSettings.setLoadsImagesAutomatically(true);

        webSettings.setBuiltInZoomControls(true);

       // webSettings.setGeolocationEnabled(true);


        webView.setWebViewClient(new WebViewClient());

        webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {

                        progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {

                progressBar.setVisibility(View.INVISIBLE);
                swipeRefreshLayout.setRefreshing(false);
                getSupportActionBar().setTitle(view.getTitle());


            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {


            }
        });

          webView.setWebChromeClient(new WebChromeClient()

                                     {
                                         @Override
                                         public void onProgressChanged(WebView view, int newProgress) {

                                             progressBar.setProgress(newProgress);
                                         }
                                     }


          );

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                webView.reload();
            }
        });

    }

    @Override
    protected void onResume() {

        super.onResume();

        boolean colorflag=sharedPreferences.getBoolean("SWITCH_COLOR",false);

        boolean loadimages=sharedPreferences.getBoolean("SWITCH_IMAGES",true);

        boolean switchjava=sharedPreferences.getBoolean("SWITCH_JAVASCRIPT",true);

        if(colorflag)
        {
            Toast.makeText(this,"value is true",Toast.LENGTH_SHORT).show();
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.RED));
        }
        else
        {
            Toast.makeText(this,"value is false",Toast.LENGTH_SHORT).show();
            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.BLUE));
        }



        webView.getSettings().setLoadsImagesAutomatically(loadimages);

        webView.getSettings().setJavaScriptEnabled(switchjava);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.manu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        if(id==R.id.settiings)
        {
            startActivity(new Intent(MainActivity.this,SettingActivity.class));
            return true;
        }
        else if(id==R.id.share)
        {
            Toast.makeText(this,"Share clicked",Toast.LENGTH_SHORT).show();

           // startActivity(new Intent(MainActivity.this,SettingActivity.class));
            return true;
        }

        return false;
    }


    @Override
    public void onBackPressed() {

        if(webView.canGoBack())
        {
            webView.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }
}
