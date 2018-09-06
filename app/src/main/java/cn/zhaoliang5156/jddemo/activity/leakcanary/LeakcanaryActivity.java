package cn.zhaoliang5156.jddemo.activity.leakcanary;

import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.zhaoliang5156.jddemo.R;

/**
 * 测试Leakcanary
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/6
 */
public class LeakcanaryActivity extends AppCompatActivity {

    private HttpRequestHelper httpRequestHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leakcanary);
        View button = findViewById(R.id.async_work);
        button.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                startAsyncWork();
            }
        });

        httpRequestHelper = (HttpRequestHelper) getLastNonConfigurationInstance();
        if (httpRequestHelper == null) {
            httpRequestHelper = new HttpRequestHelper(button);
        }
    }

    /*@Override
    public Object onRetainNonConfigurationInstance() {
        return httpRequestHelper;
    }*/

    @SuppressLint("StaticFieldLeak")
    void startAsyncWork() {
        // This runnable is an anonymous class and therefore has a hidden reference to the outer
        // class MainActivity. If the activity gets destroyed before the thread finishes (e.g. rotation),
        // the activity instance will leak.
        Runnable work = new Runnable() {
            @Override public void run() {
                // Do some slow work in background
                SystemClock.sleep(20000);
            }
        };
        new Thread(work).start();
    }
}
