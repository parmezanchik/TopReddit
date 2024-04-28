package com.example.test

import RedditPost
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        postViewModel = PostViewModel()
        postAdapter = PostAdapter(emptyList())

        recyclerView.adapter = postAdapter

        postViewModel.loadPosts()
        postViewModel.posts.observe(this, { posts: List<RedditPost> ->
            postAdapter.posts = posts
            postAdapter.notifyDataSetChanged()
        })

    }
}