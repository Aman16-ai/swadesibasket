package com.swadesibasket.swadeshecom

import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.statusBarColor = Color.parseColor("#E75E34")
        val webView = findViewById<WebView>(R.id.webView1)
        val progressBar = findViewById<ConstraintLayout>(R.id.imageProgressBar)
        webView.loadUrl("https://swadesibasket.com/")
        webView.settings.javaScriptEnabled = true
//        webView.webViewClient = WebViewClient()
        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                progressBar.visibility = View.VISIBLE
                webView.visibility = View.GONE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                progressBar.visibility = View.GONE
                webView.visibility = View.VISIBLE
            }
        }


    }
}