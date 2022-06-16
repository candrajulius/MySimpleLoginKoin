package com.candra.core

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val sesi: SessionManager)
{
    fun getUser() = sesi.getFromPreference(SessionManager.KEY_USERNAME)

    fun isUserLogin() = sesi.isLogin

    fun loginUser(username: String){
        sesi.createLoginSession()
        sesi.saveToPreference(SessionManager.KEY_USERNAME,username)
    }

    fun logoutUser() = sesi.logout()

    fun checkInstance() = Log.d("Singleton", "checkInstance: $this")
}

/*
Kesimpulan
Karena UserRepository hanya membutuhkan SessionManager — dan ingat bahwa SessionManager sudah kita provide di dalam module —, maka Anda dapat menggunakan Injection pada constructor. Caranya yaitu dengan menambahkan @Inject constructor. Jika tidak ditambahkan, maka akan muncul eror MissingBinding UserRepository.

Sudah tidak ada lagi fungsi getInstance. Anda cukup menambahkan annotation @Singleton.

Jangan lupa untuk menambahkan annotation @Singleton pada Component juga.
 */