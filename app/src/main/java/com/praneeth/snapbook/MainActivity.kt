package com.praneeth.snapbook

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.praneeth.snapbook.ui.screens.MainApp
import com.praneeth.snapbook.ui.theme.SnapBookTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        FirebaseApp.initializeApp(this)
        setContent {
            SnapBookTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }
}
//@Composable
//fun MainApp() {
//    val navController = rememberNavController()
//
//    NavHost(navController, startDestination = "postList") {
//        composable("postList") {
//            // Fetch posts code here
//            PostListScreen()
//            {
//                navController.navigate("uploadPost")
//            }
//        }
//        composable("uploadPost") {
//            UploadPostScreen {
//                navController.popBackStack()
//            }
//        }
//    }
//}
//
//@Composable
//fun PostListScreen(onFabClick: () -> Unit) {
//    val posts = remember { mutableStateOf<List<Post>>(emptyList()) }
//
//    // Fetch posts from Firebase
//    LaunchedEffect(Unit) {
//        val db = Firebase.firestore
//        db.collection("posts")
//            .orderBy("timestamp", Query.Direction.DESCENDING)
//            .addSnapshotListener { snapshot, e ->
//                if (e != null) {
//                    // Handle error
//                    return@addSnapshotListener
//                }
//                val fetchedPosts = snapshot?.documents?.mapNotNull { doc ->
//                    doc.toObject(Post::class.java)?.copy(id = doc.id)
//                } ?: emptyList()
//                posts.value = fetchedPosts
//            }
//    }
//
//    Scaffold(
//        floatingActionButton = {
//            FloatingActionButton(onClick = onFabClick) {
//                Icon(Icons.Default.Add, contentDescription = "Add Post")
//            }
//        }
//    ) {
//        LazyColumn(modifier = Modifier.padding(it)) {
//            items(posts.value) { post ->
//                PostItem(post)
//            }
//        }
//    }
//}
//
//
//@Composable
//fun PostItem(post: Post) {
//    Column(modifier = Modifier.padding(16.dp)) {
//        Text(text = post.content)
//        if (post.imageUrl != null) {
//            Image(
//                painter = rememberAsyncImagePainter(post.imageUrl),
//                contentDescription = "Post Image",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//            )
//        }
//        Text(text = "Posted at: ${post.timestamp.convertMilliSecondsToDate()}")
//    }
//}
//
//@Composable
//fun UploadPostScreen(onPostUploaded: () -> Unit) {
//    val content = remember { mutableStateOf("") }
//    val context = LocalContext.current
//    val imageUri = remember { mutableStateOf<Uri?>(null) }
//    val launcher = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.GetContent()
//    ) { uri: Uri? ->
//        imageUri.value = uri
//    }
//
//    Column(
//        modifier = Modifier.padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        TextField(value = content.value, onValueChange = { content.value = it }, label = { Text("Content") })
//
//        Button(onClick = { launcher.launch("image/*") }) {
//            Text("Select Image")
//        }
//
//        Button(onClick = {
//            imageUri.value?.let { uri ->
//                uploadImageToFirebaseStorage(uri, onPostUploaded, content.value, context)
//            } ?: Toast.makeText(context, "No image selected", Toast.LENGTH_SHORT).show()
//        }) {
//            Text("Submit Post")
//        }
//    }
//}
//
//private fun uploadImageToFirebaseStorage(uri: Uri, onPostUploaded: () -> Unit, content: String, context: Context) {
//    Toast.makeText(context, "uri + $uri", Toast.LENGTH_SHORT).show()
//    val storageRef = Firebase.storage.reference.child("images/${System.currentTimeMillis()}.jpg")
//
//    storageRef.putFile(uri)
//        .addOnSuccessListener {
//            storageRef.downloadUrl.addOnSuccessListener { downloadUri ->
//                val post = Post(content = content, imageUrl = downloadUri.toString())
//                Firebase.firestore.collection("posts")
//                    .add(post)
//                    .addOnSuccessListener {
//                        onPostUploaded()
//                    }
//                    .addOnFailureListener {
//                        Toast.makeText(context, "Failed to upload post ${it.localizedMessage}", Toast.LENGTH_SHORT).show()
//                    }
//            }
//        }
//        .addOnFailureListener {
//            Toast.makeText(context, "Failed to upload image ${it.localizedMessage}", Toast.LENGTH_SHORT).show()
//        }
//}
//
//



@Preview(showBackground = true)
@Composable
fun SnapBookPreview() {
    SnapBookTheme {
        MainApp()
    }
}