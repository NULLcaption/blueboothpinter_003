package com.cxg.blueboothpinter4.utils;

import java.io.UnsupportedEncodingException;

/**
 * description: 打印页面设置工具类
 * author: xg.chen
 * date: 2017/7/7 10:49
 * version: 1.0
*/

public class lable_sdk {

    public static int getlength(String str) {
        int i, t = 0;
        byte[] bt = str.getBytes();
        for (i = 1; i <= bt.length; i++) {
            if (bt[i - 1] < 0) {
                t = t + 2;
                i++;
            } else t = t + 1;
        }
        return t;
    }

    public static void SetPageSize(int width, int height) {
        byte[] CommandData = new byte[10];
        CommandData[0] = 0x1c;
        CommandData[1] = 0x4c;
        CommandData[2] = 0x70;
        CommandData[3] = (byte) (width % 256);
        CommandData[4] = (byte) (width / 256);
        CommandData[5] = (byte) (height % 256);
        CommandData[6] = (byte) (height / 256);
        CommandData[7] = 0x00;
        Bluetooth.SPPWrite(CommandData, 8);
    }//setpagesize

    public static void ClearPage() {
        byte[] CommandData = new byte[8];
        CommandData[0] = 0x1c;
        CommandData[1] = 0x4c;
        CommandData[2] = 0x63;
        Bluetooth.SPPWrite(CommandData, 3);
    }//clearpage

    public static void ErrorConfig(boolean ContinueFlag) {
        byte[] CommandData = new byte[8];
        CommandData[0] = 0x1c;
        CommandData[1] = 0x4c;
        CommandData[2] = 0x72;
        if (ContinueFlag)
            CommandData[3] = 0x01;
        else
            CommandData[3] = 0x00;
        Bluetooth.SPPWrite(CommandData, 4);
    }//ErrorConfig

    /**
     * 打印页面
     *
     * @param mark
     * @param maxlengthmm 最大走纸轴距
     * @param rotate 是否旋转  FALSE否；true是；
     */
    public static void PrintPage(int mark, int maxlengthmm, boolean rotate) {
        byte[] CommandData = new byte[8];
        CommandData[0] = 0x1c;
        CommandData[1] = 0x4c;
        CommandData[2] = 0x6f;
        if (rotate)
            CommandData[3] = 0x01;
        else
            CommandData[3] = 0x00;
        CommandData[4] = (byte) (mark % 256);
        CommandData[5] = (byte) (maxlengthmm % 256);
        CommandData[6] = (byte) (maxlengthmm / 256);
        Bluetooth.SPPWrite(CommandData, 7);
    }//PrintPage


    public static void DrawLine(int x0, int y0, int x1, int y1, int linewidth) {
        byte[] CommandData = new byte[16];
        CommandData[0] = 0x1C;
        CommandData[1] = 0x4C;
        CommandData[2] = 0x6C;
        CommandData[3] = (byte) (linewidth % 256);
        CommandData[4] = 1;
        CommandData[5] = (byte) (x0 % 256);
        CommandData[6] = (byte) (x0 / 256); //x
        CommandData[7] = (byte) (y0 % 256);
        CommandData[8] = (byte) (y0 / 256); //y
        CommandData[9] = (byte) (x1 % 256);
        CommandData[10] = (byte) (x1 / 256); //xx
        CommandData[11] = (byte) (y1 % 256);
        CommandData[12] = (byte) (y1 / 256); //yy
        Bluetooth.SPPWrite(CommandData, 13);
    }//drawline

