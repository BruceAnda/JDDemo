package cn.zhaoliang5156.jddemo.activity.crashhandler;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.util.Log;

/**
 * 使用单例封装 全局异常捕获
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/6
 */
public class CrashHandler implements Thread.UncaughtExceptionHandler {

    private static final String TAG = "CrashHandler";

    // 声明对象的引用
    private static CrashHandler crashHandler = new CrashHandler();

    // 声明原来异常捕获处理
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    // 声明全局的Context对象
    private Context mContext;

    // 私有化构造方法
    private CrashHandler() {

    }

    // 提供公开方法对象的方法
    public static CrashHandler getInstance() {
        return crashHandler;
    }

    public void init(Context context) {
        // 获取默认的异常处理
        uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        // 把当前的异常处理设置成默认的处理
        Thread.setDefaultUncaughtExceptionHandler(this);
        // 缓存Context对象
        mContext = context;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Log.i(TAG, "uncaughtException");
        // 程序出现未捕获异常的处理方法
        // 1.先创建个文件 把错误信息 时间 应用版本 系统版本 手机型号 保存到文件中
        // 2.下次打开app的时候把文件上传到服务器
        // 3.公司有个哥们经常查看错误信息，告诉我们程序哪里处错误了，在什么环境下出的错，是哪里出错了，出错的时间
        // 创建Intent
        Intent intent = new Intent("cn.zhaoliang5156.jddemo.errorexit");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);

        Process.killProcess(Process.myPid());
    }
}
