package com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import com.ibrahim.androidwithjetpackcompose.R

sealed class HomeStackScreen(
    val route: String,
    val params: String = ""
) {
    object HOME : HomeStackScreen("home")
    object DETAIL : HomeStackScreen("detail/{countyName}", params = "countyName")
}

sealed class BottomStackScreen(
    val route: String,
    val mainRoute: String,
    val iconId: Int,
    val label: String
) {
    object MAIN :
        BottomStackScreen("mainStack", HomeStackScreen.HOME.route, R.drawable.tab1, "First")

    object FAVORITES :
        BottomStackScreen("favoriteStack", "favorites", R.drawable.favorite, "Favorites")
    object AT :
        BottomStackScreen("settings", "settings", R.drawable.settings, "Settings")
}

val bottomScreens = listOf(
    BottomStackScreen.MAIN,
    BottomStackScreen.FAVORITES,
    BottomStackScreen.AT,

)

val drawerMenuItems = listOf<MenuItem>(
    MenuItem(
        id = "home",
        title = "Home",
        contentDescription = "Go to home",
        icon = Icons.Default.Home
    ),
    MenuItem(
        id = "settings",
        title = "Settings",
        contentDescription = "Go to Settings",
        icon = Icons.Default.Settings
    ),
    MenuItem(
        id = "help",
        title = "Help",
        contentDescription = "Go to home",
        icon = Icons.Default.Info
    )
)

