package com.cxg.blueboothpinter4.pojo;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;
import java.util.List;

/**
 * description: 采购物料组实体类
 * author: xg.chen
 * date: 2017/6/29 9:33
 * version: 1.0
*/
@DatabaseTable(tableName = "Ztwm004")
public class Ztwm004 implements Serializable {

    @DatabaseField
    private String Mandt;
    @DatabaseField
    private String Zipcode;
    @DatabaseField
    private String Charg;//ERP编码
    @DatabaseField
    private String Zcupno;//杯上批次编码
    @DatabaseField
    private String Werks;//工厂
    @DatabaseField
    private String Zkurno;//客流码
    @DatabaseField
    private String Zbc;//班别
    @DatabaseField
    private String Zlinecode;//线别
    @DatabaseField
    private String Matnr;//物料Id
    @DatabaseField
    private String Zproddate;//入库时间
    @DatabaseField
    private String Zinstock;
    @DatabaseField
    private String Zoutstock;
    @DatabaseField
    private String Mblnr;
    @DatabaseField
    private String Mjahr;
    @DatabaseField
    private String Menge;//数量
    @DatabaseField
    private String Meins;//单位
    @DatabaseField
    private String Tanum;
    @DatabaseField
    private String Zptflg;
    @DatabaseField
    private String Zgrdate;//生产时间
    @DatabaseField
    private String Zlichn;//版本
    @DatabaseField
    private String Lifnr;//供应商
    @DatabaseField
    private String Znum;//单据
    @DatabaseField
    private String Zqcnum;//车牌号
    @DatabaseField
    private String EMaktx;//物料名称
    @DatabaseField
    private String EName1;//客流码名称
    @DatabaseField
    private String EName2;//供应商名称
    /*交货数量(基本单位)*/
    @DatabaseField
    private String lgmng;
    /*托盘数量*/
    @DatabaseField
    private String erfmgl;
    /*标准托盘单位*/
    @DatabaseField
    private String erfme;
    /*未清数量*/
    @DatabaseField
    private String Zmenge;
    /*单据（采购订单、供货通知单、外向交货单）*/
    @DatabaseField
    private String znum;
    /*交货单号码*/
    @DatabaseField
    private String vbeln;
    /*采购订单*/
    @DatabaseField
    private String ebeln;
    //明细列表
    private List<Zslips> zslipsList;

    public Ztwm004() {
        super();
    }

    public Ztwm004(String mandt, String zipcode, String charg, String zcupno, String werks, String zkurno, String zbc, String zlinecode, String matnr, String zproddate, String zinstock, String zoutstock, String mblnr, String mjahr, String menge, String meins, String tanum, String zptflg, String zgrdate, String zlichn, String lifnr, String znum, String zqcnum, String EMaktx, String EName1, String EName2, String lgmng, String erfmgl, String erfme, String zmenge, String znum1, String vbeln, String ebeln, List<Zslips> zslipsList) {
        Mandt = mandt;
        Zipcode = zipcode;
        Charg = charg;
        Zcupno = zcupno;
        Werks = werks;
        Zkurno = zkurno;
        Zbc = zbc;
        Zlinecode = zlinecode;
        Matnr = matnr;
        Zproddate = zproddate;
        Zinstock = zinstock;
        Zoutstock = zoutstock;
        Mblnr = mblnr;
        Mjahr = mjahr;
        Menge = menge;
        Meins = meins;
        Tanum = tanum;
        Zptflg = zptflg;
        Zgrdate = zgrdate;
        Zlichn = zlichn;
        Lifnr = lifnr;
        Znum = znum;
        Zqcnum = zqcnum;
        this.EMaktx = EMaktx;
        this.EName1 = EName1;
        this.EName2 = EName2;
        this.lgmng = lgmng;
        this.erfmgl = erfmgl;
        this.erfme = erfme;
        Zmenge = zmenge;
        this.znum = znum1;
        this.vbeln = vbeln;
        this.ebeln = ebeln;
        this.zslipsList = zslipsList;
    }

    public List<Zslips> getZslipsList() {
        return zslipsList;
    }

    public void setZslipsList(List<Zslips> zslipsList) {
        this.zslipsList = zslipsList;
    }

    public String getMandt() {
        return Mandt;
    }

    public void setMandt(String mandt) {
        Mandt = mandt;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String zipcode) {
        Zipcode = zipcode;
    }

    public String getCharg() {
        return Charg;
    }

    public void setCharg(String charg) {
        Charg = charg;
    }

    public String getZcupno() {
        return Zcupno;
    }

    public void setZcupno(String zcupno) {
        Zcupno = zcupno;
    }

    public String getWerks() {
        return Werks;
    }

    public void setWerks(String werks) {
        Werks = werks;
    }

    public String getZkurno() {
        return Zkurno;
    }

    public void setZkurno(String zkurno) {
        Zkurno = zkurno;
    }

    public String getZbc() {
        return Zbc;
    }

    public void setZbc(String zbc) {
        Zbc = zbc;
    }

