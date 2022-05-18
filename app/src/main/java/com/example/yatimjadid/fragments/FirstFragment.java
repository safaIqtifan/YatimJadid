package com.example.yatimjadid.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.yatimjadid.Constants;
import com.example.yatimjadid.MainActivity;
import com.example.yatimjadid.Models.AllResolutionModels;
import com.example.yatimjadid.R;
import com.example.yatimjadid.StartYatimCriteriaActivity;
import com.example.yatimjadid.databinding.FragmentFirstBinding;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.widget.DatePicker;

import java.util.Calendar;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    String guardianOfTheOrphanStr = "الأم";
    String refugeeSelectedStr = "";
    String maritalStatusStr;
    String educationalLevelStr;
    String universityEducationStr;
    AllResolutionModels allResolutionModels;

    StartYatimCriteriaActivity ownerActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ownerActivity = (StartYatimCriteriaActivity) requireActivity();

        this.allResolutionModels = ownerActivity.allResolutionModels;

        initListeners();

    }

    @Override
    public void onResume() {
        super.onResume();
        this.allResolutionModels = ownerActivity.allResolutionModels;
    }

    @Override
    public void onPause() {
        super.onPause();
        ownerActivity.allResolutionModels = allResolutionModels;
    }

    private void initListeners() {
        binding.guardianOfTheOrphanRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.mother) {
                    binding.motherData.setVisibility(View.VISIBLE);
                    binding.parentsData.setVisibility(View.GONE);
                    guardianOfTheOrphanStr = binding.mother.getText().toString();
                }
                if (i == R.id.other) {
                    binding.motherData.setVisibility(View.GONE);
                    binding.parentsData.setVisibility(View.VISIBLE);
                    guardianOfTheOrphanStr = binding.other.getText().toString();
                }
            }
        });

        binding.refugeeStatusRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.refugee) {
                    refugeeSelectedStr = binding.refugee.getText().toString();
                }
                if (i == R.id.non_refugee) {
                    refugeeSelectedStr = binding.nonRefugee.getText().toString();
                }
            }
        });

        binding.motherDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month + 1;
                        Log.d("TAG", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                        String date = month + "/" + day + "/" + year;
                        binding.motherDateOfBirth.setText(date);
                    }
                };
                getDateOfBirth();
            }
        });

        binding.maritalStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    maritalStatusStr = binding.maritalStatus.getSelectedItem().toString();
                else
                    maritalStatusStr = "";

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.educationalLevel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0) {
                    educationalLevelStr = binding.educationalLevel.getSelectedItem().toString();
                    if (educationalLevelStr.equals("جامعي") || educationalLevelStr.equals("المستوي التعليمي للأم")) {
                        binding.universityEducationLy.setVisibility(View.VISIBLE);
                        binding.specializationTextInputLayout.setVisibility(View.VISIBLE);
                        binding.specializationInfo.setVisibility(View.VISIBLE);
                    } else {
                        binding.universityEducationLy.setVisibility(View.GONE);
                        binding.specializationTextInputLayout.setVisibility(View.GONE);
                        binding.specializationInfo.setVisibility(View.GONE);
                    }
                } else
                    educationalLevelStr = "";
