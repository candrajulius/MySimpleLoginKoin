package com.candra.mysimpleloginkoin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.candra.mysimpleloginkoin.databinding.HomeActivityBinding
import org.koin.android.ext.android.inject

@SuppressLint("SetTextI18n")
class HomeActivity: AppCompatActivity()
{
    lateinit var binding: HomeActivityBinding
    private val userRepository: UserRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvWelcome.text = "Welcome ${userRepository.getUser()}"

        binding.btnLogout.setOnClickListener {
            userRepository.logoutUser()
            moveToMainActivity()
        }
    }

    private fun moveToMainActivity(){
        startActivity(Intent(this@HomeActivity,MainActivity::class.java))
        finish()
    }
}