package me.brunofelix.pmovie.core.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import me.brunofelix.pmovie.core.presentation.ui.theme.PMovieTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PMovieTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = "PMovie",
                        modifier = Modifier.padding(it)
                    )
                }
            }
        }
    }
}