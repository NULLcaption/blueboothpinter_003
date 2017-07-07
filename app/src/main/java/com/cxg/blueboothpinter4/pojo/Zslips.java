package com.cxg.blueboothpinter4.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.io.Serializable;
import java.util.Hashtable;

/**
 * description: 详细信息实体
 * author: xg.chen
 * date: 2017/6/30 14:09
 * version: 1.0
 */
@DatabaseTable(tableName = "Zslips")
public class Zslips implements Serializable, KvmSerializable {

    @DatabaseField
    private String Znum;
    @DatabaseField
    private String Vbeln;
    @DatabaseField
    private String Werks;
    @DatabaseField
    private String Ebeln;
    @DatabaseField
    private String Matnr;
    @DatabaseField
    private String Maktx;
    @DatabaseField
    private String Zlichn;
    @DatabaseField
    private String Lgmng;
    @DatabaseField
    private String Meins;
    @DatabaseField
    private String Erfmg;
    @DatabaseField
    private String Erfme;
    @DatabaseField
    private String Zmenge;
    @DatabaseField
    private String Zgrdate;
    @DatabaseField
    private String Zproddate;
    @DatabaseField
    private String mark;
    @DatabaseField
    private String Lifnr;
    @DatabaseField
    private String EName1;
    @DatabaseField
    private String Menge;
    @DatabaseField
    private String Zipcode;
    @DatabaseField
    private String Qcnum;
    @DatabaseField
    private String Charg;


    public Zslips() {
        super();
    }

    public String getCharg() {
        return Charg;
    }

    public void setCharg(String charg) {
        Charg = charg;
    }

    public String getQcnum() {
        return Qcnum;
    }

    public void setQcnum(String qcnum) {
        Qcnum = qcnum;
    }

    public String getMenge() {
        return Menge;
    }

    public void setMenge(String menge) {
        Menge = menge;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String zipcode) {
        Zipcode = zipcode;
    }

    public String getLifnr() {
        return Lifnr;
    }

    public void setLifnr(String lifnr) {
        Lifnr = lifnr;
    }

    public String getEName1() {
        return EName1;
    }

    public void setEName1(String EName1) {
        this.EName1 = EName1;
    }

    public String getZgrdate() {
        return Zgrdate;
    }

    public void setZgrdate(String zgrdate) {
        Zgrdate = zgrdate;
    }

    public String getZproddate() {
        return Zproddate;
    }

    public void setZproddate(String zproddate) {
        Zproddate = zproddate;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getZnum() {
        return Znum;
    }

    public void setZnum(String znum) {
        Znum = znum;
    }

    public String getVbeln() {
        return Vbeln;
    }

    public void setVbeln(String vbeln) {
        Vbeln = vbeln;
    }

    public String getWerks() {
        return Werks;
    }

    public void setWerks(String werks) {
        Werks = werks;
    }

    public String getEbeln() {
        return Ebeln;
    }

    public void setEbeln(String ebeln) {
        Ebeln = ebeln;
    }

    public String getMatnr() {
        return Matnr;
    }

    public void setMatnr(String matnr) {
        Matnr = matnr;
    }

    public String getMaktx() {
        return Maktx;
    }

    public void setMaktx(String maktx) {
        Maktx = maktx;
    }

    public String getZlichn() {
        return Zlichn;
    }

    public void setZlichn(String zlichn) {
        Zlichn = zlichn;
    }

    public String getLgmng() {
        return Lgmng;
    }

    public void setLgmng(String lgmng) {
        Lgmng = lgmng;
    }

    public String getMeins() {
        return Meins;
    }

    public void setMeins(String meins) {
        Meins = meins;
    }

    public String getErfmg() {
        return Erfmg;
    }

    public void setErfmg(String erfmg) {
        Erfmg = erfmg;
    }

    public String getErfme() {
        return Erfme;
    }

    public void setErfme(String erfme) {
        Erfme = erfme;
    }

    public String getZmenge() {
        return Zmenge;
    }

    public void setZmenge(String zmenge) {
        Zmenge = zmenge;
    }

    @Override
    public String toString() {
        return "Zslips{" +
                "Znum='" + Znum + '\'' +
                ", Vbeln='" + Vbeln + '\'' +
                ", Werks='" + Werks + '\'' +
                ", Ebeln='" + Ebeln + '\'' +
                ", Matnr='" + Matnr + '\'' +
                ", Maktx='" + Maktx + '\'' +
                ", Zlichn='" + Zlichn + '\'' +
                ", Lgmng='" + Lgmng + '\'' +
                ", Meins='" + Meins + '\'' +
                ", Erfmg='" + Erfmg + '\'' +
                ", Erfme='" + Erfme + '\'' +
                ", Zmenge='" + Zmenge + '\'' +
                ", Zgrdate='" + Zgrdate + '\'' +
                ", Zproddate='" + Zproddate + '\'' +
                ", mark='" + mark + '\'' +
                ", Lifnr='" + Lifnr + '\'' +
                ", EName1='" + EName1 + '\'' +
                ", Menge='" + Menge + '\'' +
                ", Zipcode='" + Zipcode + '\'' +
                '}';
    }

    @Override
    public Object getProperty(int i) {
        return null;
    }

    @Override
    public int getPropertyCount() {
        return 0;
    }

    @Override
    public void setProperty(int i, Object o) {

    }

    @Override
    public void getPropertyInfo(int i, Hashtable hashtable, PropertyInfo propertyInfo) {

    }
}
