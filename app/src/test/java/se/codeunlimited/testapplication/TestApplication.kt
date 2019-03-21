package se.codeunlimited.testapplication

import android.app.Application

/**
 * This application is only used for Robolectric tests
 */
class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setTheme(R.style.Theme_AppCompat)
    }
}