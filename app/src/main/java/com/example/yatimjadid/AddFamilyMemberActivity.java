package com.example.yatimjadid;

import static com.example.yatimjadid.Constants.KEY_UPDATE_DATA;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yatimjadid.Models.FamilyMembersModel;
import com.example.yatimjadid.databinding.ActivityAddFamilyMemberBinding;

import java.util.Calendar;

public class AddFamilyMemberActivity extends BaseActivity {

    private ActivityAddFamilyMemberBinding binding;

    String memberGenderStr = "";
    String memberFamilySituationStr = "";
    FamilyMembersModel familyMembersModel;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    String age;
    int memberFamilySituationPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddFamilyMemberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.toolbar.setTitle("أفراد الأسرة");

        Bundle bundle = getIntent().getExtras();
        familyMembersModel = new FamilyMembersModel();

        initListeners();

        if (bundle != null && bundle.containsKey(KEY_UPDATE_DATA)) {
            familyMembersModel = (FamilyMembersModel) bundle.getSerializable(KEY_UPDATE_DATA);
            binding.memberNameEd.setText(familyMembersModel.getMemberName());
            binding.memberDateOfBirth.setText(familyMembersModel.getMemberDateOfBirth());
            binding.memberRelationshipWithYatim.setText(familyMembersModel.getMemberRelationshipWithYatim());

//            ( binding.memberGenderRadioGroup
//                    .getChildAt(Integer.parseInt(familyMembersModel
//                            .getRadioGroupId()))).setChecked(true);

            if (familyMembersModel.getMemberGender().equals(getString(R.string.female))) {
                binding.memberFemale.performClick();
            } else {
                binding.memberMale.performClick();
            }

            binding.memberClassroom.setText(familyMembersModel.getMemberClassroom());
            binding.memberSpecialization.setText(familyMembersModel.getMemberSpecialization());
            binding.memberGraduationYear.setText(familyMembersModel.getMemberGraduationYear());
            binding.memberAverage.setText(familyMembersModel.getMemberAverage());
            binding.memberFamilySituation.setSelection(familyMembersModel.getMemberFamilySituationPositionModel());
            binding.memberHealthStatus.setText(familyMembersModel.getMemberHealthStatus());
            binding.memberGuaranteedByIslamicRelief.setText(familyMembersModel.getMemberGuaranteed());

        }
//        binding.memberClassroom.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                // here any change in text process here
//
//            }
//        });
    }

    private void initListeners() {

        binding.memberFamilySituation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0) {
                    memberFamilySituationStr = binding.memberFamilySituation.getSelectedItem().toString();
                    memberFamilySituationPosition = i;

                } else
                    memberFamilySituationStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        binding.memberMale.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                memberGenderStr = binding.memberMale.getText().toString();
