package com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.navigation

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.BottomBar
import com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.BottomNavGraph
import com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.components.AppBar
import kotlinx.coroutines.launch


@Composable
fun RootStackNavigator() {
    val bottomNavController = rememberNavController()
    val scaffoldState= rememberScaffoldState()
    val scope= rememberCoroutineScope()
    Scaffold(
    scaffoldState=scaffoldState,
        topBar = {
                 AppBar(
                     onNavigationIconClick = {
                         scope.launch {
                             scaffoldState.drawerState.open()
                         }
                     }
                 )
        },
        bottomBar = { BottomBar(bottomNavController = bottomNavController) },
        drawerContent = {
            DrawerHeader()
            DrawerBody(
                items = drawerMenuItems,
                modifier =Modifier,
                onItemClick ={}
            )
            val activity= LocalContext.current as Activity
            BackHandler(
                onBack = {
                    if(scaffoldState.drawerState.isOpen){
                        scope.launch {
                            scaffoldState.drawerState.close()
                        }

                    }else{
                        activity.finish()
                    }
                }
            )
        }

    ) {
        BottomNavGraph(bottomNavController)
    }
}


