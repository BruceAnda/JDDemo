package cn.zhaoliang5156.jddemo.activity.recycleview.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import cn.zhaoliang5156.jddemo.R;

/**
 * 瀑布流的viewHolder
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/11
 */
public class WaterfallHolder extends RecyclerView.ViewHolder {

    public TextView textView;

    public WaterfallHolder(View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.tv_title);
    }
}
