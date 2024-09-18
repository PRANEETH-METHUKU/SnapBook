package com.praneeth.snapbook.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.praneeth.snapbook.viewmodel.PostViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.praneeth.snapbook.ui.components.PostItem

@Composable
fun PostListScreen(viewModel: PostViewModel = viewModel(), onFabClick: () -> Unit) {
    val posts by viewModel.posts

    // Fetch posts from Firebase
    LaunchedEffect(Unit) {
        viewModel.fetchPosts()
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onFabClick) {
                Icon(Icons.Default.Add, contentDescription = "Add Post")
            }
        }
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            items(posts) { post ->
                PostItem(post)
            }
        }
    }
}