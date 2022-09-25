package com.example.newsappkotlin.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsappkotlin.R
import com.example.newsappkotlin.WebViewActivity
import com.example.newsappkotlin.model.News

class RecyclerViewAdapter(private val data: List<News>) : RecyclerView.Adapter<RecyclerViewAdapter.Holder>() {
    class Holder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imageNews: ImageView = itemView.findViewById(R.id.imageNews)
        val title: TextView = itemView.findViewById(R.id.titleNews)
        val author: TextView = itemView.findViewById(R.id.author)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_news, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = data[position].title
        holder.author.text = data[position].author

        // show image with glide library
        Glide.with(holder.itemView.context)
            .load(this.data[position].urlToImage)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.imageNews)

        // move page to webview
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, WebViewActivity::class.java)
            intent.putExtra("url", data[position].url)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}