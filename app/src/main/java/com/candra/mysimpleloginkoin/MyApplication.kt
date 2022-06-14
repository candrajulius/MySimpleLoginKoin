package com.candra.mysimpleloginkoin

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(storageModule)
        }
    }
}

// Kesimpulan
/*
startKoin di dalam custom application berguna untuk membuat Koin melakukan injection di semua turunan application, seperti Activity dan Fragment. Jika tidak ada kode ini akan muncul eror No Koin Context configured.
androidContext berguna untuk mem-provide fungsi yang membutuhkan context. Jika tidak maka akan muncul eror NoBeanDefFoundException: No definition found for class:'android.content.Context'.
modules berguna untuk menambahkan module di dalam Koin. Jika tidak ada maka akan muncul eror NoBeanDefFoundException pada komponen yang dipanggil pertama kali.
 */