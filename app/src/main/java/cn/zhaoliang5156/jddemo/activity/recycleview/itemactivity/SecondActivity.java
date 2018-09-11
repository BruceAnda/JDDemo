package cn.zhaoliang5156.jddemo.activity.recycleview.itemactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import cn.zhaoliang5156.jddemo.R;
import cn.zhaoliang5156.jddemo.activity.recycleview.adapter.WaterfallAdapter;

/**
 * 这个节目学习瀑布流 和添加 删除 item动画
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/11
 */
@ContentView(R.layout.activity_second)
public class SecondActivity extends AppCompatActivity {

    @ViewInject(R.id.recycle_view)
    private RecyclerView recyclerView;

    private List<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);

        // 创建假数据
        datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add("孙悟空" + i);
        }

        // 瀑布流操作
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(new WaterfallAdapter(this, datas));
    }

    @Event({R.id.btn_add, R.id.btn_delete})
    private void onbtnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                add();
                break;
            case R.id.btn_delete:
                delete();
                break;
        }
    }

    private void delete() {

    }

    private void add() {

    }
}
