package cn.zhaoliang5156.jddemo.activity.customview.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 报表柱状图
 */
public class BarChar extends View {

    public BarChar(Context context) {
        this(context, null);
    }

    public BarChar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BarChar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


    }
}
