package com.example.notificationsample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2018/7/29.
 */

public class DownloadService extends Service {

    //这里是做下载的时候使用
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
