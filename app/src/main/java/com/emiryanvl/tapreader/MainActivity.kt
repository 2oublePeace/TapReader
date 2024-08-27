package com.emiryanvl.tapreader

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.emiryanvl.tapreader.ui.screens.BookScreen
import com.emiryanvl.tapreader.ui.screens.BottomBar
import com.emiryanvl.tapreader.ui.screens.BottomBarItem
import com.emiryanvl.tapreader.ui.screens.HomeScreen
import com.emiryanvl.tapreader.ui.screens.TestNavScreen
import com.example.myapplication.ui.theme.TapReaderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TapReaderTheme {
                val navController = rememberNavController()
                val barItems = listOf(
                    BottomBarItem.Home,
                    BottomBarItem.Search,
                    BottomBarItem.Library
                )

                Box {
                    NavHost(
                        navController = navController,
                        startDestination = NavRoutes.HomeScreen.route
                    ) {
                        composable(NavRoutes.HomeScreen.route) { HomeScreen(navController) }
                        composable(NavRoutes.BookScreen.route + "/{BOOK_ISBN}") { stackEntry ->
                            val bookIsbn = stackEntry.arguments?.getString("BOOK_ISBN")
                            BookScreen(bookIsbn, navController)
                        }
                        composable(NavRoutes.TestNavScreen.route) { TestNavScreen(navController) }
                    }

                    BottomBar(
                        modifier = Modifier.align(Alignment.BottomCenter),
                        bottomBarItems = barItems,
                        navController = navController
                    )
                }
            }
        }
    }
}

sealed class NavRoutes(val route: String) {
    data object HomeScreen : NavRoutes("HOME_SCREEN")
    data object BookScreen : NavRoutes("BOOK_SCREEN")
    data object TestNavScreen : NavRoutes("TEST_NAV_SCREEN")
}
