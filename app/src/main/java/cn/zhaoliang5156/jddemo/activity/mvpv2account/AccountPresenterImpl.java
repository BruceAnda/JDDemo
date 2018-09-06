package cn.zhaoliang5156.jddemo.activity.mvpv2account;

import cn.zhaoliang5156.jddemo.activity.base.MVPCallback;

/**
 * 账户Presenter的实现
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/5
 */
public class AccountPresenterImpl extends AccountContract.Presenter {

    private AccountModel model;

    public AccountPresenterImpl() {
        model = new AccountModel();
    }

    @Override
    void login(String mobile, String password) {
        getView().showLoading();
        model.login(mobile, password, new MVPCallback<String>() {
            @Override
            public void onSuccess(String data) {
                getView().showData(data);
            }

            @Override
            public void onError() {

            }

            @Override
            public void onComplete() {
                getView().hideLoading();
            }
        });
    }

    @Override
    void reg(String mobile, String password) {
        if (isViewAttach()) {
            getView().showLoading();
        }
        model.reg(mobile, password, new MVPCallback<String>() {
            @Override
            public void onSuccess(String data) {
                getView().showData(data);
            }

            @Override
            public void onError() {

            }

            @Override
            public void onComplete() {
                getView().hideLoading();
            }
        });
    }
}
