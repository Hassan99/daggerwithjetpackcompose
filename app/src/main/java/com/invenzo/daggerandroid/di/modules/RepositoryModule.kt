package com.invenzo.daggerandroid.di.modules

import com.invenzo.daggerandroid.frontend.repository.AuthRepository
import com.invenzo.daggerandroid.retrofit.ApiService
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideAuthRepository(apiService: ApiService): AuthRepository {
        return AuthRepository(apiService)
    }
}