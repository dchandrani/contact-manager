package com.app.contactmanager.di

import com.app.contactmanager.data.RepositoryImpl
import com.app.contactmanager.data.remote.ApiService
import com.app.contactmanager.ui.home.HomeViewModel
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { RepositoryImpl(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
}