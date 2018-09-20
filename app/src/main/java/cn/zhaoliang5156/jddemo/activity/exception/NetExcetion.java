package cn.zhaoliang5156.jddemo.activity.exception;

/**
 * 自定义的网络异常
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/12
 */
public class NetExcetion extends Exception {

    private String errorMessage;

    public NetExcetion(String message) {
        this.errorMessage = message;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }
}
