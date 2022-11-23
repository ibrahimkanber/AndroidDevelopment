package com.ibrahim.androidwithjetpackcompose.projects.contacts.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.ibrahim.androidwithjetpackcompose.projects.contacts.entity.Person

@Composable
fun ContactsNavigator(){
    val navHostController= rememberNavController()
    NavHost(navController = navHostController, startDestination = ContactStackScreen.HOME.route ){
        composable(route = ContactStackScreen.HOME.route) {
            ContactsScreen(navHostController)
        }
        composable(route = ContactStackScreen.SAVE.route) {
            AddNewContactScreen()
        }
        composable(route = ContactStackScreen.DETAIL.route, arguments = listOf(
            navArgument(ContactStackScreen.DETAIL.params){type= NavType.StringType}
        )) {
            val json=it.arguments?.getString(ContactStackScreen.DETAIL.params)
            val person=Gson().fromJson(json, Person::class.java)
            ContactsDetailScreen(person)
        }
        composable(route = ContactStackScreen.SAVE.route) {
            AddNewContactScreen()
        }
    }
}