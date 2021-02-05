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
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import java.util.ArrayList;
import java.util.Random;
import maes.tech.intentanim.CustomIntent;

public class Otazka5 extends AppCompatActivity implements RewardedVideoAdListener {
    private static boolean activityVisible;
    Button Zvuk;

    /* renamed from: a */
    final int f117a = 0;

    /* renamed from: a3 */
    Button f118a3;
    ArrayList<Integer> arl = new ArrayList<>();

    /* renamed from: b */
    final int f119b = 0;

    /* renamed from: b3 */
    Button f120b3;
    Button button4_1;
    Button buttonp4_1;
    Button buttont4_1;

    /* renamed from: c3 */
    Button f121c3;
    Button c3p;
    int castka;

    /* renamed from: d3 */
    Button f122d3;
    Button d3p;
    Button dvere;
    RadioGroup fuhrer1;
    boolean gameOver = false;

    /* renamed from: i */
    int f123i = 0;
    int[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97};
    TextView label;
    int level = 5;
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
    int pomocnapromenna5;
    int pomocnapromennap5;
    int pomocnapromennat5;
    TextView pro1;
    TextView pro2;
    TextView pro3;
    TextView pro4;

    /* renamed from: r */
    Random f124r;
    RadioGroup radioGroupreky;
    TextView reky1chyba;
    MediaPlayer spatna;
    TextView textview2;
    TextView textview3;
    TextView textview4;
    TextView textview5;
    TextView textview6;
    TextView textview7;
    TextView textview8;

    /* renamed from: u1 */
    Button f125u1;

    /* renamed from: u2 */
    Button f126u2;

    /* renamed from: u3 */
    Button f127u3;

