package com.example.notificationsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.notificationsample.floatwindow.FloatViewManager;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }

    /**
     * 各种版本
     *
     * @param view
     */
    public void diffBuild(View view) {
        startActivity(new Intent(this, DiffSDKBuildActivity.class));
    }


    /**
     * 特殊的
     *
     * @param view
     */
    public void special(View view) {
        startActivity(new Intent(this, SpecialActivity.class));
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (!NotificationApplication.getInstance().isAppOnForeground()) {
            FloatViewManager.getInstance().onDestory();
            Toast.makeText(HomeActivity.this, "退出程序", Toast.LENGTH_SHORT).show();
        }
    }
}
