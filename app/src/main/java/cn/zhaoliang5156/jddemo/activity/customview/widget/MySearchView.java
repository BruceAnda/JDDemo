package cn.zhaoliang5156.jddemo.activity.customview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import cn.zhaoliang5156.jddemo.R;

/**
 * 自定义搜索框
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/8/30
 */
public class MySearchView extends LinearLayout {

    private ImageView mImageSearch;
    private EditText mEtSearchContext;
    private String searchHint = "";

    public MySearchView(Context context) {
        //super(context);
        this(context, null);
    }

    public MySearchView(Context context, @Nullable AttributeSet attrs) {
        //super(context, attrs);
        this(context, attrs, 0);
    }

    public MySearchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 填充布局
        inflate(context, R.layout.search, this);

        // 查找控件
        mImageSearch = findViewById(R.id.iv_search);
        mEtSearchContext = findViewById(R.id.et_search_content);

        // 读取属性
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.MySearchView);
        searchHint = attributes.getString(R.styleable.MySearchView_search_hint);
        attributes.recycle();

        // 把读取到的属性值设置到 显示页面
        mEtSearchContext.setHint(searchHint);

        // 设置点击事件
        mImageSearch.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (searchListener != null) {
                    String searchContext = mEtSearchContext.getText().toString();
                    if (!TextUtils.isEmpty(searchContext))
                        searchListener.onSearch(searchContext);
                }
            }
        });
    }

    private SearchListener searchListener;

    public void setSearchListener(SearchListener searchListener) {
        this.searchListener = searchListener;
    }

    public interface SearchListener {
        void onSearch(String context);
    }
}
