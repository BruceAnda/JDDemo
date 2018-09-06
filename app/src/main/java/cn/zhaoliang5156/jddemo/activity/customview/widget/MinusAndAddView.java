package cn.zhaoliang5156.jddemo.activity.customview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.zhaoliang5156.jddemo.R;

/**
 * 自定义加减号
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/8/30
 */
public class MinusAndAddView extends LinearLayout {

    private ImageView mIvAdd;
    private ImageView mIvMinus;
    private TextView tvResult;
    private int currentNum;

    public MinusAndAddView(Context context) {
        this(context, null);
    }

    public MinusAndAddView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MinusAndAddView(final Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        // 填充布局
        inflate(context, R.layout.add_and_minus, this);
        // 查找控件
        mIvAdd = findViewById(R.id.iv_add);
        mIvMinus = findViewById(R.id.iv_minus);
        tvResult = findViewById(R.id.tv_result);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MinusAndAddView);
        currentNum = typedArray.getInteger(R.styleable.MinusAndAddView_shop_num, 0);
        typedArray.recycle();

        tvResult.setText(String.valueOf(currentNum));

        mIvAdd.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNum++;
                tvResult.setText(String.valueOf(currentNum));
                if (callback != null) {
                    callback.showShopNum(currentNum);
                }
            }
        });

        mIvMinus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNum > 1) {
                    currentNum--;
                    tvResult.setText(String.valueOf(currentNum));
                    if (callback != null) {
                        callback.showShopNum(currentNum);
                    }
                }
            }
        });
    }

    private MinusAndAddCallback callback;

    public void setCallback(MinusAndAddCallback callback) {
        this.callback = callback;
    }

    /**
     * 定义接口
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/8/30
     */
    public interface MinusAndAddCallback {
        void showShopNum(int shopNum);
    }
}
