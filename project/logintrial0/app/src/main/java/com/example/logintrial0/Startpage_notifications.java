package com.example.logintrial0;

import static com.example.logintrial0.cords.FirebaseCords1.mAuth;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.logintrial0.GlobalChat;
import com.example.logintrial0.NotificationTab;
import com.example.logintrial0.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class Startpage_notifications extends AppCompatActivity {

    ImageView Swipeimage;

    // RelativeLayout relativeLayout;
  SwipeListener swipeListener;
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if (currentUser != null) {
//            FirebaseAuth.getInstance().signOut();
//            startActivity(new Intent(this, loginActivity1.class));
//            finish();
//        }
//
//
//    }




    BottomNavigationView navigationView;


    ImageView profileImage04;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    StorageReference storageReference;
    String userId;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startpage_notifications);


        Swipeimage = findViewById(R.id.swipeimage1);
        swipeListener = new SwipeListener(Swipeimage);


        //
        //   FirebaseAuth.getInstance().signOut();

        navigationView = findViewById(R.id.nav);
        navigationView.setSelectedItemId(R.id.Notification);




      //  profileImage04 = findViewById(R.id.profileImage04);
        fAuth = FirebaseAuth.getInstance();
        FirebaseUser user = fAuth.getCurrentUser();
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();













//        StorageReference profileRef = storageReference.child("users/" + fAuth.getCurrentUser().getUid() + "/profile.jpg");
//        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                Picasso.get().load(uri).into(profileImage04);
//            }
//        });
//
//        profileImage04.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent img = new Intent(Startpage_notifications.this, MainActivity.class);
//                startActivity(img);
//
//            }
//        });






        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.profileNB:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        // Toast.makeText(menupage2.this, "Home", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.Global_Chat:
                        startActivity(new Intent(getApplicationContext(), StartPage.class));
                        overridePendingTransition(0, 0);
//                        startActivity(new Intent(MainActivity.this, MainActivity2.class));
//                        Toast.makeText(MainActivity.this, "chat", Toast.LENGTH_SHORT).show();
//                        break;
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), menupage2.class));
                        overridePendingTransition(0, 0);
                        // Toast.makeText(menupage2.this, "Home", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.Notification:
//                        startActivity(new Intent(getApplicationContext(), NotificationTab.class));
//                        overridePendingTransition(0, 0);
                        // Toast.makeText(menupage2.this, "Home", Toast.LENGTH_SHORT).show();
                        return true;


                }
                return false;
            }
        });


        Glide.with(this).load(R.drawable.notification_main).into((ImageView) findViewById(R.id.imageView2));
    }

    private class SwipeListener implements View.OnTouchListener {

        GestureDetector gestureDetector;

        SwipeListener(View view) {
            int threshold = 100;
            int velocity_threshold = 100;


            GestureDetector.SimpleOnGestureListener listener =
                    new GestureDetector.SimpleOnGestureListener() {
                        @Override
                        public boolean onDown(MotionEvent e) {

                            return true;
                        }


                        @Override
                        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                            float xDiff = e2.getX() - e1.getX();
                            float yDiff = e2.getY() - e1.getY();
                            try {
                                if (Math.abs(xDiff) > Math.abs(yDiff)) {
                                    if (Math.abs(xDiff) > threshold
                                            && Math.abs(velocityX) > velocity_threshold) {
                                        if (xDiff > 0) {

                                            // Right Swipe
                                            startActivity(new Intent(Startpage_notifications.this, StartPage.class));
                                            overridePendingTransition(0, 0);
                                            Toast.makeText(Startpage_notifications.this, "Swiped Right", Toast.LENGTH_SHORT).show();

                                            // textView.setText("Swiped Right");
                                        } else {

                                            // Left Swipe

                                            startActivity(new Intent(Startpage_notifications.this, MainActivity.class));
                                            overridePendingTransition(0, 0);
                                            Toast.makeText(Startpage_notifications.this, "Swiped Left", Toast.LENGTH_SHORT).show();
                                            //textView.setText("Swiped Left");
                                        }
                                        return true;
                                    }
                                } else {
                                    if (Math.abs(yDiff) > threshold && Math.abs(velocityY) > velocity_threshold) {
                                        if (yDiff > 0) {
                                            // textView.setText("Swiped Down");
                                        } else {
                                            //  textView.setText("Swiped Up");
                                        }
                                        return true;
                                    }

                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            return false;
                        }
                    };
            gestureDetector = new GestureDetector(listener);
            view.setOnTouchListener(this);

        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return gestureDetector.onTouchEvent(motionEvent);
        }
    }

    public void OpenMainPage(View view) {
        //startActivity(new Intent(this, GlobalChat.class));


        StorageReference profileRef = storageReference.child("users/" + fAuth.getCurrentUser().getUid() + "/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String downloadUrl = uri.toString();
                //String downloadUrl = Picasso.get().toString();
                Intent i = new Intent(view.getContext(), GlobalChat.class);
                i.putExtra("downloadUrl", downloadUrl);
                startActivity(i);
            }
        });
    }

    public void OpenMainPage1(View view) {
        // startActivity(new Intent(this, NotificationTab.class));


        StorageReference profileRef = storageReference.child("users/" + fAuth.getCurrentUser().getUid() + "/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                String downloadUrl = uri.toString();
                //String downloadUrl = Picasso.get().toString();
                Intent i = new Intent(view.getContext(), NotificationTab.class);
                i.putExtra("downloadUrl", downloadUrl);
                startActivity(i);
            }
        });
    }
}