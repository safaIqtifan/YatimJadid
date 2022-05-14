package com.example.yatimjadid.addYatim;

import android.Manifest;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;

import com.example.yatimjadid.Constants;
import com.example.yatimjadid.Models.AddYatimModel;
import com.example.yatimjadid.R;
import com.example.yatimjadid.databinding.FragmentBasicInformationBinding;
import com.example.yatimjadid.databinding.LayoutEdittextBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class BasicInformationFragment extends Fragment {

    private FragmentBasicInformationBinding binding;

    Uri yatimPhotoUri;
    String yatimGenderSelectedStr = "";
    String governorateStr = "";
    AddYatimModel addYatimModel;
    String age;
    String ageAtDeath;
    //    ArrayAdapter<String> ArrayAdapter;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    StorageReference storageRef;

    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentBasicInformationBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        storageRef = FirebaseStorage.getInstance().getReference();
        addYatimModel = new AddYatimModel();

        initListeners();

        getCity();

    }

    private void initListeners() {

        binding.yatimImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

                    if (getActivity().checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_DENIED) {
                        String[] permission = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permission, PERMISSION_CODE);

                    } else {
                        pickImageFromGallery();
                    }
                } else {
                    pickImageFromGallery();
                }
            }
        });

        binding.yatimDateOfBirthEd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month = month + 1;
                        Log.d("TAG", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                        String date = year + "/" + month + "/" + day;
                        binding.yatimDateOfBirthEd.setText(date);
                    }
                };
                getDateOfBirth();
            }
        });

        binding.fatherDeathDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                        Log.d("TAG", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                        String date = year + "/" + (month + 1) + "/" + day;
                        binding.fatherDeathDate.setText(date);
                        if (!binding.fatherBirthDate.getText().toString().isEmpty()) {
                            binding.fatherDeathAge.setVisibility(View.VISIBLE);
                            binding.fatherDeathAge.setText(setAgeAtDeath());
                        }
                    }
                };
                getDateOfBirth();
            }
        });

        binding.fatherBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//                        Log.d("TAG", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                        String date = year + "/" + (month + 1) + "/" + day;
                        binding.fatherBirthDate.setText(date);
                        if (!binding.fatherDeathDate.getText().toString().isEmpty()) {
                            binding.fatherDeathAge.setVisibility(View.VISIBLE);
                            binding.fatherDeathAge.setText(setAgeAtDeath());
                        }
                    }
                };
                getDateOfBirth();
            }
        });

        binding.yatimGenderRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.yatim_male) {
                    yatimGenderSelectedStr = binding.yatimMale.getText().toString();
                }
                if (i == R.id.yatim_female) {
                    yatimGenderSelectedStr = binding.yatimFemale.getText().toString();
                }
            }
        });

        binding.addMobileNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutEdittextBinding newMobileET = LayoutEdittextBinding.inflate(getLayoutInflater());
                binding.dataLY.addView(newMobileET.getRoot());
            }
        });

        binding.nextBasicInfoFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkYatimHousingCondition();
            }
        });

        binding.citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0) {
                    int areaListId = 0;
                    switch (i) {
                        case 1:
                            areaListId = R.array.north_list;
                            break;
                        case 2:
                            areaListId = R.array.gaza_list;
                            break;
                        case 3:
                            areaListId = R.array.central_list;
                            break;
                        case 4:
                            areaListId = R.array.khanyounes_list;
                            break;
                        case 5:
                            areaListId = R.array.rafah_list;
                            break;
                    }
                    String[] areaList = requireActivity().getResources().getStringArray(areaListId);
                    if (areaList.length > 0) {
                        getArea(areaList);
                        binding.areaSpinnerLY.setVisibility(View.VISIBLE);
                    } else {
                        Toast.makeText(requireActivity(), getString(R.string.no_area_for_this_city), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    binding.areaSpinnerLY.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void checkYatimHousingCondition() {

        String yatimNameStr = binding.yatimNameEd.getText().toString();
        String yatimDateOfBirthStr = binding.yatimDateOfBirthEd.getText().toString();
        String fatherDeathDateStr = binding.fatherDeathDate.getText().toString();
        String fatherBirthDateStr = binding.fatherBirthDate.getText().toString();
        String causeOfDeathStr = binding.causeOfDeath.getText().toString();
        String ageAtDeathStr = binding.fatherDeathAge.getText().toString();
        String fatherJobStr = binding.fatherJob.getText().toString();
        String previousIncomeStr = binding.previousIncome.getText().toString();
        String inheritanceOrPensionStr = binding.inheritanceOrPension.getText().toString();
//        String conservationStr = binding.conservation.getText().toString();
//        String addressDetailsStr = binding.addressDetails.getText().toString();
        String mobileNumberStr = binding.mobileNumber1.getText().toString();

        boolean hasError = false;

        if (yatimPhotoUri == null) {
            hasError = true;
        }
        if (yatimNameStr.isEmpty()) {
            hasError = true;
        }
        if (yatimDateOfBirthStr.isEmpty()) {
            hasError = true;
        }
        if (yatimGenderSelectedStr.isEmpty()) {
            hasError = true;
        }
        if (fatherDeathDateStr.isEmpty() && fatherBirthDateStr.isEmpty()) {
            hasError = true;
        }
        if (causeOfDeathStr.isEmpty()) {
            hasError = true;
        }
        if (ageAtDeathStr.isEmpty()) {
            hasError = true;
        }
        if (fatherJobStr.isEmpty()) {
            hasError = true;
        }
        if (previousIncomeStr.isEmpty()) {
            hasError = true;
        }
        if (inheritanceOrPensionStr.isEmpty()) {
            hasError = true;
        }
//        if (conservationStr.isEmpty()) {
//            hasError = true;
//        }
//        if (addressDetailsStr.isEmpty()) {
//            hasError = true;
//        }
        if (mobileNumberStr.isEmpty()) {
            hasError = true;
        }

        if (hasError) {
            Toast.makeText(getActivity(), getString(R.string.please_fill_data), Toast.LENGTH_SHORT).show();
            return;
        }

        String[] dateArr = yatimDateOfBirthStr.split("/");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);
        age = setAge(year, month, day);

        addYatimModel.setYatimPhotoUri(String.valueOf(yatimPhotoUri));
        addYatimModel.setYatimName(yatimNameStr);
        addYatimModel.setYatimDateOfBirth(yatimDateOfBirthStr);
        addYatimModel.setYatimGenderSelected(yatimGenderSelectedStr);
        addYatimModel.setFatherDeathDate(fatherDeathDateStr);
        addYatimModel.setCauseOfDeath(causeOfDeathStr);
        addYatimModel.setAgeAtDeath(ageAtDeathStr);
        addYatimModel.setFatherJob(fatherJobStr);
        addYatimModel.setPreviousIncome(previousIncomeStr);
        addYatimModel.setInheritanceOrPension(inheritanceOrPensionStr);
//        addYatimModel.setConservation(conservationStr);
//        addYatimModel.setAddressDetails(addressDetailsStr);
        addYatimModel.setMobileNumber(mobileNumberStr);
        addYatimModel.setYatimeAge(age);

        uploadPhoto(yatimPhotoUri);

        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.KEY_NEW_YATIM_DATA_MODEL, addYatimModel);
//        Toast.makeText(getActivity(), "igh" + addYatimModel.getYatimName(), Toast.LENGTH_SHORT).show();
//        System.out.println("Log BasicInformation getYatimName " + addYatimModel.getYatimName());
        NavHostFragment.findNavController(BasicInformationFragment.this)
                .navigate(R.id.action_BasicInformationFragment_to_YatimHealthConditionFragment, bundle);
    }

    private void pickImageFromGallery() {

        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    pickImageFromGallery();
                } else {
                    Toast.makeText(getActivity(), "Permission denied...!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && requestCode == IMAGE_PICK_CODE) {

            yatimPhotoUri = data.getData();
            binding.yatimImg.setImageURI(yatimPhotoUri);
        }
    }

    private void uploadPhoto(Uri photoUri) {

        StorageReference imgRef = storageRef.child(Constants.YATIM_IMAGES + "/"
                + UUID.randomUUID().toString());

        UploadTask uploadTask = imgRef.putFile(photoUri);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
//                Log.e("aa", exception + "");
//                Toast.makeText(getActivity(), "ddddd", Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(taskSnapshot -> {

            imgRef.getDownloadUrl().addOnCompleteListener(task -> {

                addYatimModel.setYatimPhotoUri(task.getResult().toString());
            });
        });
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

    private String setAgeAtDeath() {

        String[] birthDateArr = binding.fatherBirthDate
                .getText().toString().split("/");
        int birthYear = Integer.parseInt(birthDateArr[0]);
//        int birthMonth = Integer.parseInt(birthDateArr[1]);
//        int birthDay = Integer.parseInt(birthDateArr[2]);


        String[] deathDateArr = binding.fatherDeathDate
                .getText().toString().split("/");
        int deathYear = Integer.parseInt(deathDateArr[0]);
//        int deathMonth = Integer.parseInt(deathDateArr[1]);
//        int deathDay = Integer.parseInt(deathDateArr[2]);

//        Calendar deathCalender = Calendar.getInstance();
//        Calendar dob = Calendar.getInstance();

//        dob.set(birthYear, birthMonth, birthDay);
//        deathCalender.set(deathYear, deathMonth, deathDay);

        int age = deathYear - birthYear;
//        int age = deathCalender.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
//        if (deathCalender.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
//            age--;
//        }
        return String.valueOf(age);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void getCity() {

        String[] cityList = requireActivity().getResources().getStringArray(R.array.city_list);

        ArrayAdapter areaAdapter = new ArrayAdapter(requireActivity(), R.layout.spinner_item, R.id.itemText, cityList);
//        bodyBuildAdapter.setDropD/ownViewResource(R.layout.row_popup_spinner_item);
        binding.citySpinner.setAdapter(areaAdapter);

    }

    public void getArea(String[] areaList) {

        ArrayAdapter areaAdapter = new ArrayAdapter(requireActivity(), R.layout.spinner_item, R.id.itemText, areaList);
//        bodyBuildAdapter.setDropDownViewResource(R.layout.row_popup_spinner_item);
        binding.areaSpinner.setAdapter(areaAdapter);

    }

}