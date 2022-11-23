package com.ibrahim.androidwithjetpackcompose.lessons.widgets

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewUsage() {
    val url = "https://gelecegiyazanlar.turkcell.com.tr/"
    AndroidView(
        factory = {
            WebView(it).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT,

                    )
                webViewClient= WebViewClient()
                loadUrl(url)
            }
        },
        update = {
            it.loadUrl(url)
        }
    )
}