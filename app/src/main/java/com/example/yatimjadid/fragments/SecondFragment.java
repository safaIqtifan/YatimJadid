package com.example.yatimjadid.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.yatimjadid.Models.AllResolutionModels;
import com.example.yatimjadid.R;
import com.example.yatimjadid.StartYatimCriteriaActivity;
import com.example.yatimjadid.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    String roomsNumberStr;
    String memberNumberStr;
    String peopleForRoomsStr = "";
    String housingTypeSpinnerStr = "";
    String propertySpinnerStr = "";
    String roofTypeStr = "";
    String wallTypeStr = "";
    String floorTypeStr = "";
    String windowsCaseStr = "";
    String doorsCaseStr = "";
    String kitchenConditionStr = "";
    String bathroomConditionStr = "";
    String housingConditionInGeneralStr = "";
    String improvementNeedsStr = "";
    String furnitureNeedsStr = "";
    String hardwareNeedsStr = "";
    String housingLocationStr = "";
    String lightingSelectedStr = "";
    String ventilationSelectedStr = "";
    String electricitySelectedStr = "";
    String waterNetworkSelectedStr = "";
    String alternativeElectricitySelectedStr = "";
    String sewageSelectedStr = "";

    AllResolutionModels allResolutionModels;

    StartYatimCriteriaActivity ownerActivity;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ownerActivity = (StartYatimCriteriaActivity) requireActivity();
        this.allResolutionModels = ownerActivity.allResolutionModels;

