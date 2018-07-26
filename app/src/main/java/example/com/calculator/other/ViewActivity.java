package example.com.calculator.other;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import example.com.calculator.BaseActivity;
import example.com.calculator.R;

public class ViewActivity extends BaseActivity {

    String HOMEPAGE = "https://m.baidu.com";
    WebView webView;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()){
            webView.goBack();
            return true;
        }else {
            return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Intent intent = getIntent();
        String inputText = intent.getStringExtra("Inputdata");
        webView = (WebView)findViewById(R.id.view);

        ininWebView(webView);
        if(TextUtils.isEmpty(inputText)){
            //如果用户输入为空，则加载主页
            webView.loadUrl(HOMEPAGE);
        }else{
            //验证是不是输入的是不是网址
            if(inputText.startsWith("http") || inputText.startsWith("www")){
                webView.loadUrl(inputText);
            }else{
                //如果输入的不是网址。则拼接处百度搜索链接
                String result = "https://www.baidu.com/s?wd=" + inputText;
                webView.loadUrl(result);
            }
        }
    }

    private void ininWebView(WebView webView) {
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                //设置在当前窗口打开网页
                view.loadUrl(request.toString());
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                //拦截本地浏览器
                super.onPageStarted(view, url, favicon);
                Log.d("webview", "onPageStarted: "+url);
                if (url.startsWith("intent") || url.startsWith("INTENT")) {
                    view.loadUrl(url);
                }
            }
        });
        //设置支持JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
    }
}
