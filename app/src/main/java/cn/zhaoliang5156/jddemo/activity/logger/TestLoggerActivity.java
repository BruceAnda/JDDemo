package cn.zhaoliang5156.jddemo.activity.logger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

import cn.zhaoliang5156.jddemo.R;

/**
 * 测试Logger 的使用
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/6
 */
public class TestLoggerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_logger);

        Logger.d("测试Logger的使用");

        new Thread() {
            @Override
            public void run() {
                Logger.d("这里是子线程" + this.getName());
            }
        }.start();
        Logger.json("{ \"key\": 3, \"value\": something}");

        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("key1", "value2");

        Logger.d(map);
    }
}
