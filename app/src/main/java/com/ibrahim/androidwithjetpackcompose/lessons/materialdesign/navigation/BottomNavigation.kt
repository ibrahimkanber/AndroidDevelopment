package com.ibrahim.androidwithjetpackcompose.lessons.materialdesign

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.navigation.BottomStackScreen
import com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.navigation.MaterialStackNavigator
import com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.navigation.bottomScreens
import com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.navigation.screens.FavoritesScreen

@Composable
fun BottomNavGraph(
    bottomNavController: NavHostController,
) {
    NavHost(navController = bottomNavController, startDestination = BottomStackScreen.MAIN.route) {
        composable(route = BottomStackScreen.MAIN.route) {
            MaterialStackNavigator()
        }
        composable(route = BottomStackScreen.FAVORITES.route) {
            FavoritesScreen()
        }
        composable(route = BottomStackScreen.AT.route) {
            FavoritesScreen()
        }
    }
}

@Composable
fun BottomBar(bottomNavController: NavHostController) {
    val navBackStackEntry by bottomNavController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    BottomNavigation {
        bottomScreens.forEach {
            AddItem(
                screen = it,
                currentDestination = currentDestination,
                navController = bottomNavController
            )
        }
    }
}


@Composable
fun RowScope.AddItem(
    screen: BottomStackScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(selected = currentDestination?.hierarchy?.any {
        it.route == screen.route
    } == true,
        onClick = { navController.navigate(screen.route) },
        icon = {
            Icon(painter = painterResource(id = screen.iconId), contentDescription = "")
        },
        label = { Text(screen.label) },
        selectedContentColor = Color.Blue,
        unselectedContentColor = Color.Gray,
        modifier = Modifier.background(Color.White)
    )
}
