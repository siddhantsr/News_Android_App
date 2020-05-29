package com.example.news.startingActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.news.NewsActivity.MainActivity;
import com.example.news.R;
import com.google.firebase.auth.FirebaseAuth;

public class home extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        Button signIn = findViewById(R.id.signin);
        Button signUp = findViewById(R.id.signup);
        TextView skip = findViewById(R.id.skip);


       //Animation Part//
        Animation leftAnim = AnimationUtils.loadAnimation(this, R.anim.button_anim_left);
        Animation rightAnim = AnimationUtils.loadAnimation(this, R.anim.button_anim_right);



        signIn.setAnimation(leftAnim);
        signUp.setAnimation(rightAnim);

        //Animation Finish//

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
                overridePendingTransition(R.anim.slide_right, R.anim.slide_left_out);


            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                overridePendingTransition(R.anim.slide_right, R.anim.slide_left_out);


            }
        });


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                overridePendingTransition(R.anim.slide_left, R.anim.slide_left_out);
                finish();
            }
        });




    }



}



