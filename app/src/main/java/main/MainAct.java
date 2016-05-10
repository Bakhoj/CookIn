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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.anders.cookin.R;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import data.Data;
import login.LoginAct;
import login.LoginAct3;

public class MainAct extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
//Firebase mFirebase;

    private static final String TAG = MainAct.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        if(Profile.getCurrentProfile() == null) {
            Intent i = new Intent(this, LoginAct.class);
            startActivity(i);
            finish();
        }
        Data.getInstance().mFirebase.setAndroidContext(this);
        Data.getInstance().mFirebase = new Firebase(getResources().getString(R.string.firebase_url));

        //Firebase.setAndroidContext(this);
        //mFirebase = new Firebase(getResources().getString(R.string.firebase_url));

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
            navigationEmail.setText(Profile.getCurrentProfile().getId());
            navigationPic.setProfileId(Profile.getCurrentProfile().getId());
        }




        //startActivity(new Intent(this, LoginAct.class));

/*        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_content, new MainHostFrag())
                .commit(); */
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
            // Handle the camera action
        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_logout) {
            Data.getInstance().mFirebase.unauth();

            Intent i = new Intent(this, LoginAct.class);
            startActivity(i);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}