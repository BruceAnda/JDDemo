package cn.zhaoliang5156.jddemo.activity.login;

import cn.zhaoliang5156.jddemo.activity.exception.NetExcetion;

public class LoginPresenter {

    LoginModel loginModel;

    void login() {
        try {
            loginModel.login();
        } catch (NetExcetion netExcetion) {
            netExcetion.printStackTrace();
        }
    }
}
