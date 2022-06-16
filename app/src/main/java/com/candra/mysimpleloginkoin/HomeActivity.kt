package com.candra.mysimpleloginkoin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.candra.core.UserRepository
import com.candra.mysimpleloginkoin.databinding.HomeActivityBinding
import com.candra.mysimpleloginkoin.di.MyApplication
import javax.inject.Inject

@SuppressLint("SetTextI18n")
class HomeActivity: AppCompatActivity()
{
    lateinit var binding: HomeActivityBinding

    @Inject
    lateinit var userRepository: UserRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.inject(this)
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