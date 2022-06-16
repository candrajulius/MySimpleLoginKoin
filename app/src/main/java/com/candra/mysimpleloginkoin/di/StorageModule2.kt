package com.candra.mysimpleloginkoin.di

import android.content.Context
import com.candra.core.SessionManager
import dagger.Module
import dagger.Provides

@Module
class StorageModule2 {
    @Provides
    fun provideSessionManager(context: Context): SessionManager = SessionManager((context))
}

/*
Kesumpulan
Untuk membuat module perlu annotation @Module. Jika tidak, maka akan muncul eror @Provides methods can only be present within a @Module.
Untuk membuat fungsi untuk inisialisasi perlu annotation @Provides. Jika tidak, maka akan muncul eror MissingBinding SessionManager.
Nama fungsi tidak berpengaruh, boleh apa pun, yang penting nilai kembaliannya.
Jika Anda membutuhkan Context, Anda cukup menambahkan @BindsInstance pada Component nantinya.
 */