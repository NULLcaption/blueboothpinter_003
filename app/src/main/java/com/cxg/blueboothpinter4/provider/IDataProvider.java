package com.cxg.blueboothpinter4.provider;

import android.app.Activity;

import com.cxg.blueboothpinter4.pojo.Zslips;
import com.cxg.blueboothpinter4.pojo.Ztwm004;

import java.util.List;
import java.util.Map;

/**
 * service interface
 * Created by Administrator on 2017/5/5.
 */

public interface IDataProvider {
    /**
     * init data
     *
     * @param activity
     */
    void startDateUpdateTasks(Activity activity);

    /**
     * 根据单据获取采购物料信息
     *
     * @param string
     * @return
     */

    List<Ztwm004> getPurchasedItemInfo(String string);

    /**
     * 获取单位
     *
     * @return
     */
    Map<String, String> getMeins();

    /**
     * 生成托盘编码
     *
     * @param zslips_001
     * @return
     */
    List<Zslips> getZipcode(Zslips zslips_001);
}
