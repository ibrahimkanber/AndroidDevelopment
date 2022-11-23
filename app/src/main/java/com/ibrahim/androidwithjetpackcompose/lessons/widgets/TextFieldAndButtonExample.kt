package com.ibrahim.androidwithjetpackcompose.lessons.widgets

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldAndButtonExample(name: String) {
    val tf= remember{ mutableStateOf("") }
    val enteredValue= remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text ="Entered Value ${enteredValue.value}",
            Modifier
                .background(Color.Yellow)
                .padding(10.dp)
        )
        Text(
            text ="Entered Value---- ${enteredValue.value}",
            style = TextStyle(
                background = Color.Cyan,
                color = Color.Red,
                fontWeight = FontWeight.Bold
            )
        )
        TextField(
            value =tf.value ,
            onValueChange ={tf.value=it},
            label = { Text("Please enter value") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Gray,
                textColor = Color.Red,
                focusedIndicatorColor = Color.Green,
                focusedLabelColor = Color.Yellow,
            ),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType= KeyboardType.Number)


        )
        Button(
            onClick = { enteredValue.value=tf.value },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Red,
                contentColor = Color.White,
            ),
            border = BorderStroke(1.dp, Color.Black),
            shape = RoundedCornerShape(50)

        ) {
            Text(text = "Submit")

        }

        OutlinedTextField(
            value =tf.value ,
            onValueChange ={tf.value=it},
            label = { Text("Please enter value") },

            )
        OutlinedButton(onClick = { enteredValue.value=tf.value }) {
            Text(text = "Submit")
        }
    }
}