package com.filkra.kraguide;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.button.MaterialButton;

public class TermsActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        CheckBox checkBox = findViewById(R.id.checkBox);
        MaterialButton btnContinue = findViewById(R.id.btnContinue);
        TemplateView nativeAdView = findViewById(R.id.nativeAdView);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!checkBox.isChecked()) {
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(TermsActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                Toast.makeText(TermsActivity.this, "Accept the terms to continue", Toast.LENGTH_SHORT).show();
                            }
                        });
                    } else {
                        Toast.makeText(TermsActivity.this, "Accept the terms to continue", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Intent registerIntent = new Intent(TermsActivity.this, RegisterActivity.class);
                    if (mInterstitialAd != null) {
                        mInterstitialAd.show(TermsActivity.this);
                        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                super.onAdDismissedFullScreenContent();
                                mInterstitialAd = null;
                                startActivity(registerIntent);
                            }
                        });
                    } else {
                        startActivity(registerIntent);
                    }
                }

            }
        });

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

        AdLoader adLoader = new AdLoader.Builder(this, getString(R.string.Native_Ad_Unit))
                .forNativeAd(nativeAdView::setNativeAd).build();

        adLoader.loadAd(new AdRequest.Builder().build());
    }

}