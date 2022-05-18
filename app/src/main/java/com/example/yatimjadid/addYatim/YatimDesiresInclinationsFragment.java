package com.example.yatimjadid.addYatim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;

import com.example.yatimjadid.AddYatimActivity;
import com.example.yatimjadid.Constants;
import com.example.yatimjadid.Models.AddYatimModel;
import com.example.yatimjadid.R;
import com.example.yatimjadid.StartYatimCriteriaActivity;
import com.example.yatimjadid.databinding.FragmentYatimDesiresInclinationsBinding;

public class YatimDesiresInclinationsFragment extends Fragment {

    private FragmentYatimDesiresInclinationsBinding binding;

    String talentSelectedStr = "";
    String interestsSelectedStr = "";
    String skillsSelectedStr = "";
    String wishSelectedStr = "";
    String responsibilitiesSelectedStr = "";

    AddYatimModel addYatimModel;
    AddYatimActivity ownerActivity;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentYatimDesiresInclinationsBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        Bundle bundle = getArguments();
//        if (bundle != null && bundle.containsKey(Constants.KEY_NEW_YATIM_DATA_MODEL))
//            addYatimModel = (AddYatimModel) bundle.getSerializable(Constants.KEY_NEW_YATIM_DATA_MODEL);
//        else
//            addYatimModel = new AddYatimModel();.

        ownerActivity = (AddYatimActivity) requireActivity();
        this.addYatimModel = ownerActivity.addYatimModel;

        binding.talent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    talentSelectedStr = binding.talent.getSelectedItem().toString();
                else
                    talentSelectedStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.interests.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    interestsSelectedStr = binding.interests.getSelectedItem().toString();
                else
                    interestsSelectedStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.skills.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    skillsSelectedStr = binding.skills.getSelectedItem().toString();
                else
                    skillsSelectedStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.wish.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    wishSelectedStr = binding.wish.getSelectedItem().toString();
                else
                    wishSelectedStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.responsibilities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    responsibilitiesSelectedStr = binding.responsibilities.getSelectedItem().toString();
                else
                    responsibilitiesSelectedStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        binding.nextDesiresFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkYatimHousingCondition();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        this.addYatimModel = ownerActivity.addYatimModel;
    }

    @Override
    public void onPause() {
        super.onPause();
        ownerActivity.addYatimModel = addYatimModel;
    }
    public void checkYatimHousingCondition() {

        String favoriteFoodStr = binding.favoriteFood.getText().toString();
        String futureWishStr = binding.futureWish.getText().toString();
        String petStr = binding.pet.getText().toString();
        String immediateNeedsStr = binding.immediateNeeds.getText().toString();

        boolean hasError = false;

        if (talentSelectedStr.isEmpty()) {
            hasError = true;
        }else {
            addYatimModel.setTalentSelected(talentSelectedStr);
        }
        if (interestsSelectedStr.isEmpty()) {
            hasError = true;
        }else {
            addYatimModel.setMaterialsNeedStrengthening(interestsSelectedStr);
        }
        if (skillsSelectedStr.isEmpty()) {
            hasError = true;
        }else {
            addYatimModel.setMaterialsNeedStrengthening(skillsSelectedStr);
        }
        if (wishSelectedStr.isEmpty()) {
            hasError = true;
        }else {
            addYatimModel.setMaterialsNeedStrengthening(wishSelectedStr);
        }
        if (responsibilitiesSelectedStr.isEmpty()) {
            hasError = true;
        }else {
            addYatimModel.setMaterialsNeedStrengthening(responsibilitiesSelectedStr);
        }
        if (favoriteFoodStr.isEmpty()) {
            hasError = true;
        }else {
            addYatimModel.setMaterialsNeedStrengthening(favoriteFoodStr);
        }
        if (futureWishStr.isEmpty()) {
            hasError = true;
        }else {
            addYatimModel.setMaterialsNeedStrengthening(futureWishStr);
        }
        if (petStr.isEmpty()) {
            hasError = true;
        }else {
            addYatimModel.setMaterialsNeedStrengthening(petStr);
        }
        if (immediateNeedsStr.isEmpty()) {
            hasError = true;
        }else {
            addYatimModel.setMaterialsNeedStrengthening(immediateNeedsStr);
        }

        if (hasError) {
            Toast.makeText(getActivity(), getString(R.string.please_fill_data), Toast.LENGTH_SHORT).show();
            return;
        }
        ownerActivity.nextFragment();
//        Bundle bundle = new Bundle();
//        bundle.putSerializable(Constants.KEY_NEW_YATIM_DATA_MODEL, addYatimModel);
//        NavHostFragment.findNavController(YatimDesiresInclinationsFragment.this)
//                .navigate(R.id.action_YatimDesiresInclinationsFragment_to_AddAttachmentsFragment, bundle);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}