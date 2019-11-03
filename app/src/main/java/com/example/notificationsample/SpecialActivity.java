package com.example.notificationsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.notificationsample.floatwindow.FloatPermissionManager;

public class SpecialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special);

        //注意事项：
        /**
         * 1.悬挂式通知是Android 5.0之后就有的,并不是网上所说的
         * builder.setFullScreenIntent(xuanpengdIntent, true);
         * 第二个属性必须为true, 亲测没有任何关系,这个只跟你当前项目编译的
         * targetSdkVersion有关，只要targetSdkVersion大于等于21就行
         *
         * 2.折叠式通知栏也是Android5.0之后出现的，需要下啦当前通知才能展示
         * 你设置的折叠部分
         *
         * 3.当你模拟QQ顶部通知栏的时候，我使用的是开启悬浮窗的形式，
         * 首先需要开启悬浮窗权限， 再manifest配置权限
         * Android 8.0对于悬浮窗的开启改变了window的类型，我已经判断可以直接使用
         */

    }

    /**
     * 普通
     *
     * @param view
     */
    public void normal(View view) {
        SpecialUtils.createNormalNotification(this);
    }

    /**
     * 进度条
     *
     * @param view
     */
    public void progress(View view) {
        SpecialUtils.createProgressNotification(this, 24);
    }

    /**
     * BigText通知栏
     *
     * @param view
     */
    public void bigText(View view) {
        SpecialUtils.createBigTextNotification(this);
    }

    /**
     * BigPicture通知栏
     *
     * @param view
     */
    public void bigPicture(View view) {
        SpecialUtils.createBigPictureNotification(this);
    }

    /**
     * Inbox通知栏
     *
     * @param view
     */
    public void inbox(View view) {
        SpecialUtils.createInboxNotification(this);
    }

    /**
     * BigContent通知栏
     * 下拉折叠式
     *
     * @param view
     */
    public void bigContent(View view) {
        SpecialUtils.createBigContentNotification(this);
    }

    /**
     * 悬挂式通知栏
     *
     *
     * @param view
     */
    public void hangUp(View view) {
        SpecialUtils.createHangupNotification(this);
    }


    /**
     * 模仿QQ悬挂通知
     *
     * @param view
     */
    public void imitateQQ(View view) {
        SpecialUtils.createQQTopNotification(this);
    }


    /**
     * 悬挂式通知栏
     *
     * @param view
     */
    public void forground(View view) {
        SpecialUtils.createForgroundNotification(this);
    }

    /**
     * 悬挂式通知栏
     *
     * @param view
     */
    public void music(View view) {
        SpecialUtils.createMusicNotification(this,1);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == FloatPermissionManager.PERMISSION_REQUEST_CODE) {
            SpecialUtils.createQQTopNotification(SpecialActivity.this);
        }
    }

}
