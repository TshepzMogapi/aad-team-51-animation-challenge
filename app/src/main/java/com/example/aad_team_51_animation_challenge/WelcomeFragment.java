package com.example.aad_team_51_animation_challenge;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

// SVG from https://svgsilh.com/image/1974671.html

public class WelcomeFragment extends Fragment {

    AnimatedVectorDrawable an = null;

    public WelcomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        AppCompatImageView aciv = view.findViewById(R.id.africaImageView);
        an = (AnimatedVectorDrawable) aciv.getDrawable();
        final Handler mainHandler = new Handler(Looper.getMainLooper());
        AnimatedVectorDrawableCompat.registerAnimationCallback(aciv.getDrawable(), new Animatable2Compat.AnimationCallback() {
            @Override
            public void onAnimationEnd(Drawable drawable) {
                mainHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        an.start();
                    }
                });
            }
        });

        Button continueButton = view.findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_welcomeFragment_to_mainFragment);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        an.start();
    }
}
