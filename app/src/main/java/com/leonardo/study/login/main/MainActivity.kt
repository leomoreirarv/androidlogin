package com.leonardo.study.login.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.leonardo.study.login.R
import com.leonardo.study.login.user.User
import com.leonardo.study.login.user.UserDAO
import com.leonardo.study.login.user.UserDatabase
import com.leonardo.study.login.user.UserRepository

class MainActivity : AppCompatActivity(), MainViewInterface {

    //Presenter Reference
    private lateinit var mainPresenter: MainPresenter
    private lateinit var progressbar: ProgressBar
    private lateinit var btn: Button
    private lateinit var username: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Injecao de dependencias
        val userDao = UserDatabase.getInstance(this)!!.userDao();
        val userRepository = UserRepository(userDao)
        val mainInteractor = MainInteractor(userRepository)
        mainPresenter = MainPresenter(this, mainInteractor)

        //View elements reference
        btn = findViewById<Button>(R.id.login)
        username = findViewById<EditText>(R.id.username)
        password = findViewById<EditText>(R.id.password)
        progressbar = findViewById<ProgressBar>(R.id.progressbar)

        btn.setOnClickListener{
            var typedUserName = username.text.toString()
            var typedPassword = password.text.toString()
            mainPresenter.doLogin(typedUserName, typedPassword)
        }
    }

    override fun showLoader(){
        progressbar.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        progressbar.visibility = View.GONE
    }

    override fun showValidation(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }


}
