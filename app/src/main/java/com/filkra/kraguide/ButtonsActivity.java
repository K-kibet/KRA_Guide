package com.filkra.kraguide;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.button.MaterialButton;


public class ButtonsActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    private FrameLayout adViewContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttons);

        TemplateView nativeAdView = findViewById(R.id.nativeAdView);
        adViewContainer = findViewById(R.id.adViewContainer);
        MaterialButton btnOne = findViewById(R.id.btnOne);
        MaterialButton btnTwo = findViewById(R.id.btnTwo);
        MaterialButton btnThree = findViewById(R.id.btnThree);
        MaterialButton btnFour = findViewById(R.id.btnFour);
        MaterialButton btnFive = findViewById(R.id.btnFive);
        MaterialButton btnSix = findViewById(R.id.btnSix);
        MaterialButton btnSeven = findViewById(R.id.btnSeven);
        MaterialButton btnEight = findViewById(R.id.btnEight);
        MaterialButton btnNine = findViewById(R.id.btnNine);
        MaterialButton btnTen = findViewById(R.id.btnTen);

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent firstActivity = new Intent(ButtonsActivity.this, OneActivity.class);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ButtonsActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            mInterstitialAd = null;
                            startActivity(firstActivity);
                        }
                    });
                } else {
                    startActivity(firstActivity);
                }
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent twoActivity = new Intent(ButtonsActivity.this, TwoActivity.class);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ButtonsActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            mInterstitialAd = null;
                            startActivity(twoActivity);
                        }
                    });
                } else {
                    startActivity(twoActivity);
                }
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent threeActivity = new Intent(ButtonsActivity.this, ThreeActivity.class);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ButtonsActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            mInterstitialAd = null;
                            startActivity(threeActivity);
                        }
                    });
                } else {
                    startActivity(threeActivity);
                }
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent thirteenActivity = new Intent(ButtonsActivity.this, NineActivity.class);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ButtonsActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            mInterstitialAd = null;
                            startActivity(thirteenActivity);
                        }
                    });
                } else {
                    startActivity(thirteenActivity);
                }
            }
        });
        btnTen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fourteenActivity = new Intent(ButtonsActivity.this, TenActivity.class);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ButtonsActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            mInterstitialAd = null;
                            startActivity(fourteenActivity);
                        }
                    });
                } else {
                    startActivity(fourteenActivity);
                }
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fourActivity = new Intent(ButtonsActivity.this, FourActivity.class);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ButtonsActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            mInterstitialAd = null;
                            startActivity(fourActivity);
                        }
                    });
                } else {
                    startActivity(fourActivity);
                }
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fiveActivity = new Intent(ButtonsActivity.this, FiveActivity.class);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ButtonsActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            mInterstitialAd = null;
                            startActivity(fiveActivity);
                        }
                    });
                } else {
                    startActivity(fiveActivity);
                }
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sixActivity = new Intent(ButtonsActivity.this, SixActivity.class);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ButtonsActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            mInterstitialAd = null;
                            startActivity(sixActivity);
                        }
                    });
                } else {
                    startActivity(sixActivity);
                }
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sevenActivity = new Intent(ButtonsActivity.this, SevenActivity.class);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ButtonsActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            mInterstitialAd = null;
                            startActivity(sevenActivity);
                        }
                    });
                } else {
                    startActivity(sevenActivity);
                }
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        Intent nineActivity = new Intent(ButtonsActivity.this, EightActivity.class);
                if (mInterstitialAd != null) {
                    mInterstitialAd.show(ButtonsActivity.this);
                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            mInterstitialAd = null;
                            startActivity(nineActivity);
                        }
                    });
                } else {
                    startActivity(nineActivity);
                }
            }
        });

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

        AdLoader adLoader = new AdLoader.Builder(this, getString(R.string.Native_Ad_Unit))
                .forNativeAd(nativeAdView::setNativeAd).build();

        adLoader.loadAd(new AdRequest.Builder().build());
    }

    private void LoadBanner() {
        AdView adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.Banner_Ad_Unit));
        adViewContainer.removeAllViews();
        adViewContainer.addView(adView);

        AdSize adSize = getAdSize();
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.setAdSize(adSize);
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
}