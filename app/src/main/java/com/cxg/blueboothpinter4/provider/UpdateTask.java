package com.cxg.blueboothpinter4.provider;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import com.cxg.blueboothpinter4.R;
import com.cxg.blueboothpinter4.activity.BlueBoothPinterActivity;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2017/5/5.
 */

public class UpdateTask extends AsyncTask<Object, Object, Integer>{

    private static final String TAG = "UpdateTask";
    private static final int TIMEOUT = 5000;
    private NotificationManager mNotificationManager;
    private static final Long delay = 1000L;
    private static UpdateTask instance;
    private static int FIAL = 0;
    private static int SUCCESS = 1;
    private static int FIAL_SKU = 2;
    private static int FIAL_CHANNEL = 3;
    private static int FIAL_DICTIONARY = 4;
    private static int FIAL_TIME = 5;
    private static int FIAL_TIMEOUT = 6;
    private static int NEW_VERSION = 7;
    private static int FIAL_MENU = 8;
    private static int FIAL_ROUTE = 9;
    private static int FIAL_KunnrStockDate = 10;
    private static int FIAL_ORDER = 11;
    private static int FIAL_SKUUNIT = 12;
    private final Lock running = new ReentrantLock();
    //	private static Activity activity;
    private static Context context;
    private static boolean isRefresh ;//是否自动刷新页面

    public UpdateTask(Context context,boolean isRefresh) {
        UpdateTask.context = context;
        UpdateTask.isRefresh = isRefresh;
    }

    public static UpdateTask getInstance() {
		/* if (instance == null) */
        instance = new UpdateTask(context,isRefresh);
        return instance;
    }

    @Override
    protected void onPreExecute() {
        Log.d(TAG, "Starting Update Task");
    }

    protected void onPostExecute(Integer result) {

        Context ctx = DataProviderFactory.getContext();
        // 创建一个NotificationManager的引用
        mNotificationManager = (NotificationManager) ctx
                .getSystemService(Context.NOTIFICATION_SERVICE);
        String str = "数据同步完成....";
        switch (result) {
            case 0:
                str = "数据同步失败....";
                break;
            // case 1:
            // str = "数据同步完成....";
            // break;
            case 2:
                str = "sku同步失败....";
                break;
            case 3:
                str = "渠道信息同步失败....";
                break;
            case 4:
                str = "陈列数据同步失败....";
                break;
            case 5:
                str = "服务器时间同步失败....";
                break;
            case 6:
                str = "连接服务器超时....";
                break;
            case 7:
                str = "同步成功，监测到新版本......";
                break;
            case 8:
                str = "菜单同步失败.....";
                break;
            case 9:
                str = "线路同步失败.....";
                break;
            case 10:
                str = "库存上报时间同步失败.....";
                break;
            case 11:
                str = "订单同步失败.....";
                break;
            case 12:
                str = "门店分销量sku同步失败.....";
                break;
            default:
                break;
        }

        Notification notification = new Notification(
                R.drawable.notification_icon, str, System.currentTimeMillis());
        // // // 点通知返回原来activity
        Intent notificationIntent = new Intent(ctx, BlueBoothPinterActivity.class); // 点击该通知后跳转的Activity
        notificationIntent.setAction(Intent.ACTION_MAIN);
        notificationIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK| Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent contentIntent = PendingIntent.getActivity(ctx, 0,
                notificationIntent, 0);
        //notification.setLatestEventInfo(ctx, "香飘飘", "香飘飘", contentIntent);
        mNotificationManager.notify(0, notification);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                mNotificationManager.cancel(0);
            }
        }, delay);

        instance = null;
    }

    @SuppressLint("SimpleDateFormat")
    @Override
    protected Integer doInBackground(Object... params) {
        running.lock();
        // boolean flag = true;
        try {

            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return FIAL;
        } finally {
            running.unlock();
        }
    }

    public void waitTimeout() {
        try {
            running.tryLock(TIMEOUT, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
        }
    }

}
