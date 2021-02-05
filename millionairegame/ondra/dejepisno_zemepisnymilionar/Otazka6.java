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
import android.support.p000v4.view.InputDeviceCompat;
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

public class Otazka6 extends AppCompatActivity implements RewardedVideoAdListener {
    private static boolean activityVisible;
    Button Zvuk;

    /* renamed from: a */
    final int f129a = 0;

    /* renamed from: a4 */
    Button f130a4;
    ArrayList<Integer> arl = new ArrayList<>();

    /* renamed from: b */
    final int f131b = 0;

    /* renamed from: b4 */
    Button f132b4;
    Button b4p;
    Button button5_1;
    Button buttonp5_1;
    Button buttont5_1;

    /* renamed from: c4 */
    Button f133c4;
    Button c4p;
    int castka;

    /* renamed from: d4 */
    Button f134d4;
    Button dvere;
    RadioGroup fuhrer1;
    boolean gameOver = false;

    /* renamed from: i */
    int f135i = 0;
    int[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79};
    TextView label;
    int level = 6;
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
    int pomocnapromenna6;
    int pomocnapromennap6;
    int pomocnapromennat6;
    TextView proc1;
    TextView proc2;
    TextView proc3;
    TextView proc4;

    /* renamed from: r */
    Random f136r;
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
    Button f137u1;

    /* renamed from: u2 */
    Button f138u2;

    /* renamed from: u3 */
    Button f139u3;

