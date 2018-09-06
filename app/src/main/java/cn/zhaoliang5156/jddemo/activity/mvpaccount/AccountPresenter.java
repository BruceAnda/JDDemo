package cn.zhaoliang5156.jddemo.activity.mvpaccount;

/**
 * 账户Presenter层 需要持有账户View和账户Model
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/5
 */
public class AccountPresenter {

    //View的引用
    private AccountView view;
    //Model的引用
    private AccountModel model;

    public AccountPresenter(AccountView view) {
        this.view = view;
        model = new AccountModel();
    }

    /**
     * 注册
     *
     * @param mobile
     * @param password
     */
    public void reg(String mobile, String password) {
        // 需要调用Model层注册
        model.reg(mobile, password, new AccountModel.AccountCallback() {
            @Override
            public void onSuccess() {
                // 注册成功或失败 通知view刷新UI
                view.showSuccess("注册成功");
            }

            @Override
            public void onError(String errorMsg) {
                view.showError("注册失败");
            }
        });
    }

    /**
     * 登录
     *
     * @param mobile
     * @param password
     */
    public void login(String mobile, String password) {
        // 需要调用Model层登录
        model.login(mobile, password, new AccountModel.AccountCallback() {
            @Override
            public void onSuccess() {
                // 登录成功或失败 通知view刷新UI
                view.showSuccess("登录成功");

            }

            @Override
            public void onError(String errorMsg) {
                view.showError("登录失败");
            }
        });
    }
}
