package com.example.yatimjadid.addYatim;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.yatimjadid.AddYatimActivity;
import com.example.yatimjadid.Constants;
import com.example.yatimjadid.Models.AddYatimModel;
import com.example.yatimjadid.R;
import com.example.yatimjadid.StartYatimCriteriaActivity;
import com.example.yatimjadid.databinding.FragmentAddAttachmentsBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AddAttachmentsFragment extends Fragment {

    private FragmentAddAttachmentsBinding binding;

    AddYatimModel addYatimModel;
    //    Uri photoUri;
    Map<String, Uri> photosUriMap;
    Bundle bundle;
    private ProgressDialog lodingBar;
    AddYatimActivity ownerActivity;

    StorageReference storageRef;
    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;

    final String PHOTO_ID = "photo_id", PHOTO_DECEASED_CERTIFICATE = "photo_deceased_certificate",
            PHOTO_BIRTH_CERTIFICATE = "photo_birth_certificate",
            PHOTO_PERSONAL_PICTURE = "photo_personal_picture", PHOTO_CUSTODY_DECLARATION = "photo_custody_declaration",
            PHOTO_GUARDIANSHIP = "photo_guardianship", PHOTO_SCHOOL_CERTIFICATE = "photo_school_certificate",
            PHOTO_SALARY_SLIP_IF_ANY = "photo_salary_slip_if_any";
    String photoType = null;

    int completeUploadCount = 0;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentAddAttachmentsBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        lodingBar = new ProgressDialog(getActivity());
//
//        bundle = getArguments();
//        if (bundle != null && bundle.containsKey(Constants.KEY_NEW_YATIM_DATA_MODEL)) {
//            addYatimModel = (AddYatimModel) bundle.getSerializable(Constants.KEY_NEW_YATIM_DATA_MODEL);
//        }
//        else {
//            yatimModel = new AddYatimModel();
//        }

        ownerActivity = (AddYatimActivity) requireActivity();
        this.addYatimModel = ownerActivity.addYatimModel;

        storageRef = FirebaseStorage.getInstance().getReference();
        photosUriMap = new HashMap<>();

        binding.photoIDTV.setOnClickListener(view1 -> {
            photoType = PHOTO_ID;
            openPickPhoto();
        });

        binding.certificateOfDeceasedTV.setOnClickListener(view1 -> {
            photoType = PHOTO_DECEASED_CERTIFICATE;
            openPickPhoto();
        });

        binding.birthCertificateTV.setOnClickListener(view1 -> {
            photoType = PHOTO_BIRTH_CERTIFICATE;
            openPickPhoto();
        });

        binding.personalPictureTV.setOnClickListener(view1 -> {
            photoType = PHOTO_PERSONAL_PICTURE;
            openPickPhoto();
        });

        binding.custodyDeclarationTV.setOnClickListener(view1 -> {
            photoType = PHOTO_CUSTODY_DECLARATION;
            openPickPhoto();
        });

        binding.guardianshipTV.setOnClickListener(view1 -> {
            photoType = PHOTO_GUARDIANSHIP;
            openPickPhoto();
        });

        binding.schoolCertificateTV.setOnClickListener(view1 -> {
            photoType = PHOTO_SCHOOL_CERTIFICATE;
            openPickPhoto();
        });

        binding.salarySlipIfAnyTV.setOnClickListener(view1 -> {
            photoType = PHOTO_SALARY_SLIP_IF_ANY;
            openPickPhoto();
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

                if (!photosUriMap.containsKey(PHOTO_ID)) {
                    lodingBar.dismiss();
                    Toast.makeText(getActivity(), "الرجاء اضافة صورة واحدة علي الأقل", Toast.LENGTH_SHORT).show();
                    // please select photo id
                    return;
                }

//                Intent intent = new Intent();
//                intent.putExtra(Constants.KEY_NEW_YATIM_DATA_MODEL, addYatimModel);
//                requireActivity().setResult(Activity.RESULT_OK, intent);
//                requireActivity().finish();

                completeUploadCount = 0;
                for (String photoType : photosUriMap.keySet()) {
                    uploadPhoto(photoType, photosUriMap.get(photoType));
                }

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

            Uri photoUri = data.getData();
            if (photoType == null)
                return;

            ImageView selectedImageView = null;
            switch (photoType) {
                case PHOTO_ID:
                    selectedImageView = binding.photoID;
                    addYatimModel.setPhotoId(photoUri.toString());
                    break;
                case PHOTO_DECEASED_CERTIFICATE:
                    selectedImageView = binding.certificateOfDeceased;
                    addYatimModel.setPhotoId(photoUri.toString());
                    break;
                case PHOTO_BIRTH_CERTIFICATE:
                    selectedImageView = binding.birthCertificate;
                    addYatimModel.setPhotoId(photoUri.toString());
                    break;
                case PHOTO_PERSONAL_PICTURE:
                    selectedImageView = binding.personalPicture;
                    addYatimModel.setPhotoId(photoUri.toString());
                    break;
                case PHOTO_CUSTODY_DECLARATION:
                    selectedImageView = binding.custodyDeclaration;
                    addYatimModel.setPhotoId(photoUri.toString());
                    break;
                case PHOTO_GUARDIANSHIP:
                    selectedImageView = binding.guardianshipImage;
                    addYatimModel.setPhotoId(photoUri.toString());
                    break;
                case PHOTO_SCHOOL_CERTIFICATE:
                    selectedImageView = binding.schoolCertificateImage;
                    addYatimModel.setPhotoId(photoUri.toString());
                    break;
                case PHOTO_SALARY_SLIP_IF_ANY:
                    selectedImageView = binding.salarySlipIfAny;
                    addYatimModel.setPhotoId(photoUri.toString());
                    break;
            }
            if (selectedImageView != null)
                selectedImageView.setImageURI(photoUri);
            selectedImageView.setVisibility(View.VISIBLE);

//            photosUriMap.put(photoType, photoUri);

        }
    }

    private void openPickPhoto() {

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

    private void uploadPhoto(String photoType, Uri photoUri) {

        lodingBar.setTitle("جاري حفظ البيانات");
        lodingBar.setMessage("الرجاء الانتظار حتي يتم حفظ البيانات");
        lodingBar.setCanceledOnTouchOutside(false);
        lodingBar.show();

        StorageReference imgRef = storageRef.child(Constants.ATTACHMENTS_IMAGES + "/"
                + UUID.randomUUID().toString());

        UploadTask uploadTask = imgRef.putFile(photoUri);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
//                Log.e("aa", exception + "");
                lodingBar.dismiss();
                Toast.makeText(getActivity(), "فشل برفع الصور", Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(taskSnapshot -> {
            completeUploadCount++;
//            if (completeUploadCount >= photosUriMap.size()) {
//                lodingBar.dismiss();
//            }
            imgRef.getDownloadUrl().addOnCompleteListener(task -> {
                switch (photoType) {
                    case PHOTO_ID:
                        addYatimModel.setPhotoId(task.getResult().toString());
                        break;
                    case PHOTO_DECEASED_CERTIFICATE:
                        addYatimModel.setCertificateOfDeceased(task.getResult().toString());
                        break;
                    case PHOTO_BIRTH_CERTIFICATE:
                        addYatimModel.setBirthCertificate(task.getResult().toString());
                        break;
                    case PHOTO_PERSONAL_PICTURE:
                        addYatimModel.setPersonalPicture(task.getResult().toString());
                        break;
                    case PHOTO_GUARDIANSHIP:
                        addYatimModel.setGuardianshipImage(task.getResult().toString());
                        break;
                    case PHOTO_SCHOOL_CERTIFICATE:
                        addYatimModel.setSchoolCertificateImage(task.getResult().toString());
                        break;
                    case PHOTO_SALARY_SLIP_IF_ANY:
                        addYatimModel.setSalarySlipIfAny(task.getResult().toString());
                        break;
                }
            });
            if (completeUploadCount >= photosUriMap.size()) {
                lodingBar.dismiss();
                bundle.putSerializable(Constants.KEY_NEW_YATIM_DATA_MODEL, addYatimModel);
//            Toast.makeText(getActivity(), "123" + addYatimModel.getYatimName(), Toast.LENGTH_SHORT).show();
//                NavHostFragment.findNavController(AddAttachmentsFragment.this)
//                        .navigate(R.id.action_AddAttachmentsFragment_to_AddYatimsFragment, bundle);
                Intent intent = new Intent();
                intent.putExtra(Constants.KEY_NEW_YATIM_DATA_MODEL, addYatimModel);
                requireActivity().setResult(Activity.RESULT_OK, intent);
                requireActivity().finish();
            }

        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}