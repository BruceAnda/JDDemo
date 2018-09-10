package cn.zhaoliang5156.jddemo.activity.customview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.zhaoliang5156.jddemo.R;

/**
 * 流式布局
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/7
 */
public class FlowLayout2 extends ViewGroup {

    // 只需要布局行就行了，需要用一个集合来缓存行
    private List<Line> mLines = new ArrayList<>();
    // 横向距离
    private float horizontalSpace;
    // 纵向距离
    private float verticalSpace;

    public FlowLayout2(Context context) {
        this(context, null);
    }

    public FlowLayout2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowLayout2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        // 读取属性值
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FlowLayout2);
        horizontalSpace = typedArray.getDimension(R.styleable.FlowLayout2_width_space2, 0);
        verticalSpace = typedArray.getDimension(R.styleable.FlowLayout2_height_space2, 0);
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 完成测量
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        // 完成布局
    }

    /**
     * 每一个行View
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/7
     */
    public class Line {

        // 存放展示视图的容器
        private List<View> views = new ArrayList<>();
        // 最大宽度
        private int maxWidth;
        // 使用宽度
        private int usedWidth;
        // 行距
        private float space;

        // 行高
        private int height;

        /**
         * 添加View
         *
         * @author zhaoliang
         * @version 1.0
         * @create 2018/9/7
         */
        void addView(View view) {

        }

        /**
         * 是否可以添加
         *
         * @author zhaoliang
         * @version 1.0
         * @create 2018/9/7
         */
        boolean canAddView(View view) {
            // 如果集合是空的 肯定能添加
            if (views.isEmpty()) {
                return true;
            }
            // 如果不是空的，就要判断 行中剩余空间是否能放下这个View
            return view.getMeasuredWidth() < maxWidth - usedWidth;
        }

        /**
         * 布局孩子
         *
         * @author zhaoliang
         * @version 1.0
         * @create 2018/9/7
         */
        void layout(int l, int t) {

            for (int i = 0; i < views.size(); i++) {
                View view = views.get(i);

                int left = l;
                int top = t;
                int right = (int) (usedWidth + view.getMeasuredWidth() + space);
                int bottom = view.getMeasuredHeight();

                view.layout(left, top, right, bottom);
            }

        }
    }
}
