package com.leonardo.study.login

import android.app.Application
import com.facebook.stetho.Stetho

class StudyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}