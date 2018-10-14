package com.leonardo.study.login

import android.os.Handler
import java.lang.Thread.sleep

class LoginInteractor {
    fun validateUserPassword(username: String, password: String, callback: (Boolean) -> (Unit)){
        val handler = Handler()
        Thread {
            sleep(2000)
            val success = username == "picole" && password == "chuchu"
            handler.post { callback.invoke(success) }
        }.start()
    }
}