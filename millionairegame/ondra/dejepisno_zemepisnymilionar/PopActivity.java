package com.millionairegame.ondra.dejepisno_zemepisnymilionar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.p000v4.view.ViewCompat;
import android.support.p003v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class PopActivity extends AppCompatActivity implements RewardedVideoAdListener {
    int level;
    /* access modifiers changed from: private */
    public RewardedVideoAd mRewardedVideoAd;
    int pomocnapromenna;
    int pomocnapromennap;
    int pomocnapromennat;

    public void onBackPressed() {
    }

    public void onRewardedVideoAdFailedToLoad(int i) {
    }

    public void onRewardedVideoAdLeftApplication() {
    }

    public void onRewardedVideoAdLoaded() {
    }

    public void onRewardedVideoAdOpened() {
    }

    public void onRewardedVideoCompleted() {
    }

    public void onRewardedVideoStarted() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView((int) C1760R.layout.acitivity_pop);
        try {
            setRequestedOrientation(1);
        } catch (IllegalStateException unused) {
        }
        MobileAds.initialize(this, "ca-app-pub-6056957033271627~3965068114");
        this.mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        this.mRewardedVideoAd.setRewardedVideoAdListener(this);
        Bundle extras = getIntent().getExtras();
        this.level = extras.getInt("Level");
        this.pomocnapromenna = extras.getInt("pomocnapromenna");
        this.pomocnapromennap = extras.getInt("pomocnapromennap");
        this.pomocnapromennat = extras.getInt("pomocnapromennat");
        int i = extras.getInt("Castka");
        TextView textView = (TextView) findViewById(C1760R.C1762id.textView);
        if (i == 1000) {
            textView.setText("YOU WON\n 1 000$");
        } else if (i == 2500) {
            textView.setText("YOU WON\n 2 500$");
        } else if (i == 5000) {
            textView.setText("YOU WON\n 5 000$");
        } else if (i == 10000) {
            textView.setText("YOU WON\n 10 000$");
        } else if (i == 20000) {
            textView.setText("YOU WON\n 20 000$");
        } else if (i == 40000) {
            textView.setText("YOU WON\n 40 000$");
        } else if (i == 80000) {
            textView.setText("YOU WON\n 80 000$");
        } else if (i == 160000) {
            textView.setText("YOU WON\n 160 000$");
        } else if (i == 500000) {
            textView.setText("YOU WON\n 500 000$");
        } else if (i == 1000000) {
            textView.setText("YOU WON\n 1 000 000$");
        } else {
            textView.setText("YOU WON\n " + i + "$");
        }
        textView.setGravity(17);
        textView.setShadowLayer(1.0f, -2.0f, 2.0f, ViewCompat.MEASURED_STATE_MASK);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        getWindow().setLayout(displayMetrics.widthPixels * 1, displayMetrics.heightPixels * 1);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 17;
        attributes.x = 0;
        attributes.y = -20;
        getWindow().setAttributes(attributes);
        ((TextView) findViewById(C1760R.C1762id.textView)).setText("YOU WON\n" + i + "$");
        ((Button) findViewById(C1760R.C1762id.backtomenu)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PopActivity.this.startActivity(new Intent(PopActivity.this, MainActivity.class));
            }
        });
        ((Button) findViewById(C1760R.C1762id.newgame)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PopActivity.this.startActivity(new Intent(PopActivity.this, otazka1.class));
            }
        });
        ((Button) findViewById(C1760R.C1762id.video)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (PopActivity.this.mRewardedVideoAd.isLoaded() && PopActivity.this.level != 14) {
                    PopActivity.this.mRewardedVideoAd.show();
                } else if (PopActivity.this.level == 14) {
                    Toast.makeText(PopActivity.this, "We are sorry, you can't watch a video to try again the last question", 1).show();
                } else {
                    Toast.makeText(PopActivity.this, "We are sorry, there is currently no video available", 1).show();
                }
            }
        });
    }

    private void loadRewardedVideoAd() {
        this.mRewardedVideoAd.loadAd("ca-app-pub-6056957033271627/8100699761", new AdRequest.Builder().build());
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.mRewardedVideoAd.pause(this);
        super.onPause();
        Intent intent = new Intent(this, BackgroundSoundService.class);
        intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
        stopService(intent);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        this.mRewardedVideoAd.resume(this);
        super.onResume();
        if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true)).booleanValue()) {
            Intent intent = new Intent(this, BackgroundSoundService.class);
            intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
            startService(intent);
            return;
        }
        Intent intent2 = new Intent(this, BackgroundSoundService.class);
        intent2.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
        stopService(intent2);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            this.mRewardedVideoAd.destroy(this);
        } catch (IllegalStateException unused) {
        }
        super.onDestroy();
    }

    public void onRewarded(RewardItem rewardItem) {
        SharedPreferences sharedPreferences = getSharedPreferences("GAME_DATA", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("MINCE", sharedPreferences.getInt("MINCE", 0) + 1);
        edit.commit();
    }

    public void onRewardedVideoAdClosed() {
        loadRewardedVideoAd();
        SharedPreferences sharedPreferences = getSharedPreferences("GAME_DATA", 0);
        int i = sharedPreferences.getInt("MINCE", 0);
        if (i > 0) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("MINCE", i - 1);
            edit.commit();
            if (this.level == 1) {
                Intent intent = new Intent(this, otazka1.class);
                intent.putExtra("some_key", this.pomocnapromenna);
                intent.putExtra("some_keyp", this.pomocnapromennap);
                intent.putExtra("some_keyt", this.pomocnapromennat);
                startActivity(intent);
            }
            if (this.level == 2) {
                Intent intent2 = new Intent(this, Otazka2.class);
                intent2.putExtra("some_key", this.pomocnapromenna);
                intent2.putExtra("some_keyp", this.pomocnapromennap);
                intent2.putExtra("some_keyt", this.pomocnapromennat);
                startActivity(intent2);
            }
            if (this.level == 3) {
                Intent intent3 = new Intent(this, Otazka3.class);
                intent3.putExtra("some_key2", this.pomocnapromenna);
                intent3.putExtra("some_keyp2", this.pomocnapromennap);
                intent3.putExtra("some_keyt2", this.pomocnapromennat);
                startActivity(intent3);
            }
            if (this.level == 4) {
                Intent intent4 = new Intent(this, Otazka4.class);
                intent4.putExtra("some_key3", this.pomocnapromenna);
                intent4.putExtra("some_keyp3", this.pomocnapromennap);
                intent4.putExtra("some_keyt3", this.pomocnapromennat);
                startActivity(intent4);
            }
            if (this.level == 5) {
                Intent intent5 = new Intent(this, Otazka5.class);
                intent5.putExtra("some_key4", this.pomocnapromenna);
                intent5.putExtra("some_keyp4", this.pomocnapromennap);
                intent5.putExtra("some_keyt4", this.pomocnapromennat);
                startActivity(intent5);
            }
            if (this.level == 6) {
                Intent intent6 = new Intent(this, Otazka6.class);
                intent6.putExtra("some_key5", this.pomocnapromenna);
                intent6.putExtra("some_keyp5", this.pomocnapromennap);
                intent6.putExtra("some_keyt5", this.pomocnapromennat);
                startActivity(intent6);
            }
            if (this.level == 7) {
                Intent intent7 = new Intent(this, Otazka7.class);
                intent7.putExtra("some_key6", this.pomocnapromenna);
                intent7.putExtra("some_keyp6", this.pomocnapromennap);
                intent7.putExtra("some_keyt6", this.pomocnapromennat);
                startActivity(intent7);
            }
            if (this.level == 8) {
                Intent intent8 = new Intent(this, Otazka8.class);
                intent8.putExtra("some_key7", this.pomocnapromenna);
                intent8.putExtra("some_keyp7", this.pomocnapromennap);
                intent8.putExtra("some_keyt7", this.pomocnapromennat);
                startActivity(intent8);
            }
            if (this.level == 9) {
                Intent intent9 = new Intent(this, Otazka9.class);
                intent9.putExtra("some_key8", this.pomocnapromenna);
                intent9.putExtra("some_keyp8", this.pomocnapromennap);
                intent9.putExtra("some_keyt8", this.pomocnapromennat);
                startActivity(intent9);
            }
            if (this.level == 10) {
                Intent intent10 = new Intent(this, Otazka10.class);
                intent10.putExtra("some_key9", this.pomocnapromenna);
                intent10.putExtra("some_keyp9", this.pomocnapromennap);
                intent10.putExtra("some_keyt9", this.pomocnapromennat);
                startActivity(intent10);
            }
            if (this.level == 11) {
                Intent intent11 = new Intent(this, Otazka11.class);
                intent11.putExtra("some_key10", this.pomocnapromenna);
                intent11.putExtra("some_keyp10", this.pomocnapromennap);
                intent11.putExtra("some_keyt10", this.pomocnapromennat);
                startActivity(intent11);
            }
            if (this.level == 12) {
                Intent intent12 = new Intent(this, Otazka12.class);
                intent12.putExtra("some_key11", this.pomocnapromenna);
                intent12.putExtra("some_keyp11", this.pomocnapromennap);
                intent12.putExtra("some_keyt11", this.pomocnapromennat);
                startActivity(intent12);
            }
            if (this.level == 13) {
                Intent intent13 = new Intent(this, Otazka13.class);
                intent13.putExtra("some_key12", this.pomocnapromenna);
                intent13.putExtra("some_keyp12", this.pomocnapromennap);
                intent13.putExtra("some_keyt12", this.pomocnapromennat);
                startActivity(intent13);
                return;
            }
            return;
        }
        startActivity(new Intent(getApplicationContext(), otazka1.class));
    }
}
