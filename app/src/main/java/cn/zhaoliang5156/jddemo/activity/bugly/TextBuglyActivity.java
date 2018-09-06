package cn.zhaoliang5156.jddemo.activity.bugly;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.tencent.bugly.crashreport.CrashReport;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.x;

import cn.zhaoliang5156.jddemo.R;

/**
 * 测试Bugly的使用
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/6
 */
@ContentView(R.layout.activity_text_bugly)
public class TextBuglyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    @Event(R.id.btn_test_bugly)
    private void testBugly(View view) {
        CrashReport.testJavaCrash();
    }
}
