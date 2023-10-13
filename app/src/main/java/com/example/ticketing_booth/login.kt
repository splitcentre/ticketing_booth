package com.example.ticketing_booth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import com.example.ticketing_booth.databinding.ActivityLoginBinding

class login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    companion object{
        const val EXTRA_NAME="extra_name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener{
            val username=binding.usernameEditText.text.toString()
            val intent=Intent(this@login,MainActivity::class.java)
            intent.putExtra(EXTRA_NAME,username)
            startActivity(intent)
        }
    }
}