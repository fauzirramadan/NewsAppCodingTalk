package com.example.newsappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.newsappkotlin.adapter.RecyclerViewAdapter
import com.example.newsappkotlin.databinding.ActivityMainBinding
import com.example.newsappkotlin.model.ResponseData
import com.example.newsappkotlin.network.ConfigNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val request = ConfigNetwork.request()

        request.getNews("apple", "2022-09-24", "publishedAt", "c3221c206a3e4e6290209d3e5ee01090")
            .enqueue(object : Callback<ResponseData> {
                override fun onResponse(
                    call: Call<ResponseData>,
                    response: Response<ResponseData>
                ) {
                    if (response.isSuccessful) {
                        val dataNews = response.body()?.articles
                        Log.d("data", dataNews.toString())

                        // show ke recyclerView
                        val recyclerView = binding.recyclerView
                        val adapter = dataNews?.let { RecyclerViewAdapter(it) }
                        recyclerView.adapter = adapter
                    }
                }

                override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                    Log.d("error", t.localizedMessage ?: "")
                }

            })
    }
}