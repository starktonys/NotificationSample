package com.example.notificationsample;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * @author gexinyu
 */
public class NotificationUtils {


    //android 8.0之后需要用到的渠道通知栏
    public static final String id = "channel_1";
    public static final String name = "channel_name_1";


    public static void createBeforeApi11(Context context) {
        NotificationManager noteManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification(R.mipmap.ic_launcher, "这是api11之前的通知栏内容", System.currentTimeMillis());
        notification.tickerText="api11之前的标题";
        //方法已经废弃了
//        notification.setLatestEventInfo(context, "api11之前的标题", "api11之前的内容");
        noteManager.notify(1, notification);
    }


    public static void createBewApi11To16(Context context) {
        // API Level >= 11 (Android 3.0) && API Level < 16 (Android 4.1)
        NotificationManager noteManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("api位于11和16之间的标题")
                .setContentText("api位于11和16之间的内容")
                .setTicker("api位于11和16之间的Ticker")
                .setWhen(System.currentTimeMillis());
        Notification note = builder.getNotification(); // 调用getNotification()来生成Notification

        noteManager.notify(1, note);
    }


    /**
     * api 大于4之后通用的（推荐使用）
     *
     * @param context
     */
    public static void createCommonApiAfter4(Context context) {
        // API Level >= 11 (Android 3.0) && API Level < 16 (Android 4.1)
        NotificationManager noteManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        //API Level >= 4 (Android 1.6) && API Level < 16 (Android 4.1)
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("api4之后通用的标题")
                .setContentText("api4之后通用的内容")
                .setTicker("api4之后通用的Ticker")
                .setWhen(System.currentTimeMillis());
        Notification note = builder.getNotification(); //调用builder.getNotification()来生成Notification

        noteManager.notify(1, note);
    }


    /**
     * api 大于26之后（android O  8.0）
     *
     * @param context
     */
    public static void createApi26(Context context) {
        NotificationManager noteManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        NotificationChannel channel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_HIGH);
        noteManager.createNotificationChannel(channel);

        Notification.Builder builder = new Notification.Builder(context, id)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("api26之后的标题")
                .setContentText("api26之后的内容")
                .setTicker("api26之后的Ticker")
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true);

        Notification notification = builder.build();

        noteManager.notify(1, notification);
    }
}
