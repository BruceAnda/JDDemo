package cn.zhaoliang5156.jddemo.activity.recycleview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import cn.zhaoliang5156.jddemo.R;
import cn.zhaoliang5156.jddemo.activity.recycleview.holder.LeftImageHolder;
import cn.zhaoliang5156.jddemo.activity.recycleview.holder.RightImageHolder;
import cn.zhaoliang5156.jddemo.activity.recycleview.holder.SimpleViewHolder;
import cn.zhaoliang5156.jddemo.activity.recycleview.listener.ItemListener;

/**
 * 多条目的adapter
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/11
 */
public class MoreItemAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<String> datas;
    private final int ITEM_TYPE_ONE = 0;
    private final int ITEM_TYPE_TWO = 1;
    private final int ITEM_TYPE_THREE = 2;

    public MoreItemAdapter(Context context, List<String> datas) {
        this.context = context;
        this.datas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case ITEM_TYPE_ONE:
                holder = new SimpleViewHolder(LayoutInflater.from(context).inflate(R.layout.simple_recycleview_item, parent, false));
                break;
            case ITEM_TYPE_TWO:
                holder = new LeftImageHolder(LayoutInflater.from(context).inflate(R.layout.left_image_recycleview_item, parent, false));
                break;
            case ITEM_TYPE_THREE:
                holder = new RightImageHolder(LayoutInflater.from(context).inflate(R.layout.right_image_recycleview_item, parent, false));
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case ITEM_TYPE_ONE:
                // 条目1的逻辑
                ((SimpleViewHolder) holder).tvTitle.setText(datas.get(position));
                ((SimpleViewHolder) holder).tvTitle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (listener != null) {
                            listener.onClick(position);
                        }
                    }
                });
                ((SimpleViewHolder) holder).tvTitle.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        if (listener != null) {
                            listener.onLongClick(position);
                        }
                        return true;
                    }
                });

                break;
            case ITEM_TYPE_TWO:
                // 条目2的逻辑
                ((LeftImageHolder) holder).tvTitle.setText(datas.get(position));
                break;
            case ITEM_TYPE_THREE:
                // 条目3的逻辑
                ((RightImageHolder) holder).tvTitle.setText(datas.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return datas == null ? 0 : datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 3 == 0) {
            return ITEM_TYPE_ONE;
        } else if (position % 3 == 1) {
            return ITEM_TYPE_TWO;
        } else {
            return ITEM_TYPE_THREE;
        }
    }

    private ItemListener listener;

    public void setListener(ItemListener listener) {
        this.listener = listener;
    }
}
