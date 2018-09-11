package cn.zhaoliang5156.jddemo.activity.recycleview.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import cn.zhaoliang5156.jddemo.R;

/**
 * 左边图片的Item
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/11
 */
public class LeftImageHolder extends RecyclerView.ViewHolder {

    public TextView tvTitle;
    public LeftImageHolder(View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tv_title);
    }
}
