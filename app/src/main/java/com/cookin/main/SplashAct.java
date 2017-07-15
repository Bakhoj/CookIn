package com.cookin.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.amazonaws.mobile.AWSMobileClient;
import com.amazonaws.mobilehelper.auth.IdentityManager;
import com.amazonaws.mobilehelper.auth.IdentityProvider;
import com.amazonaws.mobilehelper.auth.StartupAuthErrorDetails;
import com.amazonaws.mobilehelper.auth.StartupAuthResult;
import com.amazonaws.mobilehelper.auth.StartupAuthResultHandler;
import com.amazonaws.mobilehelper.auth.signin.AuthException;
import com.cookin.app.R;

public class SplashAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        AWSMobileClient.initializeMobileClientIfNecessary(getApplicationContext());
        final IdentityManager identityManager = AWSMobileClient.defaultMobileClient().getIdentityManager();

        identityManager.doStartupAuth(this, authResultHandler, 2000);
    }

    private final StartupAuthResultHandler authResultHandler = new StartupAuthResultHandler() {

        @Override
        public void onComplete(StartupAuthResult authResult) {
            final IdentityManager identityManager = authResult.getIdentityManager();

            if (authResult.isUserSignedIn()) {
                final IdentityProvider provider = identityManager.getCurrentIdentityProvider();
            } else {
                final StartupAuthErrorDetails errors = authResult.getErrorDetails();

                if (errors.didErrorOccurRefreshingProvider()) {
                    final AuthException providerAuthException = errors.getProviderRefreshException();
                    Log.w("SplashAct", String.format(
                            "Credentials for Previously signed-in provider %s could not be refreshed.",
                            providerAuthException.getProvider().getDisplayName()), providerAuthException);
                }
                doMandatorySignIn(identityManager);
                return;
            }

            goMain(SplashAct.this);
        }
    };

    private void doMandatorySignIn(final IdentityManager identityManager) {
        identityManager.signInOrSignUp(SplashAct.this, new SignInHandler());
        SplashAct.this.finish();
    }

    /** Go to the main activity. */
    private void goMain(final Activity callingActivity) {
        callingActivity.startActivity(new Intent(callingActivity, MainAct.class)
                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
        callingActivity.finish();
    }

}
