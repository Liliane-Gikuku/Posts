package com.example.myposts

import android.icu.text.CaseMap

data class Post(
    var userId:Int,
    var id:Int,
    var title: String,
    var body:String
)

data class Comment(
    var postId:Int,
    var id:Int,
    var name:String,
    var email:String,
    var body:String
)

fun returnBiggerObject(post1: Post,post2:Post):Post{
//    return post.javaClass.name
    return post2

}

