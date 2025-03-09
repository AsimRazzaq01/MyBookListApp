package com.example.mybooklistapp
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.compose.material3.Text as Text

// view model
class BooklistViewModel(private val bookRepository: BookRepository) : ViewModel(){

    val books = bookRepository.getBooks()
//    val appName = bookRepository.getAppName()
}



@SuppressLint("UnrememberedMutableState")
@Composable
fun Booklistscreen(navController: NavHostController,modifier: Modifier = Modifier){
    // viewmodel instance
    val viewModel = viewModel{BooklistViewModel(BookRepository())}

    // regular column used for the outside of page
    Column {

        // call to function for top screen buttons to switch the pages
        TopScreen(navController,modifier)

        // surface for the bottom of screen Book List
        Surface(modifier = Modifier.padding(40.dp) .fillMaxWidth(), shape = RoundedCornerShape(10.dp),
            shadowElevation = 10.dp){
            // LAZY COLUMN
            LazyColumn(modifier = Modifier.padding(20.dp)) {

                item {
                    Text(text = "Book List", fontSize = 30.sp, color = Color.Blue, fontWeight = FontWeight.Bold)
                    //viewModel.appName
                }

                items(viewModel.books)    {book ->
                    Text(text = book.title, fontSize = 15.sp, color = Color.Blue)
                    Text(text = book.genre, fontSize = 15.sp, color = Color.Magenta)
                    Text(text = "${book.price} \n", fontSize = 15.sp, color = Color.Magenta)
                }

            }   // End Lazy Column
        }   // End Surface2
    }   // End Column
}   // end Booklistscreen


/**
 * funtion that allows you to switch screens using the 2 buttons
 * to be inserted at the top of first page
 */
@Composable
fun TopScreen(navController: NavHostController,modifier: Modifier = Modifier){
    val context = LocalContext.current
    // first surface
    Surface(modifier = Modifier.padding(40.dp) .fillMaxWidth(), shape = RoundedCornerShape(10.dp),
        shadowElevation = 10.dp){
        // row to keep the buttons horizontal and not over lapping
        Row(modifier = Modifier.padding(20.dp)) {      // Row Start
            Button(onClick = {
                navController.navigate("StatsScreen")
            }) {
                Text("Statics Screen")
            }

            //Space
            Text(text = " ")

            Button(onClick = {
                navController.navigate("AppInfoscreen")
            }) {
                Text("App Info Screen")
            }
        }   // End Row
    }   // End Surface
}   //  End fun topScreen