package com.kotlincoroutines.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kotlincoroutines.home.Home
import com.kotlincoroutines.core.navigation.Routes

@Composable
fun App(modifier: Modifier = Modifier) {
    val navHostController = rememberNavController()
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Routes.Home,
    ) {
        composable<Routes.Home> {
            Home(navController = navHostController)
        }
        composable("") {

        }
    }
}

@Preview
@Composable
private fun AppPreview() {
    App()
}