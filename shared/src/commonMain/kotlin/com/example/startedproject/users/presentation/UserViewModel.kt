package com.example.startedproject.users.presentation

import com.example.startedproject.BaseViewModel
import com.example.startedproject.users.domain.User
import com.example.startedproject.users.domain.UserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(
    private val useCase: UserUseCase
) : BaseViewModel() {

    private val _usersState: MutableStateFlow<UserState> =
        MutableStateFlow(UserState(loading = true))
    val usersState: StateFlow<UserState> get() = _usersState

    private val _selectedUser: MutableStateFlow<User?> = MutableStateFlow(null)
    val selectedUser: StateFlow<User?> = _selectedUser

    init {
        getUsers()
    }

    fun getUsers() {
        scope.launch {
            _usersState.emit(
                UserState(
                    loading = true
                )
            )

            val fetchedUsers = useCase.getUsers()

            _usersState.emit(UserState(users = fetchedUsers))
        }
    }

    fun selectUser(user: User) {
        scope.launch {
            _selectedUser.emit(user)
        }
    }
}