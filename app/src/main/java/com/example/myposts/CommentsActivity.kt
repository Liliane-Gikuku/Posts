package com.example.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myposts.databinding.ActivityCommentsBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsActivity : AppCompatActivity() {
    lateinit var binding: ActivityCommentsBinding
    var postId = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityCommentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPostById()
        getComments()
    }

    fun obtainPostId() {
        postId = intent.extras?.getInt("POST-ID") ?: 0
    }

    fun fetchPostById() {
        var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getPostById(postId)
        request.enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>){
                if (response.isSuccessful){

                    var post=response.body()
//                    Toast.makeText(
//                        baseContext,
//                        "fetched ${comment!!.size} comment",
//                        Toast.LENGTH_LONG
//                    ).show()
                    binding.tvPostTitle.text=post?.title
                    binding.tvPostBody.text=post?.body

                }
            }



            override fun onFailure(call: Call<Post>, t: Throwable) {
                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
            }
        })
    }

    fun getComments(){
        var apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
        var request = apiClient.getComments(postId)
        request.enqueue(object : Callback<List<Comment>> {
            override fun onResponse(
                call: Call<List<Comment>>, response: Response<List<Comment>>
            ) {
                if (response.isSuccessful) {
                    var comment = response.body()
                    Toast.makeText(
                        baseContext,
                        "fetched ${comment!!.size} Comment",
                        Toast.LENGTH_LONG
                    ).show()
                    binding.rvComments.adapter = CommentsAdaptor(comment)
                    binding.rvComments.layoutManager = LinearLayoutManager(baseContext)
                }
            }

            override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}