package com.leonardo.study.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast

class MainActivity : AppCompatActivity(), MainViewInterface {

    //Presenter Reference
    private lateinit var mainPresenter: MainPresenter

    // Views
    private lateinit var progressbar: ProgressBar
    private lateinit var username: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        mainPresenter = MainPresenter(this, LoginInteractor())
    }

    private fun initViews() {
        //View reference
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        progressbar = findViewById(R.id.progressbar)

        findViewById<Button>(R.id.login).setOnClickListener {
            performLogin()
        }
    }

    private fun performLogin() {
        val typedUserName = username.text.toString()
        val typedPassword = password.text.toString()
        mainPresenter.doLogin(typedUserName, typedPassword)
    }

    // View callbacks
    override fun showLoader() {
        progressbar.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        progressbar.visibility = View.GONE
    }

    override fun showLoginSuccess() {
        showMessage(getString(R.string.login_success))
    }

    override fun showLoginFailure() {
        showMessage(getString(R.string.login_error))
    }

    private fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
