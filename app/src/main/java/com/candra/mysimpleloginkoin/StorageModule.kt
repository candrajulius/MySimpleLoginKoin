package com.candra.mysimpleloginkoin

import org.koin.dsl.module


val storageModule = module {
    factory {
        SessionManager(get())
    }

    single {
        UserRepository(get())
    }
}

/*
Kesimpulan
 Untuk membuat module perlu menggunakan fungsi module
 Untuk membuat objek perlu menggunakan fungsi factory
 Untuk membuat objek dengan jenis singleton perlu menggunakan fungsi single
Jika parameter untuk membuat objek tersebut sudah di-provide, maka Anda bisa menggunakan get(). Jika Anda menulis get() namun belum ada fungsi yang mem-provide objek tersebut maka akan muncul eror Could not create instance for ....
 */
