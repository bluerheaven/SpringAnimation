package com.mbelec.myapplication;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                MyDialog myDialog = new MyDialog(MainActivity.this);
                myDialog.showDialog(R.layout.dialog, 0, 0);

//                showDialog();
            }
        });
    }


    /**
     * 弹性弹框
     * 张力（Tension）=196
     * 摩擦力（Friction）=25
     *
     * IOS:
     * velocity=0
     * dampingRatio = 0.89
     */
    private void showDialog() {
        Dialog dialog = new Dialog(MainActivity.this, R.style.test_dialog);

        //整个弹框布局
        View contentView = getLayoutInflater().inflate(R.layout.mytest_dialog, null);
        //弹性动画的布局
        View test_view = contentView.findViewById(R.id.test_view);

        dialog.setContentView(contentView);
        dialog.setCanceledOnTouchOutside(true);
        //Stiffness越小，弹性效果越好，弹的时间越长。DampingRatio的值越大，弹性效果越差。
        //StartVelocity开始速度，单位是px/second.正数是弹簧收缩的方向，负数则相反。
        SpringAnimation signUpBtnAnimX = new SpringAnimation(contentView, SpringAnimation.SCALE_X, 1f);
        //Android可以设置的三个参数：Stiffness、DampingRatio、StartVelocity
        signUpBtnAnimX.getSpring().setStiffness(SpringForce.STIFFNESS_VERY_LOW);
        signUpBtnAnimX.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY);
        signUpBtnAnimX.setStartVelocity(1);
        signUpBtnAnimX.start();

        SpringAnimation signUpBtnAnimY = new SpringAnimation(contentView, SpringAnimation.SCALE_Y, 1f);
        //Android可以设置的三个参数：Stiffness、DampingRatio、StartVelocity
        signUpBtnAnimY.getSpring().setStiffness(SpringForce.STIFFNESS_VERY_LOW);
        signUpBtnAnimY.getSpring().setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY);
        signUpBtnAnimY.setStartVelocity(1);
        signUpBtnAnimY.canSkipToEnd();
        signUpBtnAnimY.start();
        dialog.show();
    }

}