    /* renamed from: u4 */
    Button f140u4;
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
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_6", 0);
        int i = sharedPreferences.getInt("x", -1) + 1;
        System.out.println(i + "!!!!");
        SharedPreferences sharedPreferences2 = getSharedPreferences("zodpovezene_6", 0);
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
        this.f136r = new Random();
        this.castka = 0;
        if (this.arl.size() == 0) {
            sharedPreferences.edit().clear().commit();
            sharedPreferences2.edit().clear().commit();
            int i5 = getSharedPreferences("zodpovezene_6", 0).getInt("x", -1) + 1;
            System.out.println(i5 + "!!!!");
            SharedPreferences sharedPreferences3 = getSharedPreferences("zodpovezene_6", 0);
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
        this.losovane = this.f136r.nextInt(this.arl.size());
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
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(Otazka6.this);
                Boolean valueOf = Boolean.valueOf(defaultSharedPreferences.getBoolean("ZVUK", true));
                Intent intent = new Intent(Otazka6.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                if (valueOf.booleanValue()) {
                    SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                    edit.putBoolean("ZVUK", false);
                    edit.commit();
                    Otazka6.this.stopService(intent);
                    Otazka6.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukvypnuto);
                    return;
                }
                SharedPreferences.Editor edit2 = defaultSharedPreferences.edit();
                edit2.putBoolean("ZVUK", true);
                edit2.commit();
                Otazka6.this.startService(intent);
                Otazka6.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukzapnuto);
            }
        });
        this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f137u1.setTextColor(-1);
        this.f137u1.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f138u2.setTextColor(-1);
        this.f138u2.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f139u3.setTextColor(-1);
        this.f139u3.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f140u4.setTextColor(-1);
        this.f140u4.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
        this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
        this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
        this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
        this.up1.setTextColor(-1);
        this.up2.setTextColor(-1);
        this.up3.setTextColor(-1);
        this.up4.setTextColor(-1);
        this.textview6 = (TextView) findViewById(C1760R.C1762id.textView6);
        this.textview6.setTextColor(InputDeviceCompat.SOURCE_ANY);
        this.textview5 = (TextView) findViewById(C1760R.C1762id.textView5);
        this.textview5.setTextColor(-1);
        this.textview2 = (TextView) findViewById(C1760R.C1762id.textView2);
        this.textview2.setText("300$");
        this.textview3 = (TextView) findViewById(C1760R.C1762id.textView3);
        this.textview3.setText("500$");
        this.textview4 = (TextView) findViewById(C1760R.C1762id.textView4);
        this.textview4.setText("1K");
        this.textview4.setBackgroundResource(C1760R.C1761drawable.textview2);
        this.textview4.setTypeface(Typeface.DEFAULT_BOLD);
        this.textview5 = (TextView) findViewById(C1760R.C1762id.textView5);
        this.textview5.setText("2K");
        this.textview5.setBackgroundResource(C1760R.C1761drawable.textview);
        this.textview5.setTypeface(Typeface.DEFAULT);
        this.textview6 = (TextView) findViewById(C1760R.C1762id.textView6);
        this.textview6.setText("5K");
        this.textview6.setBackgroundResource(C1760R.C1761drawable.textview);
        this.textview6.setTypeface(Typeface.DEFAULT);
        this.textview7 = (TextView) findViewById(C1760R.C1762id.textView7);
        this.textview7.setText("10K");
        this.textview8 = (TextView) findViewById(C1760R.C1762id.textView8);
        this.textview8.setText("20K");
        this.textview8.setBackgroundResource(C1760R.C1761drawable.textview2);
        this.textview8.setTypeface(Typeface.DEFAULT_BOLD);
        this.otazkaza = (TextView) findViewById(C1760R.C1762id.otazkaza);
        this.otazkaza.setText("2 000$ Question");
        this.mProgressBar = (ProgressBar) findViewById(C1760R.C1762id.progressBar3);
        this.mProgressBar.setProgress(this.f135i);
        this.mCountDownTimer = new CountDownTimer(40000, 1000) {
            public void onTick(long j) {
                Log.v("Log_tag", "Tick of Progress" + Otazka6.this.f135i + j);
                Otazka6 otazka6 = Otazka6.this;
                otazka6.f135i = otazka6.f135i + 1;
                Otazka6.this.mProgressBar.setProgress((Otazka6.this.f135i * 100) / 40);
            }

            public void onFinish() {
                Otazka6.this.f135i++;
                Otazka6.this.mProgressBar.setProgress(100);
                Otazka6.this.uzivatelOdpovedel = false;
                Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 0, 0);
            }
        };
        this.mCountDownTimer.start();
        int i9 = getIntent().getExtras().getInt("some_key5");
        int i10 = getIntent().getExtras().getInt("some_keyp5");
        if (getIntent().getExtras().getInt("some_keyt5") == 1) {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(false);
            this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
            this.pomocnapromennat6 = 1;
        } else {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(true);
        }
        if (i10 == 1) {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(false);
            this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
            this.pomocnapromennap6 = 1;
        } else {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(true);
        }
        if (i9 == 1) {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(false);
            this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
            this.pomocnapromenna6 = 1;
        } else {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(true);
        }
        this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f137u1.setEnabled(true);
        this.f138u2.setEnabled(true);
        this.f139u3.setEnabled(true);
        this.f140u4.setEnabled(true);
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
            this.otazkau.setText("To which island was exiled Napoleon?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("GORGONA");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("TINETTO");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("HIERRO");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("ELBA");
            this.castka = 10000;
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(4);
                }
            });
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("12%");
                    Otazka6.this.up2.setText("7%");
                    Otazka6.this.up3.setText("15%");
                    Otazka6.this.up4.setText("66%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Charlie: Hi, to Elba, I'm sure!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 2) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which function is inverse to exponentiation?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("LOGARITHM");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("QUADRATIC");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("SINE");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("COSINE");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("63%");
                    Otazka6.this.up2.setText("10%");
                    Otazka6.this.up3.setText("15%");
                    Otazka6.this.up4.setText("12%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Charlie: Hi, the correct answer is logarithm!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 3) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these cities is not one of Germany's federal state?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("BREMEN");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("HAMBURG");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("MUNICH");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("BERLIN");
            this.castka = 10000;
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(3);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("31%");
                    Otazka6.this.up2.setText("16%");
                    Otazka6.this.up3.setText("42%");
                    Otazka6.this.up4.setText("11%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Charlie: Hi, Munich is a part of Bavaria, so choose C)!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 4) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many Cervical vertebrae are there in a human body?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("1");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("3");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("5");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("7");
            this.castka = 10000;
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(4);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("4%");
                    Otazka6.this.up2.setText("23%");
                    Otazka6.this.up3.setText("32%");
                    Otazka6.this.up4.setText("41%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Charlie: Hi, definitely 7!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 5) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What do we measure with hygrometer?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("HYDROSTATIC PRESSURE");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("WATER DENSITY");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("GRAVITATION");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("HUMIDITY");
            this.castka = 10000;
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(4);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("31%");
                    Otazka6.this.up2.setText("27%");
                    Otazka6.this.up3.setText("4%");
                    Otazka6.this.up4.setText("38%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Charlie: Hey, it should be humidity!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 6) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What of the following is Chondrichthyes (cartilaginous fish)?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("SHARK");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("DOPLHIN");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("JIB");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("SALMON");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("55%");
                    Otazka6.this.up2.setText("12%");
                    Otazka6.this.up3.setText("24%");
                    Otazka6.this.up4.setText("9%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Charlie: Hi, it is Shark!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 7) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What produces brand Intel?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("CARS");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("TRAINS");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("CPUs");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("BRUSHCUTTERS");
            this.castka = 10000;
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(3);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("11%");
                    Otazka6.this.up2.setText("7%");
                    Otazka6.this.up3.setText("63%");
                    Otazka6.this.up4.setText("19%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Charlie: Hi, definitely CPUs!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 8) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where can we find Moai statues?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("SALMON ISLAND");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("TAHITI");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("FIJI");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("EASTER ISLAND");
            this.castka = 10000;
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(4);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("14%");
                    Otazka6.this.up2.setText("9%");
                    Otazka6.this.up3.setText("17%");
                    Otazka6.this.up4.setText("60%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Charlie: Hi, definitely on Easter island!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 9) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which river can we find in Budapest?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("ELBE");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("RHINE");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("DANUBE");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("SAVA");
            this.castka = 10000;
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(3);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("29%");
                    Otazka6.this.up2.setText("14%");
                    Otazka6.this.up3.setText("46%");
                    Otazka6.this.up4.setText("11%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Charlie: Hi, certainly Danube!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 10) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How do we call government institution which should eliminate heresy?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("PROHIBITION");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("INQUISITION");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("ANNOTATION");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("DEVISION");
            this.castka = 10000;
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(2);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("6%");
                    Otazka6.this.up2.setText("56%");
                    Otazka6.this.up3.setText("15%");
                    Otazka6.this.up4.setText("23%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Charlie: Hi, I think it is an inquisition!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 11) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Attack on what caused the US entry into World War II?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("LEXINGTON BAY");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("GRAND FORTRESS");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("IRVINE BASE");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("PEARL HARBOR");
            this.castka = 10000;
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(4);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("11%");
                    Otazka6.this.up2.setText("18%");
                    Otazka6.this.up3.setText("10%");
                    Otazka6.this.up4.setText("61%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Olvia: Hi, 100% on Pearl Harbor!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 12) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who was Giuseppe Arcimboldo?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("PAINTER");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("SCULPTOR");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("PLAYWRITER");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("BOTANIST");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("53%");
                    Otazka6.this.up2.setText("27%");
                    Otazka6.this.up3.setText("12%");
                    Otazka6.this.up4.setText("8%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Olivia: Hi, definitely a painter!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 13) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which element was discovered by Marie Curie?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("MOLYBDENUM");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("PLUTONIUM");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("DUBNIUM");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("POLONIUM");
            this.castka = 10000;
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(4);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("12%");
                    Otazka6.this.up2.setText("7%");
                    Otazka6.this.up3.setText("15%");
                    Otazka6.this.up4.setText("66%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Olivia: Hi, 100% it was Polonium!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 14) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which units do we measure capacitance?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("CANDELAS");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("COULOMBS");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("FARADS");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("VOLTS");
            this.castka = 10000;
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(3);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("18%");
                    Otazka6.this.up2.setText("20%");
                    Otazka6.this.up3.setText("46%");
                    Otazka6.this.up4.setText("16%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Jeremy: Hi, I am 100% sure that Farads are the correct answer!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 15) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where took place the final negotiations after the World War I?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("LAUSANNE");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("BRUSSELS");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("VERSAILLES");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("LONDON");
            this.castka = 10000;
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(3);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("6%");
                    Otazka6.this.up2.setText("36%");
                    Otazka6.this.up3.setText("43%");
                    Otazka6.this.up4.setText("15%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Jeremy: Hi, definitely in Versailles!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 16) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who ruled England in the times of Wiliam Shakespeare?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("VICTORIA");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("ELISABETH I");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("WILLIAM, PRINCE OF ORANGE");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("JAMES II.");
            this.castka = 10000;
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(2);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("18%");
                    Otazka6.this.up2.setText("55%");
                    Otazka6.this.up3.setText("11%");
                    Otazka6.this.up4.setText("16%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Jeremy: Hi, that's clear! It was Elisabeth I.");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 17) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name for the best quality coal?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("ANTHRACITE");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("LIGNITE");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("PHTALITE");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("TETRALITE");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("64%");
                    Otazka6.this.up2.setText("26%");
                    Otazka6.this.up3.setText("9%");
                    Otazka6.this.up4.setText("1%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Jeremy: Hi, it is Anthracite!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 18) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Platelets are created from?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("ERYTHROCYTES");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("MEGAKARYOCYTES");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("LYMPHOCYTE T");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("LYMPHOCYTE B");
            this.castka = 10000;
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(2);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("11%");
                    Otazka6.this.up2.setText("45%");
                    Otazka6.this.up3.setText("23%");
                    Otazka6.this.up4.setText("21%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Jeremy: Hi, it is created of megakaryocytes!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 19) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What can't be found in Arctic?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("HARBOR SEAL");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("POLAR BEAR");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("POLAR FOX");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("EMPEROR PENGUIN");
            this.castka = 10000;
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(4);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("14%");
                    Otazka6.this.up2.setText("18%");
                    Otazka6.this.up3.setText("23%");
                    Otazka6.this.up4.setText("45%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Jeremy: Hi, choose D).");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 20) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("To which gulf flows rivers Brahmaputra and Ganges?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("BENGAL");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("THAI");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("BHAVNAGAR");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("OMAN");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("54%");
                    Otazka6.this.up2.setText("18%");
                    Otazka6.this.up3.setText("22%");
                    Otazka6.this.up4.setText("6%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Jeremy: Hi, it is a bay of Bengal!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 21) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the capital of Equador?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("QUITO");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("LOJA");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("PORTOVIEJO");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("LA PAZ");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("57%");
                    Otazka6.this.up2.setText("6%");
                    Otazka6.this.up3.setText("6%");
                    Otazka6.this.up4.setText("31%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Richard: Hi, it is certainly Quito!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 22) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who was the first to measure atmospheric pressure using Mercury?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("TORRICELLI");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("ACHILLINI");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("MOLDINI");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("AQUILLANI");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("74%");
                    Otazka6.this.up2.setText("12%");
                    Otazka6.this.up3.setText("2%");
                    Otazka6.this.up4.setText("12%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Richard: Hi, it was Torricelli!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 23) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these vitamins is dissolved in fats?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("A");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("B7");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("B12");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("C");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("53%");
                    Otazka6.this.up2.setText("14%");
                    Otazka6.this.up3.setText("21%");
                    Otazka6.this.up4.setText("12%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Richard: Hi, definitely vitamin A!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 24) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which treaty solved dividing the world to Portugal and Spain?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("COMPOSTELLA");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("PHAR");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("TORDESILLAS");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("SEVILLA");
            this.castka = 10000;
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(3);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("27%");
                    Otazka6.this.up2.setText("15%");
                    Otazka6.this.up3.setText("52%");
                    Otazka6.this.up4.setText("6%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Richard: Hi, I think it was the treate of Tordesillas.");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 25) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many carbons are there in Acetic acid?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("1");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("2");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("3");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("4");
            this.castka = 10000;
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(2);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("18%");
                    Otazka6.this.up2.setText("37%");
                    Otazka6.this.up3.setText("24%");
                    Otazka6.this.up4.setText("21%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Richard: Hi, I think that there are 2.");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 26) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("From which country was Catherine II (Catherine the Great)?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("HABSBURG MONARCHY");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("ENGLAND");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("TURKEY");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("RUSSIA");
            this.castka = 10000;
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(4);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("24%");
                    Otazka6.this.up2.setText("16%");
                    Otazka6.this.up3.setText("17%");
                    Otazka6.this.up4.setText("43%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Richard: Hi, she was from Russia!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 27) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where ruled Gustavus Adolphus?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("SWEDEN");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("FINLAND");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("NORWAY");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("DENMARK");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("36%");
                    Otazka6.this.up2.setText("14%");
                    Otazka6.this.up3.setText("17%");
                    Otazka6.this.up4.setText("33%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Richard: Hi, he ruled in Sweden!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 28) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who or what is Cumulonimbus?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("FAMOUS CARTOGRAPH");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("ONE OF VERTEBRAS");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("TYPE OF CLOUD");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("CRUSTACEAN");
            this.castka = 10000;
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(3);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("20%");
                    Otazka6.this.up2.setText("22%");
                    Otazka6.this.up3.setText("31%");
                    Otazka6.this.up4.setText("27%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Richard: Hi, it is certainly a type of cloud!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 29) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Svalbard (Spitsbergen) is owned by which country?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("RUSSIA");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("SWITZERLAND");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("NORWAY");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("DENMARK");
            this.castka = 10000;
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(3);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("26%");
                    Otazka6.this.up2.setText("4%");
                    Otazka6.this.up3.setText("39%");
                    Otazka6.this.up4.setText("31%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Richard: Hi, it is owned by Norway!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 30) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which units do we measure luminous intensity?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("CANDELAS");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("SIEMENSES");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("MOLS");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("KIRCHHOFFS");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("47%");
                    Otazka6.this.up2.setText("16%");
                    Otazka6.this.up3.setText("4%");
                    Otazka6.this.up4.setText("33%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Richard: Hi, I think that the correct answer is A).");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 31) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What was the nationality of Rudolf Diesel?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("BELGIAN");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("DUTCH");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("GERMAN");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("AUSTRIAN");
            this.castka = 10000;
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(3);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("32%");
                    Otazka6.this.up2.setText("11%");
                    Otazka6.this.up3.setText("37%");
                    Otazka6.this.up4.setText("20%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Emily: Hi, I can't decide between Germany and Belgium.");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 32) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where can we find appendix?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("NEARBY PANCREAS");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("IN LIVER");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("IN STOMACH");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("IN LARGE INTESTINES");
            this.castka = 10000;
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(4);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("25%");
                    Otazka6.this.up2.setText("25%");
                    Otazka6.this.up3.setText("21%");
                    Otazka6.this.up4.setText("29%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Emily: Hi, it is in large intestines!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 33) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these can not be considered Earth’s movement?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("NUTATION");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("PRECESSION");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("ROTATION");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("RULATION");
            this.castka = 10000;
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(4);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("24%");
                    Otazka6.this.up2.setText("21%");
                    Otazka6.this.up3.setText("9%");
                    Otazka6.this.up4.setText("46%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Lily: Hi, I think you should choose D)!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 34) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where does the beer Heineken come from?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("NETHERLANDS");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("ENGLAND");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("BELGIUM");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("GERMANY");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("39%");
                    Otazka6.this.up2.setText("5%");
                    Otazka6.this.up3.setText("27%");
                    Otazka6.this.up4.setText("29%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Olivia: Hi, definitely from the Netherlands!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 35) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("George Stephenson is known for the improvement of?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("WHEELE");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("AIRPLANE");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("LOCOMOTIVE");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("CAR");
            this.castka = 10000;
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(3);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("28%");
                    Otazka6.this.up2.setText("15%");
                    Otazka6.this.up3.setText("33%");
                    Otazka6.this.up4.setText("24%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Olivia: Hi, it was definitely a locomotive!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 36) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where was born Wolfgang Amadeus Mozart?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("IN SALZBURG");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("IN VIENNA");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("IN INNSBRUCK");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("IN LINZ");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("43%");
                    Otazka6.this.up2.setText("24%");
                    Otazka6.this.up3.setText("18%");
                    Otazka6.this.up4.setText("15%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Emily: Hi, he was born in Salzburg, trust me!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 37) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who is connected to the term Great Purge (Great terror)?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("HITLER");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("STALIN");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("MUSSOLINI");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("FRANCO");
            this.castka = 10000;
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(2);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("34%");
                    Otazka6.this.up2.setText("51%");
                    Otazka6.this.up3.setText("9%");
                    Otazka6.this.up4.setText("6%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Emily: Hi, 100% Stalin!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 38) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which band sang all songs for the film Transformers?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("GREEN DAY");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("MY CHEMICAL ROMANCE");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("FOO FIGHTERS");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("LINKIN PARK");
            this.castka = 10000;
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(4);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("16%");
                    Otazka6.this.up2.setText("12%");
                    Otazka6.this.up3.setText("19%");
                    Otazka6.this.up4.setText("53%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Emily: Hi, it was definitely Linkin Park.");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 39) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What of the following has been directed by Matt Groening?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("PHINEAS AND FERB");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("TOM AND JERRY");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("THE GUMMI BEARS");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("THE SIMPSONS");
            this.castka = 10000;
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(4);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("24%");
                    Otazka6.this.up2.setText("19%");
                    Otazka6.this.up3.setText("14%");
                    Otazka6.this.up4.setText("43%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Emily: Hi, definitely the Simpsons!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 40) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What does the German word Personenkraftwagen mean?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("STOPPING TRAIN");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("CAR");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("GENERAL PRACTITIONER");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("LIFE INSURANCE");
            this.castka = 10000;
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(2);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("19%");
                    Otazka6.this.up2.setText("45%");
                    Otazka6.this.up3.setText("15%");
                    Otazka6.this.up4.setText("21%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Olivia: Hi, definitely a car!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 41) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is produced by brand Rossignol?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("SKIS");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("LIGHT-EMITTING DIODS (LEDs)");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("UNDERWEAR");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("CHOCOLATE");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("38%");
                    Otazka6.this.up2.setText("14%");
                    Otazka6.this.up3.setText("19%");
                    Otazka6.this.up4.setText("29%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Jessica: Hi, it produces skis, I am sure!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 42) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these is connected with coins?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("NUMISMATICS");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("HERALDRY");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("SIGILLOGRAPHY");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("CAMPANOLOGY");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("49%");
                    Otazka6.this.up2.setText("17%");
                    Otazka6.this.up3.setText("19%");
                    Otazka6.this.up4.setText("15%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Charlotte: Hi, choose numismatics!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 43) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these art movements is named after Claude Monet’s painting?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("NATURALISM");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("FUTURISM");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("IMPRESSIONISM");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("SECESSION");
            this.castka = 10000;
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(3);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("24%");
                    Otazka6.this.up2.setText("17%");
                    Otazka6.this.up3.setText("37%");
                    Otazka6.this.up4.setText("22%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Charlotte: Hi, definitely impressionism!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 44) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these movements was made famous by Émile Zola?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("IMPRESSIONISM");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("SYMBOLISM");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("NATURALISM");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("REALISM");
            this.castka = 10000;
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(3);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("29%");
                    Otazka6.this.up2.setText("14%");
                    Otazka6.this.up3.setText("32%");
                    Otazka6.this.up4.setText("25%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Charlotte: Hi, definitely naturalism!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 45) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these is the god of war in Greek mythology?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("POSEIDÓN");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("APOLLÓN");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("ÁRES");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("MARS");
            this.castka = 10000;
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(3);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("9%");
                    Otazka6.this.up2.setText("13%");
                    Otazka6.this.up3.setText("41%");
                    Otazka6.this.up4.setText("37%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Charlotte: Hi, choose C)!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 46) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Mixed race of Caucasian and Indian is?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("MULATTO");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("ZAMBO");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("MESTIZO");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("EPICANTH");
            this.castka = 10000;
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(3);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("13%");
                    Otazka6.this.up2.setText("28%");
                    Otazka6.this.up3.setText("44%");
                    Otazka6.this.up4.setText("15%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Charlotte: Hi, C) is correct!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 47) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where was created LEGO?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("IN DENMARK");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("IN SWEDEN");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("IN BELGIUM");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("IN GERMANY");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("36%");
                    Otazka6.this.up2.setText("19%");
                    Otazka6.this.up3.setText("17%");
                    Otazka6.this.up4.setText("28%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Jessica: Hi, LEGO is from Denmark!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 48) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of a hurricane that made landfall in New Orleans in 2005?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("IRMA");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("KATRINA");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("SANDY");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("HARVEY");
            this.castka = 10000;
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(2);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("14%");
                    Otazka6.this.up2.setText("66%");
                    Otazka6.this.up3.setText("9%");
                    Otazka6.this.up4.setText("11%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Jessica: Hi, it was hurricane Katrina!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 49) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is a greek word for bone?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("MUSCULUS");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("OSTEON");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("PROCESSUS");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("FORNIX");
            this.castka = 10000;
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(2);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("6%");
                    Otazka6.this.up2.setText("43%");
                    Otazka6.this.up3.setText("28%");
                    Otazka6.this.up4.setText("23%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Jessica: Hi, I think it should be Osteon.");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 50) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What studies histology?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("TISSUES");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("AMPHIBIANS");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("INSECT");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("PROTOZOA");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("63%");
                    Otazka6.this.up2.setText("21%");
                    Otazka6.this.up3.setText("13%");
                    Otazka6.this.up4.setText("3%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Jessica: Hi, definitely tissues!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 51) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is not an island country?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("HONDURAS");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("HAITI");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("PUORTO RICO");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("TRINIDAD AND TOBAGO");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("56%");
                    Otazka6.this.up2.setText("6%");
                    Otazka6.this.up3.setText("13%");
                    Otazka6.this.up4.setText("25%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Mia: Hi, it is Honduras!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 52) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Into which bay do rivers Parana and Uruguay lead?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("LA PLATA");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("SAN MATIAS");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("NUEVO");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("BAHÍA BLANCA");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("54%");
                    Otazka6.this.up2.setText("20%");
                    Otazka6.this.up3.setText("12%");
                    Otazka6.this.up4.setText("14%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Charlotte: Hey, that's clear, it is La Plata!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 53) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which muscle type can not be found in human’s body?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("SKELETAL STRIATED");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("THICK");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("CARDIAC");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("SMOOTH");
            this.castka = 10000;
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(2);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("6%");
                    Otazka6.this.up2.setText("47%");
                    Otazka6.this.up3.setText("21%");
                    Otazka6.this.up4.setText("26%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Charlotte: Hi, I think that there is not any thick muscle type.");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 54) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("New Stone Age is also known as?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("NEOLITHIC");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("ENEOLITHIC");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("PALEOLITHIC");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("MEZOLITHIC");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("58%");
                    Otazka6.this.up2.setText("16%");
                    Otazka6.this.up3.setText("21%");
                    Otazka6.this.up4.setText("5%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Mia: Hi, it is definitely neolithic!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 55) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which continent has the highest average altitude?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("ASIA");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("ANTARCTICA");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("SOUTH AMERICA");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("AFRICA");
            this.castka = 10000;
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(2);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("28%");
                    Otazka6.this.up2.setText("47%");
                    Otazka6.this.up3.setText("2%");
                    Otazka6.this.up4.setText("23%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Charlotte: Hi, it is Antarctica!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 56) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these geological ages can be placed into Paleozoic?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("TRIASSIC");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("PALEOCENE");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("CARBONIFEROUS");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("JURASSIC");
            this.castka = 10000;
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(3);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("17%");
                    Otazka6.this.up2.setText("25%");
                    Otazka6.this.up3.setText("34%");
                    Otazka6.this.up4.setText("24%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Charlotte: Hi, C) is correct!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 57) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where can we find Hadrian's wall?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("IN GREAT BRITAIN");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("IN LITHUANA");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("IN BELGIUM");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("IN UKRAINE");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("34%");
                    Otazka6.this.up2.setText("15%");
                    Otazka6.this.up3.setText("19%");
                    Otazka6.this.up4.setText("32%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Mia: Hi, it is in the Great Britain!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 58) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Main component of granite is not?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("QUARTZ");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("TOPAZ");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("FELDSPAR");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("MICA");
            this.castka = 10000;
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(2);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("9%");
                    Otazka6.this.up2.setText("34%");
                    Otazka6.this.up3.setText("29%");
                    Otazka6.this.up4.setText("28%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Lucy: Hi, I think that you should choose B).");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 59) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who released legendary song Imagine on 11th of October 1971?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("DAVID BOWIE");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("MICK JAGGER");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("JOHN LENNON");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("FREDDIE MERCURY");
            this.castka = 10000;
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(3);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("29%");
                    Otazka6.this.up2.setText("11%");
                    Otazka6.this.up3.setText("35%");
                    Otazka6.this.up4.setText("25%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Mia: Hi, it was certainly John Lennon!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 60) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who is not a member of Commonwealth?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("USA");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("GHANA");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("CANADA");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("INDIA");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("39%");
                    Otazka6.this.up2.setText("36%");
                    Otazka6.this.up3.setText("11%");
                    Otazka6.this.up4.setText("14%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Mia: Hi, definitely USA!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 61) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where will be held the world football championship in 2022?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("IN QUATAR");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("IN BAHRAIN");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("IN SAUDI ARABIA");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("IN YEMEN");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("36%");
                    Otazka6.this.up2.setText("22%");
                    Otazka6.this.up3.setText("27%");
                    Otazka6.this.up4.setText("15%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Lily: Hi, definitely in Quatar!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 62) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which city was established by Stalin?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("YEKATERINBURG");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("MAGNITOGORSK");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("KAZAN");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("NOVOSIBIRSK");
            this.castka = 10000;
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(2);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("19%");
                    Otazka6.this.up2.setText("32%");
                    Otazka6.this.up3.setText("22%");
                    Otazka6.this.up4.setText("27%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Lily: Hi, I think it was Magnitogorsk.");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 63) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the jewish pogrom from 1938 called?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("CRYSTAL NIGHT");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("QUARTZ NIGHT");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("NIGHT OF STABBING WEAPONS");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("NIGHT OF THE LONG KNIVES");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("40%");
                    Otazka6.this.up2.setText("8%");
                    Otazka6.this.up3.setText("19%");
                    Otazka6.this.up4.setText("33%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Lucy: Hey. certainly A).");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 64) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these states is the biggest in area?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("CANADA");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("USA");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("CHINA");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("BRAZIL");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("28%");
                    Otazka6.this.up2.setText("27%");
                    Otazka6.this.up3.setText("24%");
                    Otazka6.this.up4.setText("21%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Lily: Hi, definitely Canada!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 65) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who founded Francia?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("CLOVIS");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("CHARLES MARTEL");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("CHARLES THE GREAT");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("HENRY I.");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("39%");
                    Otazka6.this.up2.setText("28%");
                    Otazka6.this.up3.setText("25%");
                    Otazka6.this.up4.setText("8%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Lucy: Hi, it was Clovis!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 66) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these minerals does not contain lead?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("ANGLESSITE");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("CERUSSITE");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("GALENA");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("MAGNESITE");
            this.castka = 10000;
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(4);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("22%");
                    Otazka6.this.up2.setText("29%");
                    Otazka6.this.up3.setText("18%");
                    Otazka6.this.up4.setText("31%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Lucy: Hi, choose D)!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 67) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How do we call an exploding star?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("SUPERVIDA");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("SUPERVICA");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("SUPERCORONE");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("SUPERNOVA");
            this.castka = 10000;
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(4);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("17%");
                    Otazka6.this.up2.setText("16%");
                    Otazka6.this.up3.setText("28%");
                    Otazka6.this.up4.setText("39%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Lily: Hi, definitely Supernova!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 68) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which car factory was established in Detroit in 1911?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("CHEVROLET");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("JEEP");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("BENTLEY");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("JAGUAR");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("54%");
                    Otazka6.this.up2.setText("19%");
                    Otazka6.this.up3.setText("18%");
                    Otazka6.this.up4.setText("9%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Lily: Hi, I think it should be Chevrolet.");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 69) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where do most of the Southeast Asian rivers originate?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("NEPAL");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("BHUTAN");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("TIBET");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("INDIA");
            this.castka = 10000;
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(3);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("30%");
                    Otazka6.this.up2.setText("33%");
                    Otazka6.this.up3.setText("36%");
                    Otazka6.this.up4.setText("1%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Lucy: Hi, 100% in Tibet!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 70) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these seas has the highest salinity level?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("RED");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("MEDITERRANEAN");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("BLACK");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("BALTIC");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("56%");
                    Otazka6.this.up2.setText("25%");
                    Otazka6.this.up3.setText("14%");
                    Otazka6.this.up4.setText("5%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Lucy: I am so sorry, but I don't know.");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 71) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("During the isochoric process, which one of these stays the same?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("PRESSURE");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("VOLUME");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("TEMPERATURE");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("EVERYTHING");
            this.castka = 10000;
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(2);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("29%");
                    Otazka6.this.up2.setText("35%");
                    Otazka6.this.up3.setText("10%");
                    Otazka6.this.up4.setText("26%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Lucy: Hi, definitely volume!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 72) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where were the first Winter Olympics in 1924 held?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("CHAMONIX");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("LAUSANNE");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("ST. MAURICE");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("GRENOBLE");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("32%");
                    Otazka6.this.up2.setText("30%");
                    Otazka6.this.up3.setText("14%");
                    Otazka6.this.up4.setText("24%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Lucy: Hi, definitely in Lausanne!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 73) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which type of medicine lower body’s temperature?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("ANTIBIOTICS");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("ANTIVIRALS");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("ANTIPYRETICS");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("ANTIFIBRICS");
            this.castka = 10000;
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(3);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("25%");
                    Otazka6.this.up2.setText("9%");
                    Otazka6.this.up3.setText("34%");
                    Otazka6.this.up4.setText("32%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Vaness: Choose C), should be correct.");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 74) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these does not belong into the International System of Units?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("OHM");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("AMPERE");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("WATT");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("COULOMB");
            this.castka = 10000;
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(2);
                }
            });
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("29%");
                    Otazka6.this.up2.setText("35%");
                    Otazka6.this.up3.setText("4%");
                    Otazka6.this.up4.setText("32%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setEnabled(false);
                    Otazka6.this.f137u1.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up1.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Lucy: Hi I think it is Ampere.");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 75) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where can we find the famous San Andreas rift?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("CALIFORNIA");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("LOUSIANA");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("INDONESIA");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("PHILIPPINES");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("45%");
                    Otazka6.this.up2.setText("10%");
                    Otazka6.this.up3.setText("23%");
                    Otazka6.this.up4.setText("22%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Lucy: Hi, in California, 100%.");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 76) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who wrote a collection of short stories South of No North?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("CHARLES BUKOWSKI");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("JACK KEROUAC");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("CARLO LEVI");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("ALBERT CAMUS");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("45%");
                    Otazka6.this.up2.setText("6%");
                    Otazka6.this.up3.setText("13%");
                    Otazka6.this.up4.setText("36%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Lucy: Hi, I am sure it was Charles Bukowski!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 77) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What type of animal is common swift?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("BIRD");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("RODENT");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("SNAKE");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("FROG");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("45%");
                    Otazka6.this.up2.setText("35%");
                    Otazka6.this.up3.setText("13%");
                    Otazka6.this.up4.setText("7%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Lucy: Hi, it is a bird!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 78) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("When did Titanic sink?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("1912");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("1889");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("1913");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("2019");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("55%");
                    Otazka6.this.up2.setText("2%");
                    Otazka6.this.up3.setText("43%");
                    Otazka6.this.up4.setText("0%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setEnabled(false);
                    Otazka6.this.f139u3.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up3.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "James: Hi, it was in April 1912!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        } else if (this.losovane == 79) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the capital city of Armenia?");
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setText("YEREVAN");
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setText("TBILISI");
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setText("KANTON");
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setText("ALMATY");
            this.castka = 10000;
            this.f137u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.Spravna(1);
                }
            });
            this.f138u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f139u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.f140u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.gameOver2(Otazka6.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka6.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unl.setEnabled(false);
                    Otazka6.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up1.setText("38%");
                    Otazka6.this.up2.setText("26%");
                    Otazka6.this.up3.setText("14%");
                    Otazka6.this.up4.setText("22%");
                    Otazka6.this.pomocnapromenna6 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unp.setEnabled(false);
                    Otazka6.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setEnabled(false);
                    Otazka6.this.f140u4.setVisibility(4);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setEnabled(false);
                    Otazka6.this.f138u2.setVisibility(4);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.up4.setVisibility(4);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up2.setVisibility(4);
                    Otazka6.this.pomocnapromennap6 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka6.this.unt.setEnabled(false);
                    Otazka6.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka6.this);
                    builder.setMessage((CharSequence) "Elisabeth: Hi, it is 100% Yerevan!");
                    builder.create().show();
                    Otazka6.this.pomocnapromennat6 = 1;
                }
            });
        }
        this.dvere = (Button) findViewById(C1760R.C1762id.dvere);
        this.dvere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Otazka6.this.castka = 10000;
                Otazka6.this.gameOver();
                if (Otazka6.this.castka > Otazka6.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                    Otazka6.this.highscore(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
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
        this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f137u1.setEnabled(false);
        this.f138u2.setEnabled(false);
        this.f139u3.setEnabled(false);
        this.f140u4.setEnabled(false);
        if (i != 0) {
            int parseColor = Color.parseColor("#ffaa00");
            this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
            this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
            this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
            this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
            if (i == 1) {
                this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f137u1.setTextColor(parseColor);
                this.f137u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up1.setTextColor(parseColor);
            } else if (i == 2) {
                this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f138u2.setTextColor(parseColor);
                this.f138u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up2.setTextColor(parseColor);
            } else if (i == 3) {
                this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f139u3.setTextColor(parseColor);
                this.f139u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up3.setTextColor(parseColor);
            } else if (i == 4) {
                this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f140u4.setTextColor(parseColor);
                this.f140u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up4.setTextColor(parseColor);
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    int parseColor = Color.parseColor("#fcff0202");
                    int parseColor2 = Color.parseColor("#1dc700");
                    Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                    Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                    Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                    Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    if (i == 1) {
                        Otazka6.this.f137u1.setTextColor(parseColor);
                        Otazka6.this.f137u1.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka6.this.up1.setTextColor(parseColor);
                    } else if (i == 2) {
                        Otazka6.this.f138u2.setTextColor(parseColor);
                        Otazka6.this.f138u2.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka6.this.up2.setTextColor(parseColor);
                    } else if (i == 3) {
                        Otazka6.this.f139u3.setTextColor(parseColor);
                        Otazka6.this.f139u3.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka6.this.up3.setTextColor(parseColor);
                    } else if (i == 4) {
                        Otazka6.this.f140u4.setTextColor(parseColor);
                        Otazka6.this.f140u4.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka6.this.up4.setTextColor(parseColor);
                    }
                    if (i2 == 1) {
                        Otazka6.this.f137u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka6.this.f137u1.setTextColor(parseColor2);
                        Otazka6.this.up1.setTextColor(parseColor2);
                    } else if (i2 == 2) {
                        Otazka6.this.f138u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka6.this.f138u2.setTextColor(parseColor2);
                        Otazka6.this.up2.setTextColor(parseColor2);
                    } else if (i2 == 3) {
                        Otazka6.this.f139u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka6.this.f139u3.setTextColor(parseColor2);
                        Otazka6.this.up3.setTextColor(parseColor2);
                    } else if (i2 == 4) {
                        Otazka6.this.f140u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka6.this.f140u4.setTextColor(parseColor2);
                        Otazka6.this.up4.setTextColor(parseColor2);
                    }
                    Intent intent = new Intent(Otazka6.this, BackgroundSoundService.class);
                    intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                    Otazka6.this.stopService(intent);
                    Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka6.this).getBoolean("ZVUK", true));
                    Otazka6.this.spatna = MediaPlayer.create(Otazka6.this, C1760R.raw.spatna2);
                    if (z && valueOf.booleanValue()) {
                        Otazka6.this.spatna.start();
                    }
                }
            }, 1500);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Otazka6.this.alertDialog();
                    if (Otazka6.this.mInterstitialAd.isLoaded()) {
                        Otazka6.this.mInterstitialAd.show();
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
        this.castka = 1000;
        Intent intent2 = new Intent(this, PopActivity.class);
        intent2.putExtra("Level", this.level);
        intent2.putExtra("Castka", this.castka);
        intent2.putExtra("pomocnapromenna", this.pomocnapromenna6);
        intent2.putExtra("pomocnapromennap", this.pomocnapromennap6);
        intent2.putExtra("pomocnapromennat", this.pomocnapromennat6);
        startActivity(intent2);
        this.mCountDownTimer.cancel();
    }

    /* access modifiers changed from: private */
    public void Spravna(final int i) {
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_6", 0);
        int i2 = sharedPreferences.getInt("x", -1) + 1;
        SharedPreferences.Editor edit = getSharedPreferences("zodpovezene_6", 0).edit();
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
        this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f137u1.setEnabled(false);
        this.f138u2.setEnabled(false);
        this.f139u3.setEnabled(false);
        this.f140u4.setEnabled(false);
        if (i == 1) {
            this.f137u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f137u1.setTextColor(parseColor);
            this.f137u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up1.setTextColor(parseColor);
        } else if (i == 2) {
            this.f138u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f138u2.setTextColor(parseColor);
            this.f138u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up2.setTextColor(parseColor);
        } else if (i == 3) {
            this.f139u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f139u3.setTextColor(parseColor);
            this.f139u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up3.setTextColor(parseColor);
        } else {
            this.f140u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f140u4.setTextColor(parseColor);
            this.f140u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up4.setTextColor(parseColor);
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka6.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                Otazka6.this.stopService(intent);
                int parseColor = Color.parseColor("#1dc700");
                Otazka6.this.up1 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up1);
                Otazka6.this.up2 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up2);
                Otazka6.this.up3 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up3);
                Otazka6.this.up4 = (TextView) Otazka6.this.findViewById(C1760R.C1762id.up4);
                if (i == 1) {
                    Otazka6.this.f137u1 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka6.this.f137u1.setTextColor(parseColor);
                    Otazka6.this.f137u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka6.this.up1.setTextColor(parseColor);
                } else if (i == 2) {
                    Otazka6.this.f138u2 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka6.this.f138u2.setTextColor(parseColor);
                    Otazka6.this.f138u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka6.this.up2.setTextColor(parseColor);
                } else if (i == 3) {
                    Otazka6.this.f139u3 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka6.this.f139u3.setTextColor(parseColor);
                    Otazka6.this.f139u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka6.this.up3.setTextColor(parseColor);
                } else {
                    Otazka6.this.f140u4 = (Button) Otazka6.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka6.this.f140u4.setTextColor(parseColor);
                    Otazka6.this.f140u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka6.this.up4.setTextColor(parseColor);
                }
                if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka6.this).getBoolean("ZVUK", true)).booleanValue()) {
                    MediaPlayer.create(Otazka6.this, C1760R.raw.applause2).start();
                }
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka6.this, Otazka7.class);
                intent.putExtra("some_key6", Otazka6.this.pomocnapromenna6);
                intent.putExtra("some_keyp6", Otazka6.this.pomocnapromennap6);
                intent.putExtra("some_keyt6", Otazka6.this.pomocnapromennat6);
                Otazka6.this.startActivity(intent);
                CustomIntent.customType(Otazka6.this, "left-to-right");
            }
        }, 2500);
    }

    /* access modifiers changed from: private */
    public void highscore(int i) {
        if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true)).booleanValue()) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    MediaPlayer.create(Otazka6.this, C1760R.raw.applause7).start();
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
            Intent intent = new Intent(this, Otazka7.class);
            this.mCountDownTimer.cancel();
            intent.putExtra("some_key6", this.pomocnapromenna6);
            intent.putExtra("some_keyp6", this.pomocnapromennap6);
            intent.putExtra("some_keyt6", this.pomocnapromennat6);
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
            intent.putExtra("pomocnapromenna", this.pomocnapromenna6);
            intent.putExtra("pomocnapromennap", this.pomocnapromennap6);
            intent.putExtra("pomocnapromennat", this.pomocnapromennat6);
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
