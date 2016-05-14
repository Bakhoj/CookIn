package main;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.cookin.app.R;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;
import com.firebase.client.Firebase;

import data.Data;
import data.FireBHandler;
import host.create.HostCreateDinner;
import login.LoginAct;

public class MainAct extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Firebase mFirebase;

    private static final String TAG = MainAct.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        if(Profile.getCurrentProfile() == null) {
            Intent i = new Intent(this, LoginAct.class);
            startActivity(i);
            finish();
        } else {
            Data.getInstance().mFirebase.setAndroidContext(this);
            Data.getInstance().mFirebase = new Firebase(getResources().getString(R.string.firebase_url));

            Firebase.setAndroidContext(this);
            mFirebase = new Firebase(getResources().getString(R.string.firebase_url));

            setContentView(R.layout.main_act);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(toggle);
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(this);

            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.main_content, new ViewpagerFrag())
                        .commit();
            }

            //View headerLayout = navigationView.inflateHeaderView(R.layout.leftmenu_head);
            View headerLayout = navigationView.getHeaderView(0);


            TextView navigationName = (TextView) headerLayout.findViewById(R.id.leftmenu_name);
            TextView navigationEmail = (TextView) headerLayout.findViewById(R.id.leftmenu_email);
            ProfilePictureView navigationPic = (ProfilePictureView) headerLayout.findViewById(R.id.leftmenu_pic);

            if (Profile.getCurrentProfile() != null) {
                navigationName.setText(Profile.getCurrentProfile().getName());
                navigationEmail.setText(Profile.getCurrentProfile().getLastName());
                navigationPic.setProfileId(Profile.getCurrentProfile().getId());
            }
/*        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_content, new MainHostFrag())
                .commit(); */
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_profil) {
            FireBHandler.getInstance().downloadAllDinnersFrom(Profile.getCurrentProfile().getId());
        } else if (id == R.id.nav_history) {
            Data.getInstance().mBanquet.setTitle("NOW WITH BETTER TITLE!");
            FireBHandler.getInstance().updateDinner(Data.getInstance().mBanquet);
        } else if (id == R.id.nav_settings) {
            Intent i = new Intent(this, HostCreateDinner.class);
            startActivity(i);
            finish();

        } else if (id == R.id.nav_logout) {
            Data.getInstance().mFirebase.unauth();

            Intent i = new Intent(this, LoginAct.class);
            startActivity(i);
            finish();
        } else if (id == R.id.nav_allergener) {
            Data.getInstance().mBanquet.setTitle("Some booring title");
            String banquetId = FireBHandler.getInstance().uploadDinner(Data.getInstance().mBanquet);
            Log.i(TAG, "BanquetID: " + banquetId);
/*
            mFirebase.child("dinners").push().setValue(mBanquet);
            mFirebase.child("dinners").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Log.i(TAG, "Amount of Children: " + dataSnapshot.getChildrenCount());
                    for (DataSnapshot postsnapshot: dataSnapshot.getChildren()) {
                        Banquet banquet = postsnapshot.getValue(Banquet.class);
                        Log.i(TAG, postsnapshot.getKey() + " got: " + banquet.getTitle() + " - " + banquet.getDescription());
                    }
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            }); */
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}