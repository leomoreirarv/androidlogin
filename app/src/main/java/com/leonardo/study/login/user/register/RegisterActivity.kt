package com.leonardo.study.login.user.register

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.widget.Toast
import com.leonardo.study.login.R
import com.leonardo.study.login.util.AfterTextChangedListener
import com.leonardo.study.login.util.RegisterValidator
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterViewInterface {

    private lateinit var presenter: RegisterPresenter
    private lateinit var formItemsValidation: Array<Boolean>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        presenter = RegisterPresenter(this, RegisterValidator())
        initViews()
        initFormItens()
    }

    private fun initFormItens(){
    }

    private fun initViews() {
        name.addTextChangedListener(object : AfterTextChangedListener {
            override fun afterTextChanged(text: Editable) {
                presenter.validateName(text.toString())
            }
        })

        username.addTextChangedListener(object : AfterTextChangedListener {
            override fun afterTextChanged(text: Editable) {
                presenter.validateUsername(text.toString())
            }
        })

        password.addTextChangedListener(object : AfterTextChangedListener {
            override fun afterTextChanged(text: Editable) {
                presenter.validatePassword(text.toString())
            }
        })

        repassword.addTextChangedListener(object : AfterTextChangedListener {
            override fun afterTextChanged(text: Editable) {
                presenter.validateRepassword(password.text.toString(), text.toString())
            }
        })

        btnregister.setOnClickListener {
            presenter.validateForm()
        }
    }

    override fun showInvalidName() {
        name.error = getString(R.string.invalid_name)
    }

    override fun showInvalidUsername() {
        username.error = getString(R.string.invalid_username)
    }

    override fun showInvalidPassword() {
        password.error = getString(R.string.invalid_password)
    }

    override fun showInvalidRepassword() {
        repassword.error = getString(R.string.invalid_repassword)
    }

    override fun showValidInsertion() {
    }

    override fun showInvalidInsertion() {
    }

    override fun showInvalidForm() {
        Toast.makeText(this, R.string.invalid_form, Toast.LENGTH_SHORT).show()
    }
}




