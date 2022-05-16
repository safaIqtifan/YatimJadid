package com.example.yatimjadid;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.yatimjadid.Adapter.YatimDataAdapter;
import com.example.yatimjadid.Models.AddYatimModel;
import com.example.yatimjadid.Models.AllResolutionModels;
import com.example.yatimjadid.databinding.FragmentNewYatimsBinding;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class NewYatimsFragment extends Fragment {

    private FragmentNewYatimsBinding binding;

    AllResolutionModels allResolutionModels;
    //    AddYatimModel yatimModel;
    ArrayList<AddYatimModel> addYatimArrayList;
    YatimDataAdapter adapter;
    private ProgressDialog lodingBar;
    private DatabaseReference yatimRef;
    int completeAddCount = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentNewYatimsBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addYatimArrayList = UtiltApp.getYatemData(requireActivity());
        binding.rvYatim.setLayoutManager(new LinearLayoutManager(getActivity()));
        lodingBar = new ProgressDialog(getActivity());
        yatimRef = FirebaseDatabase.getInstance().getReference().child("Yatim");

        adapter = new YatimDataAdapter(getActivity(), addYatimArrayList, new DataCallBack() {
            @Override
            public void Result(Object obj, String type, Object otherData) {
                if (type.equals("delete")) {
                    showHideToolbarAddButton();
//                    Toast.makeText(getActivity(), addYatimModel.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.rvYatim.setAdapter(adapter);

        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey(Constants.KEY_NEW_YATIM_DATA_MODEL)) {
            AddYatimModel yatimModel = (AddYatimModel) bundle.getSerializable(Constants.KEY_NEW_YATIM_DATA_MODEL);
            addYatimArrayList.add(yatimModel);
            adapter.notifyDataSetChanged();
            showHideToolbarAddButton();

            Toast.makeText(getActivity(), yatimModel.getYatimName(), Toast.LENGTH_SHORT).show();
            bundle.clear();
            UtiltApp.setYatimData(requireActivity(), addYatimArrayList);
        }

        if (bundle != null && bundle.containsKey(Constants.KEY_YATIM_MODEL)) {
            allResolutionModels = (AllResolutionModels) bundle.getSerializable(Constants.KEY_YATIM_MODEL);
            Toast.makeText(getActivity(), "toast 1" + allResolutionModels.getParentsName(), Toast.LENGTH_SHORT).show();
        }

        binding.addYatimTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(NewYatimsFragment.this)
                        .navigate(R.id.action_AddYatimsFragment_to_BasicInformationFragment);
            }
        });

        binding.nextBasicInfoFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(NewYatimsFragment.this)
                        .navigate(R.id.action_AddYatimsFragment_to_BasicInformationFragment);
            }
        });

        binding.endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (addYatimArrayList.isEmpty()) {
                    Toast.makeText(requireActivity(), getString(R.string.please_at_least_yatim), Toast.LENGTH_SHORT).show();
                    return;
                }

                lodingBar.setTitle("حفظ البيانات");
                lodingBar.setMessage("الرجاء الانتظار حتي يتم حفظ البيانات");
                lodingBar.setCanceledOnTouchOutside(false);
                lodingBar.show();

                completeAddCount = 0;
                for (AddYatimModel addYatimModel : addYatimArrayList) {
                    Toast.makeText(getActivity(), "toast 2" + allResolutionModels.getParentsName(), Toast.LENGTH_SHORT).show();
                    addYatimModel.setMainInfoModel(allResolutionModels);
                    saveDataInfoToDatabase(addYatimModel);
                }
            }
        });
        showHideToolbarAddButton();
    }

    @Override
    public void onStop() {
        super.onStop();
//        UtiltApp.setYatimData(requireActivity(), addYatimArrayList);
    }

    public void showHideToolbarAddButton() {

        if (adapter.getItemCount() > 0) {
            binding.nextBasicInfoFragment.setVisibility(View.VISIBLE);
            binding.addYatimTv.setVisibility(View.GONE);
            binding.rvYatim.setVisibility(View.VISIBLE);
        } else {
            binding.nextBasicInfoFragment.setVisibility(View.GONE);
            binding.addYatimTv.setVisibility(View.VISIBLE);
            binding.rvYatim.setVisibility(View.GONE);
        }
    }

    public void saveDataInfoToDatabase(AddYatimModel yatimModel) {

        System.out.println("Log yatimModel " + yatimModel.getYatimName());
        yatimRef.child(yatimModel.getMobileNumber()).setValue(yatimModel, (error, ref) -> {
            if (error == null) {
//                            Intent i = new Intent(AdminAddNewProductActivity.this, AdminCategoryActivity.class);
//                            startActivity(i);
//                            finish();
                completeAddCount++;
                if (completeAddCount == addYatimArrayList.size()) {
                    lodingBar.dismiss();
                    Toast.makeText(getActivity(), "added Successfully", Toast.LENGTH_SHORT).show();
                    NavHostFragment.findNavController(NewYatimsFragment.this)
                            .navigate(R.id.action_AddYatimsFragment_to_yatimSelectionCriteriaFragment);
                }

            } else {
                lodingBar.dismiss();
                String message = error.getMessage();
                Toast.makeText(getActivity(), "Error : " + message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}