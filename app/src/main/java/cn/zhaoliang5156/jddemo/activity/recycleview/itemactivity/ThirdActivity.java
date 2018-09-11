package cn.zhaoliang5156.jddemo.activity.recycleview.itemactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import cn.zhaoliang5156.jddemo.R;
import cn.zhaoliang5156.jddemo.activity.recycleview.adapter.MoreItemAdapter;
import cn.zhaoliang5156.jddemo.activity.recycleview.listener.ItemListener;

/**
 * 这个节目我们学习多条目 条目点击 下滑线
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/11
 */
@ContentView(R.layout.activity_third)
public class ThirdActivity extends AppCompatActivity {

    @ViewInject(R.id.recycle_view)
    private RecyclerView recyclerView;
    private List<String> datas;
    private MoreItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);

        // 模拟数据
        datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add("孙悟空" + i);
        }

        // 设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 设置adapter显示数据
        adapter = new MoreItemAdapter(this, datas);
        recyclerView.setAdapter(adapter);

        // 设置分割线
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.divider2));
        recyclerView.addItemDecoration(itemDecoration);

        adapter.setListener(new ItemListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(ThirdActivity.this, "点击" + datas.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClick(int position) {
                Toast.makeText(ThirdActivity.this, "长按" + datas.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
