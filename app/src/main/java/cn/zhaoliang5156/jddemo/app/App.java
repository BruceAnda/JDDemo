package cn.zhaoliang5156.jddemo.app;

import android.app.Application;
import android.os.StrictMode;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.bugly.crashreport.CrashReport;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

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

        initUmeng();
    }

    /**
     * 初始化Umeng
     *
     * @author zhaoliang
     * @version 1.0
     * @create 2018/9/10
     */
    private void initUmeng() {
        // UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, "5b9604788f4a9d37b90000d1");
        UMConfigure.init(this, "5b9604788f4a9d37b90000d1", "Umeng", UMConfigure.DEVICE_TYPE_PHONE,
                "");
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

    {
        PlatformConfig.setWeixin("wxdc1e388c3822c80b", "3baf1193c85774b3fd9d18447d76cab0");
        //豆瓣RENREN平台目前只能在服务器端配置
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
        PlatformConfig.setYixin("yxc0614e80c9304c11b0391514d09f13bf");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setTwitter("3aIN7fuF685MuZ7jtXkQxalyi", "MK6FEYG63eWcpDFgRYw4w9puJhzDl0tyuqWjZ3M7XJuuG7mMbO");
        PlatformConfig.setAlipay("2015111700822536");
        PlatformConfig.setLaiwang("laiwangd497e70d4", "d497e70d4c3e4efeab1381476bac4c5e");
        PlatformConfig.setPinterest("1439206");
        PlatformConfig.setKakao("e4f60e065048eb031e235c806b31c70f");
        PlatformConfig.setDing("dingoalmlnohc0wggfedpk");
        PlatformConfig.setVKontakte("5764965", "5My6SNliAaLxEm3Lyd9J");
        PlatformConfig.setDropbox("oz8v5apet3arcdy", "h7p2pjbzkkxt02a");

    }
}
