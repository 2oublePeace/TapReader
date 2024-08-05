package com.emiryanvl.tapreader.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.emiryanvl.tapreader.ui.viewModels.AddBookViewModel

@Composable
fun AddBookScreen(
    navController: NavController,
    viewModel: AddBookViewModel = hiltViewModel()
) {
    val title = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }

    Scaffold {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(it)
        ) {
            TextField(
                value = title.value,
                onValueChange = { newText ->
                    title.value = newText
                },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
            TextField(
                value = description.value,
                onValueChange = { text ->
                    description.value = text
                },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
            Button(
                onClick = {
                    viewModel.addBook(title.value, description.value)
                    navController.popBackStack()
                }
            ) {
                Text(text = "Добавить книгу")
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun AddBookScreenPreview() {
    val navController = NavController(LocalContext.current)
    AddBookScreen(navController)
}