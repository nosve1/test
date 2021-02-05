package com.millionairegame.ondra.dejepisno_zemepisnymilionar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import java.util.ArrayList;
import java.util.Random;
import maes.tech.intentanim.CustomIntent;

public class Otazka3 extends AppCompatActivity implements RewardedVideoAdListener {
    private static boolean activityVisible;
    Button Zvuk;

    /* renamed from: a */
    final int f97a = 0;

    /* renamed from: a1 */
    Button f98a1;
    ArrayList<Integer> arl = new ArrayList<>();

    /* renamed from: b */
    final int f99b = 0;

    /* renamed from: b1 */
    Button f100b1;

    /* renamed from: c1 */
    Button f101c1;
    int castka;

    /* renamed from: d1 */
    Button f102d1;
    Button dvere;
    RadioGroup fuhrer1;
    boolean gameOver = false;

    /* renamed from: i */
    int f103i = 0;
    int[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124};
    TextView label;
    int level = 3;
    int losovane;
    CountDownTimer mCountDownTimer;
    /* access modifiers changed from: private */
    public InterstitialAd mInterstitialAd;
    ProgressBar mProgressBar;
    private RewardedVideoAd mRewardedVideoAd;
    Button novahra;
    TextView otazka1;
    TextView otazka2;
    TextView otazkau;
    TextView otazkau500k;
    TextView otazkaza;
    int pomocnapromenna3;
    int pomocnapromennap3;
    int pomocnapromennat3;

    /* renamed from: r */
    Random f104r;
    RadioGroup radioGroupreky;
    TextView reky1chyba;
    MediaPlayer spatna;
    TextView textview3;
    TextView textview4;

    /* renamed from: u1 */
    Button f105u1;

    /* renamed from: u2 */
    Button f106u2;

    /* renamed from: u3 */
    Button f107u3;

