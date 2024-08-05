package com.emiryanvl.tapreader.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.emiryanvl.tapreader.NavRoutes
import com.emiryanvl.tapreader.domain.models.BookModel
import com.emiryanvl.tapreader.ui.viewModels.LibraryViewModel
import kotlin.math.roundToInt
import kotlin.random.Random

@Composable
fun LibraryScreen(
    navController: NavController,
    viewModel: LibraryViewModel = hiltViewModel()
) {
    val books by viewModel.books.collectAsState()

    val tapOnCard: (String) -> Unit = {
        navController.navigate(NavRoutes.BookScreen.route)
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(NavRoutes.AddBookScreen.route)
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Добавить",
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
            item {
                DoubleColumn(list = books, onClick = tapOnCard)
            }
        }
    }
}

@Composable
fun DoubleColumn(
    list: List<BookModel>,
    onClick: (String) -> Unit,
) {
    val firstHalf = list.subList(0, (list.size.toDouble() / 2).roundToInt())
    val secondHalf = list.subList(firstHalf.size, list.size)

    Row {
        Column(Modifier.fillMaxWidth(0.5f)) {
            firstHalf.forEach {
                BookCard(it.title, onClick)
            }
        }

        Column(Modifier.fillMaxWidth()) {
            secondHalf.forEach {
                BookCard(it.title, onClick)
            }
        }
    }
}

@Composable
fun BookCard(
    text: String,
    onClick: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(
                color = Color(
                    red = Random.nextInt(255),
                    green = Random.nextInt(255),
                    blue = Random.nextInt(255),
                    alpha = 64
                ),
                shape = RoundedCornerShape(15.dp)
            )
            .clickable {
                onClick(text)
            }
            .fillMaxWidth()
            .height(320.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontSize = 28.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LibraryScreenPreview() {
    val navController = NavController(LocalContext.current)
    LibraryScreen(navController)
}
