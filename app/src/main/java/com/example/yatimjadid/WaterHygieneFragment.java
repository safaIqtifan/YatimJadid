package com.example.yatimjadid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.yatimjadid.Models.AllResolutionModels;
import com.example.yatimjadid.databinding.FragmentWaterHygieneBinding;

public class WaterHygieneFragment extends Fragment {

    private FragmentWaterHygieneBinding binding;

    String domesticWaterSourceStr;
    String sourceOfDrinkingCookingWaterStr;
    String numberOfMunicipalDaysWaterArrivedStr;
    String doHeNeedAnyOfTheFollowingStr;
    String conditionOfCleanlinessArrangementStr;
    String guardianOfTheOrphanSelectedStr = "";
    String familyDebtsSelectedStr = "";
    String accumulatedCollegeSelectedStr = "";

    AllResolutionModels allResolutionModels;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentWaterHygieneBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey(Constants.KEY_YATIM_MODEL))
            allResolutionModels = (AllResolutionModels) bundle.getSerializable(Constants.KEY_YATIM_MODEL);
        else
            allResolutionModels = new AllResolutionModels();

        binding.domesticWaterSource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                domesticWaterSourceStr = binding.domesticWaterSource.getSelectedItem().toString();
                else
                    domesticWaterSourceStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.sourceOfDrinkingCookingWater.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                sourceOfDrinkingCookingWaterStr = binding.sourceOfDrinkingCookingWater.getSelectedItem().toString();
                else
                    sourceOfDrinkingCookingWaterStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.numberOfMunicipalDaysWaterArrived.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                numberOfMunicipalDaysWaterArrivedStr = binding.numberOfMunicipalDaysWaterArrived.getSelectedItem().toString();
                else
                    numberOfMunicipalDaysWaterArrivedStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.doHeNeedAnyOfTheFollowing.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                doHeNeedAnyOfTheFollowingStr = binding.doHeNeedAnyOfTheFollowing.getSelectedItem().toString();
                else
                    doHeNeedAnyOfTheFollowingStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.conditionOfCleanlinessArrangement.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                conditionOfCleanlinessArrangementStr = binding.conditionOfCleanlinessArrangement.getSelectedItem().toString();
                else
                    conditionOfCleanlinessArrangementStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.guardianOfTheOrphanRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.guardian_of_the_orphan_yes) {
                    guardianOfTheOrphanSelectedStr = binding.guardianOfTheOrphanYes.getText().toString();
                }
                if (i == R.id.guardian_of_the_orphan_no) {
                    guardianOfTheOrphanSelectedStr = binding.guardianOfTheOrphanNo.getText().toString();
                }
            }
        });

        binding.familyDebtsRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.family_debts_yes) {
                    familyDebtsSelectedStr = binding.familyDebtsYes.getText().toString();
                }
                if (i == R.id.family_debts_no) {
                    familyDebtsSelectedStr = binding.familyDebtsNo.getText().toString();
                }
            }
        });

        binding.accumulatedCollegeLoansRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.accumulated_college_yes) {
                    accumulatedCollegeSelectedStr = binding.accumulatedCollegeYes.getText().toString();
                }
                if (i == R.id.accumulated_college_no) {
                    accumulatedCollegeSelectedStr = binding.accumulatedCollegeNo.getText().toString();
                }
            }
        });


        binding.nextWaterFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkYatimWaterHygiene();
            }
        });

    }

    public void checkYatimWaterHygiene() {

        String tankCapacityStr = binding.tankCapacityEd.getText().toString();
        String tankCapacityNumberStr = binding.tankCapacityNumber.getText().toString();
        String drinkingWaterCapacityStr = binding.drinkingWaterCapacity.getText().toString();
        String drinkingWaterCapacityNumStr = binding.drinkingWaterCapacityNum.getText().toString();
        String workNatureStr = binding.workNatureEd.getText().toString();
        String averageIncomeStr = binding.averageIncomeEd.getText().toString();

        boolean hasError = false;

        if (domesticWaterSourceStr.isEmpty()) {
            hasError = true;
        }
        if (sourceOfDrinkingCookingWaterStr.isEmpty()) {
            hasError = true;
        }
        if (numberOfMunicipalDaysWaterArrivedStr.isEmpty()) {
            hasError = true;
        }
        if (doHeNeedAnyOfTheFollowingStr.isEmpty()) {
            hasError = true;
        }
        if (conditionOfCleanlinessArrangementStr.isEmpty()) {
            hasError = true;
        }
        if (tankCapacityStr.isEmpty()) {
            hasError = true;
        }
        if (tankCapacityNumberStr.isEmpty()) {
            hasError = true;
        }
        if (drinkingWaterCapacityStr.isEmpty()) {
            hasError = true;
        }
        if (drinkingWaterCapacityNumStr.isEmpty()) {
            hasError = true;
        }
        if (guardianOfTheOrphanSelectedStr.isEmpty()) {
            hasError = true;
        }
        if (familyDebtsSelectedStr.isEmpty()) {
            hasError = true;
        }
        if (accumulatedCollegeSelectedStr.isEmpty()) {
            hasError = true;
        }
        if (workNatureStr.isEmpty()) {
            hasError = true;
        }
        if (averageIncomeStr.isEmpty()) {
            hasError = true;
        }
        if (hasError) {
            Toast.makeText(getActivity(), getString(R.string.please_fill_data), Toast.LENGTH_SHORT).show();
            return;
        }

        allResolutionModels.setDomesticWaterSource(domesticWaterSourceStr);
        allResolutionModels.setSourceOfDrinkingCookingWater(sourceOfDrinkingCookingWaterStr);
        allResolutionModels.setNumberOfMunicipalDaysWaterArrived(numberOfMunicipalDaysWaterArrivedStr);
        allResolutionModels.setDoHeNeedAnyOfTheFollowing(doHeNeedAnyOfTheFollowingStr);
        allResolutionModels.setConditionOfCleanlinessArrangement(conditionOfCleanlinessArrangementStr);
        allResolutionModels.setTankCapacity(tankCapacityStr);
        allResolutionModels.setTankCapacityNumber(tankCapacityNumberStr);
        allResolutionModels.setDrinkingWaterCapacity(drinkingWaterCapacityStr);
        allResolutionModels.setDrinkingWaterCapacityNum(drinkingWaterCapacityNumStr);
        allResolutionModels.setGuardianOfTheOrphanSelected(guardianOfTheOrphanSelectedStr);
        allResolutionModels.setFamilyDebtsSelected(familyDebtsSelectedStr);
        allResolutionModels.setAccumulatedCollegeSelected(accumulatedCollegeSelectedStr);
        allResolutionModels.setWorkNature(workNatureStr);
        allResolutionModels.setAverageIncome(averageIncomeStr);

        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.KEY_YATIM_MODEL, allResolutionModels);

        NavHostFragment.findNavController(WaterHygieneFragment.this)
                .navigate(R.id.action_WaterHygieneFragment_to_FamilyMembersFragment, bundle);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}