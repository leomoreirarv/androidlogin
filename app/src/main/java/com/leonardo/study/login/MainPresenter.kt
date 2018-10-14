package com.leonardo.study.login

class MainPresenter(
    private val mainView: MainViewInterface?,
    private val loginInteractor: LoginInteractor
) {

    fun doLogin(username: String, password: String) {
        mainView?.showLoader()
        loginInteractor.validateUserPassword(username, password) { success ->
            mainView?.hideLoader()
            if (success)
                mainView?.showLoginSuccess()
            else
                mainView?.showLoginFailure()
        }
    }
}