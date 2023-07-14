package com.example.logintrial0;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {

    ImageView Swipeimage4;
   SwipeListener swipeListener;


    TextView verifymsg, fullName, phone, email, enrollmentNo, lastName;
    Button resendcode, changeProfileImage;
    //   Button webview;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    ImageView profileImage;
    StorageReference storageReference;
    BottomNavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Swipeimage4 = findViewById(R.id.swipeimage4);
        swipeListener = new SwipeListener(Swipeimage4);

        FirebaseMessaging.getInstance().subscribeToTopic("notification");
        FirebaseMessaging.getInstance().subscribeToTopic("notify");


        //  getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        // getSupportActionBar().setCustomView(R.layout.custom_toolbar);

        fAuth = FirebaseAuth.getInstance();
        enrollmentNo = findViewById(R.id.profileEnrollment);
        resendcode = findViewById(R.id.resendcode);
        verifymsg = findViewById(R.id.verifymsg);
        fullName = findViewById(R.id.profileName);
        phone = findViewById(R.id.profilePhonenumber);
        email = findViewById(R.id.profileEmail);
        profileImage = findViewById(R.id.profileimage);
        changeProfileImage = findViewById(R.id.profileimagebutton);
        lastName = findViewById(R.id.profilelastName);
//        webview = findViewById(R.id.webview);
        navigationView = findViewById(R.id.nav);
        navigationView.setSelectedItemId(R.id.profileNB);


        FirebaseUser user = fAuth.getCurrentUser();
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        // to hold image after logout
        // StorageReference profileRef = storageReference.child("profile.jpg");
        StorageReference profileRef = storageReference.child("users/" + fAuth.getCurrentUser().getUid() + "/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profileImage);
            }
        });

        userID = fAuth.getCurrentUser().getUid();


        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {


            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if (documentSnapshot.exists()) {
                    phone.setText(documentSnapshot.getString("phone"));
                    fullName.setText(documentSnapshot.getString("fName"));
                    email.setText(documentSnapshot.getString("email"));
                    enrollmentNo.setText(documentSnapshot.getString("enrollment"));
                    lastName.setText(documentSnapshot.getString("lname"));

                } else {
                    Log.d("TAG", "onEvent: document do not exists");
                }
            }
        });

        if (!user.isEmailVerified()) {
            resendcode.setVisibility(View.VISIBLE);
            verifymsg.setVisibility(View.VISIBLE);

            resendcode.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    user.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(view.getContext(), "Verification Email Has Been Send.", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Log.d("tag", "onFailure: Email not send" + e.getMessage());
                        }
                    });
                }
            });
        }


        changeProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // open gallery
                Intent i = new Intent(v.getContext(), EditProfile.class);
                i.putExtra("fullName", fullName.getText().toString());
                i.putExtra("email", email.getText().toString());
                i.putExtra("phone", phone.getText().toString());
                i.putExtra("enrollmentNo", enrollmentNo.getText().toString());
                i.putExtra("lastName", lastName.getText().toString());
//                i.putExtra("fullname", fullname.getText().toString());
//                i.putExtra("email", email.getText().toString());
//                i.putExtra("phone", phoneNo.getText().toString());
                startActivity(i);
                //        Intent openGalleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                //    startActivityForResult(openGalleryIntent, 1000);

            }
        });


        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), menupage2.class));
                        overridePendingTransition(0, 0);
                        // Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.profileNB:
//                        startActivity(new Intent(MainActivity.this, MainActivity2.class));
//                        Toast.makeText(MainActivity.this, "chat", Toast.LENGTH_SHORT).show();
//                        break;
                        return true;

                    case R.id.Notification:
                        startActivity(new Intent(getApplicationContext(), Startpage_notifications.class));
                        overridePendingTransition(0, 0);
                        // Toast.makeText(menupage2.this, "Home", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.Global_Chat:
                        startActivity(new Intent(getApplicationContext(), StartPage.class));
                        overridePendingTransition(0, 0);
                        // Toast.makeText(menupage2.this, "Home", Toast.LENGTH_SHORT).show();
                        return true;

                }
                return false;
            }
        });



//webview.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View view) {
//        Intent intent = new Intent(MainActivity.this,webview_main.class);
//        startActivity(intent);
//    }
//});
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
                                            startActivity(new Intent(MainActivity.this, Startpage_notifications.class));
                                            overridePendingTransition(0, 0);
                                            Toast.makeText(MainActivity.this, "Swiped Right", Toast.LENGTH_SHORT).show();

                                            // textView.setText("Swiped Right");
                                        } else {

                                            // Left Swipe

//                                            startActivity(new Intent(MainActivity.this, StartPage.class));
//                                            overridePendingTransition(0, 0);
//                                            Toast.makeText(MainActivity.this, "Swiped Left", Toast.LENGTH_SHORT).show();
//                                            //textView.setText("Swiped Left");
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == Activity.RESULT_OK) {
                Uri imageUri = data.getData();
                //profileImage.setImageURI(imageUri);

                uplodeImageTOFirebase(imageUri);
            }
        }
    }

    private void uplodeImageTOFirebase(Uri imageUri) {

        //upload image to firebase storage


        //final StorageReference fileRef = storageReference.child("profile.jpg");
        final StorageReference fileRef = storageReference.child("users/" + fAuth.getCurrentUser().getUid() + "/profile.jpg");
        fileRef.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        Picasso.get().load(uri).into(profileImage);


                    }
                });
                Toast.makeText(MainActivity.this, "Image Uploaded", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Failed.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), login.class));
        finish();
    }
}