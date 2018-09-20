# FlowLayout

# 使用步骤
1. 在proj的build.gradle 添加如下代码

    ```
    allprojects {
        repositories {
            maven { url 'https://dl.bintray.com/bruceanda/maven/' }
        }
    }
    ```
2. 在app的build.gradle 点击如下代码
    ```
    implementation 'flowlayout:flowlayout:0.0.2'
    ```
3. 在布局文件中使用

```
<cn.zhaoliang5156.flowlayout.FlowLayout
        android:id="@+id/flow_layout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:padding="10dp"
        app:height_space="20dp"
        app:width_space="20dp" />
```
4. 在Java代码中使用
```
    public class MainActivity extends AppCompatActivity {
    
        private FlowLayout flowLayout;
        private String[] data = {"QQ", "视频", "放开那三国", "电子书", "酒店", "单机", "小说", "斗地主", "优酷", "网游", "WIFI万能钥匙", "播放器", "捕鱼达人2", "机票", "游戏", "熊出没之熊大快跑", "美图秀秀", "浏览器", "单机游戏", "我的世界", "电影电视", "QQ空间", "旅游", "免费游戏", "2048", "刀塔传奇", "壁纸", "节奏大师", "锁屏", "装机必备", "天天动听", "备份", "网盘", "海淘网", "大众点评", "爱奇艺视频", "腾讯手机管家", "百度地图", "猎豹清理大师", "谷歌地图", "hao123上网导航", "京东", "有你", "万年历-农历黄历", "支付宝钱包"};
    
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
    
            flowLayout = findViewById(R.id.flow_layout);
    
            for (int i = 0; i < 20; i++) {
                TextView textView = new TextView(this);
                textView.setText(data[i % data.length]);
                textView.setPadding(10, 10, 10, 10);
                textView.setBackground(getResources().getDrawable(R.drawable.flow_bg));
                textView.setGravity(Gravity.CENTER);
                textView.setId(i);
    
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, ((TextView) v).getText() + "--" + v.getId(), Toast.LENGTH_SHORT).show();
                    }
                });
    
                flowLayout.addView(textView);
            }
        }
    }
```
