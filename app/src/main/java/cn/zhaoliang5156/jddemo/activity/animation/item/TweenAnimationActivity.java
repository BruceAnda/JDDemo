package cn.zhaoliang5156.jddemo.activity.animation.item;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import cn.zhaoliang5156.jddemo.R;

/**
 * 补间动画
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/12
 */
@ContentView(R.layout.activity_tween_animation)
public class TweenAnimationActivity extends AppCompatActivity {

    @ViewInject(R.id.iv_tween)
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);
    }

    @Event(R.id.iv_tween)
    private void onImageClick(View view) {
        imageView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.hyperspace_jump));
    }
}
