package com.example.logintrial0;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Objects;

public class MymessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        super.onMessageReceived(message);
        showNotification(Objects.requireNonNull(message.getNotification()).getTitle(),message.getNotification().getBody());
        //showNotification(message.getNotification().getTitle(),message.getNotification().getBody());
    }

    public void showNotification(String title , String message){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"MyNotifications")
        .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_stat_name)
                .setAutoCancel(true)
                .setContentText(message);

        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(999,builder.build());

    }
}
