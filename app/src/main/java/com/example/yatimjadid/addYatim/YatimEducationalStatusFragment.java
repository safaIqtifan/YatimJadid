package com.example.yatimjadid.addYatim;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.example.yatimjadid.Constants;
import com.example.yatimjadid.Models.AddYatimModel;
import com.example.yatimjadid.R;
import com.example.yatimjadid.databinding.FragmentYatimEducationalStatusBinding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class YatimEducationalStatusFragment extends Fragment {

    private FragmentYatimEducationalStatusBinding binding;

    String educationalStatusSelectedStr = "";
    String reasonForNotJoiningStr = "";
    String stageStr = "";
    String schoolTypeStr = "";
    String periodSelectedStr = "";
    String ConsistentSelectedStr = "";
    String nonComplianceStr = "";
    String reachSchoolStr = "";
    String readWriteSelectedStr = "";
    String levelOfAcademicAchievementStr = "";
    String educationalSpecialNeedsStr = "";
    String materialsNeedStrengtheningStr = "";

    AddYatimModel addYatimModel;

    boolean[] selectedeDucationalSpecialneeds;
    ArrayList<Integer> educationalSpecialneedsList = new ArrayList<>();

    boolean[] selectedMaterialsNeedStrengthening;
    ArrayList<Integer> materialsNeedStrengtheningList = new ArrayList<>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentYatimEducationalStatusBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey(Constants.KEY_NEW_YATIM_DATA_MODEL))
            addYatimModel = (AddYatimModel) bundle.getSerializable(Constants.KEY_NEW_YATIM_DATA_MODEL);
//        else
//            addYatimModel = new AddYatimModel();

//        addYatimModel = new AddYatimModel();

//        initList();

        binding.educationalStatusRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.enrolled) {
                    educationalStatusSelectedStr = binding.enrolled.getText().toString();
                    binding.educationalStatusLayout.setVisibility(View.VISIBLE);
                    binding.reasonForNotJoiningLayout.setVisibility(View.GONE);
                    binding.reasonForNotJoining.setSelection(0);
                }
                if (i == R.id.not_enrolled) {
                    educationalStatusSelectedStr = binding.notEnrolled.getText().toString();
                    binding.reasonForNotJoiningLayout.setVisibility(View.VISIBLE);
                    binding.educationalStatusLayout.setVisibility(View.GONE);
                }
            }

        });

        binding.reasonForNotJoining.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    reasonForNotJoiningStr = binding.reasonForNotJoining.getSelectedItem().toString();
                else
                    reasonForNotJoiningStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.stage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0){
                    stageStr = binding.stage.getSelectedItem().toString();
                    if (i == 1 || i == 2) {
                        binding.specialistTextInputLayout.setVisibility(View.GONE);
                        binding.periodLy.setVisibility(View.VISIBLE);
//                    }else if (i == 3 || i == 4 || i == 5 || i == 6){
//                        binding.specialist.setVisibility(View.VISIBLE);
//                        binding.period.setVisibility(View.GONE);
                    }else {
                        binding.specialistTextInputLayout.setVisibility(View.VISIBLE);
                        binding.periodLy.setVisibility(View.GONE);
                    }
                } else
                    stageStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.schoolType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    schoolTypeStr = binding.schoolType.getSelectedItem().toString();
                else
                    schoolTypeStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.periodRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.morning) {
                    periodSelectedStr = binding.morning.getText().toString();
                }
                if (i == R.id.evening) {
                    periodSelectedStr = binding.evening.getText().toString();
                }
            }
        });

        binding.ConsistentRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.Consistent_yes) {
                    ConsistentSelectedStr = binding.ConsistentYes.getText().toString();
                    binding.reasonForNonComplianceLayout.setVisibility(View.GONE);
                    binding.reasonForNonCompliance.setSelection(0);
                }
                if (i == R.id.Consistent_no) {
                    ConsistentSelectedStr = binding.ConsistentNo.getText().toString();
                    binding.reasonForNonComplianceLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        binding.reasonForNonCompliance.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    nonComplianceStr = binding.reasonForNonCompliance.getSelectedItem().toString();
                else
                    nonComplianceStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.reachSchool.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    reachSchoolStr = binding.reachSchool.getSelectedItem().toString();
                else
                    reachSchoolStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.readWriteRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.read_write_yes) {
                    readWriteSelectedStr = binding.readWriteYes.getText().toString();
                }
                if (i == R.id.read_write_no) {
                    readWriteSelectedStr = binding.readWriteNo.getText().toString();
                }
            }
        });

        binding.levelOfAcademicAchievement.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    levelOfAcademicAchievementStr = binding.levelOfAcademicAchievement.getSelectedItem().toString();
                else
                    levelOfAcademicAchievementStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        binding.educationalSpecialNeeds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                if (i > 0)
