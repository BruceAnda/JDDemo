package cn.zhaoliang5156.jddemo.activity.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import cn.zhaoliang5156.jddemo.R;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GaoDeSearchActivity extends AppCompatActivity {

    private static final String TAG = GaoDeSearchActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gao_de_search);

    }

    public void click(View view) {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(new Request.Builder()
                .url("https://restapi.amap.com/v3/place/around?key=d78f39012867929dc6ad174dd498f51f&location=%20116.473168,39.993015&radius=10000&types=%20011100").build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(TAG, "error" + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(TAG, "结果：" + response.body().string());
            }
        });
    }
}
