package com.app.contactmanager

import android.app.Application
import com.app.contactmanager.di.networkModule
import com.app.contactmanager.di.repositoryModule
import com.app.contactmanager.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ContactManagerApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(networkModule, repositoryModule, viewModelModule))
            androidContext(this@ContactManagerApplication)
        }
    }
}