package cn.zhaoliang5156.jddemo.activity.base;

public interface MVPCallback<T> {

    void onSuccess(T data);

    void onError();

    void onComplete();
}
