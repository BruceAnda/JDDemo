package cn.zhaoliang5156.jddemo.activity.recycleview.listener;

/**
 * RecycleView item 点击事件
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/11
 */
public interface ItemListener {

    void onClick(int position);

    void onLongClick(int position);
}