//            }
//        });
//
//        binding.memberFemale.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                memberGenderStr = binding.memberFemale.getText().toString();
//            }
//        });

        binding.memberGenderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.member_male) {
                    memberGenderStr = binding.memberMale.getText().toString();

                } else if (i == R.id.member_female) {
                    memberGenderStr = binding.memberFemale.getText().toString();
                }
            }
        });

        binding.memberDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month + 1;
                        Log.d("TAG", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

//                        String date = month + "/" + day + "/" + year;
                        String date = year + "/" + month + "/" + day;
                        binding.memberDateOfBirth.setText(date);

                    }
                };
                getDateOfBirth();
            }
        });

        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkYatimParentsData();
            }
        });
    }

    public void checkYatimParentsData() {

        String memberNameStr = binding.memberNameEd.getText().toString();
        String memberDateOfBirthStr = binding.memberDateOfBirth.getText().toString();
        String memberRelationshipWithYatimStr = binding.memberRelationshipWithYatim.getText().toString();
        String memberClassroomStr = binding.memberClassroom.getText().toString();
        String memberSpecializationStr = binding.memberSpecialization.getText().toString();
        String memberGraduationYearStr = binding.memberGraduationYear.getText().toString();
        String memberAverageStr = binding.memberAverage.getText().toString();
        String memberHealthStatusStr = binding.memberHealthStatus.getText().toString();
        String memberGuaranteedStr = binding.memberGuaranteedByIslamicRelief.getText().toString();

        boolean hasError = false;

        if (memberNameStr.isEmpty()) {
            System.out.println("Log memberNameStr hasError");
            hasError = true;
        }
        if (memberDateOfBirthStr.isEmpty()) {
            System.out.println("Log memberDateOfBirthStr hasError");
            hasError = true;
        }
        if (memberRelationshipWithYatimStr.isEmpty()) {
            System.out.println("Log memberRelationshipWithYatimStr hasError");
            hasError = true;
        }
        if (memberGenderStr.isEmpty()) {
            System.out.println("Log memberGenderStr " + memberGenderStr);
            System.out.println("Log memberGenderStr hasError");
            hasError = true;
        }
        if (memberClassroomStr.isEmpty()) {
            System.out.println("Log memberClassroomStr hasError");
            hasError = true;
        }
        if (memberSpecializationStr.isEmpty()) {
            System.out.println("Log memberSpecializationStr hasError");
            hasError = true;
        }
        if (memberGraduationYearStr.isEmpty()) {
            System.out.println("Log memberGraduationYearStr hasError");
            hasError = true;
        }
        if (memberAverageStr.isEmpty()) {
            System.out.println("Log memberAverageStr hasError");
            hasError = true;
        }
        if (memberFamilySituationStr.isEmpty()) {
            hasError = true;
        }
        if (memberHealthStatusStr.isEmpty()) {
            System.out.println("Log memberHealthStatusStr hasError");
            hasError = true;
        }
        if (memberGuaranteedStr.isEmpty()) {
            System.out.println("Log memberGuaranteedStr hasError");
            hasError = true;
        }

        if (hasError) {
            Toast.makeText(this, getString(R.string.please_fill_data), Toast.LENGTH_SHORT).show();
            return;
        }

        String[] dateArr = memberDateOfBirthStr.split("/");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);
        age = setAge(year, month, day);

        if (familyMembersModel == null)
            familyMembersModel = new FamilyMembersModel();

        familyMembersModel.setMemberName(memberNameStr);
        familyMembersModel.setMemberDateOfBirth(memberDateOfBirthStr);
        familyMembersModel.setMemberRelationshipWithYatim(memberRelationshipWithYatimStr);
        familyMembersModel.setMemberGender(memberGenderStr);
        familyMembersModel.setMemberClassroom(memberClassroomStr);
        familyMembersModel.setMemberSpecialization(memberSpecializationStr);
        familyMembersModel.setMemberGraduationYear(memberGraduationYearStr);
        familyMembersModel.setMemberAverage(memberAverageStr);
        familyMembersModel.setMemberFamilySituation(memberFamilySituationStr);
        familyMembersModel.setMemberFamilySituationPositionModel(memberFamilySituationPosition);
        familyMembersModel.setMemberHealthStatus(memberHealthStatusStr);
        familyMembersModel.setMemberGuaranteed(memberGuaranteedStr);
        familyMembersModel.setAge(age);

//        Bundle bundle = new Bundle();
//        bundle.putSerializable(Constants.KEY_FAMILY_MEMBER_MODEL, familyMembersModel);

//        NavHostFragment.findNavController(FamilyMemberDataFragment.this)
//                .navigate(R.id.action_FamilyMemberDataFragment_to_FamilyMembersFragment, bundle);

        // here add set resutl
        Intent intent = new Intent();
        intent.putExtra(Constants.KEY_FAMILY_MEMBERS, familyMembersModel);
        setResult(RESULT_OK, intent);
        finish();

    }

    public void getDateOfBirth() {

        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                mDateSetListener,
                year, month, day);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

    }

    private String setAge(int year, int month, int day) {
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }

//        Integer ageInt = new Integer(age);
//        String ageS = ageInt.toString();

        return String.valueOf(age);
    }

}