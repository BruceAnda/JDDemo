package cn.zhaoliang5156.jddemo.activity.customview.widget;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 完全自定义View
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/8/30
 */
public class MyView extends View {

    private Paint mPaint;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        mPaint.setTextSize(30);
        mPaint.setColor(Color.RED);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(100, 100, 50, mPaint);
        canvas.drawLine(0, 0, 768, 1280, mPaint);
        canvas.drawText("测试自定义View", 200, 200, mPaint);
        canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), android.R.drawable.star_on), new Matrix(), mPaint);
    }
}