//                    educationalSpecialNeedsStr = binding.educationalSpecialNeeds.getSelectedItem().toString();
//                else
//                    educationalSpecialNeedsStr = "";
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//        binding.materialsNeedStrengthening.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                if (i > 0)
//                    materialsNeedStrengtheningStr = binding.materialsNeedStrengthening.getSelectedItem().toString();
//                else
//                    materialsNeedStrengtheningStr = "";
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });

        String[] educationalSpecialneedsArray = getResources().getStringArray(R.array.materials_need_strengthening);
        selectedeDucationalSpecialneeds = new boolean[educationalSpecialneedsArray.length];
        binding.educationalSpecialneedsTv.setOnClickListener(view1 -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    getActivity()
            );
            builder.setTitle("اختر");
            builder.setMultiChoiceItems(educationalSpecialneedsArray, selectedeDucationalSpecialneeds, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                    if (b){
                        educationalSpecialneedsList.add(i);
                        Collections.sort(educationalSpecialneedsList);
                    }else {
                        educationalSpecialneedsList.remove(i);
                    }
                }
            });
            builder.setPositiveButton("تم", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    StringBuilder stringBuilder = new StringBuilder();

                    for (int j = 0; j < educationalSpecialneedsList.size(); j++){
                        stringBuilder.append(educationalSpecialneedsArray[educationalSpecialneedsList.get(j)]);

                        if (j != educationalSpecialneedsList.size() - 1){
                            stringBuilder.append(", ");
                        }
                    }
                    binding.educationalSpecialneedsTv.setText(stringBuilder.toString());
                }
            });
            builder.setNegativeButton("مسح الكل", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    for (int j = 0; j < selectedeDucationalSpecialneeds.length; j++){
                        selectedeDucationalSpecialneeds[j] = false;
                        educationalSpecialneedsList.clear();
                        binding.educationalSpecialneedsTv.setText("اختر");
                    }
                }
            });
            builder.show();
        });

        String[] materialsNeedStrengtheningArray = getResources().getStringArray(R.array.materials_need_strengthening);
        selectedMaterialsNeedStrengthening = new boolean[materialsNeedStrengtheningArray.length];
        binding.educationalSpecialneedsTv.setOnClickListener(view1 -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(
                    getActivity()
            );
            builder.setTitle("اختر");
            builder.setMultiChoiceItems(materialsNeedStrengtheningArray, selectedMaterialsNeedStrengthening, new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                    if (b){
                        materialsNeedStrengtheningList.add(i);
                        Collections.sort(materialsNeedStrengtheningList);
                    }else {
                        materialsNeedStrengtheningList.remove(i);
                    }
                }
            });
            builder.setPositiveButton("تم", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    StringBuilder stringBuilder = new StringBuilder();

                    for (int j = 0; j < materialsNeedStrengtheningList.size(); j++){
                        stringBuilder.append(materialsNeedStrengtheningArray[materialsNeedStrengtheningList.get(j)]);

                        if (j != materialsNeedStrengtheningList.size() - 1){
                            stringBuilder.append(", ");
                        }
                    }
                    binding.materialsNeedStrengtheningTv.setText(stringBuilder.toString());
                }
            });
            builder.setNegativeButton("مسح الكل", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    for (int j = 0; j < selectedMaterialsNeedStrengthening.length; j++){
                        selectedMaterialsNeedStrengthening[j] = false;
                        materialsNeedStrengtheningList.clear();
                        binding.materialsNeedStrengtheningTv.setText("اختر");
                    }
                }
            });
            builder.show();
        });

        binding.nextEducationFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkYatimHousingCondition();
            }
        });

    }

