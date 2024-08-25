package com.emiryanvl.tapreader.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.emiryanvl.tapreader.NavRoutes
import com.emiryanvl.tapreader.R
import com.emiryanvl.tapreader.domain.models.Book
import com.emiryanvl.tapreader.ui.viewModels.LibraryViewModel
import com.example.myapplication.ui.theme.Typography

@Composable
fun LibraryScreen(
    navController: NavController,
    viewModel: LibraryViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = stringResource(
                        id = R.string.add_book_floating_action_button_content_description
                    ),
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        topBar = { MainTopBar() },
        bottomBar = { BottomBar() },
        modifier = Modifier.padding(
            horizontal = dimensionResource(
                id = R.dimen.padding_root_size_small
            )
        )
    ) {
        LazyColumn(Modifier.padding(it)) {
            item {
                BookSection(
                    sectionTitle = stringResource(R.string.recommendation_block_header),
                    sectionDescription = stringResource(R.string.recommendation_block_description),
                    bookList = uiState.bookList,
                    navController
                )

                BookSection(
                    sectionTitle = stringResource(R.string.new_releases_block_header),
                    sectionDescription = stringResource(R.string.new_releases_block_description),
                    bookList = uiState.bookList,
                    navController
                )
            }
        }
    }
}

@Composable
fun BookSection(
    sectionTitle: String,
    sectionDescription: String,
    bookList: List<Book>,
    navController: NavController
) {
    val onTapCard = { route: String -> { navController.navigate(route) } }

    Text(
        text = sectionTitle,
        style = Typography.headlineSmall,
        modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_size_extra_small))
    )

    Text(
        text = sectionDescription,
        style = Typography.titleSmall,
        modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_size_medium))
    )

    LazyRow(
        modifier = Modifier.padding(bottom = dimensionResource(id = R.dimen.padding_size_extra_large))
    ) {
        item {
            for (book in bookList) {
                BookCard(
                    book = book,
                    onTapCard = onTapCard(NavRoutes.BookScreen.route + "/${book.isbn}")
                )
            }
        }
    }
}

@Composable
fun BookCard(
    book: Book,
    onTapCard: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(end = dimensionResource(id = R.dimen.padding_size_medium))
    ) {
        Box(
            Modifier.clickable { onTapCard() }
        ) {
            AsyncImage(
                model = book.imageUri,
                contentDescription = stringResource(
                    id = R.string.book_list_item_image_content_description
                ),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen.book_list_card_width))
                    .height(dimensionResource(id = R.dimen.book_card_height))
                    .clip(
                        shape = RoundedCornerShape(
                            dimensionResource(id = R.dimen.book_list_image_corner_radius)
                        )
                    )
            )

            if (!book.genre.isNullOrBlank()) {
                Text(
                    text = book.genre,
                    style = Typography.labelMedium,
                    modifier = modifier
                        .align(Alignment.TopEnd)
                        .background(
                            color = Color(colorResource(id = R.color.genre).toArgb()),
                            shape = RoundedCornerShape(
                                dimensionResource(
                                    id = R.dimen.book_list_image_corner_radius
                                )
                            )
                        )
                        .padding(dimensionResource(id = R.dimen.padding_size_extra_small))
                )
            }
        }

        Text(
            text = book.title,
            style = Typography.titleMedium,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BookCardPreview() {
    BookCard(
        Book(
            title = "Война и мир",
            description = "dasasdsd",
            author = "asdasd",
            genre = "Роман",
            isbn = "sadasd",
            imageUri = "asdasdasd"
        ),
        onTapCard = {},
    )
}
