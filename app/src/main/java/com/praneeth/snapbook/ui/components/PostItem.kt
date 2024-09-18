package com.praneeth.snapbook.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.praneeth.snapbook.data.model.Post
import com.praneeth.snapbook.utils.convertMilliSecondsToDate

@Composable
fun PostItem(post: Post) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = post.content)
        if (post.imageUrl != null) {
            Image(
                painter = rememberAsyncImagePainter(post.imageUrl),
                contentDescription = "Post Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
        Text(text = "Posted at: ${post.timestamp.convertMilliSecondsToDate()}")
    }
}