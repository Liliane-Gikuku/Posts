package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchPosts()
    }
    fun fetchPosts(){
        val apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
        var request=apiClient.getPosts()

        var RecyclerView=findViewById<RecyclerView>(R.id.rvPost)
        request.enqueue(object :Callback<List<Post>>{//request for  a response on another thread  /io thread.that will not be created on a main thread, but you will get it on your main thread/ui. do and and notify us once you done. through this function
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
//
               if (response.isSuccessful) {
                   var posts=response.body()
                   Toast.makeText(applicationContext,"fetched ${posts!!.size} posts",
                   Toast.LENGTH_LONG)
                       .show()
                   RecyclerView.apply {
                    layoutManager=LinearLayoutManager(this@MainActivity)
                    adapter= PostsRvAdapter(response.body()!!)
                }


               }

            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

        })
    }
}

