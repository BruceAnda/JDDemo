package cn.zhaoliang5156.jddemo.activity.recycleview.itemactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import cn.zhaoliang5156.jddemo.R;
import cn.zhaoliang5156.jddemo.activity.recycleview.adapter.SimpleAdapter;

/**
 * 这个界面学习布局管理器的使用
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/11
 */
@ContentView(R.layout.activity_first)
public class FirstActivity extends AppCompatActivity {

    @ViewInject(R.id.recycle_view)
    private RecyclerView recyclerView;
    private List<String> datas;
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);

        // 创建假数据
        datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add("孙悟空" + i);
        }

        // 1. 给RecycleView设置布局管理器
        // 2. 给RecycleView设置adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new SimpleAdapter(this, datas);
        recyclerView.setAdapter(adapter);
    }

    @Event({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4})
    private void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                list();
                break;
            case R.id.btn2:
                grid();
                break;
            case R.id.btn3:
                single();
                break;
            case R.id.btn4:
                mutiple();
                break;
        }
    }

    private void mutiple() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3, GridLayoutManager.HORIZONTAL, false));
        adapter.notifyDataSetChanged();
    }

    private void single() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapter.notifyDataSetChanged();
    }

    private void grid() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        adapter.notifyDataSetChanged();
    }

    private void list() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.notifyDataSetChanged();
    }
}
