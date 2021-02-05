package com.millionairegame.ondra.dejepisno_zemepisnymilionar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.p003v7.app.AlertDialog;
import android.support.p003v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;
import maes.tech.intentanim.CustomIntent;

public class otazka1 extends AppCompatActivity {
    private static boolean activityVisible = false;
    static final int level = 1;
    Button Zvuk;

    /* renamed from: a */
    final int f189a = 0;
    ArrayList<Integer> arl = new ArrayList<>();

    /* renamed from: b */
    final int f190b = 0;
    Button button;
    Button button2;
    Button button3;
    int castka;
    Button dvere;
    boolean gameOver = false;
    boolean highscore = false;

    /* renamed from: i */
    int f191i = 0;
    int[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108};
    int losovane;
    CountDownTimer mCountDownTimer;
    ProgressBar mProgressBar;
    TextView otazka1;
    TextView otazkau;
    TextView otazkaza;
    int pomocnapromenna;
    int pomocnapromennap;
    int pomocnapromennat;

    /* renamed from: r */
    Random f192r;
    Button start;
    TextView textview2;

    /* renamed from: u1 */
    Button f193u1;

    /* renamed from: u2 */
    Button f194u2;

    /* renamed from: u3 */
    Button f195u3;

    /* renamed from: u4 */
    Button f196u4;
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

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView((int) C1760R.layout.univerzalni);
        this.arl.clear();
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_1", 0);
        int i = sharedPreferences.getInt("x", -1) + 1;
        System.out.println(i + "!!!!");
        SharedPreferences sharedPreferences2 = getSharedPreferences("zodpovezene_1", 0);
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
        this.f192r = new Random();
        this.castka = 0;
        if (this.arl.size() == 0) {
            sharedPreferences.edit().clear().commit();
            sharedPreferences2.edit().clear().commit();
            int i5 = getSharedPreferences("zodpovezene_1", 0).getInt("x", -1) + 1;
            System.out.println(i5 + "!!!!");
            SharedPreferences sharedPreferences3 = getSharedPreferences("zodpovezene_1", 0);
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
        this.losovane = this.f192r.nextInt(this.arl.size());
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
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(otazka1.this);
                Boolean valueOf = Boolean.valueOf(defaultSharedPreferences.getBoolean("ZVUK", true));
                Intent intent = new Intent(otazka1.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                if (valueOf.booleanValue()) {
                    SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                    edit.putBoolean("ZVUK", false);
                    edit.commit();
                    otazka1.this.stopService(intent);
                    otazka1.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukvypnuto);
                    return;
                }
                SharedPreferences.Editor edit2 = defaultSharedPreferences.edit();
                edit2.putBoolean("ZVUK", true);
                edit2.commit();
                otazka1.this.startService(intent);
                otazka1.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukzapnuto);
            }
        });
        this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f193u1.setTextColor(-1);
        this.f193u1.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f194u2.setTextColor(-1);
        this.f194u2.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f195u3.setTextColor(-1);
        this.f195u3.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f196u4.setTextColor(-1);
        this.f196u4.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
        this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
        this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
        this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
        this.up1.setTextColor(-1);
        this.up2.setTextColor(-1);
        this.up3.setTextColor(-1);
        this.up4.setTextColor(-1);
        this.textview2 = (TextView) findViewById(C1760R.C1762id.textView2);
        this.textview2.setTextColor(-1);
        this.otazkaza = (TextView) findViewById(C1760R.C1762id.otazkaza);
        this.otazkaza.setText("100$ Question");
        this.mProgressBar = (ProgressBar) findViewById(C1760R.C1762id.progressBar3);
        this.mProgressBar.setProgress(this.f191i);
        this.mCountDownTimer = new CountDownTimer(40000, 1000) {
            public void onTick(long j) {
                Log.v("Log_tag", "Tick of Progress" + otazka1.this.f191i + j);
                otazka1 otazka1 = otazka1.this;
                otazka1.f191i = otazka1.f191i + 1;
                otazka1.this.mProgressBar.setProgress((otazka1.this.f191i * 100) / 40);
            }

            public void onFinish() {
                otazka1.this.f191i++;
                otazka1.this.mProgressBar.setProgress(100);
                otazka1.this.gameOver = true;
                otazka1.this.uzivatelOdpovedel = false;
                otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 0, 0);
            }
        };
        this.mCountDownTimer.start();
        switch (this.losovane) {
            case 1:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which of these rivers is the longest?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("LENA");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("THAMES");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("AMAZON");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("SEINE");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("2%");
                        otazka1.this.up2.setText("2%");
                        otazka1.this.up3.setText("96%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Archie: Hey, it's definitely Amazon!");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 2:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is not considered as dance?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("TANGO");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("WALTZ");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("LAMBADA");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("KARAOKE");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("8%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("91%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Ashley: That’s clear! Karaoke.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 3:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the highest mountain in the USA?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("MT. MCKINLEY");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("MT. EVEREST");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("BEN NEVIS");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("KILIMANJARO");
                this.castka = 0;
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(1);
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("98%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "John: I am sure it is Mt. McKinley.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 4:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How many wars are called as World wars?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("1");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("2");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("3");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("4");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("4%");
                        otazka1.this.up2.setText("90%");
                        otazka1.this.up3.setText("6%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Boris: I know it is 2.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 5:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What was the name of the man who led Nazi Germany?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("BENITO MUSSOLINI");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("JAROMIR JAGR");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("CRISTIANO RONALDO");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("ADOLF HITLER");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("3%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("97%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Ben: Hi, Adolf Hitler.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 6:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("In which movie did not play Arnold Schwarzenegger?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("TERMINATOR 2");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("FROZEN");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("COMMANDO");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("KINDERGARTEN COP");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("4%");
                        otazka1.this.up2.setText("93%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("3%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Boris: I am sure he did not play in Frozen.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 7:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the capital city of Germany?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("BONN");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("PRAGUE");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("HAMBURG");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("BERLIN");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("1%");
                        otazka1.this.up2.setText("1%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("98%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Franz: It is easy, Berlin.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 8:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Ve kterém městě se nachází Eiffelova věž?");
                this.otazkau.setText("In which city is the Eiffel Tower?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("MARSEILLE");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("LYON");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("MADRID");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("PARIS");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("3%");
                        otazka1.this.up2.setText("5%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("91%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Frederic: I'm pretty sure it's Paris.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 9:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("On the coast of which sea is Venice?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("BALTIC");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("NORTH");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("BRITISH");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("ADRIATIC");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("5%");
                        otazka1.this.up2.setText("3%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("92%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Antonio: Believe me - Adriatic.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 10:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("The name “Julius Caesar” is related to?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("ROME");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("GREECE");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("MEZOPOTAMIA");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("GERMANY");
                this.castka = 0;
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(1);
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("89%");
                        otazka1.this.up2.setText("10%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Adrian: Hi, definitely it’s Rome.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 11:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("When did the French revolution take place?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("1918");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("2013");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("1789");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("1000");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("6%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("94%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Philippe: Hi, I’m 99.9% sure it is C).");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 12:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who founded the city of Saint Petersburg?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("PETER THE GREAT");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("SHERLOCK HOLMES");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("OTTO VON BISMARCK");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("STALIN");
                this.castka = 0;
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(1);
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("94%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("6%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Iryna: I know it, Peter the Great.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 13:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Where is Oslo?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("IN ARGENTINA");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("IN RUSSIA");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("IN NORWAY");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("ON BALCAN");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("3%");
                        otazka1.this.up3.setText("95%");
                        otazka1.this.up4.setText("2%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Olaf: Hi, in Norway, I’m sure.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 14:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Monkeys belong to?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("PROTOZOA");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("BIRDS");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("MAMMALS");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("MUSHROOMS");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("1%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("99%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Martin: Hi, mammals is correct.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 15:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("One of the best-known English writers is?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("VILLON");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("DANTE");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("LAMPARD");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("SHAKESPEARE");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("3%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("96%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Janice: Hi, 100% Shakespeare.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 16:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Ag is a mark for?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("GOLD");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("SILVER");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("MERCURY");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("ZINC");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("7%");
                        otazka1.this.up2.setText("90%");
                        otazka1.this.up3.setText("2%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Ivan: I'm a chemist, correct is silver, rely on it.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 17:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is an approximate value of Pi number?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("3.14");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("2.76");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("2.34");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("0.66");
                this.castka = 0;
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(1);
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("97%");
                        otazka1.this.up2.setText("2%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Tom: Hi, 3,14 is correct.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 18:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which of these animals is the largest?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("ANT");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("BLUE WHALE");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("CHEETAH");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("RHINOCEROS");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("98%");
                        otazka1.this.up3.setText("2%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Sandra: Hi, Blue Whale.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 19:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How do we call an error in the program?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("MOSQUITO");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("ROOT");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("VIRUS");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("BUG");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("3%");
                        otazka1.this.up2.setText("7%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("89%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Steve: Hi, it is bug.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 20:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How many chambers does the human heart have?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("2");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("1");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("4");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("0");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("6%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("94%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Alan: Trust me, there are 4 rooms in the heart.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 21:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("The fourth planet of the Solar System is called?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("EARTH");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("ATHENS");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("PLUTO");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("MARS");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("7%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("93%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Mathew: Hi, I know about the universe, it's Mars.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 22:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("My uncle's son is mine?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("BROTHER");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("GRAND-UNCLE");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("COUSIN");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("NEPHEW");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("93%");
                        otazka1.this.up4.setText("7%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Paula: Moment please...yes, certainly cousin.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 23:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which of the following is not a Greek letter?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("ALPHA");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("ROMEO");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("OMEGA");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("GAMMA");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("97%");
                        otazka1.this.up3.setText("2%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Yannis: Choose Romeo");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 24:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Currency in Japan is?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("JANE");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("FRANC");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("YEN");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("EURO");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("4%");
                        otazka1.this.up2.setText("2%");
                        otazka1.this.up3.setText("94%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Alex: It’s yen, trust me.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 25:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Name of popular singer is?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("LADY GAGA");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("LADY MAGA");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("LADY SAGA");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("LADY TAGA");
                this.castka = 0;
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(1);
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("99%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Boris: Hi, it's definitely Lady Gaga.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 26:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("In which century the Declaration of independence was written?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("9TH CENTURY");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("10TH CENTURY");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("18TH CENTURY");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("20TH CENTURY");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("2%");
                        otazka1.this.up2.setText("4%");
                        otazka1.this.up3.setText("92%");
                        otazka1.this.up4.setText("2%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Boris: Hi, it was definitely in the 18th century.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 27:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("When did the second world war started?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("2000");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("1939");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("1866");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("1776");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("99%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Irene: Hi, 1939 is correct.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 28:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is not a mammal?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("CHIMPANZEE");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("BEE");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("ELEPHANT");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("GIRAFFE");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("95%");
                        otazka1.this.up3.setText("2%");
                        otazka1.this.up4.setText("3%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Sheldon: Hi, bee is not a mammal.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 29:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which of the following companies make smartphones?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("DECATHLON");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("KIA");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("IKEA");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("NOKIA");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("1%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("98%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Matthew: Hi, Nokia make smartphones.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 30:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("When an arm is broken, it is?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("A FRACTURE");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("AN EMBRYO");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("A JOINT");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("A MUSCLE");
                this.castka = 0;
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(1);
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("98%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Zyan: Hi, it is a fracture.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 31:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("The Sun is?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("A GALAXY");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("A PLANET");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("A STAR");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("A GPS SATELLITE");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("1%");
                        otazka1.this.up2.setText("3%");
                        otazka1.this.up3.setText("96%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Harry: Hey, it is C). You can rely on it.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 32:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What colour will be the result of mixing blue and red?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("GREEN");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("YELLOW");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("PURPLE");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("BLACK");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("3%");
                        otazka1.this.up2.setText("2%");
                        otazka1.this.up3.setText("88%");
                        otazka1.this.up4.setText("7%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Jack: It is C) for sure.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 33:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who is Angelina Jolie?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("TENNIS PLAYER");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("BRITISH PRIME MINISTER");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("WELDER");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("ACTRESS");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("2%");
                        otazka1.this.up2.setText("1%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("94%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Jacob: That's clear! She's an actress.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 34:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the name of british anthem?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("GOD SAVE THE QUEEN.");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("WHERE IS MY HOME?");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("HELL YEAH! GREAT BRITAIN!");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("CELEBRATE GOOD TIMES!");
                this.castka = 0;
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(1);
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("99%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Christoffer: I'm sure it is God save the queen.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 35:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What does it mean to pull someone's leg?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("TO WIN A GAME");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("TO KNOCKOUT SOMEBODY");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("TO CUT SOMEONE'S LEG");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("TO MAKE JOKES OF SOMEBODY");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("1%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("98%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Boris: Hi, I know it is to be joking of somebody!");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 36:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which superhero can shoot cobwebs from his hand?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("BATMAN");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("SPIDERMAN");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("SUPERMAN");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("CAPTAIN AMERICA");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("2%");
                        otazka1.this.up2.setText("96%");
                        otazka1.this.up3.setText("2%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Oscar: Hi, Spiderman.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 37:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the name of popular sitcom?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("ALLIES");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("ALIENS");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("FRIENDS");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("REAL ENEMIES");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("99%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Ben: Hi, it is Friends.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 38:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is an antonym to the word correct?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("GOOD");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("WRONG");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("BAD");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("SO GOOD");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("5%");
                        otazka1.this.up2.setText("95%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Sasha: Hi, it must be B).");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 39:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What does it mean to feel like under the weather?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("TO BE IN GREAT FORM");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("TO HAVE LUCK");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("TO BE CONFUSED");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("TO BE SICK");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("3%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("97%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "William: It is D) for sure.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 40:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Where is football usually played?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("ON A PITCH");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("IN THE PUB");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("ON THE ROAD");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("IN THE GREENHOUSE");
                this.castka = 0;
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(1);
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("99%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Patrick: Ah, it is definitely played on a pitch.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 41:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which city is not in Italy?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("MILANO");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("TORINO");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("GENOA");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("MALAGA");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("4%");
                        otazka1.this.up4.setText("96%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Patrick: For sure it is D).");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 42:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How do we call it when we avoid or ignore something unpleasent?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("NARRATIVE");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("IRONY");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("BYPASS");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("KARMA");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("2%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("98%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Thomas: Definitely it is C).");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 43:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which city is the most far away from London?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("LIVERPOOL");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("MANCHESTER");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("GLASGOW");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("BRIGHTON");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("1%");
                        otazka1.this.up2.setText("5%");
                        otazka1.this.up3.setText("92%");
                        otazka1.this.up4.setText("2%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Dan: It must be Glasgow.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 44:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which number is LXIX?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("666");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("69");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("71");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("571");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("93%");
                        otazka1.this.up3.setText("6%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Danny: Hi, it is B)");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 45:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Fish and chips is typical food in?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("FRANCE");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("RUSSIA");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("UKRAINE");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("GREAT BRITAIN");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("1%");
                        otazka1.this.up2.setText("1%");
                        otazka1.this.up3.setText("3%");
                        otazka1.this.up4.setText("95%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Paula: Hi, it must be D).");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 46:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is considered as a repellent against vampires?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("APPLES");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("GARLIC");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("TANGERINE");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("KOHLRABI");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("1%");
                        otazka1.this.up2.setText("96%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("2%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "John: Hi, it is B).");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 47:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which of these is an e-mail client from Google?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("OUTLOOK");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("XMAIL");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("MASTERMAIL");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("GMAIL");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("1%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("99%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Patrick: Hi, it is Gmail for sure.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 48:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How do we say I love you in German?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("ICH FICKE DICH");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("ICH ESSE DICH");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("ICH LIEBE DICH");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("ICH MACHE DICH");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("1%");
                        otazka1.this.up3.setText("98%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Tom: Hi, definitely ich liebe dich.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 49:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What of the following can we find in a car?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("MICRO-WAVE");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("COOLER");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("OVEN");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("COOKER");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("99%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Martin: Hi, it must be cooler.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 50:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How many colours are there in the flag of Canada?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("ONLY ONE");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("THREE");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("TWO");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("FOUR");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("1%");
                        otazka1.this.up3.setText("98%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Martin: Hi, it is definitely from two colours.");
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 51:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which company doesn't produce computers?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("ACER");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("HP");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("LENOVO");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("FIAT");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("1%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("99%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Marry: " + otazka1.this.pritelNaTelefonuD());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 52:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is a symbol of Helloween?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("CARROT");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("PARROT");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("PEPPER");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("PUMPKIN");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("1%");
                        otazka1.this.up3.setText("4%");
                        otazka1.this.up4.setText("95%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "John: " + otazka1.this.pritelNaTelefonuD());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 53:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("In which sport has Tiger Woods become a legend?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("GOLF");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("FOOTBALL");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("BASKETBALL");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("BASEBALL");
                this.castka = 0;
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(1);
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("94%");
                        otazka1.this.up2.setText("2%");
                        otazka1.this.up3.setText("3%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Sarah: " + otazka1.this.pritelNaTelefonuA());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 54:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What of the following is not considered as relligion?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("JUDAISM");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("HINDUISM");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("SHAOISM");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("OPTIMISM");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("2%");
                        otazka1.this.up4.setText("98%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Sarah: " + otazka1.this.pritelNaTelefonuD());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 55:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How often is a leap-year?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("EVERY 2 YEARS");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("EVERY 3 YEARS");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("EVERY 4 YEARS");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("EVERY 5 YEARS");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("1%");
                        otazka1.this.up2.setText("5%");
                        otazka1.this.up3.setText("88%");
                        otazka1.this.up4.setText("6%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Martin: " + otazka1.this.pritelNaTelefonuC());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 56:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which of these can't have volume?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("CUBE");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("RECTANGLE");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("BLOCK");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("CONE");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("1%");
                        otazka1.this.up2.setText("93%");
                        otazka1.this.up3.setText("2%");
                        otazka1.this.up4.setText("4%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Michael: " + otazka1.this.pritelNaTelefonuB());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 57:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the name of our planet?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("MARS");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("PLUTO");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("EUROPE");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("EARTH");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("100%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Vanessa: " + otazka1.this.pritelNaTelefonuD());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 58:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What of the following is not a weight unit?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("GRAM");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("TUNE");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("KILOGRAM");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("YARD");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("1%");
                        otazka1.this.up2.setText("4%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("95%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Christian: " + otazka1.this.pritelNaTelefonuD());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 59:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How many right angles are there in a rectangle?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("1");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("2");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("3");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("4");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("12%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("87%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Philipp: " + otazka1.this.pritelNaTelefonuD());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 60:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How is called a street which can be accessed only from one side?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("BLIND");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("RUDE");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("BEAUTIFUL");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("DEAD-END");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("100%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Tobias: " + otazka1.this.pritelNaTelefonuD());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 61:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which of the following animals is the highest?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("GIRAFFE");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("ZEBRA");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("ANTELOPE");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("ELEPHANT");
                this.castka = 0;
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(1);
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("99%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Chris: " + otazka1.this.pritelNaTelefonuA());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 62:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("From where is the rain falling?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("STARS");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("COMETS");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("CLOUDS");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("ASTEROIDS");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("100%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Ian: " + otazka1.this.pritelNaTelefonuC());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 63:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which object caused the crash of Titanic?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("BLUE WHALE");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("GLACIER");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("OIL PLATFORM");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("SUBMARINE");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("99%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Hannah: " + otazka1.this.pritelNaTelefonuB());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 64:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the result of 2 + 3?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("3");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("4");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("5");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("6");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("1%");
                        otazka1.this.up3.setText("98%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Marry: " + otazka1.this.pritelNaTelefonuC());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 65:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the name of popular TV series?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("GAME OF LANDS");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("GAME OF THRONES");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("GAME OF THE DEAD");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("GAME OF GHOSTS");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("99%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Patrick: " + otazka1.this.pritelNaTelefonuB());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 66:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("The first month of the year is?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("JANUARY");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("FEBRUARY");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("MAY");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("MONDAY");
                this.castka = 0;
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(1);
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("99%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Taylor: " + otazka1.this.pritelNaTelefonuA());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 67:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is usually given onto a birthday cake?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("MICE");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("CIGARETTES");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("PENCILS");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("CANDLES");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("1%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("99%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Elizabeth: " + otazka1.this.pritelNaTelefonuD());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 68:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which device is used for heating a room?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("DRYER");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("COOKER");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("RADIATOR");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("FREEZER");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("100%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Lucas: " + otazka1.this.pritelNaTelefonuC());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 69:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("In which furniture do we store our clothes?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("CHAIR");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("CLOSET");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("BED");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("TABLE");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("100%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Paul: " + otazka1.this.pritelNaTelefonuB());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 70:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which of these cities is the most populated?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("LIVERPOOL");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("BERLIN");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("VANCOUVER");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("LONDON");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("4%");
                        otazka1.this.up4.setText("96%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "David: " + otazka1.this.pritelNaTelefonuD());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 71:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the result of 3x2 - 4?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("5");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("1");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("2");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("-6");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("1%");
                        otazka1.this.up3.setText("87%");
                        otazka1.this.up4.setText("12%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "John: " + otazka1.this.pritelNaTelefonuC());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 72:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which colour is not in the US flag?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("BLACK");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("RED");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("WHITE");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("BLUE");
                this.castka = 0;
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(1);
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("79%");
                        otazka1.this.up2.setText("3%");
                        otazka1.this.up3.setText("8%");
                        otazka1.this.up4.setText("10%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Ian: " + otazka1.this.pritelNaTelefonuA());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 73:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Apples fall from?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("BUSH");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("FLOWER");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("TREE");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("IT GROWS FROM A GROUND");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("100%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Danielle: " + otazka1.this.pritelNaTelefonuC());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 74:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is used to clean the text written by a pencil?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("SULFURIC ACID");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("RUBBER");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("FLAMETHROWER");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("WATER");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("100%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Lucas: " + otazka1.this.pritelNaTelefonuB());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 75:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How do we call football played on a hard court?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("HARDFOOT");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("BALLHARD");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("FUTSAL");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("FUTHARD");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("4%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("96%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Michael: " + otazka1.this.pritelNaTelefonuC());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 76:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("In which sport are not used gloves?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("HOCKEY");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("BASEBALL");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("GOLF");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("CHESS");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("1%");
                        otazka1.this.up3.setText("5%");
                        otazka1.this.up4.setText("94%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Marry: " + otazka1.this.pritelNaTelefonuD());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 77:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which pedal is not in normal car?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("BRAKE");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("CLUTCH");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("COSMIC DRIVE");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("GAS");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("100%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Danielle: " + otazka1.this.pritelNaTelefonuC());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 78:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the name of traditional chocolate producer?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("HILKA");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("MILKA");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("VILKA");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("NILKA");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("97%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("2%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "George: " + otazka1.this.pritelNaTelefonuB());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 79:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which shape has mexican delicacy nachos?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("SQUARE");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("TRIANGLE");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("RHOMBUS");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("OVAL");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("2%");
                        otazka1.this.up2.setText("95%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("3%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Annie: " + otazka1.this.pritelNaTelefonuB());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 80:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which of the following is an island state?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("MEXICO");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("MADAGASCAR");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("KYRGYZSTAN");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("BOTSWANA");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("2%");
                        otazka1.this.up2.setText("89%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("8%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Lucy: " + otazka1.this.pritelNaTelefonuB());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 81:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who was an opponent of Donald Trump in presidential elections in 2016?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("HILLARY CLINTON");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("SELENA GOMEZ");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("BRAD PITT");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("GEORGE WASHINGTON");
                this.castka = 0;
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(1);
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("95%");
                        otazka1.this.up2.setText("2%");
                        otazka1.this.up3.setText("2%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Zyan: " + otazka1.this.pritelNaTelefonuA());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 82:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("On neck of which animal can we find a mane?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("LION");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("LIZZARD");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("CROCODILE");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("EARTHWORM");
                this.castka = 0;
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(1);
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("97%");
                        otazka1.this.up2.setText("1%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Andrew: " + otazka1.this.pritelNaTelefonuA());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 83:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How do we call a place where do the planes land?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("AIR DOCK");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("AIRPORT");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("BENCH");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("SHEET");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("100%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Patrick: " + otazka1.this.pritelNaTelefonuB());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 84:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("To which social site is connected messenger?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("FACEBOOK");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("TWITTER");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("YOUTUBE");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("INSTAGRAM");
                this.castka = 0;
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(1);
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("85%");
                        otazka1.this.up2.setText("6%");
                        otazka1.this.up3.setText("2%");
                        otazka1.this.up4.setText("7%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Dan: " + otazka1.this.pritelNaTelefonuA());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 85:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which colour do the lines on the football pitch have?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("YELLOW");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("GREEN");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("WHITE");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("BROWN");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("100%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Mathias: " + otazka1.this.pritelNaTelefonuC());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 86:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which animals are kept in the aquarium?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("DOGS");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("CATS");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("FISH");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("HORSES");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("100%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Martin: " + otazka1.this.pritelNaTelefonuC());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 87:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which colour on the traffic lights orders you to stop a vehicle?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("YELLOW");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("ORANGE");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("GREEN");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("RED");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("100%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Matt: " + otazka1.this.pritelNaTelefonuD());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 88:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("The one who studies biology is?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("BIOGRAM");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("BIOGRAPH");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("BIOLOGIST");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("BIOS");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("99%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Marry: " + otazka1.this.pritelNaTelefonuC());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 89:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which of the following is an internet search engine?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("GOOGLE");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("FACEBOOK");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("YOUTUBE");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("TWITTER");
                this.castka = 0;
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(1);
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("99%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Simon: " + otazka1.this.pritelNaTelefonuA());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 90:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Witches are said to fly using a?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("HOOVER");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("CHAIR");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("HOCKEY STICK");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("BROOM");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("100%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Marc: " + otazka1.this.pritelNaTelefonuD());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 91:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who wore eye-patches?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("PIRATES");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("LEGIONRIES");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("KIGNS");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("GLADIATORS");
                this.castka = 0;
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(1);
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("98%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("2%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Franc: " + otazka1.this.pritelNaTelefonuA());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 92:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which number is the number of the beast?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("112");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("68");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("1234");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("666");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("1%");
                        otazka1.this.up2.setText("3%");
                        otazka1.this.up3.setText("4%");
                        otazka1.this.up4.setText("92%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Andrew: " + otazka1.this.pritelNaTelefonuD());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 93:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Which colour is Ruby?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("YELLOW");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("BLUE");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("GREEN");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("RED");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("15%");
                        otazka1.this.up2.setText("0%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("84%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Liam: " + otazka1.this.pritelNaTelefonuD());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 94:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who thinks only of himself?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("PESIMIST");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("EGOIST");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("OPTIMIST");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("REALIST");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("1%");
                        otazka1.this.up2.setText("97%");
                        otazka1.this.up3.setText("2%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Claire: " + otazka1.this.pritelNaTelefonuB());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 95:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is opposite to introvert?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("EXTROVERT");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("ENDVERT");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("EXVERT");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("BYVERT");
                this.castka = 0;
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(1);
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 1);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("95%");
                        otazka1.this.up2.setText("2%");
                        otazka1.this.up3.setText("3%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Harry: " + otazka1.this.pritelNaTelefonuA());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 96:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("A feet is a unit of what?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("WEIGHT");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("LENGTH");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("SPEED");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("VOLUME");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("8%");
                        otazka1.this.up2.setText("87%");
                        otazka1.this.up3.setText("4%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Ronald: " + otazka1.this.pritelNaTelefonuB());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 97:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How do we call an ability to count, write and read?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("LITERATURE");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("LITERACY");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("LIGHTER");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("LOVE");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("1%");
                        otazka1.this.up2.setText("97%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Michelle: " + otazka1.this.pritelNaTelefonuB());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 98:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the name of famous english author?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("STEVEN GERRARD");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("J. R. R. TOLKIEN");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("ALEXANDER PUŠKIN");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("LEONARDO DA VINCI");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("1%");
                        otazka1.this.up2.setText("90%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("8%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Michelle: " + otazka1.this.pritelNaTelefonuB());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 99:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What does B4N mean?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("BEAT FOR NOBODY");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("BYE FOR NOW");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("BE FOREIGN");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("BEFORE NIGHT");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("1%");
                        otazka1.this.up2.setText("90%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("8%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Michelle: " + otazka1.this.pritelNaTelefonuB());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 100:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How do we call a science about transportation of goods, information and persons?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("ARBORISTIC");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("LOGISTICS");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("VEXIMOLOGY");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("CRYOGENICS");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("1%");
                        otazka1.this.up2.setText("96%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("2%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Michelle: " + otazka1.this.pritelNaTelefonuB());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 101:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is the capital city of Russia?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("CRIMEA");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("MOSCOW");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("ST. PETERSBURG");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("VLADIVOSTOK");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("96%");
                        otazka1.this.up3.setText("3%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Michelle: " + otazka1.this.pritelNaTelefonuB());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 102:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What does it mean to go back to the drawing board?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("TO SLOW DOWN");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("TO START OVER");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("TO DO A GREAT JOB");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("TO HAVE NO IDEA");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("96%");
                        otazka1.this.up3.setText("3%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Michelle: " + otazka1.this.pritelNaTelefonuB());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 103:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What does DIY stand for?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("DRAW IT FOR YOU");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("DO IT YOURSELF");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("DIVISION Y");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("DUST IS YELL");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("96%");
                        otazka1.this.up3.setText("4%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Michelle: " + otazka1.this.pritelNaTelefonuB());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 104:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("What is XBOX 360?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("CLOTHES DRYER");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("PLAYING CONSOLE");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("TENNIS RACKET");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("MUSIC BAND");
                this.castka = 0;
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(2);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 2);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("3%");
                        otazka1.this.up2.setText("95%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("1%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                        otazka1.this.f196u4.setEnabled(false);
                        otazka1.this.f196u4.setVisibility(4);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up4.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Michelle: " + otazka1.this.pritelNaTelefonuB());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 105:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Who has never been a US president?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("GEORGE WASHINGTON");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("BARACK OBAMA");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("WILLIAM MCKINLEY");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("SYLVESTER STALLONE");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("1%");
                        otazka1.this.up3.setText("0%");
                        otazka1.this.up4.setText("99%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                        otazka1.this.f195u3.setEnabled(false);
                        otazka1.this.f195u3.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up3.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Michelle: " + otazka1.this.pritelNaTelefonuD());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 106:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("Ariana Grande is a famous?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("CHESS PLAYER");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("PLAYWRITER");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("SKI JUMPER");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("SINGER");
                this.castka = 0;
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(4);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 3, 4);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("9%");
                        otazka1.this.up2.setText("2%");
                        otazka1.this.up3.setText("1%");
                        otazka1.this.up4.setText("88%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Michelle: " + otazka1.this.pritelNaTelefonuD());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 107:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("How many cents are there in one dollar?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("10");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("1000");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("100");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("50");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("1%");
                        otazka1.this.up3.setText("99%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Martin: " + otazka1.this.pritelNaTelefonuC());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
            case 108:
                this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
                this.otazkau.setText("A hamster is a?");
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setText("BIRD");
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setText("PLANT");
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setText("RODENT");
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setText("MOLLUSC");
                this.castka = 0;
                this.f195u3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.Spravna(3);
                    }
                });
                this.f193u1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 1, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f194u2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 2, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.f196u4.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.gameOver2(otazka1.this.uzivatelOdpovedel, 4, 3);
                        if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                            otazka1.this.highscore();
                        }
                    }
                });
                this.unl = (Button) findViewById(C1760R.C1762id.unl);
                this.unl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unl.setEnabled(false);
                        otazka1.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                        otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                        otazka1.this.up1.setText("0%");
                        otazka1.this.up2.setText("1%");
                        otazka1.this.up3.setText("99%");
                        otazka1.this.up4.setText("0%");
                        otazka1.this.pomocnapromenna = 1;
                    }
                });
                this.unp = (Button) findViewById(C1760R.C1762id.unp);
                this.unp.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unp.setEnabled(false);
                        otazka1.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                        otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                        otazka1.this.f193u1.setEnabled(false);
                        otazka1.this.f193u1.setVisibility(4);
                        otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                        otazka1.this.f194u2.setEnabled(false);
                        otazka1.this.f194u2.setVisibility(4);
                        otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                        otazka1.this.up1.setVisibility(4);
                        otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                        otazka1.this.up2.setVisibility(4);
                        otazka1.this.pomocnapromennap = 1;
                    }
                });
                this.unt = (Button) findViewById(C1760R.C1762id.unt);
                this.unt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        otazka1.this.unt.setEnabled(false);
                        otazka1.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                        AlertDialog.Builder builder = new AlertDialog.Builder(otazka1.this);
                        builder.setMessage((CharSequence) "Marry: " + otazka1.this.pritelNaTelefonuC());
                        builder.create().show();
                        otazka1.this.pomocnapromennat = 1;
                    }
                });
                break;
        }
        this.dvere = (Button) findViewById(C1760R.C1762id.dvere);
        this.dvere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                otazka1.this.gameOver();
                if (otazka1.this.castka > otazka1.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                    otazka1.this.highscore();
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
        this.castka = 0;
        Intent intent2 = new Intent(this, PopActivity.class);
        intent2.putExtra("Level", 1);
        intent2.putExtra("Castka", this.castka);
        intent2.putExtra("pomocnapromenna", this.pomocnapromenna);
        intent2.putExtra("pomocnapromennap", this.pomocnapromennap);
        intent2.putExtra("pomocnapromennat", this.pomocnapromennat);
        startActivity(intent2);
        this.mCountDownTimer.cancel();
    }

    /* access modifiers changed from: private */
    public void gameOver2(final boolean z, final int i, final int i2) {
        this.gameOver = true;
        this.mCountDownTimer.cancel();
        this.castka = 0;
        this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f193u1.setEnabled(false);
        this.f194u2.setEnabled(false);
        this.f195u3.setEnabled(false);
        this.f196u4.setEnabled(false);
        if (i != 0) {
            int parseColor = Color.parseColor("#ffaa00");
            this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
            this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
            this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
            this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
            if (i == 1) {
                this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f193u1.setTextColor(parseColor);
                this.f193u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up1.setTextColor(parseColor);
            } else if (i == 2) {
                this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f194u2.setTextColor(parseColor);
                this.f194u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up2.setTextColor(parseColor);
            } else if (i == 3) {
                this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f195u3.setTextColor(parseColor);
                this.f195u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up3.setTextColor(parseColor);
            } else if (i == 4) {
                this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f196u4.setTextColor(parseColor);
                this.f196u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up4.setTextColor(parseColor);
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    int parseColor = Color.parseColor("#fcff0202");
                    int parseColor2 = Color.parseColor("#1dc700");
                    otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                    otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                    otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                    otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                    otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                    otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                    otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                    otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                    if (i == 1) {
                        otazka1.this.f193u1.setTextColor(parseColor);
                        otazka1.this.f193u1.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        otazka1.this.up1.setTextColor(parseColor);
                    } else if (i == 2) {
                        otazka1.this.f194u2.setTextColor(parseColor);
                        otazka1.this.f194u2.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        otazka1.this.up2.setTextColor(parseColor);
                    } else if (i == 3) {
                        otazka1.this.f195u3.setTextColor(parseColor);
                        otazka1.this.f195u3.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        otazka1.this.up3.setTextColor(parseColor);
                    } else if (i == 4) {
                        otazka1.this.f196u4.setTextColor(parseColor);
                        otazka1.this.f196u4.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        otazka1.this.up4.setTextColor(parseColor);
                    }
                    if (i2 == 1) {
                        otazka1.this.f193u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        otazka1.this.f193u1.setTextColor(parseColor2);
                        otazka1.this.up1.setTextColor(parseColor2);
                    } else if (i2 == 2) {
                        otazka1.this.f194u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        otazka1.this.f194u2.setTextColor(parseColor2);
                        otazka1.this.up2.setTextColor(parseColor2);
                    } else if (i2 == 3) {
                        otazka1.this.f195u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        otazka1.this.f195u3.setTextColor(parseColor2);
                        otazka1.this.up3.setTextColor(parseColor2);
                    } else if (i2 == 4) {
                        otazka1.this.f196u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        otazka1.this.f196u4.setTextColor(parseColor2);
                        otazka1.this.up4.setTextColor(parseColor2);
                    }
                    Intent intent = new Intent(otazka1.this, BackgroundSoundService.class);
                    intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                    otazka1.this.stopService(intent);
                    Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(otazka1.this).getBoolean("ZVUK", true));
                    MediaPlayer create = MediaPlayer.create(otazka1.this, C1760R.raw.laugh);
                    if (z && valueOf.booleanValue()) {
                        create.start();
                    }
                }
            }, 1500);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    otazka1.this.alertDialog();
                }
            }, 3500);
            return;
        }
        alertDialog();
    }

    /* access modifiers changed from: private */
    public void Spravna(final int i) {
        this.mCountDownTimer.cancel();
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_1", 0);
        int i2 = sharedPreferences.getInt("x", -1) + 1;
        SharedPreferences.Editor edit = getSharedPreferences("zodpovezene_1", 0).edit();
        edit.putInt("index_" + i2, this.losovane);
        edit.commit();
        SharedPreferences.Editor edit2 = sharedPreferences.edit();
        edit2.putInt("x", i2);
        edit2.commit();
        int parseColor = Color.parseColor("#ffaa00");
        this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
        this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
        this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
        this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
        this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f193u1.setEnabled(false);
        this.f194u2.setEnabled(false);
        this.f195u3.setEnabled(false);
        this.f196u4.setEnabled(false);
        if (i == 1) {
            this.f193u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f193u1.setTextColor(parseColor);
            this.f193u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up1.setTextColor(parseColor);
        } else if (i == 2) {
            this.f194u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f194u2.setTextColor(parseColor);
            this.f194u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up2.setTextColor(parseColor);
        } else if (i == 3) {
            this.f195u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f195u3.setTextColor(parseColor);
            this.f195u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up3.setTextColor(parseColor);
        } else {
            this.f196u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f196u4.setTextColor(parseColor);
            this.f196u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up4.setTextColor(parseColor);
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(otazka1.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                otazka1.this.stopService(intent);
                int parseColor = Color.parseColor("#1dc700");
                otazka1.this.up1 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up1);
                otazka1.this.up2 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up2);
                otazka1.this.up3 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up3);
                otazka1.this.up4 = (TextView) otazka1.this.findViewById(C1760R.C1762id.up4);
                if (i == 1) {
                    otazka1.this.f193u1 = (Button) otazka1.this.findViewById(C1760R.C1762id.f175u1);
                    otazka1.this.f193u1.setTextColor(parseColor);
                    otazka1.this.f193u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    otazka1.this.up1.setTextColor(parseColor);
                } else if (i == 2) {
                    otazka1.this.f194u2 = (Button) otazka1.this.findViewById(C1760R.C1762id.f176u2);
                    otazka1.this.f194u2.setTextColor(parseColor);
                    otazka1.this.f194u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    otazka1.this.up2.setTextColor(parseColor);
                } else if (i == 3) {
                    otazka1.this.f195u3 = (Button) otazka1.this.findViewById(C1760R.C1762id.f177u3);
                    otazka1.this.f195u3.setTextColor(parseColor);
                    otazka1.this.f195u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    otazka1.this.up3.setTextColor(parseColor);
                } else {
                    otazka1.this.f196u4 = (Button) otazka1.this.findViewById(C1760R.C1762id.f178u4);
                    otazka1.this.f196u4.setTextColor(parseColor);
                    otazka1.this.f196u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    otazka1.this.up4.setTextColor(parseColor);
                }
                if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(otazka1.this).getBoolean("ZVUK", true)).booleanValue()) {
                    MediaPlayer.create(otazka1.this, C1760R.raw.applause2).start();
                }
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(otazka1.this, Otazka2.class);
                intent.putExtra("some_key", otazka1.this.pomocnapromenna);
                intent.putExtra("some_keyp", otazka1.this.pomocnapromennap);
                intent.putExtra("some_keyt", otazka1.this.pomocnapromennat);
                otazka1.this.startActivity(intent);
                CustomIntent.customType(otazka1.this, "left-to-right");
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

    /* access modifiers changed from: private */
    public void alertDialog() {
        this.castka = 0;
        if (this.gameOver && isActivityVisible()) {
            Intent intent = new Intent(this, PopActivity.class);
            intent.putExtra("Level", 1);
            intent.putExtra("Castka", this.castka);
            intent.putExtra("pomocnapromenna", this.pomocnapromenna);
            intent.putExtra("pomocnapromennap", this.pomocnapromennap);
            intent.putExtra("pomocnapromennat", this.pomocnapromennat);
            startActivity(intent);
        }
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
