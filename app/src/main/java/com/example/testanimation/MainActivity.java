package com.example.testanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView, imageView2, imageView3;
    private Button move;
    ObjectAnimator animationX, animationY, rotateAnimation;

    //записать размер дисплея устройства
    int screenWidth = 0; //ширина
    int screenHeight = 0; //высота

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public void init() {
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        move = (Button) findViewById(R.id.btnMove);

        //взять размер дисплея устройства
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;

        //или так
//        Display display = getWindowManager().getDefaultDisplay();
//        screenWidth = display.getWidth();
//        screenHeight = display.getHeight();


    }
    public class Dice {
        public void animationFirstObject() {
            //конечные точки
            Double generateX = (Double) (0 + Math.random() * screenWidth);
            Double generateY = (Double) ((screenHeight /2) + Math.random() * (screenHeight-(screenHeight/1.5)));
            float xEnd = generateX.floatValue();
            float yEnd = generateY.floatValue();

            AnimatorSet image1 = new AnimatorSet();
            animationX = ObjectAnimator.ofFloat(imageView, "x", -300f, xEnd);
            animationY = ObjectAnimator.ofFloat(imageView, "y", -300f, yEnd);
            rotateAnimation = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 720f);
            animationX.setDuration(1000);
            animationY.setDuration(1000);
            rotateAnimation.setDuration(1000);
            image1.playTogether(animationX, animationY, rotateAnimation);
            image1.start();

//            RotateAnimation rotate = new RotateAnimation(5,8000,RotateAnimation.RELATIVE_TO_SELF,
//                    0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
//            rotate.setDuration(8600);
//            rotate.setFillAfter(true);
//            rotate.setInterpolator(new CycleInterpolator(5));
//            rotate.setAnimationListener(new Animation.AnimationListener() {
//                @Override
//                public void onAnimationStart(Animation animation) {
//                    Toast.makeText(getApplicationContext(),"On animation start",Toast.LENGTH_SHORT).show();
//
//                }
//
//                @Override
//                public void onAnimationEnd(Animation animation) {
//                    Toast.makeText(getApplicationContext(),"On animation end",Toast.LENGTH_SHORT).show();
//
//                }
//
//                @Override
//                public void onAnimationRepeat(Animation animation) {
//                    Toast.makeText(getApplicationContext(),"On animation repeat",Toast.LENGTH_SHORT).show();
//                }
//            });
//            imageView.startAnimation(rotate);
        }
//        public void animationTwoObject() {
//            Double generateX = (Double) (0 + Math.random() * 1000);
//            Double generateY = (Double) (500 + Math.random() * 1000);
//            float xEnd = generateX.floatValue();
//            float yEnd = generateY.floatValue();
//
//            AnimatorSet image2 = new AnimatorSet();
//            animationX = ObjectAnimator.ofFloat(imageView2, "x", -300f, xEnd);
//            animationY = ObjectAnimator.ofFloat(imageView2, "y", -300f, yEnd);
//            rotateAnimation = ObjectAnimator.ofFloat(imageView2, "rotation", 0f, 720f);
//            animationX.setDuration(1000);
//            animationY.setDuration(1000);
//            rotateAnimation.setDuration(1500);
//            image2.playTogether(animationX, animationY, rotateAnimation);
//            image2.start();
//        }
//        public void animationThreeObject() {
//            Double generateX = (Double) (0 + Math.random() * 1000);
//            Double generateY = (Double) (500 + Math.random() * 1000);
//            float xEnd = generateX.floatValue();
//            float yEnd = generateY.floatValue();
//
//            AnimatorSet image3 = new AnimatorSet();
//            animationX = ObjectAnimator.ofFloat(imageView3, "x", -300f, xEnd);
//            animationY = ObjectAnimator.ofFloat(imageView3, "y", -300f, yEnd);
//            rotateAnimation = ObjectAnimator.ofFloat(imageView3, "rotation", 0f, 720f);
//            animationX.setDuration(1000);
//            animationY.setDuration(1000);
//            rotateAnimation.setDuration(1500);
//            image3.playTogether(animationX, animationY, rotateAnimation);
//            image3.start();
//        }
    }




    public void onClickMove(View view) {
        Dice dice = new Dice();
        dice.animationFirstObject();
//        dice.animationTwoObject();
//        dice.animationThreeObject();
    }
}