package com.ibrahim.androidwithjetpackcompose

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
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
import com.ibrahim.androidwithjetpackcompose.projects.guessnumber.navigation.RootNavigator
import com.ibrahim.androidwithjetpackcompose.projects.retrofit.FetchData
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
                    color = MaterialTheme.colors.background
                ) {
                    FetchData()
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