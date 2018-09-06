package cn.zhaoliang5156.jddemo.activity.mvpaccount;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import cn.zhaoliang5156.jddemo.R;

/**
 * 账户管理Activity
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/5
 */
@ContentView(R.layout.activity_account)
public class AccountActivity extends AppCompatActivity implements AccountView {

    // 账户的Presenter
    private AccountPresenter presenter;
    private String mMobile, mPassword;

    @ViewInject(R.id.et_username)
    private EditText etUsername;
    @ViewInject(R.id.et_password)
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        // 创建Presenter对象
        presenter = new AccountPresenter(this);

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
    public void showSuccess(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(AccountActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showError(final String msg) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(AccountActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
