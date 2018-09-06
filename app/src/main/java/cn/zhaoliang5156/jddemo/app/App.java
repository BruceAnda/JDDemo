package cn.zhaoliang5156.jddemo.app;

import android.app.Application;
import android.os.StrictMode;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;

import org.xutils.x;


import cn.zhaoliang5156.jddemo.R;
import cn.zhaoliang5156.jddemo.activity.crashhandler.CrashHandler;

/**
 * 自定义Application
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/3
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initXUtils();

        initBuglyCrashHandler();
        //initCrashHandler();

        initLogger();

        // install leakcanary
        installLeakcanary();
    }

    /**
     * 安装Leakcanary
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/6
     */
    private void installLeakcanary() {
        //enabledStrictMode();
        if (!LeakCanary.isInAnalyzerProcess(this)) {
            LeakCanary.install(this);
        }
    }

    private static void enabledStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                .detectAll() //
                .penaltyLog() //
                .penaltyDeath() //
                .build());
    }

    /**
     * 初始化Logger
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/6
     */
    private void initLogger() {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    /**
     * 初始化腾讯的Bugly
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/6
     */
    private void initBuglyCrashHandler() {
        CrashReport.initCrashReport(getApplicationContext(), getString(R.string.bugly_app_id), false);
    }

    /**
     * 初始化 全局异常捕获
     */
    private void initCrashHandler() {
        CrashHandler.getInstance().init(this);
    }

    /**
     * 初始化 Xutils
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/3
     */
    private void initXUtils() {
        x.Ext.init(this);
    }
}
