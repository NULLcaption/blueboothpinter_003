package com.cxg.blueboothpinter4.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.cxg.blueboothpinter4.R;
import com.cxg.blueboothpinter4.adapter.BlueBoothPinterAdapter;
import com.cxg.blueboothpinter4.pojo.Zslips;
import com.cxg.blueboothpinter4.pojo.Ztwm004;
import com.cxg.blueboothpinter4.provider.DataProviderFactory;
import com.cxg.blueboothpinter4.utils.ExitApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description: 采购物料系统首页
 * author: xg.chen
 * date: 2017/6/29 9:22
 * version: 1.0
 */
public class BlueBoothPinterActivity extends AppCompatActivity {

    /*详单列表*/
    private List<Zslips> zslipsList_001;
    /*通过接口获取到的值*/
    private List<Zslips> zslipsList;
    /*详单适配器*/
    private BlueBoothPinterAdapter blueBoothPinterAdapter;
    /*输入值:单据号码*/
    private EditText znum;
    /*输出值:供应商名称*/
    private TextView EName1;
    /*输出值:列表*/
    private ListView zslipsListView;
    private Dialog waitingDialog;
    private Map<String, String> map = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booth);

        //初始化视图
        initView();
        //加载数据
        initData();

        ExitApplication.getInstance().addActivity(this);

    }

    /**
     * description: init UI view
     * author: xg.chen
     * date: 2017/6/29 9:41
     * version: 1.0
     */
    private void initView() {
        znum = (EditText) findViewById(R.id.znum);//单据号
        znum.setInputType(InputType.TYPE_NULL);
        EName1 = (TextView) findViewById(R.id.EName1);//供应商名称
        zslipsListView = (ListView) findViewById(R.id.lv_sysinfo);//详单列表

        findViewById(R.id.button_ok).setOnClickListener(BtnClicked);//确定按钮
        findViewById(R.id.button_no).setOnClickListener(BtnClicked);//退出按钮
    }

    /**
     * description: init data fot service test data
     * author: xg.chen
     * date: 2017/6/29 9:41
     * version: 1.0
     */
    private void initData() {
        if (zslipsList == null) {
            zslipsList_001 = new ArrayList<>();
        } else if (zslipsList.size() != 0) {
            blueBoothPinterAdapter = new BlueBoothPinterAdapter(zslipsList, this);
            zslipsListView.setAdapter(blueBoothPinterAdapter);
        }
        //加载数据获取单位
        new getMeinsTask().execute();
    }

    /**
     * 进入时加载单位
     */
    private class getMeinsTask extends AsyncTask<String, Integer, Map<String, String>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showWaitingDialog();
        }

        @Override
        protected Map<String, String> doInBackground(String... params) {
            return DataProviderFactory.getProvider().getMeins();
        }

        @Override
        protected void onPostExecute(Map<String, String> result) {
            dismissWaitingDialog();
            if (result.size() != 0) {
                map = result;
            } else {
                Toast.makeText(getApplicationContext(), "连接超时...退出稍后重试...", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * description: 按钮事件监听类
     * author: xg.chen
     * date: 2017/6/23 15:30
     * version: 1.0
     */
    private View.OnClickListener BtnClicked = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button_ok:
                    if (!"".equals(znum.getText().toString().trim())) {
                        Pattern p2 = Pattern.compile("\\d");
                        String znum_001 = znum.getText().toString().trim();
                        Matcher matcher = p2.matcher(znum_001);
                        if (matcher.matches()) {
                            Toast.makeText(getApplicationContext(), "请填写准确的单据号码...", Toast.LENGTH_SHORT).show();
                            break;
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "请输入物料码!", Toast.LENGTH_SHORT).show();
                        break;
                    }

                    //根据单据获取相关的采购物料详细信息
                    new getPurchasedItemInfo().execute(znum.getText().toString().trim());

                    break;
                case R.id.button_no:
                    ExitApplication.getInstance().exit();
                    Toast.makeText(getApplicationContext(), "退出应用", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * description: 根据单据获取相关的采购物料详细信息
     * author: xg.chen
     * date: 2017/6/29 15:34
     * version: 1.0
     */
    private class getPurchasedItemInfo extends AsyncTask<String, Integer, List<Ztwm004>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showWaitingDialog();
        }

        @Override
        protected List<Ztwm004> doInBackground(String... params) {
            String string = params[0];
            return DataProviderFactory.getProvider().getPurchasedItemInfo(string);
        }

        @Override
        protected void onPostExecute(List<Ztwm004> result) {
            dismissWaitingDialog();
            if (result.size() != 0) {
                EName1.setText(result.get(0).getEName1());
                zslipsList = result.get(0).getZslipsList();
                initData();
            } else {
                Toast.makeText(getApplicationContext(), "连接超时...退出稍后重试...", Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * description: 加载图片开始
     * author: xg.chen
     * date: 2017/6/26 11:56
     * version: 1.0
     */
    private void showWaitingDialog() {
        if (waitingDialog == null) {

            waitingDialog = new Dialog(this, R.style.TransparentDialog);
            waitingDialog.setContentView(R.layout.login_waiting_dialog);
            DialogInterface.OnShowListener showListener = new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialog) {
                    ImageView img = (ImageView) waitingDialog.findViewById(R.id.loading);
                    ((AnimationDrawable) img.getDrawable()).start();
                }
            };
            DialogInterface.OnCancelListener cancelListener = new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    // updateButtonLook(false);
                }
            };
            waitingDialog.setOnShowListener(showListener);
            waitingDialog.setCanceledOnTouchOutside(false);
            waitingDialog.setOnCancelListener(cancelListener);
            waitingDialog.show();
        }
    }

    /**
     * description: 加载结束
     * author: xg.chen
     * date: 2017/6/26 11:56
     * version: 1.0
     */
    private void dismissWaitingDialog() {
        if (waitingDialog != null) {
            ImageView img = (ImageView) waitingDialog.findViewById(R.id.loading);
            ((AnimationDrawable) img.getDrawable()).stop();

            waitingDialog.dismiss();
            waitingDialog = null;
        }
    }
}
