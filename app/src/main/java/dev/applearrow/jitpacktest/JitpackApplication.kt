package dev.applearrow.jitpacktest

import android.app.Application
import timber.log.Timber

class JitpackApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}