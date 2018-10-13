package com.leonardo.study.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainPresenter = MainPresenter(this)

        val btn = findViewById<Button>(R.id.login)

        // referencias para as views
        var username = findViewById<EditText>(R.id.username)
        var password = findViewById<EditText>(R.id.password)

        btn.setOnClickListener{
            val typedUserName = username.text.toString()
            val typedPassword = password.text.toString()
            mainPresenter.doLogin(typedUserName, typedPassword)
        }
    }



}
