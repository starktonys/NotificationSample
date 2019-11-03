package com.example.notificationsample;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * @author gexinyu
 */
public class ForegroundService extends Service {

    private static final String TAG = "ForegroundService";

    public ForegroundService() {
    }

    private LocalBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder {

        public ForegroundService getService() {
            return ForegroundService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
        return mBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate:");
        Intent intent = new Intent(this, DetailActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("前台服务")
                .setContentText("前台服务开启通知")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round))
                .setContentIntent(pi)
                .build();

        startForeground(1, notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand:");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy:");
    }

    @Override
    public void onRebind(Intent intent) {
        Log.i(TAG, "onRebind: ");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    //做事情one
    public void doSomeThingOne() {
        Log.i(TAG, "doSomeThingOne: ");
    }

    //做事情two
    public void doSomeThingTwo() {
        Log.i(TAG, "doSomeThingTwo: ");
    }

    //说英文
    public void sayEnglish() {
        Log.i(TAG, "sayEnglish:");
    }

    //唱英文歌
    public void songEnglish() {
        Log.i(TAG, "songEnglish:");
    }


}
