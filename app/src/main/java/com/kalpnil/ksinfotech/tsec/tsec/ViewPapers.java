package com.kalpnil.ksinfotech.tsec.tsec;

import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.kalpnil.ksinfotech.tsec.R;

public class ViewPapers extends AppCompatActivity {
    private WebView webView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpapers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        webView1 = (WebView) findViewById(R.id.webView2);
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.getSettings().setSupportZoom(true);
        webView1.getSettings().setBuiltInZoomControls(true);
        String pdf;
        pdf = getIntent().getExtras().getString("url");
        if(CheckNetwork.isInternetAvailable(ViewPapers.this))
        {
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            webView1.getSettings().setJavaScriptEnabled(true);
            webView1.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView view, int progress) {
                    ViewPapers.this.setProgress(progress * 1000);
                }
            });
            webView1.setWebViewClient(new WebViewClient() {
                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    Toast.makeText(ViewPapers.this, "Oh no! " + description, Toast.LENGTH_SHORT).show();
                }
            });

            webView1.loadUrl("http://docs.google.com/gview?embedded=true&url=" + pdf);
        }
        else{
            Toast toast = Toast.makeText(ViewPapers.this, "No Internet Connection", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_faculty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if(id == R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}