//        Bundle bundle = getArguments();
//        allResolutionModels = (AllResolutionModels) bundle.getSerializable(Constants.KEY_YATIM_MODEL);

        binding.roomsNumberEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                roomsNumberStr = binding.roomsNumberEd.getText().toString();
                memberNumberStr = binding.memberNumberEd.getText().toString();

                if (!roomsNumberStr.isEmpty() && !memberNumberStr.isEmpty()) {
                    double roomsNum = Double.parseDouble(binding.roomsNumberEd.getText().toString());
                    double memberNum = Double.parseDouble(binding.memberNumberEd.getText().toString());

                    if (roomsNum > 0 && memberNum > 0) {
                        int i = (int) Math.ceil(memberNum / roomsNum);
                        peopleForRoomsStr = String.valueOf(i);
                        binding.peopleForRooms.setText(peopleForRoomsStr);
                    }
                }
            }
        });

        binding.memberNumberEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                roomsNumberStr = binding.roomsNumberEd.getText().toString();
                memberNumberStr = binding.memberNumberEd.getText().toString();

                if (!roomsNumberStr.isEmpty() && !memberNumberStr.isEmpty()) {
                    double roomsNum = Double.parseDouble(binding.roomsNumberEd.getText().toString());
                    double memberNum = Double.parseDouble(binding.memberNumberEd.getText().toString());

                    if (roomsNum > 0 && memberNum > 0) {
                        int i = (int) Math.ceil(memberNum / roomsNum);
                        peopleForRoomsStr = String.valueOf(i);
                        binding.peopleForRooms.setText(peopleForRoomsStr);
                    }
                }
            }
        });

        binding.housingTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    housingTypeSpinnerStr = binding.housingTypeSpinner.getSelectedItem().toString();
                else
                    housingTypeSpinnerStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.floorType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    floorTypeStr = binding.floorType.getSelectedItem().toString();
                else
                    floorTypeStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.propertySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    propertySpinnerStr = binding.propertySpinner.getSelectedItem().toString();
                else
                    propertySpinnerStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.roofTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    roofTypeStr = binding.roofTypeSpinner.getSelectedItem().toString();
                else
                    roofTypeStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.wallType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    wallTypeStr = binding.wallType.getSelectedItem().toString();
                else
                    wallTypeStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.windowsCase.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    windowsCaseStr = binding.windowsCase.getSelectedItem().toString();
                else
                    windowsCaseStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.doorsCase.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    doorsCaseStr = binding.doorsCase.getSelectedItem().toString();
                else
                    doorsCaseStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.kitchenCondition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    kitchenConditionStr = binding.kitchenCondition.getSelectedItem().toString();
                else
                    kitchenConditionStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.bathroomCondition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    bathroomConditionStr = binding.bathroomCondition.getSelectedItem().toString();
                else
                    bathroomConditionStr = "";

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.housingConditionInGeneral.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    housingConditionInGeneralStr = binding.housingConditionInGeneral.getSelectedItem().toString();
                else
                    housingConditionInGeneralStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.improvementNeeds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    improvementNeedsStr = binding.improvementNeeds.getSelectedItem().toString();
                else
                    improvementNeedsStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.furnitureNeeds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    furnitureNeedsStr = binding.furnitureNeeds.getSelectedItem().toString();
                else
                    furnitureNeedsStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.hardwareNeeds.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    hardwareNeedsStr = binding.hardwareNeeds.getSelectedItem().toString();
                else
                    hardwareNeedsStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.housingLocationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i > 0)
                    housingLocationStr = binding.housingLocationSpinner.getSelectedItem().toString();
                else
                    housingLocationStr = "";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.lightingRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.lighting_good) {
                    lightingSelectedStr = binding.lightingGood.getText().toString();
                }
                if (i == R.id.lighting_medium) {
                    lightingSelectedStr = binding.lightingMedium.getText().toString();
                }
                if (i == R.id.lighting_bad) {
                    lightingSelectedStr = binding.lightingBad.getText().toString();
                }
            }
        });

        binding.ventilationRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.ventilation_good) {
                    ventilationSelectedStr = binding.ventilationGood.getText().toString();
                }
                if (i == R.id.ventilation_medium) {
                    ventilationSelectedStr = binding.ventilationMedium.getText().toString();
                }
                if (i == R.id.ventilation_bad) {
                    ventilationSelectedStr = binding.ventilationBad.getText().toString();
                }
            }
        });

        binding.electricityRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.electricity_good) {
                    electricitySelectedStr = binding.electricityGood.getText().toString();
                }
                if (i == R.id.electricity_need_repair) {
                    electricitySelectedStr = binding.electricityNeedRepair.getText().toString();
                }
            }
        });

        binding.waterNetworkRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.water_network_good) {
                    waterNetworkSelectedStr = binding.waterNetworkGood.getText().toString();
                }
                if (i == R.id.water_network_need_repair) {
                    waterNetworkSelectedStr = binding.waterNetworkNeedRepair.getText().toString();
                }
            }
        });

        binding.alternativeElectricityRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.alternative_electricity_exist) {
                    alternativeElectricitySelectedStr = binding.alternativeElectricityExist.getText().toString();
                }
                if (i == R.id.alternative_electricity_not_exist) {
                    alternativeElectricitySelectedStr = binding.alternativeElectricityNotExist.getText().toString();
                }
            }
        });

        binding.sewageRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (i == R.id.sewage_good) {
                    sewageSelectedStr = binding.sewageGood.getText().toString();
                }
                if (i == R.id.sewage_need_repair) {
                    sewageSelectedStr = binding.sewageNeedRepair.getText().toString();
                }
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
        this.allResolutionModels = ownerActivity.allResolutionModels;
    }

    @Override
    public void onPause() {
        super.onPause();
        ownerActivity.allResolutionModels = allResolutionModels;
    }

    public void checkYatimHousingCondition() {

        boolean hasError = false;

        String spaceStr = binding.spaceEd.getText().toString();
//        String peopleForRoomsStr = binding.peopleForRoomsEd.getText().toString();
//        String houseLocationStr = binding.houseLocationEd.getText().toString();

        if (housingTypeSpinnerStr.isEmpty()) {
            hasError = true;
            System.out.println("Log housingTypeSpinnerStr hasError");
        } else {
            allResolutionModels.setHousingTypeSpinner(housingTypeSpinnerStr);
        }

        if (binding.roomsNumberEd.getText().toString().isEmpty()) {
            hasError = true;
            System.out.println("Log roomsNumberStr hasError");
        } else {
            allResolutionModels.setRoomsNumber(String.valueOf(roomsNumberStr));
        }

        if (spaceStr.isEmpty()) {
            hasError = true;
            System.out.println("Log spaceStr hasError");
        } else {
            allResolutionModels.setSpace(spaceStr);
        }

        if (propertySpinnerStr.isEmpty()) {
            hasError = true;
            System.out.println("Log propertySpinnerStr hasError");
        } else {
            allResolutionModels.setPropertySpinner(propertySpinnerStr);
        }

        if (roofTypeStr.isEmpty()) {
            hasError = true;
            System.out.println("Log roofTypeStr hasError");
        } else {
            allResolutionModels.setRoofType(roofTypeStr);
        }

        if (wallTypeStr.isEmpty()) {
            hasError = true;
            System.out.println("Log wallTypeStr hasError");
        } else {
            allResolutionModels.setWallType(wallTypeStr);
        }

        if (floorTypeStr.isEmpty()) {
            hasError = true;
            System.out.println("Log floorTypeStr hasError");
        } else {
            allResolutionModels.setFloorType(floorTypeStr);
        }

        if (windowsCaseStr.isEmpty()) {
            hasError = true;
            System.out.println("Log windowsCaseStr hasError");
        } else {
            allResolutionModels.setWindowsCase(windowsCaseStr);
        }

        if (doorsCaseStr.isEmpty()) {
            hasError = true;
            System.out.println("Log doorsCaseStr hasError");
        } else {
            allResolutionModels.setDoorsCase(doorsCaseStr);
        }

        if (kitchenConditionStr.isEmpty()) {
            hasError = true;
            System.out.println("Log kitchenConditionStr hasError");
        } else {
            allResolutionModels.setKitchenCondition(kitchenConditionStr);
        }

        if (bathroomConditionStr.isEmpty()) {
            hasError = true;
            System.out.println("Log bathroomConditionStr hasError");
        } else {
            allResolutionModels.setBathroomCondition(bathroomConditionStr);
        }

        if (housingConditionInGeneralStr.isEmpty()) {
            hasError = true;
            System.out.println("Log housingConditionInGeneralStr hasError");
        } else {
            allResolutionModels.setHousingConditionInGeneral(housingConditionInGeneralStr);
        }

        if (improvementNeedsStr.isEmpty()) {
            hasError = true;
            System.out.println("Log improvementNeedsStr hasError");
        } else {
            allResolutionModels.setImprovementNeeds(improvementNeedsStr);
        }

        if (furnitureNeedsStr.isEmpty()) {
            hasError = true;
            System.out.println("Log furnitureNeedsStr hasError");
        } else {
            allResolutionModels.setFurnitureNeeds(furnitureNeedsStr);
        }

        if (hardwareNeedsStr.isEmpty()) {
            hasError = true;
            System.out.println("Log hardwareNeedsStr hasError");
        } else {
            allResolutionModels.setHardwareNeeds(hardwareNeedsStr);
        }

        if (lightingSelectedStr.isEmpty()) {
            hasError = true;
            System.out.println("Log lightingSelectedStr hasError");
        } else {
            allResolutionModels.setLightingSelected(lightingSelectedStr);
        }

        if (String.valueOf(memberNumberStr).isEmpty()) {
            hasError = true;
            System.out.println("Log peopleForRoomsStr hasError");
        } else {
            allResolutionModels.setMemberNumber(String.valueOf(memberNumberStr));
        }

        if (housingLocationStr.isEmpty()) {
            hasError = true;
            System.out.println("Log houseLocationStr hasError");
        } else {
            allResolutionModels.setHouseLocation(housingLocationStr);
        }

        if (String.valueOf(roomsNumberStr).isEmpty()) {
            hasError = true;
            System.out.println("Log memberNumberStr hasError");
        } else {
            allResolutionModels.setRoomsNumber(roomsNumberStr);
        }

        if (ventilationSelectedStr.isEmpty()) {
            hasError = true;
            System.out.println("Log ventilationSelectedStr hasError");
        } else {
            allResolutionModels.setVentilationSelected(ventilationSelectedStr);
        }

        if (electricitySelectedStr.isEmpty()) {
            hasError = true;
            System.out.println("Log electricitySelectedStr hasError");
        } else {
            allResolutionModels.setElectricitySelected(electricitySelectedStr);
        }

        if (waterNetworkSelectedStr.isEmpty()) {
            hasError = true;
            System.out.println("Log waterNetworkSelectedStr hasError");
        } else {
            allResolutionModels.setWaterNetworkSelected(waterNetworkSelectedStr);
        }

        if (alternativeElectricitySelectedStr.isEmpty()) {
            hasError = true;
            System.out.println("Log alternativeElectricitySelectedStr hasError");
        } else {
            allResolutionModels.setAlternativeElectricitySelected(alternativeElectricitySelectedStr);
        }

        if (sewageSelectedStr.isEmpty()) {
            hasError = true;
            System.out.println("Log sewageSelectedStr hasError");
        } else {
            allResolutionModels.setSewageSelected(sewageSelectedStr);
        }

        if (hasError) {
            Toast.makeText(getActivity(), getString(R.string.please_fill_data), Toast.LENGTH_SHORT).show();
            return;
        }
        allResolutionModels.setPeopleForRooms(peopleForRoomsStr);
//        allResolutionModels.setPeopleForRooms(peopleForRoomsStr);

//        Bundle bundle = new Bundle();
//        bundle.putSerializable(Constants.KEY_YATIM_MODEL, allResolutionModels);

//        NavHostFragment.findNavController(SecondFragment.this)
//                .navigate(R.id.action_SecondFragment_to_WaterHygieneFragment, bundle);

//        ((StartYatimCriteriaActivity) requireActivity()).nextFragment();

        ownerActivity.nextFragment();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}