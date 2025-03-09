package com.example.mybooklistapp

import android.health.connect.datatypes.AppInfo
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController

// view model
class AppInfoViewModel(private val bookRepository: BookRepository) : ViewModel(){
    val books = bookRepository.getBooks()
    val appName = bookRepository.getAppName()
    val appDeveloperName = bookRepository.getAppDeveloperName()
    val appVersion = bookRepository.getAppVersion()
}

@Composable
fun AppInfoscreen(navController: NavHostController, modifier: Modifier ) {
    // viewmodel instance
    val viewModel = viewModel{AppInfoViewModel(BookRepository())}

    // surface for the bottom of screen Book List
    Surface(
        modifier = Modifier.padding(40.dp) .fillMaxWidth(), shape = RoundedCornerShape(10.dp),
        shadowElevation = 10.dp) {

        // LAZY COLUMN
        LazyColumn(modifier = Modifier.padding(20.dp)) {

            item {
                Text(text = "App Info", fontSize = 30.sp, color = Color.Blue,
                    fontWeight = FontWeight.Bold)
            }

            item{
                Text(
                    text = "Name:  ${viewModel.appName}", fontSize = 15.sp, color = Color.Magenta)
            }

            item{
                Text(
                    text = "Developer:  ${viewModel.appDeveloperName}", fontSize = 15.sp, color = Color.Magenta)
            }

            item{
                Text(
                    text = "Version:  ${viewModel.appVersion}", fontSize = 15.sp, color = Color.Magenta)
            }

        }   // End lazy Column
    }   // End Surface
}   // End AppInfoscreen