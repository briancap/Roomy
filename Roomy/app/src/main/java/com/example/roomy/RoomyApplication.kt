package com.example.roomy

import android.app.Application
import timber.log.Timber

class RoomyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant( Timber.DebugTree() )
    }
}