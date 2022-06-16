package com.candra.mysimpleloginkoin

import com.candra.core.UserRepository
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.core.inject

class MainActivityTest: KoinTest {
    private val userRepository: UserRepository by inject()
    private val username = "candra"

    @Before
    fun before(){
        loadKoinModules(storageModule)
        userRepository.loginUser(username)
    }

    @After
    fun after(){
        stopKoin()
    }

    @Test
    fun getUsernameFromRepository(){
        val requestedUsername = userRepository.getUser()
        assertEquals(username,requestedUsername)
    }

    /*
    Kesimpulan
    Untuk melakukan Testing pada Koin Anda perlu memanggil module pada koin dengan menggunakan loadKoinModules. Dan jika testing sudah usai Anda dapat menutupnya dengan menggunakan stopKoin.
     */

}