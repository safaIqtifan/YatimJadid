package com.example.yatimjadid;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yatimjadid.databinding.FragmentSecondBinding;
import com.example.yatimjadid.databinding.FragmentYatimSelectionCriteriaBinding;

public class YatimSelectionCriteriaFragment extends Fragment {

    private FragmentYatimSelectionCriteriaBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentYatimSelectionCriteriaBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.mainToolbar.setTitle("معايير اختيار الأيتام");
        binding.nextBtn.setOnClickListener(view1 -> {

            NavHostFragment.findNavController(YatimSelectionCriteriaFragment.this)
                    .navigate(R.id.action_yatimSelectionCriteriaFragment_to_FirstFragment );

        });


        binding.toolbarExitBtn.setOnClickListener(view1 -> {
            
        });

    }
}