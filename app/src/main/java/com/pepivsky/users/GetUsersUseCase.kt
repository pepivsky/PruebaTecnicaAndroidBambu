package com.pepivsky.users

import com.pepivsky.users.model.UserResponseItem
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val repository: GetUsersRepository) {
    suspend fun getUsers(): List<UserResponseItem> {
        return repository.getUsers()
    }
}