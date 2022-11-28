package com.ibrahim.androidwithjetpackcompose

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.AlertDialogUsage
import com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.CardUsage
import com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.LazyColumnDynamicUsage
import com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.SnackBarUsage
import com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.navigation.RootStackNavigator
import com.ibrahim.androidwithjetpackcompose.lessons.mvvm.Calculator
import com.ibrahim.androidwithjetpackcompose.lessons.widgets.CheckboxExample
import com.ibrahim.androidwithjetpackcompose.lessons.widgets.FloatingActionButtonExample
import com.ibrahim.androidwithjetpackcompose.projects.contacts.screens.ContactsNavigator
import com.ibrahim.androidwithjetpackcompose.projects.foods.navigation.FoodNavigator
import com.ibrahim.androidwithjetpackcompose.projects.glide.GlideUsage
import com.ibrahim.androidwithjetpackcompose.projects.guessnumber.navigation.RootNavigator
import com.ibrahim.androidwithjetpackcompose.projects.notification.NotificationPage
import com.ibrahim.androidwithjetpackcompose.projects.retrofit.FetchData
import com.ibrahim.androidwithjetpackcompose.projects.timer.Timer
import com.ibrahim.androidwithjetpackcompose.storage.DataStoreUsage
import com.ibrahim.androidwithjetpackcompose.ui.theme.AndroidWithJetpackComposeTheme
import com.ibrahim.androidwithjetpackcompose.ui.theme.extendedColors

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AndroidWithJetpackComposeTheme() {
                //window?.statusBarColor = MaterialTheme.colors.primary.toArgb()
                window?.statusBarColor = MaterialTheme.extendedColors.statusBar.toArgb()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF101010)
                ) {
                    Box(
                        contentAlignment = Alignment.Center ,
                        modifier = Modifier.fillMaxSize()
                    ){
                        Timer(
                            totalTime = 10L*1000L,
                            handleColor =Color.Green ,
                            inactiveBarColor = Color.DarkGray,
                            activeBarColor = Color(0xFF37B900),
                            modifier = Modifier.size(200.dp)

                        )

                    }




                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidWithJetpackComposeTheme {
        Greeting("Android")
    }
}