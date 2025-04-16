package com.invenzo.daggerandroid.retrofit

import com.invenzo.daggerandroid.model.LoginRequest
import com.invenzo.daggerandroid.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>
}