package com.pepivsky.users.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pepivsky.users.domain.use_case.GetUsersUseCase
import com.pepivsky.users.model.response.UserResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class UsersScreenViewModel @Inject constructor(private val getUsersUseCase: GetUsersUseCase): ViewModel(){

    val users = mutableStateListOf<UserResponseItem>()
    var homeUiState: HomeUiState by  mutableStateOf(HomeUiState.Loading)
    init {
        Log.d("pp", "init call")
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            Log.d("pp", "init call")

            homeUiState = try {
                val result = getUsersUseCase.getUsers()
                Log.d("pp", "get JSON $result")
                users.clear()
                users.addAll(result)
                HomeUiState.Success
            } catch (e: IOException) {
                Log.d("pp", "errorcito ${e.message}")
                HomeUiState.Error
            }
        }
    }
}

sealed interface HomeUiState {
    object Success: HomeUiState
    object Loading : HomeUiState
    object Error : HomeUiState
}