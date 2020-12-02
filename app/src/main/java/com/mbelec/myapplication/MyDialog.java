package com.mbelec.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;


public class MyDialog extends Dialog {

    private Window window = null;

    public MyDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e("test", "onCreate");
        Window window = this.getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.dialogWindowAnim);
            window.setBackgroundDrawableResource(R.color.vifrification); //设置对话框背景为透明
            WindowManager.LayoutParams wl = window.getAttributes();
            wl.alpha = 0.6f; //设置透明度
            wl.gravity = Gravity.BOTTOM; //设置重力
            window.setAttributes(wl);
        }
    }

    public void showDialog(int layoutResID, int x, int y) {
        setContentView(layoutResID);
        //设置触摸对话框意外的地方取消对话框
        setCanceledOnTouchOutside(true);
        View view = getWindow().getDecorView();
        //Stiffness越小，弹性效果越好，弹的时间越长。DampingRatio的值越大，弹性效果越差。
        //StartVelocity开始速度，单位是px/second.正数是弹簧收缩的方向，负数则相反。
        Log.e("test", "showDialog");
        SpringAnimation signUpBtnAnimY = new SpringAnimation(view, SpringAnimation.TRANSLATION_Y, 0);
        //Android可以设置的三个参数：Stiffness、DampingRatio、StartVelocity
        signUpBtnAnimY.getSpring().setStiffness(SpringForce.STIFFNESS_VERY_LOW);
        signUpBtnAnimY.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY);
        signUpBtnAnimY.setStartVelocity(10000);
        signUpBtnAnimY.start();
        show();
    }

}
