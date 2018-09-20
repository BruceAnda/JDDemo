package cn.zhaoliang5156.jddemo.activity.okhttp.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 测试重定向拦截器
 *
 * @author zhaoliang
 * @version 1.0
 * @create 2018/9/12
 */
public class RedirectInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        // 获取请求对象
        Request request = chain.request();

        // 创建一个新的请求对象
        Request build = request.newBuilder()
                .url("https://www.baidu.com")
                .build();

        // 执行新的请求对象
        return chain.proceed(build);
    }
}
