package com.pepivsky.users.domain.repository

import com.pepivsky.users.domain.service.GetUsersService
import com.pepivsky.users.model.response.UserResponseItem
import javax.inject.Inject

class GetUsersRepository @Inject constructor(private val api: GetUsersService) {
    suspend fun getUsers(): List<UserResponseItem> {
        return api.getUsers()
    }
}