package com.example.yatimjadid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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

public class SigninActivity extends BaseActivity {

    public static final int REQUEST_CODE = 10005;
    EditText mEmail, mPassword;
    Button mLoginBtn;
    TextView mCreateBtn, forgotTextLink;
//    ProgressBar progressBar;
    private ProgressDialog lodingBar;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mEmail = findViewById(R.id.login_mail);
        mPassword = findViewById(R.id.login_password);
        mLoginBtn = findViewById(R.id.login_button);
//        progressBar = findViewById(R.id.progressBar);
        mCreateBtn = findViewById(R.id.create_new_account);
        forgotTextLink = findViewById(R.id.forgot_password);
        lodingBar = new ProgressDialog(this);

        fAuth = FirebaseAuth.getInstance();

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidData();
//                progressBar.setVisibility(View.VISIBLE);
            }
        });

        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SigninActivity.this, SignupActivity.class));
                finish();
            }
        });

        forgotTextLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText resetMail = new EditText(v.getContext());
                AlertDialog.Builder passWordResetDialog = new AlertDialog.Builder(v.getContext());
                passWordResetDialog.setTitle("Reset Password ?");
                passWordResetDialog.setMessage("Enter your E-mail to Reset Link ");
                passWordResetDialog.setView(resetMail);

                passWordResetDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String mail = resetMail.getText().toString();
                        fAuth.sendPasswordResetEmail(mail).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(SigninActivity.this, "Reset Link Sent to Your Email .", Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(SigninActivity.this, "Error ! Reset Link is Not Sent ." + e.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
                passWordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                passWordResetDialog.create().show();
            }
        });

    }

    public void ValidData(){

        String emailStr = mEmail.getText().toString();
        String passwordStr = mPassword.getText().toString();

        if (emailStr.isEmpty()){
            mEmail.setError("Email is Missing");
            return;
        }
        if (passwordStr.isEmpty()){
            mPassword.setError("Password is Missing");
            return;
        }

        lodingBar.setTitle("تسجيل الدخول للإستبانة");
        lodingBar.setMessage("الرجاء الانتظار حتي يتم التحقق من البيانات");
        lodingBar.setCanceledOnTouchOutside(false);
        lodingBar.show();
        LoginAth(emailStr, passwordStr);
    }

    public void LoginAth(String email, String password){

        fAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            lodingBar.dismiss();
                            startActivity(new Intent(SigninActivity.this, HomeActivity.class)
                                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                            finish();

                        } else {
                            lodingBar.dismiss();
                            Toast.makeText(SigninActivity.this, "fail_to_login", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (FirebaseAuth.getInstance().getCurrentUser() != null){
            startActivity(new Intent(SigninActivity.this, HomeActivity.class));
            finish();
        }
    }
}