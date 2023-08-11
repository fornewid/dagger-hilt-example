package io.github.fornewid.feature.navigation.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExampleNavigationComposeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                colors = if (isSystemInDarkTheme()) {
                    darkColors()
                } else {
                    lightColors()
                }
            ) {
                ExampleNavGraph()
            }
        }
    }
}
