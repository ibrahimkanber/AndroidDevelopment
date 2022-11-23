package com.ibrahim.androidwithjetpackcompose.ui.theme

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF000FF9)
val StatusBar = Color(0xFFBF7100)
val Primary = Color(0xFFFF9801)

val MaterialDarkColorPalette = darkColors(
    primary = Primary,
    primaryVariant = Purple700,
    secondary = Teal200
)

val MaterialLightColorPalette = lightColors(
    primary = Primary,
    primaryVariant = Purple700,
    secondary = Teal200
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

data class AllColors(
    val material: Colors,
    val warning: Color,
    val onWarning: Color,
) {
    val primary: Color get() = material.primary
    val primaryVariant: Color get() = material.primaryVariant
    val secondary: Color get() = material.secondary
    val secondaryVariant: Color get() = material.secondaryVariant
    val background: Color get() = material.background
    val surface: Color get() = material.surface
    val error: Color get() = material.error
    val onPrimary: Color get() = material.onPrimary
    val onSecondary: Color get() = material.onSecondary
    val onBackground: Color get() = material.onBackground
    val onSurface: Color get() = material.onSurface
    val onError: Color get() = material.onError
    val isLight: Boolean get() = material.isLight
    val statusBar= StatusBar
}

val LightColorPalette = AllColors(
    material = MaterialLightColorPalette,
    warning = Color.Cyan,
    onWarning = Color.Black,
)

val DarkColorPalette = AllColors(
    material = MaterialDarkColorPalette,
    warning =  Color.Cyan,
    onWarning = Color.White,
)