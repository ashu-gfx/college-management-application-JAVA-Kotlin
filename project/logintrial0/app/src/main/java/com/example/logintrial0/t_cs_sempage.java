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

public class t_cs_sempage extends AppCompatActivity {

    ImageView profileImage11;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    StorageReference storageReference;
    String userId;

    ImageButton t1_sem,t2_sem,t3_sem,t4_sem,t5_sem,t6_sem,t7_sem,t8_sem;

    String[] urls = new String[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tcs_sempage);

        profileImage11 = findViewById(R.id.profileImage11);

        t1_sem = findViewById(R.id.t1_sem);
        t2_sem = findViewById(R.id.t2_sem);
        t3_sem = findViewById(R.id.t3_sem);
        t4_sem = findViewById(R.id.t4_sem);
        t5_sem = findViewById(R.id.t5_sem);
        t6_sem = findViewById(R.id.t6_sem);
        t7_sem = findViewById(R.id.t7_sem);
        t8_sem = findViewById(R.id.t8_sem);

        urls[0] ="https://drive.google.com/file/d/1zBP6vMHMwAoZxqjCZrewdr8Lb_B0JIF4/view?usp=sharing";
        urls[1] ="https://drive.google.com/file/d/1zBP6vMHMwAoZxqjCZrewdr8Lb_B0JIF4/view?usp=sharing";
        urls[2] ="https://drive.google.com/file/d/1zBP6vMHMwAoZxqjCZrewdr8Lb_B0JIF4/view?usp=sharing";
        urls[3] ="https://drive.google.com/file/d/1zBP6vMHMwAoZxqjCZrewdr8Lb_B0JIF4/view?usp=sharing";
        urls[4] ="https://drive.google.com/file/d/1zBP6vMHMwAoZxqjCZrewdr8Lb_B0JIF4/view?usp=sharing";
        urls[5] ="https://drive.google.com/file/d/1zBP6vMHMwAoZxqjCZrewdr8Lb_B0JIF4/view?usp=sharing";
        urls[6] ="https://drive.google.com/file/d/1zBP6vMHMwAoZxqjCZrewdr8Lb_B0JIF4/view?usp=sharing";
        urls[7] ="https://drive.google.com/file/d/1zBP6vMHMwAoZxqjCZrewdr8Lb_B0JIF4/view?usp=sharing";


        t1_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[0]);
                startActivity(intent);
            }
        });

        t2_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[1]);
                startActivity(intent);
            }
        });

        t3_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[2]);
                startActivity(intent);
            }
        });

        t4_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[3]);
                startActivity(intent);
            }
        });

        t5_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[4]);
                startActivity(intent);
            }
        });

        t6_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[5]);
                startActivity(intent);
            }
        });

        t7_sem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[6]);
                startActivity(intent);
            }
        });

        t8_sem.setOnClickListener(new View.OnClickListener() {
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
                Picasso.get().load(uri).into(profileImage11);
            }
        });

        profileImage11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent img = new Intent(t_cs_sempage.this, MainActivity.class);
                startActivity(img);

            }
        });
    }
}