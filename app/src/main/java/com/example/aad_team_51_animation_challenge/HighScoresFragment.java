package com.example.aad_team_51_animation_challenge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HighScoresFragment extends Fragment {

    private TextView highScoresTitleTextView = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_high_scores, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        highScoresTitleTextView = view.findViewById(R.id.highScoresTitleTextView);
    }

    @Override
    public void onResume() {
        super.onResume();
        animateHighScoreTitle();
    }

    private void animateHighScoreTitle() {
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.high_scores_animation);
        animation.reset();
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animation.reset();
                animation.setRepeatCount(Animation.INFINITE);
                animation.setRepeatMode(Animation.REVERSE);
                animation.start();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        highScoresTitleTextView.clearAnimation();
        highScoresTitleTextView.setAnimation(animation);
    }
}
