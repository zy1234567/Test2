package com.bn.test.util;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.lang.reflect.Field;

/**
 * Created by JD on 2018/7/2.
 */

public class SCreeUtil {
    Context context;
    public  float displayMetriesWidth;
    public float displayMetriesHieght;
    private static SCreeUtil instantce;

    public SCreeUtil(Context context) {
        this.context = context;
        //获取屏幕真实宽高
        WindowManager windowManager=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics=new DisplayMetrics();
        if(this.displayMetriesWidth==0.0f||this.displayMetriesHieght==0.0f){
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            //获取状态栏高度
            int systemBarHight=getSystemHight(context);
            //处理真实宽高
            if(displayMetrics.widthPixels>displayMetrics.heightPixels){
                //横屏情况
                this.displayMetriesWidth=(float) displayMetrics.heightPixels;
                this.displayMetriesHieght=(float)displayMetrics.widthPixels-systemBarHight;
            }else {
                //竖屏
                this.displayMetriesWidth=(float) displayMetrics.widthPixels;
                this.displayMetriesHieght=(float)displayMetrics.heightPixels-systemBarHight;
            }
        }
    }

    public int getSystemHight(Context context){
        return getValue(context,"com.android.internal.R$dimen","system_bar_height",48);
    }

    /**
     *
     * @param context
     * @param
     * @param
     * @param i
     * @return
     */
    private int getValue(Context context,String attrGroupClass,String attryname,int i){
        try {
            Class e  =Class.forName(attrGroupClass);
            Object object=e.newInstance();
            Field field=e.getField(attryname);
            int x=Integer.parseInt(field.get(object).toString());
            return context.getResources().getDimensionPixelOffset(x);
        } catch (Exception e) {
            e.printStackTrace();
            return 48;
        }
    }
    public static SCreeUtil getInstantce(Context context) {
        if (instantce == null) {
            instantce = new SCreeUtil(context);
        }
        return instantce;
    }
    //获取缩放以后的结果
    public int getHight(float hight){
        return (int)(hight *this.displayMetriesHieght/this.displayMetriesHieght);
    }
    public int getWidth(float width){
        return (int) (width*this.displayMetriesWidth/this.displayMetriesHieght);
    }

    public  float getSX(Context context) {
        int array[]=getScreenSize(context);
        return ((float) (array[0]) / array[1]);
    }
    public   float getSY(Context context){
        int array[]=getScreenSize(context);
        return ((float) (array[1]) / array[0]);
    }

    public static int[] getScreenSize(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return new int[]{outMetrics.widthPixels, outMetrics.heightPixels};
    }
}
