package cn.zhaoliang5156.jddemo.activity.crashhandler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.x;

import java.util.List;

import cn.zhaoliang5156.jddemo.R;

/**
 * 未处理异常的界面
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/6
 */
@ContentView(R.layout.activity_test_un_crash_exception)
public class TestUnCrashExceptionActivity extends AppCompatActivity {

    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    @Event(R.id.btn_null)
    private void onBtnClick(View view) {
        list.size();
        /*Intent intent = new Intent("cn.zhaoliang5156.jddemo.errorexit");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);*/
    }
}
