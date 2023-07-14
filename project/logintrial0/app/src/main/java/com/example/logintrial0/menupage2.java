package com.example.logintrial0;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class menupage2 extends AppCompatActivity {


    ImageView Swipeimage3;
   // RelativeLayout relativeLayout;
    //RelativeLayout scrollView;
    SwipeListener swipeListener;
   // SwipeListener swipeListener1;

    TextView userName, enrollmentNo;
    ImageButton m1_button;
    ImageButton m2_button;
    ImageButton m3_button;
    ImageButton m4_button;
    ImageButton m5_button;
    ImageButton m6_button;
    ImageView profileImage1;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    StorageReference storageReference;
    String userId;
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menupage2);

        Swipeimage3 = findViewById(R.id.swipeimage3);
        swipeListener = new SwipeListener(Swipeimage3);

       // relativeLayout = findViewById(R.id.relative_layout1);
       // m1_button = findViewById(R.id.m1_button);
      //  swipeListener = new SwipeListener(relativeLayout);
       // swipeListener1 = new SwipeListener(scrollView);



        navigationView = findViewById(R.id.nav);
        navigationView.setSelectedItemId(R.id.home);

        userName = findViewById(R.id.username11);
        enrollmentNo = findViewById(R.id.enrollment_no);
        profileImage1 = findViewById(R.id.menu_profileImage);
        fAuth = FirebaseAuth.getInstance();
        FirebaseUser user = fAuth.getCurrentUser();
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        storageReference = FirebaseStorage.getInstance().getReference();

        userId = fAuth.getCurrentUser().getUid();

        DocumentReference documentReference = fStore.collection("users").document(userId);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {


            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if (documentSnapshot.exists()) {
                    userName.setText(documentSnapshot.getString("fName"));
                    enrollmentNo.setText(documentSnapshot.getString("enrollment"));
                } else {
                    Log.d("TAG", "onEvent: document do not exists");
                }
            }
        });


        StorageReference profileRef = storageReference.child("users/" + fAuth.getCurrentUser().getUid() + "/profile.jpg");
        profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).into(profileImage1);
            }
        });


        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.profileNB:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        // Toast.makeText(menupage2.this, "Home", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.home:
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
                      //  FirebaseAuth.getInstance().signOut();
                      //  finish();

                        // Toast.makeText(menupage2.this, "Home", Toast.LENGTH_SHORT).show();
                        return true;


                }
                return false;
            }
        });

        ImageButton androidImageButton1 = (ImageButton) findViewById(R.id.m1_button);
        androidImageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(menupage2.this, "it works", Toast.LENGTH_LONG).show();
                m1_button();

            }
        });

        ImageButton androidImageButton2 = (ImageButton) findViewById(R.id.m2_button);
        androidImageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(menupage2.this, "it works", Toast.LENGTH_LONG).show();
                m2_button();

            }
        });

        ImageButton androidImageButton3 = (ImageButton) findViewById(R.id.m3_button);
        androidImageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(menupage2.this, "it works", Toast.LENGTH_LONG).show();
                m3_button();

            }
        });

        ImageButton androidImageButton4 = (ImageButton) findViewById(R.id.m4_button);
        androidImageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(menupage2.this, "it works", Toast.LENGTH_LONG).show();
                m4_button();

            }
        });

        ImageButton androidImageButton5 = (ImageButton) findViewById(R.id.m5_button);
        androidImageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(menupage2.this, "it works", Toast.LENGTH_LONG).show();
                m5_button();

            }
        });

        ImageButton androidImageButton6 = (ImageButton) findViewById(R.id.m6_button);
        androidImageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(menupage2.this, "it works", Toast.LENGTH_LONG).show();
                m6_button();

            }
        });

        profileImage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent img = new Intent(menupage2.this, MainActivity.class);
                startActivity(img);

            }
        });
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
//                                            startActivity(new Intent(menupage2.this, menupage2.class));
//                                            overridePendingTransition(0, 0);
//                                            Toast.makeText(menupage2.this, "Swiped Right", Toast.LENGTH_SHORT).show();

                                            // textView.setText("Swiped Right");
                                        } else {

                                            // Left Swipe

                                            startActivity(new Intent(menupage2.this, StartPage.class));
                                            overridePendingTransition(0, 0);
                                            Toast.makeText(menupage2.this, "Swiped Left", Toast.LENGTH_SHORT).show();
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
//    private class SwipeListener implements View.OnTouchListener {
//
//        GestureDetector gestureDetector;
//
//        SwipeListener(View view) {
//            int threshold = 100;
//            int velocity_threshold = 100;
//
//
//            GestureDetector.SimpleOnGestureListener listener =
//                    new GestureDetector.SimpleOnGestureListener() {
//                        @Override
//                        public boolean onDown(MotionEvent e) {
//
//                            return true;
//                        }
//
//
//                        @Override
//                        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
//                            float xDiff = e2.getX() - e1.getX();
//                            float yDiff = e2.getY() - e1.getY();
//                            try {
//                                if (Math.abs(xDiff) > Math.abs(yDiff)) {
//                                    if (Math.abs(xDiff) > threshold
//                                            && Math.abs(velocityX) > velocity_threshold) {
//                                        if (xDiff > 0) {
//
//                                            // Right Swipe
//
//                                            //textView.setText("Swiped Right");
//                                        } else {
//
//                                            // Left Swipe
//
//                                            startActivity(new Intent(menupage2.this, StartPage.class));
//                                            overridePendingTransition(0, 0);
//                                            Toast.makeText(menupage2.this, "Swiped Left", Toast.LENGTH_SHORT).show();
//                                            //textView.setText("Swiped Left");
//                                        }
//                                        return true;
//                                    }
//                                } else {
//                                    if (Math.abs(yDiff) > threshold && Math.abs(velocityY) > velocity_threshold) {
//                                        if (yDiff > 0) {
//                                            //textView.setText("Swiped Down");
//                                        } else {
//                                            //textView.setText("Swiped Up");
//                                        }
//                                        return true;
//                                    }
//
//                                }
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                            return false;
//                        }
//                    };
//            gestureDetector = new GestureDetector(listener);
//            view.setOnTouchListener(this);
//
//        }
//
//        @Override
//        public boolean onTouch(View view, MotionEvent motionEvent) {
//            return gestureDetector.onTouchEvent(motionEvent);
//        }
//    }

    public void m1_button() {
        Intent intent1 = new Intent(this, attendance_main.class);
        startActivity(intent1);


    }

    public void m2_button() {
        Intent intent2 = new Intent(this, buses_main.class);
        startActivity(intent2);


    }

    public void m3_button() {
        Intent intent3 = new Intent(this, timetable_main.class);
        startActivity(intent3);


    }

    public void m4_button() {
        Intent intent4 = new Intent(this, notes_main.class);
        startActivity(intent4);


    }

    public void m5_button() {
        Intent intent5 = new Intent(this, room_no.class);
        startActivity(intent5);


    }

    public void m6_button() {
        Intent intent6 = new Intent(this, college_info.class);
        startActivity(intent6);


    }

}