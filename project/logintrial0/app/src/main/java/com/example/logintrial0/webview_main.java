package com.example.logintrial0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class webview_main extends AppCompatActivity {

    Button button1;
    Button button2;

    String[] urls = new String[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_main);

        button1 = findViewById(R.id.mbutton1);
        button2 = findViewById(R.id.mbutton2);

        urls[0] ="https://www.google.com";
        urls[1] ="https://www.facebook.com";

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[0]);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),webactivity.class);
                intent.putExtra("links",urls[1]);
                startActivity(intent);
            }
        });
    }
}