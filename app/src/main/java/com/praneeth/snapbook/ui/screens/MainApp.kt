package com.praneeth.snapbook.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MainApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "postList") {
        composable("postList") {
            PostListScreen {
                navController.navigate("uploadPost")
            }
        }
        composable("uploadPost") {
            UploadPostScreen {
                navController.popBackStack()
            }
        }
    }
}