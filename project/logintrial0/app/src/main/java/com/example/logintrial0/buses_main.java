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

public class buses_main extends AppCompatActivity {

    ImageView profileImage07;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    StorageReference storageReference;
    String userId;
    ImageButton Bus1, Bus2, Bus3, Bus4, Bus5;

    String[] urls = new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buses_main);


        Bus1 = findViewById(R.id.bus1);
        Bus2 = findViewById(R.id.bus2);
        Bus3 = findViewById(R.id.bus3);
        Bus4 = findViewById(R.id.bus4);
        Bus5 = findViewById(R.id.bus5);


        urls[0] ="https://www.google.com/maps/dir/Sadar+Bus+Stand,,+Jhansi+Rd,+Sadar+Bazaar,+Sagar,+Madhya+Pradesh/Babulal+Tarabai+Institute+of+Research+and+Technology,+Village,+Sironja,+Madhya+Pradesh/@23.8020776,78.8044471,17z/data=!4m34!4m33!1m25!1m1!1s0x3978d6c91468f8cf:0x4c007c5b7dda3a3d!2m2!1d78.7403048!2d23.8524553!3m4!1m2!1d78.7536852!2d23.8516722!3s0x3978d135d8e4444f:0xaf81907cabeab1c6!3m4!1m2!1d78.7611827!2d23.8478291!3s0x3978d147af895e4f:0x8db146e8cd7d3fb4!3m4!1m2!1d78.7611827!2d23.8478291!3s0x3978d147af895e4f:0x8db146e8cd7d3fb4!3m4!1m2!1d78.802577!2d23.8130464!3s0x3978d230dda45f3b:0x1ad177f8e86d0a7b!1m5!1m1!1s0x3978d2462c3f72e1:0xc1147be044f347d9!2m2!1d78.8046453!2d23.8028723!3e0";
        urls[1] ="https://www.google.com/maps/dir/Katra+Bazaar,+Sagar,+Madhya+Pradesh/Babulal+Tarabai+Institute+of+Research+and+Technology,+Village,+Sironja,+Madhya+Pradesh/@23.8276502,78.7369563,12.75z/data=!4m14!4m13!1m5!1m1!1s0x3978d6b188793d79:0x27d4956d6cb889d2!2m2!1d78.7412443!2d23.8388771!1m5!1m1!1s0x3978d2462c3f72e1:0xc1147be044f347d9!2m2!1d78.8046453!2d23.8028723!3e0";
        urls[2] ="https://www.google.com/maps/dir/Patkui,+Madhya+Pradesh/Babulal+Tarabai+Institute+of+Research+and+Technology,+Village,+Sironja,+Madhya+Pradesh/@23.8856697,78.7362179,11.75z/data=!4m14!4m13!1m5!1m1!1s0x3978d0dfa38e63ef:0x8b67d0b31eeef522!2m2!1d78.7688728!2d23.8753786!1m5!1m1!1s0x3978d2462c3f72e1:0xc1147be044f347d9!2m2!1d78.8046453!2d23.8028723!3e0";
        urls[3] ="https://www.google.com/maps/dir/Bada+Bazaar,+Sagar,+Madhya+Pradesh/Babulal+Tarabai+Institute+of+Research+and+Technology,+Village,+Sironja,+Madhya+Pradesh/@23.8200539,78.7313213,13z/data=!3m1!4b1!4m14!4m13!1m5!1m1!1s0x3978d6a4bcae3cbd:0xaa5165c8282240d4!2m2!1d78.7263642!2d23.837048!1m5!1m1!1s0x3978d2462c3f72e1:0xc1147be044f347d9!2m2!1d78.8046453!2d23.8028723!3e0";
        urls[4] ="https://www.google.com/maps/dir/MAKRONIYA+CHOURAHA,+Sagar+Road,+Sagar+Cantt,+Makroniya,+Madhya+Pradesh/Babulal+Tarabai+Institute+of+Research+and+Technology,+Village,+Sironja,+Madhya+Pradesh/@23.8272368,78.7637104,13z/data=!3m1!4b1!4m14!4m13!1m5!1m1!1s0x3978d10e31693ccb:0x5f7c1e0a456a9241!2m2!1d78.7917945!2d23.8513934!1m5!1m1!1s0x3978d2462c3f72e1:0xc1147be044f347d9!2m2!1d78.8046453!2d23.8028723!3e0";

       Bus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[0]);
                startActivity(intent);
            }
        });
        Bus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[1]);
                startActivity(intent);
            }
        });
        Bus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[2]);
                startActivity(intent);
            }
        });
        Bus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[3]);
                startActivity(intent);
            }
        });
        Bus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[4]);
                startActivity(intent);
            }
        });


        profileImage07 = findViewById(R.id.profileImage07);

        fAuth = FirebaseAuth.getInstance();
        FirebaseUser user = fAuth.getCurrentUser();
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        StorageReference profileRef = storageReference.child("users/" + fAuth.getCurrentUser().getUid() + "/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profileImage07);
            }
        });

        profileImage07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent img = new Intent(buses_main.this, MainActivity.class);
                startActivity(img);

            }
        });
    }
}