package com.cookin.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.amazonaws.mobile.AWSMobileClient;
import com.amazonaws.mobilehelper.auth.IdentityHandler;
import com.amazonaws.mobilehelper.auth.IdentityManager;
import com.amazonaws.mobilehelper.auth.user.IdentityProfile;
import com.cookin.app.R;
import com.crashlytics.android.Crashlytics;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.widget.ProfilePictureView;
import com.firebase.client.Firebase;

import com.cookin.data.Data;
import com.cookin.data.FireBHandler;
import io.fabric.sdk.android.Fabric;
import com.cookin.login.LoginAct;

import java.security.AuthProvider;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainAct extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ActionBarDrawerToggle mActionBarDrawerToggle;

    IdentityManager identityManager;

    public MainAct() {
        Data.getInstance().choice.setMainAct(this);
    }

    private static final String TAG = MainAct.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final AWSMobileClient awsMobileClient = AWSMobileClient.defaultMobileClient();
        identityManager = awsMobileClient.getIdentityManager();

        //Data.getInstance().mFirebase.setAndroidContext(this);
        //Data.getInstance().mFirebase = new Firebase(getResources().getString(R.string.firebase_url));

        //FacebookSdk.sdkInitialize(getApplicationContext());
        //if(Profile.getCurrentProfile() == null) {
         //   Intent i = new Intent(this, LoginAct.class);
           // startActivity(i);
           // finish();
       // } else {

            //Data.getInstance().banquets = FireBHandler.getInstance().downloadAllDinnersExceptFrom(Profile.getCurrentProfile().getId());
            //Data.getInstance().hostBanquets = FireBHandler.getInstance().downloadAllDinnersFrom(Profile.getCurrentProfile().getId());
            //Data.getInstance().mFragmentManager = getSupportFragmentManager();

            setContentView(R.layout.main_act);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            //Data.getInstance().mActionBar = getSupportActionBar();

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
             mActionBarDrawerToggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.setDrawerListener(mActionBarDrawerToggle);
            mActionBarDrawerToggle.syncState();

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

            navigationName.setText(Profile.getCurrentProfile().getName());
            navigationEmail.setText(Profile.getCurrentProfile().getLastName());
            navigationPic.setProfileId(Profile.getCurrentProfile().getId());

        //}
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
        int id = item.getItemId();

        /* Handle the button pressed in the leftmenu */

        switch (item.getItemId()) {
            case R.id.nav_profil:
                break;
            case R.id.nav_history:
                break;
            case R.id.nav_settings:
                break;
            case R.id.nav_logout:
                identityManager.signOut();
                identityManager.signInOrSignUp(this, new SignInHandler());
                finish();
                break;
            case R.id.nav_allergener:
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    
    public ActionBarDrawerToggle getActionBarDrawerToggle(){
        return mActionBarDrawerToggle;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}