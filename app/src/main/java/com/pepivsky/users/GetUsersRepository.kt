package com.pepivsky.users

import com.pepivsky.users.model.UserResponseItem
import javax.inject.Inject

class GetUsersRepository @Inject constructor(private val api: GetUsersService) {
    suspend fun getUsers(): List<UserResponseItem> {
        return api.getUsers()
    }
}