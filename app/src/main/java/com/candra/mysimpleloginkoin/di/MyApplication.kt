package com.candra.mysimpleloginkoin.di

import android.app.Application

open class MyApplication: Application()
{
    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(
            applicationContext
        )
    }
}