    public static void DrawText(int x, int y, String str1, int font, int fontsize) {
        byte[] CommandData = new byte[512];
        CommandData[0] = 0x1C;
        CommandData[1] = 0x4C;
        CommandData[2] = 0x74;
        CommandData[3] = (byte) (x % 256);
        CommandData[4] = (byte) (x / 256); //x
        CommandData[5] = (byte) (y % 256);
        CommandData[6] = (byte) (y / 256); //y
        CommandData[7] = (byte) (font % 256);
        CommandData[8] = (byte) (fontsize % 256);
        Bluetooth.SPPWrite(CommandData, 9);
        try {
            CommandData = str1.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Bluetooth.SPPWrite(CommandData);
        CommandData[0] = 0x00;
        Bluetooth.SPPWrite(CommandData, 1);
    }//drawtext

    public static void DrawTextBox(int x, int y, int width, int height, String str1, int font, int fontsize) {
        byte[] CommandData = new byte[512];
        CommandData[0] = 0x1C;
        CommandData[1] = 0x4C;
        CommandData[2] = 0x54;
        CommandData[3] = (byte) (x % 256);
        CommandData[4] = (byte) (x / 256); //x
        CommandData[5] = (byte) (y % 256);
        CommandData[6] = (byte) (y / 256); //y
        CommandData[7] = (byte) (width % 256);
        CommandData[8] = (byte) (width / 256); //x
        CommandData[9] = (byte) (height % 256);
        CommandData[10] = (byte) (height / 256); //y
        CommandData[11] = (byte) (font % 256);
        CommandData[12] = (byte) (fontsize % 256);
        Bluetooth.SPPWrite(CommandData, 13);
        try {
            CommandData = str1.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
        }
        Bluetooth.SPPWrite(CommandData);
        CommandData[0] = 0x00;
        Bluetooth.SPPWrite(CommandData, 1);
    }//drawtextbox

    /**
     * 打印条形码
     * @param x
     * @param y
     * @param str
     * @param codetype
     * @param rotatewidth
     * @param height
     */
    public static void DrawCode1D(int x, int y, String str, int codetype, int rotatewidth, int height) {
        byte[] CommandData = new byte[256];
        CommandData[0] = 0x1C;
        CommandData[1] = 0x4C;
        CommandData[2] = 0x62;
        CommandData[3] = (byte) (x % 256);
        CommandData[4] = (byte) (x / 256); //x
        CommandData[5] = (byte) (y % 256);
        CommandData[6] = (byte) (y / 256); //y
        CommandData[7] = (byte) (codetype % 256);
        CommandData[8] = (byte) (rotatewidth % 256);
        CommandData[9] = (byte) (height % 256);
        Bluetooth.SPPWrite(CommandData, 10);
        try {
            CommandData = str.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
        }
        Bluetooth.SPPWrite(CommandData);
        CommandData[0] = 0x00;
        Bluetooth.SPPWrite(CommandData, 1);
    }//draw 1D code

    public static void DrawCode2D(int x, int y, String str, int codenum, int codetype, int rotatewidth, int d) {
        byte[] CommandData = new byte[256];
        CommandData[0] = 0x1C;
        CommandData[1] = 0x4C;
        CommandData[2] = 0x42;
        CommandData[3] = (byte) (x % 256);
        CommandData[4] = (byte) (x / 256); //x
        CommandData[5] = (byte) (y % 256);
        CommandData[6] = (byte) (y / 256); //y
        CommandData[7] = (byte) (codetype % 256);
        CommandData[8] = (byte) (rotatewidth % 256);
        CommandData[9] = (byte) (d % 256);
        CommandData[10] = (byte) (codenum % 256);
        CommandData[11] = (byte) (codenum / 256); //length
        Bluetooth.SPPWrite(CommandData, 12);
        try {
            CommandData = str.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
        }
        Bluetooth.SPPWrite(CommandData);
    }//draw 2D code

    public static void SelectPage(int index) {
        byte[] CommandData = new byte[8];
        CommandData[0] = 0x1C;
        CommandData[1] = 0x4C;
        CommandData[2] = 0x50;
        CommandData[3] = (byte) (index % 256);
        Bluetooth.SPPWrite(CommandData, 4);
    }//select page

    public static void DrawTextSpike(int x, int y, String str, int font, int rotatefontsize, int post) {
        byte[] CommandData = new byte[256];
        CommandData[0] = 0x1C;
        CommandData[1] = 0x4C;
        CommandData[2] = 0x61;
        CommandData[3] = (byte) (x % 256);
        CommandData[4] = (byte) (x / 256); //x
        CommandData[5] = (byte) (y % 256);
        CommandData[6] = (byte) (y / 256); //y
        CommandData[7] = (byte) (font % 256);
        CommandData[8] = (byte) (rotatefontsize % 256);
        CommandData[9] = (byte) (post % 256);
        Bluetooth.SPPWrite(CommandData, 10);
        try {
            CommandData = str.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
        }
        Bluetooth.SPPWrite(CommandData);
        CommandData[0] = 0x00;
        Bluetooth.SPPWrite(CommandData, 1);
    }//drawtextspike

    public static void SetSpike(int dataL, int dataH, int spike) {
        byte[] CommandData = new byte[16];
        CommandData[0] = 0x1C;
        CommandData[1] = 0x4C;
        CommandData[2] = 0x49;
        CommandData[3] = (byte) (dataL % 256);
        CommandData[4] = (byte) (dataL / 256); //x
        CommandData[5] = (byte) (dataH % 256);
        CommandData[6] = (byte) (dataH / 256); //y
        CommandData[7] = (byte) (spike % 256);
        CommandData[8] = (byte) (spike / 256); //y7
        Bluetooth.SPPWrite(CommandData, 9);
    }//SetSpike


    public static void PrintPageSpike(int mark, int maxlength, int num, int b) {
        byte[] CommandData = new byte[16];
        CommandData[0] = 0x1C;
        CommandData[1] = 0x4C;
        CommandData[2] = 0x4F;
        CommandData[3] = (byte) (b % 256);
        CommandData[4] = (byte) (mark % 256);
        CommandData[5] = (byte) (maxlength % 256);
        CommandData[6] = (byte) (maxlength / 256);
        CommandData[7] = (byte) (num % 256);
        CommandData[8] = (byte) (num / 256);
        Bluetooth.SPPWrite(CommandData, 9);
    }//SetSpike

}