package com.leonardo.study.login.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.leonardo.study.login.R
import com.leonardo.study.login.user.register.RegisterActivity
import com.leonardo.study.login.user.UserDatabase
import com.leonardo.study.login.user.UserRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainViewInterface {

    //Presenter Reference
    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Injecao de dependencias
        val userDao = UserDatabase.getInstance(this)!!.userDao();
        val userRepository = UserRepository(userDao)
        val mainInteractor = MainInteractor(userRepository)
        mainPresenter = MainPresenter(this, mainInteractor)

        login.setOnClickListener{
            var typedUserName = username.text.toString()
            var typedPassword = password.text.toString()
            mainPresenter.doLogin(typedUserName, typedPassword)
        }

        register.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent);
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
