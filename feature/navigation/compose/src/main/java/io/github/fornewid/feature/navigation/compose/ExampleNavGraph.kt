package io.github.fornewid.feature.navigation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController

@Composable
fun ExampleNavGraph(viewModelFactory: ViewModelProvider.Factory) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "example",
    ) {
        composable(route = "example") {
            ExampleScreen(
                screenName = "example",
                viewModel = viewModel(factory = viewModelFactory),
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
                    viewModel = viewModel(viewModelStoreOwner = parent, factory = viewModelFactory),
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
                    viewModel = viewModel(viewModelStoreOwner = parent, factory = viewModelFactory),
                )
            }
        }
    }
}
