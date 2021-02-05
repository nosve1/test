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

public class Otazka11 extends AppCompatActivity implements RewardedVideoAdListener {
    private static boolean activityVisible;
    Button Zvuk;

    /* renamed from: a */
    final int f56a = 0;
    ArrayList<Integer> arl = new ArrayList<>();

    /* renamed from: b */
    final int f57b = 0;
    Button button;
    int castka;

    /* renamed from: d8 */
    Button f58d8;
    Button dvere;
    RadioGroup fuhrer1;
    boolean gameOver = false;

    /* renamed from: i */
    int f59i = 0;
    int[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    TextView label;
    int level = 11;
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
    int pomocnapromenna11;
    int pomocnapromennap11;
    int pomocnapromennat11;

    /* renamed from: r */
    Random f60r;
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
    TextView textview9;

    /* renamed from: u1 */
    Button f61u1;

    /* renamed from: u2 */
    Button f62u2;

    /* renamed from: u3 */
    Button f63u3;

    /* renamed from: u4 */
    Button f64u4;
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
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_11", 0);
        int i = sharedPreferences.getInt("x", -1) + 1;
        System.out.println(i + "!!!!");
        SharedPreferences sharedPreferences2 = getSharedPreferences("zodpovezene_11", 0);
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
        this.f60r = new Random();
        this.castka = 0;
        if (this.arl.size() == 0) {
            sharedPreferences.edit().clear().commit();
            sharedPreferences2.edit().clear().commit();
            int i5 = getSharedPreferences("zodpovezene_11", 0).getInt("x", -1) + 1;
            System.out.println(i5 + "!!!!");
            SharedPreferences sharedPreferences3 = getSharedPreferences("zodpovezene_11", 0);
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
        this.losovane = this.f60r.nextInt(this.arl.size());
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
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(Otazka11.this);
                Boolean valueOf = Boolean.valueOf(defaultSharedPreferences.getBoolean("ZVUK", true));
                Intent intent = new Intent(Otazka11.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                if (valueOf.booleanValue()) {
                    SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                    edit.putBoolean("ZVUK", false);
                    edit.commit();
                    Otazka11.this.stopService(intent);
                    Otazka11.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukvypnuto);
                    return;
                }
                SharedPreferences.Editor edit2 = defaultSharedPreferences.edit();
                edit2.putBoolean("ZVUK", true);
                edit2.commit();
                Otazka11.this.startService(intent);
                Otazka11.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukzapnuto);
            }
        });
        this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f61u1.setTextColor(-1);
        this.f61u1.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f62u2.setTextColor(-1);
        this.f62u2.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f63u3.setTextColor(-1);
        this.f63u3.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f64u4.setTextColor(-1);
        this.f64u4.setBackgroundResource(C1760R.C1761drawable.button_bg);
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
        this.otazkaza = (TextView) findViewById(C1760R.C1762id.otazkaza);
        this.otazkaza.setText("80 000$ Question");
        this.mProgressBar = (ProgressBar) findViewById(C1760R.C1762id.progressBar3);
        this.mProgressBar.setProgress(this.f59i);
        this.mCountDownTimer = new CountDownTimer(40000, 1000) {
            public void onTick(long j) {
                Log.v("Log_tag", "Tick of Progress" + Otazka11.this.f59i + j);
                Otazka11 otazka11 = Otazka11.this;
                otazka11.f59i = otazka11.f59i + 1;
                Otazka11.this.mProgressBar.setProgress((Otazka11.this.f59i * 100) / 40);
            }

            public void onFinish() {
                Otazka11.this.f59i++;
                Otazka11.this.mProgressBar.setProgress(100);
                Otazka11.this.uzivatelOdpovedel = false;
                Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 0, 0);
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
        this.textview4.setBackgroundResource(C1760R.C1761drawable.textview);
        this.textview4.setTypeface(Typeface.DEFAULT);
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
        int i9 = getIntent().getExtras().getInt("some_key10");
        int i10 = getIntent().getExtras().getInt("some_keyp10");
        if (getIntent().getExtras().getInt("some_keyt10") == 1) {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(false);
            this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
            this.pomocnapromennat11 = 1;
        } else {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(true);
        }
        if (i10 == 1) {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(false);
            this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
            this.pomocnapromennap11 = 1;
        } else {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(true);
        }
        if (i9 == 1) {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(false);
            this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
            this.pomocnapromenna11 = 1;
        } else {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(true);
        }
        this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f61u1.setEnabled(true);
        this.f62u2.setEnabled(true);
        this.f63u3.setEnabled(true);
        this.f64u4.setEnabled(true);
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
            this.otazkau.setText("What is the name of a mosquito, that causes malaria?");
            this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f61u1.setText("AEDES");
            this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f62u2.setText("CULEX");
            this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f63u3.setText("ANOPHELES");
            this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f64u4.setText("TOXORHYNCHITES");
            this.castka = 160000;
            this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f63u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.Spravna(3);
                }
            });
            this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f61u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f62u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f64u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unl.setEnabled(false);
                    Otazka11.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up1.setText("31%");
                    Otazka11.this.up2.setText("14%");
                    Otazka11.this.up3.setText("34%");
                    Otazka11.this.up4.setText("21%");
                    Otazka11.this.pomocnapromenna11 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unp.setEnabled(false);
                    Otazka11.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka11.this.f62u2 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka11.this.f64u4 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up4.setVisibility(4);
                    Otazka11.this.up2.setVisibility(4);
                    Otazka11.this.f64u4.setVisibility(4);
                    Otazka11.this.f62u2.setVisibility(4);
                    Otazka11.this.f62u2.setEnabled(false);
                    Otazka11.this.f64u4.setEnabled(false);
                    Otazka11.this.pomocnapromennap11 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unt.setEnabled(false);
                    Otazka11.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka11.this);
                    builder.setMessage((CharSequence) "Martin: I think it’s Anophales.");
                    builder.create().show();
                    Otazka11.this.pomocnapromennat11 = 1;
                }
            });
        } else if (this.losovane == 2) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How long does it take for Earth to revolve once around it’s axis?(Sidereal day)");
            this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f61u1.setText("23 h 59 min");
            this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f62u2.setText("23 h 56 min");
            this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f63u3.setText("23 h 57 min");
            this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f64u4.setText("24 h");
            this.castka = 500000;
            this.f62u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.Spravna(2);
                }
            });
            this.f61u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f63u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f64u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unl.setEnabled(false);
                    Otazka11.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up1.setText("28%");
                    Otazka11.this.up2.setText("26%");
                    Otazka11.this.up3.setText("24%");
                    Otazka11.this.up4.setText("21%");
                    Otazka11.this.pomocnapromenna11 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unp.setEnabled(false);
                    Otazka11.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka11.this.f64u4 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka11.this.f64u4.setEnabled(false);
                    Otazka11.this.f64u4.setVisibility(4);
                    Otazka11.this.f63u3 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka11.this.f63u3.setEnabled(false);
                    Otazka11.this.f63u3.setVisibility(4);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up4.setVisibility(4);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up3.setVisibility(4);
                    Otazka11.this.pomocnapromennap11 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unt.setEnabled(false);
                    Otazka11.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka11.this);
                    builder.setMessage((CharSequence) "Dominic: Hey, it takes 23h a 56min. I know it for sure, you can trust me.");
                    builder.create().show();
                    Otazka11.this.pomocnapromennat11 = 1;
                }
            });
        } else if (this.losovane == 3) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("The band “Lordi” comes from which country?");
            this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f61u1.setText("SWEDEN");
            this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f62u2.setText("NORWAY");
            this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f63u3.setText("FINLAND");
            this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f64u4.setText("RUSSIA");
            this.castka = 500000;
            this.f63u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.Spravna(3);
                }
            });
            this.f61u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f62u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f64u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unl.setEnabled(false);
                    Otazka11.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up1.setText("24%");
                    Otazka11.this.up2.setText("24%");
                    Otazka11.this.up3.setText("28%");
                    Otazka11.this.up4.setText("24%");
                    Otazka11.this.pomocnapromenna11 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unp.setEnabled(false);
                    Otazka11.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka11.this.f64u4 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka11.this.f64u4.setEnabled(false);
                    Otazka11.this.f64u4.setVisibility(4);
                    Otazka11.this.f61u1 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka11.this.f61u1.setEnabled(false);
                    Otazka11.this.f61u1.setVisibility(4);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up4.setVisibility(4);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up1.setVisibility(4);
                    Otazka11.this.pomocnapromennap11 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unt.setEnabled(false);
                    Otazka11.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka11.this);
                    builder.setMessage((CharSequence) "Arthur: Hi, I’m sorry but I have no idea.");
                    builder.create().show();
                    Otazka11.this.pomocnapromennat11 = 1;
                }
            });
        } else if (this.losovane == 4) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How long does it take for moon to reach it’s New Moon phase?");
            this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f61u1.setText("28 DAYS");
            this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f62u2.setText("30 DAYS");
            this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f63u3.setText("28,5 DAYS");
            this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f64u4.setText("29,5 DAYS");
            this.castka = 500000;
            this.f64u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.Spravna(4);
                }
            });
            this.f61u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f62u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f63u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unl.setEnabled(false);
                    Otazka11.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up1.setText("24%");
                    Otazka11.this.up2.setText("23%");
                    Otazka11.this.up3.setText("26%");
                    Otazka11.this.up4.setText("27%");
                    Otazka11.this.pomocnapromenna11 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unp.setEnabled(false);
                    Otazka11.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka11.this.f63u3 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka11.this.f63u3.setEnabled(false);
                    Otazka11.this.f63u3.setVisibility(4);
                    Otazka11.this.f61u1 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka11.this.f61u1.setEnabled(false);
                    Otazka11.this.f61u1.setVisibility(4);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up3.setVisibility(4);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up1.setVisibility(4);
                    Otazka11.this.pomocnapromennap11 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unt.setEnabled(false);
                    Otazka11.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka11.this);
                    builder.setMessage((CharSequence) "Edward: Hello, I’m sorry but I don’t think I can help you.");
                    builder.create().show();
                    Otazka11.this.pomocnapromennat11 = 1;
                }
            });
        } else if (this.losovane == 5) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these African countries is situated south of the equator?");
            this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f61u1.setText("ETHIOPIA");
            this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f62u2.setText("NIGERIA");
            this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f63u3.setText("ZAMBIA");
            this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f64u4.setText("CHAD");
            this.castka = 500000;
            this.f63u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.Spravna(3);
                }
            });
            this.f61u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f62u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f64u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unl.setEnabled(false);
                    Otazka11.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up1.setText("26%");
                    Otazka11.this.up2.setText("22%");
                    Otazka11.this.up3.setText("28%");
                    Otazka11.this.up4.setText("24%");
                    Otazka11.this.pomocnapromenna11 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unp.setEnabled(false);
                    Otazka11.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka11.this.f61u1 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka11.this.f61u1.setEnabled(false);
                    Otazka11.this.f61u1.setVisibility(4);
                    Otazka11.this.f62u2 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka11.this.f62u2.setEnabled(false);
                    Otazka11.this.f62u2.setVisibility(4);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up1.setVisibility(4);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up2.setVisibility(4);
                    Otazka11.this.pomocnapromennap11 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unt.setEnabled(false);
                    Otazka11.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka11.this);
                    builder.setMessage((CharSequence) "Robert: Hi, I think it’s Zambia.");
                    builder.create().show();
                    Otazka11.this.pomocnapromennat11 = 1;
                }
            });
        } else if (this.losovane == 6) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What does the Russian word “Kremlin” stand for?");
            this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f61u1.setText("FREEDOM");
            this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f62u2.setText("HOPE");
            this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f63u3.setText("UNITY");
            this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f64u4.setText("GOVERNMENT");
            this.castka = 500000;
            this.f63u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.Spravna(3);
                }
            });
            this.f61u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f62u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f64u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unl.setEnabled(false);
                    Otazka11.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up1.setText("22%");
                    Otazka11.this.up2.setText("24%");
                    Otazka11.this.up3.setText("28%");
                    Otazka11.this.up4.setText("26%");
                    Otazka11.this.pomocnapromenna11 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unp.setEnabled(false);
                    Otazka11.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka11.this.f62u2 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka11.this.f62u2.setEnabled(false);
                    Otazka11.this.f62u2.setVisibility(4);
                    Otazka11.this.f61u1 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka11.this.f61u1.setEnabled(false);
                    Otazka11.this.f61u1.setVisibility(4);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up2.setVisibility(4);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up1.setVisibility(4);
                    Otazka11.this.pomocnapromennap11 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unt.setEnabled(false);
                    Otazka11.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka11.this);
                    builder.setMessage((CharSequence) "Claire: Hi, I don’t know.");
                    builder.create().show();
                    Otazka11.this.pomocnapromennat11 = 1;
                }
            });
        } else if (this.losovane == 7) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these countries is considered absolute monarchy?");
            this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f61u1.setText("OMAN");
            this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f62u2.setText("CUBA");
            this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f63u3.setText("MONGOLIA");
            this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f64u4.setText("CHINA");
            this.castka = 500000;
            this.f61u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.Spravna(1);
                }
            });
            this.f62u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f63u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f64u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unl.setEnabled(false);
                    Otazka11.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up1.setText("39%");
                    Otazka11.this.up2.setText("24%");
                    Otazka11.this.up3.setText("25%");
                    Otazka11.this.up4.setText("12%");
                    Otazka11.this.pomocnapromenna11 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unp.setEnabled(false);
                    Otazka11.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka11.this.f64u4 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka11.this.f64u4.setEnabled(false);
                    Otazka11.this.f64u4.setVisibility(4);
                    Otazka11.this.f63u3 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka11.this.f63u3.setEnabled(false);
                    Otazka11.this.f63u3.setVisibility(4);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up4.setVisibility(4);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up3.setVisibility(4);
                    Otazka11.this.pomocnapromennap11 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unt.setEnabled(false);
                    Otazka11.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka11.this);
                    builder.setMessage((CharSequence) "Lucy: Hey, I know it is not China or Cuba for sure.");
                    builder.create().show();
                    Otazka11.this.pomocnapromennat11 = 1;
                }
            });
        } else if (this.losovane == 8) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where was the first European university founded?");
            this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f61u1.setText("CAMBRIDGE");
            this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f62u2.setText("LONDON");
            this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f63u3.setText("MILAN");
            this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f64u4.setText("BOLOGNA");
            this.castka = 500000;
            this.f64u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.Spravna(4);
                }
            });
            this.f61u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f62u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f63u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unl.setEnabled(false);
                    Otazka11.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up1.setText("29%");
                    Otazka11.this.up2.setText("29%");
                    Otazka11.this.up3.setText("13%");
                    Otazka11.this.up4.setText("29%");
                    Otazka11.this.pomocnapromenna11 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unp.setEnabled(false);
                    Otazka11.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka11.this.f63u3 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka11.this.f63u3.setEnabled(false);
                    Otazka11.this.f63u3.setVisibility(4);
                    Otazka11.this.f61u1 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka11.this.f61u1.setEnabled(false);
                    Otazka11.this.f61u1.setVisibility(4);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up3.setVisibility(4);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up1.setVisibility(4);
                    Otazka11.this.pomocnapromennap11 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unt.setEnabled(false);
                    Otazka11.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka11.this);
                    builder.setMessage((CharSequence) "Henry: Hello, I don’t know either.");
                    builder.create().show();
                    Otazka11.this.pomocnapromennat11 = 1;
                }
            });
        } else if (this.losovane == 9) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("il Prete Rosso is a nickname of which one of these?");
            this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f61u1.setText("GARIBALDI");
            this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f62u2.setText("GALILEO");
            this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f63u3.setText("VIVALDI");
            this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f64u4.setText("POLO");
            this.castka = 500000;
            this.f63u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.Spravna(3);
                }
            });
            this.f61u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f62u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f64u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unl.setEnabled(false);
                    Otazka11.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up1.setText("30%");
                    Otazka11.this.up2.setText("21%");
                    Otazka11.this.up3.setText("29%");
                    Otazka11.this.up4.setText("20%");
                    Otazka11.this.pomocnapromenna11 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unp.setEnabled(false);
                    Otazka11.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka11.this.f61u1 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka11.this.f61u1.setEnabled(false);
                    Otazka11.this.f61u1.setVisibility(4);
                    Otazka11.this.f64u4 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka11.this.f64u4.setEnabled(false);
                    Otazka11.this.f64u4.setVisibility(4);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up1.setVisibility(4);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up4.setVisibility(4);
                    Otazka11.this.pomocnapromennap11 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unt.setEnabled(false);
                    Otazka11.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka11.this);
                    builder.setMessage((CharSequence) "Simon: Hi, I’m sorry but I can’t help you.");
                    builder.create().show();
                    Otazka11.this.pomocnapromennat11 = 1;
                }
            });
        } else if (this.losovane == 10) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What does “myopia” stand for?");
            this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f61u1.setText("SHORTSIGHTEDNESS");
            this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f62u2.setText("COLOR BLINDNESS");
            this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f63u3.setText("FARSIGHTEDNESS");
            this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f64u4.setText("BLINDNESS");
            this.castka = 500000;
            this.f61u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.Spravna(1);
                }
            });
            this.f62u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f63u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f64u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unl.setEnabled(false);
                    Otazka11.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up1.setText("30%");
                    Otazka11.this.up2.setText("29%");
                    Otazka11.this.up3.setText("28%");
                    Otazka11.this.up4.setText("13%");
                    Otazka11.this.pomocnapromenna11 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unp.setEnabled(false);
                    Otazka11.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka11.this.f62u2 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka11.this.f62u2.setEnabled(false);
                    Otazka11.this.f62u2.setVisibility(4);
                    Otazka11.this.f63u3 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka11.this.f63u3.setEnabled(false);
                    Otazka11.this.f63u3.setVisibility(4);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up2.setVisibility(4);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up3.setVisibility(4);
                    Otazka11.this.pomocnapromennap11 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unt.setEnabled(false);
                    Otazka11.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka11.this);
                    builder.setMessage((CharSequence) "Claudia: Hi, it’s shortsightedness.");
                    builder.create().show();
                    Otazka11.this.pomocnapromennat11 = 1;
                }
            });
        } else if (this.losovane == 11) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which year was the movie “Toy Story” released?");
            this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f61u1.setText(NativeAppInstallAd.ASSET_CALL_TO_ACTION);
            this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f62u2.setText(NativeAppInstallAd.ASSET_HEADLINE);
            this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f63u3.setText("1996");
            this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f64u4.setText("1995");
            this.castka = 500000;
            this.f64u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.Spravna(4);
                }
            });
            this.f61u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f62u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f63u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unl.setEnabled(false);
                    Otazka11.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up1.setText("25%");
                    Otazka11.this.up2.setText("23%");
                    Otazka11.this.up3.setText("25%");
                    Otazka11.this.up4.setText("27%");
                    Otazka11.this.pomocnapromenna11 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unp.setEnabled(false);
                    Otazka11.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka11.this.f62u2 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka11.this.f62u2.setEnabled(false);
                    Otazka11.this.f62u2.setVisibility(4);
                    Otazka11.this.f61u1 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka11.this.f61u1.setEnabled(false);
                    Otazka11.this.f61u1.setVisibility(4);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up2.setVisibility(4);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up1.setVisibility(4);
                    Otazka11.this.pomocnapromennap11 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unt.setEnabled(false);
                    Otazka11.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka11.this);
                    builder.setMessage((CharSequence) "Harry: Hi, I don’t know.");
                    builder.create().show();
                    Otazka11.this.pomocnapromennat11 = 1;
                }
            });
        } else if (this.losovane == 12) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these is not an Italian harbor?");
            this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f61u1.setText("TARANTO");
            this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f62u2.setText("LIVORNO");
            this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f63u3.setText("GIOIA TAURO");
            this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f64u4.setText("ALICANTE");
            this.castka = 500000;
            this.f64u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.Spravna(4);
                }
            });
            this.f61u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f62u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f63u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unl.setEnabled(false);
                    Otazka11.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up1.setText("26%");
                    Otazka11.this.up2.setText("21%");
                    Otazka11.this.up3.setText("26%");
                    Otazka11.this.up4.setText("27%");
                    Otazka11.this.pomocnapromenna11 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unp.setEnabled(false);
                    Otazka11.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka11.this.f62u2 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka11.this.f62u2.setEnabled(false);
                    Otazka11.this.f62u2.setVisibility(4);
                    Otazka11.this.f61u1 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka11.this.f61u1.setEnabled(false);
                    Otazka11.this.f61u1.setVisibility(4);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up2.setVisibility(4);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up1.setVisibility(4);
                    Otazka11.this.pomocnapromennap11 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unt.setEnabled(false);
                    Otazka11.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka11.this);
                    builder.setMessage((CharSequence) "Henry: Hi, I just know that Livorno is Italian.");
                    builder.create().show();
                    Otazka11.this.pomocnapromennat11 = 1;
                }
            });
        } else if (this.losovane == 21) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Ve kterém z uvedených filmů ztvárnil Dustin Hoffman autistu Raymonda?");
            this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f61u1.setText("TOOTSIE");
            this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f62u2.setText("ČAS PROBUZENÍ");
            this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f63u3.setText("KRAMEROVÁ VS. KRAMER");
            this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f64u4.setText("RAIN MAN");
            this.castka = 500000;
            this.f64u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.Spravna(4);
                }
            });
            this.f61u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f62u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f63u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unl.setEnabled(false);
                    Otazka11.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up1.setText("26%");
                    Otazka11.this.up2.setText("26%");
                    Otazka11.this.up3.setText("21%");
                    Otazka11.this.up4.setText("27%");
                    Otazka11.this.pomocnapromenna11 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unp.setEnabled(false);
                    Otazka11.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka11.this.f62u2 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka11.this.f62u2.setEnabled(false);
                    Otazka11.this.f62u2.setVisibility(4);
                    Otazka11.this.f61u1 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka11.this.f61u1.setEnabled(false);
                    Otazka11.this.f61u1.setVisibility(4);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up2.setVisibility(4);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up1.setVisibility(4);
                    Otazka11.this.pomocnapromennap11 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unt.setEnabled(false);
                    Otazka11.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka11.this);
                    builder.setMessage((CharSequence) "Pavlína: Ahoj, to vím, v Rain Manovi.");
                    builder.create().show();
                    Otazka11.this.pomocnapromennat11 = 1;
                }
            });
        } else if (this.losovane == 13) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which year was the operation of supersonic aircraft “Concorde” terminated?");
            this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f61u1.setText("1980");
            this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f62u2.setText("1999");
            this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f63u3.setText(NativeAppInstallAd.ASSET_ICON);
            this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f64u4.setText("2010");
            this.castka = 500000;
            this.f63u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.Spravna(3);
                }
            });
            this.f61u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f62u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.f64u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.gameOver2(Otazka11.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka11.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unl.setEnabled(false);
                    Otazka11.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up1.setText("15%");
                    Otazka11.this.up2.setText("37%");
                    Otazka11.this.up3.setText("39%");
                    Otazka11.this.up4.setText("9%");
                    Otazka11.this.pomocnapromenna11 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unp.setEnabled(false);
                    Otazka11.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka11.this.f64u4 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka11.this.f64u4.setEnabled(false);
                    Otazka11.this.f64u4.setVisibility(4);
                    Otazka11.this.f62u2 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka11.this.f62u2.setEnabled(false);
                    Otazka11.this.f62u2.setVisibility(4);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.up4.setVisibility(4);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up2.setVisibility(4);
                    Otazka11.this.pomocnapromennap11 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka11.this.unt.setEnabled(false);
                    Otazka11.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka11.this);
                    builder.setMessage((CharSequence) "Jeremy: Hi, I don’t know, but if I had to guess, I’d say 1999.");
                    builder.create().show();
                    Otazka11.this.pomocnapromennat11 = 1;
                }
            });
        }
        this.dvere = (Button) findViewById(C1760R.C1762id.dvere);
        this.dvere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Otazka11.this.castka = 500000;
                Otazka11.this.gameOver();
                if (Otazka11.this.castka > Otazka11.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                    Otazka11.this.highscore(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
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
        this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f61u1.setEnabled(false);
        this.f62u2.setEnabled(false);
        this.f63u3.setEnabled(false);
        this.f64u4.setEnabled(false);
        if (i != 0) {
            int parseColor = Color.parseColor("#ffaa00");
            this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
            this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
            this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
            this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
            if (i == 1) {
                this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f61u1.setTextColor(parseColor);
                this.f61u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up1.setTextColor(parseColor);
            } else if (i == 2) {
                this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f62u2.setTextColor(parseColor);
                this.f62u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up2.setTextColor(parseColor);
            } else if (i == 3) {
                this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f63u3.setTextColor(parseColor);
                this.f63u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up3.setTextColor(parseColor);
            } else if (i == 4) {
                this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f64u4.setTextColor(parseColor);
                this.f64u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up4.setTextColor(parseColor);
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    int parseColor = Color.parseColor("#fcff0202");
                    int parseColor2 = Color.parseColor("#1dc700");
                    Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                    Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                    Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                    Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                    Otazka11.this.f61u1 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka11.this.f62u2 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka11.this.f63u3 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka11.this.f64u4 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f178u4);
                    if (i == 1) {
                        Otazka11.this.f61u1.setTextColor(parseColor);
                        Otazka11.this.f61u1.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka11.this.up1.setTextColor(parseColor);
                    } else if (i == 2) {
                        Otazka11.this.f62u2.setTextColor(parseColor);
                        Otazka11.this.f62u2.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka11.this.up2.setTextColor(parseColor);
                    } else if (i == 3) {
                        Otazka11.this.f63u3.setTextColor(parseColor);
                        Otazka11.this.f63u3.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka11.this.up3.setTextColor(parseColor);
                    } else if (i == 4) {
                        Otazka11.this.f64u4.setTextColor(parseColor);
                        Otazka11.this.f64u4.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka11.this.up4.setTextColor(parseColor);
                    }
                    if (i2 == 1) {
                        Otazka11.this.f61u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka11.this.f61u1.setTextColor(parseColor2);
                        Otazka11.this.up1.setTextColor(parseColor2);
                    } else if (i2 == 2) {
                        Otazka11.this.f62u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka11.this.f62u2.setTextColor(parseColor2);
                        Otazka11.this.up2.setTextColor(parseColor2);
                    } else if (i2 == 3) {
                        Otazka11.this.f63u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka11.this.f63u3.setTextColor(parseColor2);
                        Otazka11.this.up3.setTextColor(parseColor2);
                    } else if (i2 == 4) {
                        Otazka11.this.f64u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka11.this.f64u4.setTextColor(parseColor2);
                        Otazka11.this.up4.setTextColor(parseColor2);
                    }
                    Intent intent = new Intent(Otazka11.this, BackgroundSoundService.class);
                    intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                    Otazka11.this.stopService(intent);
                    Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka11.this).getBoolean("ZVUK", true));
                    Otazka11.this.spatna = MediaPlayer.create(Otazka11.this, C1760R.raw.spatna2);
                    if (z && valueOf.booleanValue()) {
                        Otazka11.this.spatna.start();
                    }
                }
            }, 1500);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Otazka11.this.alertDialog();
                    if (Otazka11.this.mInterstitialAd.isLoaded()) {
                        Otazka11.this.mInterstitialAd.show();
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
        this.castka = 40000;
        Intent intent2 = new Intent(this, PopActivity.class);
        intent2.putExtra("Level", this.level);
        intent2.putExtra("Castka", this.castka);
        intent2.putExtra("pomocnapromenna", this.pomocnapromenna11);
        intent2.putExtra("pomocnapromennap", this.pomocnapromennap11);
        intent2.putExtra("pomocnapromennat", this.pomocnapromennat11);
        startActivity(intent2);
        this.mCountDownTimer.cancel();
    }

    /* access modifiers changed from: private */
    public void Spravna(final int i) {
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_11", 0);
        int i2 = sharedPreferences.getInt("x", -1) + 1;
        SharedPreferences.Editor edit = getSharedPreferences("zodpovezene_11", 0).edit();
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
        this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f61u1.setEnabled(false);
        this.f62u2.setEnabled(false);
        this.f63u3.setEnabled(false);
        this.f64u4.setEnabled(false);
        if (i == 1) {
            this.f61u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f61u1.setTextColor(parseColor);
            this.f61u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up1.setTextColor(parseColor);
        } else if (i == 2) {
            this.f62u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f62u2.setTextColor(parseColor);
            this.f62u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up2.setTextColor(parseColor);
        } else if (i == 3) {
            this.f63u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f63u3.setTextColor(parseColor);
            this.f63u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up3.setTextColor(parseColor);
        } else {
            this.f64u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f64u4.setTextColor(parseColor);
            this.f64u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up4.setTextColor(parseColor);
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka11.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                Otazka11.this.stopService(intent);
                int parseColor = Color.parseColor("#1dc700");
                Otazka11.this.up1 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up1);
                Otazka11.this.up2 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up2);
                Otazka11.this.up3 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up3);
                Otazka11.this.up4 = (TextView) Otazka11.this.findViewById(C1760R.C1762id.up4);
                if (i == 1) {
                    Otazka11.this.f61u1 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka11.this.f61u1.setTextColor(parseColor);
                    Otazka11.this.f61u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka11.this.up1.setTextColor(parseColor);
                } else if (i == 2) {
                    Otazka11.this.f62u2 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka11.this.f62u2.setTextColor(parseColor);
                    Otazka11.this.f62u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka11.this.up2.setTextColor(parseColor);
                } else if (i == 3) {
                    Otazka11.this.f63u3 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka11.this.f63u3.setTextColor(parseColor);
                    Otazka11.this.f63u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka11.this.up3.setTextColor(parseColor);
                } else {
                    Otazka11.this.f64u4 = (Button) Otazka11.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka11.this.f64u4.setTextColor(parseColor);
                    Otazka11.this.f64u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka11.this.up4.setTextColor(parseColor);
                }
                if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka11.this).getBoolean("ZVUK", true)).booleanValue()) {
                    MediaPlayer.create(Otazka11.this, C1760R.raw.applause2).start();
                }
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka11.this, Otazka12.class);
                intent.putExtra("some_key11", Otazka11.this.pomocnapromenna11);
                intent.putExtra("some_keyp11", Otazka11.this.pomocnapromennap11);
                intent.putExtra("some_keyt11", Otazka11.this.pomocnapromennat11);
                Otazka11.this.startActivity(intent);
                CustomIntent.customType(Otazka11.this, "left-to-right");
            }
        }, 2500);
    }

    /* access modifiers changed from: private */
    public void highscore(int i) {
        if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true)).booleanValue()) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    MediaPlayer.create(Otazka11.this, C1760R.raw.applause7).start();
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
            Intent intent = new Intent(this, Otazka12.class);
            this.mCountDownTimer.cancel();
            intent.putExtra("some_key11", this.pomocnapromenna11);
            intent.putExtra("some_keyp11", this.pomocnapromennap11);
            intent.putExtra("some_keyt11", this.pomocnapromennat11);
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
            intent.putExtra("pomocnapromenna", this.pomocnapromenna11);
            intent.putExtra("pomocnapromennap", this.pomocnapromennap11);
            intent.putExtra("pomocnapromennat", this.pomocnapromennat11);
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
