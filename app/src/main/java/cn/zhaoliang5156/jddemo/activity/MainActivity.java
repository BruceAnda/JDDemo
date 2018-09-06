package cn.zhaoliang5156.jddemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import cn.zhaoliang5156.jddemo.R;
import cn.zhaoliang5156.jddemo.activity.customview.widget.FlowLayout;

/**
 * 这里是开发版本
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/8/29
 */
public class MainActivity extends AppCompatActivity {

    private FlowLayout flowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flowLayout = findViewById(R.id.flow_layout);

        for (int i = 0; i < 10; i++) {
            TextView child = new TextView(this);
            child.setText("Hellohksjahf");
            flowLayout.addView(child);

            
        }

    }
}
