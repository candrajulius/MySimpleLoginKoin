package com.candra.mysimpleloginkoin

class UserRepository(private val sesi: SessionManager)
{
    companion object{
        @Volatile
        private var instance: UserRepository? = null

        fun getInstance(sesi: SessionManager): UserRepository =
            instance ?: synchronized(this){
                instance ?: UserRepository(sesi)
            }
    }

    fun getUser() = sesi.getFromPreference(SessionManager.KEY_USERNAME)

    fun isUserLogin() = sesi.isLogin

    fun loginUser(username: String){
        sesi.createLoginSession()
        sesi.saveToPreference(SessionManager.KEY_USERNAME,username)
    }

    fun logoutUser() = sesi.logout()
}