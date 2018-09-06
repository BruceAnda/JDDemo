package cn.zhaoliang5156.jddemo.activity.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.zhaoliang5156.jddemo.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * 使用OKHttp
 */
@ContentView(R.layout.activity_okhttp)
public class OKHttpActivity extends AppCompatActivity {

    private static final String TAG = OKHttpActivity.class.getSimpleName();
    @ViewInject(R.id.tv_result)
    TextView tvResult;

    @ViewInject(R.id.et_username)
    EditText etUsername;
    @ViewInject(R.id.et_password)
    EditText etPassword;
    private String mUsername, mPassword;

    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);

        configClient();
    }

    /**
     * 配置client
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/4
     */
    private void configClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        client = new OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
    }

    @Event({R.id.btn_sync_get, R.id.btn_async_get, R.id.btn_sync_post, R.id.btn_async_post})
    private void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_sync_get:
                syncGet();
                break;
            case R.id.btn_async_get:
                asyncGet();
                break;
            case R.id.btn_sync_post:
                readUsernameAndPassword();
                syncPost();
                break;
            case R.id.btn_async_post:
                readUsernameAndPassword();
                asyncPost();
                break;
        }
    }

    /**
     * 读取用户名和密码
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/4
     */
    private void readUsernameAndPassword() {
        mUsername = etUsername.getText().toString();
        mPassword = etPassword.getText().toString();
    }

    /**
     * 异步post
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/4
     */
    private void asyncPost() {
        FormBody builder = new FormBody
                .Builder()
                .add("mobile", mUsername)
                .add("password", mPassword)
                .build();
        Request request = new Request
                .Builder()
                .url("https://www.zhaoapi.cn/user/login")
                .post(builder)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(TAG, "response:" + response.body().string());
            }
        });
    }

    /**
     * 同步post
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/4
     */
    private void syncPost() {

    }

    /**
     * 异步get
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/4
     */
    private void asyncGet() {
        Request request = new Request
                .Builder()
                .url("https://publicobject.com/helloworld.txt")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    Log.i(TAG, "\n" + response.body().string());
                }
            }
        });
    }

    /**
     * 同步get
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/4
     */
    private void syncGet() {
        new Thread() {
            @Override
            public void run() {
                Request request = new Request
                        .Builder()
                        .url("https://publicobject.com/helloworld.txt")
                        .build();

                try {
                    final Response response = client.newCall(request).execute();
                    Log.i(TAG, "\n" + response.body().string());
                    /*if (response.isSuccessful()) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    tvResult.setText(Html.fromHtml(response.body().string()));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }*/
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
