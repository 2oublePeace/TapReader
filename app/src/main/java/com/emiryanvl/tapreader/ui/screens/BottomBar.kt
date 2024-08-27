package com.emiryanvl.tapreader.ui.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.emiryanvl.tapreader.NavRoutes
import com.emiryanvl.tapreader.R
import com.example.myapplication.ui.theme.TapReaderTheme

sealed class BottomBarItem(
    @StringRes val titleId: Int,
    @DrawableRes val iconId: Int,
    val route: String,
) {
    data object Home :
        BottomBarItem(
            titleId = R.string.home_image_button_text,
            iconId = R.drawable.ic_home,
            route = NavRoutes.HomeScreen.route
        )

    data object Search :
        BottomBarItem(
            titleId = R.string.search_image_button_text,
            iconId = R.drawable.ic_search,
            route = NavRoutes.TestNavScreen.route
        )

    data object Library :
        BottomBarItem(
            titleId = R.string.library_image_button_text,
            iconId = R.drawable.ic_book,
            route = NavRoutes.TestNavScreen.route
        )
}

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    bottomBarItems: List<BottomBarItem>,
    navController: NavController
) {
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar(
        modifier = modifier
    ) {
        bottomBarItems.forEachIndexed { index, bottomBarItem ->
            val isSelected = selectedItemIndex == index

            val color = if (isSelected) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.inverseSurface
            }

            NavigationBarItem(
                selected = isSelected,
                label = {
                    Text(
                        text = stringResource(id = bottomBarItem.titleId),
                        style = MaterialTheme.typography.labelSmall,
                        color = color
                    )
                },
                icon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = ImageVector.vectorResource(id = bottomBarItem.iconId),
                        contentDescription = stringResource(id = bottomBarItem.titleId),
                        tint = color
                    )
                },
                onClick = {
                    selectedItemIndex = index
                    navController.navigate(bottomBarItem.route) {
                        popUpTo(0)
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun BottomBarDarkPreview() {
    TapReaderTheme(darkTheme = true) {
        BottomBar(
            bottomBarItems = listOf(
                BottomBarItem.Home,
                BottomBarItem.Search,
                BottomBarItem.Library
            ),
            navController = rememberNavController()
        )
    }
}

@Preview
@Composable
fun BottomBarLightPreview() {
    TapReaderTheme() {
        BottomBar(
            bottomBarItems = listOf(
                BottomBarItem.Home,
                BottomBarItem.Search,
                BottomBarItem.Library
            ),
            navController = rememberNavController()
        )
    }
}