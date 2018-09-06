package cn.zhaoliang5156.jddemo.activity.base;

import java.lang.ref.WeakReference;

/**
 * MVP p 层规范
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/5
 */
public abstract class IBasePresenter<V extends IBaseView> {

    // View层的引用
    private WeakReference<V> viewRef;

    /**
     * 和View绑定
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/5
     */
    public void attch(V v) {
        viewRef = new WeakReference(v);
    }

    /**
     * 解绑View 释放内存 防止内存泄漏
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/5
     */
    public void detach() {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }

    /**
     * 从弱引用中拿出View对象
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/5
     */
    protected V getView() {
        return viewRef.get();
    }

    /**
     * 判断View是否已经绑定
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/5
     */
    public boolean isViewAttach() {
        return viewRef != null && viewRef.get() != null;
    }
}
