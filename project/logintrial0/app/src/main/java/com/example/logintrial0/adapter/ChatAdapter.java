package com.example.logintrial0.adapter;

import static com.example.logintrial0.cords.FirebaseCords.mAuth;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.logintrial0.R;
import com.example.logintrial0.model.ChatModel;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.rxjava3.annotations.NonNull;

public class ChatAdapter extends FirestoreRecyclerAdapter<ChatModel, ChatAdapter.ChatViewHolder> {


    public ChatAdapter(@NonNull FirestoreRecyclerOptions<ChatModel> options) {
        super(options);

    }

    @Override
    protected void onBindViewHolder(@NonNull ChatViewHolder holder, int position, @NonNull ChatModel model) {
        holder.message.setText(model.getMessage());
        Glide.with(holder.user_image.getContext().getApplicationContext())
                .load(model.getUser_image_url())
                .into(holder.user_image);

        if (!model.getChat_image().equals("")) {
            Glide.with(holder.chat_image.getContext().getApplicationContext())
                    .load(model.getUser_image_url())
                    .into(holder.chat_image);
            holder.chat_image.setVisibility(View.VISIBLE);
        } else {
            holder.chat_image.setVisibility(View.GONE);
        }

       holder.user_name.setText(model.getUser_name());

    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, parent, false);
        return new ChatViewHolder(view);

    }

    class ChatViewHolder extends RecyclerView.ViewHolder {

//        ImageView user_image12;
//        FirebaseAuth fAuth;
//        FirebaseFirestore fStore;
//        StorageReference storageReference;
//        String userId;




        TextView message,user_name;
        CircleImageView user_image;
        ImageView chat_image;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);


//            fAuth = FirebaseAuth.getInstance();
//            FirebaseUser user = fAuth.getCurrentUser();
//            fAuth = FirebaseAuth.getInstance();
//            fStore = FirebaseFirestore.getInstance();
//            storageReference = FirebaseStorage.getInstance().getReference();
//
//            StorageReference profileRef = storageReference.child("users/" + fAuth.getCurrentUser().getUid() + "/profile.jpg");
//            profileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                @Override
//                public void onSuccess(Uri uri) {
//                    Picasso.get().load(uri).into(user_image12);
//                }
//            });

//            user_image12 = itemView.findViewById(R.id.user_image12);
            message = itemView.findViewById(R.id.message);
            user_image = itemView.findViewById(R.id.user_image);
            chat_image = itemView.findViewById(R.id.chat_image);
            user_name = itemView.findViewById(R.id.userID);
        }

        FirebaseUser user = mAuth.getCurrentUser();

    }



}
