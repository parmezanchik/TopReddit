package com.example.test

import RedditPost
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(var posts: List<RedditPost>) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    class PostViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.view.findViewById<TextView>(R.id.author).text = post.author
        holder.view.findViewById<TextView>(R.id.created_utc).text = post.created_utc.toString()
        holder.view.findViewById<ImageView>(R.id.thumbnail).setImageURI(post.uri)
        holder.view.findViewById<TextView>(R.id.num_comments).text = post.num_comments.toString()
    }

    override fun getItemCount() = posts.size
}