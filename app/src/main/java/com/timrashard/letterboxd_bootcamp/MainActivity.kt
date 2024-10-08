package com.timrashard.letterboxd_bootcamp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.timrashard.letterboxd_bootcamp.presentation.screens.popular.PopularScreen
import com.timrashard.letterboxd_bootcamp.ui.theme.Letterboxd_BootcampTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Letterboxd_BootcampTheme {
                PopularScreen()
            }
        }
    }
}