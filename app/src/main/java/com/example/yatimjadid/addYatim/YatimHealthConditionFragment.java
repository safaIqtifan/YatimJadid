package com.example.yatimjadid.addYatim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;

import com.example.yatimjadid.AddYatimActivity;
import com.example.yatimjadid.Constants;
import com.example.yatimjadid.Models.AddYatimModel;
import com.example.yatimjadid.R;
import com.example.yatimjadid.StartYatimCriteriaActivity;
import com.example.yatimjadid.databinding.FragmentYatimHealthConditionBinding;

public class YatimHealthConditionFragment extends Fragment {

    private FragmentYatimHealthConditionBinding binding;

    String bodyHealthSelectedStr = "";
    String healthConditionSelectedStr = "";
    String hasALockSelectedStr = "";
    String natureOfCaseStr = "";
    String statusSinceSelectedStr = "";
    String disabilityTypeStr = "";
    String yatimSpecialNeedsStr = "";
    String handicappedNeedsStr = "";
    String teethHealthStr = "";
    String psychologicalStateStr = "";
    String yatimNeedsStr = "";

    AddYatimModel addYatimModel;
    AddYatimActivity ownerActivity;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentYatimHealthConditionBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        Bundle bundle = getArguments();
//        if (bundle != null && bundle.containsKey(Constants.KEY_NEW_YATIM_DATA_MODEL))
//            addYatimModel = (AddYatimModel) bundle.getSerializable(Constants.KEY_NEW_YATIM_DATA_MODEL);
//        else
//            addYatimModel = new AddYatimModel();

        ownerActivity = (AddYatimActivity) requireActivity();
        this.addYatimModel = ownerActivity.addYatimModel;

