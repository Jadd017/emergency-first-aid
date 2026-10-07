package com.example.firstaid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.firstaid.data.Emergency
import com.example.firstaid.logic.MatchOutcome
import com.example.firstaid.logic.Matcher
import com.example.firstaid.ui.AllScreen
import com.example.firstaid.ui.AppTheme
import com.example.firstaid.ui.ChooseScreen
import com.example.firstaid.ui.HomeScreen
import com.example.firstaid.ui.NoMatchScreen
import com.example.firstaid.ui.ResultScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                FirstAidApp()
            }
        }
    }
}

/** Simple screen state, no navigation library needed. */
sealed class Screen {
    data object Home : Screen()
    data object All : Screen()
    data object NoMatch : Screen()
    data class Result(val emergency: Emergency) : Screen()
    data class Choose(val options: List<Emergency>) : Screen()
}

@Composable
fun FirstAidApp() {
    var screen by remember { mutableStateOf<Screen>(Screen.Home) }

    BackHandler(enabled = screen !is Screen.Home) { screen = Screen.Home }

    val goHome = { screen = Screen.Home }
    val open = { e: Emergency -> screen = Screen.Result(e) }

    Surface(Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        Box(Modifier.fillMaxSize().safeDrawingPadding()) {
            when (val s = screen) {
                Screen.Home -> HomeScreen(
                    onSend = { text ->
                        screen = when (val r = Matcher.match(text)) {
                            is MatchOutcome.Single -> Screen.Result(r.emergency)
                            is MatchOutcome.Close -> Screen.Choose(r.options)
                            MatchOutcome.None -> Screen.NoMatch
                        }
                    },
                    onPick = open,
                    onShowAll = { screen = Screen.All }
                )
                Screen.All -> AllScreen(onPick = open, onBack = goHome)
                Screen.NoMatch -> NoMatchScreen(onPick = open, onBack = goHome)
                is Screen.Result -> ResultScreen(s.emergency, onBack = goHome)
                is Screen.Choose -> ChooseScreen(s.options, onPick = open, onBack = goHome)
            }
        }
    }
}