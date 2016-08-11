package com.munir.firelist;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    public static class AddressViewHolder extends RecyclerView.ViewHolder{
        public TextView textName;
        public TextView textAddress;
        public TextView textUrl;
        public AddressViewHolder(View view){
            super(view);
            textName = (TextView)view.findViewById(R.id.textName);
            textAddress = (TextView)view.findViewById(R.id.textAddress);
            textUrl = (TextView)view.findViewById(R.id.textURL);
        }
    }
    public static final String ADRESS = "addresses";
    private static final String TAG = "MainActivity";
    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private DatabaseReference mDatabaseReference;
    private FirebaseRecyclerAdapter<AddressBook,AddressViewHolder> mFirebaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setStackFromEnd(true);
       // mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mFirebaseAdapter = new FirebaseRecyclerAdapter<AddressBook, AddressViewHolder>(
                AddressBook.class,
                R.layout.address_item,
                AddressViewHolder.class,
                mDatabaseReference.child(ADRESS)
        ) {
            @Override
            protected void populateViewHolder(AddressViewHolder viewHolder, AddressBook model, int position) {
                viewHolder.textName.setText(model.getName());
                viewHolder.textAddress.setText(model.getAddress());
                viewHolder.textUrl.setText(model.getUrl());
            }
        };
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mFirebaseAdapter);

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
        Toast.makeText(this, "Google Play Services error.", Toast.LENGTH_SHORT).show();
    }
}
