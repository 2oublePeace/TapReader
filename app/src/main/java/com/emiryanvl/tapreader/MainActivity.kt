package com.emiryanvl.tapreader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.emiryanvl.tapreader.ui.screens.BookScreen
import com.emiryanvl.tapreader.ui.screens.LibraryScreen
import com.example.myapplication.ui.theme.TapReaderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TapReaderTheme {
                Main()
            }
        }
    }
}

@Composable
fun Main() {
    val navController = rememberNavController()
    Column {
        NavHost(
            navController = navController,
            startDestination = NavRoutes.LibraryScreen.route
        ) {
            composable(NavRoutes.LibraryScreen.route) { LibraryScreen(navController) }
            composable(NavRoutes.BookScreen.route + "/{BOOK_ISBN}") { stackEntry ->
                val bookIsbn = stackEntry.arguments?.getString("BOOK_ISBN")
                BookScreen(bookIsbn, navController)
            }
        }
    }
}

sealed class NavRoutes(val route: String) {
    data object LibraryScreen : NavRoutes("LIBRARY_SCREEN")
    data object BookScreen : NavRoutes("BOOK_SCREEN")
}
