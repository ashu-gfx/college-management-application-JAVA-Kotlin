package com.example.logintrial0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class at_cs_sempage extends AppCompatActivity {

    ImageView profileImage03;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    StorageReference storageReference;
    String userId;
    ImageButton a1_year,a2_year,a3_year,a4_year;

    String[] urls = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_at_cs_sempage);

        profileImage03 = findViewById(R.id.profileImage03);
        a1_year = findViewById(R.id.a1_year);
        a2_year = findViewById(R.id.a2_year);
        a3_year = findViewById(R.id.a3_year);
        a4_year = findViewById(R.id.a4_year);


        urls[0] ="https://docs.google.com/spreadsheets/d/1JjGZ9ir2Gwz32GLSYh_fEto1MPYwUtbaLBfXo5yxTS0/edit?usp=sharing";
        urls[1] ="https://docs.google.com/spreadsheets/d/1JjGZ9ir2Gwz32GLSYh_fEto1MPYwUtbaLBfXo5yxTS0/edit?usp=sharing";
        urls[2] ="https://docs.google.com/spreadsheets/d/1JjGZ9ir2Gwz32GLSYh_fEto1MPYwUtbaLBfXo5yxTS0/edit?usp=sharing";
        urls[3] ="https://docs.google.com/spreadsheets/d/1JjGZ9ir2Gwz32GLSYh_fEto1MPYwUtbaLBfXo5yxTS0/edit?usp=sharing";



        a1_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[0]);
                startActivity(intent);
            }
        });

        a2_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[1]);
                startActivity(intent);
            }
        });

        a3_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[2]);
                startActivity(intent);
            }
        });

        a4_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[3]);
                startActivity(intent);
            }
        });

        fAuth = FirebaseAuth.getInstance();
        FirebaseUser user = fAuth.getCurrentUser();
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        StorageReference profileRef = storageReference.child("users/" + fAuth.getCurrentUser().getUid() + "/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profileImage03);
            }
        });

        profileImage03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent img = new Intent(at_cs_sempage.this, MainActivity.class);
                startActivity(img);

            }
        });
    }
}