package com.proway.project_four.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    //ele fica vaziu porque o hilt consegue mapear por debaixo dos panos automaticamente
    override fun onCreate() {
        super.onCreate()


    }
}