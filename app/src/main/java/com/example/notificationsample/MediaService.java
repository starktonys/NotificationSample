package com.example.notificationsample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Administrator on 2018/7/29.
 */

public class MediaService extends Service {


    //这里是音乐播放的服务
    public static final int COMMAND_START = 1;
    public static final int COMMAND_PAUSE = 2;
    public static final int COMMAND_NEXT = 3;
    public static final int COMMAND_CANCLE = 4;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}
