package login;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.anders.cookin.R;
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
import data.Users;
import main.MainAct;


public class LoginAct extends AppCompatActivity {

    final String TAG = "Facebook LoginAct";

    private LoginButton mLoginButton;
    private CallbackManager mCallbackManager;
    private Firebase mFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


       mFirebase.setAndroidContext(this);
       mFirebase = new Firebase(getResources().getString(R.string.firebase_url));
        //Firebase.setAndroidContext(this);
        //mFirebaseRef = new Firebase(getResources().getString(R.string.firebase_url));

        FacebookSdk.sdkInitialize(getApplicationContext());
        mCallbackManager = CallbackManager.Factory.create();
        mLoginButton = (LoginButton) findViewById(R.id.login_button);

        LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.i(TAG, "Success");

                mFirebase.authWithOAuthToken("facebook", AccessToken.getCurrentAccessToken().getToken(), new AuthResultHandler("facebook"));
                //mFirebase.child("UID").setValue(Profile.getCurrentProfile().getId());
                //mFirebase.child("UID").setValue(Data.getInstance().user);

                Data.getInstance().theUser = new Users();
                Data.getInstance().theUser.setUserID(Profile.getCurrentProfile().getId());
                Data.getInstance().theUser.setFirstName(Profile.getCurrentProfile().getFirstName());
                Data.getInstance().theUser.setLastName(Profile.getCurrentProfile().getLastName());
                Data.getInstance().theUser.setFullName(Profile.getCurrentProfile().getName());
                Data.getInstance().theUser.setFacebookUri(Profile.getCurrentProfile().getLinkUri().toString());

                mFirebase.child("users").child(Data.getInstance().theUser.getUserID()).setValue(Data.getInstance().theUser);
                //mFirebase.child("users").child(Profile.getCurrentProfile().getId()).setValue(Data.getInstance().profils.get(1));
                //mFirebase.child("dinners").setValue(Data.getInstance().dinners);
           //     Data.getInstance().mFirebase.push().setValue(Data.getInstance().dinners.get(0));


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
        mFirebase.onDisconnect();
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
//            mAuthProgressDialog.hide();
            Log.i(TAG, provider + " auth successful");
//            setAuthenticatedUser(authData);
        }

        @Override
        public void onAuthenticationError(FirebaseError firebaseError) {
//            mAuthProgressDialog.hide();
//            showErrorDialog(firebaseError.toString());
        }
    }
}

