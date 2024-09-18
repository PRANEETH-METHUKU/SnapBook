package com.praneeth.snapbook.viewmodel

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.praneeth.snapbook.data.model.Post
import com.praneeth.snapbook.data.repository.PostRepository

class PostViewModel : ViewModel() {
    private val repository = PostRepository()

    val posts = mutableStateOf<List<Post>>(emptyList())

    fun fetchPosts() {
        repository.getPosts { fetchedPosts ->
            posts.value = fetchedPosts
        }
    }

    fun uploadPost(uri: Uri, content: String, context: Context, onPostUploaded: () -> Unit) {
        repository.uploadImage(uri, content, context, onPostUploaded)
    }
}