//    private void initList() {
//        spinnerMaterialsNeedModelsArrayList = new ArrayList<>();
//        spinnerMaterialsNeedModelsArrayList.add(new SpinnerMaterialsNeedModels("India");
//        spinnerMaterialsNeedModelsArrayList.add(new SpinnerMaterialsNeedModels("China");
//        spinnerMaterialsNeedModelsArrayList.add(new SpinnerMaterialsNeedModels("USA");
//        spinnerMaterialsNeedModelsArrayList.add(new SpinnerMaterialsNeedModels("Germany");
//    }

    public void checkYatimHousingCondition() {

        String schoolUniversityNameStr = binding.schoolUniversityName.getText().toString();
        String educationAddressStr = binding.educationAddress.getText().toString();
        String gradeLevelStr = binding.gradeLevel.getText().toString();
        String specialistStr = binding.specialist.getText().toString();
        String educationalAvargeStr = binding.educationalAvarge.getText().toString();

        boolean hasError = false;

        if (readWriteSelectedStr.isEmpty()) {
            hasError = true;
            System.out.println("Log readWriteSelectedStr hasError");
        }else {
            addYatimModel.setReadWriteSelected(readWriteSelectedStr);
        }
        if (educationalStatusSelectedStr.isEmpty()) {
            hasError = true;
            System.out.println("Log educationalStatusSelectedStr hasError");
        }else {
            addYatimModel.setEducationalStatusSelected(educationalStatusSelectedStr);
        }
        if (educationalStatusSelectedStr.equals("غير ملتحق")) {
            if (reasonForNotJoiningStr.isEmpty()) {
                hasError = true;
                System.out.println("Log reasonForNotJoiningStr hasError");
            }else {
                addYatimModel.setReasonForNotJoining(reasonForNotJoiningStr);
            }
        } else if (educationalStatusSelectedStr.equals("ملتحق")) {
            if (stageStr.isEmpty()) {
                hasError = true;
                System.out.println("Log stageStr hasError");
            }else {
                addYatimModel.setStage(stageStr);
            }
            if (stageStr.equals("روضة") || stageStr.equals("مدرسة")){
                if (periodSelectedStr.isEmpty()) {
                    hasError = true;
                    System.out.println("Log periodSelectedStr hasError");
                }else {
                    addYatimModel.setPeriodSelected(periodSelectedStr);
                }
            }
            if (schoolTypeStr.isEmpty()) {
                hasError = true;
                System.out.println("Log schoolTypeStr hasError");
            }else {
                addYatimModel.setSchoolType(schoolTypeStr);
            }
            if (schoolUniversityNameStr.isEmpty()) {
                hasError = true;
                System.out.println("Log schoolUniversityNameStr hasError");
            }else {
                addYatimModel.setSchoolUniversityName(schoolUniversityNameStr);
            }
            if (educationAddressStr.isEmpty()) {
                hasError = true;
                System.out.println("Log educationAddressStr hasError");
            }else {
                addYatimModel.setEducationAddress(educationAddressStr);
            }
            if (gradeLevelStr.isEmpty()) {
                hasError = true;
                System.out.println("Log gradeLevelStr hasError");
            }else {
                addYatimModel.setGradeLevel(gradeLevelStr);
            }
            if (specialistStr.isEmpty()) {
                hasError = true;
                System.out.println("Log specialistStr hasError");
            }else {
                addYatimModel.setSpecialist(specialistStr);
            }
            if (educationalAvargeStr.isEmpty()) {
                hasError = true;
                System.out.println("Log educationalAvargeStr hasError");
            }else {
                addYatimModel.setEducationalAvarge(educationalAvargeStr);
            }
            if (ConsistentSelectedStr.equals("لا")) {
                if (nonComplianceStr.isEmpty()) {
                    hasError = true;
                    System.out.println("Log ConsistentSelectedStr hasError");
                }else {
                    addYatimModel.setNonCompliance(nonComplianceStr);
                }
            }
            if (ConsistentSelectedStr.isEmpty()) {
                hasError = true;
                System.out.println("Log ConsistentSelectedStr hasError");
            }else {
                addYatimModel.setConsistentSelected(ConsistentSelectedStr);
            }
            if (reachSchoolStr.isEmpty()) {
                hasError = true;
                System.out.println("Log reachSchoolStr hasError");
            }else {
                addYatimModel.setReachSchool(reachSchoolStr);
            }
            if (levelOfAcademicAchievementStr.isEmpty()) {
                hasError = true;
                System.out.println("Log levelOfAcademicAchievementStr hasError");
            }else {

            }
            if (educationalSpecialNeedsStr.isEmpty()) {
                hasError = true;
                System.out.println("Log educationalSpecialNeedsStr hasError");
            }else {
                addYatimModel.setEducationalSpecialNeeds(educationalSpecialNeedsStr);
            }
            if (materialsNeedStrengtheningStr.isEmpty()) {
                hasError = true;
                System.out.println("Log materialsNeedStrengtheningStr hasError");
            }else {

            }
        }

        if (hasError) {
            Toast.makeText(getActivity(), getString(R.string.please_fill_data), Toast.LENGTH_SHORT).show();
            return;
        }

        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.KEY_NEW_YATIM_DATA_MODEL, addYatimModel);
//        Toast.makeText(getActivity(), "" + addYatimModel.getYatimName(), Toast.LENGTH_SHORT).show();
        NavHostFragment.findNavController(YatimEducationalStatusFragment.this)
                .navigate(R.id.action_YatimEducationalStatusFragment_to_YatimDesiresInclinationsFragment, bundle);

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}