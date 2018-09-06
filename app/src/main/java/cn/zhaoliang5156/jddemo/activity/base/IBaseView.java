package cn.zhaoliang5156.jddemo.activity.base;

/**
 * MVP v 的规范接口
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/5
 */
public interface IBaseView<T> {

    void showData(T data);
}
