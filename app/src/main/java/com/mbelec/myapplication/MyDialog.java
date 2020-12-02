package com.mbelec.myapplication;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;


public class MyDialog extends Dialog {

    private Window window = null;

    public MyDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
        show();
    }

}
