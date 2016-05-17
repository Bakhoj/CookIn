package login;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cookin.app.R;
import com.crashlytics.android.Crashlytics;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import data.Data;
import data.User;
import main.MainAct;


public class LoginAct extends AppCompatActivity {

    final String TAG = "Facebook LoginAct";

    private LoginButton mLoginButton;
    private CallbackManager mCallbackManager;
    private Firebase mFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        FacebookSdk.sdkInitialize(getApplicationContext());
        mCallbackManager = CallbackManager.Factory.create();
        mLoginButton = (LoginButton) findViewById(R.id.login_button);

        LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.i(TAG, "Success");

                Data.getInstance().mFirebase.authWithOAuthToken("facebook", AccessToken.getCurrentAccessToken().getToken(), new AuthResultHandler("facebook"));

                Data.getInstance().theUser = new User();
                Data.getInstance().theUser.setUid(Profile.getCurrentProfile().getId());
                Data.getInstance().theUser.setFirstName(Profile.getCurrentProfile().getFirstName());
                Data.getInstance().theUser.setLastName(Profile.getCurrentProfile().getLastName());
                Data.getInstance().theUser.setFullName(Profile.getCurrentProfile().getName());
                Data.getInstance().theUser.setFacebookUri(Profile.getCurrentProfile().getLinkUri().toString());

                Data.getInstance().mFirebase.child("users").child(Data.getInstance().theUser.getUid()).setValue(Data.getInstance().theUser);
                logUser();

                Intent i = new Intent(getApplication(), MainAct.class);
                startActivity(i);
                finish();

            }

            @Override
            public void onCancel() {
                Log.i(TAG, "Cancel");
            }

            @Override
            public void onError(FacebookException error) {
                Log.i(TAG, "Error");
            }
        });
        LoginManager.getInstance().logOut();



        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private class AuthResultHandler implements Firebase.AuthResultHandler {

        private final String provider;

        public AuthResultHandler(String provider) {
            this.provider = provider;
        }

        @Override
        public void onAuthenticated(AuthData authData) {
            Log.i(TAG, provider + " auth successful");
        }

        @Override
        public void onAuthenticationError(FirebaseError firebaseError) {
        }
    }

    private void logUser() {
        // TODO: Use the current user's information
        // You can call any combination of these three methods
        Crashlytics.setUserIdentifier(Data.getInstance().theUser.getUid());
        Crashlytics.setUserEmail(Data.getInstance().theUser.getFacebookUri());
        Crashlytics.setUserName(Data.getInstance().theUser.getFullName());
    }

    public void forceCrash(View view) {
        throw new RuntimeException("This is a crash");
    }


}

