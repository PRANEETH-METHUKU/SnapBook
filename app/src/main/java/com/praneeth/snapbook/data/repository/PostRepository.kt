package com.praneeth.snapbook.data.repository

import android.content.Context
import android.net.Uri
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.praneeth.snapbook.data.model.Post

class PostRepository {
    private val firestore = FirebaseFirestore.getInstance()
    private val storage = FirebaseStorage.getInstance()

    fun getPosts(onPostsLoaded: (List<Post>) -> Unit) {
        firestore.collection("posts")
            .orderBy("timestamp")
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    onPostsLoaded(emptyList())
                    return@addSnapshotListener
                }
                val fetchedPosts = snapshot?.documents?.mapNotNull { doc ->
                    doc.toObject(Post::class.java)?.copy(id = doc.id)
                } ?: emptyList()
                onPostsLoaded(fetchedPosts)
            }
    }

    fun uploadImage(uri: Uri, content: String, context: Context, onPostUploaded: () -> Unit) {
        val storageRef = storage.reference.child("images/${System.currentTimeMillis()}.jpg")
        storageRef.putFile(uri)
            .addOnSuccessListener {
                storageRef.downloadUrl.addOnSuccessListener { downloadUri ->
                    val post = Post(content = content, imageUrl = downloadUri.toString())
                    firestore.collection("posts")
                        .add(post)
                        .addOnSuccessListener {
                            onPostUploaded()
                        }
                        .addOnFailureListener {
                            Toast.makeText(context, "Failed to upload post ${it.localizedMessage}", Toast.LENGTH_SHORT).show()
                        }
                }
            }
            .addOnFailureListener {
                Toast.makeText(context, "Failed to upload image ${it.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
    }
}