package com.example.newsappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsappkotlin.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val webView = binding.webView

        val detailView = intent.getStringExtra("url")

        detailView.let {
            if (it != null) {
                webView.loadUrl(it)
            }
        }
    }
}