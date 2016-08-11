package com.munir.firelist;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

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
    }

}
