package cn.zhaoliang5156.jddemo.activity.mvpv2account;

import cn.zhaoliang5156.jddemo.activity.base.IBaseModel;
import cn.zhaoliang5156.jddemo.activity.base.IBasePresenter;
import cn.zhaoliang5156.jddemo.activity.base.IBaseView;
import cn.zhaoliang5156.jddemo.activity.base.MVPCallback;

/**
 * 账户的契约接口
 * <p>
 * 需要把 账户 m v p 的定义放到这里
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/5
 */
public interface AccountContract {

    /**
     * 账户View
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/5
     */
    interface View extends IBaseView<String> {
        /**
         * 显示进度条
         */
        void showLoading();

        /**
         * 隐藏进度条
         */
        void hideLoading();

        /**
         * 显示错误信息
         */
        void showError();
    }

    /**
     * Account model的规范
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/5
     */
    interface Model extends IBaseModel {
        void login(String mobile, String password, MVPCallback<String> callback);

        void reg(String mobile, String password, MVPCallback<String> callback);
    }

    /**
     * Presenter 模板
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/5
     */
    abstract class Presenter extends IBasePresenter<View> {
        abstract void login(String mobile, String password);

        abstract void reg(String mobile, String password);
    }

}
