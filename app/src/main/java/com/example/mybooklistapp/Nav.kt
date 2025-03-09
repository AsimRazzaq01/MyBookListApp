package com.example.mybooklistapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Nav(modifier: Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Booklistscreen", modifier) {
        composable(route = "Booklistscreen") {
            Booklistscreen(navController, modifier)
        }
        composable(route = "StatsScreen") {
            StatsScreen(navController, modifier)
        }
        composable(route = "AppInfoscreen") {
            AppInfoscreen(navController, modifier)
        }
    }
}