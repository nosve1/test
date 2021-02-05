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

public class Otazka9 extends AppCompatActivity implements RewardedVideoAdListener {
    private static boolean activityVisible;
    Button Zvuk;

    /* renamed from: a */
    final int f163a = 0;

    /* renamed from: a7 */
    Button f164a7;
    Button a7p;
    ArrayList<Integer> arl = new ArrayList<>();

    /* renamed from: b */
    final int f165b = 0;

    /* renamed from: b7 */
    Button f166b7;
    Button button8_1;
    Button buttonp8_1;
    Button buttont8_1;

    /* renamed from: c7 */
    Button f167c7;
    Button c7p;
    int castka;

    /* renamed from: d7 */
    Button f168d7;
    Button dvere;
    RadioGroup fuhrer1;
    boolean gameOver = false;

    /* renamed from: i */
    int f169i = 0;
    int[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
    TextView label;
    int level = 9;
    int losovane;
    CountDownTimer mCountDownTimer;
    /* access modifiers changed from: private */
    public InterstitialAd mInterstitialAd;
    ProgressBar mProgressBar;
    private RewardedVideoAd mRewardedVideoAd;
    Button novahra;
    TextView otazka2;
    TextView otazkau;
    TextView otazkau500k;
    TextView otazkaza;
    int pomocnapromenna9;
    int pomocnapromennap9;
    int pomocnapromennat9;
    TextView procent1;
    TextView procent2;
    TextView procent3;
    TextView procent4;

    /* renamed from: r */
    Random f170r;
    RadioGroup radioGroupreky;
    TextView reky1chyba;
    MediaPlayer spatna;
    TextView textview10;
    TextView textview2;
    TextView textview3;
    TextView textview4;
    TextView textview5;
    TextView textview6;
    TextView textview7;
    TextView textview8;
    TextView textview9;

    /* renamed from: u1 */
    Button f171u1;

    /* renamed from: u2 */
    Button f172u2;

    /* renamed from: u3 */
    Button f173u3;

    /* renamed from: u4 */
    Button f174u4;
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
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_9", 0);
        int i = sharedPreferences.getInt("x", -1) + 1;
        System.out.println(i + "!!!!");
        SharedPreferences sharedPreferences2 = getSharedPreferences("zodpovezene_9", 0);
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
        this.f170r = new Random();
        this.castka = 0;
        if (this.arl.size() == 0) {
            sharedPreferences.edit().clear().commit();
            sharedPreferences2.edit().clear().commit();
            int i5 = getSharedPreferences("zodpovezene_9", 0).getInt("x", -1) + 1;
            System.out.println(i5 + "!!!!");
            SharedPreferences sharedPreferences3 = getSharedPreferences("zodpovezene_9", 0);
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
        this.losovane = this.f170r.nextInt(this.arl.size());
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
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(Otazka9.this);
                Boolean valueOf = Boolean.valueOf(defaultSharedPreferences.getBoolean("ZVUK", true));
                Intent intent = new Intent(Otazka9.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                if (valueOf.booleanValue()) {
                    SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                    edit.putBoolean("ZVUK", false);
                    edit.commit();
                    Otazka9.this.stopService(intent);
                    Otazka9.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukvypnuto);
                    return;
                }
                SharedPreferences.Editor edit2 = defaultSharedPreferences.edit();
                edit2.putBoolean("ZVUK", true);
                edit2.commit();
                Otazka9.this.startService(intent);
                Otazka9.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukzapnuto);
            }
        });
        this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f171u1.setTextColor(-1);
        this.f171u1.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f172u2.setTextColor(-1);
        this.f172u2.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f173u3.setTextColor(-1);
        this.f173u3.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f174u4.setTextColor(-1);
        this.f174u4.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
        this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
        this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
        this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
        this.up1.setTextColor(-1);
        this.up2.setTextColor(-1);
        this.up3.setTextColor(-1);
        this.up4.setTextColor(-1);
        this.textview5 = (TextView) findViewById(C1760R.C1762id.textView5);
        this.textview5.setTextColor(-1);
        this.textview2 = (TextView) findViewById(C1760R.C1762id.textView2);
        this.textview2.setText("2K");
        this.textview2.setBackgroundResource(C1760R.C1761drawable.textview);
        this.textview2.setTypeface(Typeface.DEFAULT);
        this.textview3 = (TextView) findViewById(C1760R.C1762id.textView3);
        this.textview3.setText("5K");
        this.textview4 = (TextView) findViewById(C1760R.C1762id.textView4);
        this.textview4.setText("10K");
        this.textview5 = (TextView) findViewById(C1760R.C1762id.textView5);
        this.textview5.setText("20K");
        this.textview5.setBackgroundResource(C1760R.C1761drawable.textview2);
        this.textview5.setTypeface(Typeface.DEFAULT_BOLD);
        this.textview6 = (TextView) findViewById(C1760R.C1762id.textView6);
        this.textview6.setText("40K");
        this.textview6.setBackgroundResource(C1760R.C1761drawable.textview);
        this.textview6.setTypeface(Typeface.DEFAULT);
        this.textview7 = (TextView) findViewById(C1760R.C1762id.textView7);
        this.textview7.setText("80K");
        this.textview8 = (TextView) findViewById(C1760R.C1762id.textView8);
        this.textview8.setText("160K");
        this.otazkaza = (TextView) findViewById(C1760R.C1762id.otazkaza);
        this.otazkaza.setText("20 000$ Question");
        this.mProgressBar = (ProgressBar) findViewById(C1760R.C1762id.progressBar3);
        this.mProgressBar.setProgress(this.f169i);
        this.mCountDownTimer = new CountDownTimer(40000, 1000) {
            public void onTick(long j) {
                Log.v("Log_tag", "Tick of Progress" + Otazka9.this.f169i + j);
                Otazka9 otazka9 = Otazka9.this;
                otazka9.f169i = otazka9.f169i + 1;
                Otazka9.this.mProgressBar.setProgress((Otazka9.this.f169i * 100) / 40);
            }

            public void onFinish() {
                Otazka9.this.f169i++;
                Otazka9.this.mProgressBar.setProgress(100);
                Otazka9.this.uzivatelOdpovedel = false;
                Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 0, 0);
            }
        };
        this.mCountDownTimer.start();
        int i9 = getIntent().getExtras().getInt("some_key8");
        int i10 = getIntent().getExtras().getInt("some_keyp8");
        if (getIntent().getExtras().getInt("some_keyt8") == 1) {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(false);
            this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
            this.pomocnapromennat9 = 1;
        } else {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(true);
        }
        if (i10 == 1) {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(false);
            this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
            this.pomocnapromennap9 = 1;
        } else {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(true);
        }
        if (i9 == 1) {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(false);
            this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
            this.pomocnapromenna9 = 1;
        } else {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(true);
        }
        this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f171u1.setEnabled(true);
        this.f172u2.setEnabled(true);
        this.f173u3.setEnabled(true);
        this.f174u4.setEnabled(true);
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
            this.otazkau.setText("Which offensive did the Germans use to try and win WW1?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("FRIDRIECH");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("LUDENDORFF");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("MARWITZ");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("RASCHOV");
            this.castka = 10000;
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(2);
                }
            });
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 0);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 0);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 0);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("22%");
                    Otazka9.this.up2.setText("29%");
                    Otazka9.this.up3.setText("25%");
                    Otazka9.this.up4.setText("24%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f171u1 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka9.this.f173u3 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up1.setVisibility(4);
                    Otazka9.this.up3.setVisibility(4);
                    Otazka9.this.f171u1.setVisibility(4);
                    Otazka9.this.f173u3.setVisibility(4);
                    Otazka9.this.f171u1.setEnabled(false);
                    Otazka9.this.f173u3.setEnabled(false);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Peter: I know this one, Ludendorff is the correct answer.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 2) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these gems were the favourite of an Egyptian pharaoh Cleopatra VII?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("RUBIES");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("EMERALDS");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("DIAMONDS");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("SAPHIRES");
            this.castka = 80000;
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(2);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 0);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 0);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 0);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("21%");
                    Otazka9.this.up2.setText("31%");
                    Otazka9.this.up3.setText("22%");
                    Otazka9.this.up4.setText("26%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.f173u3 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka9.this.f173u3.setEnabled(false);
                    Otazka9.this.f173u3.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up3.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Damian: Hey, the answer is either emeralds or saphires.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 3) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these rulers issued the Edict of Nantes in 1598?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("HENRY VII");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("LOUIS XIII");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("LOUIS XIV");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("HENRY IV");
            this.castka = 80000;
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(4);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("27%");
                    Otazka9.this.up2.setText("21%");
                    Otazka9.this.up3.setText("23%");
                    Otazka9.this.up4.setText("29%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f172u2 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka9.this.f172u2.setEnabled(false);
                    Otazka9.this.f172u2.setVisibility(4);
                    Otazka9.this.f173u3 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka9.this.f173u3.setEnabled(false);
                    Otazka9.this.f173u3.setVisibility(4);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up2.setVisibility(4);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up3.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Marc: Hi, it was Henry IV.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 4) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these countries does not have 3 stripes in it’s flag?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("CONGO");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("MYANMAR");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("BANGLADESH");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("SYRIA");
            this.castka = 80000;
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(3);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("25%");
                    Otazka9.this.up2.setText("27%");
                    Otazka9.this.up3.setText("27%");
                    Otazka9.this.up4.setText("21%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f172u2 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka9.this.f172u2.setEnabled(false);
                    Otazka9.this.f172u2.setVisibility(4);
                    Otazka9.this.f171u1 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka9.this.f171u1.setEnabled(false);
                    Otazka9.this.f171u1.setVisibility(4);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up2.setVisibility(4);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up1.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Charles: Hello, I’m sorry bot I don’t know.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 5) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these cities was hit by a large scale fire in 1666?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("PARIS");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("VENICE");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("LONDON");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("FLORENCE");
            this.castka = 80000;
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(3);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("31%");
                    Otazka9.this.up2.setText("11%");
                    Otazka9.this.up3.setText("33%");
                    Otazka9.this.up4.setText("25%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f171u1 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka9.this.f171u1.setEnabled(false);
                    Otazka9.this.f171u1.setVisibility(4);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up1.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Paul: Hi, it was London in my opinion.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 6) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many organ systems does human have?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("9");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("11");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("13");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("14");
            this.castka = 80000;
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(2);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("4%");
                    Otazka9.this.up2.setText("36%");
                    Otazka9.this.up3.setText("33%");
                    Otazka9.this.up4.setText("27%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f171u1 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka9.this.f171u1.setEnabled(false);
                    Otazka9.this.f171u1.setVisibility(4);
                    Otazka9.this.f173u3 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka9.this.f173u3.setEnabled(false);
                    Otazka9.this.f173u3.setVisibility(4);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up1.setVisibility(4);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up3.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Jeffrey: Hello, I am sorry but I can not help you with this one.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 7) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of the oldest epic poem?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("BRUNHILDA OF AUSTRASIA");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("RAMAYANA");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("EPOS OF GILGAMESH");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("THE SONG OF ROLAND");
            this.castka = 80000;
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(3);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("26%");
                    Otazka9.this.up2.setText("20%");
                    Otazka9.this.up3.setText("34%");
                    Otazka9.this.up4.setText("20%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f172u2 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka9.this.f172u2.setEnabled(false);
                    Otazka9.this.f172u2.setVisibility(4);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up2.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "CJ: Hi, I have no idea.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 8) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these mean “left” in latin?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("DEXTER");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("INFERIOR");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("SINISTER");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("SUPERIOR");
            this.castka = 80000;
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(3);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("29%");
                    Otazka9.this.up2.setText("22%");
                    Otazka9.this.up3.setText("29%");
                    Otazka9.this.up4.setText("20%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f171u1 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka9.this.f171u1.setEnabled(false);
                    Otazka9.this.f171u1.setVisibility(4);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up1.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Sam: Hey, the answer is sinister.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 9) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Head of which animal did the Egyptian god of sun Re have?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("DOG");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("FALCON");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("LION");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("CAT");
            this.castka = 80000;
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(2);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("18%");
                    Otazka9.this.up2.setText("31%");
                    Otazka9.this.up3.setText("31%");
                    Otazka9.this.up4.setText("20%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.f171u1 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka9.this.f171u1.setEnabled(false);
                    Otazka9.this.f171u1.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up1.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Maya: Hey, he had a falcon head.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 10) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which distances does the race Ironman consist of (swimming, cycling, running)?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("3,8KM; 180KM; 42KM");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("1KM; 100KM; 20KM");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("2,5KM; 150KM; 42KM");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("3KM; 160KM; 35KM");
            this.castka = 80000;
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(1);
                }
            });
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("28%");
                    Otazka9.this.up2.setText("16%");
                    Otazka9.this.up3.setText("29%");
                    Otazka9.this.up4.setText("27%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f172u2 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka9.this.f172u2.setEnabled(false);
                    Otazka9.this.f172u2.setVisibility(4);
                    Otazka9.this.f173u3 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka9.this.f173u3.setEnabled(false);
                    Otazka9.this.f173u3.setVisibility(4);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up2.setVisibility(4);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up3.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Daniel: Hello, It is A for sure.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 11) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these colors can not be found on Chile’s flag?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("WHITE");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("YELLOW");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("BLUE");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("RED");
            this.castka = 80000;
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(2);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("23%");
                    Otazka9.this.up2.setText("32%");
                    Otazka9.this.up3.setText("24%");
                    Otazka9.this.up4.setText("21%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.f171u1 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka9.this.f171u1.setEnabled(false);
                    Otazka9.this.f171u1.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up1.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Stephan: Hi, the answer is yellow.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 12) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What does the latin phrase “carpe diem” mean?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("SEIZE THE DAY");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("AS MUCH AS YOU LIKE");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("WITHOUT PREPARATION");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("HIGHER POWER");
            this.castka = 80000;
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(1);
                }
            });
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("27%");
                    Otazka9.this.up2.setText("23%");
                    Otazka9.this.up3.setText("25%");
                    Otazka9.this.up4.setText("27%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.f173u3 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka9.this.f173u3.setEnabled(false);
                    Otazka9.this.f173u3.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up3.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Dave: Hey. It means seize the day, 100%.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 13) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many of os radius(bone) does a human have in it’s body?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("1");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("2");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("3");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("4");
            this.castka = 80000;
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(2);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("12%");
                    Otazka9.this.up2.setText("36%");
                    Otazka9.this.up3.setText("16%");
                    Otazka9.this.up4.setText("36%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.f171u1 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka9.this.f171u1.setEnabled(false);
                    Otazka9.this.f171u1.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up1.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Draymond: Hi, there are 2 of them.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 14) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Anders Celsius came from which country?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("DENMARK");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("NORWAY");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("SWEDEN");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("FINLAND");
            this.castka = 80000;
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(3);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("28%");
                    Otazka9.this.up2.setText("28%");
                    Otazka9.this.up3.setText("31%");
                    Otazka9.this.up4.setText("13%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.f172u2 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka9.this.f172u2.setEnabled(false);
                    Otazka9.this.f172u2.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up2.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Jeremy: Hello, he was Swdish.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 15) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Khmer Rouge terrorized which country?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("CAMBODIA");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("LAOS");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("THAILAND");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("BURMA");
            this.castka = 80000;
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(1);
                }
            });
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("29%");
                    Otazka9.this.up2.setText("26%");
                    Otazka9.this.up3.setText("17%");
                    Otazka9.this.up4.setText("28%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f172u2 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka9.this.f172u2.setEnabled(false);
                    Otazka9.this.f172u2.setVisibility(4);
                    Otazka9.this.f173u3 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka9.this.f173u3.setEnabled(false);
                    Otazka9.this.f173u3.setVisibility(4);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up2.setVisibility(4);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up3.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Stan: Hey there, the answer is Cambodia.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 16) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Baht is a currency of which country?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("BRUNEI");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("LAOS");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("MALAYSIA");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("THAILAND");
            this.castka = 80000;
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(4);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("24%");
                    Otazka9.this.up2.setText("27%");
                    Otazka9.this.up3.setText("22%");
                    Otazka9.this.up4.setText("27%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f172u2 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka9.this.f172u2.setEnabled(false);
                    Otazka9.this.f172u2.setVisibility(4);
                    Otazka9.this.f171u1 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka9.this.f171u1.setEnabled(false);
                    Otazka9.this.f171u1.setVisibility(4);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up2.setVisibility(4);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up1.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Michael: Hey, I am sorry but I have no idea.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 17) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these tenists holds the most victories in singles at Wimbledon?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("BJÖRN BORG");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("ROGER FEDERER");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("ROD LAVER");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("BORIS BECKER");
            this.castka = 80000;
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(2);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("20%");
                    Otazka9.this.up2.setText("29%");
                    Otazka9.this.up3.setText("23%");
                    Otazka9.this.up4.setText("28%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f171u1 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka9.this.f171u1.setEnabled(false);
                    Otazka9.this.f171u1.setVisibility(4);
                    Otazka9.this.f173u3 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka9.this.f173u3.setEnabled(false);
                    Otazka9.this.f173u3.setVisibility(4);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up1.setVisibility(4);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up3.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Randy: Hi, it’s Roger Federer!");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 18) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where did the largest tank battle take place?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("KURSK");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("ARDENNES");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("STALINGRAD");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("KHARKIV");
            this.castka = 80000;
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(1);
                }
            });
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("29%");
                    Otazka9.this.up2.setText("19%");
                    Otazka9.this.up3.setText("26%");
                    Otazka9.this.up4.setText("26%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.f172u2 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka9.this.f172u2.setEnabled(false);
                    Otazka9.this.f172u2.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up2.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Branda: Hi, it took place at Krusk.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 19) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many parts does cow’s stomach have?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("2");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("4");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("6");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("8");
            this.castka = 80000;
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(2);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("28%");
                    Otazka9.this.up2.setText("28%");
                    Otazka9.this.up3.setText("25%");
                    Otazka9.this.up4.setText("21%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.f171u1 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka9.this.f171u1.setEnabled(false);
                    Otazka9.this.f171u1.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up1.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Mathew: Hi, I’m sure it’s either 2 or 4.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 20) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("2,718 is an approximate value of which one of these numbers?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("EULER’S NUMBER");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("LUDLPHINE NUMBER");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("GOLDEN RATIO");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("GOOGOL");
            this.castka = 80000;
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(1);
                }
            });
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("31%");
                    Otazka9.this.up2.setText("18%");
                    Otazka9.this.up3.setText("29%");
                    Otazka9.this.up4.setText("22%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.f172u2 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka9.this.f172u2.setEnabled(false);
                    Otazka9.this.f172u2.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up2.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Adam: Hey, the correct answer is Euler’s number!");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 21) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In Egyptian mythology, Anat is a goddes of what?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("WAR");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("SKY");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("SEA");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("HARVEST");
            this.castka = 80000;
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(1);
                }
            });
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("26%");
                    Otazka9.this.up2.setText("22%");
                    Otazka9.this.up3.setText("26%");
                    Otazka9.this.up4.setText("26%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f172u2 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka9.this.f172u2.setEnabled(false);
                    Otazka9.this.f172u2.setVisibility(4);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up2.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Dave: Hey, I’m sorry but I don’t know either.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 22) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these is a thundercloud?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("CIRRUS");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("NIMBOSTRATUS");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("CUMMULONIMBUS");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("ALTOSTRATUS");
            this.castka = 80000;
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(3);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("21%");
                    Otazka9.this.up2.setText("26%");
                    Otazka9.this.up3.setText("29%");
                    Otazka9.this.up4.setText("24%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f172u2 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka9.this.f172u2.setEnabled(false);
                    Otazka9.this.f172u2.setVisibility(4);
                    Otazka9.this.f171u1 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka9.this.f171u1.setEnabled(false);
                    Otazka9.this.f171u1.setVisibility(4);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up2.setVisibility(4);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up1.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Richard: Hi, it is Cummulonimbus.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 23) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of Germany’s plan to conquer Czechoslovakia in 1937?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("FALL OTTO");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("FALL BLAU");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("FALL GRÜN");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("FALL HIMMLER");
            this.castka = 80000;
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(3);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("26%");
                    Otazka9.this.up2.setText("10%");
                    Otazka9.this.up3.setText("35%");
                    Otazka9.this.up4.setText("29%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.f171u1 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka9.this.f171u1.setEnabled(false);
                    Otazka9.this.f171u1.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up1.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Jim: Hi, it was Fall Grün.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 24) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these is not used while playing quidditch?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("GOLDEN SNITCH");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("QUAFFLE");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("BASSINET");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("BLUDGER");
            this.castka = 80000;
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(3);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("7%");
                    Otazka9.this.up2.setText("31%");
                    Otazka9.this.up3.setText("37%");
                    Otazka9.this.up4.setText("25%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f172u2 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka9.this.f172u2.setEnabled(false);
                    Otazka9.this.f172u2.setVisibility(4);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up2.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Gabe: Hello, choose bassinet!");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 25) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these literary movements was heavily influenced by S. Freud’s psychoanalysis?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("POETISM");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("EXPRESSIONISM");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("RURALISM");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("SURREALISM");
            this.castka = 80000;
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(4);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("21%");
                    Otazka9.this.up2.setText("28%");
                    Otazka9.this.up3.setText("19%");
                    Otazka9.this.up4.setText("32%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f172u2 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka9.this.f172u2.setEnabled(false);
                    Otazka9.this.f172u2.setVisibility(4);
                    Otazka9.this.f173u3 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka9.this.f173u3.setEnabled(false);
                    Otazka9.this.f173u3.setVisibility(4);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up2.setVisibility(4);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up3.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Kevin: Hi, I think it was surrealism.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 26) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("On which day of December was Pearl Harbor attacked?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("FIRST");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("SEVENTH");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("FIFTEENTH");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("TWENTIETH");
            this.castka = 80000;
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(2);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("28%");
                    Otazka9.this.up2.setText("29%");
                    Otazka9.this.up3.setText("24%");
                    Otazka9.this.up4.setText("19%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.f173u3 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka9.this.f173u3.setEnabled(false);
                    Otazka9.this.f173u3.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up3.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Jill: Hey, I honestly have no idea, sorry.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 27) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where does roundworm parasitise?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("LARGE INTESTINE");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("SMALL INTESTINE");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("LIVERS");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("GALL BLADDER");
            this.castka = 80000;
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(2);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("26%");
                    Otazka9.this.up2.setText("26%");
                    Otazka9.this.up3.setText("22%");
                    Otazka9.this.up4.setText("26%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f173u3 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka9.this.f173u3.setEnabled(false);
                    Otazka9.this.f173u3.setVisibility(4);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up3.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Martha: Hello, I don’t know.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 28) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these lakes does not have cryptodepression?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("BAIKAL");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("VICTORIA");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("TAIMYR");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("GREAT BEAR");
            this.castka = 80000;
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(2);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("15%");
                    Otazka9.this.up2.setText("29%");
                    Otazka9.this.up3.setText("28%");
                    Otazka9.this.up4.setText("28%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f173u3 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka9.this.f173u3.setEnabled(false);
                    Otazka9.this.f173u3.setVisibility(4);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up3.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Jordan: Hello, it is either B) or C).");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 29) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these generals was nicknamed the Desert Fox?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("ERWIN ROMMEL");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("BERNARD MONTGOMERY");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("HEINZ GUDERIAN");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("ERICH VON MANSTEIN");
            this.castka = 80000;
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(1);
                }
            });
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("32%");
                    Otazka9.this.up2.setText("14%");
                    Otazka9.this.up3.setText("24%");
                    Otazka9.this.up4.setText("30%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f172u2 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka9.this.f172u2.setEnabled(false);
                    Otazka9.this.f172u2.setVisibility(4);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up2.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Sarah: Hey, it was general Rommel.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 30) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which country had many Polish officers killed in 1940 near the city Katyń?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("GERMANY");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("USSR");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("ITALY");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("JAPAN");
            this.castka = 80000;
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(2);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("40%");
                    Otazka9.this.up2.setText("40%");
                    Otazka9.this.up3.setText("15%");
                    Otazka9.this.up4.setText("5%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.f173u3 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka9.this.f173u3.setEnabled(false);
                    Otazka9.this.f173u3.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up3.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Henry: Hi, I’m pretty sure it was the USSR!");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 31) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the capital of Monaco?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("MONTE-CARLO");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("MONACO-VILLE");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("FONTVIELLE");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("MONACO");
            this.castka = 80000;
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(2);
                }
            });
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("40%");
                    Otazka9.this.up2.setText("40%");
                    Otazka9.this.up3.setText("5%");
                    Otazka9.this.up4.setText("15%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setEnabled(false);
                    Otazka9.this.f174u4.setVisibility(4);
                    Otazka9.this.f173u3 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka9.this.f173u3.setEnabled(false);
                    Otazka9.this.f173u3.setVisibility(4);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up4.setVisibility(4);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up3.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Jimmy: Hello, the capital of Monaco is Monaco-Ville!");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        } else if (this.losovane == 32) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these played the role of James Bond only once?");
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setText("GEORGE LAZENBY");
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setText("DANIEL CRAIG");
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setText("PIERCE BROSNAN");
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setText("TIMOTHY DALTON");
            this.castka = 80000;
            this.f171u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.Spravna(1);
                }
            });
            this.f172u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f173u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.f174u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.gameOver2(Otazka9.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka9.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unl.setEnabled(false);
                    Otazka9.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.up1.setText("44%");
                    Otazka9.this.up2.setText("6%");
                    Otazka9.this.up3.setText("11%");
                    Otazka9.this.up4.setText("39%");
                    Otazka9.this.pomocnapromenna9 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unp.setEnabled(false);
                    Otazka9.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka9.this.f172u2 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka9.this.f172u2.setEnabled(false);
                    Otazka9.this.f172u2.setVisibility(4);
                    Otazka9.this.f173u3 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka9.this.f173u3.setEnabled(false);
                    Otazka9.this.f173u3.setVisibility(4);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up2.setVisibility(4);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up3.setVisibility(4);
                    Otazka9.this.pomocnapromennap9 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka9.this.unt.setEnabled(false);
                    Otazka9.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka9.this);
                    builder.setMessage((CharSequence) "Thadeus: Hi, I think it was A) but I’m not entirely sure.");
                    builder.create().show();
                    Otazka9.this.pomocnapromennat9 = 1;
                }
            });
        }
        this.dvere = (Button) findViewById(C1760R.C1762id.dvere);
        this.dvere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Otazka9.this.castka = 80000;
                Otazka9.this.gameOver();
                if (Otazka9.this.castka > Otazka9.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                    Otazka9.this.highscore(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
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
        this.castka = 10000;
        this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f171u1.setEnabled(false);
        this.f172u2.setEnabled(false);
        this.f173u3.setEnabled(false);
        this.f174u4.setEnabled(false);
        if (i != 0) {
            int parseColor = Color.parseColor("#ffaa00");
            this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
            this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
            this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
            this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
            if (i == 1) {
                this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f171u1.setTextColor(parseColor);
                this.f171u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up1.setTextColor(parseColor);
            } else if (i == 2) {
                this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f172u2.setTextColor(parseColor);
                this.f172u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up2.setTextColor(parseColor);
            } else if (i == 3) {
                this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f173u3.setTextColor(parseColor);
                this.f173u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up3.setTextColor(parseColor);
            } else if (i == 4) {
                this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f174u4.setTextColor(parseColor);
                this.f174u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up4.setTextColor(parseColor);
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    int parseColor = Color.parseColor("#fcff0202");
                    int parseColor2 = Color.parseColor("#1dc700");
                    Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                    Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                    Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                    Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                    Otazka9.this.f171u1 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka9.this.f172u2 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka9.this.f173u3 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    if (i == 1) {
                        Otazka9.this.f171u1.setTextColor(parseColor);
                        Otazka9.this.f171u1.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka9.this.up1.setTextColor(parseColor);
                    } else if (i == 2) {
                        Otazka9.this.f172u2.setTextColor(parseColor);
                        Otazka9.this.f172u2.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka9.this.up2.setTextColor(parseColor);
                    } else if (i == 3) {
                        Otazka9.this.f173u3.setTextColor(parseColor);
                        Otazka9.this.f173u3.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka9.this.up3.setTextColor(parseColor);
                    } else if (i == 4) {
                        Otazka9.this.f174u4.setTextColor(parseColor);
                        Otazka9.this.f174u4.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka9.this.up4.setTextColor(parseColor);
                    }
                    if (i2 == 1) {
                        Otazka9.this.f171u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka9.this.f171u1.setTextColor(parseColor2);
                        Otazka9.this.up1.setTextColor(parseColor2);
                    } else if (i2 == 2) {
                        Otazka9.this.f172u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka9.this.f172u2.setTextColor(parseColor2);
                        Otazka9.this.up2.setTextColor(parseColor2);
                    } else if (i2 == 3) {
                        Otazka9.this.f173u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka9.this.f173u3.setTextColor(parseColor2);
                        Otazka9.this.up3.setTextColor(parseColor2);
                    } else if (i2 == 4) {
                        Otazka9.this.f174u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka9.this.f174u4.setTextColor(parseColor2);
                        Otazka9.this.up4.setTextColor(parseColor2);
                    }
                    Intent intent = new Intent(Otazka9.this, BackgroundSoundService.class);
                    intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                    Otazka9.this.stopService(intent);
                    Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka9.this).getBoolean("ZVUK", true));
                    Otazka9.this.spatna = MediaPlayer.create(Otazka9.this, C1760R.raw.spatna2);
                    if (z && valueOf.booleanValue()) {
                        Otazka9.this.spatna.start();
                    }
                }
            }, 1500);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Otazka9.this.alertDialog();
                    if (Otazka9.this.mInterstitialAd.isLoaded()) {
                        Otazka9.this.mInterstitialAd.show();
                    }
                }
            }, 3500);
            this.castka = 10000;
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
        this.castka = 10000;
        Intent intent2 = new Intent(this, PopActivity.class);
        intent2.putExtra("Level", this.level);
        intent2.putExtra("Castka", this.castka);
        intent2.putExtra("pomocnapromenna", this.pomocnapromenna9);
        intent2.putExtra("pomocnapromennap", this.pomocnapromennap9);
        intent2.putExtra("pomocnapromennat", this.pomocnapromennat9);
        startActivity(intent2);
        this.mCountDownTimer.cancel();
    }

    /* access modifiers changed from: private */
    public void Spravna(final int i) {
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_9", 0);
        int i2 = sharedPreferences.getInt("x", -1) + 1;
        SharedPreferences.Editor edit = getSharedPreferences("zodpovezene_9", 0).edit();
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
        this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f171u1.setEnabled(false);
        this.f172u2.setEnabled(false);
        this.f173u3.setEnabled(false);
        this.f174u4.setEnabled(false);
        if (i == 1) {
            this.f171u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f171u1.setTextColor(parseColor);
            this.f171u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up1.setTextColor(parseColor);
        } else if (i == 2) {
            this.f172u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f172u2.setTextColor(parseColor);
            this.f172u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up2.setTextColor(parseColor);
        } else if (i == 3) {
            this.f173u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f173u3.setTextColor(parseColor);
            this.f173u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up3.setTextColor(parseColor);
        } else {
            this.f174u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f174u4.setTextColor(parseColor);
            this.f174u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up4.setTextColor(parseColor);
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka9.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                Otazka9.this.stopService(intent);
                int parseColor = Color.parseColor("#1dc700");
                Otazka9.this.up1 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up1);
                Otazka9.this.up2 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up2);
                Otazka9.this.up3 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up3);
                Otazka9.this.up4 = (TextView) Otazka9.this.findViewById(C1760R.C1762id.up4);
                if (i == 1) {
                    Otazka9.this.f171u1 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka9.this.f171u1.setTextColor(parseColor);
                    Otazka9.this.f171u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka9.this.up1.setTextColor(parseColor);
                } else if (i == 2) {
                    Otazka9.this.f172u2 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka9.this.f172u2.setTextColor(parseColor);
                    Otazka9.this.f172u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka9.this.up2.setTextColor(parseColor);
                } else if (i == 3) {
                    Otazka9.this.f173u3 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka9.this.f173u3.setTextColor(parseColor);
                    Otazka9.this.f173u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka9.this.up3.setTextColor(parseColor);
                } else {
                    Otazka9.this.f174u4 = (Button) Otazka9.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka9.this.f174u4.setTextColor(parseColor);
                    Otazka9.this.f174u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka9.this.up4.setTextColor(parseColor);
                }
                if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka9.this).getBoolean("ZVUK", true)).booleanValue()) {
                    MediaPlayer.create(Otazka9.this, C1760R.raw.applause2).start();
                }
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka9.this, Otazka10.class);
                intent.putExtra("some_key9", Otazka9.this.pomocnapromenna9);
                intent.putExtra("some_keyp9", Otazka9.this.pomocnapromennap9);
                intent.putExtra("some_keyt9", Otazka9.this.pomocnapromennat9);
                Otazka9.this.startActivity(intent);
                CustomIntent.customType(Otazka9.this, "left-to-right");
            }
        }, 2500);
    }

    /* access modifiers changed from: private */
    public void highscore(int i) {
        if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true)).booleanValue()) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    MediaPlayer.create(Otazka9.this, C1760R.raw.applause7).start();
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
            Intent intent = new Intent(this, Otazka10.class);
            this.mCountDownTimer.cancel();
            intent.putExtra("some_key9", this.pomocnapromenna9);
            intent.putExtra("some_keyp9", this.pomocnapromennap9);
            intent.putExtra("some_keyt9", this.pomocnapromennat9);
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
        this.castka = 1000;
        if (this.gameOver && isActivityVisible()) {
            Intent intent = new Intent(this, PopActivity.class);
            intent.putExtra("Level", this.level);
            intent.putExtra("Castka", this.castka);
            intent.putExtra("pomocnapromenna", this.pomocnapromenna9);
            intent.putExtra("pomocnapromennap", this.pomocnapromennap9);
            intent.putExtra("pomocnapromennat", this.pomocnapromennat9);
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
