package com.pepivsky.users

import com.pepivsky.users.model.UserResponseItem
import retrofit2.http.GET

interface GetUsersClient {
    @GET("users")
    suspend fun getUsers(): List<UserResponseItem>
}