package com.invenzo.daggerandroid.model

data class LoginRequest(
    val email: String,
    val password: String
)
data class LoginResponse(
    val token: String,
    val userId: String,
    val name: String,
    val email: String
)