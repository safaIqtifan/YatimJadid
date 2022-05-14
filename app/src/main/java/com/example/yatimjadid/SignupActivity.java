package com.example.yatimjadid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;

public class SignupActivity extends BaseActivity {

    EditText nameEd, e_mailEd, passwordEd;
    TextView mLoginBtn;
    Button signupButton;
    //    ProgressBar progressBar;
    private ProgressDialog lodingBar;

    //    FirebaseFirestore fireStoreDB;
    private FirebaseAuth fAuth;
//    StorageReference storageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nameEd = findViewById(R.id.name);
        e_mailEd = findViewById(R.id.e_mailAddress);
        passwordEd = findViewById(R.id.password);
        signupButton = findViewById(R.id.signupButton);
        mLoginBtn = findViewById(R.id.logintoaccount);
//        progressBar = findViewById(R.id.progressBar);

//        fireStoreDB = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();
        lodingBar = new ProgressDialog(this);
//        storageRef = FirebaseStorage.getInstance().getReference();

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ValidData();
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignupActivity.this, SigninActivity.class));
                finish();
            }
        });

    }

    private void ValidData() {

        String nameStr = nameEd.getText().toString();
        String emailStr = e_mailEd.getText().toString();
        String passwordStr = passwordEd.getText().toString();

        if (nameStr.isEmpty()) {
            nameEd.setError("name is Requird");
            return;
        }
        if (emailStr.isEmpty()) {
            e_mailEd.setError("Email is Requird");
            return;
        }

        if (passwordStr.isEmpty()) {
            passwordEd.setError("password is Requird");
            return;
        }

        if (passwordStr.length() < 4) {
            passwordEd.setError("password Must be 4 or more characters");
            return;
        }

        lodingBar.setTitle("إنشاء حساب جديد");
        lodingBar.setMessage("الرجاء الانتظار حتي يتم التحقق من البيانات");
        lodingBar.setCanceledOnTouchOutside(false);
        lodingBar.show();

        firebaseAuth(nameStr, emailStr, passwordStr);

    }

    private void firebaseAuth(String name, String email, String password) {

        fAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

//                progressBar.setVisibility(View.VISIBLE);
                lodingBar.dismiss();
                FirebaseUser firebaseUser = fAuth.getCurrentUser();
                assert firebaseUser != null;
                String userid = firebaseUser.getUid();

                Intent intent = new Intent(SignupActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                lodingBar.dismiss();
                Toast.makeText(SignupActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = fAuth.getCurrentUser();

        if (user != null) {
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
            startActivity(intent);
            finish();
        }
    }


}