    /* renamed from: u4 */
    Button f108u4;
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
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_3", 0);
        int i = sharedPreferences.getInt("x", -1) + 1;
        System.out.println(i + "!!!!");
        SharedPreferences sharedPreferences2 = getSharedPreferences("zodpovezene_3", 0);
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
        this.f104r = new Random();
        this.castka = 0;
        if (this.arl.size() == 0) {
            sharedPreferences.edit().clear().commit();
            sharedPreferences2.edit().clear().commit();
            int i5 = getSharedPreferences("zodpovezene_3", 0).getInt("x", -1) + 1;
            System.out.println(i5 + "!!!!");
            SharedPreferences sharedPreferences3 = getSharedPreferences("zodpovezene_3", 0);
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
        this.losovane = this.f104r.nextInt(this.arl.size());
        this.losovane = this.arl.get(this.losovane).intValue();
        setFinishOnTouchOutside(false);
        Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true));
        this.Zvuk = (Button) findViewById(C1760R.C1762id.zvuk);
        if (valueOf.booleanValue()) {
            Intent intent = new Intent(this, BackgroundSoundService.class);
            intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
            startService(intent);
            this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukzapnuto);
        } else {
            Intent intent2 = new Intent(this, BackgroundSoundService.class);
            intent2.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
            stopService(intent2);
            this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukvypnuto);
        }
        this.Zvuk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(Otazka3.this);
                Boolean valueOf = Boolean.valueOf(defaultSharedPreferences.getBoolean("ZVUK", true));
                Intent intent = new Intent(Otazka3.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                if (valueOf.booleanValue()) {
                    SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                    edit.putBoolean("ZVUK", false);
                    edit.commit();
                    Otazka3.this.stopService(intent);
                    Otazka3.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukvypnuto);
                    return;
                }
                SharedPreferences.Editor edit2 = defaultSharedPreferences.edit();
                edit2.putBoolean("ZVUK", true);
                edit2.commit();
                Otazka3.this.startService(intent);
                Otazka3.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukzapnuto);
            }
        });
        this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f105u1.setTextColor(-1);
        this.f105u1.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f106u2.setTextColor(-1);
        this.f106u2.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f107u3.setTextColor(-1);
        this.f107u3.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f108u4.setTextColor(-1);
        this.f108u4.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
        this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
        this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
        this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
        this.up1.setTextColor(-1);
        this.up2.setTextColor(-1);
        this.up3.setTextColor(-1);
        this.up4.setTextColor(-1);
        this.textview3 = (TextView) findViewById(C1760R.C1762id.textView3);
        this.textview3.setTextColor(InputDeviceCompat.SOURCE_ANY);
        this.textview4 = (TextView) findViewById(C1760R.C1762id.textView4);
        this.textview4.setTextColor(-1);
        this.otazkaza = (TextView) findViewById(C1760R.C1762id.otazkaza);
        this.otazkaza.setText("300$ Question");
        this.mProgressBar = (ProgressBar) findViewById(C1760R.C1762id.progressBar3);
        this.mProgressBar.setProgress(this.f103i);
        this.mCountDownTimer = new CountDownTimer(40000, 1000) {
            public void onTick(long j) {
                Log.v("Log_tag", "Tick of Progress" + Otazka3.this.f103i + j);
                Otazka3 otazka3 = Otazka3.this;
                otazka3.f103i = otazka3.f103i + 1;
                Otazka3.this.mProgressBar.setProgress((Otazka3.this.f103i * 100) / 40);
            }

            public void onFinish() {
                Otazka3.this.f103i++;
                Otazka3.this.mProgressBar.setProgress(100);
                Otazka3.this.uzivatelOdpovedel = false;
                Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 0, 0);
            }
        };
        this.mCountDownTimer.start();
        int i9 = getIntent().getExtras().getInt("some_key2");
        int i10 = getIntent().getExtras().getInt("some_keyp2");
        if (getIntent().getExtras().getInt("some_keyt2") != 1) {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(true);
        } else {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(false);
            this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
            this.pomocnapromennat3 = 1;
        }
        if (i10 != 1) {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(true);
        } else {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(false);
            this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
            this.pomocnapromennap3 = 1;
        }
        if (i9 != 1) {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(true);
        } else {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(false);
            this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
            this.pomocnapromenna3 = 1;
        }
        this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f105u1.setEnabled(true);
        this.f106u2.setEnabled(true);
        this.f107u3.setEnabled(true);
        this.f108u4.setEnabled(true);
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
            this.otazkau.setText("Who has never been a part of music band The beatles?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("OZZY OSBOURNE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("JOHN LENNON");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("PAUL MCCARTNEY");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("GEORGE HARRISON");
            this.castka = 0;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("86%");
                    Otazka3.this.up2.setText("6%");
                    Otazka3.this.up3.setText("7%");
                    Otazka3.this.up4.setText("1%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 2) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many ancient wonders are there?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("7");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("5");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("9");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("1");
            this.castka = 0;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("86%");
                    Otazka3.this.up2.setText("4%");
                    Otazka3.this.up3.setText("7%");
                    Otazka3.this.up4.setText("3%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 3) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the capital of Denmark?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("VILNIUS");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("COPENHAGEN");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("BERLIN");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("OSLO");
            this.castka = 0;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("4%");
                    Otazka3.this.up2.setText("86%");
                    Otazka3.this.up3.setText("7%");
                    Otazka3.this.up4.setText("3%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 4) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many milliseconds are there in one second?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("10");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("100");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("1000");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("1 000 000");
            this.castka = 0;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("4%");
                    Otazka3.this.up2.setText("21%");
                    Otazka3.this.up3.setText("69%");
                    Otazka3.this.up4.setText("6%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 5) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these actors played Harry Potter?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("DANIEL RADCLIFFE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("DWAYNE JOHNSON");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("GEORGE CLOONEY");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("WILL SMITH");
            this.castka = 0;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("93%");
                    Otazka3.this.up2.setText("0%");
                    Otazka3.this.up3.setText("6%");
                    Otazka3.this.up4.setText("1%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 6) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Arachnophobia is a fear of?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("PEOPLE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("STUDYING");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("HEIGHTS");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("SPIDERS");
            this.castka = 0;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("10%");
                    Otazka3.this.up2.setText("4%");
                    Otazka3.this.up3.setText("16%");
                    Otazka3.this.up4.setText("70%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 7) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who is the author of plays like Othello or Macbeth?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("WILLIAM SHAKESPEARE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("MOLIÉRE");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("LEONARDO DA VINCI");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("HENRYK SZIENKEWICZ");
            this.castka = 0;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("60%");
                    Otazka3.this.up2.setText("20%");
                    Otazka3.this.up3.setText("19%");
                    Otazka3.this.up4.setText("1%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 8) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which of the following sports are there most players on a pitch?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("BASKETBALL");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("HANDBALL");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("BEACH VOLLEYBALL");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("TENNIS");
            this.castka = 0;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("17%");
                    Otazka3.this.up2.setText("74%");
                    Otazka3.this.up3.setText("5%");
                    Otazka3.this.up4.setText("4%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 9) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is tequila made from?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("COFFEE TREE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("BANANA TREE");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("PRICKLY PEAR");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("AGAVE");
            this.castka = 0;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("10%");
                    Otazka3.this.up2.setText("11%");
                    Otazka3.this.up3.setText("20%");
                    Otazka3.this.up4.setText("59%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 10) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who founded Microsoft?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("MARK ZUCKENBERG");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("BILL GATES");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("DENNIS RITCHIE");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("STEVE JOBS");
            this.castka = 0;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("4%");
                    Otazka3.this.up2.setText("87%");
                    Otazka3.this.up3.setText("6%");
                    Otazka3.this.up4.setText("3%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 11) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these cities is southern from equator?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("MONTE CARLO");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("DAKAR");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("ISLAMABAD");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("RIO DE JANIERO");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("4%");
                    Otazka3.this.up2.setText("5%");
                    Otazka3.this.up3.setText("23%");
                    Otazka3.this.up4.setText("68%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 12) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which river flows into the Caspian sea?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("DANUBE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("VOLGA");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("EBRO");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("ELBE");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("10%");
                    Otazka3.this.up2.setText("79%");
                    Otazka3.this.up3.setText("4%");
                    Otazka3.this.up4.setText("7%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 13) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which planet of the Solar system is the biggest one?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("JUPITER");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("SATURN");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("URANUS");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("NEPTUNE");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("83%");
                    Otazka3.this.up2.setText("12%");
                    Otazka3.this.up3.setText("3%");
                    Otazka3.this.up4.setText("2%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 14) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What do we call the oath the doctors make?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("ARISTOTELLIC");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("PAPPOVIC");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("APOLONIC");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("HIPPOCRATIC");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("4%");
                    Otazka3.this.up2.setText("6%");
                    Otazka3.this.up3.setText("9%");
                    Otazka3.this.up4.setText("81%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 15) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of famous Arizona's canyon?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("GREAT");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("GRAND");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("BIG");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("MONUMENTAL");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("3%");
                    Otazka3.this.up2.setText("89%");
                    Otazka3.this.up3.setText("6%");
                    Otazka3.this.up4.setText("2%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 16) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which country is not in Africa?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("RWANDA");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("COLOMBIA");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("SENEGAL");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("TUNISIA");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("3%");
                    Otazka3.this.up2.setText("91%");
                    Otazka3.this.up3.setText("4%");
                    Otazka3.this.up4.setText("2%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 17) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where can we find cities Kyiev, Odessa or Lvov?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("LATVIA");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("LITHUANIA");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("UKRAINE");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("RUSSIA");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("7%");
                    Otazka3.this.up2.setText("6%");
                    Otazka3.this.up3.setText("78%");
                    Otazka3.this.up4.setText("9%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 18) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of an Ukrainian island annexed by Russia in 2014?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("RHODES");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("CUNDA");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("CRIMEA");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("KOTLIN");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("5%");
                    Otazka3.this.up2.setText("3%");
                    Otazka3.this.up3.setText("85%");
                    Otazka3.this.up4.setText("7%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 19) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What or who did Harry Potter kill in the second movie?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("GILDEROY LOCKHART");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("HORACE SLUGHORN");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("BASILISK");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("DEMENTOR");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("4%");
                    Otazka3.this.up2.setText("3%");
                    Otazka3.this.up3.setText("81%");
                    Otazka3.this.up4.setText("12%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 20) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of the main protagonist in the Lord of the Rings saga?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("FRODO BAGGINS");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("CROUCH BARTEMIUS");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("EDWARD CULLEN");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("SASHA HORIL");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("92%");
                    Otazka3.this.up2.setText("2%");
                    Otazka3.this.up3.setText("1%");
                    Otazka3.this.up4.setText("5%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 21) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What do we call the part of Alps in northern Italy?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("STALAGMITES");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("DOLOMITES");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("APUAN ALPS");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("CAMPANELLES");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("1%");
                    Otazka3.this.up2.setText("90%");
                    Otazka3.this.up3.setText("4%");
                    Otazka3.this.up4.setText("5%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 22) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of this islands does not belong to France?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("SICILY");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("SARDINIA");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("ELBA");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("CORSICA");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("3%");
                    Otazka3.this.up2.setText("9%");
                    Otazka3.this.up3.setText("5%");
                    Otazka3.this.up4.setText("83%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 23) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Epidemy of which disease is known as Black Death?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("CHOLERA");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("DIPHTHERIA");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("TUBERCULOSIS");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("PLAGUE");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("14%");
                    Otazka3.this.up2.setText("6%");
                    Otazka3.this.up3.setText("9%");
                    Otazka3.this.up4.setText("71%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 24) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which century stroke the spanish flu?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("14TH");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("16TH");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("18TH");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("20TH");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("16%");
                    Otazka3.this.up2.setText("12%");
                    Otazka3.this.up3.setText("8%");
                    Otazka3.this.up4.setText("64%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 25) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which country was renaissance born?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("FRANCE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("ITALY");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("SPAIN");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("ENGLAND");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("21%");
                    Otazka3.this.up2.setText("54%");
                    Otazka3.this.up3.setText("11%");
                    Otazka3.this.up4.setText("14%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 26) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Andorra borders with:");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("ITALY");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("PORTUGAL");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("CROATIA");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("SPAIN");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("5%");
                    Otazka3.this.up2.setText("2%");
                    Otazka3.this.up3.setText("9%");
                    Otazka3.this.up4.setText("84%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 27) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who is the owner of Amazon?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("JEFF BEZOS");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("BILL GATES");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("NICOLAS CRAIG");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("ROMAN ABRAMOVICH");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("63%");
                    Otazka3.this.up2.setText("11%");
                    Otazka3.this.up3.setText("18%");
                    Otazka3.this.up4.setText("8%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 28) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the channel between Spain and Morocco called?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("HUDSON’S");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("BERING’S");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("GIBRALTAR");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("HUMORZS");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("6%");
                    Otazka3.this.up2.setText("2%");
                    Otazka3.this.up3.setText("87%");
                    Otazka3.this.up4.setText("5%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 29) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("E. A. Poe is best known for his poem named after which animal?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("RAVEN");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("FOX");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("JAYBIRD");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("CROW");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("84%");
                    Otazka3.this.up2.setText("3%");
                    Otazka3.this.up3.setText("4%");
                    Otazka3.this.up4.setText("9%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 30) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("The most known port of Ukraine is:");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("ODESSA");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("KIEV");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("LVOV");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("BREST");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("76%");
                    Otazka3.this.up2.setText("4%");
                    Otazka3.this.up3.setText("8%");
                    Otazka3.this.up4.setText("12%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 31) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these poker combinations has the highest value?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("FULL HOUSE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("PAIR");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("THREE OF A KIND");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("ROYAL FLUSH");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("10%");
                    Otazka3.this.up2.setText("0%");
                    Otazka3.this.up3.setText("6%");
                    Otazka3.this.up4.setText("84%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 32) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the antonym of the word happy?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("SAD");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("ANGRY");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("HAPPINESS");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("SADNESS");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("83%");
                    Otazka3.this.up2.setText("2%");
                    Otazka3.this.up3.setText("14%");
                    Otazka3.this.up4.setText("1%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 33) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which chemical element has a mark X?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("XENON");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("TECHNETIUM");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("NONE OF EXISTING");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("THALLIUM");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("16%");
                    Otazka3.this.up2.setText("1%");
                    Otazka3.this.up3.setText("82%");
                    Otazka3.this.up4.setText("1%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 34) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Unit of what is a light-year?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("TIME");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("SPEED");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("LENGTH");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("LUMINOUS INTENSITY");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("12%");
                    Otazka3.this.up2.setText("8%");
                    Otazka3.this.up3.setText("66%");
                    Otazka3.this.up4.setText("14%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 35) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where were the 2016 summer olympics held?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("RUSSIA");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("CHINA");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("ITALY");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("BRAZIL");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("5%");
                    Otazka3.this.up2.setText("8%");
                    Otazka3.this.up3.setText("6%");
                    Otazka3.this.up4.setText("81%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 36) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which state of the USA is populated the most?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("CALIFORNIA");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("NEW YORK");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("FLORIDA");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("TEXAS");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("35%");
                    Otazka3.this.up2.setText("27%");
                    Otazka3.this.up3.setText("26%");
                    Otazka3.this.up4.setText("12%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 37) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("If it’s warmer the higher we go, we are dealing with:");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("MONZUNE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("ANTICYCLONE");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("INVERSION");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("TYPHOON");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("1%");
                    Otazka3.this.up2.setText("15%");
                    Otazka3.this.up3.setText("83%");
                    Otazka3.this.up4.setText("1%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 38) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these systems can not be found in human’s body?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("REPRODUCTIVE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("NERVOUS");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("GASTROVASCULAR");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("HORMONAL");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("0%");
                    Otazka3.this.up2.setText("0%");
                    Otazka3.this.up3.setText("94%");
                    Otazka3.this.up4.setText("6%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 39) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which state is not a part of the Great Britain?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("ENGLAND");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("IRELAND");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("WALES");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("SCOTLAND");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("27%");
                    Otazka3.this.up2.setText("64%");
                    Otazka3.this.up3.setText("5%");
                    Otazka3.this.up4.setText("4%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 40) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("French is:");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("ROMANCE LANGUAGE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("GERMAN LANGUAGE");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("CELTIC LANGUAGE");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("BALTIC LANGUAGE");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("83%");
                    Otazka3.this.up2.setText("5%");
                    Otazka3.this.up3.setText("12%");
                    Otazka3.this.up4.setText("0%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 41) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is not a typical part for lasagna dish?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("PASTA");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("MEAT SAUCE");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("CHEESE");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("CHAMPIGNONS");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("0%");
                    Otazka3.this.up2.setText("26%");
                    Otazka3.this.up3.setText("2%");
                    Otazka3.this.up4.setText("72%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 42) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What's the name of a bell in the Westminster palace tower?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("LITTLE BOY");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("FAT BOY");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("TALL BART");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("BIG BEN");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("2%");
                    Otazka3.this.up2.setText("1%");
                    Otazka3.this.up3.setText("1%");
                    Otazka3.this.up4.setText("96%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 43) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which football club is often called as the Gunners?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("CHELSEA FC");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("REAL MADRID CF");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("MANCHESTER UNITED");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("ARSENAL");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("6%");
                    Otazka3.this.up2.setText("6%");
                    Otazka3.this.up3.setText("7%");
                    Otazka3.this.up4.setText("81%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 44) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What colour of cat is said to bring bad luck?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("WHITE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("BLACK");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("BROWN");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("PURPLE");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("0%");
                    Otazka3.this.up2.setText("63%");
                    Otazka3.this.up3.setText("35%");
                    Otazka3.this.up4.setText("2%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 45) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which prefix in the SI stands for one millionth?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("MILLI");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("MICRO");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("NANO");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("PICO");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("6%");
                    Otazka3.this.up2.setText("72%");
                    Otazka3.this.up3.setText("19%");
                    Otazka3.this.up4.setText("3%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 46) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where is held the biggest carneval of the world?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("IN PARIS");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("IN RIO DE JANIERO");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("IN SAO PAULO");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("IN BEIJING");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("4%");
                    Otazka3.this.up2.setText("69%");
                    Otazka3.this.up3.setText("21%");
                    Otazka3.this.up4.setText("6%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 47) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Against who fought England in the 100 years war?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("SPAIN");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("FRANCE");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("SCOTLAND");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("RUSSIA");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("3%");
                    Otazka3.this.up2.setText("64%");
                    Otazka3.this.up3.setText("2%");
                    Otazka3.this.up4.setText("31%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 48) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Extrovert usually isn’t:");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("ACTIVE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("SOCIAL");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("FRIENDLY");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("SLOW");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("13%");
                    Otazka3.this.up2.setText("2%");
                    Otazka3.this.up3.setText("14%");
                    Otazka3.this.up4.setText("71%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 49) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these can’t be found in human’s ear?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("AMBOS");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("STAPES");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("EARDRUM");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("HORSESHOE");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("5%");
                    Otazka3.this.up2.setText("4%");
                    Otazka3.this.up3.setText("8%");
                    Otazka3.this.up4.setText("83%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 50) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How did Abraham Lincoln die?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("HE WAS SHOT");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("TUBERCULOSIS");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("SYPHILIS");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("GAS POISONING");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("83%");
                    Otazka3.this.up2.setText("4%");
                    Otazka3.this.up3.setText("3%");
                    Otazka3.this.up4.setText("10%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 51) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where do they wear kilts?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("SCOTLAND");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("HUNGARY");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("RUSSIA");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("MONGOLIA");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("68%");
                    Otazka3.this.up2.setText("14%");
                    Otazka3.this.up3.setText("7%");
                    Otazka3.this.up4.setText("11%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 52) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What do the B's stand for in the shortcut BBC?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("BRITISH BEGINNING");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("BRITISH BROADCASTING");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("BRITISH BACON");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("BRITISH BUSSINESS");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("21%");
                    Otazka3.this.up2.setText("76%");
                    Otazka3.this.up3.setText("2%");
                    Otazka3.this.up4.setText("1%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 53) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many gods does a monotheistic religion have?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("0");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("1");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("2");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("12");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("8%");
                    Otazka3.this.up2.setText("82%");
                    Otazka3.this.up3.setText("4%");
                    Otazka3.this.up4.setText("6%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 54) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which car producer has created the model Focus?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("ŠKODA");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("FORD");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("HYUNDAI");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("FERRARI");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("4%");
                    Otazka3.this.up2.setText("72%");
                    Otazka3.this.up3.setText("16%");
                    Otazka3.this.up4.setText("8%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 55) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is an elephant?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("FISH");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("MAMMAL");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("AMPHIBIAN");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("MOLLUSC");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("12%");
                    Otazka3.this.up2.setText("7%");
                    Otazka3.this.up3.setText("80%");
                    Otazka3.this.up4.setText("1%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 56) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who of the following singers has commited a suicide?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("FREDDIE MERCURY");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("JOHN LENNON");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("MICHAEL JACKSON");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("KURT COBAIN");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("5%");
                    Otazka3.this.up2.setText("4%");
                    Otazka3.this.up3.setText("3%");
                    Otazka3.this.up4.setText("88%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 57) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who or what is/are Guns N' Roses?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("AMERICAN SALAD");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("AMERICAN COWBOY");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("BRITISH COMEDIAN");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("AMERICAN BAND");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("3%");
                    Otazka3.this.up2.setText("0%");
                    Otazka3.this.up3.setText("2%");
                    Otazka3.this.up4.setText("95%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 58) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("The company Whiskas makes food for?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("JUSTIN BIEBER");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("PSY");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("CATS");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("CHICKENS");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("0%");
                    Otazka3.this.up2.setText("21%");
                    Otazka3.this.up3.setText("73%");
                    Otazka3.this.up4.setText("6%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 59) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which continent is populated the most?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("ASIA");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("AFRICA");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("SOUTH AMERICA");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("EUROPE");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("95%");
                    Otazka3.this.up2.setText("4%");
                    Otazka3.this.up3.setText("1%");
                    Otazka3.this.up4.setText("0%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 60) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these animals is the only mammal who can fly?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("BAT");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("SWAN");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("CHIHUAHUA");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("SQUIRREL");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("78%");
                    Otazka3.this.up2.setText("5%");
                    Otazka3.this.up3.setText("5%");
                    Otazka3.this.up4.setText("12%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 61) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who played captain Jack Sparrow?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("JOHNNY DEPP");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("LEONARDO DI CAPRIO");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("TOM HANKS");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("BRAD PITT");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("73%");
                    Otazka3.this.up2.setText("8%");
                    Otazka3.this.up3.setText("6%");
                    Otazka3.this.up4.setText("13%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 62) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these elements is radioactive?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("FRANCIUM");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("ZIRCON");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("ARSENIC");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("ARGON");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("73%");
                    Otazka3.this.up2.setText("18%");
                    Otazka3.this.up3.setText("5%");
                    Otazka3.this.up4.setText("4%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 63) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the smallest prime number?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("0");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("1");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("2");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("3");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("2%");
                    Otazka3.this.up2.setText("11%");
                    Otazka3.this.up3.setText("81%");
                    Otazka3.this.up4.setText("6%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 64) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which social site is mainly focused on sharing videos for free?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("YOUTUBE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("TWITTER");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("FLICKR");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("VK");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("46%");
                    Otazka3.this.up2.setText("12%");
                    Otazka3.this.up3.setText("25%");
                    Otazka3.this.up4.setText("17%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 65) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("After which good was the trade route between China and Europe named?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("SILK");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("PEPPER");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("TEA");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("SILVER");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("87%");
                    Otazka3.this.up2.setText("6%");
                    Otazka3.this.up3.setText("5%");
                    Otazka3.this.up4.setText("2%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 66) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the score when a tennis player wins first 3 exchanges in a game?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("15:0");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("30:0");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("40:0");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("45:0");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("8%");
                    Otazka3.this.up2.setText("4%");
                    Otazka3.this.up3.setText("88%");
                    Otazka3.this.up4.setText("0%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 67) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What was the name of the table that Arthur’s knights sat at?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("SQUARE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("OVAL");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("RECTANGLE");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("ROUND");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("7%");
                    Otazka3.this.up2.setText("16%");
                    Otazka3.this.up3.setText("1%");
                    Otazka3.this.up4.setText("76%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 68) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("When is Helloween?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("IN SEPTEMBER");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("IN OCTOBER");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("IN NOVEMBER");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("IN DECEMBER");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("7%");
                    Otazka3.this.up2.setText("72%");
                    Otazka3.this.up3.setText("19%");
                    Otazka3.this.up4.setText("2%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 69) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("On which peninsula can we find Denmark?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("JUTLAND PENINSULA");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("BRITTANY PENINSULA");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("IBERIAN PENINSULA");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("SCANDINAVIAN PENINSULA");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("64%");
                    Otazka3.this.up2.setText("8%");
                    Otazka3.this.up3.setText("3%");
                    Otazka3.this.up4.setText("25%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 70) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("The show must go on is a hit of which music band?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("ABBA");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("LED ZEPPELIN");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("THE BEATLES");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("QUEEN");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("0%");
                    Otazka3.this.up2.setText("12%");
                    Otazka3.this.up3.setText("14%");
                    Otazka3.this.up4.setText("74%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 71) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Brexit is about Britain leaving which organization?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("NATO");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("UNICEF");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("UNESCO");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("EU");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("4%");
                    Otazka3.this.up2.setText("1%");
                    Otazka3.this.up3.setText("8%");
                    Otazka3.this.up4.setText("87%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 72) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which country is not in the EU?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("RUSSIA");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("GERMANY");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("SPAIN");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("FRANCE");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("76%");
                    Otazka3.this.up2.setText("2%");
                    Otazka3.this.up3.setText("16%");
                    Otazka3.this.up4.setText("6%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 73) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these countries does not have over 300 million of inhabitants?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("BRASIL");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("INDIA");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("CHINA");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("USA");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("71%");
                    Otazka3.this.up2.setText("1%");
                    Otazka3.this.up3.setText("3%");
                    Otazka3.this.up4.setText("25%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 74) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who wasn't a painter?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("FRANCISCO GOYA");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("VICTOR HUGO");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("CLAUDE MANET");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("EDUARD MONET");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("9%");
                    Otazka3.this.up2.setText("59%");
                    Otazka3.this.up3.setText("16%");
                    Otazka3.this.up4.setText("16%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 75) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What do we call knocking over all 10 of the cones on our first try?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("SPARE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("SPLIT");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("GUTTER");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("STRIKE");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("8%");
                    Otazka3.this.up2.setText("3%");
                    Otazka3.this.up3.setText("2%");
                    Otazka3.this.up4.setText("87%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 76) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which part of tree contains the most chlorophyll?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("STICKS");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("LEAVES");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("ROOTS");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("TRUNK");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("9%");
                    Otazka3.this.up2.setText("82%");
                    Otazka3.this.up3.setText("5%");
                    Otazka3.this.up4.setText("4%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 77) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which country ruled Napoleon I.?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("ITALY");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("FRANCE");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("ENGLAND");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("SPAIN");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("8%");
                    Otazka3.this.up2.setText("89%");
                    Otazka3.this.up3.setText("1%");
                    Otazka3.this.up4.setText("2%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 78) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which animal is the fastest?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("GIRAFFE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("OSTRICH");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("CHEETAH");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("LION");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("8%");
                    Otazka3.this.up2.setText("11%");
                    Otazka3.this.up3.setText("76%");
                    Otazka3.this.up4.setText("5%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 79) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which plant do the lovers usually kiss under?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("HOLLY");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("TULIP");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("MISTLETOE");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("ROSE");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("5%");
                    Otazka3.this.up2.setText("17%");
                    Otazka3.this.up3.setText("59%");
                    Otazka3.this.up4.setText("19%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 80) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of a famous song by German band Rammstein?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("ICH BIN");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("ER HAT");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("DU HAST");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("WIR SIND");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("6%");
                    Otazka3.this.up2.setText("12%");
                    Otazka3.this.up3.setText("73%");
                    Otazka3.this.up4.setText("9%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 81) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is not a unit of temperature?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("CELSIUS");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("MARTIN");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("FAHRENHEIT");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("KELVIN");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("1%");
                    Otazka3.this.up2.setText("79%");
                    Otazka3.this.up3.setText("18%");
                    Otazka3.this.up4.setText("2%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 82) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which car producer is specialized on electric cars?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("JEEP");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("TESLA");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("SEAT");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("LAND ROVER");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("21%");
                    Otazka3.this.up2.setText("69%");
                    Otazka3.this.up3.setText("7%");
                    Otazka3.this.up4.setText("3%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 83) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is considered as a fruit?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("TOMATO");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("POTATO");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("CARROT");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("CHIVE");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("89%");
                    Otazka3.this.up2.setText("2%");
                    Otazka3.this.up3.setText("4%");
                    Otazka3.this.up4.setText("5%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 84) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who is David Attenborough?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("PHYSICIAN");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("NATURAL HISTORIAN");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("CHEMIST");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("SURGEON");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("6%");
                    Otazka3.this.up2.setText("89%");
                    Otazka3.this.up3.setText("5%");
                    Otazka3.this.up4.setText("0%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 85) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these formats is not used to store images?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("GIF");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("JPEG");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("PNG");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("AVI");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("8%");
                    Otazka3.this.up2.setText("2%");
                    Otazka3.this.up3.setText("14%");
                    Otazka3.this.up4.setText("76%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 86) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many seconds to Mars is in the name of famous music band?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("10");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("20");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("30");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("40");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("8%");
                    Otazka3.this.up2.setText("18%");
                    Otazka3.this.up3.setText("62%");
                    Otazka3.this.up4.setText("12%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 87) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the colour of mile in a famous film by Frank Darabont?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("GREEN");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("WHITE");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("BLACK");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("ORANGE");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("79%");
                    Otazka3.this.up2.setText("4%");
                    Otazka3.this.up3.setText("15%");
                    Otazka3.this.up4.setText("2%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 88) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these does not exist?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("EDISONIUM");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("EINSTEINIUM");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("EUROPIUM");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("CALIFORNIUM");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("65%");
                    Otazka3.this.up2.setText("4%");
                    Otazka3.this.up3.setText("15%");
                    Otazka3.this.up4.setText("16%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 89) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who of the following characters is not in Hamlet?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("HAMLET");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("CLAUDIUS");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("OTHELLO");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("OPHELIA");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("6%");
                    Otazka3.this.up2.setText("12%");
                    Otazka3.this.up3.setText("78%");
                    Otazka3.this.up4.setText("4%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 90) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who is the chancellor of Germany (2019)?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("GERHARD SCHRÖDER");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("HELMUT KOHL");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("TILL LINDEMANN");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("ANGELA MERKEL");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("8%");
                    Otazka3.this.up2.setText("2%");
                    Otazka3.this.up3.setText("12%");
                    Otazka3.this.up4.setText("78%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 91) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Formations that we can find in caves and come from the ceiling down are called?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("STALAGMITES");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("STALAGNITES");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("STALAGTS");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("STALACTITES");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("29%");
                    Otazka3.this.up2.setText("22%");
                    Otazka3.this.up3.setText("1%");
                    Otazka3.this.up4.setText("48%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 92) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who has won the most tennis grandslams?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("ANDRE AGASSI");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("NOVAK DJOKOVIC");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("ROGER FEDERER");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("ANDY MURRAY");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("5%");
                    Otazka3.this.up2.setText("14%");
                    Otazka3.this.up3.setText("75%");
                    Otazka3.this.up4.setText("16%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 93) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What do they eat during thanksgiving in USA?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("OSTRICH");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("DUCK");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("TURKEY");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("CHICKEN");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("1%");
                    Otazka3.this.up2.setText("9%");
                    Otazka3.this.up3.setText("86%");
                    Otazka3.this.up4.setText("4%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 94) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which house was Juliet in a play by William Shakespeare?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("ROSSI");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("ESCALUS");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("CAPULET");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("MONTAGUE");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("14%");
                    Otazka3.this.up2.setText("14%");
                    Otazka3.this.up3.setText("55%");
                    Otazka3.this.up4.setText("17%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 95) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Island of volcanic origin surrounded by coral reefs is called?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("MENTOL");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("ETOL");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("ATOL");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("NEMTOL");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("12%");
                    Otazka3.this.up2.setText("13%");
                    Otazka3.this.up3.setText("59%");
                    Otazka3.this.up4.setText("16%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 96) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many ribs are there in a human body?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("10");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("16");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("14");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("12");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("18%");
                    Otazka3.this.up2.setText("3%");
                    Otazka3.this.up3.setText("1%");
                    Otazka3.this.up4.setText("78%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 97) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Whale is:");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("A FISH");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("A CARTILAGINOUS FISH");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("A REPTILE");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("A MAMMAL");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("12%");
                    Otazka3.this.up2.setText("16%");
                    Otazka3.this.up3.setText("1%");
                    Otazka3.this.up4.setText("71%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 98) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where in the world was the lowest temperature measured?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("SIBERIA");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("ANTARCTICA");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("ICELAND");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("ARCTIC");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("14%");
                    Otazka3.this.up2.setText("78%");
                    Otazka3.this.up3.setText("1%");
                    Otazka3.this.up4.setText("7%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 99) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these was not written by Johann Wolfgang von Goethe?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("THE SORROW OF YOUNG WERTHER");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("FAUST");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("IFIGENIA IN TAURIS");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("THE OLD MAN AND THE SEA");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("11%");
                    Otazka3.this.up2.setText("3%");
                    Otazka3.this.up3.setText("30%");
                    Otazka3.this.up4.setText("56%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 100) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Israel’s main religion is?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("ISLAM");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("CHRISTIANITY");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("HINDUISM");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("JUDAISM");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("4%");
                    Otazka3.this.up2.setText("16%");
                    Otazka3.this.up3.setText("0%");
                    Otazka3.this.up4.setText("80%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 101) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Foci is typical for which one of these?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("TRIANGLE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("LINE");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("RECTANGLE");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("ELLIPSE");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("10%");
                    Otazka3.this.up2.setText("3%");
                    Otazka3.this.up3.setText("11%");
                    Otazka3.this.up4.setText("76%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 102) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who is the author of The old man and the sea?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("ERNEST HEMINGWAY");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("WLLIAM SHAKESPEARE");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("GEORGE BYRON");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("WALTER SCOTT");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("56%");
                    Otazka3.this.up2.setText("9%");
                    Otazka3.this.up3.setText("14%");
                    Otazka3.this.up4.setText("21%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 103) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which kind of game is Call of Duty?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("HOCKEY");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("EDUCATIONAL");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("FOOTBALL");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("WAR");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("8%");
                    Otazka3.this.up2.setText("11%");
                    Otazka3.this.up3.setText("6%");
                    Otazka3.this.up4.setText("75%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 104) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which year was taken the first photo of a black hole?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText(NativeAppInstallAd.ASSET_HEADLINE);
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("1980");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("2019");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("1993");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("4%");
                    Otazka3.this.up2.setText("6%");
                    Otazka3.this.up3.setText("62%");
                    Otazka3.this.up4.setText("28%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 105) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is a maximal value of pH?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("12");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("14");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("16");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("18");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("19%");
                    Otazka3.this.up2.setText("59%");
                    Otazka3.this.up3.setText("15%");
                    Otazka3.this.up4.setText("7%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 106) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of famous falls?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("GRANDIADA");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("NARNIA");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("HUASCARA");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("NIAGARA");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("15%");
                    Otazka3.this.up2.setText("7%");
                    Otazka3.this.up3.setText("2%");
                    Otazka3.this.up4.setText("76%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 107) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the longest river in North America?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("COLORADO");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("RIO GRANDE");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("YUKON");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("MISSISSIPPI");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("8%");
                    Otazka3.this.up2.setText("4%");
                    Otazka3.this.up3.setText("9%");
                    Otazka3.this.up4.setText("79%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 108) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these was taken out of the solar system in 2006?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("ERIS");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("PLUTO");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("EUROPA");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("DEIMOS");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("13%");
                    Otazka3.this.up2.setText("75%");
                    Otazka3.this.up3.setText("6%");
                    Otazka3.this.up4.setText("6%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 109) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is Parmesan?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("CHEESE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("TROPIC FRUIT");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("SALAMI");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("TROPIC VEGETABLE");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("53%");
                    Otazka3.this.up2.setText("29%");
                    Otazka3.this.up3.setText("12%");
                    Otazka3.this.up4.setText("6%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 110) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Germany’s plan to conquer Moscow was named?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("BARBAROSSA");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("BAGRADION");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("TYPHOON");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("SEELÖWE");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("95%");
                    Otazka3.this.up2.setText("4%");
                    Otazka3.this.up3.setText("1%");
                    Otazka3.this.up4.setText("0%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 111) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who wrote the story of Forrest Gump?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("STEPHEN KING");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("WINSTON GROOM");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("STEVEN SPIELBERG");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("ALFRED HITCHCOCK");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("9%");
                    Otazka3.this.up2.setText("65%");
                    Otazka3.this.up3.setText("3%");
                    Otazka3.this.up4.setText("23%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 112) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who is often called as the king of rock n' roll?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("MICHAEL JACKSON");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("KURT COBAIN");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("ELVIS PRESLEY");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("DAVE GROHL");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("4%");
                    Otazka3.this.up2.setText("5%");
                    Otazka3.this.up3.setText("85%");
                    Otazka3.this.up4.setText("6%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 113) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the largest desert in the world?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("KALAHARI");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("GOBI");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("ATACAMA");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("SAHARA");
            this.castka = 2000;
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(4);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("21%");
                    Otazka3.this.up2.setText("4%");
                    Otazka3.this.up3.setText("2%");
                    Otazka3.this.up4.setText("73%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuD());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 114) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of the following sights is not in England?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("STONEHENGE");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("TOWER BRIDGE");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("MOUNT RUSHMORE");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("BIG BEN");
            this.castka = 2000;
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(3);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("7%");
                    Otazka3.this.up2.setText("9%");
                    Otazka3.this.up3.setText("76%");
                    Otazka3.this.up4.setText("8%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuC());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 115) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who wasn't a mathematician?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("PYTHAGORAS");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("JIMI HENDRIX");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("EUCLID");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("CARL FRIEDRICH GAUSS");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("6%");
                    Otazka3.this.up2.setText("89%");
                    Otazka3.this.up3.setText("2%");
                    Otazka3.this.up4.setText("3%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 116) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which city can we find Lincoln memorial?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("IN WASHINGTON");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("IN NEW YORK");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("IN LOS ANGELES");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("IN DALLAS");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("78%");
                    Otazka3.this.up2.setText("14%");
                    Otazka3.this.up3.setText("6%");
                    Otazka3.this.up4.setText("2%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setEnabled(false);
                    Otazka3.this.f106u2.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up2.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 117) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who betrayed Jesus Christ?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("MATTHEW");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("JUDAS");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("VASIL");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("SAUL");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up2.setText("78%");
                    Otazka3.this.up1.setText("14%");
                    Otazka3.this.up3.setText("6%");
                    Otazka3.this.up4.setText("2%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 118) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which coffee has the highest density of milk?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("ESPRESSO");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("CAPPUCCINO");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("RISTRETTO");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("MOCHACHINO");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up2.setText("78%");
                    Otazka3.this.up1.setText("6%");
                    Otazka3.this.up3.setText("14%");
                    Otazka3.this.up4.setText("2%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 119) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where is Hannover?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("IN AUSTRIA");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("IN GERMANY");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("IN SWITZERLAND");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("IN NETHERLANDS");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up2.setText("63%");
                    Otazka3.this.up1.setText("12%");
                    Otazka3.this.up3.setText("14%");
                    Otazka3.this.up4.setText("11%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 120) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the capital of Poland?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("KRAKOW");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("WARSZAWA");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("KATOWICE");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("LODZ");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up2.setText("63%");
                    Otazka3.this.up1.setText("25%");
                    Otazka3.this.up3.setText("7%");
                    Otazka3.this.up4.setText("5%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 121) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who created the theories of general and special relatvity?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("ENRICO FERMI");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("ALBERT EINSTEIN");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("STEPHEN HAWKING");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("ARISTOTELES");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up2.setText("63%");
                    Otazka3.this.up1.setText("7%");
                    Otazka3.this.up3.setText("25%");
                    Otazka3.this.up4.setText("5%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 122) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these elements is iron?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("CO");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("FE");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("AU");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("FU");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("1%");
                    Otazka3.this.up2.setText("97%");
                    Otazka3.this.up3.setText("1%");
                    Otazka3.this.up4.setText("2%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setEnabled(false);
                    Otazka3.this.f105u1.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up1.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 123) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which hurricane caused extensive damage in New Orleans?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("JOHN");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("KATRINA");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("VERACRUZ");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("OLIVIA");
            this.castka = 2000;
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(2);
                }
            });
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("3%");
                    Otazka3.this.up2.setText("95%");
                    Otazka3.this.up3.setText("2%");
                    Otazka3.this.up4.setText("0%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuB());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        } else if (this.losovane == 124) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who is the author of Waka Waka (the official Fifa WC 2010 song)?");
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setText("SHAKIRA");
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setText("RIHANNA");
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setText("MADONNA");
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setText("BRITNEY SPEARS");
            this.castka = 2000;
            this.f105u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.Spravna(1);
                }
            });
            this.f106u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f107u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.f108u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.gameOver2(Otazka3.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka3.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unl.setEnabled(false);
                    Otazka3.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up1.setText("95%");
                    Otazka3.this.up2.setText("2%");
                    Otazka3.this.up3.setText("3%");
                    Otazka3.this.up4.setText("0%");
                    Otazka3.this.pomocnapromenna3 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unp.setEnabled(false);
                    Otazka3.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setEnabled(false);
                    Otazka3.this.f108u4.setVisibility(4);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setEnabled(false);
                    Otazka3.this.f107u3.setVisibility(4);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.up4.setVisibility(4);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up3.setVisibility(4);
                    Otazka3.this.pomocnapromennap3 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka3.this.unt.setEnabled(false);
                    Otazka3.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka3.this);
                    builder.setMessage((CharSequence) Otazka3.this.pritelNaTelefonuA());
                    builder.create().show();
                    Otazka3.this.pomocnapromennat3 = 1;
                }
            });
        }
        this.dvere = (Button) findViewById(C1760R.C1762id.dvere);
        this.dvere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Otazka3.this.castka = 2000;
                Otazka3.this.gameOver();
                if (Otazka3.this.castka > Otazka3.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                    Otazka3.this.highscore(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public String pritelNaTelefonuA() {
        String[] strArr = {"Benjamin", "Daniel", "Ethan", "Henry", "Jacob", "Oliver", "Gordon", "Alice", "Bella", "Eva", "Hermione", "Sophie", "Mia", "Emily", "Meghan", "Chloe", "Charlotte", "Ben", "David", "William", "Andrew", "Lucy", "Hannah"};
        String str = strArr[new Random().nextInt(strArr.length)];
        return str + ": Hey, it is definitely A)!";
    }

    /* access modifiers changed from: private */
    public String pritelNaTelefonuB() {
        String[] strArr = {"Benjamin", "Daniel", "Ethan", "Henry", "Jacob", "Oliver", "Gordon", "Alice", "Bella", "Eva", "Hermione", "Sophie", "Mia", "Emily", "Meghan", "Chloe", "Charlotte", "Ben", "David", "William", "Andrew", "Lucy", "Hannah"};
        String str = strArr[new Random().nextInt(strArr.length)];
        return str + ": Hi, I am sure it's B).";
    }

    /* access modifiers changed from: private */
    public String pritelNaTelefonuC() {
        String[] strArr = {"Benjamin", "Daniel", "Ethan", "Henry", "Jacob", "Oliver", "Gordon", "Alice", "Bella", "Eva", "Hermione", "Sophie", "Mia", "Emily", "Meghan", "Chloe", "Charlotte", "Ben", "David", "William", "Andrew", "Lucy", "Hannah"};
        String str = strArr[new Random().nextInt(strArr.length)];
        return str + ": Hi, It's C), 100%";
    }

    /* access modifiers changed from: private */
    public String pritelNaTelefonuD() {
        String[] strArr = {"Benjamin", "Daniel", "Ethan", "Henry", "Jacob", "Oliver", "Gordon", "Alice", "Bella", "Eva", "Hermione", "Sophie", "Mia", "Emily", "Meghan", "Chloe", "Charlotte", "Ben", "David", "William", "Andrew", "Lucy", "Hannah"};
        String str = strArr[new Random().nextInt(strArr.length)];
        return str + ": Hey, it must be D).";
    }

    /* access modifiers changed from: private */
    public void gameOver() {
        this.gameOver = true;
        Intent intent = new Intent(this, BackgroundSoundService.class);
        intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
        stopService(intent);
        this.castka = ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION;
        Intent intent2 = new Intent(this, PopActivity.class);
        intent2.putExtra("Level", this.level);
        intent2.putExtra("Castka", this.castka);
        intent2.putExtra("pomocnapromenna", this.pomocnapromenna3);
        intent2.putExtra("pomocnapromennap", this.pomocnapromennap3);
        intent2.putExtra("pomocnapromennat", this.pomocnapromennat3);
        startActivity(intent2);
        this.mCountDownTimer.cancel();
    }

    private void loadRewardedVideoAd() {
        this.mRewardedVideoAd.loadAd("ca-app-pub-6056957033271627/8100699761", new AdRequest.Builder().build());
    }

    /* access modifiers changed from: private */
    public void gameOver2(final boolean z, final int i, final int i2) {
        this.gameOver = true;
        this.mCountDownTimer.cancel();
        this.castka = 0;
        this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f105u1.setEnabled(false);
        this.f106u2.setEnabled(false);
        this.f107u3.setEnabled(false);
        this.f108u4.setEnabled(false);
        if (i != 0) {
            int parseColor = Color.parseColor("#ffaa00");
            this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
            this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
            this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
            this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
            if (i == 1) {
                this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f105u1.setTextColor(parseColor);
                this.f105u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up1.setTextColor(parseColor);
            } else if (i == 2) {
                this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f106u2.setTextColor(parseColor);
                this.f106u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up2.setTextColor(parseColor);
            } else if (i == 3) {
                this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f107u3.setTextColor(parseColor);
                this.f107u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up3.setTextColor(parseColor);
            } else if (i == 4) {
                this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f108u4.setTextColor(parseColor);
                this.f108u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up4.setTextColor(parseColor);
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    int parseColor = Color.parseColor("#fcff0202");
                    int parseColor2 = Color.parseColor("#1dc700");
                    Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                    Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                    Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                    Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    if (i == 1) {
                        Otazka3.this.f105u1.setTextColor(parseColor);
                        Otazka3.this.f105u1.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka3.this.up1.setTextColor(parseColor);
                    } else if (i == 2) {
                        Otazka3.this.f106u2.setTextColor(parseColor);
                        Otazka3.this.f106u2.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka3.this.up2.setTextColor(parseColor);
                    } else if (i == 3) {
                        Otazka3.this.f107u3.setTextColor(parseColor);
                        Otazka3.this.f107u3.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka3.this.up3.setTextColor(parseColor);
                    } else if (i == 4) {
                        Otazka3.this.f108u4.setTextColor(parseColor);
                        Otazka3.this.f108u4.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka3.this.up4.setTextColor(parseColor);
                    }
                    if (i2 == 1) {
                        Otazka3.this.f105u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka3.this.f105u1.setTextColor(parseColor2);
                        Otazka3.this.up1.setTextColor(parseColor2);
                    } else if (i2 == 2) {
                        Otazka3.this.f106u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka3.this.f106u2.setTextColor(parseColor2);
                        Otazka3.this.up2.setTextColor(parseColor2);
                    } else if (i2 == 3) {
                        Otazka3.this.f107u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka3.this.f107u3.setTextColor(parseColor2);
                        Otazka3.this.up3.setTextColor(parseColor2);
                    } else if (i2 == 4) {
                        Otazka3.this.f108u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka3.this.f108u4.setTextColor(parseColor2);
                        Otazka3.this.up4.setTextColor(parseColor2);
                    }
                    Intent intent = new Intent(Otazka3.this, BackgroundSoundService.class);
                    intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                    Otazka3.this.stopService(intent);
                    Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka3.this).getBoolean("ZVUK", true));
                    Otazka3.this.spatna = MediaPlayer.create(Otazka3.this, C1760R.raw.spatna2);
                    if (z && valueOf.booleanValue()) {
                        Otazka3.this.spatna.start();
                    }
                }
            }, 1500);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Otazka3.this.alertDialog();
                    if (Otazka3.this.mInterstitialAd.isLoaded()) {
                        Otazka3.this.mInterstitialAd.show();
                    }
                }
            }, 3500);
            this.castka = 0;
            return;
        }
        alertDialog();
    }

    /* access modifiers changed from: private */
    public void Spravna(final int i) {
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_3", 0);
        int i2 = sharedPreferences.getInt("x", -1) + 1;
        SharedPreferences.Editor edit = getSharedPreferences("zodpovezene_3", 0).edit();
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
        this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f105u1.setEnabled(false);
        this.f106u2.setEnabled(false);
        this.f107u3.setEnabled(false);
        this.f108u4.setEnabled(false);
        if (i == 1) {
            this.f105u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f105u1.setTextColor(parseColor);
            this.f105u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up1.setTextColor(parseColor);
        } else if (i == 2) {
            this.f106u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f106u2.setTextColor(parseColor);
            this.f106u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up2.setTextColor(parseColor);
        } else if (i == 3) {
            this.f107u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f107u3.setTextColor(parseColor);
            this.f107u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up3.setTextColor(parseColor);
        } else {
            this.f108u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f108u4.setTextColor(parseColor);
            this.f108u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up4.setTextColor(parseColor);
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka3.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                Otazka3.this.stopService(intent);
                int parseColor = Color.parseColor("#1dc700");
                Otazka3.this.up1 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up1);
                Otazka3.this.up2 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up2);
                Otazka3.this.up3 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up3);
                Otazka3.this.up4 = (TextView) Otazka3.this.findViewById(C1760R.C1762id.up4);
                if (i == 1) {
                    Otazka3.this.f105u1 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka3.this.f105u1.setTextColor(parseColor);
                    Otazka3.this.f105u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka3.this.up1.setTextColor(parseColor);
                } else if (i == 2) {
                    Otazka3.this.f106u2 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka3.this.f106u2.setTextColor(parseColor);
                    Otazka3.this.f106u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka3.this.up2.setTextColor(parseColor);
                } else if (i == 3) {
                    Otazka3.this.f107u3 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka3.this.f107u3.setTextColor(parseColor);
                    Otazka3.this.f107u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka3.this.up3.setTextColor(parseColor);
                } else {
                    Otazka3.this.f108u4 = (Button) Otazka3.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka3.this.f108u4.setTextColor(parseColor);
                    Otazka3.this.f108u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka3.this.up4.setTextColor(parseColor);
                }
                if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka3.this).getBoolean("ZVUK", true)).booleanValue()) {
                    MediaPlayer.create(Otazka3.this, C1760R.raw.applause2).start();
                }
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka3.this, Otazka4.class);
                intent.putExtra("some_key3", Otazka3.this.pomocnapromenna3);
                intent.putExtra("some_keyp3", Otazka3.this.pomocnapromennap3);
                intent.putExtra("some_keyt3", Otazka3.this.pomocnapromennat3);
                Otazka3.this.startActivity(intent);
                CustomIntent.customType(Otazka3.this, "left-to-right");
            }
        }, 2500);
    }

    /* access modifiers changed from: private */
    public void highscore(int i) {
        if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true)).booleanValue()) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    MediaPlayer.create(Otazka3.this, C1760R.raw.applause7).start();
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
            Intent intent = new Intent(this, Otazka4.class);
            this.mCountDownTimer.cancel();
            intent.putExtra("some_key3", this.pomocnapromenna3);
            intent.putExtra("some_keyp3", this.pomocnapromennap3);
            intent.putExtra("some_keyt3", this.pomocnapromennat3);
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
            intent.putExtra("pomocnapromenna", this.pomocnapromenna3);
            intent.putExtra("pomocnapromennap", this.pomocnapromennap3);
            intent.putExtra("pomocnapromennat", this.pomocnapromennat3);
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
