package cn.zhaoliang5156.jddemo.activity.mvpv2account;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.zhaoliang5156.jddemo.activity.base.MVPCallback;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AccountModel implements AccountContract.Model {

    private OkHttpClient client;

    // 数据管理类dataManager remote远程数据管理  local本地数据管理

    public AccountModel() {
        client = new OkHttpClient
                .Builder()
                .build();
    }

    @Override
    public void login(String mobile, String password, final MVPCallback<String> callback) {
        // 调用dataManager 请求数据 我们这里调用okclient
        client.newCall(new Request
                .Builder()
                .url("https://www.zhaoapi.cn/user/login")
                .post(new FormBody
                        .Builder()
                        .add("mobile", mobile)
                        .add("password", password)
                        .build())
                .build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onSuccess(response.body().string());
                callback.onComplete();
            }
        });
    }

    @Override
    public void reg(String mobile, String password, final MVPCallback<String> callback) {
        // 调用dataManager 请求数据 我们这里调用okclient
        client.newCall(new Request
                .Builder()
                .url("https://www.zhaoapi.cn/user/reg")
                .post(new FormBody
                        .Builder()
                        .add("mobile", mobile)
                        .add("password", password)
                        .build())
                .build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onError();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onSuccess(response.body().string());
                callback.onComplete();
            }
        });
    }
}
