package com.example.logintrial0.cords;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class FirebaseCords1 {

    public static final FirebaseFirestore firebase = FirebaseFirestore.getInstance();
    public static final FirebaseAuth mAuth = FirebaseAuth.getInstance();


    public static final CollectionReference MAIN_CHAT_DATABASE1 = firebase.collection("CHAT1");

}
