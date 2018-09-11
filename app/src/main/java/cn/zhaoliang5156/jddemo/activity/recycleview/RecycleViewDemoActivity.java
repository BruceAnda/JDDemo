package cn.zhaoliang5156.jddemo.activity.recycleview;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import cn.zhaoliang5156.jddemo.R;
import cn.zhaoliang5156.jddemo.activity.recycleview.itemactivity.FirstActivity;
import cn.zhaoliang5156.jddemo.activity.recycleview.itemactivity.SecondActivity;
import cn.zhaoliang5156.jddemo.activity.recycleview.itemactivity.ThirdActivity;

/**
 * RecycleView的使用
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/11
 */
@ContentView(R.layout.activity_recycle_view_demo)
public class RecycleViewDemoActivity extends AppCompatActivity {

    @ViewInject(R.id.list)
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{
                "布局管理器",
                "瀑布流",
                "多条目 下划线 条目点击"
        }));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(RecycleViewDemoActivity.this, FirstActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(RecycleViewDemoActivity.this, SecondActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(RecycleViewDemoActivity.this, ThirdActivity.class));
                        break;
                }
            }
        });
    }
}
