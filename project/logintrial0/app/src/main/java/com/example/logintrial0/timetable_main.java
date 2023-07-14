package com.example.logintrial0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class timetable_main extends AppCompatActivity {
    ImageButton t_cs;
    ImageButton t_ec;
    ImageButton t_ce;
    ImageButton t_me;
    ImageButton t_e;
    ImageView profileImage08;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    StorageReference storageReference;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable_main);



        profileImage08 = findViewById(R.id.profileImage08);

        fAuth = FirebaseAuth.getInstance();
        FirebaseUser user = fAuth.getCurrentUser();
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        StorageReference profileRef = storageReference.child("users/" + fAuth.getCurrentUser().getUid() + "/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profileImage08);
            }
        });

        profileImage08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent img = new Intent(timetable_main.this, MainActivity.class);
                startActivity(img);

            }
        });

        ImageButton androidImageButton1 = (ImageButton) findViewById(R.id. t_cs);
        androidImageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(timetable_main.this, "it works", Toast.LENGTH_LONG).show();
                t_cs();

            }
        });

        ImageButton androidImageButton2 = (ImageButton) findViewById(R.id.t_ec);
        androidImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(timetable_main.this, "it works", Toast.LENGTH_LONG).show();
                t_ec();

            }
        });

        ImageButton androidImageButton3 = (ImageButton) findViewById(R.id.t_ce);
        androidImageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(timetable_main.this, "it works", Toast.LENGTH_LONG).show();
                t_ce();

            }
        });

        ImageButton androidImageButton4 = (ImageButton) findViewById(R.id.t_me);
        androidImageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(timetable_main.this, "it works", Toast.LENGTH_LONG).show();
                t_me();

            }
        });

        ImageButton androidImageButton5 = (ImageButton) findViewById(R.id.t_e);
        androidImageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(timetable_main.this, "it works", Toast.LENGTH_LONG).show();
                t_e();

            }
        });


    }

    public void  t_cs() {
        Intent intent1 = new Intent(this,t_cs_sempage .class);
        startActivity(intent1);


    }

    public void t_ec() {
        Intent intent2 = new Intent(this,t_ec_sempage.class);
        startActivity(intent2);


    }
    public void t_ce() {
        Intent intent3 = new Intent(this,t_ce_sempage.class);
        startActivity(intent3);


    }

    public void  t_me() {
        Intent intent4 = new Intent(this, t_me_sempage.class);
        startActivity(intent4);


    }

    public void t_e() {
        Intent intent5 = new Intent(this, t_e_sempage.class);
        startActivity(intent5);


    }

}