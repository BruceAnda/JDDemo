package cn.zhaoliang5156.jddemo.activity.animation.item;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import cn.zhaoliang5156.jddemo.R;

/**
 * 帧动画
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/12
 */
@ContentView(R.layout.activity_frame_animation)
public class FrameAnimationActivity extends AppCompatActivity {

    @ViewInject(R.id.iv_frame)
    private ImageView imageView;

    AnimationDrawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);

        imageView.setBackgroundResource(R.drawable.jingdongkuaidi);
        drawable = (AnimationDrawable) imageView.getBackground();
        drawable.start();
    }
}
