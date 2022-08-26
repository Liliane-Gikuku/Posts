package com.example.myposts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myposts.databinding.ActivityCommentsBinding.inflate
import com.example.myposts.databinding.ActivityMainBinding.inflate
import com.example.myposts.databinding.PostsListItemsBinding
import com.example.myposts.databinding.PostsListItemsBinding.inflate

class CommentsRvAdapter(var comment:List<Comment>):RecyclerView.Adapter<CommentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var binding = PostsListItemsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )//        var binding=CommentsActivity.inflate(LayoutInflater.from(parent.context),parent,false)
//          var binding=CommentsViewHolder.inflate
        return CommentsViewHolder(binding)

    }


    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComment = comment.get(position)
        with(holder.binding) {
            tvBody.text=currentComment.Body.toString()
            tvTitle.text=currentComment.name.toString()
//            tvPostTitle.text = currentComment.name.toString()
//            tvPostBody.text = currentComment.body.toString
        }
    }

    override fun getItemCount(): Int {
        return comment.size
    }
}









class CommentsViewHolder(var binding: PostsListItemsBinding):RecyclerView.ViewHolder(binding.root)