    public String getZlinecode() {
        return Zlinecode;
    }

    public void setZlinecode(String zlinecode) {
        Zlinecode = zlinecode;
    }

    public String getMatnr() {
        return Matnr;
    }

    public void setMatnr(String matnr) {
        Matnr = matnr;
    }

    public String getZproddate() {
        return Zproddate;
    }

    public void setZproddate(String zproddate) {
        Zproddate = zproddate;
    }

    public String getZinstock() {
        return Zinstock;
    }

    public void setZinstock(String zinstock) {
        Zinstock = zinstock;
    }

    public String getZoutstock() {
        return Zoutstock;
    }

    public void setZoutstock(String zoutstock) {
        Zoutstock = zoutstock;
    }

    public String getMblnr() {
        return Mblnr;
    }

    public void setMblnr(String mblnr) {
        Mblnr = mblnr;
    }

    public String getMjahr() {
        return Mjahr;
    }

    public void setMjahr(String mjahr) {
        Mjahr = mjahr;
    }

    public String getMenge() {
        return Menge;
    }

    public void setMenge(String menge) {
        Menge = menge;
    }

    public String getMeins() {
        return Meins;
    }

    public void setMeins(String meins) {
        Meins = meins;
    }

    public String getTanum() {
        return Tanum;
    }

    public void setTanum(String tanum) {
        Tanum = tanum;
    }

    public String getZptflg() {
        return Zptflg;
    }

    public void setZptflg(String zptflg) {
        Zptflg = zptflg;
    }

    public String getZgrdate() {
        return Zgrdate;
    }

    public void setZgrdate(String zgrdate) {
        Zgrdate = zgrdate;
    }

    public String getZlichn() {
        return Zlichn;
    }

    public void setZlichn(String zlichn) {
        Zlichn = zlichn;
    }

    public String getLifnr() {
        return Lifnr;
    }

    public void setLifnr(String lifnr) {
        Lifnr = lifnr;
    }

    public String getZnum() {
        return Znum;
    }

    public void setZnum(String znum) {
        Znum = znum;
    }

    public String getVbeln() {
        return vbeln;
    }

    public void setVbeln(String vbeln) {
        this.vbeln = vbeln;
    }

    public String getEbeln() {
        return ebeln;
    }

    public void setEbeln(String ebeln) {
        this.ebeln = ebeln;
    }

    public String getZqcnum() {
        return Zqcnum;
    }

    public void setZqcnum(String zqcnum) {
        Zqcnum = zqcnum;
    }

    public String getEMaktx() {
        return EMaktx;
    }

    public void setEMaktx(String EMaktx) {
        this.EMaktx = EMaktx;
    }

    public String getEName1() {
        return EName1;
    }

    public void setEName1(String EName1) {
        this.EName1 = EName1;
    }

    public String getEName2() {
        return EName2;
    }

    public void setEName2(String EName2) {
        this.EName2 = EName2;
    }

    public String getLgmng() {
        return lgmng;
    }

    public void setLgmng(String lgmng) {
        this.lgmng = lgmng;
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

    @Override
    public String toString() {
        return "Ztwm004{" +
                "Mandt='" + Mandt + '\'' +
                ", Zipcode='" + Zipcode + '\'' +
                ", Charg='" + Charg + '\'' +
                ", Zcupno='" + Zcupno + '\'' +
                ", Werks='" + Werks + '\'' +
                ", Zkurno='" + Zkurno + '\'' +
                ", Zbc='" + Zbc + '\'' +
                ", Zlinecode='" + Zlinecode + '\'' +
                ", Matnr='" + Matnr + '\'' +
                ", Zproddate='" + Zproddate + '\'' +
                ", Zinstock='" + Zinstock + '\'' +
                ", Zoutstock='" + Zoutstock + '\'' +
                ", Mblnr='" + Mblnr + '\'' +
                ", Mjahr='" + Mjahr + '\'' +
                ", Menge='" + Menge + '\'' +
                ", Meins='" + Meins + '\'' +
                ", Tanum='" + Tanum + '\'' +
                ", Zptflg='" + Zptflg + '\'' +
                ", Zgrdate='" + Zgrdate + '\'' +
                ", Zlichn='" + Zlichn + '\'' +
                ", Lifnr='" + Lifnr + '\'' +
                ", Znum='" + Znum + '\'' +
                ", Zqcnum='" + Zqcnum + '\'' +
                ", EMaktx='" + EMaktx + '\'' +
                ", EName1='" + EName1 + '\'' +
                ", EName2='" + EName2 + '\'' +
                ", lgmng='" + lgmng + '\'' +
                ", erfmgl='" + erfmgl + '\'' +
                ", erfme='" + erfme + '\'' +
                ", Zmenge='" + Zmenge + '\'' +
                ", znum='" + znum + '\'' +
                ", vbeln='" + vbeln + '\'' +
                ", ebeln='" + ebeln + '\'' +
                ", zslipsList=" + zslipsList +
                '}';
    }
}
