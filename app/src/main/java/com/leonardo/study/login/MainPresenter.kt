package com.leonardo.study.login

class MainPresenter(private var mainView: MainViewInterface?){
    private var mainInteractor = MainInteractor()
    fun doLogin(username: String, password: String){

        when {
            username.isEmpty() -> mainView?.showValidation("The username must be filled up")
            password.isEmpty() -> mainView?.showValidation("The password must be filled up")
            else -> {
                if(mainInteractor.validadeUserPassword(username, password)) {
                    mainView?.showLoader()
                } else {
                    mainView?.showValidation("Wrong username our/and password")
                }
            }
        }
    }
}