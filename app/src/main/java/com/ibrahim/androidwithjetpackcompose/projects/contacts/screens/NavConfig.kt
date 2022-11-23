package com.ibrahim.androidwithjetpackcompose.projects.contacts.screens


sealed class ContactStackScreen(
    val route: String,
    val params: String = "",
    val mainRoute:String=""
) {
    object HOME : ContactStackScreen("home")
    object DETAIL : ContactStackScreen("detail/{person}", params = "person", mainRoute = "detail")
    object SAVE : ContactStackScreen("save")
}