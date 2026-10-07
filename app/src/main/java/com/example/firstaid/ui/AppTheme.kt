package com.example.firstaid.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/** One place for every colour in the app. */
object Brand {
    val Red = Color(0xFFC62828)
    val RedDark = Color(0xFF8E0000)
    val RedSoft = Color(0xFFFDECEC)
    val Green = Color(0xFF1B7F3B)
    val GreenSoft = Color(0xFFE8F5EC)
    val Amber = Color(0xFF8A5A00)
    val AmberSoft = Color(0xFFFFF4DC)
    val Page = Color(0xFFF4F5F7)
    val Card = Color.White
    val Border = Color(0xFFDDE0E4)
    val Ink = Color(0xFF1B1F23)
    val InkSoft = Color(0xFF5A6169)
}

/** Always light and high-contrast, so it is readable in stress and sunlight. */
@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Brand.Red,
            onPrimary = Color.White,
            background = Brand.Page,
            onBackground = Brand.Ink,
            surface = Brand.Card,
            onSurface = Brand.Ink,
            outline = Brand.Border
        ),
        content = content
    )
}