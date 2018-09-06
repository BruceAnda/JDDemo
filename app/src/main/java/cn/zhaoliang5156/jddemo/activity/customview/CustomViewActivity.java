package cn.zhaoliang5156.jddemo.activity.customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import cn.zhaoliang5156.jddemo.R;
import cn.zhaoliang5156.jddemo.activity.customview.widget.MinusAndAddView;
import cn.zhaoliang5156.jddemo.activity.customview.widget.MySearchView;

public class CustomViewActivity extends AppCompatActivity {

    private MySearchView searchView;
    private MinusAndAddView mShopNumView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);

        searchView = findViewById(R.id.jd_search_view);
        searchView.setSearchListener(new MySearchView.SearchListener() {
            @Override
            public void onSearch(String context) {
                Toast.makeText(CustomViewActivity.this, "搜索内容是：" + context, Toast.LENGTH_SHORT).show();
            }
        });

        mShopNumView = findViewById(R.id.shop_num);
        mShopNumView.setCallback(new MinusAndAddView.MinusAndAddCallback() {
            @Override
            public void showShopNum(int shopNum) {
                Toast.makeText(CustomViewActivity.this, "当前商品数量是：" + shopNum, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
