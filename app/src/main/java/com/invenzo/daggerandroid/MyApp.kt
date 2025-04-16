package com.invenzo.daggerandroid

import android.app.Application
import com.invenzo.daggerandroid.di.component.AppComponent
import com.invenzo.daggerandroid.di.component.DaggerAppComponent
import com.invenzo.daggerandroid.di.modules.NetworkModule
import com.invenzo.daggerandroid.di.modules.RepositoryModule

class MyApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .repositoryModule(RepositoryModule())
            .build()
    }
}