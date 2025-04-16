package com.invenzo.daggerandroid.di.component

import com.invenzo.daggerandroid.activity.LoginActivity
import com.invenzo.daggerandroid.di.modules.NetworkModule
import com.invenzo.daggerandroid.di.modules.RepositoryModule
import com.invenzo.daggerandroid.di.modules.ViewModelModule
import dagger.Component

@Component(
    modules = [
        NetworkModule::class,
        RepositoryModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {
    fun inject(activity: LoginActivity)
}