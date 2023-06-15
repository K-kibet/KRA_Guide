package com.filkra.kraguide;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;

public class NineActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nine);
        TemplateView nativeAdView = findViewById(R.id.nativeAdView);

        AdLoader adLoader = new AdLoader.Builder(this, getString(R.string.Native_Ad_Unit))
                .forNativeAd(nativeAdView::setNativeAd).build();

        adLoader.loadAd(new AdRequest.Builder().build());
    }
}