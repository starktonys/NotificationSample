package com.example.notificationsample;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.notificationsample.floatwindow.FloatPermissionManager;
import com.example.notificationsample.floatwindow.FloatViewManager;

import static android.app.PendingIntent.FLAG_CANCEL_CURRENT;
import static com.example.notificationsample.R.mipmap.ic_launcher_round;

/**
 * Created by Administrator on 2018/7/28.
 */

public class SpecialUtils {

    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_PROGRESS = 2;
    public static final int TYPE_BIGTEXT = 3;
    public static final int TYPE_BIGPICTURE = 4;
    public static final int TYPE_INBOX = 5;
    public static final int TYPE_BIGCONTENT = 6;
    public static final int TYPE_HANGUP = 7;
    public static final int TYPE_IMITATE_QQ = 8;
    public static final int TYPE_FORGROUND_SERVICE = 9;
    public static final int TYPE_CUSTOM = 10;


    /**
     * 普通的
     *
     * @param context
     */
    public static void createNormalNotification(Context context) {
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        //Ticker是状态栏显示的提示
        builder.setTicker("简单Notification");
        //第一行内容  通常作为通知栏标题
        builder.setContentTitle("标题");
        //第二行内容 通常是通知正文
        builder.setContentText("通知内容");
        //第三行内容 通常是内容摘要什么的 在低版本机器上不一定显示
        builder.setSubText("这里显示的是通知第三行内容！");
        //ContentInfo 在通知的右侧 时间的下面 用来展示一些其他信息
        builder.setContentInfo("2");
        //number设计用来显示同种通知的数量和ContentInfo的位置一样，如果设置了ContentInfo则number会被隐藏
//        builder.setNumber(2);
        //可以点击通知栏的删除按钮删除
        builder.setAutoCancel(true);
        //系统状态栏显示的小图标
        builder.setSmallIcon(R.mipmap.ic_launcher);
        //下拉显示的大图标
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), ic_launcher_round));
        Intent intent = new Intent(context, DetailActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, 1, intent, FLAG_CANCEL_CURRENT);

