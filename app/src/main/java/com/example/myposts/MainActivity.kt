package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
        fetchPosts()
    }


    fun fetchPosts() {
        val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPosts()
        request.enqueue(object : Callback<List<Post>> {
            //request for  a response on another thread  /io thread.that will not be created on a main thread, but you will get it on your main thread/ui. do and and notify us once you done. through this function
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
//
                if (response.isSuccessful) {
                    var posts = response.body()
                    Toast.makeText(
                        baseContext, "fetched ${posts!!.size} posts",
                        Toast.LENGTH_LONG
                    )
                        .show()
                    var postsAdapter = PostsRvAdapter( posts)
//                RecyclerView.apply {
                    binding.rvPost.layoutManager = LinearLayoutManager(baseContext)
                    binding.rvPost.adapter = postsAdapter
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

        })
    }



}
//        var RecyclerView=findViewById<RecyclerView>(R.id.rvPost)


