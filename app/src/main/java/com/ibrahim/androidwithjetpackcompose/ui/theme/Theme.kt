package com.ibrahim.androidwithjetpackcompose.ui.theme

import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ibrahim.androidwithjetpackcompose.ui.theme.viewmodel.ThemeViewModel

private val LocalColors = staticCompositionLocalOf { LightColorPalette }

@Composable
fun AndroidWithJetpackComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,

) {

    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    CompositionLocalProvider(LocalColors provides LightColorPalette) {
        MaterialTheme(
            colors = colors.material,
            typography = Typography,
            shapes = Shapes,
            content = content,

        )
    }

}
val MaterialTheme.extendedColors: AllColors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current