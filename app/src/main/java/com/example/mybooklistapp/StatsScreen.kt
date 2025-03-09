package com.example.mybooklistapp

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
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import kotlin.math.roundToInt
import kotlin.math.roundToLong

// view model
class StatsScreenViewModel(private val bookRepository: BookRepository) : ViewModel(){
    val books = bookRepository.getBooks()
    val AvgPrice = bookRepository.getAveragePrice()
    val generalAvgPrice = bookRepository
}

@Composable
fun StatsScreen(navController: NavHostController, modifier: Modifier = Modifier) {
    // viewmodel instance
    val viewModel = viewModel{StatsScreenViewModel(BookRepository())}

    // surface for the bottom of screen Book List
    Surface(modifier = Modifier.padding(40.dp) .fillMaxWidth(), shape = RoundedCornerShape(10.dp),
        shadowElevation = 10.dp) {
        // LAZY COLUMN
        LazyColumn(modifier = Modifier.padding(20.dp)) {

            item {
                Text(text = "Book Statistics", fontSize = 30.sp, color = Color.Blue,
                    fontWeight = FontWeight.Bold)
            }

            item {
                Text(
                    text = "Average Price  $${String.format("%.2f",viewModel.AvgPrice)}", fontSize = 15.sp, color = Color.Magenta)
            }

            items(viewModel.books.distinctBy { it.genre }){book ->
                Text(
                    text = "${book.genre}  $${String.format("%.2f",viewModel.generalAvgPrice.getGenreAveragePrice(book.genre))}", fontSize = 15.sp, color = Color.Magenta)
            }

        }   // End lazy Column
    }   // End Surface
}   // End Stats Screen


