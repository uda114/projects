package com.example.paypal;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private WebView nWebView;
    private ProgressBar nProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nWebView = findViewById(R.id.webView);
        nProgressBar = findViewById(R.id.progressBar);

        nWebView.getSettings().setJavaScriptEnabled(true);
        nWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        nWebView.setWebViewClient(new WebViewClient()

                                  {

                                      @Override
                                      public void onPageStarted(WebView view, String url, Bitmap favicon) {
                                          super.onPageStarted(view, url, favicon);
                                          nWebView.setVisibility(View.GONE);
                                          nProgressBar.setVisibility(View.VISIBLE);

                                          if (url.equals("http://www.example.com/cancel"))
                                          {
                                              Toast.makeText(Main2Activity.this, "Payment is cancel", Toast.LENGTH_LONG).show();
                                             finish();
                                          }

                                          else if (url.equals("http://www.example.com/done"))
                                          {
                                              Toast.makeText(Main2Activity.this, "Payment is success", Toast.LENGTH_SHORT).show();
                                              youCanDoWhatEverYouWantToDo();
                                          }
                                      }


                                      @Override
                                      public void onPageFinished(WebView view, String url) {
                                          super.onPageFinished(view, url);
                                          nWebView.setVisibility(View.VISIBLE);
                                          nProgressBar.setVisibility(View.GONE);
                                      }
                                  }

        );

        nWebView.loadUrl("https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=AZ26ETCJG76BS");
    }

    private void youCanDoWhatEverYouWantToDo() {
    }
}
