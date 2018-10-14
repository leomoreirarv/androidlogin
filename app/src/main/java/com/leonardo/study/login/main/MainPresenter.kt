package com.leonardo.study.login.main

class MainPresenter(private var mainView: MainViewInterface?){
    private var mainInteractor = MainInteractor()
    //TODO Como fazer isso rodar na thred?
    fun doLogin(username: String, password: String){
        when {
            username.isEmpty() -> mainView?.showValidation("The username must be filled up")
            password.isEmpty() -> mainView?.showValidation("The password must be filled up")
            else -> {
                if(!mainInteractor.validadeUserPassword(username, password)) {
                    mainView?.showValidation("Wrong username our/and password")
                }
            }
        }
    }
}