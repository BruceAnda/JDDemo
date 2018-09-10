package cn.zhaoliang5156.jddemo.activity.umeng;

import android.Manifest;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.client.android.Intents;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.SocializeUtils;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.x;

import java.util.Map;

import cn.zhaoliang5156.jddemo.R;
import cn.zhaoliang5156.jddemo.activity.base.UmengBaseActivity;

@ContentView(R.layout.activity_umeng_analytics)
public class UmengAnalyticsActivity extends UmengBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_PHONE_STATE,
                    Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.ACCESS_WIFI_STATE
            }, 200);
        }

        x.view().inject(this);
    }

    @Event(R.id.sina_login)
    private void singLogin(View view) {
        // 执行新浪登录的逻辑
        boolean authorize = UMShareAPI.get(this).isAuthorize(this, SHARE_MEDIA.QQ);
        if (authorize) {
            UMShareAPI.get(this).deleteOauth(this, SHARE_MEDIA.QQ, authListener);
        } else {
            UMShareAPI.get(this).doOauthVerify(this, SHARE_MEDIA.QQ, authListener);
        }
    }

    UMAuthListener authListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            Toast.makeText(UmengAnalyticsActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(UmengAnalyticsActivity.this, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(UmengAnalyticsActivity.this, "取消了", Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UMShareAPI.get(this).release();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        UMShareAPI.get(this).onSaveInstanceState(outState);
    }
}
