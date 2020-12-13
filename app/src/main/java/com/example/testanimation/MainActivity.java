package com.example.testanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button move;
    ObjectAnimator animationX, animationY, rotateAnimation;
    AnimatorSet image1 = new AnimatorSet();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public void init() {
        imageView = findViewById(R.id.imageView);
        move = (Button) findViewById(R.id.btnMove);


    }

    public void animationFirstObject(){
        Double generateX = (Double) (0 + Math.random() * 1000);
        Double generateY = (Double) (500 + Math.random() * 1000);
        float xEnd = generateX.floatValue();
        float yEnd = generateY.floatValue();

        AnimatorSet image1 = new AnimatorSet();
        animationX = ObjectAnimator.ofFloat(imageView, "x", -300f, xEnd);
        animationY = ObjectAnimator.ofFloat(imageView, "y", -300f, yEnd);
        rotateAnimation = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 720f);
        animationX.setDuration(1000);
        animationY.setDuration(1000);
        rotateAnimation.setDuration(1500);
        image1.playTogether(animationX, animationY, rotateAnimation);
        image1.start();
        }




    public void onClickMove(View view) {
        animationFirstObject();
    }
}