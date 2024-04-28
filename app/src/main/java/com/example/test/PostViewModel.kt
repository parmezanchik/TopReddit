package com.example.test

import RedditPost
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostViewModel : ViewModel() {
    val posts: MutableLiveData<List<RedditPost>> = MutableLiveData()

    fun loadPosts() {
        val apiService = RetrofitInstance.getRetrofitInstance().create(RedditApiService::class.java)
        apiService.getTopPosts().enqueue(object : Callback<RedditApiResponse> {
            override fun onResponse(call: Call<RedditApiResponse>, response: Response<RedditApiResponse>) {
                val redditApiResponse = response.body()
                val posts = redditApiResponse?.data?.children?.map { it.data }?: emptyList()
                this@PostViewModel.posts.value = posts
            }

            override fun onFailure(call: Call<RedditApiResponse>, t: Throwable) {
                // Handle error
            }
        })
    }
}