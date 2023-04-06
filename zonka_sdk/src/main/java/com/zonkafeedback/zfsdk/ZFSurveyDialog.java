package com.zonkafeedback.zfsdk;

import android.app.Activity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;


public class ZFSurveyDialog extends Dialog {

    private final Context context;
    private WebView webview;
    private CardView cardView;
    private final String baseUrl;
    private final OnDialogClickListener dialogClickListener;
    private ProgressBar progressBar;

    public ZFSurveyDialog(@NonNull Context context, String baseUrl, OnDialogClickListener onDialogClickListener) {
        super(context);
        this.context = context;
        this.baseUrl = baseUrl;
        this.dialogClickListener = onDialogClickListener;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zonka_dialog);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        webview = findViewById(R.id.webview);
        cardView = findViewById(R.id.cardview);
        progressBar = findViewById(R.id.progressbar);
        ImageView ivCancel = findViewById(R.id.iv_cancel);
        this.setCancelable(false);
        this.setCanceledOnTouchOutside(false);
        initView();


        ivCancel.setOnClickListener(v -> {
            destroyWebView();
            dialogClickListener.onDialogDismiss();
            dismiss();
        });
    }

    /**
     * Method used to initialize web view and set javascript event listener.
     */

    private void initView() {
        String url = baseUrl + Constant.EMBED_URL;
        final MyJavaScriptInterface myJavaScriptInterface
                = new MyJavaScriptInterface(context);
        webview.addJavascriptInterface(myJavaScriptInterface, Constant.ZF_FUNCTION);

        WebSettings webSettings = webview.getSettings();
        webview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);

        if (Build.VERSION.SDK_INT >= 19) {
            webview.setLayerType(View.LAYER_TYPE_HARDWARE, null);
        }
        else {
            webview.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }
        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl(url);
        webview.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }

    /**
     * Java Script Interface used to listen callbacks from web.
     */
    public class MyJavaScriptInterface {
        Context mContext;

        MyJavaScriptInterface(Context c) {
            mContext = c;
        }

        @JavascriptInterface
        public void executeWebSurveyEventAction(String toast) {
            if (toast.equalsIgnoreCase(Constant.SURVEY_CLOSE)) {
                ((Activity) context).runOnUiThread(() -> {
                    destroyWebView();
                    dialogClickListener.onDialogDismiss();
                    dismiss();
                });
            } else if (toast.equalsIgnoreCase(Constant.SURVEY_EXPAND)) {
                ((Activity) context).runOnUiThread(() -> {
                    RelativeLayout.LayoutParams param = new RelativeLayout.LayoutParams((int) (300 * context.getResources().getDisplayMetrics().density),
                            (int) (480 * context.getResources().getDisplayMetrics().density));
                    param.setMargins(0, (int) context.getResources().getDimension(
                            R.dimen.dp_9), 0, 0);
                    cardView.setLayoutParams(param);
                });

            }
        }

    }


    public interface OnDialogClickListener {
        void onDialogDismiss();
    }

    public void destroyWebView() {
        webview.clearHistory();
        webview.clearCache(true);
        webview.loadUrl("about:blank");
        webview.onPause();
        webview.removeAllViews();
        webview.destroyDrawingCache();
        webview.pauseTimers();
        webview.destroy();
        webview = null;
    }
}
