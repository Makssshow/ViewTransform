package com.example.viewtransform;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    RelativeLayout layout;
    boolean anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layoutT);

//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(200, 200);
//        layoutParams.leftMargin = 100;
//        layoutParams.topMargin = 100;
//        layoutParams.

        anim = false;

        layout.setOnClickListener(v -> {
            if (!anim) {
                ObjectAnimator animation = ObjectAnimator.ofFloat(layout, "translationX", 500f);
                animation.setDuration(2000).start();
                ObjectAnimator animation2 = ObjectAnimator.ofFloat(layout, "translationY", 500f);
                animation2.setDuration(2000).start();
                ObjectAnimator animationScale = ObjectAnimator.ofFloat(layout, View.SCALE_X, 1.5f);
                animationScale.setDuration(2000).start();
                ObjectAnimator animationScale2 = ObjectAnimator.ofFloat(layout, View.SCALE_Y, 1.5f);
                animationScale2.setDuration(2000).start();
                ObjectAnimator animationRotate = ObjectAnimator.ofFloat(layout, View.ROTATION, 50f);
                animationRotate.setDuration(2000).start();
                ObjectAnimator animationAlpha = ObjectAnimator.ofFloat(layout, View.ALPHA, .5f);
                animationAlpha.setDuration(2000).start();

                int colorFrom = getResources().getColor(R.color.black);
                int colorTo = getResources().getColor(R.color.purple_500);
                ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
                colorAnimation.setDuration(2000); // milliseconds
                colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {
                        layout.setBackgroundColor((int) animator.getAnimatedValue());
                    }

                });
                colorAnimation.start();
                anim = true;
            } else {

                ObjectAnimator animationRotate = ObjectAnimator.ofFloat(layout, View.ROTATION, 180f);
                animationRotate.setDuration(2000).start();

                int colorFrom = getResources().getColor(R.color.purple_500);
                int colorTo = getResources().getColor(R.color.black);
                ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
                colorAnimation.setDuration(2000); // milliseconds
                colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

                    @Override
                    public void onAnimationUpdate(ValueAnimator animator) {
                        layout.setBackgroundColor((int) animator.getAnimatedValue());
                    }

                });
                colorAnimation.start();
                anim = false;
            }
        });





    }
}