package cn.zhaoliang5156.jddemo.activity.recycleview.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import cn.zhaoliang5156.jddemo.R;

/**
 * 右边图片的item
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/11
 */
public class RightImageHolder extends RecyclerView.ViewHolder {

    public TextView tvTitle;

    public RightImageHolder(View itemView) {
        super(itemView);

        tvTitle = itemView.findViewById(R.id.tv_title);
    }
}
