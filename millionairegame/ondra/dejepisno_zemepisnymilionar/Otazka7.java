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

public class Otazka7 extends AppCompatActivity implements RewardedVideoAdListener {
    private static boolean activityVisible;
    Button Zvuk;

    /* renamed from: a */
    final int f141a = 0;
    ArrayList<Integer> arl = new ArrayList<>();

    /* renamed from: b */
    final int f142b = 0;

    /* renamed from: c5 */
    Button f143c5;
    int castka;

    /* renamed from: d5 */
    Button f144d5;
    Button dvere;
    RadioGroup fuhrer1;
    boolean gameOver = false;

    /* renamed from: i */
    int f145i = 0;
    int[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67};
    TextView label;
    int level = 7;
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
    int pomocnapromenna7;
    int pomocnapromennap7;
    int pomocnapromennat7;

    /* renamed from: r */
    Random f146r;
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
    Button f147u1;

    /* renamed from: u2 */
    Button f148u2;

    /* renamed from: u3 */
    Button f149u3;

    /* renamed from: u4 */
    Button f150u4;
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
        this.f146r = new Random();
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_7", 0);
        int i = sharedPreferences.getInt("x", -1) + 1;
        System.out.println(i + "!!!!");
        SharedPreferences sharedPreferences2 = getSharedPreferences("zodpovezene_7", 0);
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
        this.f146r = new Random();
        this.castka = 0;
        if (this.arl.size() == 0) {
            sharedPreferences.edit().clear().commit();
            sharedPreferences2.edit().clear().commit();
            int i5 = getSharedPreferences("zodpovezene_7", 0).getInt("x", -1) + 1;
            System.out.println(i5 + "!!!!");
            SharedPreferences sharedPreferences3 = getSharedPreferences("zodpovezene_7", 0);
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
        setFinishOnTouchOutside(false);
        this.losovane = this.f146r.nextInt(this.arl.size());
        this.losovane = this.arl.get(this.losovane).intValue();
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
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(Otazka7.this);
                Boolean valueOf = Boolean.valueOf(defaultSharedPreferences.getBoolean("ZVUK", true));
                Intent intent = new Intent(Otazka7.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                if (valueOf.booleanValue()) {
                    SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                    edit.putBoolean("ZVUK", false);
                    edit.commit();
                    Otazka7.this.stopService(intent);
                    Otazka7.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukvypnuto);
                    return;
                }
                SharedPreferences.Editor edit2 = defaultSharedPreferences.edit();
                edit2.putBoolean("ZVUK", true);
                edit2.commit();
                Otazka7.this.startService(intent);
                Otazka7.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukzapnuto);
            }
        });
        this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f147u1.setTextColor(-1);
        this.f147u1.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f148u2.setTextColor(-1);
        this.f148u2.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f149u3.setTextColor(-1);
        this.f149u3.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f150u4.setTextColor(-1);
        this.f150u4.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
        this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
        this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
        this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
        this.up1.setTextColor(-1);
        this.up2.setTextColor(-1);
        this.up3.setTextColor(-1);
        this.up4.setTextColor(-1);
        this.textview7 = (TextView) findViewById(C1760R.C1762id.textView7);
        this.textview7.setTextColor(InputDeviceCompat.SOURCE_ANY);
        this.textview5 = (TextView) findViewById(C1760R.C1762id.textView5);
        this.textview5.setTextColor(-1);
        this.textview2 = (TextView) findViewById(C1760R.C1762id.textView2);
        this.textview2.setText("500$");
        this.textview3 = (TextView) findViewById(C1760R.C1762id.textView3);
        this.textview3.setText("1K");
        this.textview3.setBackgroundResource(C1760R.C1761drawable.textview2);
        this.textview3.setTypeface(Typeface.DEFAULT_BOLD);
        this.textview4 = (TextView) findViewById(C1760R.C1762id.textView4);
        this.textview4.setText("2K");
        this.textview4.setBackgroundResource(C1760R.C1761drawable.textview);
        this.textview4.setTypeface(Typeface.DEFAULT);
        this.textview5 = (TextView) findViewById(C1760R.C1762id.textView5);
        this.textview5.setText("5K");
        this.textview6 = (TextView) findViewById(C1760R.C1762id.textView6);
        this.textview6.setText("10K");
        this.textview6.setBackgroundResource(C1760R.C1761drawable.textview);
        this.textview6.setTypeface(Typeface.DEFAULT);
        this.textview7 = (TextView) findViewById(C1760R.C1762id.textView7);
        this.textview7.setText("20K");
        this.textview7.setBackgroundResource(C1760R.C1761drawable.textview2);
        this.textview7.setTypeface(Typeface.DEFAULT_BOLD);
        this.textview8 = (TextView) findViewById(C1760R.C1762id.textView8);
        this.textview8.setText("40K");
        this.textview8.setBackgroundResource(C1760R.C1761drawable.textview);
        this.textview8.setTypeface(Typeface.DEFAULT);
        this.otazkaza = (TextView) findViewById(C1760R.C1762id.otazkaza);
        this.otazkaza.setText("5 000$ Question");
        this.mProgressBar = (ProgressBar) findViewById(C1760R.C1762id.progressBar3);
        this.mProgressBar.setProgress(this.f145i);
        this.mCountDownTimer = new CountDownTimer(40000, 1000) {
            public void onTick(long j) {
                Log.v("Log_tag", "Tick of Progress" + Otazka7.this.f145i + j);
                Otazka7 otazka7 = Otazka7.this;
                otazka7.f145i = otazka7.f145i + 1;
                Otazka7.this.mProgressBar.setProgress((Otazka7.this.f145i * 100) / 40);
            }

            public void onFinish() {
                Otazka7.this.f145i++;
                Otazka7.this.mProgressBar.setProgress(100);
                Otazka7.this.uzivatelOdpovedel = false;
                Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 0, 0);
            }
        };
        this.mCountDownTimer.start();
        int i9 = getIntent().getExtras().getInt("some_key6");
        int i10 = getIntent().getExtras().getInt("some_keyp6");
        if (getIntent().getExtras().getInt("some_keyt6") == 1) {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(false);
            this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
            this.pomocnapromennat7 = 1;
        } else {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(true);
        }
        if (i10 == 1) {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(false);
            this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
            this.pomocnapromennap7 = 1;
        } else {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(true);
        }
        if (i9 == 1) {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(false);
            this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
            this.pomocnapromenna7 = 1;
        } else {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(true);
        }
        this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f147u1.setEnabled(true);
        this.f148u2.setEnabled(true);
        this.f149u3.setEnabled(true);
        this.f150u4.setEnabled(true);
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
            this.otazkau.setText("Which country didn't take part in partitions of Poland?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("RUSSIAN EMPIRE");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("KINGDOM OF GREAT BRITAIN");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("KINGDOM OF PRUSSIA");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("HABSBURG AUSTRIA");
            this.castka = 10000;
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(2);
                }
            });
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("17%");
                    Otazka7.this.up2.setText("40%");
                    Otazka7.this.up3.setText("18%");
                    Otazka7.this.up4.setText("25%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "James: Hi, choose C)!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 2) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("When was the World Trade Center attacked?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("9TH OF SEPTEMBER 2001");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("11TH OF SEPTEMBER 2001");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("9TH OF SEPTEMBER 2003");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("11TH OF SEPTEMBER 2003");
            this.castka = 10000;
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(2);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("6%");
                    Otazka7.this.up2.setText("56%");
                    Otazka7.this.up3.setText("9%");
                    Otazka7.this.up4.setText("29%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "James: Hi, definitely B) is correct!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 3) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where can we find the oldest metro system?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("BUDAPEST");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("LONDON");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("NEW YORK");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("MOSCOW");
            this.castka = 20000;
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(2);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("12%");
                    Otazka7.this.up2.setText("31%");
                    Otazka7.this.up3.setText("24%");
                    Otazka7.this.up4.setText("23%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "James: Hi, definitely in London!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 4) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which country produces the most Uranium?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("USA");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("KAZAKHSTAN");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("AUSTRALIA");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("CANADA");
            this.castka = 20000;
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(2);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("22%");
                    Otazka7.this.up2.setText("34%");
                    Otazka7.this.up3.setText("28%");
                    Otazka7.this.up4.setText("16%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "James: Hi, I am sorry, I don't know.");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 5) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who is Billie Joe Armstrong?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("SINGER");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("CYCLIST");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("TENNIS PLAYER");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("FAMOUS BIOLOGIST");
            this.castka = 20000;
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(1);
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("35%");
                    Otazka7.this.up2.setText("21%");
                    Otazka7.this.up3.setText("20%");
                    Otazka7.this.up4.setText("24%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "James: Hi, he's a lead singer of Green Day!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 6) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which country switched to Allied powers during the World War I?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("AUSTRIA-HUNGARY");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("TURKEY");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("SPAIN");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("ITALY");
            this.castka = 20000;
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(4);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 0);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 0);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 0);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("16%");
                    Otazka7.this.up2.setText("25%");
                    Otazka7.this.up3.setText("25%");
                    Otazka7.this.up4.setText("34%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "James: Hi, it was definitely Italy!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 7) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of Italian revolutionaire of 19th century?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("SALVATORE BERNINI");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("LUCA RICCI");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("GIUSEPPE GARIBALDI");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("ANDREA CONTI");
            this.castka = 20000;
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(3);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("19%");
                    Otazka7.this.up2.setText("9%");
                    Otazka7.this.up3.setText("62%");
                    Otazka7.this.up4.setText("10%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "James: Hi, I know that it was Giuseppe Garibaldi!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 8) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who was the first to publish periodic table of elemnts?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("JOHAN G. MENDEL");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("MIKHAIL V. LOMONSOV");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("NIKOLAI I. LOBACHEVSKI");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("DMITRI I. MENDELEEV");
            this.castka = 20000;
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(4);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("20%");
                    Otazka7.this.up2.setText("17%");
                    Otazka7.this.up3.setText("6%");
                    Otazka7.this.up4.setText("57%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "James: Hey, it was Mendelev!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 9) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where can we find the deepest lake in the world?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("RUSSIA");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("CANADA");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("USA");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("FINLAND");
            this.castka = 20000;
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(1);
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("38%");
                    Otazka7.this.up2.setText("24%");
                    Otazka7.this.up3.setText("9%");
                    Otazka7.this.up4.setText("29%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "James: Hi, the deepest lake is Baikal, which is in Russia!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 10) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Peace of Westphalia which ended 30-years war meant what?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("HABSBURGS VICTORY");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("PROTESTANT FORCES VICTORY");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("COMPROMISE");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("RELIGION TOLERATION");
            this.castka = 20000;
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(3);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("27%");
                    Otazka7.this.up2.setText("19%");
                    Otazka7.this.up3.setText("29%");
                    Otazka7.this.up4.setText("25%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Jessica: Hi, definitely compromise!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 11) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Peace of Utrecht (1713) ended which war?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("AUSTRIA SUCCESSION");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("SPAIN SUCCESSION");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("BAVARIA SUCCESSION");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("7 YEARS WAR");
            this.castka = 20000;
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(2);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("14%");
                    Otazka7.this.up2.setText("50%");
                    Otazka7.this.up3.setText("15%");
                    Otazka7.this.up4.setText("21%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "John: Hi, it ended War of Spain Succession!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 12) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who was an opponent of Mao Zedong?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("SUN YAT-SEN");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("CAO PI");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("CHIANG KAI-SHEK");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("HUANG XIANFAN");
            this.castka = 20000;
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(3);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("29%");
                    Otazka7.this.up2.setText("18%");
                    Otazka7.this.up3.setText("36%");
                    Otazka7.this.up4.setText("17%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "John: Hi, I think that C) should be correct.");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 13) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which country is not a member of Golden triangle?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("LAOS");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("THAILAND");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("CAMBODIA");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("MYANMAR");
            this.castka = 20000;
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(3);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("25%");
                    Otazka7.this.up2.setText("24%");
                    Otazka7.this.up3.setText("26%");
                    Otazka7.this.up4.setText("24%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Liam: Hi, I am sorry, but I don't know the correct answer.");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 14) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which river originates in Baikal and its mouth is in Laptev sea?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("OB");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("YENISEI");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("LENA");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("IRTYSH");
            this.castka = 20000;
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(3);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("26%");
                    Otazka7.this.up2.setText("22%");
                    Otazka7.this.up3.setText("31%");
                    Otazka7.this.up4.setText("21%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Liam: Hi, I guess it is Lena, but I am not sure.");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 15) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many moons planet Venus has?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("0");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("1");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("2");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("3");
            this.castka = 20000;
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(1);
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("35%");
                    Otazka7.this.up2.setText("30%");
                    Otazka7.this.up3.setText("26%");
                    Otazka7.this.up4.setText("9%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Liam: Hi, I think that Venus doesn't have any moon!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 16) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these elements has the most protons in its core?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("HELIUM");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("LEAD");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("NEON");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("OXYGEN");
            this.castka = 20000;
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(2);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("2%");
                    Otazka7.this.up2.setText("52%");
                    Otazka7.this.up3.setText("42%");
                    Otazka7.this.up4.setText("4%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Liam: Hi, it is Lead or Neon.");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 17) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many inhabitants are there in Greenland?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("150 000");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("50 000");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("10 000");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("1 000");
            this.castka = 20000;
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(2);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("24%");
                    Otazka7.this.up2.setText("32%");
                    Otazka7.this.up3.setText("21%");
                    Otazka7.this.up4.setText("23%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Liam: Hi, I think there are 50 000 inhabitants.");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 18) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What forms an imperative mood?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("COMMAND");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("QUESTION");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("ZERO CONDITION");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("NARRATION");
            this.castka = 20000;
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(1);
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("55%");
                    Otazka7.this.up2.setText("10%");
                    Otazka7.this.up3.setText("7%");
                    Otazka7.this.up4.setText("28%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Liam: Hi, definitely a command!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 19) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is Teotihuacan?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("SPICY DISH");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("PYRAMID COMPLEX");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("ANTICYCLONE");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("MEXICAN GANG");
            this.castka = 20000;
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(2);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("22%");
                    Otazka7.this.up2.setText("32%");
                    Otazka7.this.up3.setText("19%");
                    Otazka7.this.up4.setText("27%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Liam: Hi, it is definitely a complex of pyramids!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 20) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is disinflation?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("ANTONYM OF INFLATION");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("ECONOMIC DEPRESSION");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("SLOWDOWN OF INFLATION");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("TERM DOESN'T EXIST");
            this.castka = 20000;
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(3);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("26%");
                    Otazka7.this.up2.setText("10%");
                    Otazka7.this.up3.setText("37%");
                    Otazka7.this.up4.setText("27%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Liam: Hi, it is slowdown of inflation!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 21) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What colours are on Ukraine flag?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("BLUE AND RED");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("BLUE AND YELLOW");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("YELLOW AND BLUE");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("GREEN AND BLUE");
            this.castka = 20000;
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(2);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("12%");
                    Otazka7.this.up2.setText("45%");
                    Otazka7.this.up3.setText("20%");
                    Otazka7.this.up4.setText("23%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Oliver: Hi, it is blue and yellow!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 22) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Egypt doesn't border with?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("LIBYA");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("SUDAN");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("ISRAEL");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("LEBANON");
            this.castka = 20000;
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(4);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("17%");
                    Otazka7.this.up2.setText("28%");
                    Otazka7.this.up3.setText("16%");
                    Otazka7.this.up4.setText("39%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Oliver: Hi, choose Lebanon!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 23) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many hydrogens are there in butane?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("6");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("8");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("10");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("12");
            this.castka = 20000;
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(3);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("11%");
                    Otazka7.this.up2.setText("28%");
                    Otazka7.this.up3.setText("32%");
                    Otazka7.this.up4.setText("29%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Oliver: Hi, certainly 10 hydrogens!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 24) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Schrödinger's cat is a problem of?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("PSYCHOLOGY");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("HEREDITY");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("QUANTUM MECHANICS");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("CYNOLOGY");
            this.castka = 20000;
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(3);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("34%");
                    Otazka7.this.up2.setText("14%");
                    Otazka7.this.up3.setText("34%");
                    Otazka7.this.up4.setText("18%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Oliver: Hey, you're lucky, I know it is from quantum mechanic!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 25) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which today's state is on the area of Mesopotamia?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("IRAN");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("IRAQ");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("SYRIA");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("PAKISTAN");
            this.castka = 20000;
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(2);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("31%");
                    Otazka7.this.up2.setText("32%");
                    Otazka7.this.up3.setText("31%");
                    Otazka7.this.up4.setText("6%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Oliver: Hi, it is Iraq!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 26) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where does Adidas come from?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("USA");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("ENGLAND");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("NETHERLANDS");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("GERMANY");
            this.castka = 20000;
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(4);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("27%");
                    Otazka7.this.up2.setText("25%");
                    Otazka7.this.up3.setText("21%");
                    Otazka7.this.up4.setText("27%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Oliver: Hi, definitely from Germany!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 27) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of the following Belgium cities is populated the most?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("LIEGE");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("GENT");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("ANTWERP");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("BURGES");
            this.castka = 20000;
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(3);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("15%");
                    Otazka7.this.up2.setText("25%");
                    Otazka7.this.up3.setText("31%");
                    Otazka7.this.up4.setText("29%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Margaret: Hi, It is probably Antwerp, but I am not sure.");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 28) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Roman emperor Gaius Octavius Thurinus is rather known as?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("CLAUDIUS");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("AUGUSTUS");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("JULIUS");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("ANTONIUS");
            this.castka = 20000;
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(2);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("22%");
                    Otazka7.this.up2.setText("32%");
                    Otazka7.this.up3.setText("17%");
                    Otazka7.this.up4.setText("29%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Margaret: Hi, I think it is Augustus!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 29) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Moctezuma was ruler of which empire?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("INCA");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("MAYA");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("TOLTEC");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("AZTEC");
            this.castka = 20000;
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(4);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("34%");
                    Otazka7.this.up2.setText("15%");
                    Otazka7.this.up3.setText("14%");
                    Otazka7.this.up4.setText("37%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Margaret: Hi, definitely Aztec empire!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 30) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who is the oldest player to make appearance in NHL?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("WAYNE GRETZKY");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("JAROMIR JAGR");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("MARTIN ST. LOUIS");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("GORDIE HOWE");
            this.castka = 20000;
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(4);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("29%");
                    Otazka7.this.up2.setText("15%");
                    Otazka7.this.up3.setText("24%");
                    Otazka7.this.up4.setText("32%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Margaret: Hi, definitely Gordie Howe!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 31) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which country is a volcano called Hekla?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("USA");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("ITALY");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("INDONESIA");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("ICELAND");
            this.castka = 20000;
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(4);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("24%");
                    Otazka7.this.up2.setText("4%");
                    Otazka7.this.up3.setText("29%");
                    Otazka7.this.up4.setText("43%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Margaret: Hi, I really don't know.");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 32) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Hero of novel by which author is Julian Sorel?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("VICTOR HUGO");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("EMILE ZOLA");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("GUSTAVE FLAUBERT");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("STENDHAL");
            this.castka = 20000;
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(4);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("19%");
                    Otazka7.this.up2.setText("26%");
                    Otazka7.this.up3.setText("26%");
                    Otazka7.this.up4.setText("29%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Margaret: Hi, it is from Stendhal's novel The Red and the Black.");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 33) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("On which of Canarian islands can we find two big airports?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("GRAN CANARIA");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("TENERIFE");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("FUERTEVENTURA");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("LA PALMA");
            this.castka = 20000;
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(2);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("29%");
                    Otazka7.this.up2.setText("36%");
                    Otazka7.this.up3.setText("19%");
                    Otazka7.this.up4.setText("16%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Margaret: Hi, probably Tenerife.");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 34) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of this cities is easternmost?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("VIENNA");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("BUDAPEST");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("PRAGUE");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("WARSAW");
            this.castka = 20000;
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(2);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("21%");
                    Otazka7.this.up2.setText("33%");
                    Otazka7.this.up3.setText("28%");
                    Otazka7.this.up4.setText("18%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Margaret: Hi, definitely Warsaw!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 35) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which southamerican state has the greatest oil supplies?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("VENEZUELA");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("COLOMBIA");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("EQUADOR");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("BOLIVIA");
            this.castka = 20000;
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(1);
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("36%");
                    Otazka7.this.up2.setText("33%");
                    Otazka7.this.up3.setText("23%");
                    Otazka7.this.up4.setText("8%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Margaret: Hi, it is Venezuela!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 36) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Canarian islands are part of?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("FRANCE");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("MOROCCO");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("SPAIN");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("PORTUGAL");
            this.castka = 20000;
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(3);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("2%");
                    Otazka7.this.up2.setText("15%");
                    Otazka7.this.up3.setText("52%");
                    Otazka7.this.up4.setText("31%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Margaret: Hi, surely part of Spain!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 37) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Sulfur is?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("HALOGEN");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("ALKALI METAL");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("METALLOID");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("CHALCOGEN");
            this.castka = 20000;
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(4);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("14%");
                    Otazka7.this.up2.setText("18%");
                    Otazka7.this.up3.setText("25%");
                    Otazka7.this.up4.setText("43%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Margaret: Hi, it is a chalcogen!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 38) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of the following countries is on Arabian peninsula?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("YEMEN");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("BENIN");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("BURUNDI");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("RWANDA");
            this.castka = 20000;
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(1);
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("36%");
                    Otazka7.this.up2.setText("22%");
                    Otazka7.this.up3.setText("18%");
                    Otazka7.this.up4.setText("24%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Patricia: Hi, it is Yemen!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 39) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of the following US states is southernmost?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("TENNESSEE");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("LOUISIANA");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("VIRGINIA");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("SOUTH DAKOTA");
            this.castka = 20000;
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(2);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("25%");
                    Otazka7.this.up2.setText("34%");
                    Otazka7.this.up3.setText("24%");
                    Otazka7.this.up4.setText("17%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Patricia: Hi, it should be Lousiana.");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 40) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which elemnt has the greatest electronegativity?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("OXYGEN");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("BROMINE");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("FLUORINE");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("IODINE");
            this.castka = 20000;
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(3);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("9%");
                    Otazka7.this.up2.setText("29%");
                    Otazka7.this.up3.setText("36%");
                    Otazka7.this.up4.setText("26%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Patricia: Hi, definitely Fluorine!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 41) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which of the following films hasn't played Tom Hanks?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("THE GREEN MILE");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("FORREST GUMP");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("BRAVEHEART");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("CAST AWAY");
            this.castka = 20000;
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(3);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("16%");
                    Otazka7.this.up2.setText("10%");
                    Otazka7.this.up3.setText("39%");
                    Otazka7.this.up4.setText("35%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Patricia: Hi, I think he hasn't played in braveheart!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 42) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who were Varangians?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("VIKINGS");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("GERMANIC PEOPLE");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("CELTS");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("HUNS");
            this.castka = 20000;
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(1);
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("34%");
                    Otazka7.this.up2.setText("32%");
                    Otazka7.this.up3.setText("16%");
                    Otazka7.this.up4.setText("18%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Patricia: Hi, certainly Vikings!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 43) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many teeth are there in deciduous (temporary) teeth?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("20");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("22");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("24");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("26");
            this.castka = 20000;
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(1);
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("41%");
                    Otazka7.this.up2.setText("38%");
                    Otazka7.this.up3.setText("20%");
                    Otazka7.this.up4.setText("1%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Patricia: Hi, I think it should be 20.");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 44) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("On which surface is played tennis tournament Roland Garros?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("CONCRETE");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("CLAY");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("GRASS");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("ASPHALT");
            this.castka = 20000;
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(2);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("29%");
                    Otazka7.this.up2.setText("34%");
                    Otazka7.this.up3.setText("26%");
                    Otazka7.this.up4.setText("11%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Patricia: Hi, surely on a clay!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 45) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is Carcassonne/carcassonne?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("CAR FACTORY");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("BOARD GAME");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("SPORT");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("CLOTHING BRAND");
            this.castka = 20000;
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(2);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("11%");
                    Otazka7.this.up2.setText("32%");
                    Otazka7.this.up3.setText("31%");
                    Otazka7.this.up4.setText("26%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Patricia: Hi, it is a board game!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 46) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Operation Desert Storm was against which country?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("EGYPT");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("SYRIA");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("SAUDI ARABIA");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("IRAQ");
            this.castka = 20000;
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(4);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("21%");
                    Otazka7.this.up2.setText("28%");
                    Otazka7.this.up3.setText("18%");
                    Otazka7.this.up4.setText("33%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Patricia: Hi, certainly against Iraq!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 47) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("New Amsterdam is a original name for?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("NEW YORK");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("NEW ORLEANS");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("NEW BRUNSWICK");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("NEWCASTLE");
            this.castka = 20000;
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(1);
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("45%");
                    Otazka7.this.up2.setText("28%");
                    Otazka7.this.up3.setText("15%");
                    Otazka7.this.up4.setText("12%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Patricia: Hi, definitely for New York!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 48) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who named Benito Mussolini as prime minister?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("VICTOR EMMANUEL I");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("VICTOR EMMANUEL II");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("VICTOR EMMANUEL III");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("UMBERTO I");
            this.castka = 20000;
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(3);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("20%");
                    Otazka7.this.up2.setText("31%");
                    Otazka7.this.up3.setText("31%");
                    Otazka7.this.up4.setText("18%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Patricia: Hi, it was Victor Emmanuel III.");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 49) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Brian Johnson is a lead singer of which band?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("GUNS N' ROSES");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("METALLICA");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("AC/DC");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("MEGADEATH");
            this.castka = 20000;
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(3);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("22%");
                    Otazka7.this.up2.setText("16%");
                    Otazka7.this.up3.setText("32%");
                    Otazka7.this.up4.setText("30%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Patricia: Hi, definitely AC/DC!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 50) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which river flows out of Victoria's lake?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("CONGO");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("ZAMBEZI");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("NIGER");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("NILE");
            this.castka = 20000;
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(4);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("26%");
                    Otazka7.this.up2.setText("28%");
                    Otazka7.this.up3.setText("18%");
                    Otazka7.this.up4.setText("28%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Patricia: Hi, it is definitely Nile!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 51) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("For purely imaginary number (a + bi) is?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("A = 0");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("B = 0");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("I = 0");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("B = 1");
            this.castka = 20000;
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(1);
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("34%");
                    Otazka7.this.up2.setText("22%");
                    Otazka7.this.up3.setText("26%");
                    Otazka7.this.up4.setText("18%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Patricia: Hi, A = 0.");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 52) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where can we find duodenum?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("LIVER");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("SMALL INTESTINE");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("STOMACH");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("LARGE INTESTINE");
            this.castka = 20000;
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(2);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("27%");
                    Otazka7.this.up2.setText("30%");
                    Otazka7.this.up3.setText("26%");
                    Otazka7.this.up4.setText("17%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Mary: Hi, it is the first part of small intestine!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 53) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these national parks is not in Africa?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("SERENGETI");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("ETOSHA");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("KGALAGADI");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("KAZIRANGA");
            this.castka = 20000;
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(4);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("17%");
                    Otazka7.this.up2.setText("26%");
                    Otazka7.this.up3.setText("28%");
                    Otazka7.this.up4.setText("29%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Mary: Hi, I only know that Serengeti is in Africa.");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 54) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who wrote surrealist manifesto?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("ANDRE BRETON");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("PAUL ELUARD");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("BENJAMIN PERET");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("LOUIS ARAGON");
            this.castka = 20000;
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(1);
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("31%");
                    Otazka7.this.up2.setText("29%");
                    Otazka7.this.up3.setText("22%");
                    Otazka7.this.up4.setText("18%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Mary: Hi, definitely Andre Breton!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 55) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of Thor's hammer?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("MJOLJIR");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("NALJIR");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("MJOLNIR");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("BJOLNIR");
            this.castka = 20000;
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(3);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("20%");
                    Otazka7.this.up2.setText("16%");
                    Otazka7.this.up3.setText("42%");
                    Otazka7.this.up4.setText("22%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Mary: Hi, certainly Mjolnir!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 56) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who wrote The Spirit of Capitalism?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("IMMANUEL KANT");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("JOHN LOCKE");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("FRANZ WENGER");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("MAX WEBER");
            this.castka = 20000;
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(4);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("26%");
                    Otazka7.this.up2.setText("18%");
                    Otazka7.this.up3.setText("24%");
                    Otazka7.this.up4.setText("32%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Mary: Hi, it was Max Weber!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 57) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where can we find hepatocytes?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("SMALL INTESTINE");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("LIVER");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("LARGE INTESTINE");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("URINARY BLADDER");
            this.castka = 20000;
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(2);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("29%");
                    Otazka7.this.up2.setText("32%");
                    Otazka7.this.up3.setText("14%");
                    Otazka7.this.up4.setText("25%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Claire: Hi, it is in liver!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 58) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Subduction is a phenomenon associated with?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("LITOSPHERE");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("PEDOSPHERE");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("BIOSPHERE");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("HYDROSPHERE");
            this.castka = 20000;
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(1);
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("39%");
                    Otazka7.this.up2.setText("19%");
                    Otazka7.this.up3.setText("16%");
                    Otazka7.this.up4.setText("26%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Thomas: Hi, definitely a litosphere!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 59) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who of these goalkeepers has never won UEFA Champions league?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("GIANLUIGGI BUFFON");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("MANUEL NEUER");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("PETR CECH");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("IKER CASILLAS");
            this.castka = 20000;
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(1);
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("27%");
                    Otazka7.this.up2.setText("24%");
                    Otazka7.this.up3.setText("22%");
                    Otazka7.this.up4.setText("27%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Michael: Hi, I know this one! It is Buffon!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 60) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What does the symbol “Hamsa” stand for?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("FREEDOM");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("DEATH");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("PROTECTION");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("CREATIVITY");
            this.castka = 20000;
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(3);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("28%");
                    Otazka7.this.up2.setText("28%");
                    Otazka7.this.up3.setText("29%");
                    Otazka7.this.up4.setText("15%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Maria: Hi, I don’t know either.");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 61) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What does the letter M stand  for in the abbreviation “GMT”?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("MEAN");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("MOON");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("MAN");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("MALE");
            this.castka = 20000;
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(1);
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("29%");
                    Otazka7.this.up2.setText("28%");
                    Otazka7.this.up3.setText("20%");
                    Otazka7.this.up4.setText("23%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Michael: Hi, the correct answer is A).");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 62) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the average diameter of the Earth?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("9 800 KM");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("11 500 KM");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("12 700 KM");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("13 900 KM");
            this.castka = 20000;
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(3);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("17%");
                    Otazka7.this.up2.setText("29%");
                    Otazka7.this.up3.setText("34%");
                    Otazka7.this.up4.setText("20%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Damian: Hello, it is either B) or C).");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 63) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who composed the music for the movie “Intouchables”?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("LUDOVICO EINAUDI");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("HANS ZIMMER");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("JAMES NEWTON HOWARD");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("ENNIO MORRICONE");
            this.castka = 20000;
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(1);
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("30%");
                    Otazka7.this.up2.setText("19%");
                    Otazka7.this.up3.setText("29%");
                    Otazka7.this.up4.setText("22%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setEnabled(false);
                    Otazka7.this.f150u4.setVisibility(4);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up4.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Christie: Hello, it was Ludovico Einaudi.");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 64) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who discovered radioactivity in 1896?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("ALBERT EINSTEIN");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("J. J. THOMSON");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("W. W. HANSEN");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("HENRY BECQUEREL");
            this.castka = 20000;
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(4);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("26%");
                    Otazka7.this.up2.setText("26%");
                    Otazka7.this.up3.setText("20%");
                    Otazka7.this.up4.setText("28%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Simone: Hey, it was Henry Becquerel.");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 65) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these became the president first?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("ABRAHAM LINCOLN");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("WILLIAM MCKINLEY");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("HERBERT HOOVER");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("THOMAS JEFFERSON");
            this.castka = 20000;
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(4);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("30%");
                    Otazka7.this.up2.setText("19%");
                    Otazka7.this.up3.setText("19%");
                    Otazka7.this.up4.setText("32%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Leo: Hey, it was Thomas Jefferson!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 66) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where is the country Suriname situated?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("EAST OF ASIA");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("SOUTH OF AFRICA");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("WEST OF EUROPE");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("NORTH OF SOUTH AMERICA");
            this.castka = 20000;
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(4);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("30%");
                    Otazka7.this.up2.setText("31%");
                    Otazka7.this.up3.setText("1%");
                    Otazka7.this.up4.setText("38%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setEnabled(false);
                    Otazka7.this.f149u3.setVisibility(4);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up3.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Leo: Hey, Suriname is situated in the North of South America!");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        } else if (this.losovane == 67) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In the TV series “Futurama”, which character has only one eye?");
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setText("ZOIDBERG");
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setText("FRY");
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setText("LEELA");
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setText("HERMES");
            this.castka = 20000;
            this.f149u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.Spravna(3);
                }
            });
            this.f147u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f148u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.f150u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.gameOver2(Otazka7.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka7.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unl.setEnabled(false);
                    Otazka7.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.up1.setText("16%");
                    Otazka7.this.up2.setText("14%");
                    Otazka7.this.up3.setText("52%");
                    Otazka7.this.up4.setText("18%");
                    Otazka7.this.pomocnapromenna7 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unp.setEnabled(false);
                    Otazka7.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setEnabled(false);
                    Otazka7.this.f147u1.setVisibility(4);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setEnabled(false);
                    Otazka7.this.f148u2.setVisibility(4);
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up1.setVisibility(4);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up2.setVisibility(4);
                    Otazka7.this.pomocnapromennap7 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka7.this.unt.setEnabled(false);
                    Otazka7.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka7.this);
                    builder.setMessage((CharSequence) "Boris: I know this for sure, it’s C).");
                    builder.create().show();
                    Otazka7.this.pomocnapromennat7 = 1;
                }
            });
        }
        this.dvere = (Button) findViewById(C1760R.C1762id.dvere);
        this.dvere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Otazka7.this.castka = 20000;
                Otazka7.this.gameOver();
                if (Otazka7.this.castka > Otazka7.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                    Otazka7.this.highscore(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
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
        this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f147u1.setEnabled(false);
        this.f148u2.setEnabled(false);
        this.f149u3.setEnabled(false);
        this.f150u4.setEnabled(false);
        if (i != 0) {
            int parseColor = Color.parseColor("#ffaa00");
            this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
            this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
            this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
            this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
            if (i == 1) {
                this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f147u1.setTextColor(parseColor);
                this.f147u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up1.setTextColor(parseColor);
            } else if (i == 2) {
                this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f148u2.setTextColor(parseColor);
                this.f148u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up2.setTextColor(parseColor);
            } else if (i == 3) {
                this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f149u3.setTextColor(parseColor);
                this.f149u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up3.setTextColor(parseColor);
            } else if (i == 4) {
                this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f150u4.setTextColor(parseColor);
                this.f150u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up4.setTextColor(parseColor);
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    int parseColor = Color.parseColor("#fcff0202");
                    int parseColor2 = Color.parseColor("#1dc700");
                    Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                    Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                    Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                    Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    if (i == 1) {
                        Otazka7.this.f147u1.setTextColor(parseColor);
                        Otazka7.this.f147u1.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka7.this.up1.setTextColor(parseColor);
                    } else if (i == 2) {
                        Otazka7.this.f148u2.setTextColor(parseColor);
                        Otazka7.this.f148u2.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka7.this.up2.setTextColor(parseColor);
                    } else if (i == 3) {
                        Otazka7.this.f149u3.setTextColor(parseColor);
                        Otazka7.this.f149u3.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka7.this.up3.setTextColor(parseColor);
                    } else if (i == 4) {
                        Otazka7.this.f150u4.setTextColor(parseColor);
                        Otazka7.this.f150u4.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka7.this.up4.setTextColor(parseColor);
                    }
                    if (i2 == 1) {
                        Otazka7.this.f147u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka7.this.f147u1.setTextColor(parseColor2);
                        Otazka7.this.up1.setTextColor(parseColor2);
                    } else if (i2 == 2) {
                        Otazka7.this.f148u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka7.this.f148u2.setTextColor(parseColor2);
                        Otazka7.this.up2.setTextColor(parseColor2);
                    } else if (i2 == 3) {
                        Otazka7.this.f149u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka7.this.f149u3.setTextColor(parseColor2);
                        Otazka7.this.up3.setTextColor(parseColor2);
                    } else if (i2 == 4) {
                        Otazka7.this.f150u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka7.this.f150u4.setTextColor(parseColor2);
                        Otazka7.this.up4.setTextColor(parseColor2);
                    }
                    Intent intent = new Intent(Otazka7.this, BackgroundSoundService.class);
                    intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                    Otazka7.this.stopService(intent);
                    Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka7.this).getBoolean("ZVUK", true));
                    Otazka7.this.spatna = MediaPlayer.create(Otazka7.this, C1760R.raw.spatna2);
                    if (z && valueOf.booleanValue()) {
                        Otazka7.this.spatna.start();
                    }
                }
            }, 1500);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Otazka7.this.alertDialog();
                    if (Otazka7.this.mInterstitialAd.isLoaded()) {
                        Otazka7.this.mInterstitialAd.show();
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
        this.castka = 2500;
        Intent intent2 = new Intent(this, PopActivity.class);
        intent2.putExtra("Level", this.level);
        intent2.putExtra("Castka", this.castka);
        intent2.putExtra("pomocnapromenna", this.pomocnapromenna7);
        intent2.putExtra("pomocnapromennap", this.pomocnapromennap7);
        intent2.putExtra("pomocnapromennat", this.pomocnapromennat7);
        startActivity(intent2);
        this.mCountDownTimer.cancel();
    }

    /* access modifiers changed from: private */
    public void Spravna(final int i) {
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_7", 0);
        int i2 = sharedPreferences.getInt("x", -1) + 1;
        SharedPreferences.Editor edit = getSharedPreferences("zodpovezene_7", 0).edit();
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
        this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f147u1.setEnabled(false);
        this.f148u2.setEnabled(false);
        this.f149u3.setEnabled(false);
        this.f150u4.setEnabled(false);
        if (i == 1) {
            this.f147u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f147u1.setTextColor(parseColor);
            this.f147u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up1.setTextColor(parseColor);
        } else if (i == 2) {
            this.f148u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f148u2.setTextColor(parseColor);
            this.f148u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up2.setTextColor(parseColor);
        } else if (i == 3) {
            this.f149u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f149u3.setTextColor(parseColor);
            this.f149u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up3.setTextColor(parseColor);
        } else {
            this.f150u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f150u4.setTextColor(parseColor);
            this.f150u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up4.setTextColor(parseColor);
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka7.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                Otazka7.this.stopService(intent);
                int parseColor = Color.parseColor("#1dc700");
                Otazka7.this.up1 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up1);
                Otazka7.this.up2 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up2);
                Otazka7.this.up3 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up3);
                Otazka7.this.up4 = (TextView) Otazka7.this.findViewById(C1760R.C1762id.up4);
                if (i == 1) {
                    Otazka7.this.f147u1 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka7.this.f147u1.setTextColor(parseColor);
                    Otazka7.this.f147u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka7.this.up1.setTextColor(parseColor);
                } else if (i == 2) {
                    Otazka7.this.f148u2 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka7.this.f148u2.setTextColor(parseColor);
                    Otazka7.this.f148u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka7.this.up2.setTextColor(parseColor);
                } else if (i == 3) {
                    Otazka7.this.f149u3 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka7.this.f149u3.setTextColor(parseColor);
                    Otazka7.this.f149u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka7.this.up3.setTextColor(parseColor);
                } else {
                    Otazka7.this.f150u4 = (Button) Otazka7.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka7.this.f150u4.setTextColor(parseColor);
                    Otazka7.this.f150u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka7.this.up4.setTextColor(parseColor);
                }
                if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka7.this).getBoolean("ZVUK", true)).booleanValue()) {
                    MediaPlayer.create(Otazka7.this, C1760R.raw.applause2).start();
                }
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka7.this, Otazka8.class);
                Otazka7.this.mCountDownTimer.cancel();
                intent.putExtra("some_key7", Otazka7.this.pomocnapromenna7);
                intent.putExtra("some_keyp7", Otazka7.this.pomocnapromennap7);
                intent.putExtra("some_keyt7", Otazka7.this.pomocnapromennat7);
                Otazka7.this.startActivity(intent);
                CustomIntent.customType(Otazka7.this, "left-to-right");
            }
        }, 2500);
    }

    /* access modifiers changed from: private */
    public void highscore(int i) {
        if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true)).booleanValue()) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    MediaPlayer.create(Otazka7.this, C1760R.raw.applause7).start();
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
            Intent intent = new Intent(this, Otazka8.class);
            this.mCountDownTimer.cancel();
            intent.putExtra("some_key7", this.pomocnapromenna7);
            intent.putExtra("some_keyp7", this.pomocnapromennap7);
            intent.putExtra("some_keyt7", this.pomocnapromennat7);
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
            intent.putExtra("pomocnapromenna", this.pomocnapromenna7);
            intent.putExtra("pomocnapromennap", this.pomocnapromennap7);
            intent.putExtra("pomocnapromennat", this.pomocnapromennat7);
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
