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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import java.util.ArrayList;
import java.util.Random;
import maes.tech.intentanim.CustomIntent;

public class Otazka2 extends AppCompatActivity implements RewardedVideoAdListener {
    private static boolean activityVisible = false;
    static final int level = 2;
    Button Zvuk;

    /* renamed from: a */
    final int f89a = 0;
    ArrayList<Integer> arl = new ArrayList<>();

    /* renamed from: b */
    final int f90b = 0;
    int castka;
    int delay;
    Button dvere;
    boolean gameOver = false;

    /* renamed from: i */
    int f91i = 0;
    int[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124};
    int losovane;
    CountDownTimer mCountDownTimer;
    ProgressBar mProgressBar;
    private RewardedVideoAd mRewardedVideoAd;
    TextView otazka2;
    TextView otazkau;
    TextView otazkaza;
    int pomocnapromenna2;
    int pomocnapromennap2;
    int pomocnapromennat2;

    /* renamed from: r */
    Random f92r;
    TextView textview2;
    TextView textview3;

    /* renamed from: u1 */
    Button f93u1;

    /* renamed from: u2 */
    Button f94u2;

    /* renamed from: u3 */
    Button f95u3;

    /* renamed from: u4 */
    Button f96u4;
    Button unl;
    Button unp;
    Button unt;
    TextView up1;
    TextView up2;
    TextView up3;
    TextView up4;
    boolean uzivatelOdpovedel = true;

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
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_2", 0);
        int i = sharedPreferences.getInt("x", -1) + 1;
        System.out.println(i + "!!!!");
        SharedPreferences sharedPreferences2 = getSharedPreferences("zodpovezene_2", 0);
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
        this.f92r = new Random();
        this.castka = 0;
        if (this.arl.size() == 0) {
            sharedPreferences.edit().clear().commit();
            sharedPreferences2.edit().clear().commit();
            int i5 = getSharedPreferences("zodpovezene_2", 0).getInt("x", -1) + 1;
            System.out.println(i5 + "!!!!");
            SharedPreferences sharedPreferences3 = getSharedPreferences("zodpovezene_2", 0);
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
        this.losovane = this.f92r.nextInt(this.arl.size());
        this.losovane = this.arl.get(this.losovane).intValue();
        setFinishOnTouchOutside(false);
        this.Zvuk = (Button) findViewById(C1760R.C1762id.zvuk);
        if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true)).booleanValue()) {
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
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(Otazka2.this);
                Boolean valueOf = Boolean.valueOf(defaultSharedPreferences.getBoolean("ZVUK", true));
                Intent intent = new Intent(Otazka2.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                if (valueOf.booleanValue()) {
                    SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                    edit.putBoolean("ZVUK", false);
                    edit.commit();
                    Otazka2.this.stopService(intent);
                    Otazka2.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukvypnuto);
                    return;
                }
                SharedPreferences.Editor edit2 = defaultSharedPreferences.edit();
                edit2.putBoolean("ZVUK", true);
                edit2.commit();
                Otazka2.this.startService(intent);
                Otazka2.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukzapnuto);
            }
        });
        this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f93u1.setTextColor(-1);
        this.f93u1.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f94u2.setTextColor(-1);
        this.f94u2.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f95u3.setTextColor(-1);
        this.f95u3.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f96u4.setTextColor(-1);
        this.f96u4.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
        this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
        this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
        this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
        this.up1.setTextColor(-1);
        this.up2.setTextColor(-1);
        this.up3.setTextColor(-1);
        this.up4.setTextColor(-1);
        this.textview2 = (TextView) findViewById(C1760R.C1762id.textView2);
        this.textview2.setTextColor(InputDeviceCompat.SOURCE_ANY);
        this.textview3 = (TextView) findViewById(C1760R.C1762id.textView3);
        this.textview3.setTextColor(-1);
        this.otazkaza = (TextView) findViewById(C1760R.C1762id.otazkaza);
        this.otazkaza.setText("200$ Question");
        this.mProgressBar = (ProgressBar) findViewById(C1760R.C1762id.progressBar3);
        this.mProgressBar.setProgress(this.f91i);
        this.mCountDownTimer = new CountDownTimer(40000, 1000) {
            public void onTick(long j) {
                Log.v("Log_tag", "Tick of Progress" + Otazka2.this.f91i + j);
                Otazka2 otazka2 = Otazka2.this;
                otazka2.f91i = otazka2.f91i + 1;
                Otazka2.this.mProgressBar.setProgress((Otazka2.this.f91i * 100) / 40);
            }

            public void onFinish() {
                Otazka2.this.uzivatelOdpovedel = false;
                Otazka2.this.f91i++;
                Otazka2.this.mProgressBar.setProgress(100);
                Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 0, 0);
            }
        };
        this.mCountDownTimer.start();
        int i9 = getIntent().getExtras().getInt("some_key");
        int i10 = getIntent().getExtras().getInt("some_keyp");
        if (getIntent().getExtras().getInt("some_keyt") != 1) {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(true);
        } else {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(false);
            this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
            this.pomocnapromennat2 = 1;
        }
        if (i10 != 1) {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(true);
        } else {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(false);
            this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
            this.pomocnapromennap2 = 1;
        }
        if (i9 != 1) {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(true);
        } else {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(false);
            this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
            this.pomocnapromenna2 = 1;
        }
        this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f93u1.setEnabled(true);
        this.f94u2.setEnabled(true);
        this.f95u3.setEnabled(true);
        this.f96u4.setEnabled(true);
        this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
        this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
        this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
        this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
        this.up1.setText("A)");
        this.up2.setText("B)");
        this.up3.setText("C)");
        this.up4.setText("D)");
        System.out.println("1!!!!!");
        switch (this.losovane) {
            case 1:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which of the following mountains are in Asia?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("ALPS");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("ROCKY MOUNTAINS");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("HIMALAYAS");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("ETHIOPIAN HIGHLANDS");
                this.castka = 0;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("5%");
                        Otazka2.this.up2.setText("1%");
                        Otazka2.this.up3.setText("87%");
                        Otazka2.this.up4.setText("7%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 2:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who has built pyramids?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("EGYPTIANS");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("ROMANS");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("CELTS");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("GREEKS");
                this.castka = 0;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("93%");
                        Otazka2.this.up2.setText("3%");
                        Otazka2.this.up3.setText("1%");
                        Otazka2.this.up4.setText("3%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 3:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What of the following is not a piece in chess?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("BISHOP");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("QUEEN");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("KNIGHT");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("SNIPER");
                this.castka = 0;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("1%");
                        Otazka2.this.up3.setText("3%");
                        Otazka2.this.up4.setText("94%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 4:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which of the following states is situated by the sea?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("NEPAL");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("BRAZIL");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("CHAD");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("CZECHIA");
                this.castka = 0;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("94%");
                        Otazka2.this.up3.setText("1%");
                        Otazka2.this.up4.setText("3%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 5:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who is the author of The little prince?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("J. K. ROWLING");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("J. R. R. TOLKIEN");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("JOHN LOCKE");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("ANTOINE DE ST.-EXUPÉRY");
                this.castka = 0;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("3%");
                        Otazka2.this.up2.setText("12%");
                        Otazka2.this.up3.setText("6%");
                        Otazka2.this.up4.setText("79%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 6:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is not a string instrument?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("GUITAR");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("TRUMPET");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("PIANO");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("UKULELE");
                this.castka = 0;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("1%");
                        Otazka2.this.up2.setText("91%");
                        Otazka2.this.up3.setText("5%");
                        Otazka2.this.up4.setText("3%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 7:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How do we call a kick when a footballer kicks an airborne ball rearward in midair?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("RAINBOW KICK");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("HEEL KICK");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("BICYCLE KICK");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("HARD KICK");
                this.castka = 0;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("1%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("96%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 8:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is a unit of force?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("YARD");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("PASCAL");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("NEWTON");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("KILOGRAM");
                this.castka = 0;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("5%");
                        Otazka2.this.up2.setText("3%");
                        Otazka2.this.up3.setText("91%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 9:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("In politics, what is EU?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("EUROPEAN UNION");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("ESTIMATED UTILITY");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("ENERGIC UNIT");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("EU IS NOTHING");
                this.castka = 0;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("92%");
                        Otazka2.this.up2.setText("7%");
                        Otazka2.this.up3.setText("1%");
                        Otazka2.this.up4.setText("0%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 10:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the name of main negative character in Harry Potter series?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("SEVERUS SNAPE");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("HORACE SLUGHORN");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("LORD VOLDEMORT");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("SIRIUS BLACK");
                this.castka = 0;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("4%");
                        Otazka2.this.up2.setText("0%");
                        Otazka2.this.up3.setText("95%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 11:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What was the first name of physics Einstein?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("ISAAC");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("NIKOLA");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("ALBERT");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("ROBERT");
                this.castka = 0;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("0%");
                        Otazka2.this.up2.setText("1%");
                        Otazka2.this.up3.setText("95%");
                        Otazka2.this.up4.setText("4%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 12:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who was the first American president?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("GEORGE BUSH JR.");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("DONALD TRUMP");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("GEORGE WASHINGTON");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("THEODORE ROOSEVELT");
                this.castka = 0;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("1%");
                        Otazka2.this.up2.setText("3%");
                        Otazka2.this.up3.setText("95%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 13:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is a standart time (in minutes) for NHL match?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("2x30");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("3x20");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("1x60");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("2x45");
                this.castka = 0;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("1%");
                        Otazka2.this.up2.setText("94%");
                        Otazka2.this.up3.setText("5%");
                        Otazka2.this.up4.setText("0%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 14:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What of the following is a fruit?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("ZUCCHINI");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("KOHLRABI");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("RADISH");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("AVOCADO");
                this.castka = 0;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("2%");
                        Otazka2.this.up4.setText("94%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 15:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which of the Paris sights was on fire in 2019?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("NOTRE-DAME");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("EIFFEL TOWER");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("ARC DE TRIOMPHE");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("CHAMPS-ÉLYSÉES");
                this.castka = 0;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("89%");
                        Otazka2.this.up2.setText("8%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("3%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 16:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which of the following marks is not from Sweden?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("VOLVO");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("HUSQVARNA");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("IKEA");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("FIAT");
                this.castka = 0;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("3%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("95%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 17:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the name of the main british sitcom character?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("MR. WIN");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("MR. DEAN");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("MR. WEED");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("MR. BEAN");
                this.castka = 0;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("5%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("93%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 18:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Complete this proverb: Better late than?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("NOW");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("NEVER");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("TODAY");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("EARLY");
                this.castka = 0;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("1%");
                        Otazka2.this.up2.setText("97%");
                        Otazka2.this.up3.setText("2%");
                        Otazka2.this.up4.setText("0%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 19:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who is not a neighbour of France?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("SWITZERLAND");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("POLAND");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("SPAIN");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("BELGIUM");
                this.castka = 0;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("3%");
                        Otazka2.this.up2.setText("94%");
                        Otazka2.this.up3.setText("3%");
                        Otazka2.this.up4.setText("0%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 20:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What covers the sun in the time of eclipse?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("CLOUDS");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("MOON");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("EARTH");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("PLANE");
                this.castka = 0;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("0%");
                        Otazka2.this.up2.setText("96%");
                        Otazka2.this.up3.setText("4%");
                        Otazka2.this.up4.setText("0%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 21:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Complete this proverb: Hope for the best but prepare for...");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("A JUMP");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("A MURDER");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("GOOD TIMES");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("THE WORST");
                this.castka = 0;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("9%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("89%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 22:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Conversion of gas to solid is called?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("DESUBLIMATION");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("MELTING");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("DRYING");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("SUBLIMATION");
                this.castka = 0;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("78%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("3%");
                        Otazka2.this.up4.setText("17%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 23:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which of these cities is not a capital city?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("MOSCOW");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("WASHINGTON");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("LONDON");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("TORONTO");
                this.castka = 0;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("0%");
                        Otazka2.this.up2.setText("10%");
                        Otazka2.this.up3.setText("1%");
                        Otazka2.this.up4.setText("89%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 24:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("12 squared is?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("144");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("169");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("112");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("121");
                this.castka = 0;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("92%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("6%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 25:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("The highest mountain of the Alps is called?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("MONT BLANC");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("MONTE ROSA");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("MATTERHORN");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("MT. EVEREST");
                this.castka = 0;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("92%");
                        Otazka2.this.up2.setText("5%");
                        Otazka2.this.up3.setText("2%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 26:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Popular game for childern is called?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("ANGRY ZEBRAS");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("HAPPY FLIES");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("ANGRY BIRDS");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("CRAZY GIRAFFES");
                this.castka = 0;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("3%");
                        Otazka2.this.up3.setText("94%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 27:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Complete this proverb: There's no place like...");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("HOME");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("A PUB");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("CROATIA");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("A SHOPPING CENTRE");
                this.castka = 0;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("99%");
                        Otazka2.this.up2.setText("1%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("0%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 28:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who or what is T/tsunami?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("POLE DANCER");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("BIG WAVE");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("ARTISTIC STYLE");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("CAKE");
                this.castka = 0;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("0%");
                        Otazka2.this.up2.setText("99%");
                        Otazka2.this.up3.setText("1%");
                        Otazka2.this.up4.setText("0%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 29:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who is Serena Williams?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("TENNIS PLAYER");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("RUNNER");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("JAVELIN THROWER");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("FORMULA ONE RACER");
                this.castka = 0;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("92%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("3%");
                        Otazka2.this.up4.setText("3%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 30:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Where is the oldest university in England?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("IN LEEDS");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("IN OXFORD");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("IN EDINBURGH");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("IN NEWCASTLE");
                this.castka = 0;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("93%");
                        Otazka2.this.up3.setText("2%");
                        Otazka2.this.up4.setText("3%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 31:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the most famous song from John Lennon?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("NOTHING ELSE MATTERS");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("RUN, RUN, RUN!");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("IMAGINE");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("FROM YESTERDAY");
                this.castka = 0;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("9%");
                        Otazka2.this.up2.setText("11%");
                        Otazka2.this.up3.setText("78%");
                        Otazka2.this.up4.setText("2%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 32:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is ukulele?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("RARE FLOWER");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("STRING INSTRUMENT");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("SPORT AID");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("PHYSICAL UNIT");
                this.castka = 0;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("10%");
                        Otazka2.this.up2.setText("87%");
                        Otazka2.this.up3.setText("1%");
                        Otazka2.this.up4.setText("2%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 33:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How do we call a device for containing and controlling nuclear reaction?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("TRACTOR");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("REDACTOR");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("CREATOR");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("REACTOR");
                this.castka = 0;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("3%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("3%");
                        Otazka2.this.up4.setText("92%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 34:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("A kangaroo can be naturaly found only in?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("AFRICA");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("SOUTH AMERICA");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("EUROPE");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("AUSTRALIA");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("3%");
                        Otazka2.this.up2.setText("4%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("93%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 35:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Opposite to revers is?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("DISVERS");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("BAD");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("GOOD");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("AVERS");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("1%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("2%");
                        Otazka2.this.up4.setText("95%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 36:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the capital of France?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("MUNICH");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("STRASSBOURG");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("MARSEILLE");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("PARIS");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("13%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("6%");
                        Otazka2.this.up4.setText("79%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 37:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Square root of 256 equals:");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("14");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("15");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("16");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("17");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("4%");
                        Otazka2.this.up2.setText("1%");
                        Otazka2.this.up3.setText("93%");
                        Otazka2.this.up4.setText("2%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 38:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which one is not a swimming style?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("BREASTSTROKE");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("BACKSTROKE");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("BUTTERFLY STROKE");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("HEAT STROKE");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("5%");
                        Otazka2.this.up2.setText("3%");
                        Otazka2.this.up3.setText("4%");
                        Otazka2.this.up4.setText("88%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 39:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which part of atom has positive charge?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("PROTONS");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("ELECTRONS");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("NEUTRONS");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("ALBUMIN");
                this.castka = 1000;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("92%");
                        Otazka2.this.up2.setText("5%");
                        Otazka2.this.up3.setText("2%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 40:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who is the main character in The big bang theory?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("HARRY POTTER");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("SHELDON COOPER");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("MASHA");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("BART SIMPSON");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("4%");
                        Otazka2.this.up2.setText("87%");
                        Otazka2.this.up3.setText("2%");
                        Otazka2.this.up4.setText("7%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 41:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which sport plays James LeBron?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("RUGBY");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("CRICKET");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("BASKETBALL");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("TENNIS");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("3%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("94%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 42:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How often are the winter olympics held?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("EVERY YEAR");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("EVERY OTHER YEAR");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("EVERY 4 YEARS");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("EVERY 5 YEARS");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("5%");
                        Otazka2.this.up3.setText("89%");
                        Otazka2.this.up4.setText("4%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 43:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who wasn't from France?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("MIGUEL CÉRVANTES");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("JEAN-JACQUES ROUSSEAU");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("VICTOR HUGO");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("FRANCOIS VILLON");
                this.castka = 1000;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("80%");
                        Otazka2.this.up2.setText("7%");
                        Otazka2.this.up3.setText("9%");
                        Otazka2.this.up4.setText("4%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 44:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("In which sport do you use the smallest ball?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("BASKETBALL");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("FLOORBALL");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("HANDBALL");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("FOOTBALL");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("1%");
                        Otazka2.this.up2.setText("89%");
                        Otazka2.this.up3.setText("9%");
                        Otazka2.this.up4.setText("2%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 45:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("In which units do we measure wattage?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("NEWTONS");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("WATTS");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("JOULES");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("AMPERES");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("4%");
                        Otazka2.this.up2.setText("86%");
                        Otazka2.this.up3.setText("7%");
                        Otazka2.this.up4.setText("3%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 46:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What do we get when we connect 2 opposing vertexes in a square?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("RAY");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("DIAGONAL");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("CIRCLE");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("LINE");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("4%");
                        Otazka2.this.up2.setText("93%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("3%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 47:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Two diagonals in a square...");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("ARE PARALLEL");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("FORM AN ANGLE OF 30°");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("FORM AN ANGLE OF 60°");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("CUT EACH OTHER IN HALF");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("1%");
                        Otazka2.this.up2.setText("7%");
                        Otazka2.this.up3.setText("10%");
                        Otazka2.this.up4.setText("82%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 48:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What of the following is not a US state?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("MONTANA");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("ALABAMA");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("CAPE TOWN");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("UTAH");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("12%");
                        Otazka2.this.up3.setText("72%");
                        Otazka2.this.up4.setText("14%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 49:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which one of these numbers is not a prime number?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("2");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("1");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("23");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("17");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("23%");
                        Otazka2.this.up2.setText("72%");
                        Otazka2.this.up3.setText("3%");
                        Otazka2.this.up4.setText("2%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 50:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What square can we find in Moscow?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("PINK");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("ORANGE");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("BLUE");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("RED");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("1%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("6%");
                        Otazka2.this.up4.setText("91%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 51:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Where can be found the main Audi headquarters?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("GREAT BRITAIN");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("AUSTRALIA");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("AUSTRIA");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("GERMANY");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("0%");
                        Otazka2.this.up2.setText("11%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("89%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 52:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which science is an application of science to criminal and civil laws?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("PHARMACOLOGY SCIENCE");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("MOLECULAR SCIENCE");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("FORENSIC SCIENCE");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("NEUROSCIENCE");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("81%");
                        Otazka2.this.up4.setText("15%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 53:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Over which river was the Tower Bridge built?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("THEMES");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("SHANNON");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("RHINE");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("SEINE");
                this.castka = 1000;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("89%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("8%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 54:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What does the latin word plantae stand for?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("TREES");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("PROTOZOA");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("PLANTS");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("OCTOPUSES");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("1%");
                        Otazka2.this.up2.setText("6%");
                        Otazka2.this.up3.setText("92%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 55:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the base play time of a football match?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("3x20 MINUTES");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("1x120 MINUTES");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("4x30 MINUTES");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("2x45 MINUTES");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("4%");
                        Otazka2.this.up2.setText("3%");
                        Otazka2.this.up3.setText("1%");
                        Otazka2.this.up4.setText("92%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 56:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the national dance of Hungary?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("KOZACHOK");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("CSARDAS");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("GOULASH");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("MAZURKA");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("5%");
                        Otazka2.this.up2.setText("91%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("4%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 57:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the symbol of a chemical element Rubidium?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("R");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("Ru");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("Rb");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("Rd");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("5%");
                        Otazka2.this.up2.setText("14%");
                        Otazka2.this.up3.setText("81%");
                        Otazka2.this.up4.setText("0%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 58:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Where can be penguins naturaly found?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("IN CHINA");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("IN VENEZUELA");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("IN ANTARCTICA");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("IN ARCTICA");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("12%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("82%");
                        Otazka2.this.up4.setText("4%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 59:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the name of Google's internet browser?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("GOOGLE EARTH");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("GOOGLE YOUTUBE");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("GOOGLE EXPLORE");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("GOOGLE CHROME");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("6%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("5%");
                        Otazka2.this.up4.setText("87%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 60:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which one of these is an eating disorder?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("BULIMIA");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("LOAIZA");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("VAROASSIS");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("CELLULOSE");
                this.castka = 1000;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("88%");
                        Otazka2.this.up2.setText("4%");
                        Otazka2.this.up3.setText("7%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 61:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which one of these is not a Roman numeral?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("C");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("D");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("X");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("T");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("11%");
                        Otazka2.this.up2.setText("5%");
                        Otazka2.this.up3.setText("6%");
                        Otazka2.this.up4.setText("78%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 62:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which one of these can we find in an atomic shell?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("PROTONS");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("NEUTRONS");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("SHELLONS");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("ELECTRONS");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("1%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("97%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 63:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which one of these is a pasta?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("FRENCH FRIES");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("SPAGHETTI");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("CTRL + V");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("CARP");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("9%");
                        Otazka2.this.up2.setText("83%");
                        Otazka2.this.up3.setText("5%");
                        Otazka2.this.up4.setText("3%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 64:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Usually, in which part of a map can we find west?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("ON THE TOP");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("ON THE BOTTOM");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("ON THE LEFT");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("ON THE RIGHT");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("3%");
                        Otazka2.this.up2.setText("3%");
                        Otazka2.this.up3.setText("82%");
                        Otazka2.this.up4.setText("12%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 65:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which conifer doesn't keep it's needles during winter?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("SPRUCE");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("FIR");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("LARCH");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("PINE");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("3%");
                        Otazka2.this.up3.setText("94%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 66:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("In which of these categories do we use the word HATTRICK?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("HELMINTHOLOGY");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("ASTRONOMY");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("MATHS");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("SPORTS");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("0%");
                        Otazka2.this.up2.setText("5%");
                        Otazka2.this.up3.setText("7%");
                        Otazka2.this.up4.setText("88%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 67:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is heavier, a pound of feathers, or a pound of steel?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("CAN'T BE SOLVED");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("BOTH WEIGH THE SAME");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("A POUND OF FEATHERS");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("A POUND OF STEEL");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("5%");
                        Otazka2.this.up2.setText("71%");
                        Otazka2.this.up3.setText("1%");
                        Otazka2.this.up4.setText("23%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 68:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What place do I finish at, if I overtook the fifth one?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("THIRD");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("FOURTH");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("FIFTH");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("SIXTH");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("0%");
                        Otazka2.this.up2.setText("36%");
                        Otazka2.this.up3.setText("63%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 69:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Faces of cube are:");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("RECTANGLES");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("SQUARES");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("TRIANGLES");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("RECTANGLES AND SQUARES");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("1%");
                        Otazka2.this.up2.setText("95%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("4%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 70:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("In which city can we find the Brandenburg gate?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("IN BERLIN");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("IN PRAGUE");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("IN LONDON");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("IN PARIS");
                this.castka = 1000;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("89%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("6%");
                        Otazka2.this.up4.setText("3%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 71:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How many days does February have if it is a leap year?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("28");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("29");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("30");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("31");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("80%");
                        Otazka2.this.up3.setText("15%");
                        Otazka2.this.up4.setText("3%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 72:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What do we measure with ammeter?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("VOLTAGE");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("CURRENT");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("WATTAGE");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("WORK");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("28%");
                        Otazka2.this.up2.setText("69%");
                        Otazka2.this.up3.setText("2%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 73:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Few millenniums ago, we could find this realm in between the rivers Euphrates and Tigris");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("MESOPOTAMIA");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("EGYPT");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("OTTOMAN EMPIRE");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("MONGOLIAN EMPIRE");
                this.castka = 1000;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("87%");
                        Otazka2.this.up2.setText("0%");
                        Otazka2.this.up3.setText("12%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 74:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How many stripes are there in an Adidas logo?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("1");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("2");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("3");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("4");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("0%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("97%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 75:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which currency has the abbreviation GBP?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("INDIAN RUPEE");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("BRITISH POUND");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("CROATIAN KUNA");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("CZECH CROWN");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("9%");
                        Otazka2.this.up2.setText("86%");
                        Otazka2.this.up3.setText("3%");
                        Otazka2.this.up4.setText("2%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 76:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who was elected the president of USA on 20. 1. 2017?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("BARACK OBAMA");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("DONALD TRUMP");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("ABRAHAM LINCOLN");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("HILLARY CLINTON");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("97%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 77:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Time during which the Earth completes one rotation around it's axis is?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("DAY");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("YEAR");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("LIGHT YEAR");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("POLAR DAY");
                this.castka = 1000;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("91%");
                        Otazka2.this.up2.setText("9%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("0%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 78:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is a normal body temperature?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("34°C/93°F");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("35,2°C/95°F");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("36,5°C/98°F");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("38,3°C/101°F");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("0%");
                        Otazka2.this.up2.setText("0%");
                        Otazka2.this.up3.setText("99%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 79:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which animal creates packs?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("BEAR");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("FOX");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("SQUIRREL");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("WOLF");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("12%");
                        Otazka2.this.up2.setText("16%");
                        Otazka2.this.up3.setText("3%");
                        Otazka2.this.up4.setText("69%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 80:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who abolished slavery?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("GEORGE WASHINGTON");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("DONALD TRUMP");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("ABRAHAM LINCOLN");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("BARACK OBAMA");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("14%");
                        Otazka2.this.up2.setText("0%");
                        Otazka2.this.up3.setText("86%");
                        Otazka2.this.up4.setText("0%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 81:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which sickness is characterized with a high blood sugar levels?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("JAUNDICE");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("DIABETES");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("AIDS");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("INSOMNIA");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("5%");
                        Otazka2.this.up2.setText("84%");
                        Otazka2.this.up3.setText("7%");
                        Otazka2.this.up4.setText("4%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 82:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Eurotunnel links the city of Folkestone with?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("PARIS");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("DOVER");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("CALAIS");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("BRUSSELS");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("4%");
                        Otazka2.this.up2.setText("22%");
                        Otazka2.this.up3.setText("63%");
                        Otazka2.this.up4.setText("11%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 83:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What was the motto of American revolution? No taxation without...");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("REPRESENTATION");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("FREE NATION");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("TRAIN STATION");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("DONATION");
                this.castka = 1000;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("100%");
                        Otazka2.this.up2.setText("0%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("0%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 84:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What does it mean to feel pumped up?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("TO BE EXCITED");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("TO BE SAD");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("TO BE ANGRY");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("TO FEEL HOMESICK");
                this.castka = 1000;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("71%");
                        Otazka2.this.up2.setText("25%");
                        Otazka2.this.up3.setText("3%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 85:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is goulash?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("PENIS");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("ANIMAL");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("FOOD");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("NICKNAME OF FOOTBALLER XAVI");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("0%");
                        Otazka2.this.up2.setText("1%");
                        Otazka2.this.up3.setText("97%");
                        Otazka2.this.up4.setText("2%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 86:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Leaf of which tree can we find on Canada’s flag?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("MAPLE");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("OAK");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("BEECH");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("BIRCH");
                this.castka = 1000;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("84%");
                        Otazka2.this.up2.setText("7%");
                        Otazka2.this.up3.setText("9%");
                        Otazka2.this.up4.setText("0%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 87:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which of these gemstones is colourless?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("SAPPHIRE");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("AMETHYST");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("CRYSTAL");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("EMERALD");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("0%");
                        Otazka2.this.up2.setText("0%");
                        Otazka2.this.up3.setText("99%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 88:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How many days does January have?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("28");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("29");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("30");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("31");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("0%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("20%");
                        Otazka2.this.up4.setText("78%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 89:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("In equilateral triangle, every angle is:");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("60°");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("75°");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("90°");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("OTHER");
                this.castka = 1000;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("73%");
                        Otazka2.this.up2.setText("6%");
                        Otazka2.this.up3.setText("9%");
                        Otazka2.this.up4.setText("12%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 90:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How do we say thank you in German?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("DANKE SCHÖN");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("BITTE SCHÖN");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("MERCI");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("GRAZIE");
                this.castka = 1000;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("91%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("6%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 91:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the name of one of Japan’s most known dishes?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("SUSHU");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("SUSHI");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("SHASHU");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("SHAUSHI");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("1%");
                        Otazka2.this.up2.setText("98%");
                        Otazka2.this.up3.setText("1%");
                        Otazka2.this.up4.setText("0%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 92:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which one of these is the smallest?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("2/3");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("9/10");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("1/2");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("3/4");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("4%");
                        Otazka2.this.up2.setText("5%");
                        Otazka2.this.up3.setText("89%");
                        Otazka2.this.up4.setText("2%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 93:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which of these cities was destroyed by an atomic bomb?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("TOKYO");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("YOKOHAMA");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("SAPPORO");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("NAGASAKI");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("1%");
                        Otazka2.this.up2.setText("4%");
                        Otazka2.this.up3.setText("6%");
                        Otazka2.this.up4.setText("89%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 94:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which one of these channels does not exist in America?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("ABC");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("FOX");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("TBD");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("NOVA");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("0%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("1%");
                        Otazka2.this.up4.setText("97%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 95:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How many rings are there in the logo of the olympic games?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("1");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("9");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("7");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("5");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("0%");
                        Otazka2.this.up2.setText("15%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("85%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 96:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who is often called as man's best friend?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("MOUSE");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("DOG");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("PARROT");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("RABBIT");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("95%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("3%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 97:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which one of these is dangerous for computers?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("INSOMNIA");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("VIRUS");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("MIGRAINE");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("MUSHROOM");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("0%");
                        Otazka2.this.up2.setText("93%");
                        Otazka2.this.up3.setText("4%");
                        Otazka2.this.up4.setText("3%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 98:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Ph. D. is doctor of what?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("PEARL HARBOUR");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("PAST HISTORY");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("PHARMACY");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("PHILOSOPHY");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("13%");
                        Otazka2.this.up2.setText("18%");
                        Otazka2.this.up3.setText("6%");
                        Otazka2.this.up4.setText("63%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 99:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("According to legend who drinks blood?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("DEMENTOR");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("MICE");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("RABBITS");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("VAMPIRES");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("3%");
                        Otazka2.this.up2.setText("1%");
                        Otazka2.this.up3.setText("1%");
                        Otazka2.this.up4.setText("95%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 100:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("In which garden did Adam and Eve live?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("ODEN");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("ODIN");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("EDEN");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("ADEN");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("3%");
                        Otazka2.this.up2.setText("5%");
                        Otazka2.this.up3.setText("91%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 101:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Kinds of which fruit are called Golden delicious, Gala, Jonagold?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("APPLE");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("MELON");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("TOMATO");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("PEAR");
                this.castka = 1000;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("78%");
                        Otazka2.this.up2.setText("6%");
                        Otazka2.this.up3.setText("8%");
                        Otazka2.this.up4.setText("8%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 102:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which of these organisations is connected with space program?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("UEFA");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("NATO");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("NASA");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("FIFA");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("3%");
                        Otazka2.this.up3.setText("92%");
                        Otazka2.this.up4.setText("3%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 103:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which one of these disasters start with a retreat of a sea?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("TORNADO");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("HURRICANE");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("EARTHQUAKE");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("TSUNAMI");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("4%");
                        Otazka2.this.up3.setText("1%");
                        Otazka2.this.up4.setText("93%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 104:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which part of Pinocchio gets bigger every time he lies?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("FINGERS");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("EARS");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("NOSE");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("LEGS");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("93%");
                        Otazka2.this.up4.setText("3%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 105:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who introduced 3 laws of motion?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("THOMAS EDISON");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("NIKOLA TESLA");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("ISAAC NEWTON");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("BLAIR PASCAL");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("4%");
                        Otazka2.this.up2.setText("8%");
                        Otazka2.this.up3.setText("81%");
                        Otazka2.this.up4.setText("7%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 106:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Organism’s lack of water is?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("DEPRESSION");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("DEHYDRATION");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("METABOLISM");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("RESPIRATION");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("1%");
                        Otazka2.this.up2.setText("94%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("5%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 107:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which one of these words has the same meaning as the word immunity?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("RESISTANCE");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("WEAKNESS");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("BRAVENESS");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("SELF-CONFIDENCE");
                this.castka = 1000;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("90%");
                        Otazka2.this.up2.setText("1%");
                        Otazka2.this.up3.setText("4%");
                        Otazka2.this.up4.setText("5%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 108:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which one is a name of famous American rapper?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("EMENEM");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("EMINEM");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("NEMINEM");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("VEMENEM");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("4%");
                        Otazka2.this.up2.setText("89%");
                        Otazka2.this.up3.setText("5%");
                        Otazka2.this.up4.setText("2%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 109:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who is bringing the presents in the time of christmas?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("VAMPIRE");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("SANTA CLAUS");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("BARACK OBAMA");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("CENTAUR");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("1%");
                        Otazka2.this.up2.setText("72%");
                        Otazka2.this.up3.setText("26%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 110:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which one of these is not a part of feet?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("ANKLEBONE");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("CALCANEUS");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("PATELLA");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("CUBOIDEUM");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("0%");
                        Otazka2.this.up2.setText("0%");
                        Otazka2.this.up3.setText("94%");
                        Otazka2.this.up4.setText("6%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 111:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What does the company Apple name their phones?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("IPHONE");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("MAGICPHONE");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("MYPHONE");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("ULTRAPHONE");
                this.castka = 1000;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("99%");
                        Otazka2.this.up2.setText("0%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 112:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What are The Guardian, Daily Mail or The Times?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("CHARITIES");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("SPORT EVENTS");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("TV CHANNELS");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("NEWSPAPER");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("16%");
                        Otazka2.this.up2.setText("3%");
                        Otazka2.this.up3.setText("3%");
                        Otazka2.this.up4.setText("78%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 113:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Larva of which animal do we call tadpole?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("SNAIL");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("SALAMANDER");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("FROG");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("BUTTERFLY");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("1%");
                        Otazka2.this.up2.setText("1%");
                        Otazka2.this.up3.setText("97%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 114:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which field does batik belong to?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("ARTS");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("MILITARY");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("ECONOMY");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("BIOLOGY");
                this.castka = 1000;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("97%");
                        Otazka2.this.up2.setText("1%");
                        Otazka2.this.up3.setText("1%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 115:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What had Marthin Luther King Jr. in his famous speech?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("MOTORCYCLE");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("AIDS");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("FEVER");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("DREAM");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("1%");
                        Otazka2.this.up2.setText("6%");
                        Otazka2.this.up3.setText("20%");
                        Otazka2.this.up4.setText("73%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 116:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What do we call the avoidance of doing a task?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("PROCRASTINATION");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("ANTISOCIALNESS");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("WILL AUTOREGULATION");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("SYNESTHESIA");
                this.castka = 1000;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("71%");
                        Otazka2.this.up2.setText("2%");
                        Otazka2.this.up3.setText("9%");
                        Otazka2.this.up4.setText("18%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 117:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the name of detective from A. C. Doyle’s books? ");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("SHELDON COOPER");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("DOCTOR WHO");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("OLIVER QUEEN");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("SHERLOCK HOLMES");
                this.castka = 1000;
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(4);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 4);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("3%");
                        Otazka2.this.up3.setText("2%");
                        Otazka2.this.up4.setText("93%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuD());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 118:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What would you do with Skittles?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("WEAR IT");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("STUDY IT");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("EAT IT");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("PLAY IT");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("9%");
                        Otazka2.this.up2.setText("4%");
                        Otazka2.this.up3.setText("80%");
                        Otazka2.this.up4.setText("7%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 119:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("On which day in February do we celebrate St. Valentine?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("12th");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("14th");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("16th");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("18th");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("9%");
                        Otazka2.this.up2.setText("61%");
                        Otazka2.this.up3.setText("14%");
                        Otazka2.this.up4.setText("16%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 120:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which one of these is not a world wonder?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("GREAT PYRAMID OF GIZA");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("TEMPLE OF ARTEMIS AT EPHESUS");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("COLOSEUM AT ROME");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("MAUSOLEUM AT HALICARNASSUS");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("5%");
                        Otazka2.this.up2.setText("16%");
                        Otazka2.this.up3.setText("67%");
                        Otazka2.this.up4.setText("12%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 121:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How many seconds are there in one minute?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("30");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("60");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("80");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("100");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("5%");
                        Otazka2.this.up2.setText("70%");
                        Otazka2.this.up3.setText("16%");
                        Otazka2.this.up4.setText("9%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 122:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How many faces does a normal dice have?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("6");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("4");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("8");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("10");
                this.castka = 1000;
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(1);
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 1);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("70%");
                        Otazka2.this.up2.setText("26%");
                        Otazka2.this.up3.setText("3%");
                        Otazka2.this.up4.setText("1%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                        Otazka2.this.f94u2.setEnabled(false);
                        Otazka2.this.f94u2.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up2.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuA());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 123:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How many letters are there in a standard alphabet?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("16");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("20");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("26");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("36");
                this.castka = 1000;
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(3);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 2, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 3);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("4%");
                        Otazka2.this.up2.setText("14%");
                        Otazka2.this.up3.setText("82%");
                        Otazka2.this.up4.setText("0%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                        Otazka2.this.f96u4.setEnabled(false);
                        Otazka2.this.f96u4.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up4.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuC());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
            case 124:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who wanted the Little Red Riding Hood to visit before she met a wolf?");
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setText("BOYFRIEND");
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setText("GRANDMA");
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setText("PUB");
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setText("FAST FOOD");
                this.castka = 1000;
                this.f94u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.Spravna(2);
                    }
                });
                this.f93u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 1, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f95u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 3, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.f96u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.gameOver2(Otazka2.this.uzivatelOdpovedel, 4, 2);
                        if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            Otazka2.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unl.setEnabled(false);
                        Otazka2.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                        Otazka2.this.up1.setText("2%");
                        Otazka2.this.up2.setText("95%");
                        Otazka2.this.up3.setText("0%");
                        Otazka2.this.up4.setText("3%");
                        Otazka2.this.pomocnapromenna2 = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unp.setEnabled(false);
                        Otazka2.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                        Otazka2.this.f95u3.setEnabled(false);
                        Otazka2.this.f95u3.setVisibility(4);
                        Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                        Otazka2.this.f93u1.setEnabled(false);
                        Otazka2.this.f93u1.setVisibility(4);
                        Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                        Otazka2.this.up3.setVisibility(4);
                        Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                        Otazka2.this.up1.setVisibility(4);
                        Otazka2.this.pomocnapromennap2 = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Otazka2.this.unt.setEnabled(false);
                        Otazka2.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(Otazka2.this);
                        builder.setMessage((CharSequence) Otazka2.this.pritelNaTelefonuB());
                        builder.create().show();
                        Otazka2.this.pomocnapromennat2 = 1;
                    }
                });
                break;
        }
        System.out.println("3!!!!!");
        this.dvere = (Button) findViewById(C1760R.C1762id.dvere);
        this.dvere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Otazka2.this.castka = 1000;
                Otazka2.this.gameOver();
                if (Otazka2.this.castka > Otazka2.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                    Otazka2.this.highscore();
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
        this.castka = 100;
        Intent intent2 = new Intent(this, PopActivity.class);
        intent2.putExtra("Level", 2);
        intent2.putExtra("Castka", this.castka);
        intent2.putExtra("pomocnapromenna", this.pomocnapromenna2);
        intent2.putExtra("pomocnapromennap", this.pomocnapromennap2);
        intent2.putExtra("pomocnapromennat", this.pomocnapromennat2);
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
        this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f93u1.setEnabled(false);
        this.f94u2.setEnabled(false);
        this.f95u3.setEnabled(false);
        this.f96u4.setEnabled(false);
        if (i != 0) {
            int parseColor = Color.parseColor("#ffaa00");
            this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
            this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
            this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
            this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
            if (i == 1) {
                this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f93u1.setTextColor(parseColor);
                this.f93u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up1.setTextColor(parseColor);
            } else if (i == 2) {
                this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f94u2.setTextColor(parseColor);
                this.f94u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up2.setTextColor(parseColor);
            } else if (i == 3) {
                this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f95u3.setTextColor(parseColor);
                this.f95u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up3.setTextColor(parseColor);
            } else if (i == 4) {
                this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f96u4.setTextColor(parseColor);
                this.f96u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up4.setTextColor(parseColor);
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    int parseColor = Color.parseColor("#fcff0202");
                    int parseColor2 = Color.parseColor("#1dc700");
                    Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                    Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                    Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                    Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                    Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                    if (i == 1) {
                        Otazka2.this.f93u1.setTextColor(parseColor);
                        Otazka2.this.f93u1.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka2.this.up1.setTextColor(parseColor);
                    } else if (i == 2) {
                        Otazka2.this.f94u2.setTextColor(parseColor);
                        Otazka2.this.f94u2.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka2.this.up2.setTextColor(parseColor);
                    } else if (i == 3) {
                        Otazka2.this.f95u3.setTextColor(parseColor);
                        Otazka2.this.f95u3.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka2.this.up3.setTextColor(parseColor);
                    } else if (i == 4) {
                        Otazka2.this.f96u4.setTextColor(parseColor);
                        Otazka2.this.f96u4.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka2.this.up4.setTextColor(parseColor);
                    }
                    if (i2 == 1) {
                        Otazka2.this.f93u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka2.this.f93u1.setTextColor(parseColor2);
                        Otazka2.this.up1.setTextColor(parseColor2);
                    } else if (i2 == 2) {
                        Otazka2.this.f94u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka2.this.f94u2.setTextColor(parseColor2);
                        Otazka2.this.up2.setTextColor(parseColor2);
                    } else if (i2 == 3) {
                        Otazka2.this.f95u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka2.this.f95u3.setTextColor(parseColor2);
                        Otazka2.this.up3.setTextColor(parseColor2);
                    } else if (i2 == 4) {
                        Otazka2.this.f96u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka2.this.f96u4.setTextColor(parseColor2);
                        Otazka2.this.up4.setTextColor(parseColor2);
                    }
                    Intent intent = new Intent(Otazka2.this, BackgroundSoundService.class);
                    intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                    Otazka2.this.stopService(intent);
                    Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka2.this).getBoolean("ZVUK", true));
                    MediaPlayer create = MediaPlayer.create(Otazka2.this, C1760R.raw.laugh);
                    if (z && valueOf.booleanValue()) {
                        create.start();
                    }
                }
            }, 1500);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Otazka2.this.alertDialog();
                }
            }, 3500);
            this.castka = 0;
            return;
        }
        alertDialog();
    }

    /* access modifiers changed from: private */
    public void Spravna(final int i) {
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_2", 0);
        int i2 = sharedPreferences.getInt("x", -1) + 1;
        SharedPreferences.Editor edit = getSharedPreferences("zodpovezene_2", 0).edit();
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
        this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f93u1.setEnabled(false);
        this.f94u2.setEnabled(false);
        this.f95u3.setEnabled(false);
        this.f96u4.setEnabled(false);
        if (i == 1) {
            this.f93u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f93u1.setTextColor(parseColor);
            this.f93u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up1.setTextColor(parseColor);
        } else if (i == 2) {
            this.f94u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f94u2.setTextColor(parseColor);
            this.f94u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up2.setTextColor(parseColor);
        } else if (i == 3) {
            this.f95u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f95u3.setTextColor(parseColor);
            this.f95u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up3.setTextColor(parseColor);
        } else {
            this.f96u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f96u4.setTextColor(parseColor);
            this.f96u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up4.setTextColor(parseColor);
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka2.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                Otazka2.this.stopService(intent);
                int parseColor = Color.parseColor("#1dc700");
                Otazka2.this.up1 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up1);
                Otazka2.this.up2 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up2);
                Otazka2.this.up3 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up3);
                Otazka2.this.up4 = (TextView) Otazka2.this.findViewById(C1760R.C1762id.up4);
                if (i == 1) {
                    Otazka2.this.f93u1 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka2.this.f93u1.setTextColor(parseColor);
                    Otazka2.this.f93u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka2.this.up1.setTextColor(parseColor);
                } else if (i == 2) {
                    Otazka2.this.f94u2 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka2.this.f94u2.setTextColor(parseColor);
                    Otazka2.this.f94u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka2.this.up2.setTextColor(parseColor);
                } else if (i == 3) {
                    Otazka2.this.f95u3 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka2.this.f95u3.setTextColor(parseColor);
                    Otazka2.this.f95u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka2.this.up3.setTextColor(parseColor);
                } else {
                    Otazka2.this.f96u4 = (Button) Otazka2.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka2.this.f96u4.setTextColor(parseColor);
                    Otazka2.this.f96u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka2.this.up4.setTextColor(parseColor);
                }
                if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka2.this).getBoolean("ZVUK", true)).booleanValue()) {
                    MediaPlayer.create(Otazka2.this, C1760R.raw.applause2).start();
                }
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka2.this, Otazka3.class);
                Otazka2.this.mCountDownTimer.cancel();
                intent.putExtra("some_key2", Otazka2.this.pomocnapromenna2);
                intent.putExtra("some_keyp2", Otazka2.this.pomocnapromennap2);
                intent.putExtra("some_keyt2", Otazka2.this.pomocnapromennat2);
                Otazka2.this.startActivity(intent);
                CustomIntent.customType(Otazka2.this, "left-to-right");
            }
        }, 2500);
    }

    /* access modifiers changed from: private */
    public void highscore() {
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
            Intent intent = new Intent(this, Otazka3.class);
            this.mCountDownTimer.cancel();
            intent.putExtra("some_key2", this.pomocnapromenna2);
            intent.putExtra("some_keyp2", this.pomocnapromennap2);
            intent.putExtra("some_keyt2", this.pomocnapromennat2);
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
        this.mCountDownTimer.cancel();
    }

    /* access modifiers changed from: private */
    public void alertDialog() {
        this.castka = 0;
        if (this.gameOver && isActivityVisible()) {
            Intent intent = new Intent(this, PopActivity.class);
            intent.putExtra("Level", 2);
            intent.putExtra("Castka", this.castka);
            intent.putExtra("pomocnapromenna", this.pomocnapromenna2);
            intent.putExtra("pomocnapromennap", this.pomocnapromennap2);
            intent.putExtra("pomocnapromennat", this.pomocnapromennat2);
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
