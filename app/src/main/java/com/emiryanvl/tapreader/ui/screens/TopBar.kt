package com.emiryanvl.tapreader.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.emiryanvl.tapreader.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Box(
                modifier = modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    textAlign = TextAlign.Center,
                    color = Color(colorResource(id = R.color.primary).toArgb()),
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(resId = R.font.dm_sans_bold)),
                )
            }

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
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackTopBar(navController: NavController) {
    TopAppBar(
        title = {},
        navigationIcon = {
            IconButton({ navController.popBackStack() }) {
                Icon(
                    painterResource(id = R.drawable.ic_back_arrow),
                    contentDescription = stringResource(
                        id = R.string.back_arrow_icon_content_description
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
        }
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
    val navController = NavController(LocalContext.current)
    BackTopBar(navController)
}