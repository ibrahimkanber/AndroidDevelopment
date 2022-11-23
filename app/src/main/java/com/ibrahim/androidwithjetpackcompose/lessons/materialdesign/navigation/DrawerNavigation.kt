package com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.navigation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ibrahim.androidwithjetpackcompose.lessons.materialdesign.navigation.MenuItem

@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 64.dp),
        contentAlignment = Alignment.Center

    ) {
        Text(text = "Header", fontSize = 60.sp)
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier,
    itemTextStyle: TextStyle=TextStyle(fontSize = 20.sp),
    onItemClick: (MenuItem) -> Unit

) {
    LazyColumn(modifier) {
        items(items) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(it) }
                    .padding(16.dp)
            ) {
                Icon(imageVector = it.icon, contentDescription = it.contentDescription)
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = it.title,
                    modifier = Modifier.weight(1f),
                    style = itemTextStyle
                )
            }
        }
    }
}
