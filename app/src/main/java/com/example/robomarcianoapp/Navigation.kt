package com.example.robomarcianoapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.robomarcianoapp.screens.HistoryScreen
import com.example.robomarcianoapp.screens.MainScreen
import com.example.robomarcianoapp.screens.MathScreen
import com.example.robomarcianoapp.screens.ResponseScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "main"
    ) {

        composable("main") {

            MainScreen(navController)

        }

        composable("history") {
            HistoryScreen(navController)
        }

        composable("math") {
            MathScreen(navController)
        }

        composable(
            route = "response/{message}",
            arguments = listOf(
                navArgument("message") {
                    type = NavType.StringType
                }
            )
        ) {

            val message =
                it.arguments?.getString("message") ?: ""

            ResponseScreen(
                message = message,
                navController = navController
            )

        }
    }
}