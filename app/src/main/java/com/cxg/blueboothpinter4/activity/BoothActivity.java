package com.cxg.blueboothpinter4.activity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.cxg.blueboothpinter4.R;
import com.cxg.blueboothpinter4.application.XPPApplication;
import com.cxg.blueboothpinter4.pojo.Zslips;
import com.cxg.blueboothpinter4.utils.Bluetooth;
import com.cxg.blueboothpinter4.utils.ExitApplication;
import com.cxg.blueboothpinter4.utils.MessageBox;
import com.cxg.blueboothpinter4.utils.StatusBox;
import com.cxg.blueboothpinter4.utils.lable_sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * 蓝牙打印首页
 */
public class BoothActivity extends AppCompatActivity {

    /*蓝牙适配器*/
    public static BluetoothAdapter myBluetoothAdapter;
    /*远程连接地址*/
    public String SelectedBDAddress;
    /*打印机盒子状态*/
    StatusBox statusBox;
    /*盒子信息*/
    MessageBox megBox;
    /*编辑张数*/
    TextView tv1;
    /*打印对象*/
    Zslips zslips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_booth);

        Button Button1 = (Button) findViewById(R.id.button1);
        statusBox = new StatusBox(this, Button1);
        megBox = new MessageBox(this);
        /*tv1 = (EditText) findViewById(R.id.editText);
        tv1.setText("10");*/
        SelectedBDAddress = "";

        //接收页面传入的数据
        Bundle bun = getIntent().getExtras();
        if (bun != null) {
            zslips = (Zslips) bun.get("zslips");
        }

        /*判断设备是否支持蓝牙设备*/
        boolean bluetoothDevice = ListBluetoothDevice();
        if (!bluetoothDevice) {
            String mags = "与蓝牙设备匹配有问题，请检查后重试!";
            showMessage(mags);
            finish();//用于结束一个Activity的生命周期
        }

        /*循环多张打印*/
        Button1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Print1(SelectedBDAddress, zslips);
            }
        });

        /*单张打印———格式不同*/
        Button Button3 = (Button) findViewById(R.id.button3);
        Button3.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                XPPApplication.exit(BoothActivity.this);
            }
        });

        ExitApplication.getInstance().addActivity(this);
    }

    /**
     * 循环多张打印
     *
     * @param BDAddress
     */
    private void Print1(String BDAddress, Zslips zslips) {
        statusBox.Show("正在打印...");
        if (!Bluetooth.OpenPrinter(BDAddress)) {
            showMessage(Bluetooth.ErrorMessage);
            Bluetooth.close();
            statusBox.Close();
            return;
        }
        // create page
        String name = zslips.getMenge();//标签个数
        int num = Integer.parseInt(name);
        lable_sdk.SelectPage(0);
        lable_sdk.ClearPage();
        lable_sdk.SelectPage(1);
        lable_sdk.ClearPage();
        lable_sdk.SetPageSize(83 * 8, 72 * 8);
        lable_sdk.ErrorConfig(true);
        for (int i = 1; i <= num; i++) {
            DrawContent(zslips);// content
            lable_sdk.PrintPage(0x04, 150, false);
            lable_sdk.ClearPage();
        }
        Bluetooth.close();
        statusBox.Close();
    }// print1


    /**
     * 打印数据输出时间设置
     *
     * @param timeout
     * @return
     */
    public static int zp_realtime_status(int timeout) {
        byte[] status = new byte[8];
        byte[] buf = new byte[11];
        buf[0] = 0x1f;
        buf[1] = 0x00;
        buf[2] = 0x06;
        buf[3] = 0x00;
        buf[4] = 0x07;
        buf[5] = 0x14;
        buf[6] = 0x18;
        buf[7] = 0x23;
        buf[8] = 0x25;
        buf[9] = 0x32;
        buf[10] = 0x00;
        Bluetooth.SPPWrite(buf, 10);
        if (Bluetooth.SPPReadTimeout(status, 1, timeout) == false) {
            return -1;
        }
        return status[0];
    }

    /**
     * 页面布局
     *
     * @param zslips 对象参数
     */
    private void DrawContent(Zslips zslips) {
        try {
            lable_sdk.DrawText(7 * 8, 8 * 8, "物料:" + zslips.getMatnr(), 0x00, 0x0);
            zp_realtime_status(1000);
            lable_sdk.DrawText(7 * 8, 12 * 8, zslips.getMaktx(), 0x00, 0x0);
            zp_realtime_status(1000);
            lable_sdk.DrawText(7 * 8, 16 * 8, "供应商:" + zslips.getEName1(), 0, 0);
            zp_realtime_status(1000);
            lable_sdk.DrawText(7 * 8, 20 * 8, "生产日期:" + zslips.getZgrdate(), 0, 0);
            zp_realtime_status(1000);
            lable_sdk.DrawText(7 * 8, 24 * 8, "批次:" + zslips.getCharg(), 0, 0);
            zp_realtime_status(1000);
            lable_sdk.DrawText(7 * 8, 29 * 8, "版本:" + zslips.getZlichn(), 0, 0);
            zp_realtime_status(1000);
            lable_sdk.DrawText(7 * 8, 31 * 8, "入库日期:" + zslips.getZproddate(), 0, 0);
            zp_realtime_status(1000);
            lable_sdk.DrawText(7 * 8, 35 * 8, "数量:" + zslips.getLgmng(), 0, 0);
            zp_realtime_status(1000);
            lable_sdk.DrawCode1D(7 * 8, 39 * 8, zslips.getZipcode(), 0x1, 0x03, (16 * 8));
            zp_realtime_status(1000);
        } catch (Exception e) {
            e.printStackTrace();
            showMessage("打印页面参数错误!");
        }
    }// DrawContent

    /**
     * 远程连接设备的蓝牙列表
     *
     * @return
     */
    public boolean ListBluetoothDevice() {
        final List<Map<String, String>> list = new ArrayList<>();
        ListView listView = (ListView) findViewById(R.id.listView1);
        SimpleAdapter m_adapter = new SimpleAdapter(this, list,
                android.R.layout.simple_list_item_2, new String[]{
                "DeviceName", "BDAddress"}, new int[]{
                android.R.id.text1, android.R.id.text2});
        listView.setAdapter(m_adapter);

        if ((myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter()) == null) {
            Toast.makeText(this, "没有找到蓝牙适配器", Toast.LENGTH_LONG).show();
            return false;
        }
        if (!myBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(
                    BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 2);
        }

        Set<BluetoothDevice> pairedDevices = myBluetoothAdapter
                .getBondedDevices();
        if (pairedDevices.size() <= 0) {
            return false;
        }
        for (BluetoothDevice device : pairedDevices) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("DeviceName", device.getName());
            map.put("BDAddress", device.getAddress());
            list.add(map);
        }
        listView.setOnItemClickListener(new ListView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                SelectedBDAddress = list.get(position).get("BDAddress");
                if (((ListView) parent).getTag() != null) {
                    ((View) ((ListView) parent).getTag())
                            .setBackgroundDrawable(null);
                }
                ((ListView) parent).setTag(view);
                view.setBackgroundColor(Color.YELLOW);
            }
        });
        return true;
    }// ListBluetoothDevice

    /**
     * 输出信息
     *
     * @param str
     */
    public void showMessage(String str) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }
}
