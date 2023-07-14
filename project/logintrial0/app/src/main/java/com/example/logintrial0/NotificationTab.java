package com.example.logintrial0;

import static com.example.logintrial0.cords.FirebaseCords1.MAIN_CHAT_DATABASE1;
import static com.example.logintrial0.cords.FirebaseCords1.mAuth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.logintrial0.adapter.ChatAdapter1;
import com.example.logintrial0.model.ChatModel1;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
//import com.theartofdev.edmodo.cropper.CropImage;
//import com.theartofdev.edmodo.cropper.CropImageView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;


public class NotificationTab extends AppCompatActivity {

    public static final String TAG = "TAG";

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            startActivity(new Intent(this, login.class));
            finish();
        }

        chatAdapter1.startListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                mAuth.signOut();
                startActivity(new Intent(this, login.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    //    Toolbar toolbar;
    EditText chat_box;
    RecyclerView chat_list;
    EditText ProfileImageFirebase1;
    TextView userName21;
    Uri imageUri;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    StorageReference storageReference;
    String userId;

    ChatAdapter1 chatAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_tab);


        FirebaseMessaging.getInstance().subscribeToTopic("global_chat1");

//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        chat_box = findViewById(R.id.chat_box);
        userName21 = findViewById(R.id.username21);
        ProfileImageFirebase1 = findViewById(R.id.profileImageFirebase1);
        chat_list = findViewById(R.id.chat_list);

        initChatList();

        Intent data = getIntent();
        String downloadUrl = data.getStringExtra("downloadUrl");
        ProfileImageFirebase1.setText(downloadUrl);
        Log.d(TAG, "onCreate: " + downloadUrl);


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
                    userName21.setText(documentSnapshot.getString("fName"));
                } else {
                    Log.d("TAG", "onEvent: document do not exists");
                }
            }
        });
    }

    private void initChatList() {
        chat_list.setHasFixedSize(true);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
//        layoutManager.setStackFromEnd(true);
//        chat_list.setLayoutManager(layoutManager);
//


        chat_list.setLayoutManager((new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true)));


//        chat_list.getLayoutManager().scrollToPosition(chatAdapter1.getItemCount() -1);
//        chat_list.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
//            @Override
//            public void onLayoutChange(View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
//                if (chat_list != null) {
//                    if (bottom < oldBottom) {
//                        chat_list.smoothScrollToPosition(chatAdapter1.getItemCount() - 1);
//
//                    }
//                }
//            }
//        });


        Query query = MAIN_CHAT_DATABASE1.orderBy("timestamp", Query.Direction.ASCENDING);
        FirestoreRecyclerOptions<ChatModel1> option = new FirestoreRecyclerOptions.Builder<ChatModel1>()
                .setQuery(query, ChatModel1.class)
                .build();
        chatAdapter1 = new ChatAdapter1(option);
        chat_list.setAdapter(chatAdapter1);
        chatAdapter1.startListening();


    }

    public void addMessage1(View view) {
        String message = chat_box.getText().toString();
        String user_image_url = ProfileImageFirebase1.getText().toString();
        String username211 = userName21.getText().toString();

        FirebaseUser user = mAuth.getCurrentUser();
        if (!TextUtils.isEmpty(message)) {

            Date today = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String messageID = format.format(today);


//            String user_image_url = "";
//            Uri photoUrl = user.getPhotoUrl();
//            String originalUrl = "s96-c/photo.jpg";
//            String resizeImageUrl = "s400-c/photo.jpg";
//            if (photoUrl != null) {
//                String photoPath = photoUrl.toString();
//                user_image_url = photoPath.replace(originalUrl, resizeImageUrl);
//            }

            HashMap<String, Object> messageObj = new HashMap<>();
            messageObj.put("message", message);
            messageObj.put("user_name", username211);
            messageObj.put("timestamp", FieldValue.serverTimestamp());
            messageObj.put("messageID", messageID);
            messageObj.put("chat_image", "");
            messageObj.put("user_image_url", user_image_url);


            MAIN_CHAT_DATABASE1.document(messageID).set(messageObj).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        FirebaseMessaging.getInstance().unsubscribeFromTopic("global_chat1");
                        //Toast.makeText(MainActivity.this, "Message Send", Toast.LENGTH_SHORT).show();
                       // SendPushNotification1 sendPushNotification1 = new SendPushNotification1(NotificationTab.this);
                       // sendPushNotification1.startPush(username211, message, "global_chat1");
                        chat_box.setText("");
                    } else {
                        Toast.makeText(NotificationTab.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }


//    public void OpenExplorer1(View view) {
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) ==
//                PackageManager.PERMISSION_GRANTED) {
//            ChoseImage();
//        } else {
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 20);
//
//
//            } else {
//                Toast.makeText(this, "Storage Permission Needed", Toast.LENGTH_SHORT).show();
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 20);
//            }
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == 20) {
//            if (grantResults.length == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
//                ChoseImage();
//            } else {
//                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//


//
//    private void ChoseImage() {
//        CropImage.activity()
//                .setGuidelines(CropImageView.Guidelines.ON)
//                .start(NotificationTab.this);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
//            CropImage.ActivityResult result = CropImage.getActivityResult(data);
//            if (resultCode == RESULT_OK) {
//                if (result == null) throw new AssertionError();
//                imageUri = result.getUri();
//                startActivity(new Intent(NotificationTab.this, ImageUploadPreview.class)
//                        .putExtra("image_uri", imageUri.toString()));
//            } else if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
//                Toast.makeText(this, result.getError().getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//
//
//


    public void Finish1(View view) {
        finish();
    }

}