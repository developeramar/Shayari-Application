package com.andajeshayarana;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.andajeshayarana.class_storage.Bewfai;
import com.andajeshayarana.class_storage.Devotional;
import com.andajeshayarana.class_storage.Dialog;
import com.andajeshayarana.class_storage.Feelings;
import com.andajeshayarana.class_storage.Good_morning;
import com.andajeshayarana.class_storage.Good_night;
import com.andajeshayarana.class_storage.Love;
import com.andajeshayarana.class_storage.Motivational;
import com.andajeshayarana.class_storage.Romantic;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Categories_Activity extends AppCompatActivity implements View.OnClickListener {

    private AdView mAdView;

    TextView tvlove,tvRomantic,tvSad,bewfai,good_morning,goodnight,devotional,motivational,dialog,feelings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
            getSupportActionBar().hide();

        tvlove=findViewById(R.id.tvlove);
        tvRomantic=findViewById(R.id.tvRomantic);

        bewfai=findViewById(R.id.bewfai);
        good_morning=findViewById(R.id.good_morning);
        goodnight=findViewById(R.id.goodnight);
        devotional=findViewById(R.id.devotional_1);
        motivational=findViewById(R.id.motivation_1);
        dialog=findViewById(R.id.diolog);
        feelings=findViewById(R.id.feelings);
//        memes=findViewById(R.id.memes);

        tvlove.setOnClickListener(this);
        tvRomantic.setOnClickListener(this);

        bewfai.setOnClickListener(this);
        goodnight.setOnClickListener(this);
        good_morning.setOnClickListener(this);
        devotional.setOnClickListener(this);
        motivational.setOnClickListener(this);
        dialog.setOnClickListener(this);
        feelings.setOnClickListener(this);
//        memes.setOnClickListener(this);





        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.

                super.onAdClicked();
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.

                super.onAdFailedToLoad(adError);
                mAdView.loadAd(adRequest);
            }

            @Override
            public void onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
                super.onAdImpression();
            }

            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.

                super.onAdLoaded();
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.

                super.onAdOpened();
            }
        });




    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tvlove:
                Intent intent1=new Intent(Categories_Activity.this, Love.class);
                startActivity(intent1);
                break;
            case R.id.tvRomantic:
                Intent intent2=new Intent(Categories_Activity.this, Romantic.class);
                startActivity(intent2);
                break;



            case R.id.bewfai:

                Intent intent4=new Intent(Categories_Activity.this, Bewfai.class);
                startActivity(intent4);
                break;

            case R.id.good_morning:

                Intent intent5=new Intent(Categories_Activity.this, Good_morning.class);
                startActivity(intent5);
                break;

            case R.id.goodnight:

                Intent intent6=new Intent(Categories_Activity.this, Good_night.class);
                startActivity(intent6);
                break;

            case R.id.diolog:

                Intent intent7=new Intent(Categories_Activity.this, Dialog.class);
                startActivity(intent7);
                break;

            case R.id.motivation_1:

                Intent intent8=new Intent(Categories_Activity.this, Motivational.class);
                startActivity(intent8);
                break;

            case R.id.devotional_1:

                Intent intent9=new Intent(Categories_Activity.this, Devotional.class);
                startActivity(intent9);
                break;

//            case R.id.memes:
//
//                Intent intent11=new Intent(Categories_Activity.this, Memes.class);
//                startActivity(intent11);
//                break;

            case R.id.feelings:

                Intent intent10=new Intent(Categories_Activity.this, Feelings.class);
                startActivity(intent10);
                break;

        }





    }
}