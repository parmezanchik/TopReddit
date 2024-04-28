package com.example.test

import RedditPost
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PostDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        val post = intent.getParcelableExtra<RedditPost>("post")

        if (post != null) {
            findViewById<TextView>(R.id.author).text = post.author
        }
        if (post != null) {
            findViewById<TextView>(R.id.created_utc).text = post.created_utc.toString()
        }
        if (post != null) {
            findViewById<ImageView>(R.id.image).setImageURI(post.uri)
        }
        if (post != null) {
            findViewById<TextView>(R.id.num_comments).text = post.num_comments.toString()
        }
    }
}