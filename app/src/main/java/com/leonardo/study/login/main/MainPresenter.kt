package com.leonardo.study.login.main

import android.os.Handler
import java.lang.Thread.sleep


class MainPresenter(private var mainView: MainViewInterface?, private val mainInteractor: MainInteractor){
    //TODO Como fazer isso rodar na thred?
    fun doLogin(username: String, password: String){
        when {
            username.isEmpty() -> mainView?.showValidation("The username must be filled up")
            password.isEmpty() -> mainView?.showValidation("The password must be filled up")
            else -> {
                val handler = Handler()
                Thread {
                    handler.post {mainView?.showLoader()}
                    sleep(2000)
                    if(!mainInteractor.validadeUserPassword(username, password)) {
                        handler.post {mainView?.showValidation("Wrong username our/and password")}
                    }
                    handler.post {mainView?.hideLoader()}
                }.start()
            }
        }
    }
}