package com.example.test

import RedditPost

data class RedditApiResponse(val data: RedditData)
data class RedditData(val children: List<RedditChildren>)
data class RedditChildren(val data: RedditPost)
