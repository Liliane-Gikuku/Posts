package com.example.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.databinding.PostsListItemsBinding

class CommentsAdaptor (var commentList:List<Post>):
    RecyclerView.Adapter<CommentViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        var binding= PostsListItemsBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
//        var CommentViewHolder=CommentViewHolder(binding)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        var currentComment=commentList.get(position)
        holder.binding.tvTitle.text=currentComment.title.toString()
        holder.binding.tvBody.text=currentComment.body.toString()
    }

    override fun getItemCount(): Int {
        return commentList.size
    }
}

class  CommentViewHolder(val binding: PostsListItemsBinding):
    RecyclerView.ViewHolder(binding.root)


