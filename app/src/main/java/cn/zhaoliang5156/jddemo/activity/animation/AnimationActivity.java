package cn.zhaoliang5156.jddemo.activity.animation;

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
import cn.zhaoliang5156.jddemo.activity.animation.item.FrameAnimationActivity;
import cn.zhaoliang5156.jddemo.activity.animation.item.PropertyAnimationActivity;
import cn.zhaoliang5156.jddemo.activity.animation.item.TweenAnimationActivity;

/**
 * 动画的使用
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/12
 */
@ContentView(R.layout.activity_animation)
public class AnimationActivity extends AppCompatActivity {

    @ViewInject(R.id.list)
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);

        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{
                "帧动画",
                "补间动画",
                "属性动画"
        }));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(AnimationActivity.this, FrameAnimationActivity.class);
                        break;
                    case 1:
                        intent = new Intent(AnimationActivity.this, TweenAnimationActivity.class);
                        break;
                    case 2:
                        intent = new Intent(AnimationActivity.this, PropertyAnimationActivity.class);
                        break;
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        });
    }
}
