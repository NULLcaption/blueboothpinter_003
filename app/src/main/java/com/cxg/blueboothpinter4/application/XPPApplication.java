package com.cxg.blueboothpinter4.application;

import android.app.Activity;
import android.app.Application;

import com.cxg.blueboothpinter4.R;


/**
 * application static final
 * Created by Administrator on 2017/5/3.
 */

public class XPPApplication extends Application {
    private static XPPApplication instance;
    public static final int NO_NETWORK = 0;
    public static final int SUCCESS = 1;
    public static final int ERR_PASSWORD = 2;
    public static final int ERR_ROLE = 3;
    public static final int NO_USER = 4;
    public static final int FAIL_CONNECT_SERVER = 5;

    public static final int OFFLINE_ERROR_PASSWORD = 8;
    public static final int OFFLINE_LOADED = 9;
    public static final int FAIL = 10;
    public static final int UPDATE_VERSION = 11;
    public static final int NO_MOBILE = 12;
    public static final int NOTBUSINESSPHONE = 13;
    public static final String UPLOAD_FAIL = "fail";
    public static final String UPLOAD_SUCCESS = "success";
    public static final String UPLOAD_SAME = "same";
    public static final String UPLOAD_TIMEOUT = "timeout";
    public static final String UPLOAD_FAIL_CONNECT_SERVER = "5";

    /**
     * 返回或者退出时的页面交互动作
     * */
    public static void  exit(Activity activity) {
        activity.finish();
        activity.overridePendingTransition(R.anim.push_right_in, R.anim.push_right_out);
    }
}
