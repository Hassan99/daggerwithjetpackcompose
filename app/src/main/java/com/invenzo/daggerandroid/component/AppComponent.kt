package com.invenzo.daggerandroid.component

import com.invenzo.daggerandroid.activity.LoginActivity
import com.invenzo.daggerandroid.modules.NetworkModule
import com.invenzo.daggerandroid.modules.RepositoryModule
import com.invenzo.daggerandroid.modules.ViewModelModule
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