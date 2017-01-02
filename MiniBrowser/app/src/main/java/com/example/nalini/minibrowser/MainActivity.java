package com.example.nalini.minibrowser;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    private SwipeRefreshLayout swipeRefreshLayout;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        webView=(WebView)findViewById(R.id.webview);
        webView.loadUrl("http://google.com");

        progressBar=(ProgressBar)findViewById(R.id.progressbar);

        swipeRefreshLayout=(SwipeRefreshLayout)findViewById(R.id.swap);

        progressBar.setVisibility(View.GONE);

        WebSettings webSettings= webView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setGeolocationEnabled(true);
        webSettings.setAllowContentAccess(true);


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
            public void onProgressChanged(WebView view, int newProgress)
            {
                progressBar.setProgress(newProgress);
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                webView.reload();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.new_tab) {
            return true;
        }
        if (id == R.id.book) {
            return true;
        }
        if (id == R.id.recenttab) {
            return true;
        }

        if (id == R.id.history) {
            return true;
        }

        if (id == R.id.downloads) {
            return true;
        }

        if (id == R.id.Share) {
            return true;
        }
        if (id == R.id.addtohome) {
            return true;
        }
        if (id == R.id.setting) {
            return true;
        }
        if (id == R.id.help) {
            return true;
        }

        return super.onOptionsItemSelected(item);


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
