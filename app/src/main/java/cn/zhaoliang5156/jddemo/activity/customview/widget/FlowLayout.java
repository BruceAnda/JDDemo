package cn.zhaoliang5156.jddemo.activity.customview.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoliang
 * @version 1.0
 * @create 2018/8/31
 */

public class FlowLayout extends ViewGroup {

    private String TAG = FlowLayout.class.getSimpleName();

    //存储所有的View，按行记录
    private List<List<View>> mAllView = new ArrayList<>();

    //记录每一行的最大高度
    private List<Integer> mLineHeight = new ArrayList<>();

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int width = getWidth();

        //当前行的最大值
        int lineWidth = 0;
        int lineHeight = 0;

        //存储每一行所有的ChildView
        List<View> lineViews = new ArrayList<View>();

        //考虑到padding情况，所以开始要加上padding
        int left = getPaddingLeft();
        int top = getPaddingTop();
        //得到总行数
        int lineNums = mAllView.size();
        for (int i = 0; i < lineNums; i++) {
            //每一行的所有的Views
            lineViews = mAllView.get(i);
            //当前行的最大高度
            lineHeight = mLineHeight.get(i);

            Log.e(TAG, "第" + i + "行 ：" + lineViews.size() + " , " + lineViews);
            Log.e(TAG, "第" + i + "行， ：" + lineHeight);
            //遍历当前所有的View
            for (int j = 0; j < lineViews.size(); j++) {

                //考虑到子View的状态
                View child = lineViews.get(j);
                if (child.getVisibility() == View.GONE) {
                    continue;
                }

                MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

                //计算childView的left,top,right,bottom
                int lc = left + lp.leftMargin;
                int tc = top + lp.topMargin;
                int rc = lc + child.getMeasuredWidth();
                int bc = tc + child.getMeasuredHeight();

                child.layout(lc, tc, rc, bc);
                left += child.getMeasuredWidth() + lp.rightMargin
                        + lp.leftMargin;

            }
            left = getPaddingLeft();
            top += lineHeight;
        }
        Log.v(TAG, "onLayout   mAllViews.size() -- > " + mAllView.size() + "   mLineHeight.size() -- > " + mLineHeight.size());
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //置空 view 容器 和 lineHeight 容器  重新赋值
        mAllView.clear();
        mLineHeight.clear();
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        // 计算出所有的 child 的 宽和高
        measureChildren(sizeWidth, sizeHeight);
        //如果是wrap_content情况下，记录宽和高
        int width = 0;
        int height = 0;

        //记录每一行的宽度，width不断取最大宽度
        int lineWidth = 0;
        //每一行的高度，累加至height
        int lineHeight = 0;

        //存储每一行的chileVIew
        List<View> lineViews = new ArrayList<View>();

        int cCount = getChildCount();

        //遍历每个子元素
        for (int i = 0; i < cCount; i++) {
            View child = getChildAt(i);

            //测量每一个child的宽和高
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

            //当前子控件实际占据的宽度
            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            //当前子空间实际占据的高度
            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;

            //需要换行
            if (lineWidth + childWidth > sizeWidth - getPaddingLeft() - getPaddingRight()) {
                width = Math.max(lineWidth, childWidth);
                lineWidth = childWidth;   //重新开启新行，开始记录

                height += lineHeight;  //叠加高度
                //开启记录下一行的高度
                lineHeight = childHeight;

                mAllView.add(lineViews);
                //记录这一行所有的View以及最大高度
                mLineHeight.add(lineHeight);
                lineViews = new ArrayList<View>();
                // 这个  view(child) 是下一行的第一个view
                lineViews.add(child);

                //Log.v(TAG, "onl  mAllViews.size()  --  > " + mAllView.size());
            } else {
                //否则累加值lineWidth,lineHeight取最大高度
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, childHeight); //去height最大的值
                lineViews.add(child);
            }
            if (i == cCount - 1) {
                width = Math.max(width, lineWidth);
                height += lineHeight;  //如果是最后一行，则叠加其高度
            }
        }

        // 循环结束后 把最后一行内容add进集合中
        mLineHeight.add(lineHeight); // 记录最后一行
        mAllView.add(lineViews);
        //计算容器的宽高
        setMeasuredDimension((modeWidth == MeasureSpec.EXACTLY) ? sizeWidth
                        : width + getPaddingLeft() + getPaddingRight(),
                (modeHeight == MeasureSpec.EXACTLY) ? sizeHeight : height + getPaddingTop() + getPaddingBottom());

    }


}
