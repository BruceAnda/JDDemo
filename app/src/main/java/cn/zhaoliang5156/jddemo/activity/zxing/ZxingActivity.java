package cn.zhaoliang5156.jddemo.activity.zxing;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.RGBLuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.encode.QRCodeUtil;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;


import cn.zhaoliang5156.jddemo.R;


@ContentView(R.layout.activity_zxing)
public class ZxingActivity extends AppCompatActivity {

    private static final int CODE_QR = 1000;
    @ViewInject(R.id.iv_qr_code)
    private ImageView ivQrCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        x.view().inject(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.CAMERA}, 100);
        }
    }

    @Event({R.id.btn_encode, R.id.btn_decode, R.id.iv_qr_code})
    private void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_encode:
                //ivQrCode.setImageBitmap(QRCodeUtil.createQRCodeBitmap("http://www.baidu.com", 600, BitmapFactory.decodeResource(getResources(), R.drawable.timg), 0.2F));
                //ivQrCode.setImageBitmap(QRCodeUtil.createQRCodeBitmap("今天好像要下雨", 600));

               // ivQrCode.setImageBitmap(QRCodeUtil.createQRCodeBitmap("用户张三", 600, BitmapFactory.decodeResource(getResources(), R.drawable.timg), 0.2F));
                ivQrCode.setImageBitmap(QRCodeUtil.createQRCodeBitmap("Hello", 600, Color.BLUE, Color.YELLOW));
                break;
            case R.id.btn_decode:
                startActivityForResult(new Intent(this, CaptureActivity.class), CODE_QR);
                break;
            case R.id.iv_qr_code:
                reader();
                break;
        }
    }

    private void reader() {
        Bitmap obmp = ((BitmapDrawable) (ivQrCode).getDrawable()).getBitmap();
        int width = obmp.getWidth();
        int height = obmp.getHeight();
        int[] data = new int[width * height];
        obmp.getPixels(data, 0, width, 0, 0, width, height);
        RGBLuminanceSource source = new RGBLuminanceSource(width, height, data);
        BinaryBitmap bitmap1 = new BinaryBitmap(new HybridBinarizer(source));
        QRCodeReader reader = new QRCodeReader();
        Result re = null;
        try {
            re = reader.decode(bitmap1);
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (ChecksumException e) {
            e.printStackTrace();
        } catch (FormatException e) {
            e.printStackTrace();
        }
        if (re == null) {
            Toast.makeText(this, "未识别", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, re.getText(), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            Toast.makeText(this, "扫描结果：" + result, Toast.LENGTH_SHORT).show();
        }
    }
}
