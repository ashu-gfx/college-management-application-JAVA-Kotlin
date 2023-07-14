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

public class notes_main extends AppCompatActivity {

    ImageButton at_cs;
    ImageButton at_ec;
    ImageButton at_ce;
    ImageButton at_me;
    ImageButton at_e;
    ImageView profileImage14;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    StorageReference storageReference;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_main);

        profileImage14 = findViewById(R.id.profileImage14);

        fAuth = FirebaseAuth.getInstance();
        FirebaseUser user = fAuth.getCurrentUser();
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        StorageReference profileRef = storageReference.child("users/" + fAuth.getCurrentUser().getUid() + "/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profileImage14);
            }
        });

        profileImage14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent img = new Intent(notes_main.this, MainActivity.class);
                startActivity(img);

            }
        });

        ImageButton androidImageButton1 = (ImageButton) findViewById(R.id. at_cs);
        androidImageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(notes_main.this, "it works", Toast.LENGTH_LONG).show();
                at_cs();

            }
        });

        ImageButton androidImageButton2 = (ImageButton) findViewById(R.id.at_ec);
        androidImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(notes_main.this, "it works", Toast.LENGTH_LONG).show();
                at_ec();

            }
        });

        ImageButton androidImageButton3 = (ImageButton) findViewById(R.id.at_ce);
        androidImageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(notes_main.this, "it works", Toast.LENGTH_LONG).show();
                at_ce();

            }
        });

        ImageButton androidImageButton4 = (ImageButton) findViewById(R.id.at_me);
        androidImageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(notes_main.this, "it works", Toast.LENGTH_LONG).show();
                at_me();

            }
        });

        ImageButton androidImageButton5 = (ImageButton) findViewById(R.id.at_e);
        androidImageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(notes_main.this, "it works", Toast.LENGTH_LONG).show();
                at_e();

            }
        });

    }

    public void  at_cs() {
        Intent intent1 = new Intent(this,n_cs_sempage.class);
        startActivity(intent1);


    }

    public void at_ec() {
        Intent intent2 = new Intent(this,n_ec_sempage.class);
        startActivity(intent2);


    }
    public void at_ce() {
        Intent intent3 = new Intent(this,n_ce_sempage.class);
        startActivity(intent3);


    }

    public void  at_me() {
        Intent intent4 = new Intent(this, n_me_sempage.class);
        startActivity(intent4);


    }

    public void at_e() {
        Intent intent5 = new Intent(this, n_e_sempage.class);
        startActivity(intent5);


    }

}