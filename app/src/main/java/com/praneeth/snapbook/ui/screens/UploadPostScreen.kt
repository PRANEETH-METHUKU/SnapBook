package com.praneeth.snapbook.ui.screens

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.praneeth.snapbook.viewmodel.PostViewModel

@Composable
fun UploadPostScreen(viewModel: PostViewModel = viewModel(), onPostUploaded: () -> Unit) {
    val content = remember { mutableStateOf("") }
    val context = LocalContext.current
    val imageUri = remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri.value = uri
    }

    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(value = content.value, onValueChange = { content.value = it }, label = { Text("Content") })

        Button(onClick = { launcher.launch("image/*") }) {
            Text("Select Image")
        }

        Button(onClick = {
            imageUri.value?.let { uri ->
                viewModel.uploadPost(uri, content.value, context, onPostUploaded)
            } ?: Toast.makeText(context, "No image selected", Toast.LENGTH_SHORT).show()
        }) {
            Text("Submit Post")
        }
    }
}