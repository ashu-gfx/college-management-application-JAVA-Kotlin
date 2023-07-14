package com.example.logintrial0;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.Timer;
import java.util.TimerTask;

public class Splash_screen extends AppCompatActivity {


    private static final String TAG = "tag";
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        FirebaseMessaging.getInstance().subscribeToTopic("notification");
        FirebaseMessaging.getInstance().subscribeToTopic("notify");



      if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
          NotificationChannel channel =
                  new NotificationChannel("MyNotifications","MyNotifications", NotificationManager.IMPORTANCE_DEFAULT);

          NotificationManager manager = getSystemService((NotificationManager.class));
          manager.createNotificationChannel(channel);
      }

        FirebaseMessaging.getInstance().subscribeToTopic("college")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Successfull";
                        if (!task.isSuccessful()) {
                            msg = "Failed";
                        }
                        Log.d(TAG, msg);
                        Toast.makeText(Splash_screen.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });


        timer= new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent= new Intent(Splash_screen.this, Register.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}