package com.example.test


import retrofit2.Call

import retrofit2.http.GET


interface RedditApiService {

    @GET("top.json")

    fun getTopPosts(): Call<RedditApiResponse>

}