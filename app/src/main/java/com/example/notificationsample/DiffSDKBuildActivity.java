package com.example.notificationsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DiffSDKBuildActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * 针对不同的SDK版本有不同的通知形式
         * 最后生成的通知栏跟你当前targetSDK有关系
         * 例如我当前编译所用的就是24：targetSdkVersion = 24
         */

    }

    /**
     * api 11之前的通知样式 （）
     *
     * @param view
     */
    public void beforeApi11(View view) {
        NotificationUtils.createBeforeApi11(this);
    }


    /**
     * api 11和16之间的通知样式 （）
     *
     * @param view
     */
    public void api11To16(View view) {
        NotificationUtils.createBewApi11To16(this);
    }

    /**
     * api 4之后通用的通知样式 （）
     *
     * @param view
     */
    public void afterapi4Common(View view) {
        NotificationUtils.createCommonApiAfter4(this);
    }

    /**
     * api 26之后通知样式 （）
     *
     * @param view
     */
    public void afterapi26(View view) {
        NotificationUtils.createApi26(this);
    }


}
