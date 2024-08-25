package com.emiryanvl.tapreader.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.emiryanvl.tapreader.R

@Composable
fun BottomBar() {
    BottomAppBar(
        modifier = Modifier
            .width(dimensionResource(id = R.dimen.bottom_bar_width))
            .height(dimensionResource(id = R.dimen.bottom_bar_height))
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { }) {
                Icon(
                    painterResource(id = R.drawable.ic_home),
                    contentDescription = stringResource(
                        id = R.string.home_page_icon_content_description
                    )
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    painterResource(id = R.drawable.ic_serach),
                    contentDescription = stringResource(
                        id = R.string.search_icon_content_description
                    )
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    painterResource(id = R.drawable.ic_book),
                    contentDescription = stringResource(
                        id = R.string.library_icon_content_description
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    BottomBar()
}