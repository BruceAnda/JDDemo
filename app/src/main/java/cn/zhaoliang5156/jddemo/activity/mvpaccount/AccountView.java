package cn.zhaoliang5156.jddemo.activity.mvpaccount;

/**
 * 账户View
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/5
 */
public interface AccountView {
    void showSuccess(String msg);

    void showError(String msg);
}
