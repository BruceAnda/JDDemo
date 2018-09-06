package cn.zhaoliang5156.jddemo.activity.customview.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * 自定义tank View
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/8/31
 */
public class TankView extends View {

    private Paint mControlPaint;
    private int mWidth;
    private int mHeight;
    private String TAG = TankView.class.getSimpleName();
    private int rectWidth = 100;
    private int left;
    private int top;
    private int right;
    private int bottom;
    private int centerX;
    private int centerY;
    private Paint paint;

    public TankView(Context context) {
        this(context, null);
    }

    public TankView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TankView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mControlPaint = new Paint();
        mControlPaint.setColor(Color.GRAY);

        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (widthMode == MeasureSpec.AT_MOST) {
            Log.i(TAG, "测试模式是：AT_MOST");
        } else if (widthMode == MeasureSpec.EXACTLY) {
            Log.i(TAG, "测试模式是：EXACTLY");
        } else {
            Log.i(TAG, "测试模式是：UNSPECIFIED");
        }

        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        mWidth = width;
        mHeight = height;

        Log.i(TAG, "width:" + mWidth + "height:" + mHeight);

        left = 0;
        top = mHeight - rectWidth;
        right = rectWidth;
        bottom = mHeight;

        centerX = mWidth / 2;
        centerY = mHeight / 2;

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(Color.GREEN);

        int widthLineNum = mWidth / rectWidth;
        int heightLineNum = mHeight / rectWidth;
        for (int i = 0; i <= widthLineNum; i++) {
            canvas.drawLine(rectWidth * i, 0, rectWidth * i, mHeight, paint);
        }

        for (int i = 0; i <= heightLineNum; i++) {
            canvas.drawLine(0, i * rectWidth, mWidth, i * rectWidth, paint);
        }

        canvas.drawRect(left, top, right, bottom, mControlPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                float x = event.getX();

                float y = event.getY();

                if (x < centerX) {
                    // 左移
                    moveLeft();
                } else {
                    // 右移
                    moveRight();
                }

                if (y > centerY) {
                    moveUP();
                } else {
                    moveDown();
                }

                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:

                break;
        }


        return super.onTouchEvent(event);
    }

    /**
     * 向下移动
     */
    private void moveDown() {
        top = top - rectWidth;
        bottom = bottom - rectWidth;
    }

    /**
     * 向上移动
     */
    private void moveUP() {
        top = top + rectWidth;
        bottom = bottom + rectWidth;
    }

    /**
     * 向右移动
     */
    private void moveRight() {
        left = left + rectWidth;
        right = right + rectWidth;
    }

    /**
     * 向左移动
     */
    private void moveLeft() {
        left = left - rectWidth;
        right = right - rectWidth;
    }
}
