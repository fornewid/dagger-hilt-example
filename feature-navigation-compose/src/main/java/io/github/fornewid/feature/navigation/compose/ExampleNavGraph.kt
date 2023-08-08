package io.github.fornewid.feature.navigation.compose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ExampleNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "example",
    ) {
        composable(route = "example") {
            ExampleScreen()
        }
    }
}
