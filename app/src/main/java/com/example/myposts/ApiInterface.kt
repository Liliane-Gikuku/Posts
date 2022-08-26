package com.example.myposts

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import java.sql.RowId

interface ApiInterface {// Android arsenal/volley for libraries//creating functions to access api.

    @GET("/posts")
    fun getPosts(): Call<List<Post>>

    @GET("/posts/{postId}")
    fun getPostById(@Path("postId")postId: Int):Call<Post>

//Retrofit is a library that allows our app to send this instructions via http
}