package com.emiryanvl.tapreader.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.emiryanvl.tapreader.R
import com.emiryanvl.tapreader.domain.models.Book

@Composable
fun BookCard(
    book: Book,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card(
            elevation = CardDefaults.cardElevation(16.dp),
            modifier = modifier.padding(bottom = 10.dp),
            shape = RoundedCornerShape(
                dimensionResource(id = R.dimen.book_list_card_corner_radius)
            )
        ) {
            Box(
                Modifier.clickable { onClick.invoke() }
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
                )

                if (!book.genre.isNullOrBlank()) {
                    Text(
                        text = book.genre,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = modifier
                            .align(Alignment.TopEnd)
                            .background(
                                color = Color(colorResource(id = R.color.genre).toArgb()),
                                shape = RoundedCornerShape(
                                    dimensionResource(
                                        id = R.dimen.book_list_card_corner_radius
                                    )
                                )
                            )
                            .padding(dimensionResource(id = R.dimen.padding_size_extra_small))
                    )
                }
            }
        }

        Text(
            text = book.title,
            style = MaterialTheme.typography.titleMedium,
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
        onClick = {},
    )
}
