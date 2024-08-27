package com.emiryanvl.tapreader.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.emiryanvl.tapreader.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                color = MaterialTheme.colorScheme.primary,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(resId = R.font.dm_sans_bold)),
            )
        },
        navigationIcon = {
            IconButton({ }) {
                Icon(
                    painterResource(id = R.drawable.ic_burger_menu),
                    contentDescription = stringResource(
                        id = R.string.burger_menu_icon_content_description
                    )
                )
            }
        },
        actions = {
            IconButton({ }) {
                Icon(
                    painterResource(id = R.drawable.ic_bell_notification),
                    contentDescription = stringResource(
                        id = R.string.bell_notification_icon_content_description
                    )
                )
            }
        },
        scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackTopBar(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {},
        navigationIcon = {
            Icon(
                modifier = Modifier.clickable { onBackClick() },
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_back_arrow),
                contentDescription = stringResource(
                    id = R.string.back_arrow_icon_content_description
                )
            )
        },
        actions = {
            Icon(
                painterResource(id = R.drawable.ic_bell_notification),
                contentDescription = stringResource(
                    id = R.string.bell_notification_icon_content_description
                )
            )
        },
        modifier = modifier
    )
}

@Preview
@Composable
fun MainTopBarPreview() {
    MainTopBar()
}

@Preview
@Composable
fun BackTopBarPreview() {
    BackTopBar({})
}