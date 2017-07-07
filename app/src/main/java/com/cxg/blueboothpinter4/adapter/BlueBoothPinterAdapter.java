package com.cxg.blueboothpinter4.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cxg.blueboothpinter4.R;
import com.cxg.blueboothpinter4.activity.BlueBoothPinterDetailActivity;
import com.cxg.blueboothpinter4.pojo.Zslips;

import java.util.ArrayList;
import java.util.List;

/**
 * description: 系统物料列表适配器
 * author: xg.chen
 * date: 2017/6/29 13:34
 * version: 1.0
*/

public class BlueBoothPinterAdapter extends BaseAdapter {

    public List<Zslips> zslipsList = new ArrayList<>();
    private LayoutInflater layoutInflater;
    private Activity activity;

    private LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT);

    public BlueBoothPinterAdapter(List<Zslips> parameterList, Activity activity) {
        params.leftMargin = 2;
        this.zslipsList = parameterList;
        this.layoutInflater = LayoutInflater.from(activity);
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return zslipsList.size();
    }

    @Override
    public Object getItem(int position) {
        return zslipsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*列表字段赋值*/
        ViewHolder hodler;
        if (convertView == null) {
            hodler = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.layout_sysinfo, null);
            hodler.matnr = (TextView) convertView.findViewById(R.id.matnr);//物料编码
            hodler.maktx = (TextView) convertView.findViewById(R.id.maktx);//物料描述
            hodler.werks = (TextView) convertView.findViewById(R.id.werks);//工厂
            hodler.znum = (TextView) convertView.findViewById(R.id.znum);//单据号
            hodler.zlichn = (TextView) convertView.findViewById(R.id.zlichn);//版本
            hodler.lgmng = (TextView) convertView.findViewById(R.id.lgmng);//交货数量
            hodler.Zmenge = (TextView) convertView.findViewById(R.id.Zmenge);//未清数量
            hodler.Meins = (TextView) convertView.findViewById(R.id.Meins);//单位
            hodler.erfmgl = (TextView) convertView.findViewById(R.id.erfmgl);//托盘数量
            hodler.erfme = (TextView) convertView.findViewById(R.id.erfme);//托盘单位
            convertView.setTag(hodler);
        } else {
            hodler = (ViewHolder) convertView.getTag();
            resetViewHolder(hodler);
        }
        Zslips zslips = zslipsList.get(position);
        hodler.matnr.setText(zslips.getMatnr());
        hodler.maktx.setText(zslips.getMaktx());
        hodler.werks.setText(zslips.getWerks());
        hodler.znum.setText(zslips.getZnum());
        hodler.zlichn.setText(zslips.getZlichn());
        hodler.lgmng.setText(zslips.getLgmng());
        hodler.Zmenge.setText(zslips.getZmenge());
        hodler.Meins.setText(zslips.getMeins());
        hodler.erfmgl.setText(zslips.getErfmg());
        hodler.erfme.setText(zslips.getErfme());

        /*设置列表的点击事件*/
        final int n = position;
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, BlueBoothPinterDetailActivity.class);
                intent.putExtra("zslips",zslipsList.get(n));
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left);
            }
        });

        return convertView;
    }

    /**
     * reset view holder
     *
     * @param pViewHodler
     */
    private void resetViewHolder(ViewHolder pViewHodler) {
        pViewHodler.znum.setText(null);
        pViewHodler.werks.setText(null);
        pViewHodler.matnr.setText(null);
        pViewHodler.maktx.setText(null);
        pViewHodler.zlichn.setText(null);
        pViewHodler.lgmng.setText(null);
        pViewHodler.Meins.setText(null);
        pViewHodler.Zmenge.setText(null);
        pViewHodler.erfmgl.setText(null);
        pViewHodler.erfme.setText(null);
    }

    /**
     * view holder
     */
    private static class ViewHolder {
        TextView matnr = null;
        TextView maktx = null;
        TextView lgmng = null;
        TextView zlichn = null;
        TextView werks = null;
        TextView znum = null;
        TextView Zmenge = null;
        TextView Meins = null;
        TextView erfme = null;
        TextView erfmgl = null;

    }
}
