package com.cxg.blueboothpinter4.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

/**
 * 数据实体类
 * Created by Administrator on 2017/4/28.
 */
@DatabaseTable(tableName = "sysinfo")
public class Sysinfo implements Serializable{

    private static final long serialVersionUID = 1L;

    /*单据（采购订单、供货通知单、外向交货单）*/
    @DatabaseField
    private String znum;
    /*交货单号码*/
    @DatabaseField
    private String vbeln;
    /*	工厂*/
    @DatabaseField
    private String werks;
    /*采购订单*/
    @DatabaseField
    private String ebeln;
    /*物料*/
    private String matnr;
    /*物料描述*/
    @DatabaseField
    private String maktx;
    /*版本*/
    @DatabaseField
    private String zlichn;
    /*交货数量(基本单位)*/
    @DatabaseField
    private String lgmng;
    /*单位*/
    @DatabaseField
    private String meins;
    /*托盘数量*/
    @DatabaseField
    private String erfmgl;
    /*标准托盘单位*/
    @DatabaseField
    private String erfme;
    /*未清数量*/
    @DatabaseField
    private String Zmenge;
    /*供应商*/
    @DatabaseField
    private String name1;
    /*供应商代码ID*/
    @DatabaseField
    private String name1Id;

    public Sysinfo() {
        super();
    }

    public Sysinfo(String znum, String vbeln, String werks, String ebeln, String matnr, String maktx, String zlichn, String lgmng, String meins, String erfmgl, String erfme, String zmenge, String name1, String name1Id) {
        this.znum = znum;
        this.vbeln = vbeln;
        this.werks = werks;
        this.ebeln = ebeln;
        this.matnr = matnr;
        this.maktx = maktx;
        this.zlichn = zlichn;
        this.lgmng = lgmng;
        this.meins = meins;
        this.erfmgl = erfmgl;
        this.erfme = erfme;
        this.Zmenge = zmenge;
        this.name1 = name1;
        this.name1Id = name1Id;
    }

    public String getZnum() {
        return znum;
    }

    public void setZnum(String znum) {
        this.znum = znum;
    }

    public String getVbeln() {
        return vbeln;
    }

    public void setVbeln(String vbeln) {
        this.vbeln = vbeln;
    }

    public String getWerks() {
        return werks;
    }

    public void setWerks(String werks) {
        this.werks = werks;
    }

    public String getEbeln() {
        return ebeln;
    }

    public void setEbeln(String ebeln) {
        this.ebeln = ebeln;
    }

    public String getMatnr() {
        return matnr;
    }

    public void setMatnr(String matnr) {
        this.matnr = matnr;
    }

    public String getMaktx() {
        return maktx;
    }

    public void setMaktx(String maktx) {
        this.maktx = maktx;
    }

    public String getZlichn() {
        return zlichn;
    }

    public void setZlichn(String zlichn) {
        this.zlichn = zlichn;
    }

    public String getLgmng() {
        return lgmng;
    }

    public void setLgmng(String lgmng) {
        this.lgmng = lgmng;
    }

    public String getMeins() {
        return meins;
    }

    public void setMeins(String meins) {
        this.meins = meins;
    }

    public String getErfmgl() {
        return erfmgl;
    }

    public void setErfmgl(String erfmgl) {
        this.erfmgl = erfmgl;
    }

    public String getErfme() {
        return erfme;
    }

    public void setErfme(String erfme) {
        this.erfme = erfme;
    }

    public String getZmenge() {
        return Zmenge;
    }

    public void setZmenge(String zmenge) {
        Zmenge = zmenge;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName1Id() {
        return name1Id;
    }

    public void setName1Id(String name1Id) {
        this.name1Id = name1Id;
    }

    @Override
    public String toString() {
        return "Sysinfo{" +
                "znum='" + znum + '\'' +
                ", vbeln='" + vbeln + '\'' +
                ", werks='" + werks + '\'' +
                ", ebeln='" + ebeln + '\'' +
                ", matnr='" + matnr + '\'' +
                ", maktx='" + maktx + '\'' +
                ", zlichn='" + zlichn + '\'' +
                ", lgmng='" + lgmng + '\'' +
                ", meins='" + meins + '\'' +
                ", erfmgl='" + erfmgl + '\'' +
                ", erfme='" + erfme + '\'' +
                ", Zmenge='" + Zmenge + '\'' +
                ", name1='" + name1 + '\'' +
                ", name1Id='" + name1Id + '\'' +
                '}';
    }
}
