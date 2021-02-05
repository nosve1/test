package com.millionairegame.ondra.dejepisno_zemepisnymilionar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.p003v7.app.AlertDialog;
import android.support.p003v7.app.AppCompatActivity;
import android.support.p003v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import java.util.ArrayList;
import java.util.Random;
import maes.tech.intentanim.CustomIntent;

public class Otazka13 extends AppCompatActivity implements RewardedVideoAdListener {
    private static boolean activityVisible;
    Button Zvuk;

    /* renamed from: a */
    final int f73a = 0;
    Button a13_1;
    ArrayList<Integer> arl = new ArrayList<>();

    /* renamed from: b */
    final int f74b = 0;
    Button b13_1;
    Button button;
    Button button12_1;
    Button buttonp12_1;
    Button buttont12_1;
    Button c13_1;
    int castka;
    Button d13_1;
    Button dvere;
    RadioGroup fuhrer1;
    boolean gameOver = false;
    TextView havaj_1;
    TextView havaj_2;
    TextView havaj_3;
    TextView havaj_4;

    /* renamed from: i */
    int f75i = 0;
    int[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    TextView label;
    int level = 13;
    int losovane;
    CountDownTimer mCountDownTimer;
    /* access modifiers changed from: private */
    public InterstitialAd mInterstitialAd;
    ProgressBar mProgressBar;
    private RewardedVideoAd mRewardedVideoAd;
    Button novahra;
    TextView otazkau;
    TextView otazkau500k;
    TextView otazkaza;
    int pomocnapromenna13;
    int pomocnapromennap13;
    int pomocnapromennat13;

    /* renamed from: r */
    Random f76r;
    RadioGroup radioGroupreky;
    TextView reky1chyba;
    MediaPlayer spatna;
    TextView textview14;
    TextView textview2;
    TextView textview3;
    TextView textview4;
    TextView textview5;
    TextView textview6;
    TextView textview7;
    TextView textview8;
    TextView textview9;

    /* renamed from: u1 */
    Button f77u1;

    /* renamed from: u2 */
    Button f78u2;

    /* renamed from: u3 */
    Button f79u3;

    /* renamed from: u4 */
    Button f80u4;
    Button unl;
    Button unp;
    Button unt;
    TextView up1;
    TextView up2;
    TextView up3;
    TextView up4;
    boolean uzivatelOdpovedel = true;
    RadioGroup valky1;
    RadioGroup vrchol1;

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
        setContentView((int) C1760R.layout.univerzalni);
        this.arl.clear();
        MobileAds.initialize(this, "ca-app-pub-6056957033271627~3965068114");
        this.mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        this.mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();
        this.mInterstitialAd = new InterstitialAd(this);
        this.mInterstitialAd.setAdUnitId("ca-app-pub-6056957033271627/5548712134");
        this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_13", 0);
        int i = sharedPreferences.getInt("x", -1) + 1;
        System.out.println(i + "!!!!");
        SharedPreferences sharedPreferences2 = getSharedPreferences("zodpovezene_13", 0);
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = sharedPreferences2.getInt("index_" + i2, 0);
        }
        for (int i3 = 0; i3 < this.items.length; i3++) {
            boolean z = false;
            for (int i4 : iArr) {
                if (this.items[i3] == i4) {
                    z = true;
                }
            }
            if (!z) {
                this.arl.add(Integer.valueOf(this.items[i3]));
            }
        }
        this.f76r = new Random();
        this.castka = 0;
        if (this.arl.size() == 0) {
            sharedPreferences.edit().clear().commit();
            sharedPreferences2.edit().clear().commit();
            int i5 = getSharedPreferences("zodpovezene_13", 0).getInt("x", -1) + 1;
            System.out.println(i5 + "!!!!");
            SharedPreferences sharedPreferences3 = getSharedPreferences("zodpovezene_13", 0);
            int[] iArr2 = new int[i5];
            for (int i6 = 0; i6 < i5; i6++) {
                iArr2[i6] = sharedPreferences3.getInt("index_" + i6, 0);
            }
            for (int i7 = 0; i7 < this.items.length; i7++) {
                boolean z2 = false;
                for (int i8 : iArr2) {
                    if (this.items[i7] == i8) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    this.arl.add(Integer.valueOf(this.items[i7]));
                }
            }
        }
        this.losovane = this.f76r.nextInt(this.arl.size());
        this.losovane = this.arl.get(this.losovane).intValue();
        setFinishOnTouchOutside(false);
        this.Zvuk = (Button) findViewById(C1760R.C1762id.zvuk);
        if (!Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true)).booleanValue()) {
            Intent intent = new Intent(this, BackgroundSoundService.class);
            intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
            stopService(intent);
            this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukvypnuto);
        } else {
            Intent intent2 = new Intent(this, BackgroundSoundService.class);
            intent2.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
            startService(intent2);
            this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukzapnuto);
        }
        this.Zvuk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(Otazka13.this);
                Boolean valueOf = Boolean.valueOf(defaultSharedPreferences.getBoolean("ZVUK", true));
                Intent intent = new Intent(Otazka13.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                if (valueOf.booleanValue()) {
                    SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                    edit.putBoolean("ZVUK", false);
                    edit.commit();
                    Otazka13.this.stopService(intent);
                    Otazka13.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukvypnuto);
                    return;
                }
                SharedPreferences.Editor edit2 = defaultSharedPreferences.edit();
                edit2.putBoolean("ZVUK", true);
                edit2.commit();
                Otazka13.this.startService(intent);
                Otazka13.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukzapnuto);
            }
        });
        this.f77u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f77u1.setTextColor(-1);
        this.f77u1.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f78u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f78u2.setTextColor(-1);
        this.f78u2.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f79u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f79u3.setTextColor(-1);
        this.f79u3.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f80u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f80u4.setTextColor(-1);
        this.f80u4.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
        this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
        this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
        this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
        this.up1.setTextColor(-1);
        this.up2.setTextColor(-1);
        this.up3.setTextColor(-1);
        this.up4.setTextColor(-1);
        this.textview7 = (TextView) findViewById(C1760R.C1762id.textView7);
        this.textview7.setTextColor(-1);
        this.otazkaza = (TextView) findViewById(C1760R.C1762id.otazkaza);
        this.otazkaza.setText("500 000$ Question");
        this.mProgressBar = (ProgressBar) findViewById(C1760R.C1762id.progressBar3);
        this.mProgressBar.setProgress(this.f75i);
        this.mCountDownTimer = new CountDownTimer(40000, 1000) {
            public void onTick(long j) {
                Log.v("Log_tag", "Tick of Progress" + Otazka13.this.f75i + j);
                Otazka13 otazka13 = Otazka13.this;
                otazka13.f75i = otazka13.f75i + 1;
                Otazka13.this.mProgressBar.setProgress((Otazka13.this.f75i * 100) / 40);
            }

            public void onFinish() {
                Otazka13.this.f75i++;
                Otazka13.this.mProgressBar.setProgress(100);
                Otazka13.this.uzivatelOdpovedel = false;
                Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 0, 0);
            }
        };
        this.mCountDownTimer.start();
        this.textview2 = (TextView) findViewById(C1760R.C1762id.textView2);
        this.textview2.setText("10K");
        this.textview3 = (TextView) findViewById(C1760R.C1762id.textView3);
        this.textview3.setText("20K");
        this.textview3.setBackgroundResource(C1760R.C1761drawable.textview2);
        this.textview3.setTypeface(Typeface.DEFAULT_BOLD);
        this.textview4 = (TextView) findViewById(C1760R.C1762id.textView4);
        this.textview4.setText("40K");
        this.textview5 = (TextView) findViewById(C1760R.C1762id.textView5);
        this.textview5.setText("80K");
        this.textview6 = (TextView) findViewById(C1760R.C1762id.textView6);
        this.textview6.setText("160K");
        this.textview6.setBackgroundResource(C1760R.C1761drawable.textview);
        this.textview6.setTypeface(Typeface.DEFAULT);
        this.textview7 = (TextView) findViewById(C1760R.C1762id.textView7);
        this.textview7.setText("500K");
        this.textview8 = (TextView) findViewById(C1760R.C1762id.textView8);
        this.textview8.setText("1M");
        this.textview8.setBackgroundResource(C1760R.C1761drawable.textview2);
        this.textview8.setTypeface(Typeface.DEFAULT_BOLD);
        int i9 = getIntent().getExtras().getInt("some_key12");
        int i10 = getIntent().getExtras().getInt("some_keyp12");
        if (getIntent().getExtras().getInt("some_keyt12") == 1) {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(false);
            this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
            this.pomocnapromennat13 = 1;
        } else {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(true);
        }
        if (i10 == 1) {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(false);
            this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
            this.pomocnapromennap13 = 1;
        } else {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(true);
        }
        if (i9 == 1) {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(false);
            this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
            this.pomocnapromenna13 = 1;
        } else {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(true);
        }
        this.f77u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f78u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f79u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f80u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f77u1.setEnabled(true);
        this.f78u2.setEnabled(true);
        this.f79u3.setEnabled(true);
        this.f80u4.setEnabled(true);
        this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
        this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
        this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
        this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
        this.up1.setText("A)");
        this.up2.setText("B)");
        this.up3.setText("C)");
        this.up4.setText("D)");
        if (this.losovane == 1) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Honolulu, the Hawaiian capital is situated on which one of these islands?");
            this.f77u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f77u1.setText("MAUI");
            this.f78u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f78u2.setText("HAWAII");
            this.f79u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f79u3.setText("MOLOKAI");
            this.f80u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f80u4.setText("OAHU");
            this.castka = 3000000;
            this.f80u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f80u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.Spravna(4);
                }
            });
            this.f77u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f77u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f79u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f79u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f78u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f78u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unl.setEnabled(false);
                    Otazka13.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka13.this.up1 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up1);
                    Otazka13.this.up2 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up2);
                    Otazka13.this.up3 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up3);
                    Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                    Otazka13.this.up1.setText("27%");
                    Otazka13.this.up2.setText("20%");
                    Otazka13.this.up3.setText("27%");
                    Otazka13.this.up4.setText("26%");
                    Otazka13.this.pomocnapromenna13 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unp.setEnabled(false);
                    Otazka13.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka13.this.f77u1 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka13.this.f78u2 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka13.this.up1 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up1);
                    Otazka13.this.up2 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up2);
                    Otazka13.this.up1.setVisibility(4);
                    Otazka13.this.up2.setVisibility(4);
                    Otazka13.this.f77u1.setVisibility(4);
                    Otazka13.this.f78u2.setVisibility(4);
                    Otazka13.this.f77u1.setEnabled(false);
                    Otazka13.this.f78u2.setEnabled(false);
                    Otazka13.this.pomocnapromennap13 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unt.setEnabled(false);
                    Otazka13.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka13.this);
                    builder.setMessage((CharSequence) "Andrew: Hey, I have no idea.");
                    builder.create().show();
                    Otazka13.this.pomocnapromennat13 = 1;
                }
            });
        } else if (this.losovane == 2) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these is not used against blood coagulation?");
            this.f77u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f77u1.setText("HEPARIN");
            this.f78u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f78u2.setText("EOSIN");
            this.f79u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f79u3.setText("HIRUDIN");
            this.f80u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f80u4.setText("IXODIN");
            this.castka = 3000000;
            this.f78u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.Spravna(2);
                }
            });
            this.f77u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f79u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f80u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unl.setEnabled(false);
                    Otazka13.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka13.this.up1 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up1);
                    Otazka13.this.up2 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up2);
                    Otazka13.this.up3 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up3);
                    Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                    Otazka13.this.up1.setText("27%");
                    Otazka13.this.up2.setText("28%");
                    Otazka13.this.up3.setText("20%");
                    Otazka13.this.up4.setText("25%");
                    Otazka13.this.pomocnapromenna13 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unp.setEnabled(false);
                    Otazka13.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka13.this.f79u3 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka13.this.f79u3.setEnabled(false);
                    Otazka13.this.f79u3.setVisibility(4);
                    Otazka13.this.f80u4 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka13.this.f80u4.setEnabled(false);
                    Otazka13.this.f80u4.setVisibility(4);
                    Otazka13.this.up3 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up3);
                    Otazka13.this.up3.setVisibility(4);
                    Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                    Otazka13.this.up4.setVisibility(4);
                    Otazka13.this.pomocnapromennap13 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unt.setEnabled(false);
                    Otazka13.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka13.this);
                    builder.setMessage((CharSequence) "Mary: Hey, I just know that Hirudin is the wrong answer..");
                    builder.create().show();
                    Otazka13.this.pomocnapromennat13 = 1;
                }
            });
        } else if (this.losovane == 3) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("If we planted Quercus robur, what would we get?");
            this.f77u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f77u1.setText("TREE");
            this.f78u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f78u2.setText("FLOWER");
            this.f79u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f79u3.setText("VEGETABLE");
            this.f80u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f80u4.setText("CEREAL");
            this.castka = 3000000;
            this.f77u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.Spravna(1);
                }
            });
            this.f78u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f79u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f80u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unl.setEnabled(false);
                    Otazka13.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka13.this.up1 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up1);
                    Otazka13.this.up2 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up2);
                    Otazka13.this.up3 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up3);
                    Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                    Otazka13.this.up1.setText("28%");
                    Otazka13.this.up2.setText("26%");
                    Otazka13.this.up3.setText("24%");
                    Otazka13.this.up4.setText("22%");
                    Otazka13.this.pomocnapromenna13 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unp.setEnabled(false);
                    Otazka13.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka13.this.f80u4 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka13.this.f80u4.setEnabled(false);
                    Otazka13.this.f80u4.setVisibility(4);
                    Otazka13.this.f78u2 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka13.this.f78u2.setEnabled(false);
                    Otazka13.this.f78u2.setVisibility(4);
                    Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                    Otazka13.this.up4.setVisibility(4);
                    Otazka13.this.up2 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up2);
                    Otazka13.this.up2.setVisibility(4);
                    Otazka13.this.pomocnapromennap13 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unt.setEnabled(false);
                    Otazka13.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka13.this);
                    builder.setMessage((CharSequence) "David: Hi, tree is the correct answer.");
                    builder.create().show();
                    Otazka13.this.pomocnapromennat13 = 1;
                }
            });
        } else if (this.losovane == 4) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these mountains is not 8000+ meters tall?");
            this.f77u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f77u1.setText("LHOTSE");
            this.f78u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f78u2.setText("XIXABANGMA");
            this.f79u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f79u3.setText("KANČENDŽUNGA");
            this.f80u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f80u4.setText("RAKAPOŠI");
            this.castka = 3000000;
            this.f80u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.Spravna(4);
                }
            });
            this.f77u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f78u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f79u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unl.setEnabled(false);
                    Otazka13.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka13.this.up1 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up1);
                    Otazka13.this.up2 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up2);
                    Otazka13.this.up3 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up3);
                    Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                    Otazka13.this.up1.setText("24%");
                    Otazka13.this.up2.setText("25%");
                    Otazka13.this.up3.setText("24%");
                    Otazka13.this.up4.setText("27%");
                    Otazka13.this.pomocnapromenna13 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unp.setEnabled(false);
                    Otazka13.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka13.this.f77u1 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka13.this.f77u1.setEnabled(false);
                    Otazka13.this.f77u1.setVisibility(4);
                    Otazka13.this.f79u3 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka13.this.f79u3.setEnabled(false);
                    Otazka13.this.f79u3.setVisibility(4);
                    Otazka13.this.up1 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up1);
                    Otazka13.this.up1.setVisibility(4);
                    Otazka13.this.up3 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up3);
                    Otazka13.this.up3.setVisibility(4);
                    Otazka13.this.pomocnapromennap13 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unt.setEnabled(false);
                    Otazka13.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka13.this);
                    builder.setMessage((CharSequence) "Libor: Čau, 100% za D).");
                    builder.create().show();
                    Otazka13.this.pomocnapromennat13 = 1;
                }
            });
        } else if (this.losovane == 5) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Until which year is the mining of mineral resources banned in Antarctica?");
            this.f77u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f77u1.setText("2028");
            this.f78u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f78u2.setText("2038");
            this.f79u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f79u3.setText("2048");
            this.f80u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f80u4.setText("2068");
            this.castka = 3000000;
            this.f79u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.Spravna(3);
                }
            });
            this.f77u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f78u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f80u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unl.setEnabled(false);
                    Otazka13.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka13.this.up1 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up1);
                    Otazka13.this.up2 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up2);
                    Otazka13.this.up3 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up3);
                    Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                    Otazka13.this.up1.setText("26%");
                    Otazka13.this.up2.setText("26%");
                    Otazka13.this.up3.setText("26%");
                    Otazka13.this.up4.setText("22%");
                    Otazka13.this.pomocnapromenna13 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unp.setEnabled(false);
                    Otazka13.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka13.this.f77u1 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka13.this.f77u1.setEnabled(false);
                    Otazka13.this.f77u1.setVisibility(4);
                    Otazka13.this.f80u4 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka13.this.f80u4.setEnabled(false);
                    Otazka13.this.f80u4.setVisibility(4);
                    Otazka13.this.up1 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up1);
                    Otazka13.this.up1.setVisibility(4);
                    Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                    Otazka13.this.up4.setVisibility(4);
                    Otazka13.this.pomocnapromennap13 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unt.setEnabled(false);
                    Otazka13.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka13.this);
                    builder.setMessage((CharSequence) "Marry: Hello, I have no idea.");
                    builder.create().show();
                    Otazka13.this.pomocnapromennat13 = 1;
                }
            });
        } else if (this.losovane == 6) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these Canadian cities has the least inhabitants?");
            this.f77u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f77u1.setText("MONTREAL");
            this.f78u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f78u2.setText("CALGARY");
            this.f79u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f79u3.setText("OTTAWA");
            this.f80u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f80u4.setText("VANCOUVER");
            this.castka = 3000000;
            this.f80u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.Spravna(4);
                }
            });
            this.f77u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f78u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f79u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unl.setEnabled(false);
                    Otazka13.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka13.this.up1 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up1);
                    Otazka13.this.up2 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up2);
                    Otazka13.this.up3 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up3);
                    Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                    Otazka13.this.up1.setText("27%");
                    Otazka13.this.up2.setText("27%");
                    Otazka13.this.up3.setText("19%");
                    Otazka13.this.up4.setText("27%");
                    Otazka13.this.pomocnapromenna13 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unp.setEnabled(false);
                    Otazka13.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka13.this.f78u2 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka13.this.f78u2.setEnabled(false);
                    Otazka13.this.f78u2.setVisibility(4);
                    Otazka13.this.f77u1 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka13.this.f77u1.setEnabled(false);
                    Otazka13.this.f77u1.setVisibility(4);
                    Otazka13.this.up2 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up2);
                    Otazka13.this.up2.setVisibility(4);
                    Otazka13.this.up1 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up1);
                    Otazka13.this.up1.setVisibility(4);
                    Otazka13.this.pomocnapromennap13 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unt.setEnabled(false);
                    Otazka13.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka13.this);
                    builder.setMessage((CharSequence) "Richard: Čau. Vůbec nevím. Hodně štěstí...");
                    builder.create().show();
                    Otazka13.this.pomocnapromennat13 = 1;
                }
            });
        } else if (this.losovane == 7) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these writers lived the longest?");
            this.f77u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f77u1.setText("PERCY SHELLY");
            this.f78u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f78u2.setText("WALTER SCOTT");
            this.f79u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f79u3.setText("GEORGE BYRON");
            this.f80u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f80u4.setText("OSCAR WILDE");
            this.castka = 3000000;
            this.f78u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.Spravna(2);
                }
            });
            this.f77u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f79u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f80u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unl.setEnabled(false);
                    Otazka13.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka13.this.up1 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up1);
                    Otazka13.this.up2 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up2);
                    Otazka13.this.up3 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up3);
                    Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                    Otazka13.this.up1.setText("4%");
                    Otazka13.this.up2.setText("39%");
                    Otazka13.this.up3.setText("5%");
                    Otazka13.this.up4.setText("52%");
                    Otazka13.this.pomocnapromenna13 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unp.setEnabled(false);
                    Otazka13.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka13.this.f79u3 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka13.this.f79u3.setEnabled(false);
                    Otazka13.this.f79u3.setVisibility(4);
                    Otazka13.this.f80u4 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka13.this.f80u4.setEnabled(false);
                    Otazka13.this.f80u4.setVisibility(4);
                    Otazka13.this.up3 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up3);
                    Otazka13.this.up3.setVisibility(4);
                    Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                    Otazka13.this.up4.setVisibility(4);
                    Otazka13.this.pomocnapromennap13 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unt.setEnabled(false);
                    Otazka13.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka13.this);
                    builder.setMessage((CharSequence) "Jeremy: Hi, I really have no clue.");
                    builder.create().show();
                    Otazka13.this.pomocnapromennat13 = 1;
                }
            });
        } else if (this.losovane == 8) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of the French aircraft carrier powered by nuclear power?");
            this.f77u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f77u1.setText("FORBIN");
            this.f78u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f78u2.setText("CHARLES DE GAULLE");
            this.f79u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f79u3.setText("CHEVALIER PAUL");
            this.f80u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f80u4.setText("DUPLEIX");
            this.castka = 3000000;
            this.f78u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.Spravna(2);
                }
            });
            this.f77u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f79u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f80u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unl.setEnabled(false);
                    Otazka13.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka13.this.up1 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up1);
                    Otazka13.this.up2 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up2);
                    Otazka13.this.up3 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up3);
                    Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                    Otazka13.this.up1.setText("24%");
                    Otazka13.this.up2.setText("25%");
                    Otazka13.this.up3.setText("26%");
                    Otazka13.this.up4.setText("25%");
                    Otazka13.this.pomocnapromenna13 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unp.setEnabled(false);
                    Otazka13.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka13.this.f80u4 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka13.this.f80u4.setEnabled(false);
                    Otazka13.this.f80u4.setVisibility(4);
                    Otazka13.this.f77u1 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka13.this.f77u1.setEnabled(false);
                    Otazka13.this.f77u1.setVisibility(4);
                    Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                    Otazka13.this.up4.setVisibility(4);
                    Otazka13.this.up1 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up1);
                    Otazka13.this.up1.setVisibility(4);
                    Otazka13.this.pomocnapromennap13 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unt.setEnabled(false);
                    Otazka13.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka13.this);
                    builder.setMessage((CharSequence) "Kuba: Čau, nevím.");
                    builder.create().show();
                    Otazka13.this.pomocnapromennat13 = 1;
                }
            });
        } else if (this.losovane == 9) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these internet browsers is being developed by Otello Corporation?");
            this.f77u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f77u1.setText("OPERA");
            this.f78u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f78u2.setText("UC BROWSER");
            this.f79u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f79u3.setText("SAFARI");
            this.f80u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f80u4.setText("MOZILLA FIREFOX");
            this.castka = 3000000;
            this.f77u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.Spravna(1);
                }
            });
            this.f78u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f79u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f80u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unl.setEnabled(false);
                    Otazka13.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka13.this.up1 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up1);
                    Otazka13.this.up2 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up2);
                    Otazka13.this.up3 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up3);
                    Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                    Otazka13.this.up1.setText("30%");
                    Otazka13.this.up2.setText("29%");
                    Otazka13.this.up3.setText("12%");
                    Otazka13.this.up4.setText("29%");
                    Otazka13.this.pomocnapromenna13 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unp.setEnabled(false);
                    Otazka13.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka13.this.f79u3 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka13.this.f79u3.setEnabled(false);
                    Otazka13.this.f79u3.setVisibility(4);
                    Otazka13.this.f80u4 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka13.this.f80u4.setEnabled(false);
                    Otazka13.this.f80u4.setVisibility(4);
                    Otazka13.this.up3 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up3);
                    Otazka13.this.up3.setVisibility(4);
                    Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                    Otazka13.this.up4.setVisibility(4);
                    Otazka13.this.pomocnapromennap13 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unt.setEnabled(false);
                    Otazka13.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka13.this);
                    builder.setMessage((CharSequence) "Jill: Hello, sorry but I don’t know.");
                    builder.create().show();
                    Otazka13.this.pomocnapromennat13 = 1;
                }
            });
        } else if (this.losovane == 10) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of the wolrd’s fastest rollercoaster?");
            this.f77u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f77u1.setText("TOP THRILL DRAGSTER");
            this.f78u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f78u2.setText("RING RACER");
            this.f79u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f79u3.setText("KINGDA KA");
            this.f80u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f80u4.setText("EL TORO");
            this.castka = 3000000;
            this.f78u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.Spravna(2);
                }
            });
            this.f77u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f79u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f80u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unl.setEnabled(false);
                    Otazka13.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka13.this.up1 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up1);
                    Otazka13.this.up2 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up2);
                    Otazka13.this.up3 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up3);
                    Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                    Otazka13.this.up1.setText("24%");
                    Otazka13.this.up2.setText("26%");
                    Otazka13.this.up3.setText("24%");
                    Otazka13.this.up4.setText("26%");
                    Otazka13.this.pomocnapromenna13 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unp.setEnabled(false);
                    Otazka13.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka13.this.f79u3 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka13.this.f79u3.setEnabled(false);
                    Otazka13.this.f79u3.setVisibility(4);
                    Otazka13.this.f80u4 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka13.this.f80u4.setEnabled(false);
                    Otazka13.this.f80u4.setVisibility(4);
                    Otazka13.this.up3 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up3);
                    Otazka13.this.up3.setVisibility(4);
                    Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                    Otazka13.this.up4.setVisibility(4);
                    Otazka13.this.pomocnapromennap13 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unt.setEnabled(false);
                    Otazka13.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka13.this);
                    builder.setMessage((CharSequence) "Dominic: Hello, I have no clue to be honest.");
                    builder.create().show();
                    Otazka13.this.pomocnapromennat13 = 1;
                }
            });
        } else if (this.losovane == 11) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which year did the supertanker Exxon Valdez crash?");
            this.f77u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f77u1.setText("1986");
            this.f78u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f78u2.setText("1989");
            this.f79u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f79u3.setText("1987");
            this.f80u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f80u4.setText("1988");
            this.castka = 3000000;
            this.f78u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.Spravna(2);
                }
            });
            this.f77u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f79u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.f80u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.gameOver2(Otazka13.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka13.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unl.setEnabled(false);
                    Otazka13.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka13.this.up1 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up1);
                    Otazka13.this.up2 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up2);
                    Otazka13.this.up3 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up3);
                    Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                    Otazka13.this.up1.setText("26%");
                    Otazka13.this.up2.setText("26%");
                    Otazka13.this.up3.setText("22%");
                    Otazka13.this.up4.setText("26%");
                    Otazka13.this.pomocnapromenna13 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unp.setEnabled(false);
                    Otazka13.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka13.this.f79u3 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka13.this.f79u3.setEnabled(false);
                    Otazka13.this.f79u3.setVisibility(4);
                    Otazka13.this.f77u1 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka13.this.f77u1.setEnabled(false);
                    Otazka13.this.f77u1.setVisibility(4);
                    Otazka13.this.up3 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up3);
                    Otazka13.this.up3.setVisibility(4);
                    Otazka13.this.up1 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up1);
                    Otazka13.this.up1.setVisibility(4);
                    Otazka13.this.pomocnapromennap13 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka13.this.unt.setEnabled(false);
                    Otazka13.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka13.this);
                    builder.setMessage((CharSequence) "Maggiea: Hello, sorry but I don’t know.");
                    builder.create().show();
                    Otazka13.this.pomocnapromennat13 = 1;
                }
            });
        }
        this.dvere = (Button) findViewById(C1760R.C1762id.dvere);
        this.dvere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Otazka13.this.castka = 3000000;
                Otazka13.this.gameOver();
                if (Otazka13.this.castka > Otazka13.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                    Otazka13.this.highscore(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
                }
            }
        });
    }

    private void loadRewardedVideoAd() {
        this.mRewardedVideoAd.loadAd("ca-app-pub-6056957033271627/8100699761", new AdRequest.Builder().build());
    }

    /* access modifiers changed from: private */
    public void gameOver2(final boolean z, final int i, final int i2) {
        this.gameOver = true;
        this.mCountDownTimer.cancel();
        this.castka = 160000;
        this.f77u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f78u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f79u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f80u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f77u1.setEnabled(false);
        this.f78u2.setEnabled(false);
        this.f79u3.setEnabled(false);
        this.f80u4.setEnabled(false);
        if (i != 0) {
            int parseColor = Color.parseColor("#ffaa00");
            this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
            this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
            this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
            this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
            if (i == 1) {
                this.f77u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f77u1.setTextColor(parseColor);
                this.f77u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up1.setTextColor(parseColor);
            } else if (i == 2) {
                this.f78u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f78u2.setTextColor(parseColor);
                this.f78u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up2.setTextColor(parseColor);
            } else if (i == 3) {
                this.f79u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f79u3.setTextColor(parseColor);
                this.f79u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up3.setTextColor(parseColor);
            } else if (i == 4) {
                this.f80u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f80u4.setTextColor(parseColor);
                this.f80u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up4.setTextColor(parseColor);
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    int parseColor = Color.parseColor("#fcff0202");
                    int parseColor2 = Color.parseColor("#1dc700");
                    Otazka13.this.up1 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up1);
                    Otazka13.this.up2 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up2);
                    Otazka13.this.up3 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up3);
                    Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                    Otazka13.this.f77u1 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka13.this.f78u2 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka13.this.f79u3 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka13.this.f80u4 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f178u4);
                    if (i == 1) {
                        Otazka13.this.f77u1.setTextColor(parseColor);
                        Otazka13.this.f77u1.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka13.this.up1.setTextColor(parseColor);
                    } else if (i == 2) {
                        Otazka13.this.f78u2.setTextColor(parseColor);
                        Otazka13.this.f78u2.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka13.this.up2.setTextColor(parseColor);
                    } else if (i == 3) {
                        Otazka13.this.f79u3.setTextColor(parseColor);
                        Otazka13.this.f79u3.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka13.this.up3.setTextColor(parseColor);
                    } else if (i == 4) {
                        Otazka13.this.f80u4.setTextColor(parseColor);
                        Otazka13.this.f80u4.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka13.this.up4.setTextColor(parseColor);
                    }
                    if (i2 == 1) {
                        Otazka13.this.f77u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka13.this.f77u1.setTextColor(parseColor2);
                        Otazka13.this.up1.setTextColor(parseColor2);
                    } else if (i2 == 2) {
                        Otazka13.this.f78u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka13.this.f78u2.setTextColor(parseColor2);
                        Otazka13.this.up2.setTextColor(parseColor2);
                    } else if (i2 == 3) {
                        Otazka13.this.f79u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka13.this.f79u3.setTextColor(parseColor2);
                        Otazka13.this.up3.setTextColor(parseColor2);
                    } else if (i2 == 4) {
                        Otazka13.this.f80u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka13.this.f80u4.setTextColor(parseColor2);
                        Otazka13.this.up4.setTextColor(parseColor2);
                    }
                    Intent intent = new Intent(Otazka13.this, BackgroundSoundService.class);
                    intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                    Otazka13.this.stopService(intent);
                    Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka13.this).getBoolean("ZVUK", true));
                    Otazka13.this.spatna = MediaPlayer.create(Otazka13.this, C1760R.raw.spatna2);
                    if (z && valueOf.booleanValue()) {
                        Otazka13.this.spatna.start();
                    }
                }
            }, 1500);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Otazka13.this.alertDialog();
                    if (Otazka13.this.mInterstitialAd.isLoaded()) {
                        Otazka13.this.mInterstitialAd.show();
                    }
                }
            }, 3500);
            this.castka = 160000;
            return;
        }
        alertDialog();
    }

    /* access modifiers changed from: private */
    public void gameOver() {
        this.gameOver = true;
        Intent intent = new Intent(this, BackgroundSoundService.class);
        intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
        stopService(intent);
        this.castka = 160000;
        Intent intent2 = new Intent(this, PopActivity.class);
        intent2.putExtra("Level", this.level);
        intent2.putExtra("Castka", this.castka);
        intent2.putExtra("pomocnapromenna", this.pomocnapromenna13);
        intent2.putExtra("pomocnapromennap", this.pomocnapromennap13);
        intent2.putExtra("pomocnapromennat", this.pomocnapromennat13);
        startActivity(intent2);
        this.mCountDownTimer.cancel();
    }

    /* access modifiers changed from: private */
    public void Spravna(final int i) {
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_13", 0);
        int i2 = sharedPreferences.getInt("x", -1) + 1;
        SharedPreferences.Editor edit = getSharedPreferences("zodpovezene_13", 0).edit();
        edit.putInt("index_" + i2, this.losovane);
        edit.commit();
        SharedPreferences.Editor edit2 = sharedPreferences.edit();
        edit2.putInt("x", i2);
        edit2.commit();
        this.mCountDownTimer.cancel();
        int parseColor = Color.parseColor("#ffaa00");
        this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
        this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
        this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
        this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
        this.f77u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f78u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f79u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f80u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f77u1.setEnabled(false);
        this.f78u2.setEnabled(false);
        this.f79u3.setEnabled(false);
        this.f80u4.setEnabled(false);
        if (i == 1) {
            this.f77u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f77u1.setTextColor(parseColor);
            this.f77u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up1.setTextColor(parseColor);
        } else if (i == 2) {
            this.f78u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f78u2.setTextColor(parseColor);
            this.f78u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up2.setTextColor(parseColor);
        } else if (i == 3) {
            this.f79u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f79u3.setTextColor(parseColor);
            this.f79u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up3.setTextColor(parseColor);
        } else {
            this.f80u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f80u4.setTextColor(parseColor);
            this.f80u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up4.setTextColor(parseColor);
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka13.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                Otazka13.this.stopService(intent);
                int parseColor = Color.parseColor("#1dc700");
                Otazka13.this.up1 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up1);
                Otazka13.this.up2 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up2);
                Otazka13.this.up3 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up3);
                Otazka13.this.up4 = (TextView) Otazka13.this.findViewById(C1760R.C1762id.up4);
                if (i == 1) {
                    Otazka13.this.f77u1 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka13.this.f77u1.setTextColor(parseColor);
                    Otazka13.this.f77u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka13.this.up1.setTextColor(parseColor);
                } else if (i == 2) {
                    Otazka13.this.f78u2 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka13.this.f78u2.setTextColor(parseColor);
                    Otazka13.this.f78u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka13.this.up2.setTextColor(parseColor);
                } else if (i == 3) {
                    Otazka13.this.f79u3 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka13.this.f79u3.setTextColor(parseColor);
                    Otazka13.this.f79u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka13.this.up3.setTextColor(parseColor);
                } else {
                    Otazka13.this.f80u4 = (Button) Otazka13.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka13.this.f80u4.setTextColor(parseColor);
                    Otazka13.this.f80u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka13.this.up4.setTextColor(parseColor);
                }
                if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka13.this).getBoolean("ZVUK", true)).booleanValue()) {
                    MediaPlayer.create(Otazka13.this, C1760R.raw.applause2).start();
                }
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka13.this, Otazka14.class);
                intent.putExtra("some_key13", Otazka13.this.pomocnapromenna13);
                intent.putExtra("some_keyp13", Otazka13.this.pomocnapromennap13);
                intent.putExtra("some_keyt13", Otazka13.this.pomocnapromennat13);
                Otazka13.this.startActivity(intent);
                CustomIntent.customType(Otazka13.this, "left-to-right");
            }
        }, 2500);
    }

    /* access modifiers changed from: private */
    public void highscore(int i) {
        if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true)).booleanValue()) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    MediaPlayer.create(Otazka13.this, C1760R.raw.applause7).start();
                }
            }, (long) i);
        }
        SharedPreferences sharedPreferences = getSharedPreferences("GAME_DATA", 0);
        sharedPreferences.getInt("HIGH_SCORE", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("HIGH_SCORE", this.castka);
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
            Intent intent = new Intent(this, Otazka14.class);
            this.mCountDownTimer.cancel();
            intent.putExtra("some_key13", this.pomocnapromenna13);
            intent.putExtra("some_keyp13", this.pomocnapromennap13);
            intent.putExtra("some_keyt13", this.pomocnapromennat13);
            startActivity(intent);
            return;
        }
        startActivity(new Intent(getApplicationContext(), otazka1.class));
    }

    public void onRewarded(RewardItem rewardItem) {
        SharedPreferences sharedPreferences = getSharedPreferences("GAME_DATA", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("MINCE", sharedPreferences.getInt("MINCE", 0) + 1);
        edit.commit();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        activityPaused();
        Intent intent = new Intent(this, BackgroundSoundService.class);
        intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
        stopService(intent);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        activityResumed();
        Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true));
        Intent intent = new Intent(this, BackgroundSoundService.class);
        intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
        if (valueOf.booleanValue()) {
            startService(intent);
        } else {
            stopService(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public void alertDialog() {
        this.castka = 20000;
        if (this.gameOver && isActivityVisible()) {
            Intent intent = new Intent(this, PopActivity.class);
            intent.putExtra("Level", this.level);
            intent.putExtra("Castka", this.castka);
            intent.putExtra("pomocnapromenna", this.pomocnapromenna13);
            intent.putExtra("pomocnapromennap", this.pomocnapromennap13);
            intent.putExtra("pomocnapromennat", this.pomocnapromennat13);
            startActivity(intent);
        }
    }

    public static boolean isActivityVisible() {
        return activityVisible;
    }

    public static void activityResumed() {
        activityVisible = true;
    }

    public static void activityPaused() {
        activityVisible = false;
    }
}