//                allResolutionModels.setEducationalLevel(String.valueOf(i));
//                binding.educationalLevel.setSelection(i);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.universityEducation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    universityEducationStr = binding.universityEducation.getSelectedItem().toString();
                else
                    universityEducationStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.parentsDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDateSetListener = (datePicker, year, month, day) -> {
                    month = month + 1;
                    Log.d("TAG", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                    String date = month + "/" + day + "/" + year;
                    binding.parentsDateOfBirth.setText(date);
                };
                getDateOfBirth();
            }
        });

        binding.nextFirstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkYatimParentsData();
            }
        });
    }

    public void checkYatimParentsData() {

        String motherNameStr = binding.motherName.getText().toString();
        String motherDateOfBirthStr = binding.motherDateOfBirth.getText().toString();
        String specializationStr = binding.specialization.getText().toString();
        String graduationYearStr = binding.graduationYear.getText().toString();
        String averageStr = binding.average.getText().toString();

        String parentsNameStr = binding.parentsName.getText().toString();
        String parentsIdStr = binding.parentsId.getText().toString();
        String parentsDateOfBirthStr = binding.parentsDateOfBirth.getText().toString();
        String relationshipWithTheOrphanStr = binding.relationshipWithTheOrphan.getText().toString();


        boolean hasError = false;

        if (guardianOfTheOrphanStr.equals("الأم")) {
            allResolutionModels.setGuardianOfTheOrphanSelected(guardianOfTheOrphanStr);

            if (refugeeSelectedStr.isEmpty()) {
                hasError = true;
            } else {
                allResolutionModels.setRefugeeSelected(refugeeSelectedStr);
            }

            if (motherNameStr.isEmpty()) {
                hasError = true;
            } else {
                allResolutionModels.setMotherName(motherNameStr);
            }

            if (motherDateOfBirthStr.isEmpty()) {
                hasError = true;
            } else {
                allResolutionModels.setMotherDateOfBirth(motherDateOfBirthStr);
            }

            if (maritalStatusStr.isEmpty()) {
                hasError = true;
            } else {
                allResolutionModels.setMaritalStatus(maritalStatusStr);
            }

            if (educationalLevelStr.equals("جامعي")) {
                allResolutionModels.setEducationalLevel(educationalLevelStr);

                if (universityEducationStr.isEmpty()) {
                    hasError = true;
                } else {
                    allResolutionModels.setUniversityEducation(universityEducationStr);
                }

                if (specializationStr.isEmpty()) {
                    hasError = true;
                } else {
                    allResolutionModels.setSpecialization(specializationStr);
                }

                if (graduationYearStr.isEmpty()) {
                    hasError = true;
                } else {
                    allResolutionModels.setGraduationYear(graduationYearStr);
                }

                if (averageStr.isEmpty()) {
                    hasError = true;
                } else {
                    allResolutionModels.setAverage(averageStr);
                }

            } else if (educationalLevelStr.isEmpty()) {
                hasError = true;
            }

        } else if (guardianOfTheOrphanStr.equals("أخرى")) {
            allResolutionModels.setGuardianOfTheOrphanSelected(guardianOfTheOrphanStr);

            if (refugeeSelectedStr.isEmpty()) {
                hasError = true;
            } else {
                allResolutionModels.setRefugeeSelected(refugeeSelectedStr);
            }

            if (parentsNameStr.isEmpty()) {
                hasError = true;
            } else {
                allResolutionModels.setParentsName(parentsNameStr);
            }

            if (parentsIdStr.isEmpty()) {
                hasError = true;
            } else {
                allResolutionModels.setParentsId(parentsIdStr);
            }

            if (parentsDateOfBirthStr.isEmpty()) {
                hasError = true;
            } else {
                allResolutionModels.setParentsDateOfBirth(parentsDateOfBirthStr);
            }

            if (relationshipWithTheOrphanStr.isEmpty()) {
                hasError = true;
            } else {
                allResolutionModels.setRelationshipWithTheOrphan(relationshipWithTheOrphanStr);
            }
//            allResolutionModels.setGuardianOfTheOrphanSelected(guardianOfTheOrphanStr);
        }
        if (hasError) {
            Toast.makeText(getActivity(), getString(R.string.please_fill_data), Toast.LENGTH_SHORT).show();
            return;
        }

        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.KEY_YATIM_MODEL, allResolutionModels);

//        NavHostFragment.findNavController(FirstFragment.this)
//                .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);

        ownerActivity.nextFragment();

    }

    public void getDateOfBirth() {

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                getActivity(),
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDateSetListener,
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}