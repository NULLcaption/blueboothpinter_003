package com.cxg.blueboothpinter4.query;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.cxg.blueboothpinter4.pojo.Sysinfo;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by Administrator on 2017/5/5.
 */

public class OrmHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "xpp.db";
    private static final int DATABASE_VERSION = 31;// 30     手机db版本,2016-10-21

    private static OrmHelper instance;

    private Dao<Sysinfo, Integer> sysinfoDao = null;

    private OrmHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public static OrmHelper getInstance() {
        return instance;
    }

    public static void createInstance(Context context) {
        if (instance == null)
            instance = new OrmHelper(context);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {

            TableUtils.createTable(connectionSource, Sysinfo.class);

        } catch (SQLException e) {
            Log.e(OrmHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }

    }

    public Dao<Sysinfo, Integer> getSysinfoDao() throws SQLException {
        if (sysinfoDao == null) {
            sysinfoDao = getDao(Sysinfo.class);
        }
        return sysinfoDao;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        Log.i(OrmHelper.class.getName(), "onUpgrade");
        try {

            TableUtils.dropTable(connectionSource, Sysinfo.class, true);

            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
