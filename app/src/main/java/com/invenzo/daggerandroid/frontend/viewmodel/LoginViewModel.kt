package com.invenzo.daggerandroid.frontend.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.invenzo.daggerandroid.frontend.repository.AuthRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    fun onEmailChange(newEmail: String) {
        email = newEmail
    }

    fun onPasswordChange(newPassword: String) {
        password = newPassword
    }

    fun onLoginClicked() {
        repository.login(email, password)
    }
}