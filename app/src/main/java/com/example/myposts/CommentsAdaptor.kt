package com.example.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.databinding.PostsListItemsBinding

class CommentsAdaptor(var commentList: List<Comment>?):
    RecyclerView.Adapter<RetrofitViewsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewsHolder {
        var binding = PostsListItemsBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
//        var CommentViewHolder=CommentViewHolder(binding)
        return RetrofitViewsHolder(binding)
    }

    override fun onBindViewHolder(holder: RetrofitViewsHolder, position: Int) {
        var currentComment = commentList!!.get(position)
        holder.binding.tvTitle.text = currentComment.postId.toString()
        holder.binding.tvBody.text = currentComment.body.toString()
    }



    override fun getItemCount(): Int {
        return commentList!!.size
    }
}

class  RetrofitViewsHolder(val binding: PostsListItemsBinding):
    RecyclerView.ViewHolder(binding.root)


