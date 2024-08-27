package com.emiryanvl.tapreader.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.emiryanvl.tapreader.NavRoutes
import com.emiryanvl.tapreader.R
import com.emiryanvl.tapreader.ui.viewModels.BookViewModel

@Composable
fun BookScreen(
    bookIsbn: String?,
    navController: NavController,
    viewModel: BookViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    bookIsbn?.let { isbn -> viewModel.getBook(isbn) }
    val onBackClick = { navController.navigateUp() }

    Scaffold(
        topBar = { BackTopBar(onBackClick = { onBackClick.invoke() }) },
        //bottomBar = { }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding(), bottom = paddingValues.calculateBottomPadding())
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            Card(
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen.book_image_width))
                    .height(dimensionResource(id = R.dimen.book_image_height))
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                elevation = CardDefaults.cardElevation(dimensionResource(id = R.dimen.padding_size_medium)),
            ) {
                AsyncImage(
                    model = uiState.imageUri,
                    contentDescription = stringResource(R.string.book_image_content_description),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(
                            shape = RoundedCornerShape(
                                dimensionResource(id = R.dimen.book_list_card_corner_radius)
                            )
                        )
                )
            }
            Text(
                text = uiState.title,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = uiState.author,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = stringResource(R.string.about_book_text),
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = uiState.description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Justify
            )
        }
    }
}

