package com.candra.mysimpleloginkoin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.candra.core.UserRepository
import com.candra.mysimpleloginkoin.databinding.ActivityMainBinding
import com.candra.mysimpleloginkoin.di.MyApplication
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var userRepository: UserRepository

    @Inject
    lateinit var userRepository2: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (userRepository.isUserLogin()){
            moveToHomeActivity()
        }
        binding.btnLogin.setOnClickListener {
            saveSession()
        }
        userRepository.checkInstance()
        userRepository2.checkInstance()
    }

    private fun saveSession() {
        userRepository.loginUser(binding.edUsername.text.toString())
        moveToHomeActivity()
    }

    private fun moveToHomeActivity(){
        startActivity(Intent(this@MainActivity,HomeActivity::class.java))
        finish()
    }
}
/*
Sudah tidak ada lagi kode untuk inisialisasi Objek di sini. Anda cukup menambahkan Annotation @Inject pada field yang ingin di-inject. Keren kan! Jangan lupa untuk meng-inject component sebelum super.onCreate terlebih dahulu.

Memanggil Activity pada Module Lain
Perhatikanlah kode berikut pada kelas MainActivity:

startActivity(Intent(this, Class.forName("com.dicoding.home.HomeActivity")))
 Karena antara module tidak tersambung, Anda perlu menuliskan nama Activity secara manual seperti berikut. Sebenarnya ada cara lain untuk memanggil Activity lain, namun kita akan mengulasnya pada modul berikutnya. Jadi tetap stay-tuned ya!

 */