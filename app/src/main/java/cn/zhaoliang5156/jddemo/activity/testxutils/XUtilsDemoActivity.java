package cn.zhaoliang5156.jddemo.activity.testxutils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import cn.zhaoliang5156.jddemo.R;

/**
 * 测试Xutils
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/3
 */
@ContentView(R.layout.activity_xutils_demo)
public class XUtilsDemoActivity extends AppCompatActivity {

    @ViewInject(R.id.tv1)
    private TextView tv1;
    @ViewInject(R.id.tv2)
    private TextView tv2;
    @ViewInject(R.id.tv3)
    private TextView tv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    @Event(value = R.id.tv1)
    private void onTvClick(View view) {
        tv3.setText("点击了tv1");
    }
}
