package com.cxg.blueboothpinter4.pojo;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

import java.io.Serializable;
import java.util.Hashtable;

/**
 * description: 供应商返回值实体类
 * author: xg.chen
 * date: 2017/6/30 14:06
 * version: 1.0
*/
@DatabaseTable(tableName = "Zlfa1")
public class Zslfa1 implements Serializable,KvmSerializable {

    @DatabaseField
    private String Lifnr;

    @DatabaseField
    private  String Name1;

    public Zslfa1() {
        super();
    }

    public Zslfa1(String lifnr, String name1) {
        Lifnr = lifnr;
        Name1 = name1;
    }

    public String getLifnr() {
        return Lifnr;
    }

    public void setLifnr(String lifnr) {
        Lifnr = lifnr;
    }

    public String getName1() {
        return Name1;
    }

    public void setName1(String name1) {
        Name1 = name1;
    }

    @Override
    public String toString() {
        return "Zlfa1{" +
                "Lifnr='" + Lifnr + '\'' +
                ", Name1='" + Name1 + '\'' +
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
