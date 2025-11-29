package com.example.smarthealthapp.auth

import android.app.Activity
import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.example.smarthealthapp.R

object GoogleSignInHelper {
    private var googleSignInClient: GoogleSignInClient? = null

    fun getClient(context: Context): GoogleSignInClient {
        if (googleSignInClient == null) {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

            googleSignInClient = GoogleSignIn.getClient(context, gso)
        }
        return googleSignInClient!!
    }

    fun signIn(activity: Activity, requestCode: Int) {
        val signInIntent: Intent = getClient(activity).signInIntent
        activity.startActivityForResult(signInIntent, requestCode)
    }

    fun signOut(context: Context, onComplete: () -> Unit) {
        getClient(context).signOut().addOnCompleteListener {
            onComplete()
        }
    }
}
