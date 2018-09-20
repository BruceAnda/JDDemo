package cn.zhaoliang5156.jddemo.activity.animation.item;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import cn.zhaoliang5156.jddemo.R;

/**
 * 属性动画
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/12
 */
@ContentView(R.layout.activity_property_animation)
public class PropertyAnimationActivity extends AppCompatActivity {

    @ViewInject(R.id.iv_property)
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);
    }

    @Event(R.id.iv_property)
    private void onImageClick(View view) {
        /*ObjectAnimator rotation = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 360f);
        rotation.start();*/
        /*ObjectAnimator alpha = ObjectAnimator.ofFloat(imageView, "alpha", 0F, 1F);
        alpha.setDuration(2000);
        alpha.start();*/
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,
                R.animator.property_animator);
        set.setTarget(imageView);
        set.start();
        /*ObjectAnimator x = ObjectAnimator.ofFloat(imageView, "x", 0, 500);
        x.start();*/
    }
}
