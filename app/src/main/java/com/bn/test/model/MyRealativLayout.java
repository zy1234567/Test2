//package com.bn.test.model;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.util.DisplayMetrics;
//import android.view.ViewGroup;
//import android.view.WindowManager;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//
//import com.bn.test.util.SCreeUtil;
//
///**
// * Created by JD on 2018/7/2.
// */
//
//public class MyRealativLayout extends RelativeLayout {
//    private static boolean flag=true;
//    public MyRealativLayout(Context context) {
//        super(context);
//    }
//
//    public MyRealativLayout(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public MyRealativLayout(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        if(flag){
//            flag=false;
//            LinearLayout.LayoutParams layoutParams=(LinearLayout.LayoutParams)this.getLayoutParams();
//        if(layoutParams.width!= LinearLayout.LayoutParams.MATCH_PARENT&&layoutParams.width!= LinearLayout.LayoutParams.FILL_PARENT){
//           layoutParams.width=SCreeUtil.getInstantce(this.getContext()).getWidth(w)
//        }
//            SCreeUtil sCreeUtil= SCreeUtil.getInstantce(this.getContext());
//            float sX=sCreeUtil.getSX(getContext());
//            float sY=sCreeUtil.getSY(getContext());
//            try {
//                Class c=Class.forName("");
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//
//            getChildCount();
//            ViewGroup.LayoutParams layoutParams=getLayoutParams();
//
//        }
//
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    }
//
//
//
//    @Override
//    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        super.onLayout(changed, l, t, r, b);
//    }
//
//    @Override
//    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
//        return super.generateLayoutParams(lp);
//    }
//}
