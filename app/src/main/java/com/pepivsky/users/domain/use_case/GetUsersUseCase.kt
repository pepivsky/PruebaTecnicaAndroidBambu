package com.pepivsky.users.domain.use_case

import com.pepivsky.users.domain.repository.GetUsersRepository
import com.pepivsky.users.model.response.UserResponseItem
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val repository: GetUsersRepository) {
    suspend fun getUsers(): List<UserResponseItem> {
        return repository.getUsers()
    }
}