        binding.bodyHealth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    bodyHealthSelectedStr = binding.bodyHealth.getSelectedItem().toString();
                else
                    bodyHealthSelectedStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.healthConditionRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.healthy) {
                    healthConditionSelectedStr = binding.healthy.getText().toString();
                    binding.healthLayout.setVisibility(View.GONE);
                }
                if (i == R.id.unhealthy) {
                    healthConditionSelectedStr = binding.unhealthy.getText().toString();
                    binding.healthLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.hasALockRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.has_a_lock_yes) {
                    hasALockSelectedStr = binding.hasALockYes.getText().toString();
                }
                if (i == R.id.has_a_lock_no) {
                    hasALockSelectedStr = binding.hasALockNo.getText().toString();
                }
            }
        });

        binding.natureOfCase.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0) {
                    natureOfCaseStr = binding.natureOfCase.getSelectedItem().toString();
                    if (natureOfCaseStr.equals("??????????")) {
                        binding.disabilityType.setSelection(0);
                        binding.disabilityTypeLayout.setVisibility(View.VISIBLE);
                    } else {
                        binding.disabilityType.setSelection(0);
                        binding.disabilityTypeLayout.setVisibility(View.GONE);
                    }
                } else
                    natureOfCaseStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.statusSinceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.birth) {
                    statusSinceSelectedStr = binding.birth.getText().toString();
                }
                if (i == R.id.birth_other) {
                    statusSinceSelectedStr = binding.birthOther.getText().toString();
                }
            }
        });

        binding.disabilityType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0) {
                    disabilityTypeStr = binding.disabilityType.getSelectedItem().toString();
                } else {
                    disabilityTypeStr = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.yatimSpecialNeeds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    yatimSpecialNeedsStr = binding.yatimSpecialNeeds.getSelectedItem().toString();
                else
                    yatimSpecialNeedsStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.handicappedNeeds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    handicappedNeedsStr = binding.handicappedNeeds.getSelectedItem().toString();
                else
                    handicappedNeedsStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.teethHealth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    teethHealthStr = binding.teethHealth.getSelectedItem().toString();
                else
                    teethHealthStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.psychologicalStateforChild.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0) {
                    psychologicalStateStr = binding.psychologicalStateforChild.getSelectedItem().toString();
                    if (psychologicalStateStr.equals("?????????? ???? ?????????????? ??????????")) {
                        binding.mentalDisorderTypeTextInput.setVisibility(View.VISIBLE);
                    } else {
                        binding.mentalDisorderTypeTextInput.setVisibility(View.GONE);
                    }
                } else {
                    psychologicalStateStr = "";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.yatimNeeds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    yatimNeedsStr = binding.yatimNeeds.getSelectedItem().toString();
                else
                    yatimNeedsStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.backFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                ((StartYatimCriteriaActivity) requireActivity()).prevFragment();
                ownerActivity.prevFragment();
            }
        });

        binding.nextSecondFragment.setOnClickListener(new View.OnClickListener() {
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

        String heightStr = binding.height.getText().toString();
        String weightStr = binding.weight.getText().toString();
        String diseaseNameStr = binding.diseaseName.getText().toString();
        String mentalDisorderTypeStr = binding.mentalDisorderType.getText().toString();

        boolean hasError = false;

        if (heightStr.isEmpty()) {
            hasError = true;
        }else {
            addYatimModel.setHeight(heightStr);
        }
        if (weightStr.isEmpty()) {
            hasError = true;
        }else {
            addYatimModel.setWeight(weightStr);
        }
        if (bodyHealthSelectedStr.isEmpty()) {
            hasError = true;
        }else {
            addYatimModel.setNeedAnyOfTheFollowing(bodyHealthSelectedStr);
        }
        if (hasALockSelectedStr.isEmpty()) {
            hasError = true;
        }else {
            addYatimModel.setHasALockSelected(hasALockSelectedStr);
        }
        if (healthConditionSelectedStr.isEmpty()){
            hasError = true;
        }else {
            addYatimModel.setHealthConditionSelected(healthConditionSelectedStr);
        }
        if (healthConditionSelectedStr.equals("?????? ??????????")) {
            addYatimModel.setHealthConditionSelected(healthConditionSelectedStr);
            if (natureOfCaseStr.isEmpty()) {
                hasError = true;
            }else {
                addYatimModel.setNatureOfCase(natureOfCaseStr);
            }
            if (natureOfCaseStr.equals("??????????")) {
                addYatimModel.setNatureOfCase(natureOfCaseStr);
                if (disabilityTypeStr.isEmpty()) {
                    hasError = true;
                }else {
                    addYatimModel.setDisabilityType(disabilityTypeStr);
                }
            }
            if (statusSinceSelectedStr.isEmpty()) {
                hasError = true;
            }else {
                addYatimModel.setStatusSinceSelected(statusSinceSelectedStr);
            }
            if (diseaseNameStr.isEmpty()) {
                hasError = true;
            }else {
                addYatimModel.setDiseaseName(diseaseNameStr);
            }
            if (yatimSpecialNeedsStr.isEmpty()) {
                hasError = true;
            }else {
                addYatimModel.setYatimSpecialNeeds(yatimSpecialNeedsStr);
            }
            if (handicappedNeedsStr.isEmpty()) {
                hasError = true;
            }else {
                addYatimModel.setHandicappedNeeds(handicappedNeedsStr);
            }
            if (psychologicalStateStr.isEmpty()){
                hasError = true;
            }else {
                addYatimModel.setPsychologicalState(psychologicalStateStr);
            }
            if (psychologicalStateStr.equals("?????????? ???? ?????????????? ??????????")) {
                if (mentalDisorderTypeStr.isEmpty()) {
                    hasError = true;
                }else {
                    addYatimModel.setMentalDisorderType(mentalDisorderTypeStr);
                }
            }
            if (teethHealthStr.isEmpty()) {
                hasError = true;
            }else {
                addYatimModel.setTeethHealth(teethHealthStr);
            }
            if (yatimNeedsStr.isEmpty()) {
                hasError = true;
            }else {
                addYatimModel.setYatimNeeds(yatimNeedsStr);
            }
        }

        if (hasError) {
            Toast.makeText(getActivity(), getString(R.string.please_fill_data), Toast.LENGTH_SHORT).show();
            return;
        }

//        Bundle bundle = new Bundle();
//        bundle.putSerializable(Constants.KEY_NEW_YATIM_DATA_MODEL, addYatimModel);
//        NavHostFragment.findNavController(YatimHealthConditionFragment.this)
//                .navigate(R.id.action_YatimHealthConditionFragment_to_YatimEducationalStatusFragment, bundle);

        ownerActivity.nextFragment();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}