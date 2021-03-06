package com.rohit.scrumcard;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class PointActivity extends AppCompatActivity {
    String value;
    TextView displayValue;
    RelativeLayout pointShow;
    RelativeLayout pointHide;
    AnimatorSet mSetRightOut;
    AnimatorSet mSetLeftIn;
    Boolean mIsBackVisible = true;
    Boolean canAnimate = true;
    TextView hint;

    /**
     * Set Camera Distance to support flip on all screen size
     */
    private void changeCameraDistance() {
        int distance = 8000;
        float scale = getResources().getDisplayMetrics().density * distance;
        pointShow.setCameraDistance(scale);
        pointHide.setCameraDistance(scale);
    }

    /**
     * Flip card logic to flip a card
     */
    private void flipCard() {
        if (!canAnimate) return;

        canAnimate = false;

        if (!mIsBackVisible) {
            mSetRightOut.setTarget(pointShow);
            mSetLeftIn.setTarget(pointHide);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = true;
        } else {
            mSetRightOut.setTarget(pointHide);
            mSetLeftIn.setTarget(pointShow);
            mSetRightOut.start();
            mSetLeftIn.start();
            mIsBackVisible = false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_point);
        super.onCreate(savedInstanceState);

        value = getIntent().getStringExtra("CARD_VALUE");
        pointHide = (RelativeLayout) findViewById(R.id.point_layout_hide);
        pointShow = (RelativeLayout) findViewById(R.id.point_layout_show);
        displayValue = (TextView) findViewById(R.id.display_value);
        mSetRightOut = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.out_animation);
        mSetLeftIn = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.in_animation);
        hint = (TextView) findViewById(R.id.tap_to_show_point);

        displayValue.setText(value);
        changeCameraDistance();

        pointHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard();
            }
        });
        pointShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard();
            }
        });
        mSetLeftIn.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                hint.setVisibility(TextView.INVISIBLE);
                canAnimate = true;
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MainActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
