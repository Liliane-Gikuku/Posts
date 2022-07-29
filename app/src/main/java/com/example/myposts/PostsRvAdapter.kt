package com.example.myposts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.databinding.PostsListItemsBinding

class PostsRvAdapter (var PostsList:List<Post>):
RecyclerView.Adapter<PostsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        var binding= PostsListItemsBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        var PostsViewHolder=PostsViewHolder(binding)
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
            var currentPosts=PostsList.get(position)
            holder.binding.tvUserId.text=currentPosts.userId.toString()
            holder.binding.tvId.text=currentPosts.id.toString()
            holder.binding.tvTitle.text=currentPosts.title
            holder.binding.tvBody.text=currentPosts.body
    }

    override fun getItemCount(): Int {
        return PostsList.size
    }


}



    class  PostsViewHolder(val binding:PostsListItemsBinding):
        RecyclerView.ViewHolder(binding.root){


    }