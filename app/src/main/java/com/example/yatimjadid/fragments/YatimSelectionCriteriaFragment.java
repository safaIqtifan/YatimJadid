package com.example.yatimjadid.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.yatimjadid.MainActivity;
import com.example.yatimjadid.StartYatimCriteriaActivity;
import com.example.yatimjadid.UtiltApp;
import com.example.yatimjadid.databinding.FragmentYatimSelectionCriteriaBinding;

public class YatimSelectionCriteriaFragment extends Fragment {

    private FragmentYatimSelectionCriteriaBinding binding;

    ActivityResultLauncher<Intent> addYatimCriteriaLaunch = null;

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

        addYatimCriteriaLaunch = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {

                UtiltApp.setFamilyMembers(requireActivity(), null);
                UtiltApp.setYatimData(requireActivity(), null);
                requireActivity().recreate();

            }
        });


//        binding.mainToolbar.setTitle("معايير اختيار الأيتام");
        binding.nextBtn.setOnClickListener(view1 -> {

//            NavHostFragment.findNavController(YatimSelectionCriteriaFragment.this)
//                    .navigate(R.id.action_yatimSelectionCriteriaFragment_to_FirstFragment );

            Intent intent = new Intent(requireActivity(), StartYatimCriteriaActivity.class);
            addYatimCriteriaLaunch.launch(intent);

        });

    }
}