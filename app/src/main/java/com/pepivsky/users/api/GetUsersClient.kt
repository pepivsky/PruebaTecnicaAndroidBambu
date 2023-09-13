package com.pepivsky.users.api

import com.pepivsky.users.model.response.UserResponseItem
import retrofit2.http.GET

interface GetUsersClient {
    @GET("users")
    suspend fun getUsers(): List<UserResponseItem>
}