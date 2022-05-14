package com.jxr202.vivo_fingerprint_animator;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jxr202.vivo_fingerprint_animator.R;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    public @BindView(R.id.bezier) ImageView bezier;
    public @BindView(R.id.text) TextView text;
    public int stage = 1;
    public HashMap<Integer, AnimatedVectorDrawable> vectorDrawableHashMap = new HashMap<>();
    public AnimatedVectorDrawable bezierAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initVectorDrawable();
    }

    public void initVectorDrawable() {
        text.setText(String.valueOf(stage));
        vectorDrawableHashMap.put(1, (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.bezier_anim01, null));
        vectorDrawableHashMap.put(2, (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.bezier_anim02, null));
        vectorDrawableHashMap.put(3, (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.bezier_anim03, null));
        vectorDrawableHashMap.put(4, (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.bezier_anim04, null));
        vectorDrawableHashMap.put(5, (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.bezier_anim05, null));
        vectorDrawableHashMap.put(6, (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.bezier_anim06, null));
        vectorDrawableHashMap.put(7, (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.bezier_anim07, null));
        vectorDrawableHashMap.put(8, (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.bezier_anim08, null));
        vectorDrawableHashMap.put(9, (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.bezier_anim09, null));
        vectorDrawableHashMap.put(10, (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.bezier_anim10, null));
        vectorDrawableHashMap.put(11, (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.bezier_anim11, null));
        vectorDrawableHashMap.put(12, (AnimatedVectorDrawable) getResources().getDrawable(R.drawable.bezier_anim12, null));
    }

    private void drawFingerprint() {
        if (bezierAnimator != null && bezierAnimator.isRunning()) {
            return;
        }
        text.setText(String.valueOf(stage));
        bezierAnimator = vectorDrawableHashMap.get(stage);
        bezier.setImageDrawable(bezierAnimator);
        bezierAnimator.start();
        stage++;
        if (stage > 12) {
            stage = 1;
        }
    }

    @OnClick({R.id.bezier, R.id.text})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bezier:
                drawFingerprint();
                break;
            case R.id.text:
                drawFingerprint();
                break;
        }
    }
}
