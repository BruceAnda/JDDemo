package cn.zhaoliang5156.jddemo.activity.recycleview.itemactivity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.zrq.divider.Divider;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import cn.zhaoliang5156.jddemo.R;
import cn.zhaoliang5156.jddemo.activity.recycleview.adapter.WaterfallAdapter;
import jp.wasabeef.recyclerview.animators.FadeInRightAnimator;
import jp.wasabeef.recyclerview.animators.LandingAnimator;
import jp.wasabeef.recyclerview.animators.ScaleInBottomAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

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
    private WaterfallAdapter adapter;

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
        adapter = new WaterfallAdapter(this, datas);
        recyclerView.setAdapter(adapter);

        // 给RecycleView item 添加动画
        // recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.setItemAnimator(new SlideInUpAnimator());
        recyclerView.setItemAnimator(new FadeInRightAnimator());

        recyclerView.addItemDecoration(Divider.builder()
                .color(android.R.color.darker_gray)
                .width(50)
                .height(50).build());
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
        datas.remove(5);
        adapter.notifyItemRemoved(5);
    }

    private void add() {
        datas.add(5, "猪八戒");
        adapter.notifyItemInserted(5);
    }
}
