package com.example.news.startingActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.news.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
   private EditText FullName, Email, Phone, Password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        FullName = findViewById(R.id.fullname);
        Email = findViewById(R.id.email);
        Phone = findViewById(R.id.phone);
        Password = findViewById(R.id.password);
        Button mSignUp = findViewById(R.id.signup);
        ImageView topImage = findViewById(R.id.imageView2);



        //Animation part
        Animation rightAnim = AnimationUtils.loadAnimation(this, R.anim.button_anim_right);
        Animation topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        Animation bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        Animation leftAnim = AnimationUtils.loadAnimation(this, R.anim.button_anim_left);



        FullName.setAnimation(rightAnim);
        Email.setAnimation(leftAnim);
        Password.setAnimation(rightAnim);
        Phone.setAnimation(leftAnim);
        mSignUp.setAnimation(bottomAnim);
        topImage.setAnimation(topAnim); //animation part end here


        mAuth = FirebaseAuth.getInstance();
        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();
                String phone = Phone.getText().toString().trim();
                String fullname = FullName.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Email.setError("Email Is Required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Password.setError("Password Is Required");
                    return;
                }

                if (password.length() < 6){
                    Password.setError("Password Must Be 6 Character Long");
                    return;
                }





                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(SignUpActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            finish();



                        }

                        else {

                            Toast.makeText(SignUpActivity.this, "Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        });
    }
}
