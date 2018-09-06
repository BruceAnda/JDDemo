package cn.zhaoliang5156.jddemo.activity.mvpv2account;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import cn.zhaoliang5156.jddemo.R;
import cn.zhaoliang5156.jddemo.activity.mvpaccount.AccountActivity;
import cn.zhaoliang5156.jddemo.activity.mvpaccount.AccountPresenter;
import cn.zhaoliang5156.jddemo.activity.mvpaccount.AccountView;

/**
 * 账户管理Activity
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/5
 */
@ContentView(R.layout.activity_account)
public class AccountActivityv2 extends AppCompatActivity implements AccountContract.View {

    private String mMobile, mPassword;

    @ViewInject(R.id.et_username)
    private EditText etUsername;
    @ViewInject(R.id.et_password)
    private EditText etPassword;

    // 声明presenter层
    private AccountPresenterImpl presenter;
    private ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        // 创建Presenter对象
        presenter = new AccountPresenterImpl();
        presenter.attch(this);
        dialog = new ProgressDialog(this);
    }

    @Event({R.id.btn_reg, R.id.btn_login})
    private void accountClick(View view) {
        readUserNameAdnPassword();
        switch (view.getId()) {
            case R.id.btn_reg:
                presenter.reg(mMobile, mPassword);
                break;
            case R.id.btn_login:
                presenter.login(mMobile, mPassword);
                break;
        }
    }

    /**
     * 读取用户名和密码
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/5
     */
    private void readUserNameAdnPassword() {
        mMobile = etUsername.getText().toString();
        mPassword = etPassword.getText().toString();
    }

    @Override
    public void showLoading() {
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    @Override
    public void hideLoading() {
        if (dialog.isShowing()) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    dialog.hide();
                }
            });
        }
    }

    @Override
    public void showError() {

    }

    @Override
    public void showData(final String data) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(AccountActivityv2.this, data, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter.isViewAttach()) {
            presenter.detach();
        }
    }
}