//        FLAG_CANCEL_CURRENT：如果构建的PendingIntent已经存在，则取消前一个，重新构建一个。
//        FLAG_NO_CREATE：如果前一个PendingIntent已经不存在了，将不再构建它。
//        FLAG_ONE_SHOT：表明这里构建的PendingIntent只能使用一次。
//        FLAG_UPDATE_CURRENT：如果构建的PendingIntent已经存在，则替换它，常用。

        //点击跳转的intent
        builder.setContentIntent(pIntent);
        //通知默认的声音 震动 呼吸灯
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        Notification notification = builder.build();
        mNotificationManager.notify(TYPE_NORMAL, notification);
    }

    /**
     * 进度的通知栏
     *
     * @param context
     * @param progress
     */
    public static void createProgressNotification(Context context, int progress) {
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), ic_launcher_round));
        //禁止用户点击删除按钮删除
        builder.setAutoCancel(false);
        //禁止滑动删除
        builder.setOngoing(true);
        //取消右上角的时间显示
        builder.setShowWhen(false);
        builder.setContentTitle("下载中..." + progress + "%");
        builder.setProgress(100, progress, false);
        builder.setOngoing(true);
        builder.setShowWhen(false);
        Intent intent = new Intent(context, DownloadService.class);
        intent.putExtra("command", 1);
        Notification notification = builder.build();
        mNotificationManager.notify(TYPE_PROGRESS, notification);
    }

    /**
     * 折叠式的显示文本样式
     *
     * @param context
     */
    public static void createBigTextNotification(Context context) {
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("BigTextStyle");
        builder.setContentText("BigTextStyle演示示例");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), ic_launcher_round));
        android.support.v4.app.NotificationCompat.BigTextStyle style = new android.support.v4.app.NotificationCompat.BigTextStyle();
        style.bigText("这里是点击通知后要显示的正文，可以换行可以显示很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长很长");
        style.setBigContentTitle("点击后的标题");
        //SummaryText没什么用 可以不设置
        style.setSummaryText("末尾只一行的文字内容");
        builder.setStyle(style);
        builder.setAutoCancel(true);
        Intent intent = new Intent(context, DetailActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, 1, intent, 0);
        builder.setContentIntent(pIntent);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        Notification notification = builder.build();
        mNotificationManager.notify(TYPE_BIGTEXT, notification);
    }


    /**
     * 折叠式的显示大图样式
     *
     * @param context
     */
    public static void createBigPictureNotification(Context context) {
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("BigPictureStyle");
        builder.setContentText("BigPicture演示示例");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher_round));
        NotificationCompat.BigPictureStyle style = new NotificationCompat.BigPictureStyle();
        style.setBigContentTitle("BigContentTitle");
        style.setSummaryText("SummaryText");
        style.bigPicture(BitmapFactory.decodeResource(context.getResources(), R.mipmap.fly_pig));
        builder.setStyle(style);
        builder.setAutoCancel(true);
        Intent intent = new Intent(context, DetailActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, 1, intent, 0);
        //设置点击大图后跳转
        builder.setContentIntent(pIntent);
        Notification notification = builder.build();
        mNotificationManager.notify(TYPE_BIGPICTURE, notification);
    }


    /**
     * 这种事折叠式的 显示多行的样式
     *
     * @param context
     */
    public static void createInboxNotification(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.mipmap.lol_logo);
        builder.setContentTitle("LOL");//系统限制，可能不显示
        builder.setContentText("有没有开黑的");//系统限制，可能不显示
        builder.setDefaults(Notification.DEFAULT_ALL);
        //添加宽视图
        NotificationCompat.InboxStyle style = new NotificationCompat.InboxStyle();
        style.setBigContentTitle("皮尔特沃夫");
        //由手机屏幕像素决定显示多少
        style.addLine("刀锋之影");
        style.addLine("放逐之刃");
        style.addLine("无双剑姬");
        style.addLine("疾风剑豪");
        style.addLine("影流之主");
        style.addLine("武器大师");
        style.addLine("诺克萨斯之手");
        style.addLine("德玛西亚之力");
        style.addLine("德玛西亚皇子");
        style.addLine("寒冰射手");
        style.setSummaryText("每个人都曾是坑");//添加概要
        builder.setStyle(style);
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        Notification n = builder.build();
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(TYPE_INBOX, n);
    }


    /**
     * 创建下拉布局 与折叠式一样，已经过时
     *
     * @param context
     */
    public static void createBigContentNotification(Context context) {
        Notification foregroundNote;
        RemoteViews bigView = new RemoteViews(context.getPackageName(),
                R.layout.notification_layout_big);

        Notification.Builder mNotifyBuilder = new Notification.Builder(context);
        foregroundNote = mNotifyBuilder.setContentTitle("下拉标题")
                .setContentText("下拉展开所有的布局")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                .build();
        foregroundNote.bigContentView = bigView;

        NotificationManager mNotifyManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotifyManager.notify(TYPE_BIGCONTENT, foregroundNote);
    }

    /**
     * 悬挂式通知 记得 5.0之后才能显示，并且有些手机需要手动开启
     *
     * @param context
     */
    public static void createHangupNotification(Context context) {
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("悬挂式通知");
        builder.setContentText("部分手机（小米）请在设置通知管理中开启消息横幅提醒权限");
        builder.setDefaults(NotificationCompat.DEFAULT_ALL);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher_round));
        Intent intent = new Intent(context, DetailActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, 1, intent, 0);
        builder.setContentIntent(pIntent);
        //这句是重点
        builder.setFullScreenIntent(pIntent, true);
        builder.setAutoCancel(true);
        Notification notification = builder.build();
        mNotificationManager.notify(TYPE_HANGUP, notification);
    }


    /**
     * 这里是开启类似QQ一样的悬挂式的通知
     *
     * @param context
     */
    public static void createQQTopNotification(Context context) {
        if (FloatPermissionManager.getInstance().checkPermission(context)) {
            //开启悬挂
            FloatViewManager.getInstance().startFloatWindow();
        } else {
            Toast.makeText(context, "权限授予失败，无法开启悬浮窗", Toast.LENGTH_SHORT).show();
            FloatPermissionManager.getInstance().applyPermission(context);
        }
    }


    /**
     * 开启前台的通知栏
     *
     * @param context
     */
    public static void createForgroundNotification(Context context) {
        //这里的作用很多 作为推送、后台音乐播放
        Intent intent = new Intent(context, ForegroundService.class);
        context.startService(intent);
    }


    /**
     * 自定义通知栏  通过点击事件控制音乐的播放与暂停 下一首 以及取消
     *
     * @param context
     * @param command
     */
    public static void createMusicNotification(Context context, int command) {
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("自定义通知标题");
        builder.setContentText("自定义通知栏示例");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher_round));
        builder.setAutoCancel(false);
        builder.setOngoing(true);//代表是常驻的，主要是配合服务
        builder.setShowWhen(false);

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notification_custom);
        //这里要根据当前的音乐状态显示不同的图标

        //如果音乐更新的话 ，需要动态的设置背景  我这图标找的不好
//        if (command == MediaService.COMMAND_START) {
//            remoteViews.setImageViewResource(R.id.btn1, R.mipmap.pause);
//        } else if (command == MediaService.COMMAND_PAUSE) {
//            remoteViews.setImageViewResource(R.id.btn1, R.mipmap.play);
//        }

        //getService(Context context, int requestCode, @NonNull Intent intent, @Flags int flags)
        //不同控件的requestCode需要区分开 getActivity broadcoast同理

        //暂停或者重新播放
        Intent startOrPause = new Intent(context, MediaService.class);
        if (command == MediaService.COMMAND_START) {
            startOrPause.putExtra("command", MediaService.COMMAND_START);
        } else if (command == MediaService.COMMAND_PAUSE) {
            startOrPause.putExtra("command", MediaService.COMMAND_PAUSE);
        }
        PendingIntent startOrPauseP = PendingIntent.getService(context, MediaService.COMMAND_START, startOrPause, 0);
        remoteViews.setOnClickPendingIntent(R.id.btn1, startOrPauseP);

        //这里是下一首的command
        Intent nextSong = new Intent(context, MediaService.class);
        nextSong.putExtra("command", MediaService.COMMAND_NEXT);
        PendingIntent nextSongP = PendingIntent.getService(context, MediaService.COMMAND_NEXT, nextSong, 0);
        remoteViews.setOnClickPendingIntent(R.id.btn2, nextSongP);

        //取消 关闭当前服务
        Intent mediaCancle = new Intent(context, MediaService.class);
        mediaCancle.putExtra("command", MediaService.COMMAND_CANCLE);
        PendingIntent mediaCancleP = PendingIntent.getService(context, MediaService.COMMAND_CANCLE, mediaCancle, 0);
        remoteViews.setOnClickPendingIntent(R.id.btn3, mediaCancleP);

        builder.setContent(remoteViews);
        Notification notification = builder.build();
        mNotificationManager.notify(TYPE_CUSTOM, notification);
    }
}
