package com.invenzo.daggerandroid.repository

import com.invenzo.daggerandroid.retrofit.ApiService
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val apiService: ApiService
) {
    fun login(email: String, password: String) {
        // Logic here
    }
}