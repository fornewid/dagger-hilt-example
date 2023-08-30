package io.github.fornewid.feature.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

@Composable
fun ExampleNavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "example",
    ) {
        composable(route = "example") {
            ExampleScreen(
                screenName = "example",
                viewModel = hiltViewModel(),
                onClick = {
                    navController.navigate(route = "example_navigation")
                },
            )
        }
        navigation(
            route = "example_navigation",
            startDestination = "nested_example1",
        ) {
            composable(route = "nested_example1") {
                val parent = remember(it) {
                    navController.getBackStackEntry("example_navigation")
                }
                ExampleScreen(
                    screenName = "nested_example1",
                    viewModel = hiltViewModel(parent),
                    onClick = {
                        navController.navigate("nested_example2")
                    },
                )
            }
            composable(route = "nested_example2") {
                val parent = remember(it) {
                    navController.getBackStackEntry("example_navigation")
                }
                ExampleScreen(
                    screenName = "nested_example2",
                    viewModel = hiltViewModel(parent),
                )
            }
        }
    }
}
