package com.example.stan.mylibrary;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;

/**
 * Created by stan on 16/5/13.
 */
public class GradientImageView extends FrameLayout {
    int tarColor;
    ObjectAnimator animator;
    ImageView loginBackground;
    Context context;
    public GradientImageView(Context context) {
        super(context);
        initData(context);
    }

    public GradientImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initData(context);
    }

    public GradientImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initData(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public GradientImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initData(context);
    }

//    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void initData(Context context) {
        this.context = context;
        LayoutInflater.from(getContext()).inflate(R.layout.bg_view_gradient_layout, this, true);
        loginBackground = (ImageView) findViewById(R.id.login_background);
        initAnimator();
    }
    private void initAnimator() {
        animator = ObjectAnimator.ofFloat(loginBackground, " ", 0.0f, 1.0f).setDuration(15000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(Animation.REVERSE);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float cVal = (float) animation.getAnimatedValue();
                tarColor = (0xff & (int) (cVal * 240)) << 24 | (0xff) << 16;
                loginBackground.setColorFilter(tarColor, PorterDuff.Mode.SRC_ATOP);
            }
        });
    }

    public void startAnimation() {
        if (animator == null)
            initAnimator();
        else
            animator.start();
    }

    public void stopAnimation() {
        animator.cancel();
        animator = null;
    }


}
