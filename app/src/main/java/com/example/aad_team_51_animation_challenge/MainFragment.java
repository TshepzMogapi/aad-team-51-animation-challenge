package com.example.aad_team_51_animation_challenge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

//Background Image by <a href="https://pixabay.com/users/IanZA-2026973/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=2888519">Ian Lindsay</a> from <a href="https://pixabay.com/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=2888519">Pixabay</a>

public class MainFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button button = view.findViewById(R.id.button_about);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_mainFragment_to_aboutFragment);
            }
        });

        button = view.findViewById(R.id.button_game);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_mainFragment_to_gameFragment);
            }
        });

        button = view.findViewById(R.id.button_questions);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_mainFragment_to_manageQuestionsFragment);
            }
        });

        button = view.findViewById(R.id.button_scores);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_mainFragment_to_highScoresFragment);
            }
        });

    }
}
