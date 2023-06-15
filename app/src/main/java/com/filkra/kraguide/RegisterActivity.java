package com.filkra.kraguide;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.button.MaterialButton;
public class RegisterActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private FrameLayout adViewContainer;
    MaterialButton btnRegister;
    TextView textViewLogin;
    EditText textEmail, textPassword, textUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        adViewContainer = findViewById(R.id.adViewContainer);
        textUsername = findViewById(R.id.textUsername);
        textEmail = findViewById(R.id.textEmail);
        textPassword = findViewById(R.id.textPassword);
        btnRegister = findViewById(R.id.btnRegister);
        textViewLogin = findViewById(R.id.textViewLogin);

        adViewContainer.post(this::LoadBanner);
        AdRequest adRequest = new AdRequest.Builder().build();
        InterstitialAd.load(this,getString(R.string.Interstitial_Ad_Unit), adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                    }
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                    }
                });

        btnRegister.setOnClickListener(v -> handleRegister());
        textViewLogin.setOnClickListener(v ->{
            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(intent);
        });

    }
    private void LoadBanner() {
        AdView adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.Banner_Ad_Unit));
        adViewContainer.removeAllViews();
        adViewContainer.addView(adView);

        AdSize adSize = getAdSize();
        adView.setAdSize(adSize);

        AdRequest adRequest = new AdRequest.Builder().build();

        adView.loadAd(adRequest);
    }

    private AdSize getAdSize() {
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;
        int adWidth = (int) (widthPixels / density);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }


    private void handleRegister () {
        Intent intent = new Intent(this, LoginActivity.class);
        if (!validateUsername() | !validateEmail() | !validatePassword()) {
            return;
        }
        if (mInterstitialAd != null) {
            mInterstitialAd.show(this);
            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent();
                    mInterstitialAd = null;
                    finish();
                    startActivity(intent);
                }
            });
        } else {
            finish();
            startActivity(intent);
        }
    }

    private boolean checkWhiteSpace (String line) {
        for(int i = 0; i < line.length(); i++){
            if(line.charAt(i) == ' '){
                return true;
            }
        }
        return false;
    }

    private boolean validateUsername() {
        String val = textUsername.getText().toString().trim();
        if (val.isEmpty()) {
            textUsername.setError("Field can not be empty");
            return false;
        } else if (val.length() > 20) {
            textUsername.setError("Username is too large!");
            return false;
        } else if (checkWhiteSpace(val)) {
            textUsername.setError("No White spaces are allowed!");
            return false;
        }else {
            textUsername.setError(null);
            return true;
        }
    }

    private boolean validateEmail() {
        String val = textEmail.getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";
        if (val.isEmpty()) {
            textEmail.setError("Field can not be empty");
            return false;
        } else if (!val.matches(checkEmail)) {
            textEmail.setError("Invalid Email!");
            return false;
        } else {
            textEmail.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = textPassword.getText().toString().trim();
        if (val.isEmpty()) {
            textPassword.setError("Field can not be empty");
            return false;
        } else if(val.length() < 6){
            textPassword.setError("Password should contain 6 characters!");
            return false;
        }else {
            textPassword.setError(null);
            return true;
        }
    }
}