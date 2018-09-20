package cn.zhaoliang5156.jddemo.activity.okhttp.interceptor;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.IOException;
import java.util.logging.Logger;

import cn.zhaoliang5156.jddemo.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 测试重定向拦截器
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/12
 */
@ContentView(R.layout.activity_interceptor)
public class InterceptorActivity extends AppCompatActivity {

    @ViewInject(R.id.get_data)
    private TextView textView;

    private OkHttpClient mOkHttpClient;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);

        mOkHttpClient = new OkHttpClient
                .Builder()
                .addInterceptor(new RedirectInterceptor())
                .build();

        mHandler = new Handler(Looper.getMainLooper());
    }

    @Event(R.id.get_data)
    private void clickData(View view) {
        final Request request = new Request
                .Builder()
                .url("https://www.zhaoapi.cn/home/getHome")
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
               // com.orhanobut.logger.Logger.json(response.body().string());
                com.orhanobut.logger.Logger.d(response.body().string());
                /*mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            textView.setText(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });*/
                /*runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            textView.setText(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });*/
            }
        });
    }

}
