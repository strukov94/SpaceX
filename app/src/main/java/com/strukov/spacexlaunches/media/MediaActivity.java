package com.strukov.spacexlaunches.media;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.strukov.spacexlaunches.R;
import com.strukov.spacexlaunches.constants.Constants;

public class MediaActivity extends AppCompatActivity {

    private WebView mWebViewArticle;
    private String mUrlArticle;
    private String mUrlVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mWebViewArticle = findViewById(R.id.web_article);
        mWebViewArticle.getSettings().setSupportZoom(true);
        mWebViewArticle.getSettings().setBuiltInZoomControls(true);

        mUrlArticle = getIntent().getStringExtra(Constants.LAUNCH_ARTICLE_LINK);
        mUrlVideo = getIntent().getStringExtra(Constants.LAUNCH_VIDEO_LINK);

        setTitle(mUrlArticle);

        mWebViewArticle.loadUrl(mUrlArticle);

        mWebViewArticle.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebViewArticle.canGoBack()) {
            mWebViewArticle.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.article_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                if (mWebViewArticle.canGoBack())
                    mWebViewArticle.goBack();
                else onBackPressed();
                break;
            case R.id.action_open_browser:
                openApp(mUrlArticle);
                break;
            case R.id.action_open_youtube:
                openApp(mUrlVideo);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openApp(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
