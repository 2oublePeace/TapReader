package com.emiryanvl.tapreader.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.emiryanvl.tapreader.R
import com.emiryanvl.tapreader.ui.viewModels.BookViewModel
import com.example.myapplication.ui.theme.Typography

@Composable
fun BookScreen(
    bookIsbn: String?,
    navController: NavController,
    viewModel: BookViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    bookIsbn?.let { isbn -> viewModel.getBook(isbn) }

    Scaffold(
        topBar = { BackTopBar(navController = navController) },
        bottomBar = { BottomBar() },
        modifier = Modifier.padding(
            horizontal = dimensionResource(
                id = R.dimen.padding_root_size_large
            )
        )
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    AsyncImage(
                        model = uiState.imageUri,
                        contentDescription = stringResource(R.string.book_image_content_description),
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .width(dimensionResource(id = R.dimen.book_image_width))
                            .height(dimensionResource(id = R.dimen.book_image_height))
                            .clip(
                                shape = RoundedCornerShape(
                                    dimensionResource(id = R.dimen.book_list_image_corner_radius)
                                )
                            )
                    )
                }

                Text(
                    text = uiState.title,
                    style = Typography.headlineMedium
                )

                Text(
                    text = uiState.author,
                    style = Typography.titleMedium
                )

                Text(
                    text = "О книге",
                    style = Typography.titleLarge
                )

                Text(
                    text = uiState.description,
                    style = Typography.bodyMedium
                )
            }
        }
    }
}
