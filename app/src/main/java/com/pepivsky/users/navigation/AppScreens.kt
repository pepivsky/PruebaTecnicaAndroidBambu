package com.pepivsky.users.navigation

sealed class AppScreens(val route: String) {
    object UsersScreen: AppScreens("users_screen")
    object DetailScreen: AppScreens("detail_screen")

}
