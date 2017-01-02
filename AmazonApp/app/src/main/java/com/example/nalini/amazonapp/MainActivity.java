package com.example.nalini.amazonapp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

     private WebView webView;

     private ProgressBar progressBar;

    @Override
       protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        progressBar=(ProgressBar)findViewById(R.id.progressbar);

        webView=(WebView)findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());

        progressBar.setVisibility(View.GONE);

        webView.setWebViewClient(new WebViewClient()

                                 {
                                     @Override
                                     public void onPageStarted(WebView view, String url, Bitmap favicon) {
                                         progressBar.setVisibility(View.VISIBLE);
                                     }

                                     @Override
                                     public void onPageFinished(WebView view, String url) {
                                         progressBar.setVisibility(View.INVISIBLE);
                                     }

                                     @Override
                                     public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {

                                     }
                                 }





        );
      //  webView.loadUrl("http://www.amazon.in");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       //   getSupportActionBar().setDisplayHomeAsUpEnabled(true);

       // getSupportActionBar().setIcon(R.drawable.amazon);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.setDrawerListener(toggle);

        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

          webView.loadUrl("http://www.amazon.in/?tag=googhydrabk-21&ref_=pd_mn_ABKror1114");
        } else if (id == R.id.nav_category) {

            webView.loadUrl("http://www.amazon.in/gp/site-directory/ref=nav_shopall_btn");

        } else if (id == R.id.nav_deal) {

           webView.loadUrl("http://www.amazon.in/gp/goldbox/ref=nav_cs_gb");

        } else if (id == R.id.nav_order) {

            webView.loadUrl("https://www.amazon.in/ap/signin?_encoding=UTF8&accountStatusPolicy=P1&openid.assoc_handle=inamazon&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fcss%2Forder-history%3Fie%3DUTF8%26ref_%3Dnav_youraccount_orders&pageId=webcs-yourorder&showRmrMe=1");

        } else if (id == R.id.nav_wishlist) {

            webView.loadUrl("http://www.amazon.in/gp/goldbox/ref=nav_cs_gb?nocache=1482397672363");

        } else if (id == R.id.nav_account) {

            webView.loadUrl("https://www.amazon.in/gp/css/homepage.html/ref=footer_ya");

        }
        else if(id==R.id.gift)
        {
           webView.loadUrl("https://www.amazon.in/gift-card-store/b/ref=nav_cs_gc?ie=UTF8&node=3704982031");
        }
        else if(id==R.id.try_prime)
        {
          webView.loadUrl("https://www.amazon.in/gp/prime/pipeline/landing?ie=UTF8&ref_=nav_prime_try_btn");
        } else if (id==R.id.nav_customer)
        {
            webView.loadUrl("https://www.amazon.in/gp/help/customer/display.html?ie=UTF8&nodeId=200507590&ref_=nav_cs_help");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
