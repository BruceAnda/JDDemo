package cn.zhaoliang5156.jddemo.activity.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.nex3z.flowlayout.FlowLayout;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import cn.zhaoliang5156.jddemo.R;

@ContentView(R.layout.activity_flow_layout)
public class FlowLayoutActivity extends AppCompatActivity {

    @ViewInject(R.id.flow_layout)
    private FlowLayout flowLayout;
    private String[] data = {"QQ", "视频", "放开那三国", "电子书", "酒店", "单机", "小说", "斗地主", "优酷", "网游", "WIFI万能钥匙", "播放器", "捕鱼达人2", "机票", "游戏", "熊出没之熊大快跑", "美图秀秀", "浏览器", "单机游戏", "我的世界", "电影电视", "QQ空间", "旅游", "免费游戏", "2048", "刀塔传奇", "壁纸", "节奏大师", "锁屏", "装机必备", "天天动听", "备份", "网盘", "海淘网", "大众点评", "爱奇艺视频", "腾讯手机管家", "百度地图", "猎豹清理大师", "谷歌地图", "hao123上网导航", "京东", "有你", "万年历-农历黄历", "支付宝钱包"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        for (int i = 0; i < 20; i++) {
            TextView textView = new TextView(this);
            textView.setText(data[i % data.length]);
            textView.setBackgroundResource(R.drawable.flow_bg);
            textView.setPadding(10, 10, 10, 10);
            textView.setGravity(Gravity.CENTER);
            textView.setId(i);

            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(FlowLayoutActivity.this, ((TextView) v).getText() + "--" + v.getId(), Toast.LENGTH_SHORT).show();
                }
            });

            flowLayout.addView(textView);
        }
    }
}
