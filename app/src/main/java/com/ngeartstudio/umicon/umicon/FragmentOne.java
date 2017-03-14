package com.ngeartstudio.umicon.umicon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by docotel on 3/2/16.
 */
public class FragmentOne extends Fragment {
    public static FragmentOne newInstance(){
        return new FragmentOne();
    }
    private static final String TAG = "Umicon";
    Button dagang, manufaktur;
    TextView username, email;
    ImageView photo;
    private FirebaseAuth.AuthStateListener authListener;
    private Firebase myFirebaseRef;
    private FirebaseAuth auth;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private CallbackManager callbackManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);

        dagang = (Button) rootView.findViewById(R.id.goDagang);
        manufaktur = (Button) rootView.findViewById(R.id.goManufaktur);
        username = (TextView) rootView.findViewById(R.id.desJasa);
        email = (TextView) rootView.findViewById(R.id.nama);
        photo = (ImageView) rootView.findViewById(R.id.imageView2);
        ;

        //mFirebaseInstance = FirebaseDatabase.getInstance();

        // get reference to 'users' node
//        mFirebaseDatabase = mFirebaseInstance.getReference("users");

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        //get current user
        //final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    for (UserInfo userInfo : user.getProviderData()){
                        Log.d("TAG", userInfo.getProviderId());
                    }
                    username.setText(user.getDisplayName());
                    email.setText(user.getUid());

              //      finish();
                } else {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    //startActivity(new Intent(getActivity(), LoginActivity.class));
                    intent.putExtra("logout", true);
                    startActivity(intent);
                }
            }
        };
        dagang.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getActivity(), DagangActivity.class);
                getActivity().startActivity(intent);
//                signOut();
            }
        });
        return rootView;
    }
    //sign out method
    public void signOut() {
        //auth.signOut();
        auth.getInstance().signOut();
    }

//    @Override
//    public void onResume() {
//        super.onResume();
////        progressBar.setVisibility(View.GONE);
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        auth.addAuthStateListener(authListener);
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (authListener != null) {
//            auth.removeAuthStateListener(authListener);
//        }
//    }
}