    /* renamed from: u4 */
    Button f128u4;
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
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_5", 0);
        int i = sharedPreferences.getInt("x", -1) + 1;
        System.out.println(i + "!!!!");
        SharedPreferences sharedPreferences2 = getSharedPreferences("zodpovezene_5", 0);
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
        this.f124r = new Random();
        this.castka = 0;
        if (this.arl.size() == 0) {
            sharedPreferences.edit().clear().commit();
            sharedPreferences2.edit().clear().commit();
            int i5 = getSharedPreferences("zodpovezene_5", 0).getInt("x", -1) + 1;
            System.out.println(i5 + "!!!!");
            SharedPreferences sharedPreferences3 = getSharedPreferences("zodpovezene_5", 0);
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
        this.losovane = this.f124r.nextInt(this.arl.size());
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
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(Otazka5.this);
                Boolean valueOf = Boolean.valueOf(defaultSharedPreferences.getBoolean("ZVUK", true));
                Intent intent = new Intent(Otazka5.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                if (valueOf.booleanValue()) {
                    SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                    edit.putBoolean("ZVUK", false);
                    edit.commit();
                    Otazka5.this.stopService(intent);
                    Otazka5.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukvypnuto);
                    return;
                }
                SharedPreferences.Editor edit2 = defaultSharedPreferences.edit();
                edit2.putBoolean("ZVUK", true);
                edit2.commit();
                Otazka5.this.startService(intent);
                Otazka5.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukzapnuto);
            }
        });
        this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f125u1.setTextColor(-1);
        this.f125u1.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f126u2.setTextColor(-1);
        this.f126u2.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f127u3.setTextColor(-1);
        this.f127u3.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f128u4.setTextColor(-1);
        this.f128u4.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
        this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
        this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
        this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
        this.up1.setTextColor(-1);
        this.up2.setTextColor(-1);
        this.up3.setTextColor(-1);
        this.up4.setTextColor(-1);
        this.textview2 = (TextView) findViewById(C1760R.C1762id.textView2);
        this.textview2.setText("200$");
        this.textview3 = (TextView) findViewById(C1760R.C1762id.textView3);
        this.textview3.setText("300$");
        this.textview4 = (TextView) findViewById(C1760R.C1762id.textView4);
        this.textview4.setText("500$");
        this.textview5 = (TextView) findViewById(C1760R.C1762id.textView5);
        this.textview5.setText("1K");
        this.textview5.setBackgroundResource(C1760R.C1761drawable.textview2);
        this.textview5.setTypeface(Typeface.DEFAULT_BOLD);
        this.textview6 = (TextView) findViewById(C1760R.C1762id.textView6);
        this.textview6.setBackgroundResource(C1760R.C1761drawable.textview);
        this.textview6.setTypeface(Typeface.DEFAULT);
        this.textview6.setText("2K");
        this.textview7 = (TextView) findViewById(C1760R.C1762id.textView7);
        this.textview7.setText("5K");
        this.textview8 = (TextView) findViewById(C1760R.C1762id.textView8);
        this.textview8.setText("10K");
        this.textview5 = (TextView) findViewById(C1760R.C1762id.textView5);
        this.textview5.setTextColor(-1);
        this.otazkaza = (TextView) findViewById(C1760R.C1762id.otazkaza);
        this.otazkaza.setText("1 000$ Question");
        this.mProgressBar = (ProgressBar) findViewById(C1760R.C1762id.progressBar3);
        this.mProgressBar.setProgress(this.f123i);
        this.mCountDownTimer = new CountDownTimer(40000, 1000) {
            public void onTick(long j) {
                Log.v("Log_tag", "Tick of Progress" + Otazka5.this.f123i + j);
                Otazka5 otazka5 = Otazka5.this;
                otazka5.f123i = otazka5.f123i + 1;
                Otazka5.this.mProgressBar.setProgress((Otazka5.this.f123i * 100) / 40);
            }

            public void onFinish() {
                Otazka5.this.f123i++;
                Otazka5.this.mProgressBar.setProgress(100);
                Otazka5.this.uzivatelOdpovedel = false;
                Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 0, 0);
            }
        };
        this.mCountDownTimer.start();
        int i9 = getIntent().getExtras().getInt("some_key4");
        int i10 = getIntent().getExtras().getInt("some_keyp4");
        if (getIntent().getExtras().getInt("some_keyt4") == 1) {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(false);
            this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
            this.pomocnapromennat5 = 1;
        } else {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(true);
        }
        if (i10 == 1) {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(false);
            this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
            this.pomocnapromennap5 = 1;
        } else {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(true);
        }
        if (i9 == 1) {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(false);
            this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
            this.pomocnapromenna5 = 1;
        } else {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(true);
        }
        this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f125u1.setEnabled(true);
        this.f126u2.setEnabled(true);
        this.f127u3.setEnabled(true);
        this.f128u4.setEnabled(true);
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
            this.otazkau.setText("When did the 1st World War start?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("1939");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("1914");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("1918");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("1912");
            this.castka = 0;
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("7%");
                    Otazka5.this.up2.setText("45%");
                    Otazka5.this.up3.setText("26%");
                    Otazka5.this.up4.setText("22%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Sandra: Hi, it started in 1914!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 2) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which ocean is the biggest?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("ARCTIC");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("ATLANTIC");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("INDIAN");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("PACIFIC");
            this.castka = 0;
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(4);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("5%");
                    Otazka5.this.up2.setText("9%");
                    Otazka5.this.up3.setText("2%");
                    Otazka5.this.up4.setText("84%");
                    Otazka5.this.pomocnapromenna5 = 1;
                    Otazka5.this.unp = (Button) Otazka5.this.findViewById(C1760R.C1762id.unp);
                    Otazka5.this.unp.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Otazka5.this.unp.setEnabled(false);
                            Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                            Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                            Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                            Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                            Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                            Otazka5.this.up3.setVisibility(4);
                            Otazka5.this.up2.setVisibility(4);
                            Otazka5.this.f127u3.setVisibility(4);
                            Otazka5.this.f126u2.setVisibility(4);
                            Otazka5.this.f126u2.setEnabled(false);
                            Otazka5.this.f127u3.setEnabled(false);
                            Otazka5.this.pomocnapromennap5 = 1;
                        }
                    });
                    Otazka5.this.unt = (Button) Otazka5.this.findViewById(C1760R.C1762id.unt);
                    Otazka5.this.unt.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Otazka5.this.unt.setEnabled(false);
                            Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                            AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                            builder.setMessage((CharSequence) "Sandra: Hi, it is Pacific ocean!");
                            builder.create().show();
                            Otazka5.this.pomocnapromennat5 = 1;
                        }
                    });
                }
            });
        } else if (this.losovane == 3) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which year died Fidel Castro?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("2019");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("2016");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText(NativeAppInstallAd.ASSET_CALL_TO_ACTION);
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("2000");
            this.castka = 0;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("40%");
                    Otazka5.this.up2.setText("55%");
                    Otazka5.this.up3.setText("3%");
                    Otazka5.this.up4.setText("2%");
                    Otazka5.this.pomocnapromenna5 = 1;
                    Otazka5.this.unp = (Button) Otazka5.this.findViewById(C1760R.C1762id.unp);
                    Otazka5.this.unp.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Otazka5.this.unp.setEnabled(false);
                            Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                            Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                            Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                            Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                            Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                            Otazka5.this.up1.setVisibility(4);
                            Otazka5.this.up3.setVisibility(4);
                            Otazka5.this.f125u1.setVisibility(4);
                            Otazka5.this.f127u3.setVisibility(4);
                            Otazka5.this.f125u1.setEnabled(false);
                            Otazka5.this.f127u3.setEnabled(false);
                            Otazka5.this.pomocnapromennap5 = 1;
                        }
                    });
                    Otazka5.this.unt = (Button) Otazka5.this.findViewById(C1760R.C1762id.unt);
                    Otazka5.this.unt.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Otazka5.this.unt.setEnabled(false);
                            Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                            AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                            builder.setMessage((CharSequence) "Sandra: Hi, I think it was in 2016.");
                            builder.create().show();
                            Otazka5.this.pomocnapromennat5 = 1;
                        }
                    });
                }
            });
        } else if (this.losovane == 4) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which gulf are the largest amounts of oil?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("PERSIAN");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("GULF OF GUINEA");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("GULF OF LION");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("ARGOLIC");
            this.castka = 0;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("44%");
                    Otazka5.this.up2.setText("20%");
                    Otazka5.this.up3.setText("19%");
                    Otazka5.this.up4.setText("17%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Sandra: Hi the correct answer is A)!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 5) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the chemical mark of Potassium?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("F");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("K");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("P");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("S");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("19%");
                    Otazka5.this.up2.setText("72%");
                    Otazka5.this.up3.setText("2%");
                    Otazka5.this.up4.setText("7%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Jane: Hi, I think that K is the correct one!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 6) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who wrote Oliver Twist?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("CHARLES DICKENS");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("OSCAR WILDE");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("PERCY SHELLEY");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("JONATHAN SWIFT");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("54%");
                    Otazka5.this.up2.setText("16%");
                    Otazka5.this.up3.setText("16%");
                    Otazka5.this.up4.setText("14%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Jennifer: Hi, I think it was Charles Dickens!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 7) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What did not draw Leonardo da Vinci?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("THE BIRTH OF VENUS");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("THE LAST SUPPER");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("BENOIS MADONNA");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("MONA LISA");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("59%");
                    Otazka5.this.up2.setText("13%");
                    Otazka5.this.up3.setText("21%");
                    Otazka5.this.up4.setText("7%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Jennifer: Hi, The birth of Venus is a picture by Andrea Botticeli, so the correct answer is A)!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 8) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Nearby which continent can we find Borneo (Kalimantan)?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("ASIA");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("AFRICA");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("SOUTH AMERICA");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("EUROPE");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("46%");
                    Otazka5.this.up2.setText("21%");
                    Otazka5.this.up3.setText("27%");
                    Otazka5.this.up4.setText("6%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Jennifer: Hi, it is nearby Asia!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 9) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How do we call 25th Wedding anniversary?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("GOLDEN WEDDING");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("SILVER WEDDING");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("CRYSTAL WEDDING");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("SILK WEDDING");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("14%");
                    Otazka5.this.up2.setText("53%");
                    Otazka5.this.up3.setText("21%");
                    Otazka5.this.up4.setText("12%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Jennifer: hi, I think it should be Silver wedding!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 10) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who won the 2000 golph US open?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("MIGUEL JIMENEZ");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("TIGER WOODS");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("ERNIE ELS");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("NICK FALDO");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("18%");
                    Otazka5.this.up2.setText("56%");
                    Otazka5.this.up3.setText("15%");
                    Otazka5.this.up4.setText("11%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Martin: Hi, this must have been Tiger Woods!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 11) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which historical phase lived Leonardo da Vinci?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("CLASSICISM");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("BAROQUE");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("ROMANTICISM");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("RENAISSANCE");
            this.castka = 5000;
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(4);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("14%");
                    Otazka5.this.up2.setText("6%");
                    Otazka5.this.up3.setText("25%");
                    Otazka5.this.up4.setText("55%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Jennifer: Hi, it was in Renaissance!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 12) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many percents of nitrogen are there in earth's atmosphere?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("6%");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("56%");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("71%");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("78%");
            this.castka = 5000;
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(4);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("4%");
                    Otazka5.this.up2.setText("7%");
                    Otazka5.this.up3.setText("41%");
                    Otazka5.this.up4.setText("48%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Jennifer: Hi, there are 78% of it!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 13) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which city was a wall, seperating it into two parts (Western and Eastern)?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("BERLIN");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("PARIS");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("PRAGUE");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("MARSEILLE");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("57%");
                    Otazka5.this.up2.setText("3%");
                    Otazka5.this.up3.setText("24%");
                    Otazka5.this.up4.setText("16%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Linda: Hi, it was in Berlin!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 14) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which state can we find Transylvania region?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("IN ROMANIA");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("IN MACEDONIA");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("IN UKRAINE");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("IN ITALY");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("51%");
                    Otazka5.this.up2.setText("11%");
                    Otazka5.this.up3.setText("6%");
                    Otazka5.this.up4.setText("32%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Linda: Hi, it is in Romania!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 15) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which lake has recently almost dry up?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("AJARKUL");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("ARAL");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("TAYMYR");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("ISSYK-KUL");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("13%");
                    Otazka5.this.up2.setText("54%");
                    Otazka5.this.up3.setText("15%");
                    Otazka5.this.up4.setText("18%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Linda: Hi, I think it is Aral lake!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 16) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which sea surrounds the Netherlands?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("CELTIC SEA");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("LIGURIAN SEA");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("NORTH SEA");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("BALTIC SEA");
            this.castka = 5000;
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(3);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("5%");
                    Otazka5.this.up2.setText("4%");
                    Otazka5.this.up3.setText("68%");
                    Otazka5.this.up4.setText("23%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Linda: Hi, I'd choose C)!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 17) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What are erythrocytes?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("RED BLOOD CELLS");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("WHITE BLOOD CELLS");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("PLATELETS");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("BLOOD PLASMA");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("56%");
                    Otazka5.this.up2.setText("9%");
                    Otazka5.this.up3.setText("22%");
                    Otazka5.this.up4.setText("13%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Linda: Hi, I am sure that correct answer is A)!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 18) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which units do we measure an electric charge?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("VOLTS");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("WATTS");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("JOULS");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("COULOMBS");
            this.castka = 5000;
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(4);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("9%");
                    Otazka5.this.up2.setText("7%");
                    Otazka5.this.up3.setText("13%");
                    Otazka5.this.up4.setText("71%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Linda: Hi, it is measured in Coulombes, trust me!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 19) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of famous basilica in Venice?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("ST. PETER'S");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("ST. PAUL'S");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("ST. MARK'S");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("ST. JOSEPH'S");
            this.castka = 5000;
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(3);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("25%");
                    Otazka5.this.up2.setText("10%");
                    Otazka5.this.up3.setText("63%");
                    Otazka5.this.up4.setText("2%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Laura: Hi, it is St. Mark's basilica!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 20) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which egyptian city can we find The Great Sphinx?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("GIZA");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("CAIRO");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("LUXOR");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("THEBES");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("39%");
                    Otazka5.this.up2.setText("7%");
                    Otazka5.this.up3.setText("26%");
                    Otazka5.this.up4.setText("28%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "David: Hi, I was there, so I can confirm it's in Giza!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 21) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many nulls are there if a prefix pico is used?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("6");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("9");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("12");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("15");
            this.castka = 5000;
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(3);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("11%");
                    Otazka5.this.up2.setText("32%");
                    Otazka5.this.up3.setText("49%");
                    Otazka5.this.up4.setText("8%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Laura: Hi, there are 12 nulls!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 22) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the tangens of 45 degrees angle?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("0");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("-1");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("1");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("0,5");
            this.castka = 5000;
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(3);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("17%");
                    Otazka5.this.up2.setText("20%");
                    Otazka5.this.up3.setText("57%");
                    Otazka5.this.up4.setText("6%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Laura: Hi, I think, it is 1!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 23) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How do we call an increase of general price level?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("INFLATION");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("DEFLATION");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("VALORISATION");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("MONOPHSONACE");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("54%");
                    Otazka5.this.up2.setText("14%");
                    Otazka5.this.up3.setText("19%");
                    Otazka5.this.up4.setText("13%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Laura: Hi, that is easy! Inflation is correct!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 24) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which state are there the most nuclear plants?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("FRANCE");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("AUSTRIA");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("SPAIN");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("GREAT BRITAIN");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("43%");
                    Otazka5.this.up2.setText("23%");
                    Otazka5.this.up3.setText("25%");
                    Otazka5.this.up4.setText("9%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Jeniffer: Hi, the most nuclear plants are in France.");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 25) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many mililitres of a new blood are created every day?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("1");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("10");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("50");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("200");
            this.castka = 5000;
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(3);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("1%");
                    Otazka5.this.up2.setText("42%");
                    Otazka5.this.up3.setText("55%");
                    Otazka5.this.up4.setText("2%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Kevin: Hi, certainly it is 50 mililitres.");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 26) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("An alloy Duralumin is mainly created of?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("ZINC");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("ALUMINIUM");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("LEAD");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("SILVER");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("9%");
                    Otazka5.this.up2.setText("80%");
                    Otazka5.this.up3.setText("6%");
                    Otazka5.this.up4.setText("5%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Kevin: Hi, certainly from Aluminium!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 27) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who established Lists of Intangible Cultural Heritage?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("UNESCO");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("PETA");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("UEFA");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("UNICEF");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("63%");
                    Otazka5.this.up2.setText("17%");
                    Otazka5.this.up3.setText("15%");
                    Otazka5.this.up4.setText("5%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Kevin: Hi, certainly it is UNESCO!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 28) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which nationality was the first man to reach the South pole?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("NORWEGIAN");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("AMERICAN");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("RUSSIAN");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("FRENCH");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("52%");
                    Otazka5.this.up2.setText("31%");
                    Otazka5.this.up3.setText("12%");
                    Otazka5.this.up4.setText("5%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Kevin: Hi, it was Roald Amundsen, Norwegian.");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 29) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who has lead Soviet Union in the times it breakup?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("MIKHAIL GORBACHEV");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("YURI ANDROPOV");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("KONSTANTIN CERNENKO");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("LEONID BREZHNEV");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("39%");
                    Otazka5.this.up2.setText("24%");
                    Otazka5.this.up3.setText("23%");
                    Otazka5.this.up4.setText("14%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Kevin: Hi, surely Mikhail Gorbachev!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 30) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How do we call science which studies maps?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("CARTOGRAPHY");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("KEPLEROLOGY");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("MAPOGRAPHY");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("ORTODROMOLOGY");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("83%");
                    Otazka5.this.up2.setText("1%");
                    Otazka5.this.up3.setText("0%");
                    Otazka5.this.up4.setText("17%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Kevin: Hi, definitely a Cartography!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 31) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which Asian peninsula is the biggest in area?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("KAMCHATKA");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("MALAY");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("ARABIAN");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("INDIAN");
            this.castka = 5000;
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(3);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("4%");
                    Otazka5.this.up2.setText("16%");
                    Otazka5.this.up3.setText("45%");
                    Otazka5.this.up4.setText("35%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Kevin: Hi, I think it is an Arabian peninsula!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 32) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Between 3 most common Greek columns doesn't belong?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("CORINTHIAN ORDER");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("PAETIC ORDER");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("IONIC ORDER");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("DORIC ORDER");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("14%");
                    Otazka5.this.up2.setText("65%");
                    Otazka5.this.up3.setText("12%");
                    Otazka5.this.up4.setText("9%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Carol: Hi, I think that you should choose B).");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 33) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which year before Christ there was the first Olympics?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("787");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("776");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("767");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("768");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("12%");
                    Otazka5.this.up2.setText("45%");
                    Otazka5.this.up3.setText("26%");
                    Otazka5.this.up4.setText("17%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Carol: Hi, this is easy - 776.");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 34) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which strait is named after a man who circumnavigated New Zealend as first?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("DRAKE");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("HUDSON");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("BYRON");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("COOK");
            this.castka = 5000;
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(4);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("26%");
                    Otazka5.this.up2.setText("20%");
                    Otazka5.this.up3.setText("19%");
                    Otazka5.this.up4.setText("35%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Carol: Hi, this is a Cook strait!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 35) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who was the first to circumnavigate the Earth?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("FERNAO DE MAGALHAES (MAGELLAN)");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("FRANCIS DRAKE");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("BARTOLOMEU DIAS");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("JAMES COOK");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("46%");
                    Otazka5.this.up2.setText("21%");
                    Otazka5.this.up3.setText("11%");
                    Otazka5.this.up4.setText("22%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Carol: Hi, I think that it was Fernao de Magalhaes!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 36) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which city got Kevin lost in the film Home alone 2?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("PARIS");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("NEW YORK");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("MIAMI");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("CHICAGO");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("11%");
                    Otazka5.this.up2.setText("66%");
                    Otazka5.this.up3.setText("7%");
                    Otazka5.this.up4.setText("16%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Carol: Hi, it was New York, I am 100% sure!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 37) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What of the following is not a Dutch port?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("AMSTERDAM");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("ANTWERP");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("ROTTERDAM");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("TERNEUZEN");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("5%");
                    Otazka5.this.up2.setText("43%");
                    Otazka5.this.up3.setText("12%");
                    Otazka5.this.up4.setText("40%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Kevin: Hi, the city of Antwerp is in Belgium, so choose B)!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 38) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of Scottish national food?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("HAGGIS");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("LAGGIS");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("FAGGIS");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("LAGGIES");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("48%");
                    Otazka5.this.up2.setText("25%");
                    Otazka5.this.up3.setText("4%");
                    Otazka5.this.up4.setText("23%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Carol: Hi, it is called Haggis!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 39) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("From which country is a brand Philips?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("GERMANY");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("JAPAN");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("SOUTH KOREA");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("THE NETHERLANDS");
            this.castka = 5000;
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(4);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("20%");
                    Otazka5.this.up2.setText("22%");
                    Otazka5.this.up3.setText("26%");
                    Otazka5.this.up4.setText("32%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Kevin: I'm so sorry, but I don't know.");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 40) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where is the St. Patrick's day celebrated the most?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("IRELAND");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("DENMARK");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("RUSSIA");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("HUNGARY");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("82%");
                    Otazka5.this.up2.setText("9%");
                    Otazka5.this.up3.setText("8%");
                    Otazka5.this.up4.setText("1%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Carol: Hi, it is in Ireland!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 41) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who or what is dauhá/Dauhá?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("PERSIAN GLADIATOR");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("CITY IN QUATAR");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("PRESIDENT OF MALI");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("A GEMSTONE");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("16%");
                    Otazka5.this.up2.setText("72%");
                    Otazka5.this.up3.setText("3%");
                    Otazka5.this.up4.setText("9%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Betty: Hi, it is the capital city of Quatar!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 42) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where can we find the original Michelangelo's statue of David?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("IN FLORENCE");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("IN VENICE");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("IN ROME");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("IN VERONA");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("61%");
                    Otazka5.this.up2.setText("24%");
                    Otazka5.this.up3.setText("4%");
                    Otazka5.this.up4.setText("11%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Betty: Hi, surely in Florence!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 43) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("For what is used Richter scale?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("STORMS");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("AIR PRESSURE");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("VOLCANIC ERUPTIONS");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("EARTHQUAKES");
            this.castka = 5000;
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(4);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("19%");
                    Otazka5.this.up2.setText("4%");
                    Otazka5.this.up3.setText("23%");
                    Otazka5.this.up4.setText("54%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Betty: Hi, definitely for Earthquakes!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 47) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of Chinese currency?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("DONG");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("YEN");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("RENMINBI");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("WON");
            this.castka = 5000;
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(3);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("18%");
                    Otazka5.this.up2.setText("11%");
                    Otazka5.this.up3.setText("62%");
                    Otazka5.this.up4.setText("9%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Betty: Hi, it is a Renminbi!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 48) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which vitamin is in an orange concentrated the most?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("A");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("B");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("C");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("D");
            this.castka = 5000;
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(3);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("21%");
                    Otazka5.this.up2.setText("27%");
                    Otazka5.this.up3.setText("39%");
                    Otazka5.this.up4.setText("13%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Betty: Hi, there is a lot vitamin C.");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 49) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("The highest peak of which mountains is Mount Elbrus?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("CAUCASUS");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("ATLAS");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("ANDS");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("PAMIR");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("28%");
                    Otazka5.this.up2.setText("21%");
                    Otazka5.this.up3.setText("26%");
                    Otazka5.this.up4.setText("25%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Betty: Hi, it is the highest peak of Caucasus mountains!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 50) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What was the name of famous painter who painted the series of sunflowers?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("CLAUDE MONET");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("VINCENT VAN GOGH");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("EDGAR DEGAS");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("HIERONYMUS BOSCH");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("16%");
                    Otazka5.this.up2.setText("51%");
                    Otazka5.this.up3.setText("18%");
                    Otazka5.this.up4.setText("15%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Betty: Hi, I am sure it was Vincent van Gogh.");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 51) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the basic unit of enzymes?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("FAT");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("SUGAR");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("PROTEIN");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("OSTEOBLAST");
            this.castka = 5000;
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(3);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("18%");
                    Otazka5.this.up2.setText("14%");
                    Otazka5.this.up3.setText("56%");
                    Otazka5.this.up4.setText("12%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Betty: Hi, it is protein!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 52) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("American series The Grand Tour is about?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("CARS");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("COMPUTERS");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("ROCK CLIMBING");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("AMERICAN CULTURE");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("59%");
                    Otazka5.this.up2.setText("4%");
                    Otazka5.this.up3.setText("23%");
                    Otazka5.this.up4.setText("14%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Betty: Hi, it is about cars!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 53) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is not an American brand?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("BENTLEY");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("FORD");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("JEEP");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("CHEVROLET");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("42%");
                    Otazka5.this.up2.setText("15%");
                    Otazka5.this.up3.setText("11%");
                    Otazka5.this.up4.setText("32%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Donald: Hi, I think that Bentley is British!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 54) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where is not Christianity a dominant religion?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("DENMARK");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("PHILIPPINES");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("KYRGYZSTAN");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("MEXICO");
            this.castka = 5000;
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(3);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("11%");
                    Otazka5.this.up2.setText("7%");
                    Otazka5.this.up3.setText("73%");
                    Otazka5.this.up4.setText("9%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Donald: Hi, in Kyrgyzstan, there is Islam.");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 55) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where is the state called Lesotho?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("IN ASIA");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("IN SOUTH AMERICA");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("IN AFRICA");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("IN OCEANIA");
            this.castka = 5000;
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(3);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("29%");
                    Otazka5.this.up2.setText("13%");
                    Otazka5.this.up3.setText("41%");
                    Otazka5.this.up4.setText("17%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Donald: Hi, Lesotho is certainly in Africa!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 56) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these states is the biggest in area?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("IRELAND");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("LIBYA");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("CZECH REPUBLIC");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("HUNGARY");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("2%");
                    Otazka5.this.up2.setText("73%");
                    Otazka5.this.up3.setText("11%");
                    Otazka5.this.up4.setText("14%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Donald: Hi, that should be Libya!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 57) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of the following states is an absolute monarchy?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("QUATAR");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("VATICAN CITY");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("BENIN");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("GREAT BRITAIN");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("18%");
                    Otazka5.this.up2.setText("51%");
                    Otazka5.this.up3.setText("24%");
                    Otazka5.this.up4.setText("7%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Donald: Hey, it is Vatican city!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 58) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What does the letter K stand for in KFC?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("KANSAS");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("KATIE'S");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("KENTUCKY");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("KEITH'S");
            this.castka = 5000;
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(3);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("18%");
                    Otazka5.this.up2.setText("17%");
                    Otazka5.this.up3.setText("45%");
                    Otazka5.this.up4.setText("20%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Donald: Hi, it is Kentucky, because KFC i Kentucky Fried Chicken!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 59) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of the following islands is not in the northern hemisphere?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("MAURITIUS");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("ICELAND");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("HONSHU");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("TENERIFE");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("49%");
                    Otazka5.this.up2.setText("1%");
                    Otazka5.this.up3.setText("9%");
                    Otazka5.this.up4.setText("41%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Donald: Hi, I think that Mauricius should be in the southern hemisphere!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 60) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What of the following is not a mammal?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("CROCODILE");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("BAT");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("BLUE WHALE");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("DOLPHIN");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("65%");
                    Otazka5.this.up2.setText("23%");
                    Otazka5.this.up3.setText("11%");
                    Otazka5.this.up4.setText("1%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Donald: Hi, crocodile is definitely not a mammal!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 61) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which organ studies pneumology?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("HEART");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("LIVER");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("LUNGS");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("BRAIN");
            this.castka = 5000;
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(3);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("20%");
                    Otazka5.this.up2.setText("21%");
                    Otazka5.this.up3.setText("41%");
                    Otazka5.this.up4.setText("18%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Helen: Hi, it studies lungs, trust me!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 62) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many inches are 10 centimetres?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("3");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("4");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("5");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("6");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("42%");
                    Otazka5.this.up2.setText("45%");
                    Otazka5.this.up3.setText("8%");
                    Otazka5.this.up4.setText("5%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Nancy: Hi, it is gonna be 3 or 4 inches.");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 63) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How is often called Louis XIV of France?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("SWORD KING");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("FIRE KING");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("KING OF ENGLAND");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("SUN KING");
            this.castka = 5000;
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(4);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("23%");
                    Otazka5.this.up2.setText("19%");
                    Otazka5.this.up3.setText("12%");
                    Otazka5.this.up4.setText("46%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Nancy: Hi, D) is definitely correct!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 64) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which actor played Mr. Bean?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("ROWAN ATKINSON");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("RICHARD CURTIS");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("ROBIN DRISCOLL");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("HUGH GRANT");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("56%");
                    Otazka5.this.up2.setText("19%");
                    Otazka5.this.up3.setText("16%");
                    Otazka5.this.up4.setText("9%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Nancy: Hi, definitely Rowan Atkinson!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 65) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of the following continents is the smallest in area?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("AUSTRALIA");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("EUROPE");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("NORTH AMERICA");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("ANTARCTICA");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("42%");
                    Otazka5.this.up2.setText("28%");
                    Otazka5.this.up3.setText("3%");
                    Otazka5.this.up4.setText("27%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Nancy: Hi, I am sorry, I don't know the correct answer.");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 66) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How do we call the greatest event in Ski jumping?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("TWO HILLS TOURNAMENT");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("THREE HILLS TOURNAMENT");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("FOUR HILLS TOURNAMENT");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("FIVE HILLS TOURNAMENT");
            this.castka = 5000;
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(3);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("21%");
                    Otazka5.this.up2.setText("34%");
                    Otazka5.this.up3.setText("45%");
                    Otazka5.this.up4.setText("0%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Nancy: Hi, that's four hills tournament!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 67) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which gas causes disappearing of boats in Bermuda triangle?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("NITRIC OXIDE");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("HYDROGEN SULFIDE");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("METHANE");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("SULFUR DIOXIDE");
            this.castka = 5000;
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(3);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("12%");
                    Otazka5.this.up2.setText("19%");
                    Otazka5.this.up3.setText("39%");
                    Otazka5.this.up4.setText("30%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Nancy: Hi, it is Methane!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 68) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who wrote a novel called Don Quixote?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("MIGUEL CERVANTES");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("LOPE DE VEGA");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("PEDRO CALDERON DE LA BARCA");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("JOSE ZORRILLA");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("32%");
                    Otazka5.this.up2.setText("31%");
                    Otazka5.this.up3.setText("21%");
                    Otazka5.this.up4.setText("16%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Nancy: Hi, it was Miguel de Cervantes, trust me.");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 69) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who was killed in the sixth film of Harry Potter series?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("SIRIUS BLACK");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("ALBUS DUMBLEDORE");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("HORACE SLUGHORN");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("ARTHUR WEASLEY");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("26%");
                    Otazka5.this.up2.setText("51%");
                    Otazka5.this.up3.setText("9%");
                    Otazka5.this.up4.setText("14%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Nancy: Hi, it was Albus Dumbledore.");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 70) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which river creates natural border between Germany and France?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("WISLA");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("RHINE");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("SPREE");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("ELBE");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("26%");
                    Otazka5.this.up2.setText("33%");
                    Otazka5.this.up3.setText("25%");
                    Otazka5.this.up4.setText("16%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Nancy: Hi, the correct answer is definitely Rhine!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 71) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where was born Marvel hero Thor?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("IN HASHCABACK");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("IN ASHCABACK");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("IN HAZGUARD");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("IN ASGARD");
            this.castka = 5000;
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(4);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("12%");
                    Otazka5.this.up2.setText("14%");
                    Otazka5.this.up3.setText("25%");
                    Otazka5.this.up4.setText("49%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Helen: Hi, he was born in Asgard!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 72) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("To which name is connected J.A.R.V.I.S.?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("HARRY POTTER");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("TONY STARK");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("JON SNOW");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("SHELDON COOPER");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("13%");
                    Otazka5.this.up2.setText("58%");
                    Otazka5.this.up3.setText("18%");
                    Otazka5.this.up4.setText("11%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Helen: Hi, definitely to Tony Stark - Iron man!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 73) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which technique is not used in the High jump?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("FLOP");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("STRADDLE");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("SLAP");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("SCISSORS");
            this.castka = 5000;
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(3);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("22%");
                    Otazka5.this.up2.setText("29%");
                    Otazka5.this.up3.setText("38%");
                    Otazka5.this.up4.setText("11%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Helen: Hi, choose C)!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 74) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Gaussian elimination do we use when we want to solve what?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("QUADRATIC EQUATION");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("SYSTEM OF LINEAR EQUATIONS");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("LINEAR EQUATION");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("QUARTIC EQUATION");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("18%");
                    Otazka5.this.up2.setText("44%");
                    Otazka5.this.up3.setText("16%");
                    Otazka5.this.up4.setText("22%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Helen: Hi, I am sure that it is used for solving system of linear equations!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 75) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which colour represents French word rouge?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("YELLOW");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("BLUE");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("WHITE");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("RED");
            this.castka = 5000;
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(4);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("23%");
                    Otazka5.this.up2.setText("29%");
                    Otazka5.this.up3.setText("18%");
                    Otazka5.this.up4.setText("30%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Helen: Hi, definitely a red colour!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 76) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the speed of light in kilometres per second?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("20 000");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("30 000");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("200 000");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("300 000");
            this.castka = 5000;
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(4);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("7%");
                    Otazka5.this.up2.setText("19%");
                    Otazka5.this.up3.setText("28%");
                    Otazka5.this.up4.setText("46%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Helen: Hi, D) is correct!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 77) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who has directed the film Saving private Ryan?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("JAMES CAMERON");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("STEVEN SPIELBERG");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("WOODY ALLEN");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("TIM BURTON");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("21%");
                    Otazka5.this.up2.setText("40%");
                    Otazka5.this.up3.setText("23%");
                    Otazka5.this.up4.setText("16%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Helen: Hi, it was definitely Steven Spielberg!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 78) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is not a province of Canada?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("QUEBEC");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("BRITISH COLUMBIA");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("ALBERTA");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("NORTH DAKOTA");
            this.castka = 5000;
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(4);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("14%");
                    Otazka5.this.up2.setText("23%");
                    Otazka5.this.up3.setText("27%");
                    Otazka5.this.up4.setText("36%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Helen: Hi, North Dakota is in the USA!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 79) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What symbolizes the colours of Olympic rings?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("CONTINENTS");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("EARTH SPHERES");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("FOUNDING STATES");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("FIVE ORIGINAL DISCIPLINES");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("31%");
                    Otazka5.this.up2.setText("18%");
                    Otazka5.this.up3.setText("23%");
                    Otazka5.this.up4.setText("28%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Helen: Hi, definitely continents!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 80) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Phobos and Deimos are moons of which planet?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("MARS");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("JUPITER");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("SATURN");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("NEPTUNE");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("68%");
                    Otazka5.this.up2.setText("14%");
                    Otazka5.this.up3.setText("12%");
                    Otazka5.this.up4.setText("6%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Helen: Hi, Phobos and Deimos are moons of Mars!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 81) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which science studies, prevents and correct malpositioned teeth?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("ODOROLOGY");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("ORTHODONTICS");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("OPHTAMOLOGY");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("OOLOGY");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("18%");
                    Otazka5.this.up2.setText("64%");
                    Otazka5.this.up3.setText("14%");
                    Otazka5.this.up4.setText("4%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Helen: Hi, definitely Orthodontics!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 82) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is awarded to the worst films of a year?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("GOLDEN STRAWBERRY");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("GOLDEN RASPBERRY");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("GOLDEN BLACKBERRY");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("GOLDEN APPLE");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("28%");
                    Otazka5.this.up2.setText("29%");
                    Otazka5.this.up3.setText("21%");
                    Otazka5.this.up4.setText("22%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Helen: Hi, it is golden raspberry!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 83) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("From which philosophy is the term Yin and Yang?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("JAPAN");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("THAI");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("CHINESE");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("SINGAPORE");
            this.castka = 5000;
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(3);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("28%");
                    Otazka5.this.up2.setText("26%");
                    Otazka5.this.up3.setText("41%");
                    Otazka5.this.up4.setText("5%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Helen: Hi, definitely a Chinese philosophy!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 84) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Minotaur was half men and half?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("BEAR");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("WOLF");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("TUP");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("BULL");
            this.castka = 5000;
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(4);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("13%");
                    Otazka5.this.up2.setText("14%");
                    Otazka5.this.up3.setText("34%");
                    Otazka5.this.up4.setText("39%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Helen: Hi, it was half bull!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 85) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who fought with Germany in the Triple aliance during the 1st World war?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("AUSTRIA-HUNGARY");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("RUSSIA");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("FRANCE");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("ENGLAND");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("45%");
                    Otazka5.this.up2.setText("23%");
                    Otazka5.this.up3.setText("18%");
                    Otazka5.this.up4.setText("14%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Laura: Hi, it was definitely Austria-Hungary!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 86) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of Nemo's father from the film Finding nemo?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("EMO");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("DARLING");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("DEMO");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("MARLIN");
            this.castka = 5000;
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(4);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("19%");
                    Otazka5.this.up2.setText("12%");
                    Otazka5.this.up3.setText("22%");
                    Otazka5.this.up4.setText("47%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Michael: Hi, it is certainly Marlin!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 87) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which automobile company is led by Elon Musk?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("TESLA");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("MERCEDES-BENZ");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("BENTLEY");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("BUGATTI");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("39%");
                    Otazka5.this.up2.setText("28%");
                    Otazka5.this.up3.setText("4%");
                    Otazka5.this.up4.setText("29%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Laura: Hi, Tesla is definitely a correct answer!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 88) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In geology, how do we call a place where the litosphere is being pulled apart?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("RIFT");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("DRIFT");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("CONVERGENCE");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("DIVERGENCE");
            this.castka = 5000;
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(1);
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("32%");
                    Otazka5.this.up2.setText("14%");
                    Otazka5.this.up3.setText("27%");
                    Otazka5.this.up4.setText("27%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setEnabled(false);
                    Otazka5.this.f126u2.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up2.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Laura: Hi, it is called rift!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 89) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What of the following is not any tectonical plate?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("JUAN DE FUCA PLATE");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("NAZCA PLATE");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("COCOS PLATE");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("HILLARY PLATE");
            this.castka = 5000;
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(4);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("12%");
                    Otazka5.this.up2.setText("12%");
                    Otazka5.this.up3.setText("32%");
                    Otazka5.this.up4.setText("44%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setEnabled(false);
                    Otazka5.this.f127u3.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up3.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Jiří: Čau, severní deska určitě neexistuje.");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 90) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which car factory has named its cars after letters of Greek alphabet?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("ALFA ROMEO");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("LANCIA");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("SEAT");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("FIAT");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("38%");
                    Otazka5.this.up2.setText("45%");
                    Otazka5.this.up3.setText("14%");
                    Otazka5.this.up4.setText("3%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Nicolaus: Hi, that's easy, it is Lancia!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 91) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which iceland is being occupied by Turkey from 1974?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("MADAGASCAR");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("CYPRUS");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("MALTA");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("ST. THOMAS");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("28%");
                    Otazka5.this.up2.setText("55%");
                    Otazka5.this.up3.setText("3%");
                    Otazka5.this.up4.setText("14%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Boris: Hi, that's easy, Cyprus is correct!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 92) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("The Government Inspector by Nikolai Gogol is?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("PROSE");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("DRAMA");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("POETRY");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("BALLAD");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("18%");
                    Otazka5.this.up2.setText("65%");
                    Otazka5.this.up3.setText("3%");
                    Otazka5.this.up4.setText("14%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Michael: Hi, it is drama!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 93) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who played the main role in the film A Star is Born (2018)?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("RIHANNA");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("LADY GAGA");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("CARA DELEVIGNE");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("SELENA GOMEZ");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("20%");
                    Otazka5.this.up2.setText("51%");
                    Otazka5.this.up3.setText("7%");
                    Otazka5.this.up4.setText("22%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Jeremy: Hi, Lady Gaga should be correct!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 94) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which football club won the Champions league 3 times in a row?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("SK SLAVIA PRAGUE");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("REAL MADRID CF");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("FC BARCELONA");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("CHELSEA FC");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("7%");
                    Otazka5.this.up2.setText("51%");
                    Otazka5.this.up3.setText("22%");
                    Otazka5.this.up4.setText("20%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Jeremy: Hey, that's clear! Real Madrid CF!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 95) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who created character Forrest Gump?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("WILLIAM SHAKESPEARE");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("WINSTON GROOM");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("F. F. FITZGERALD");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("STEPHEN KING");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("2%");
                    Otazka5.this.up2.setText("61%");
                    Otazka5.this.up3.setText("15%");
                    Otazka5.this.up4.setText("22%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Philip: Hi, I think it should be Winston Groom.");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 96) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which team won the world championship in football in Russia 2018?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("BELGIUM");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("FRANCE");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("PORTUGAL");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("ENGLAND");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("18%");
                    Otazka5.this.up2.setText("43%");
                    Otazka5.this.up3.setText("22%");
                    Otazka5.this.up4.setText("17%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Jeremy: Hi, 100% it was France!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        } else if (this.losovane == 97) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of the paper sizes is the smallest?");
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setText("A2");
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setText("B3");
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setText("A1");
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setText("B2");
            this.castka = 5000;
            this.f126u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.Spravna(2);
                }
            });
            this.f125u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f127u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.f128u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.gameOver2(Otazka5.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka5.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unl.setEnabled(false);
                    Otazka5.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up1.setText("28%");
                    Otazka5.this.up2.setText("43%");
                    Otazka5.this.up3.setText("15%");
                    Otazka5.this.up4.setText("14%");
                    Otazka5.this.pomocnapromenna5 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unp.setEnabled(false);
                    Otazka5.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setEnabled(false);
                    Otazka5.this.f125u1.setVisibility(4);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setEnabled(false);
                    Otazka5.this.f128u4.setVisibility(4);
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up1.setVisibility(4);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.up4.setVisibility(4);
                    Otazka5.this.pomocnapromennap5 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka5.this.unt.setEnabled(false);
                    Otazka5.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka5.this);
                    builder.setMessage((CharSequence) "Jeremy: Hi, definitely B3!");
                    builder.create().show();
                    Otazka5.this.pomocnapromennat5 = 1;
                }
            });
        }
        this.dvere = (Button) findViewById(C1760R.C1762id.dvere);
        this.dvere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Otazka5.this.castka = 5000;
                Otazka5.this.gameOver();
                if (Otazka5.this.castka > Otazka5.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                    Otazka5.this.highscore(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
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
        this.castka = 0;
        this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f125u1.setEnabled(false);
        this.f126u2.setEnabled(false);
        this.f127u3.setEnabled(false);
        this.f128u4.setEnabled(false);
        if (i != 0) {
            int parseColor = Color.parseColor("#ffaa00");
            this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
            this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
            this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
            this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
            if (i == 1) {
                this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f125u1.setTextColor(parseColor);
                this.f125u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up1.setTextColor(parseColor);
            } else if (i == 2) {
                this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f126u2.setTextColor(parseColor);
                this.f126u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up2.setTextColor(parseColor);
            } else if (i == 3) {
                this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f127u3.setTextColor(parseColor);
                this.f127u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up3.setTextColor(parseColor);
            } else if (i == 4) {
                this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f128u4.setTextColor(parseColor);
                this.f128u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up4.setTextColor(parseColor);
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    int parseColor = Color.parseColor("#fcff0202");
                    int parseColor2 = Color.parseColor("#1dc700");
                    Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                    Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                    Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                    Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    if (i == 1) {
                        Otazka5.this.f125u1.setTextColor(parseColor);
                        Otazka5.this.f125u1.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka5.this.up1.setTextColor(parseColor);
                    } else if (i == 2) {
                        Otazka5.this.f126u2.setTextColor(parseColor);
                        Otazka5.this.f126u2.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka5.this.up2.setTextColor(parseColor);
                    } else if (i == 3) {
                        Otazka5.this.f127u3.setTextColor(parseColor);
                        Otazka5.this.f127u3.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka5.this.up3.setTextColor(parseColor);
                    } else if (i == 4) {
                        Otazka5.this.f128u4.setTextColor(parseColor);
                        Otazka5.this.f128u4.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka5.this.up4.setTextColor(parseColor);
                    }
                    if (i2 == 1) {
                        Otazka5.this.f125u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka5.this.f125u1.setTextColor(parseColor2);
                        Otazka5.this.up1.setTextColor(parseColor2);
                    } else if (i2 == 2) {
                        Otazka5.this.f126u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka5.this.f126u2.setTextColor(parseColor2);
                        Otazka5.this.up2.setTextColor(parseColor2);
                    } else if (i2 == 3) {
                        Otazka5.this.f127u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka5.this.f127u3.setTextColor(parseColor2);
                        Otazka5.this.up3.setTextColor(parseColor2);
                    } else if (i2 == 4) {
                        Otazka5.this.f128u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka5.this.f128u4.setTextColor(parseColor2);
                        Otazka5.this.up4.setTextColor(parseColor2);
                    }
                    Intent intent = new Intent(Otazka5.this, BackgroundSoundService.class);
                    intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                    Otazka5.this.stopService(intent);
                    Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka5.this).getBoolean("ZVUK", true));
                    Otazka5.this.spatna = MediaPlayer.create(Otazka5.this, C1760R.raw.spatna2);
                    if (z && valueOf.booleanValue()) {
                        Otazka5.this.spatna.start();
                    }
                }
            }, 1500);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Otazka5.this.alertDialog();
                    if (Otazka5.this.mInterstitialAd.isLoaded()) {
                        Otazka5.this.mInterstitialAd.show();
                    }
                }
            }, 3500);
            this.castka = 0;
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
        this.castka = 500;
        Intent intent2 = new Intent(this, PopActivity.class);
        intent2.putExtra("Level", this.level);
        intent2.putExtra("Castka", this.castka);
        intent2.putExtra("pomocnapromenna", this.pomocnapromenna5);
        intent2.putExtra("pomocnapromennap", this.pomocnapromennap5);
        intent2.putExtra("pomocnapromennat", this.pomocnapromennat5);
        startActivity(intent2);
        this.mCountDownTimer.cancel();
    }

    /* access modifiers changed from: private */
    public void highscore(int i) {
        if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true)).booleanValue()) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    MediaPlayer.create(Otazka5.this, C1760R.raw.applause7).start();
                }
            }, (long) i);
        }
        SharedPreferences sharedPreferences = getSharedPreferences("GAME_DATA", 0);
        sharedPreferences.getInt("HIGH_SCORE", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("HIGH_SCORE", this.castka);
        edit.commit();
    }

    /* access modifiers changed from: private */
    public void Spravna(final int i) {
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_5", 0);
        int i2 = sharedPreferences.getInt("x", -1) + 1;
        SharedPreferences.Editor edit = getSharedPreferences("zodpovezene_5", 0).edit();
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
        this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f125u1.setEnabled(false);
        this.f126u2.setEnabled(false);
        this.f127u3.setEnabled(false);
        this.f128u4.setEnabled(false);
        if (i == 1) {
            this.f125u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f125u1.setTextColor(parseColor);
            this.f125u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up1.setTextColor(parseColor);
        } else if (i == 2) {
            this.f126u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f126u2.setTextColor(parseColor);
            this.f126u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up2.setTextColor(parseColor);
        } else if (i == 3) {
            this.f127u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f127u3.setTextColor(parseColor);
            this.f127u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up3.setTextColor(parseColor);
        } else {
            this.f128u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f128u4.setTextColor(parseColor);
            this.f128u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up4.setTextColor(parseColor);
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka5.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                Otazka5.this.stopService(intent);
                int parseColor = Color.parseColor("#1dc700");
                Otazka5.this.up1 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up1);
                Otazka5.this.up2 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up2);
                Otazka5.this.up3 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up3);
                Otazka5.this.up4 = (TextView) Otazka5.this.findViewById(C1760R.C1762id.up4);
                if (i == 1) {
                    Otazka5.this.f125u1 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka5.this.f125u1.setTextColor(parseColor);
                    Otazka5.this.f125u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka5.this.up1.setTextColor(parseColor);
                } else if (i == 2) {
                    Otazka5.this.f126u2 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka5.this.f126u2.setTextColor(parseColor);
                    Otazka5.this.f126u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka5.this.up2.setTextColor(parseColor);
                } else if (i == 3) {
                    Otazka5.this.f127u3 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka5.this.f127u3.setTextColor(parseColor);
                    Otazka5.this.f127u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka5.this.up3.setTextColor(parseColor);
                } else {
                    Otazka5.this.f128u4 = (Button) Otazka5.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka5.this.f128u4.setTextColor(parseColor);
                    Otazka5.this.f128u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka5.this.up4.setTextColor(parseColor);
                }
                if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka5.this).getBoolean("ZVUK", true)).booleanValue()) {
                    MediaPlayer.create(Otazka5.this, C1760R.raw.applause2).start();
                }
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka5.this, Otazka6.class);
                intent.putExtra("some_key5", Otazka5.this.pomocnapromenna5);
                intent.putExtra("some_keyp5", Otazka5.this.pomocnapromennap5);
                intent.putExtra("some_keyt5", Otazka5.this.pomocnapromennat5);
                Otazka5.this.startActivity(intent);
                CustomIntent.customType(Otazka5.this, "left-to-right");
            }
        }, 2500);
    }

    public void onRewardedVideoAdClosed() {
        loadRewardedVideoAd();
        SharedPreferences sharedPreferences = getSharedPreferences("GAME_DATA", 0);
        int i = sharedPreferences.getInt("MINCE", 0);
        if (i > 0) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("MINCE", i - 1);
            edit.commit();
            Intent intent = new Intent(this, Otazka6.class);
            this.mCountDownTimer.cancel();
            intent.putExtra("some_key5", this.pomocnapromenna5);
            intent.putExtra("some_keyp5", this.pomocnapromennap5);
            intent.putExtra("some_keyt5", this.pomocnapromennat5);
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
        this.castka = 0;
        if (this.gameOver && isActivityVisible()) {
            Intent intent = new Intent(this, PopActivity.class);
            intent.putExtra("Level", this.level);
            intent.putExtra("Castka", this.castka);
            intent.putExtra("pomocnapromenna", this.pomocnapromenna5);
            intent.putExtra("pomocnapromennap", this.pomocnapromennap5);
            intent.putExtra("pomocnapromennat", this.pomocnapromennat5);
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
