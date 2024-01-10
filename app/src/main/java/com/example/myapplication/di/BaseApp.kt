package com.example.myapplication.di

import android.app.Application
import android.content.Context
import androidx.hilt.work.HiltWorkerFactory
import dagger.hilt.android.HiltAndroidApp

import javax.inject.Inject

@HiltAndroidApp
class BaseApp : Application(){

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    companion object {
        private lateinit var appContext: Context
        fun getContext(): Context {
            return appContext
        }
    }

}