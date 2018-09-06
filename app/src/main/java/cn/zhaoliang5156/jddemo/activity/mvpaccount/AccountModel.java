package cn.zhaoliang5156.jddemo.activity.mvpaccount;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 账户Model
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/5
 * <p>
 * 访问网络 那用户名和密码去登录
 */
public class AccountModel {

    

    private OkHttpClient client;

    public AccountModel() {
        client = new OkHttpClient
                .Builder()
                .cookieJar(new CookieJar() {
                    private final HashMap<String, List<Cookie>> cookieStore = new HashMap<>();

                    @Override
                    public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                        cookieStore.put(url.host(), cookies);
                    }

                    @Override
                    public List<Cookie> loadForRequest(HttpUrl url) {
                        List<Cookie> cookies = cookieStore.get(url.host());
                        return cookies != null ? cookies : new ArrayList<Cookie>();
                    }
                })
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();

    }

    /**
     * 注册
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/5
     */
    public void reg(String mobile, String password, final AccountCallback callback) {
        FormBody body = new FormBody
                .Builder()
                .add("mobile", mobile)
                .add("password", password)
                .build();

        Request build = new Request
                .Builder()
                .url("https://www.zhaoapi.cn/user/reg")
                .post(body)
                .build();
        client.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onSuccess();
            }
        });
    }

    /**
     * 登录
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/5
     */
    public void login(String mobile, String password, final AccountCallback callback) {
        FormBody body = new FormBody
                .Builder()
                .add("mobile", mobile)
                .add("password", password)
                .build();

        Request build = new Request
                .Builder()
                .url("https://www.zhaoapi.cn/user/login")
                .post(body)
                .build();
        client.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onSuccess();
            }
        });
    }

    public interface AccountCallback {
        void onSuccess();

        void onError(String errorMsg);
    }
}
