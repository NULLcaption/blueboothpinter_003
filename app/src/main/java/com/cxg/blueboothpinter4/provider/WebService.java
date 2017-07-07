package com.cxg.blueboothpinter4.provider;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

import com.cxg.blueboothpinter4.pojo.Zslfa1;
import com.cxg.blueboothpinter4.pojo.Zslips;
import com.cxg.blueboothpinter4.pojo.Ztwm004;
import com.cxg.blueboothpinter4.utils.Helpers;
import com.cxg.blueboothpinter4.utils.WebServiceUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description: webservice服务类
 * author: xg.chen
 * date: 2017/6/29 9:16
 * version: 1.0
*/

public class WebService implements IDataProvider{

    private static WebService instance;

    private static final int TIME_OUT = 30000;

    private static final String TAG = "WebService";

    private WebService() {
        super();
    }

    public static IDataProvider getInstance() {
        if (instance == null)
            instance = new WebService();
        return instance;
    }

    @Override
    public void startDateUpdateTasks(Activity activity) {
        Context ctx = DataProviderFactory.getContext();
        if (ctx != null) {
            SharedPreferences sp = ctx.getSharedPreferences("XPPWebService",
                    Context.MODE_PRIVATE);

            if (sp.contains("lastUpdate")) {
                Date now = new Date();
                String str1 = sp.getString("lastUpdate", "");
                String str2 = Helpers.getDateStrWithoutTime(now);
                if (str1.startsWith(str2)) {
                    Log.d(TAG, "No updates needed at this time.");
                    return;
                }
            }
            if (UpdateTask.getInstance().getStatus() != AsyncTask.Status.RUNNING) {
                sp.edit().putInt("lastUpdatedShopSequence", -1).commit();
                new UpdateTask(activity, false).execute();
            }
        }
    }

    @Override
    public List<Ztwm004> getPurchasedItemInfo(String properties) {
        List<Ztwm004> ztwm004List = new ArrayList<>();
        //String properties1 = "9000000048";
        try {
            List<Object> list = WebServiceUtils.callWebServiceFor005(WebServiceUtils.URL_005, WebServiceUtils.METHOD_NAME_005, properties);
            Ztwm004 ztwm004 = new Ztwm004();
            List<Zslips> zslipsList = new ArrayList<>();
            if (list.size() != 0) {
                Zslfa1 zlfa1 = (Zslfa1) list.get(0);
                ztwm004.setLifnr(zlfa1.getLifnr());
                ztwm004.setEName1(zlfa1.getName1());
                for (int i = 1; i < list.size(); i++) {
                    Zslips zslips = (Zslips) list.get(i);
                    zslipsList.add(zslips);
                }
                ztwm004.setZslipsList(zslipsList);
            }
            ztwm004List.add(ztwm004);

            return ztwm004List;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ztwm004List;
    }

    @Override
    public Map<String, String> getMeins() {
        Map<String,String> map = new HashMap<>();
        try {
            map = WebServiceUtils.callWebServiceFor004(WebServiceUtils.URL_004, WebServiceUtils.METHOD_NAME_004);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public List<Zslips> getZipcode(Zslips zslips_001) {
        //处理后的类型具体的返回值
        List<Zslips> zslipsList = new ArrayList<>();
        try {
            Zslips properties = new Zslips();

            properties.setLgmng(zslips_001.getLgmng());
            properties.setLifnr(zslips_001.getLifnr());
            properties.setMatnr(zslips_001.getMatnr());
            properties.setMeins(zslips_001.getMeins());
            properties.setMenge(zslips_001.getMenge());
            properties.setWerks(zslips_001.getWerks());
            properties.setZgrdate(zslips_001.getZgrdate());
            properties.setZlichn(zslips_001.getZlichn());
            properties.setZnum(zslips_001.getZnum());
            properties.setZproddate(zslips_001.getZproddate());
            properties.setQcnum(zslips_001.getQcnum());
            properties.setZipcode(zslips_001.getZipcode());

            List<Object> list = WebServiceUtils.callWebServiceFor006(WebServiceUtils.URL_006, WebServiceUtils.METHOD_NAME_006, properties);
            if (list.size()!=0) {
                Zslips zslips_002 = new Zslips();

                zslips_002.setZipcode(list.get(0).toString());
                zslips_002.setCharg(list.get(1).toString());

                zslipsList.add(zslips_002);
            }
            return zslipsList;
        } catch (Exception e ) {
            e.printStackTrace();
        }

        return zslipsList;
    }

}
