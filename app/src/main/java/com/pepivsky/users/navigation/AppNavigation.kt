package com.pepivsky.users.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pepivsky.users.presentation.UsersScreenViewModel
import com.pepivsky.users.screens.UserDetailScreen
import com.pepivsky.users.screens.UsersScreen

@Composable
fun AppNavigation(viewModel: UsersScreenViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.UsersScreen.route) {
        composable(route = AppScreens.UsersScreen.route) {
            UsersScreen(
                viewModel = viewModel,
                navController = navController
            )
        }
        composable(
            route = AppScreens.DetailScreen.route,
            arguments = listOf(navArgument(name = AppScreens.DetailScreen.param) {
                type = NavType.IntType
            })
        ) {
            UserDetailScreen(
                viewModel = viewModel,
                navController = navController,
                id = it.arguments?.getInt(AppScreens.DetailScreen.param) ?: 0
            )
        }
    }
}