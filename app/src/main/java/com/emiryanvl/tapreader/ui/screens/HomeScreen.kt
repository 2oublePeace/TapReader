package com.emiryanvl.tapreader.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.emiryanvl.tapreader.NavRoutes
import com.emiryanvl.tapreader.R
import com.emiryanvl.tapreader.domain.models.Book
import com.emiryanvl.tapreader.ui.composables.BookCard
import com.emiryanvl.tapreader.ui.viewModels.HomeViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = stringResource(
                        id = R.string.add_book_fab_content_description
                    )
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        topBar = { MainTopBar() },
        bottomBar = {}
    ) { paddingValues ->

        val onTapCard: (String) -> Unit = { route ->
            navController.navigate(route)
        }

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(space = dimensionResource(id = R.dimen.padding_size_extra_large))
        ) {
            BookSection(
                modifier = Modifier.fillMaxWidth(),
                sectionTitle = stringResource(R.string.recommendation_block_header),
                sectionDescription = stringResource(R.string.recommendation_block_description),
                bookList = uiState.bookList,
                onTapCard = onTapCard,
            )

            BookSection(
                modifier = Modifier.fillMaxWidth(),
                sectionTitle = stringResource(R.string.new_releases_block_header),
                sectionDescription = stringResource(R.string.new_releases_block_description),
                bookList = uiState.bookList,
                onTapCard = onTapCard,
            )
        }
    }
}

@Composable
fun BookSection(
    modifier: Modifier = Modifier,
    sectionTitle: String,
    sectionDescription: String,
    bookList: List<Book>,
    onTapCard: (String) -> Unit = {},
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = sectionTitle,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.padding_size_large))
                .padding(bottom = dimensionResource(id = R.dimen.padding_size_extra_small))
        )
        Text(
            text = sectionDescription,
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .padding(horizontal = dimensionResource(id = R.dimen.padding_size_large))
                .padding(bottom = dimensionResource(id = R.dimen.padding_size_large))
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = dimensionResource(id = R.dimen.padding_size_extra_large)),
            horizontalArrangement = Arrangement.spacedBy(space = dimensionResource(id = R.dimen.padding_size_large)),
            contentPadding = PaddingValues(horizontal = dimensionResource(id = R.dimen.padding_size_medium))
        ) {
            items(bookList) { book ->
                val onClick by remember {
                    mutableStateOf({
                        onTapCard(NavRoutes.BookScreen.route + "/${book.isbn}")
                    })
                }
                //val onClick = { onTapCard(NavRoutes.BookScreen.route + "/${book.isbn}") }
                BookCard(
                    book = book,
                    onClick = onClick
                )
            }
        }
    }
}

@Composable
fun TestNavScreen(navController: NavController) {
    Scaffold(
        topBar = { BackTopBar(onBackClick = { }) },
        bottomBar = {}
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {}
    }
}