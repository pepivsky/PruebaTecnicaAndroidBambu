package com.pepivsky.users.domain.service

import com.pepivsky.users.api.GetUsersClient
import com.pepivsky.users.model.response.UserResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class GetUsersService @Inject constructor(private val retrofit: Retrofit) {
    suspend fun getUsers(): List<UserResponseItem> {
        return withContext(Dispatchers.IO) {
            retrofit.create(GetUsersClient::class.java).getUsers()

        }
    }
}