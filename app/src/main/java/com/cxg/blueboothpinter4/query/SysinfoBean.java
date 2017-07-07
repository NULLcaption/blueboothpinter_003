package com.cxg.blueboothpinter4.query;


import com.cxg.blueboothpinter4.pojo.Sysinfo;

/**
 * bean operation
 * Created by Administrator on 2017/5/5.
 */

public class SysinfoBean extends Sysinfo {

    private static final long serialVersionUID = 1L;

    public SysinfoBean() {
        super();
    }

    public SysinfoBean(String znum, String vbeln, String werks, String ebeln, String matnr, String maktx, String zlichn, String lgmng, String meins, String erfmgl, String erfme, String zmenge, String name1, String name1Id) {
        super(znum, vbeln, werks, ebeln, matnr, maktx, zlichn, lgmng, meins, erfmgl, erfme, zmenge, name1, name1Id);
    }

    public boolean save() {
        try {
            OrmHelper.getInstance().getSysinfoDao().createOrUpdate(this);
            return true;
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
