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

public class n_ec_sempage extends AppCompatActivity {
    ImageView profileImage16;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    StorageReference storageReference;
    String userId;

    ImageButton n1_sem,n2_sem,n3_sem,n4_sem,n5_sem,n6_sem,n7_sem,n8_sem;

    String[] urls = new String[8];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nec_sempage);

        profileImage16 = findViewById(R.id.profileImage16);

        n1_sem = findViewById(R.id.n1_sem);
        n2_sem = findViewById(R.id.n2_sem);
        n3_sem = findViewById(R.id.n3_sem);
        n4_sem = findViewById(R.id.n4_sem);
        n5_sem = findViewById(R.id.n5_sem);
        n6_sem = findViewById(R.id.n6_sem);
        n7_sem = findViewById(R.id.n7_sem);
        n8_sem = findViewById(R.id.n8_sem);

        urls[0] ="https://drive.google.com/file/d/17BiJt27SWs9VjFaes2av975bLuID73Bv/view?usp=sharing";
        urls[1] ="https://drive.google.com/file/d/17BiJt27SWs9VjFaes2av975bLuID73Bv/view?usp=sharing";
        urls[2] ="https://drive.google.com/file/d/17BiJt27SWs9VjFaes2av975bLuID73Bv/view?usp=sharing";
        urls[3] ="https://drive.google.com/file/d/17BiJt27SWs9VjFaes2av975bLuID73Bv/view?usp=sharing";
        urls[4] ="https://drive.google.com/file/d/17BiJt27SWs9VjFaes2av975bLuID73Bv/view?usp=sharing";
        urls[5] ="https://drive.google.com/file/d/17BiJt27SWs9VjFaes2av975bLuID73Bv/view?usp=sharing";
        urls[6] ="https://drive.google.com/file/d/17BiJt27SWs9VjFaes2av975bLuID73Bv/view?usp=sharing";
        urls[7] ="https://drive.google.com/file/d/17BiJt27SWs9VjFaes2av975bLuID73Bv/view?usp=sharing";


        n1_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[0]);
                startActivity(intent);
            }
        });

        n2_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[1]);
                startActivity(intent);
            }
        });

        n3_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[2]);
                startActivity(intent);
            }
        });

        n4_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[3]);
                startActivity(intent);
            }
        });

        n5_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[4]);
                startActivity(intent);
            }
        });

        n6_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[5]);
                startActivity(intent);
            }
        });

        n7_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[6]);
                startActivity(intent);
            }
        });

        n8_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[7]);
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
                Picasso.get().load(uri).into(profileImage16);
            }
        });

        profileImage16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent img = new Intent(n_ec_sempage.this, MainActivity.class);
                startActivity(img);

            }
        });
    }
}