package com.example.logintrial0;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.net.MalformedURLException;
import java.net.URL;



public class VC_dashboard extends AppCompatActivity {

    EditText secretCodeBox;
    Button joinBtn, shareBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vc_dashboard);

        secretCodeBox = findViewById(R.id.codebox);
        joinBtn = findViewById(R.id.join_button);
        shareBtn = findViewById(R.id.share_button);

       URL serverURL;

       try {
           serverURL = new URL("https://meet.jit.si");

       } catch (MalformedURLException e) {
           e.printStackTrace();
       }

//    JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
//                .setServerURL(new URL("https://meet.jit.si"))
//                .setRoom("test123")
//                .setAudioMuted(false)
//                .setVideoMuted(false)
//                .setAudioOnly(false)
//                .setWelcomePageEnabled(false)
//                .setConfigOverride("requireDisplayName", true)
//                .build();

        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}