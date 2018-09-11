package cn.zhaoliang5156.jddemo.activity.recycleview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.zhaoliang5156.jddemo.R;
import cn.zhaoliang5156.jddemo.activity.recycleview.holder.WaterfallHolder;

/**
 * 瀑布流Holder
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/11
 */
public class WaterfallAdapter extends RecyclerView.Adapter<WaterfallHolder> {

    private Context context;
    private List<String> datas;
    private List<Integer> itemHeight;

    public WaterfallAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
        itemHeight = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            itemHeight.add((int) (Math.random() * 100 + 300));
        }
    }

    @NonNull
    @Override
    public WaterfallHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.waterfall_recycleview_item, parent, false);

        return new WaterfallHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WaterfallHolder holder, int position) {
        // 动态设置高度
        ViewGroup.LayoutParams layoutParams = holder.textView.getLayoutParams();
        layoutParams.height = itemHeight.get(position);

        // 动态设置背景颜色
        holder.textView.setBackgroundColor(Color.rgb((int) (Math.random() * 100 + 155), (int) (Math.random() * 100 + 155), (int) (Math.random() * 100 + 155)));

        holder.textView.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
