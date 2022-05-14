package com.example.yatimjadid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.yatimjadid.Adapter.FamilyMemberAdapter;
import com.example.yatimjadid.Models.AllResolutionModels;
import com.example.yatimjadid.Models.FamilyMembersModel;
import com.example.yatimjadid.databinding.FragmentFamilyMembersBinding;

import java.util.ArrayList;

public class FamilyMembersFragment extends Fragment {

    private FragmentFamilyMembersBinding binding;

    AllResolutionModels allResolutionModels;
    int editedFamilyMemberPos = -1;
    FamilyMembersModel familyMembersModel;
    ArrayList<FamilyMembersModel> familyMembersArrayList;
    FamilyMemberAdapter adapter;
//    View toolbarAddBtn;


    ActivityResultLauncher<Intent> addMemberLaunch = null;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFamilyMembersBinding.inflate(inflater, container, false);
//        Toolbar toolbar = container.findViewById(R.id.mainToolbar);
//        if (toolbar != null)
//            toolbarAddBtn = toolbar.findViewById(R.id.toolbarAddBtn);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        familyMembersArrayList = DBFunction.getFamilyMembers(requireActivity());
//        familyMembersArrayList = new ArrayList<>();

        addMemberLaunch = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
            if (result.getResultCode() == Activity.RESULT_OK) {

                Intent resultIntent = result.getData();
                familyMembersModel = (FamilyMembersModel) resultIntent.getSerializableExtra(Constants.KEY_FAMILY_MEMBERS);

                if (editedFamilyMemberPos != -1) {
                    familyMembersArrayList.set(editedFamilyMemberPos, familyMembersModel);
                    editedFamilyMemberPos = -1;
                } else
                    familyMembersArrayList.add(familyMembersModel);

                adapter.notifyDataSetChanged();
                showHideToolbarAddButton();
                DBFunction.setFamilyMembers(requireActivity(), familyMembersArrayList);
            }
        });

        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey(Constants.KEY_YATIM_MODEL)) {
            allResolutionModels = (AllResolutionModels) bundle.getSerializable(Constants.KEY_YATIM_MODEL);
        } else {
            allResolutionModels = new AllResolutionModels();
        }

        binding.rvFamily.setLayoutManager(new LinearLayoutManager(getActivity()));
//        FamilyMemberAdapter familyMemberAdapter= new FamilyMemberAdapter(getActivity(), familyMembersArrayList);
//        binding.rvFamily.setAdapter(familyMemberAdapter);

        adapter = new FamilyMemberAdapter(getActivity(), familyMembersArrayList, new DataCallBack() {
            @Override
            public void Result(Object obj, String type, Object otherData) {
//                familyMembersArrayList = DBFunction.getFamilyMembers(requireActivity());

                if (type.equals("delete")) {
                    showHideToolbarAddButton();
                } else {
                    editedFamilyMemberPos = (int) otherData;
                    FamilyMembersModel familyMemberModel = (FamilyMembersModel) obj;

//                Bundle updateBundle = new Bundle();
//                updateBundle.putSerializable(Constants.KEY_UPDATE_DATA, familyMemberModel);
//                NavHostFragment.findNavController(FamilyMembersFragment.this)
//                        .navigate(R.id.action_FamilyMembersFragment_to_FamilyMemberDataFragment, updateBundle);
                    Intent intent = new Intent(requireActivity(), AddFamilyMemberActivity.class);
                    intent.putExtra(Constants.KEY_UPDATE_DATA, familyMemberModel);
                    addMemberLaunch.launch(intent);
                }

            }

        });

        binding.rvFamily.setAdapter(adapter);

        binding.addDataTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                NavHostFragment.findNavController(FamilyMembersFragment.this)
//                        .navigate(R.id.action_FamilyMembersFragment_to_FamilyMemberDataFragment);
                Intent intent = new Intent(requireActivity(), AddFamilyMemberActivity.class);
                addMemberLaunch.launch(intent);
//                intent.putExtra(Constants.KEY_UPDATE_DATA, familyMemberModel);
            }
        });

        binding.addFamilyMemberBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(requireActivity(), AddFamilyMemberActivity.class);
                addMemberLaunch.launch(intent);

            }
        });

        binding.nextFamilyMemberFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Bundle updateBundle = new Bundle();
//                updateBundle.putSerializable(Constants.KEY_UPDATE_DATA, familyMembersModel);

                NavHostFragment.findNavController(FamilyMembersFragment.this)
                        .navigate(R.id.action_FamilyMembersFragment_to_AddYatimsFragment);
            }
        });

        showHideToolbarAddButton();
    }

    @Override
    public void onStop() {
        super.onStop();
//        DBFunction.setFamilyMembers(requireActivity(), familyMembersArrayList);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void showHideToolbarAddButton() {

        if (adapter.getItemCount() > 0) {
            binding.addFamilyMemberBtn.setVisibility(View.VISIBLE);
            binding.addDataTv.setVisibility(View.GONE);
            binding.rvFamily.setVisibility(View.VISIBLE);
        } else {
            binding.addFamilyMemberBtn.setVisibility(View.GONE);
            binding.addDataTv.setVisibility(View.VISIBLE);
            binding.rvFamily.setVisibility(View.GONE);
        }
    }
}