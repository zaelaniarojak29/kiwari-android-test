package com.example.kiwarichattest.ui.login


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kiwarichattest.MainActivity
import com.example.kiwarichattest.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity :  AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener {
            val email = etUser.text.toString()
            val password = etPassword.text.toString()

            if (email.isEmpty()|| password.isEmpty()) {
                Toast.makeText(this, "Please Insert Email and Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(email == "ismail@mail.com" || password == "123456"){
                finish()

                val intent = Intent (this,MainActivity::class.java)
                startActivity(intent)
            }
            if(email == "jarjit@mail.com" || password == "123456"){
                finish()

            val intent = Intent (this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
}
