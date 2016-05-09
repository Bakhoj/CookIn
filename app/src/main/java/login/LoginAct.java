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
import main.MainAct;


public class LoginAct extends AppCompatActivity {

    final String TAG = "Facebook LoginAct";

    private LoginButton mLoginButton;
    private CallbackManager mCallbackManager;
  //  private Firebase mFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Data.getInstance().mFirebase.setAndroidContext(this);
        Data.getInstance().mFirebase = new Firebase(getResources().getString(R.string.firebase_url));
        //Firebase.setAndroidContext(this);
        //mFirebaseRef = new Firebase(getResources().getString(R.string.firebase_url));

        FacebookSdk.sdkInitialize(getApplicationContext());
        mCallbackManager = CallbackManager.Factory.create();
        mLoginButton = (LoginButton) findViewById(R.id.login_button);

        LoginManager.getInstance().registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.i(TAG, "Success");
                /*Log.i(TAG, Profile.getCurrentProfile().getFirstName());
                Log.i(TAG, Profile.getCurrentProfile().getMiddleName());
                Log.i(TAG, Profile.getCurrentProfile().getLastName());
                Log.i(TAG, Profile.getCurrentProfile().getId());
                Log.i(TAG, Profile.getCurrentProfile().getLinkUri() + "");
                Log.i(TAG, Profile.getCurrentProfile().getProfilePictureUri(24, 240) + "");
                Log.i(TAG, Profile.getCurrentProfile().getName()); */

                //mFirebaseRef.authWithOAuthToken("facebook", token.getToken(), new AuthResultHandler("facebook"));
                Data.getInstance().mFirebase.authWithOAuthToken("facebook", AccessToken.getCurrentAccessToken().getToken(), new AuthResultHandler("facebook"));

//                Log.i(TAG, Data.getInstance().mFirebase.getAuth().toString() + "");
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

