package com.example.logintrial0

import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_kotlin_r_ce_sempage.*

class Kotlin_r_e_sempage : AppCompatActivity() {


    lateinit var front_anim: AnimatorSet
    lateinit var back_anim: AnimatorSet
    var isFront = true


    var fAuth: FirebaseAuth? = null
    var fStore: FirebaseFirestore? = null
    var storageReference: StorageReference? = null
    var userId: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_re_sempage)


        fAuth = FirebaseAuth.getInstance()
        val user = fAuth!!.currentUser
        fAuth = FirebaseAuth.getInstance()
        fStore = FirebaseFirestore.getInstance()
        storageReference = FirebaseStorage.getInstance().reference

        val profileRef = storageReference!!.child(
            "users/" + fAuth!!.currentUser!!
                .uid + "/profile.jpg"
        )
        profileRef.downloadUrl.addOnSuccessListener { uri ->
            Picasso.get().load(uri).into(profileImage24)
        }

        profileImage24.setOnClickListener(View.OnClickListener {
            val img = Intent(this, MainActivity::class.java)
            startActivity(img)
        })


        val scale: Float = applicationContext.resources.displayMetrics.density
        r1_room.cameraDistance = 8000 * scale
        r1_room_flip.cameraDistance = 8000 * scale

        r2_room.cameraDistance = 8000 * scale
        r2_room_flip.cameraDistance = 8000 * scale

        r3_room.cameraDistance = 8000 * scale
        r3_room_flip.cameraDistance = 8000 * scale

        r4_room.cameraDistance = 8000 * scale
        r4_room_flip.cameraDistance = 8000 * scale


        front_anim = AnimatorInflater.loadAnimator(applicationContext,R.animator.front_animator1) as AnimatorSet
        back_anim = AnimatorInflater.loadAnimator(applicationContext,R.animator.back_animator) as AnimatorSet


//        flip_btn.setOnClickListener {
//            if (isFront){
//                front_anim.setTarget(r1_room)
//                back_anim.setTarget(r1_room_flip)
//                front_anim.start()
//                back_anim.start()
//                isFront = false
//
//            }else{
//                front_anim.setTarget(r1_room_flip)
//                back_anim.setTarget(r1_room)
//                back_anim.start()
//                front_anim.start()
//                isFront = true
//
//
//            }
//        }

        r1_room.setOnClickListener {
            if (isFront){
                front_anim.setTarget(r1_room)
                back_anim.setTarget(r1_room_flip)
                front_anim.start()
                back_anim.start()
                isFront = false

            }else{
                front_anim.setTarget(r1_room_flip)
                back_anim.setTarget(r1_room)
                back_anim.start()
                front_anim.start()
                isFront = true


            }


        }


        r1_room_flip.setOnClickListener {
            if (isFront){
                front_anim.setTarget(r1_room)
                back_anim.setTarget(r1_room_flip)
                front_anim.start()
                back_anim.start()
                isFront = false

            }else{
                front_anim.setTarget(r1_room_flip)
                back_anim.setTarget(r1_room)
                back_anim.start()
                front_anim.start()
                isFront = true


            }

        }







        r2_room.setOnClickListener {
            if (isFront){
                front_anim.setTarget(r2_room)
                back_anim.setTarget(r2_room_flip)
                front_anim.start()
                back_anim.start()
                isFront = false

            }else{
                front_anim.setTarget(r2_room_flip)
                back_anim.setTarget(r2_room)
                back_anim.start()
                front_anim.start()
                isFront = true


            }


        }


        r2_room_flip.setOnClickListener {
            if (isFront){
                front_anim.setTarget(r2_room)
                back_anim.setTarget(r2_room_flip)
                front_anim.start()
                back_anim.start()
                isFront = false

            }else{
                front_anim.setTarget(r2_room_flip)
                back_anim.setTarget(r2_room)
                back_anim.start()
                front_anim.start()
                isFront = true


            }





            r3_room.setOnClickListener {
                if (isFront){
                    front_anim.setTarget(r3_room)
                    back_anim.setTarget(r3_room_flip)
                    front_anim.start()
                    back_anim.start()
                    isFront = false

                }else{
                    front_anim.setTarget(r3_room_flip)
                    back_anim.setTarget(r3_room)
                    back_anim.start()
                    front_anim.start()
                    isFront = true


                }


            }


            r3_room_flip.setOnClickListener {
                if (isFront){
                    front_anim.setTarget(r3_room)
                    back_anim.setTarget(r3_room_flip)
                    front_anim.start()
                    back_anim.start()
                    isFront = false

                }else{
                    front_anim.setTarget(r3_room_flip)
                    back_anim.setTarget(r3_room)
                    back_anim.start()
                    front_anim.start()
                    isFront = true


                }

            }






            r4_room.setOnClickListener {
                if (isFront){
                    front_anim.setTarget(r4_room)
                    back_anim.setTarget(r4_room_flip)
                    front_anim.start()
                    back_anim.start()
                    isFront = false

                }else{
                    front_anim.setTarget(r4_room_flip)
                    back_anim.setTarget(r4_room)
                    back_anim.start()
                    front_anim.start()
                    isFront = true


                }


            }


            r4_room_flip.setOnClickListener {
                if (isFront){
                    front_anim.setTarget(r4_room)
                    back_anim.setTarget(r4_room_flip)
                    front_anim.start()
                    back_anim.start()
                    isFront = false

                }else{
                    front_anim.setTarget(r4_room_flip)
                    back_anim.setTarget(r4_room)
                    back_anim.start()
                    front_anim.start()
                    isFront = true


                }

            }

        }


    }
}