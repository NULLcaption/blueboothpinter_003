package com.cxg.blueboothpinter4.utils;

import android.app.Activity;
import android.app.Application;

import java.util.LinkedList;
import java.util.List;

/**
 * 退出当前应用
 * Created by Administrator on 2017/6/15.
 */

public class ExitApplication extends Application {
    private List<Activity> activityList = new LinkedList<>();
    private static ExitApplication instance;

    private ExitApplication() {

    }

    // 单例模式中获取唯一的ExitApplication实例
    public static ExitApplication getInstance() {
        if (null == instance) {
            instance = new ExitApplication();
        }
        return instance;
    }

    // 将Activity添加到容器中
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    // 当要退出Activity时，遍历所有Activity 并finish
    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        System.exit(0);
    }
}
