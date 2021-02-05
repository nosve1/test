package com.millionairegame.ondra.dejepisno_zemepisnymilionar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.graphics.drawable.PathInterpolatorCompat;
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

public class Otazka4 extends AppCompatActivity implements RewardedVideoAdListener {
    private static boolean activityVisible;
    Button Zvuk;

    /* renamed from: a */
    final int f109a = 0;
    ArrayList<Integer> arl = new ArrayList<>();

    /* renamed from: b */
    final int f110b = 0;
    int castka;
    Button dvere;
    RadioGroup fuhrer1;
    boolean gameOver = false;

    /* renamed from: i */
    int f111i = 0;
    int[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116};
    TextView label;
    int level = 4;
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
    int pomocnapromenna4;
    int pomocnapromennap4;
    int pomocnapromennat4;

    /* renamed from: r */
    Random f112r;
    RadioGroup radioGroupreky;
    TextView reky1chyba;
    MediaPlayer spatna;
    TextView textview4;
    TextView textview5;

    /* renamed from: u1 */
    Button f113u1;

    /* renamed from: u2 */
    Button f114u2;

    /* renamed from: u3 */
    Button f115u3;

    /* renamed from: u4 */
    Button f116u4;
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
        MobileAds.initialize(this, "ca-app-pub-6056957033271627~3965068114");
        this.mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        this.mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();
        this.mInterstitialAd = new InterstitialAd(this);
        this.mInterstitialAd.setAdUnitId("ca-app-pub-6056957033271627/5548712134");
        this.mInterstitialAd.loadAd(new AdRequest.Builder().build());
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_4", 0);
        int i = sharedPreferences.getInt("x", -1) + 1;
        System.out.println(i + "!!!!");
        SharedPreferences sharedPreferences2 = getSharedPreferences("zodpovezene_4", 0);
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
        this.f112r = new Random();
        this.castka = 0;
        if (this.arl.size() == 0) {
            sharedPreferences.edit().clear().commit();
            sharedPreferences2.edit().clear().commit();
            int i5 = getSharedPreferences("zodpovezene_4", 0).getInt("x", -1) + 1;
            System.out.println(i5 + "!!!!");
            SharedPreferences sharedPreferences3 = getSharedPreferences("zodpovezene_4", 0);
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
        this.losovane = this.f112r.nextInt(this.arl.size());
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
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(Otazka4.this);
                Boolean valueOf = Boolean.valueOf(defaultSharedPreferences.getBoolean("ZVUK", true));
                Intent intent = new Intent(Otazka4.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                if (valueOf.booleanValue()) {
                    SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                    edit.putBoolean("ZVUK", false);
                    edit.commit();
                    Otazka4.this.stopService(intent);
                    Otazka4.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukvypnuto);
                    return;
                }
                SharedPreferences.Editor edit2 = defaultSharedPreferences.edit();
                edit2.putBoolean("ZVUK", true);
                edit2.commit();
                Otazka4.this.startService(intent);
                Otazka4.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukzapnuto);
            }
        });
        this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f113u1.setTextColor(-1);
        this.f113u1.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f114u2.setTextColor(-1);
        this.f114u2.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f115u3.setTextColor(-1);
        this.f115u3.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f116u4.setTextColor(-1);
        this.f116u4.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
        this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
        this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
        this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
        this.up1.setTextColor(-1);
        this.up2.setTextColor(-1);
        this.up3.setTextColor(-1);
        this.up4.setTextColor(-1);
        this.textview4 = (TextView) findViewById(C1760R.C1762id.textView4);
        this.textview4.setTextColor(InputDeviceCompat.SOURCE_ANY);
        this.textview5 = (TextView) findViewById(C1760R.C1762id.textView5);
        this.textview5.setTextColor(-1);
        this.otazkaza = (TextView) findViewById(C1760R.C1762id.otazkaza);
        this.otazkaza.setText("500$ Question");
        this.mProgressBar = (ProgressBar) findViewById(C1760R.C1762id.progressBar3);
        this.mProgressBar.setProgress(this.f111i);
        this.mCountDownTimer = new CountDownTimer(40000, 1000) {
            public void onTick(long j) {
                Log.v("Log_tag", "Tick of Progress" + Otazka4.this.f111i + j);
                Otazka4 otazka4 = Otazka4.this;
                otazka4.f111i = otazka4.f111i + 1;
                Otazka4.this.mProgressBar.setProgress((Otazka4.this.f111i * 100) / 40);
            }

            public void onFinish() {
                Otazka4.this.f111i++;
                Otazka4.this.mProgressBar.setProgress(100);
                Otazka4.this.uzivatelOdpovedel = false;
                Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 0, 0);
            }
        };
        this.mCountDownTimer.start();
        int i9 = getIntent().getExtras().getInt("some_key3");
        int i10 = getIntent().getExtras().getInt("some_keyp3");
        if (getIntent().getExtras().getInt("some_keyt3") == 1) {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(false);
            this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
            this.pomocnapromennat4 = 1;
        } else {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(true);
        }
        if (i10 == 1) {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(false);
            this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
            this.pomocnapromennap4 = 1;
        } else {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(true);
        }
        if (i9 == 1) {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(false);
            this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
            this.pomocnapromenna4 = 1;
        } else {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(true);
        }
        this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f113u1.setEnabled(true);
        this.f114u2.setEnabled(true);
        this.f115u3.setEnabled(true);
        this.f116u4.setEnabled(true);
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
            this.otazkau.setText("The capital of Slovenia is?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("SARAJEVO");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("BRATISLAVA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("SOFIA");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("LJUBLJANA");
            this.castka = 0;
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("7%");
                    Otazka4.this.up2.setText("6%");
                    Otazka4.this.up3.setText("5%");
                    Otazka4.this.up4.setText("82%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Andrew: D) is correct - Ljubljana.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 2) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which country were the 2018 winter olympics held?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("CANADA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("CHINA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("SOUTH KOREA");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("JAPAN");
            this.castka = 0;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("8%");
                    Otazka4.this.up2.setText("6%");
                    Otazka4.this.up3.setText("79%");
                    Otazka4.this.up4.setText("7%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Thomas: Hey, it's surely C). It was in South Korea.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 3) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What was the name of a lead Linkin Park singer?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("CHRIS CORNELL");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("KURT COBAIN");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("CHESTER BENNINGTON");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("COREY TAYLOR");
            this.castka = 0;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("9%");
                    Otazka4.this.up2.setText("2%");
                    Otazka4.this.up3.setText("84%");
                    Otazka4.this.up4.setText("5%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Malcom: It was Chester Bennington.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 4) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the order of guitar strings from bottom to top?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("D A E H G E");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("E H G D A E");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("G C A E D H");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("B C E A D H");
            this.castka = 0;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("20%");
                    Otazka4.this.up2.setText("71%");
                    Otazka4.this.up3.setText("7%");
                    Otazka4.this.up4.setText("2%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Ian: It is definitely B).");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 5) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many strings are there on a standard bass guitar?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("4");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("3");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("6");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("8");
            this.castka = 0;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("91%");
                    Otazka4.this.up2.setText("4%");
                    Otazka4.this.up3.setText("3%");
                    Otazka4.this.up4.setText("2%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Claire: I am 100% sure that there are 4 strings.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 6) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who is a vegan?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("PERSON, WHO DOESN'T EAT MEAT");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("MEAT LOVER");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("PERSON, WHO DOESN'T EAT ANIMAL PRODUCTS");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("BUTCHER");
            this.castka = 0;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("21%");
                    Otazka4.this.up2.setText("5%");
                    Otazka4.this.up3.setText("71%");
                    Otazka4.this.up4.setText("3%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Alexis: C) is correct.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 7) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the biggest drum of a drum kit?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("SNARE DRUM");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("HI-HAT");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("BASS DRUM");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("RACK TOM");
            this.castka = 0;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("5%");
                    Otazka4.this.up2.setText("20%");
                    Otazka4.this.up3.setText("71%");
                    Otazka4.this.up4.setText("4%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Peter: Hi, it is a bass drum!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 8) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which vitamins are often missed by vegans and vegetarians?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("C, E, B6");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("B12, D, A");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("K, B9");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("B2, B7, E");
            this.castka = 0;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("2%");
                    Otazka4.this.up2.setText("85%");
                    Otazka4.this.up3.setText("3%");
                    Otazka4.this.up4.setText("10%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Patrick: It's definitely B), rely on it.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 9) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these rivers is the shortest?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("THAMES");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("DANUBE");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("RHINE");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("RHONE");
            this.castka = 0;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("50%");
                    Otazka4.this.up2.setText("9%");
                    Otazka4.this.up3.setText("13%");
                    Otazka4.this.up4.setText("28%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Alec: Hi, the Thames is the shortest!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 10) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who discovered New Zealand?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("VASCO DA GAMA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("EDMUND HILLARY");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("RONALD AMUNDSEN");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("JAMES COOK");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("20%");
                    Otazka4.this.up2.setText("15%");
                    Otazka4.this.up3.setText("17%");
                    Otazka4.this.up4.setText("48%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Rick: Hi, it was captain Cook in 1769!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 11) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who helped Elizabeth I. to beat Spanish fleet?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("MARCO POLO");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("FRANCIS DRAKE");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("FRANCISCO PIZARRO");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("HENRY HUDSON");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("1%");
                    Otazka4.this.up2.setText("84%");
                    Otazka4.this.up3.setText("5%");
                    Otazka4.this.up4.setText("10%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Pavlína: Ahoj! Bezpochyby husité!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 12) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where belongs Argon?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("ALKALINE EARTH METAL");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("TO CHALCOGENS");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("TO HALOGENS");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("TO NOBEL GASSES");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("15%");
                    Otazka4.this.up2.setText("3%");
                    Otazka4.this.up3.setText("17%");
                    Otazka4.this.up4.setText("65%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Marc: Hey, it's definitely one of the noble gasses.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 13) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is not considered to be chalcogen?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("ALUMINIUM");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("OXYGEN");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("POLONIUM");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("SULFUR");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("75%");
                    Otazka4.this.up2.setText("4%");
                    Otazka4.this.up3.setText("9%");
                    Otazka4.this.up4.setText("12%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Amy: Hi, I'd choose Aluminium.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 14) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of the following cities is populated the least?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("LAGOS");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("SHANGHAI");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("NEW YORK");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("DALLAS");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("23%");
                    Otazka4.this.up2.setText("9%");
                    Otazka4.this.up3.setText("17%");
                    Otazka4.this.up4.setText("51%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Amy: Hi, it is Dallas.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 15) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is an annexation?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("DEPOSING THE DICTATOR");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("FORCIBLE ACQUISITION OF TERRITORY");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("ORGAN OPERATION");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("MUSCLE SPASM");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("16%");
                    Otazka4.this.up2.setText("68%");
                    Otazka4.this.up3.setText("4%");
                    Otazka4.this.up4.setText("12%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "David: Hi, B) is correct!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 16) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What was the name of Kazakhstan capital until 2019 (current name is Nur-Sultan)?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("BISHKEK");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("ASTANA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("SAMARKAND");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("TASHKENT");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("7%");
                    Otazka4.this.up2.setText("80%");
                    Otazka4.this.up3.setText("4%");
                    Otazka4.this.up4.setText("9%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Elizabeth: Astana is correct, rely on it.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 17) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who was the first human in an outer space?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("VLADIMÍR REMEK");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("NEIL ARMSTRONG");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("YURI GAGARIN");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("BUZZ ALDRIN");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("8%");
                    Otazka4.this.up2.setText("24%");
                    Otazka4.this.up3.setText("56%");
                    Otazka4.this.up4.setText("12%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "John: Hi, it was Yuri Gagarin.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 18) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who is Raphael Nadal?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("SWIMMER");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("FOOTBALLER");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("HOCKEY PLAYER");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("TENNIS PLAYER");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("4%");
                    Otazka4.this.up2.setText("3%");
                    Otazka4.this.up3.setText("5%");
                    Otazka4.this.up4.setText("88%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Claire: Hi, he is a spain tennis player!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 19) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who is not an author of classical music?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("B. SCHWEINSTEIGER");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("W. A. MOZART");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("J. S. BACH");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("L. V. BEETHOVEN");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("63%");
                    Otazka4.this.up2.setText("27%");
                    Otazka4.this.up3.setText("3%");
                    Otazka4.this.up4.setText("7%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Joe: Hi, you must choose A)!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 20) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which state is not a member of EU?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("SLOVAKIA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("ITALY");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("SWITZERLAND");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("GERMANY");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("4%");
                    Otazka4.this.up2.setText("9%");
                    Otazka4.this.up3.setText("83%");
                    Otazka4.this.up4.setText("4%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Elisabeth: Hi, Switzerland is definitely not a member.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 21) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where can we find Machu Picchu?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("IN BOLIVIA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("IN PERU");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("IN CHILE");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("IN MEXICO");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("7%");
                    Otazka4.this.up2.setText("58%");
                    Otazka4.this.up3.setText("12%");
                    Otazka4.this.up4.setText("23%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Matthew: Hi, Machu Picchu is in Peru.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 22) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where was an Archduke Franz Ferdinand of Austria assassinated?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("IN BEOGRAD");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("IN SARAJEVO");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("IN SKOPJE");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("IN PODGORICA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("11%");
                    Otazka4.this.up2.setText("66%");
                    Otazka4.this.up3.setText("5%");
                    Otazka4.this.up4.setText("18%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Dan: Hi, he was assassinated in Sarajevo!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 23) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of an Ukrainian currency?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("LITAS");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("RUBLE");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("HRYVNIA");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("SHKARIA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("6%");
                    Otazka4.this.up2.setText("12%");
                    Otazka4.this.up3.setText("75%");
                    Otazka4.this.up4.setText("7%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Sam: Hi, C) is correct!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 24) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What was the name of woman, who was the issue of Trojan war?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("ANNA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("HELEN");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("MARIE");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("AENEA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("9%");
                    Otazka4.this.up2.setText("75%");
                    Otazka4.this.up3.setText("9%");
                    Otazka4.this.up4.setText("7%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Andy: Hi, it was definitely Helen.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 25) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who was a representative of October revolution?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("LENIN");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("STALIN");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("PUTIN");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("RASPUTIN");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("67%");
                    Otazka4.this.up2.setText("14%");
                    Otazka4.this.up3.setText("18%");
                    Otazka4.this.up4.setText("1%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Gabrielle: Hi, it was Lenin.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 26) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many red lines are there on a hockey field?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("2");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("3");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("5");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("NONE");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("30%");
                    Otazka4.this.up2.setText("45%");
                    Otazka4.this.up3.setText("13%");
                    Otazka4.this.up4.setText("12%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "John: Hi, there are 3 red lines. I am 100% sure.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 27) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where can we find Uzbekistan?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("IN ASIA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("IN AFRICA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("IN SOUTH AMERICA");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("IN OCENIA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("70%");
                    Otazka4.this.up2.setText("9%");
                    Otazka4.this.up3.setText("11%");
                    Otazka4.this.up4.setText("10%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Zoe: Hi, Uzbekistan is in Asia.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 28) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of the topmost human vertebra?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("AXIS");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("ATLAS");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("EPISTROPHEUS");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("FLAILAL");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("7%");
                    Otazka4.this.up2.setText("82%");
                    Otazka4.this.up3.setText("9%");
                    Otazka4.this.up4.setText("2%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Zoe: It is called atlas, I am sure.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 29) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Approximately, how many bones are there in a human body?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("207");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("132");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("315");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("168");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("79%");
                    Otazka4.this.up2.setText("4%");
                    Otazka4.this.up3.setText("3%");
                    Otazka4.this.up4.setText("14%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Carl: Hi, A) is correct!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 30) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("The Aztecs empire was situated in?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("PERU");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("MEXICO");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("ARGENTINA");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("SOUTH AFRICA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("31%");
                    Otazka4.this.up2.setText("39%");
                    Otazka4.this.up3.setText("28%");
                    Otazka4.this.up4.setText("2%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Chris: Hi, I am not sure whether it is A) or B).");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 31) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which way is the earth spinning?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("FROM EAST TO WEST");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("FROM WEST TO EAST");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("FROM NORTH TO SOUTH");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("FROM SOUTH TO NORTH");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("31%");
                    Otazka4.this.up2.setText("67%");
                    Otazka4.this.up3.setText("1%");
                    Otazka4.this.up4.setText("1%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Lindsey: Hmm, it is probably B).");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 32) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who calls to prayer in a mosque?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("IMMAM");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("MUEZZIN");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("MIHRAB");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("MUHADZIN");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("7%");
                    Otazka4.this.up2.setText("83%");
                    Otazka4.this.up3.setText("5%");
                    Otazka4.this.up4.setText("5%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Olivia: Hey, B) is definitely correct.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 33) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many pillars of Islam are there?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("4");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("5");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("6");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("7");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("7%");
                    Otazka4.this.up2.setText("42%");
                    Otazka4.this.up3.setText("14%");
                    Otazka4.this.up4.setText("37%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Valentine: Hi, there are 5 of them.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 34) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("After crossing which river said Ceasar: Alea iacta est?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("MARECCHIA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("CONCA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("RUBICONE");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("FOGLIA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("12%");
                    Otazka4.this.up2.setText("13%");
                    Otazka4.this.up3.setText("62%");
                    Otazka4.this.up4.setText("13%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "David: Hi, I think that Rubicone is correct.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 35) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the capital of Brazil?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("BRASÍLIA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("SAO PAULO");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("RIO DE JANIERO");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("CURITIBA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("74%");
                    Otazka4.this.up2.setText("8%");
                    Otazka4.this.up3.setText("16%");
                    Otazka4.this.up4.setText("2%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Charlotte: Hi, I am sure that the capital of Brazil is Brasília.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 36) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Close to which city can we find the Escorial palace?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("MADRID");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("SEVILLA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("LISBON");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("BARCELONA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("74%");
                    Otazka4.this.up2.setText("13%");
                    Otazka4.this.up3.setText("9%");
                    Otazka4.this.up4.setText("4%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Charlotte: Hi, it is close to Madrid.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 37) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("After which Ancient philosopher are named the five solids?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("ZENO OF ELEA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("ARISTOTLE");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("SOCRATES");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("PLATO");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("22%");
                    Otazka4.this.up2.setText("4%");
                    Otazka4.this.up3.setText("18%");
                    Otazka4.this.up4.setText("56%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Anna: It is named after Plato!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 38) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the main component of natural gas?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("METHANE");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("ETHANE");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("ETHYNE");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("NAPHTHALENE");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("57%");
                    Otazka4.this.up2.setText("21%");
                    Otazka4.this.up3.setText("9%");
                    Otazka4.this.up4.setText("13%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Alex: Hi, it should be methane.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 39) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which bone in the human’s body is the smallest?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("TRAPEZE");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("STAPES");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("VOMER");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("PALENTINE");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("15%");
                    Otazka4.this.up2.setText("63%");
                    Otazka4.this.up3.setText("16%");
                    Otazka4.this.up4.setText("6%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Alexandra: Hi, B) is correct!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 40) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which scientist managed to isolate penicillin?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("MENDEL");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("MORGAN");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("SCHWANN");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("FLEMING");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("4%");
                    Otazka4.this.up2.setText("5%");
                    Otazka4.this.up3.setText("6%");
                    Otazka4.this.up4.setText("85%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Mia: Hi, it is D).");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 41) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these islands belongs to Japan?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("JAVA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("BORNEO");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("SULAWESI");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("HONSHU");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("5%");
                    Otazka4.this.up2.setText("12%");
                    Otazka4.this.up3.setText("5%");
                    Otazka4.this.up4.setText("78%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Cecillia: Hi, you should choose Honshu.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 42) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which kind of factory owns Willy Wonka?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("ICECREAM");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("CHOCOLATE");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("GINGERBREAD");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("CRISPS");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("16%");
                    Otazka4.this.up2.setText("68%");
                    Otazka4.this.up3.setText("14%");
                    Otazka4.this.up4.setText("2%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Martin: Hi, I am sure he owns a chocolate factory.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 43) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who painted Guernica?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("SALVADOR DALI");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("EUGENE DELACROIX");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("FRANCISCO GOYA");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("PICASSO");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("22%");
                    Otazka4.this.up2.setText("10%");
                    Otazka4.this.up3.setText("12%");
                    Otazka4.this.up4.setText("56%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Dan: Hi, the author of Guernica is Spanish painter Pablo Picasso.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 44) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where is the Death valley situated?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("IN THE USA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("IN CANADA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("IN ISRAEL");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("IN AUSTRALIA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("41%");
                    Otazka4.this.up2.setText("4%");
                    Otazka4.this.up3.setText("28%");
                    Otazka4.this.up4.setText("27%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Olivia: The Death Valley is in the USA.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 45) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("English is a language?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("GERMANIC");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("ROMANCE");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("CELTIC");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("BASQUEIC");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("56%");
                    Otazka4.this.up2.setText("9%");
                    Otazka4.this.up3.setText("29%");
                    Otazka4.this.up4.setText("6%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Sarah: Hi, English is a germanic language.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 46) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which supercontinent was on earth 300 million years ago?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("GONDWANA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("LAURASIA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("PANGAEA");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("RODINIA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("12%");
                    Otazka4.this.up2.setText("3%");
                    Otazka4.this.up3.setText("84%");
                    Otazka4.this.up4.setText("1%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Sarah: Hi, it was Pangaea. Rely on it.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 47) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where can we find a city of Szeged?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("IN SLOVAKIA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("IN SLOVENIA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("IN HUNGARY");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("IN ROMANIA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("14%");
                    Otazka4.this.up2.setText("6%");
                    Otazka4.this.up3.setText("71%");
                    Otazka4.this.up4.setText("9%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Paul: Hi, Szeged is definitely in Hungary.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 48) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which state is situated the biggest lake of Europe?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("IN RUSSIA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("IN FINLAND");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("IN POLAND");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("IN HUNGARY");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("56%");
                    Otazka4.this.up2.setText("33%");
                    Otazka4.this.up3.setText("1%");
                    Otazka4.this.up4.setText("10%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Michael: Hi, I'm 100% sure it is in Russia.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 49) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which animal can we find natively in China?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("LION");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("ZEBRA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("GIRAFFE");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("PANDA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("3%");
                    Otazka4.this.up2.setText("5%");
                    Otazka4.this.up3.setText("10%");
                    Otazka4.this.up4.setText("82%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Paul: Hi, D) is correct.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 50) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Ordem e progresso is written on which flag?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("ETHIOPIA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("BRAZIL");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("COLOMBIA");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("NIGERIA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("4%");
                    Otazka4.this.up2.setText("52%");
                    Otazka4.this.up3.setText("44%");
                    Otazka4.this.up4.setText("0%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "John: Hi, it is written on a Brazil flag.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 51) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many seconds can last one basketball attack?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("18");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("20");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("22");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("24");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("23%");
                    Otazka4.this.up2.setText("20%");
                    Otazka4.this.up3.setText("25%");
                    Otazka4.this.up4.setText("32%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Susane: Hi, it is 24 seconds, I am sure.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 52) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is tomorrowland?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("MUSIC FESTIVAL");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("SYNONYM TO NARNIA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("NICKNAME FOR BRAZIL");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("BRITISH ISLAND");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("79%");
                    Otazka4.this.up2.setText("14%");
                    Otazka4.this.up3.setText("5%");
                    Otazka4.this.up4.setText("2%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Susane: Hi, it's 100% music festival.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 53) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of famous british rock band?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("THE WHICH");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("THE WHAT");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("THE WHO");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("THE WHERE");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("1%");
                    Otazka4.this.up2.setText("18%");
                    Otazka4.this.up3.setText("79%");
                    Otazka4.this.up4.setText("2%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Susane: Hi, it is definitely The Who.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 54) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of Israeli intelligence agency?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("FSB");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("SIS");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("MOSSAD");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("BIS");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("6%");
                    Otazka4.this.up2.setText("8%");
                    Otazka4.this.up3.setText("84%");
                    Otazka4.this.up4.setText("2%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Alec: Hi, it is Mossad, I am sure.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 55) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the colour of 0 in rullete?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("RED");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("BLACK");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("GREEN");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("WHITE");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("17%");
                    Otazka4.this.up2.setText("23%");
                    Otazka4.this.up3.setText("57%");
                    Otazka4.this.up4.setText("3%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Alex: Hi, I am sure that C) is correct!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 56) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What number symbolizes a gross?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("24");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("48");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("144");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("200");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("12%");
                    Otazka4.this.up2.setText("12%");
                    Otazka4.this.up3.setText("57%");
                    Otazka4.this.up4.setText("19%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Matthew: Hi! I know it is C)!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 57) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these musical instruments is usually the biggest?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("BAGPIPES");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("SAXOPHONE");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("PIPE ORGAN");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("GUITAR");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("4%");
                    Otazka4.this.up2.setText("5%");
                    Otazka4.this.up3.setText("86%");
                    Otazka4.this.up4.setText("5%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Anthony: Hi, pipe organ should be the biggest.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 58) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which studio created animated film Madagascar?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("DREAMWORKS");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("COLUMBIA PICTURES");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("SQUARE PICTURES");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("21ST CENTURY FOX");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("52%");
                    Otazka4.this.up2.setText("17%");
                    Otazka4.this.up3.setText("7%");
                    Otazka4.this.up4.setText("24%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Michael: Hi, Unfortunately I don't know it, good luck.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 59) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Onto which physician's head has fallen an apple?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("BLAIS PASCAL");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("ISAAC NEWTONOV");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("LUDWIG BOLTZMANNOV");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("ALBERT EINSTEIN");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("1%");
                    Otazka4.this.up2.setText("93%");
                    Otazka4.this.up3.setText("0%");
                    Otazka4.this.up4.setText("6%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "George: Hi, it was Isaac Newton!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 60) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("When did Freddie Mercury die?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("1991");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("1983");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText(NativeAppInstallAd.ASSET_STORE);
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("1998");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("61%");
                    Otazka4.this.up2.setText("27%");
                    Otazka4.this.up3.setText("8%");
                    Otazka4.this.up4.setText("4%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Sophie: Hi, it was in 1991.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 61) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these states is not in Europe?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("ALBANIA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("MACEDONIA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("MOLDOVIA");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("JORDAN");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("21%");
                    Otazka4.this.up2.setText("17%");
                    Otazka4.this.up3.setText("19%");
                    Otazka4.this.up4.setText("43%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Sophie: Hi, you have to choose Jordan!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 62) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("James Bond is also known as agent...?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("007");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("77");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("707");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("7");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("65%");
                    Otazka4.this.up2.setText("10%");
                    Otazka4.this.up3.setText("12%");
                    Otazka4.this.up4.setText("13%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Michelle: Hi, this is A) for sure!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 63) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is traditionally wine made of?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("AGAVE");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("GRAPE");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("PLUM");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("TANGERINE");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("1%");
                    Otazka4.this.up2.setText("56%");
                    Otazka4.this.up3.setText("6%");
                    Otazka4.this.up4.setText("37%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Michelle: Hi, it is definitely grape!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 64) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who played the main character in the film Terminator?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("ARNOLD SCHWARZENEGGER");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("SYLVESTER STALLONE");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("JACKIE CHAN");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("SAM L. JACKSON");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("78%");
                    Otazka4.this.up2.setText("13%");
                    Otazka4.this.up3.setText("7%");
                    Otazka4.this.up4.setText("2%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Michelle: Hi, that's easy, Arnold Schwarzenegger!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 65) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What animal is Garfield (comic and film character)?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("CAT");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("MONKEY");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("DONKEY");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("DOG");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("58%");
                    Otazka4.this.up2.setText("12%");
                    Otazka4.this.up3.setText("24%");
                    Otazka4.this.up4.setText("6%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Michelle: Hi, Garfield is a cat!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 66) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which battle was fought in 1066?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("BATTLE OF WATERLOO");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("BATTLE OF GETTYSBURG");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("BATTLE OF HASTINGS");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("BATTLE OF THE SOMME");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("27%");
                    Otazka4.this.up2.setText("9%");
                    Otazka4.this.up3.setText("46%");
                    Otazka4.this.up4.setText("18%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Alec: Hi, I am sure it was battle of Hastings!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 67) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("On the coast of which sea can we find Bulgaria?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("MEDITERRANEAN");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("BALTIC");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("BLACK");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("CASPIAN");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("24%");
                    Otazka4.this.up2.setText("21%");
                    Otazka4.this.up3.setText("47%");
                    Otazka4.this.up4.setText("8%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Alexis: Hi, I know it! Bulgaria is on the coast of the black sea!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 68) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who or what is K(k)arakoram?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("AZTECS RULER");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("AUSTRALIAN MARSUPIAL");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("MOUNTAINS IN ASIA");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("VENEZUELA'S PRESIDENT");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("9%");
                    Otazka4.this.up2.setText("13%");
                    Otazka4.this.up3.setText("60%");
                    Otazka4.this.up4.setText("18%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Michael: Hi, mountains in Asia is correct!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 69) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where can we find radius bone?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("IN PELVIS");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("IN FOREARM");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("IN ANKLE");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("IN FACE");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("20%");
                    Otazka4.this.up2.setText("39%");
                    Otazka4.this.up3.setText("28%");
                    Otazka4.this.up4.setText("13%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Martin: Hi, it is situated in forearm!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 70) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many states can we find on an Apennine peninsula?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("0");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("1");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("2");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("3");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("0%");
                    Otazka4.this.up2.setText("3%");
                    Otazka4.this.up3.setText("44%");
                    Otazka4.this.up4.setText("53%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Rick: Hi, there are 3 states - Italy, San Marino and Vatican.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 71) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which state is not on Scandinavian peninsula?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("NORWAY");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("SWEDEN");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("DENMARK");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("FINLAND");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("14%");
                    Otazka4.this.up2.setText("21%");
                    Otazka4.this.up3.setText("53%");
                    Otazka4.this.up4.setText("12%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Rick: Hi, I recommend you choosing Denmark!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 72) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these lakes is not in Africa?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("VICTORIA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("TANGANYIKA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("MALAWI");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("TITICACA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("12%");
                    Otazka4.this.up2.setText("1%");
                    Otazka4.this.up3.setText("24%");
                    Otazka4.this.up4.setText("63%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Susane: Hi, correct answer is Titicaca which is situated in South America!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 73) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who has written The picture of Dorian Gray?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("OSCAR WILDE");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("J. K. ROWLING");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("CHARLES DICKENS");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("DANIEL DEFOE");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("81%");
                    Otazka4.this.up2.setText("2%");
                    Otazka4.this.up3.setText("14%");
                    Otazka4.this.up4.setText("3%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Thomas: Hey, I am sure it was Oscar Wilde!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 74) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("For what is not a Nobel prize given?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("PEACE");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("CHEMISTRY");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("LITERATURE");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("MATHEMATICS");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("5%");
                    Otazka4.this.up2.setText("18%");
                    Otazka4.this.up3.setText("21%");
                    Otazka4.this.up4.setText("56%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Tina: Hi, I think that there is not any Nobel prize in Math.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 75) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the capital city of Australia?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("CANBERRA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("SYDNEY");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("BRISBANE");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("MELBOURNE");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("29%");
                    Otazka4.this.up2.setText("28%");
                    Otazka4.this.up3.setText("15%");
                    Otazka4.this.up4.setText("28%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Theresa: Hi, I am sure it is Canberra!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 76) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("On which day is the Day of America’s Independence celebrated?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("5TH OF JULY");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("5TH OF AUGHUST");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("4TH OF JULY");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("4TH OF AUGHUST");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("15%");
                    Otazka4.this.up2.setText("36%");
                    Otazka4.this.up3.setText("42%");
                    Otazka4.this.up4.setText("7%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Jack: Hi, it is definitely the 4th of July!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 77) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these countries is the closest to the North pole?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("NORWAY");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("MEXICO");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("MONGOLIA");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("DENMARK");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("52%");
                    Otazka4.this.up2.setText("2%");
                    Otazka4.this.up3.setText("20%");
                    Otazka4.this.up4.setText("26%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Courtney: Hi, it should be Norway.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 78) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How do we call a famous American bussiness magazine?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("FORBES");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("PHENOM");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("FABRES");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("PHILLET");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("36%");
                    Otazka4.this.up2.setText("27%");
                    Otazka4.this.up3.setText("22%");
                    Otazka4.this.up4.setText("15%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Patrick: Hi, I am sure, it is Forbes!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 79) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("The highest peak of which state is named after Tadeausz Kosciuszko?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("POLAND");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("AUSTRALIA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("LITHUANA");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("UKRAINE");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("35%");
                    Otazka4.this.up2.setText("37%");
                    Otazka4.this.up3.setText("12%");
                    Otazka4.this.up4.setText("16%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Charlotte: Hi, that's easy, it is Australia!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 80) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which shape has an office of US president?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("CIRCLE");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("SQUARE");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("RECTANGLE");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("OVAL");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("14%");
                    Otazka4.this.up2.setText("6%");
                    Otazka4.this.up3.setText("6%");
                    Otazka4.this.up4.setText("74%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Ian: Hi, it is oval!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 81) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How do we say please in Spanish?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("MERCI");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("POR FAVOR");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("PREGO");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("GRACIAS");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("7%");
                    Otazka4.this.up2.setText("18%");
                    Otazka4.this.up3.setText("61%");
                    Otazka4.this.up4.setText("14%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Martin: Hi, it should be por favor.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 82) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which competition does the team Detroit Red Wings take part in?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("NFL");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("NHL");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("NBA");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("MLS");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("23%");
                    Otazka4.this.up2.setText("43%");
                    Otazka4.this.up3.setText("29%");
                    Otazka4.this.up4.setText("5%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Matthew: Hi, 100% in NHL!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 83) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which number represents a word penta?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("3");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("4");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("5");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("6");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("2%");
                    Otazka4.this.up2.setText("27%");
                    Otazka4.this.up3.setText("65%");
                    Otazka4.this.up4.setText("6%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Danielle: Hi, it is number 5.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 84) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("On which state's flag can we find a white cross?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("MALI");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("ALBANIA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("CANADA");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("SWITZERLAND");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("3%");
                    Otazka4.this.up2.setText("1%");
                    Otazka4.this.up3.setText("12%");
                    Otazka4.this.up4.setText("84%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Barbara: Hi, it is Switzerland, I am sure!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 85) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Murray is the longest river of?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("ENGLAND");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("USA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("AUSTRALIA");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("CANADA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("6%");
                    Otazka4.this.up2.setText("5%");
                    Otazka4.this.up3.setText("81%");
                    Otazka4.this.up4.setText("8%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Lisa: Hi, it is the longest river of Australia!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 86) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("An angle can be measured in which SI units?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("IN PERCENTS");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("IN YARDS");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("IN CENTIMETRES");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("IN RADIANS");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("21%");
                    Otazka4.this.up2.setText("12%");
                    Otazka4.this.up3.setText("0%");
                    Otazka4.this.up4.setText("67%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Nicole: Hi, I am pretty sure that D) is correct!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 87) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the motto of the Olympics?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("CITIUS, ALTIUS, FORTIUS");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("VENI, VIDI, VICI");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("DE CAPRA ET ALBERGO");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("AUT VINCERE, AUT MORI");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("81%");
                    Otazka4.this.up2.setText("16%");
                    Otazka4.this.up3.setText("2%");
                    Otazka4.this.up4.setText("1%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Lisa: It is Citius, Altius, Fortius which means swifter, higher, stronger.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 88) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("On which state's flag can we find a sun?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("NEPAL");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("GHANA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("MOZAMBIQUE");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("SWEDEN");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("67%");
                    Otazka4.this.up2.setText("21%");
                    Otazka4.this.up3.setText("10%");
                    Otazka4.this.up4.setText("2%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Margharet: Hi, I think it should be Nepal!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 89) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Wish you were here is a song by which band?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("THE BEATLES");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("ROLLING STONES");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("THE OFFSPRING");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("PINK FLOYD");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("20%");
                    Otazka4.this.up2.setText("23%");
                    Otazka4.this.up3.setText("14%");
                    Otazka4.this.up4.setText("43%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Ann: Hi, it is Pink Floyd, 100%!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 90) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which country can we find up to 1000 fjords?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("CZECH REPUBLIC");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("FINLAND");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("FRANCE");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("NORWAY");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("14%");
                    Otazka4.this.up2.setText("16%");
                    Otazka4.this.up3.setText("9%");
                    Otazka4.this.up4.setText("61%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Margharet: Hi, this is easy, Norway is correct!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 91) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How long does it take the light to reach from the Sun to Earth?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("8 SECONDS");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("8 MINUTES");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("8 HOURS");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("8 YEARS");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("21%");
                    Otazka4.this.up2.setText("48%");
                    Otazka4.this.up3.setText("28%");
                    Otazka4.this.up4.setText("3%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Theresa: Hi, I know this! 8 minutes for sure!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 92) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the pH of water?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("4");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("5");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("6");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("7");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("9%");
                    Otazka4.this.up2.setText("14%");
                    Otazka4.this.up3.setText("35%");
                    Otazka4.this.up4.setText("42%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Michael: Hi, water is neutral so it is 7 for sure!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 93) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which football club has won the italian Seria A the most?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("AC MILANO");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("JUVENTUS TORINO");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("AS ROMA");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("INTER MILANO");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("19%");
                    Otazka4.this.up2.setText("61%");
                    Otazka4.this.up3.setText("9%");
                    Otazka4.this.up4.setText("11%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Luke: Hi, that's easy for me, definitely Juventus!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 94) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which country has renaissance appeared as first?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("IN FRANCE");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("IN ENGLAND");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("IN ITALY");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("IN PRUSSIA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("25%");
                    Otazka4.this.up2.setText("28%");
                    Otazka4.this.up3.setText("47%");
                    Otazka4.this.up4.setText("0%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Diana: Hi, it was probably in Italy.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 95) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these books is the oldest?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("LES MISÉRABLES");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("OLIVER TWIST");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("EPIC OF GILGAMESH");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("HAMLET");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("4%");
                    Otazka4.this.up2.setText("7%");
                    Otazka4.this.up3.setText("71%");
                    Otazka4.this.up4.setText("18%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Claire: Hi, it is Epic of Gilgamesh, I am sure!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 96) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of famous ballet?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("TURKEY LAKE");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("SWAN LAKE");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("GOOSE LAKE");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("PIGEON LAKE");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("4%");
                    Otazka4.this.up2.setText("73%");
                    Otazka4.this.up3.setText("19%");
                    Otazka4.this.up4.setText("4%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Christopher: Hi, it is a Swan lake!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 97) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Peter Parker is the name of which superhero?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("FLASH");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("BATMAN");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("SPIDERMAN");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("HULK");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("14%");
                    Otazka4.this.up2.setText("18%");
                    Otazka4.this.up3.setText("62%");
                    Otazka4.this.up4.setText("6%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Sarah: Hi, this is the name of Spiderman!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 98) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which state can we find the leaning tower of Pisa?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("IN PERU");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("IN ITALY");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("IN GREECE");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("IN SPAIN");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("2%");
                    Otazka4.this.up2.setText("49%");
                    Otazka4.this.up3.setText("9%");
                    Otazka4.this.up4.setText("40%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Sarah: Hi, it is in Italy!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 99) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("An activity of which organ can we observe with electrocardiograph?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("LUNGS");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("HEART");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("BRAIN");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("LIVER");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("20%");
                    Otazka4.this.up2.setText("71%");
                    Otazka4.this.up3.setText("5%");
                    Otazka4.this.up4.setText("4%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Claire: Hi, we can watch an activity of heart!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 100) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many films are there in the Lord of the Rings series?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("2");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("3");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("4");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("5");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("15%");
                    Otazka4.this.up2.setText("48%");
                    Otazka4.this.up3.setText("21%");
                    Otazka4.this.up4.setText("16%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Taylor: Hi, there are 3 films!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 101) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which state can we find the city of Plovdiv?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("IN ROMANIA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("IN BULGARIA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("IN SERBIA");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("IN BOSNIA AND HERZEGOVINA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("32%");
                    Otazka4.this.up2.setText("43%");
                    Otazka4.this.up3.setText("12%");
                    Otazka4.this.up4.setText("13%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Vicky: Hi, Bulgaria is correct!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 102) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these states is the biggest in area?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("SLOVENIA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("CROATIA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("MONTENEGRO");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("ALBANIA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("39%");
                    Otazka4.this.up2.setText("48%");
                    Otazka4.this.up3.setText("5%");
                    Otazka4.this.up4.setText("8%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Jim: Hi, it should be Croatia!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 103) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which goalkeeper has the most clean sheets in English Premier League?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("JOE HART");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("IKER CASILLAS");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("PETR CECH");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("THIBAUT CURTOIS");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("10%");
                    Otazka4.this.up2.setText("9%");
                    Otazka4.this.up3.setText("67%");
                    Otazka4.this.up4.setText("14%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Jim: Hi, it is Petr Cech, rely on it!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 104) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the chemical formula for methanol?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("CH3-OH");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("CH3-CH2-OH");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("CH2=OH");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("CH3-CH=OH");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("39%");
                    Otazka4.this.up2.setText("37%");
                    Otazka4.this.up3.setText("14%");
                    Otazka4.this.up4.setText("10%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Lucy: Hi, I don't know the answer, but A) or B) must be correct!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 105) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the colour of Nemo (fish) in the film Finding Nemo?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("BLACK");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("BLUE");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("YELLOW");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("ORANGE");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("20%");
                    Otazka4.this.up2.setText("7%");
                    Otazka4.this.up3.setText("14%");
                    Otazka4.this.up4.setText("59%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Theresa: Hi, Nemo is orange! Rely on it!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 106) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many karats are there in 100% gold?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("18");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("22");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("24");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("28");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("3%");
                    Otazka4.this.up2.setText("25%");
                    Otazka4.this.up3.setText("39%");
                    Otazka4.this.up4.setText("33%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Steven: Hi, I think it should be 24 karats!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 107) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which hockey club can we find in Vancouver?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("SHARKS");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("GOLDEN KNIGHTS");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("CANUCKS");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("STARS");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("14%");
                    Otazka4.this.up2.setText("19%");
                    Otazka4.this.up3.setText("41%");
                    Otazka4.this.up4.setText("26%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Rick: Hi, I think it's Vancouver Canucks!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 108) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which NHL team made it's debut in the 2017/2018 season?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("TAMPA BAY LIGHTNING");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("WASHINGTON CAPITALS");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("CALGARY FLAMES");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("LAS VEGAS GOLDEN KNIGHTS");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("18%");
                    Otazka4.this.up2.setText("5%");
                    Otazka4.this.up3.setText("6%");
                    Otazka4.this.up4.setText("71%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Patrick: Hi, this is easy for me, D) is correct!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 109) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many sports are there in Nordic Combination?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("2");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("3");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("5");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("10");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("38%");
                    Otazka4.this.up2.setText("42%");
                    Otazka4.this.up3.setText("14%");
                    Otazka4.this.up4.setText("6%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Phil: Hi, there are only 2 sports!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 110) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is Cotangens?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("SOME KIND OF TANGO");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("MATH FUNCTION");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("METAL BAND");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("WEB BROWSER");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("12%");
                    Otazka4.this.up2.setText("84%");
                    Otazka4.this.up3.setText("1%");
                    Otazka4.this.up4.setText("3%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Thomas: Hi, 100% it is B)!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 111) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("From which discipline does the term Meander come from?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("HYDROLOGY");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("BIOLOGY");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("ASTRONOMY");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("CHEMISTRY");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(1);
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("62%");
                    Otazka4.this.up2.setText("18%");
                    Otazka4.this.up3.setText("6%");
                    Otazka4.this.up4.setText("14%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Phil: Hi, it is definitely from Hydrology!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 112) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Come As You Are is a hit of which band?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("METALLICA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("LINKIN PARK");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("IRON MAIDEN");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("NIRVANA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("13%");
                    Otazka4.this.up2.setText("6%");
                    Otazka4.this.up3.setText("19%");
                    Otazka4.this.up4.setText("62%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Frank: Nirvana! 100%!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 113) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of phenomenom which influences the weather in Peru?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("EL INO");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("EL MINO");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("EL NINO");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("EL ENO");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(3);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("18%");
                    Otazka4.this.up2.setText("21%");
                    Otazka4.this.up3.setText("48%");
                    Otazka4.this.up4.setText("13%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Susanne: Hey, C) is correct!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 114) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which state has Germany attacked on the 1st of September 1939?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("CZECHOSLOVAKIA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("POLAND");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("BELGIUM");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("FRANCE");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("4%");
                    Otazka4.this.up2.setText("70%");
                    Otazka4.this.up3.setText("16%");
                    Otazka4.this.up4.setText("10%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Sandra: Hi, I think it was Poland!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 115) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these languages is not considered to be the romance one?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("PORTUGUESE");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("GREEK");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("SPANISH");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("ITALIAN");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(2);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("4%");
                    Otazka4.this.up2.setText("70%");
                    Otazka4.this.up3.setText("16%");
                    Otazka4.this.up4.setText("10%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setEnabled(false);
                    Otazka4.this.f116u4.setVisibility(4);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setEnabled(false);
                    Otazka4.this.f115u3.setVisibility(4);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up4.setVisibility(4);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up3.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Sandra: Hi, it is Greek, I am 100% sure!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 116) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many Megabytes are there in one Gigabyte?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("100");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("666");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("256");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("1000");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("4%");
                    Otazka4.this.up2.setText("0%");
                    Otazka4.this.up3.setText("17%");
                    Otazka4.this.up4.setText("79%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Paul: Hi, there is 1 thousand of it.");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        } else if (this.losovane == 117) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which continent is Nigeria?");
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setText("ASIA");
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setText("NORTH AMERICA");
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setText("SOUTH AMERICA");
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setText("AFRICA");
            this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
            this.f116u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.Spravna(4);
                }
            });
            this.f113u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f114u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.f115u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.gameOver2(Otazka4.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka4.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unl.setEnabled(false);
                    Otazka4.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.up1.setText("17%");
                    Otazka4.this.up2.setText("0%");
                    Otazka4.this.up3.setText("4%");
                    Otazka4.this.up4.setText("79%");
                    Otazka4.this.pomocnapromenna4 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unp.setEnabled(false);
                    Otazka4.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setEnabled(false);
                    Otazka4.this.f113u1.setVisibility(4);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setEnabled(false);
                    Otazka4.this.f114u2.setVisibility(4);
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up1.setVisibility(4);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up2.setVisibility(4);
                    Otazka4.this.pomocnapromennap4 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka4.this.unt.setEnabled(false);
                    Otazka4.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka4.this);
                    builder.setMessage((CharSequence) "Paul: Hi, Nigeria is in Africa!");
                    builder.create().show();
                    Otazka4.this.pomocnapromennat4 = 1;
                }
            });
        }
        this.dvere = (Button) findViewById(C1760R.C1762id.dvere);
        this.dvere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Otazka4.this.castka = PathInterpolatorCompat.MAX_NUM_POINTS;
                Otazka4.this.gameOver();
                if (Otazka4.this.castka > Otazka4.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                    Otazka4.this.highscore(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
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
        this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f113u1.setEnabled(false);
        this.f114u2.setEnabled(false);
        this.f115u3.setEnabled(false);
        this.f116u4.setEnabled(false);
        if (i != 0) {
            int parseColor = Color.parseColor("#ffaa00");
            this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
            this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
            this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
            this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
            if (i == 1) {
                this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f113u1.setTextColor(parseColor);
                this.f113u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up1.setTextColor(parseColor);
            } else if (i == 2) {
                this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f114u2.setTextColor(parseColor);
                this.f114u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up2.setTextColor(parseColor);
            } else if (i == 3) {
                this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f115u3.setTextColor(parseColor);
                this.f115u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up3.setTextColor(parseColor);
            } else if (i == 4) {
                this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f116u4.setTextColor(parseColor);
                this.f116u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up4.setTextColor(parseColor);
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    int parseColor = Color.parseColor("#fcff0202");
                    int parseColor2 = Color.parseColor("#1dc700");
                    Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                    Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                    Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                    Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    if (i == 1) {
                        Otazka4.this.f113u1.setTextColor(parseColor);
                        Otazka4.this.f113u1.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka4.this.up1.setTextColor(parseColor);
                    } else if (i == 2) {
                        Otazka4.this.f114u2.setTextColor(parseColor);
                        Otazka4.this.f114u2.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka4.this.up2.setTextColor(parseColor);
                    } else if (i == 3) {
                        Otazka4.this.f115u3.setTextColor(parseColor);
                        Otazka4.this.f115u3.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka4.this.up3.setTextColor(parseColor);
                    } else if (i == 4) {
                        Otazka4.this.f116u4.setTextColor(parseColor);
                        Otazka4.this.f116u4.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka4.this.up4.setTextColor(parseColor);
                    }
                    if (i2 == 1) {
                        Otazka4.this.f113u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka4.this.f113u1.setTextColor(parseColor2);
                        Otazka4.this.up1.setTextColor(parseColor2);
                    } else if (i2 == 2) {
                        Otazka4.this.f114u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka4.this.f114u2.setTextColor(parseColor2);
                        Otazka4.this.up2.setTextColor(parseColor2);
                    } else if (i2 == 3) {
                        Otazka4.this.f115u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka4.this.f115u3.setTextColor(parseColor2);
                        Otazka4.this.up3.setTextColor(parseColor2);
                    } else if (i2 == 4) {
                        Otazka4.this.f116u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka4.this.f116u4.setTextColor(parseColor2);
                        Otazka4.this.up4.setTextColor(parseColor2);
                    }
                    Intent intent = new Intent(Otazka4.this, BackgroundSoundService.class);
                    intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                    Otazka4.this.stopService(intent);
                    Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka4.this).getBoolean("ZVUK", true));
                    Otazka4.this.spatna = MediaPlayer.create(Otazka4.this, C1760R.raw.spatna2);
                    if (z && valueOf.booleanValue()) {
                        Otazka4.this.spatna.start();
                    }
                }
            }, 1500);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Otazka4.this.alertDialog();
                    if (Otazka4.this.mInterstitialAd.isLoaded()) {
                        Otazka4.this.mInterstitialAd.show();
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
        this.castka = 300;
        Intent intent2 = new Intent(this, PopActivity.class);
        intent2.putExtra("Level", this.level);
        intent2.putExtra("Castka", this.castka);
        intent2.putExtra("pomocnapromenna", this.pomocnapromenna4);
        intent2.putExtra("pomocnapromennap", this.pomocnapromennap4);
        intent2.putExtra("pomocnapromennat", this.pomocnapromennat4);
        startActivity(intent2);
        this.mCountDownTimer.cancel();
    }

    /* access modifiers changed from: private */
    public void Spravna(final int i) {
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_4", 0);
        int i2 = sharedPreferences.getInt("x", -1) + 1;
        SharedPreferences.Editor edit = getSharedPreferences("zodpovezene_4", 0).edit();
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
        this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f113u1.setEnabled(false);
        this.f114u2.setEnabled(false);
        this.f115u3.setEnabled(false);
        this.f116u4.setEnabled(false);
        if (i == 1) {
            this.f113u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f113u1.setTextColor(parseColor);
            this.f113u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up1.setTextColor(parseColor);
        } else if (i == 2) {
            this.f114u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f114u2.setTextColor(parseColor);
            this.f114u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up2.setTextColor(parseColor);
        } else if (i == 3) {
            this.f115u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f115u3.setTextColor(parseColor);
            this.f115u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up3.setTextColor(parseColor);
        } else {
            this.f116u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f116u4.setTextColor(parseColor);
            this.f116u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up4.setTextColor(parseColor);
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka4.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                Otazka4.this.stopService(intent);
                int parseColor = Color.parseColor("#1dc700");
                Otazka4.this.up1 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up1);
                Otazka4.this.up2 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up2);
                Otazka4.this.up3 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up3);
                Otazka4.this.up4 = (TextView) Otazka4.this.findViewById(C1760R.C1762id.up4);
                if (i == 1) {
                    Otazka4.this.f113u1 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka4.this.f113u1.setTextColor(parseColor);
                    Otazka4.this.f113u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka4.this.up1.setTextColor(parseColor);
                } else if (i == 2) {
                    Otazka4.this.f114u2 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka4.this.f114u2.setTextColor(parseColor);
                    Otazka4.this.f114u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka4.this.up2.setTextColor(parseColor);
                } else if (i == 3) {
                    Otazka4.this.f115u3 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka4.this.f115u3.setTextColor(parseColor);
                    Otazka4.this.f115u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka4.this.up3.setTextColor(parseColor);
                } else {
                    Otazka4.this.f116u4 = (Button) Otazka4.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka4.this.f116u4.setTextColor(parseColor);
                    Otazka4.this.f116u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka4.this.up4.setTextColor(parseColor);
                }
                if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka4.this).getBoolean("ZVUK", true)).booleanValue()) {
                    MediaPlayer.create(Otazka4.this, C1760R.raw.applause2).start();
                }
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka4.this, Otazka5.class);
                intent.putExtra("some_key4", Otazka4.this.pomocnapromenna4);
                intent.putExtra("some_keyp4", Otazka4.this.pomocnapromennap4);
                intent.putExtra("some_keyt4", Otazka4.this.pomocnapromennat4);
                Otazka4.this.startActivity(intent);
                CustomIntent.customType(Otazka4.this, "left-to-right");
            }
        }, 2500);
    }

    /* access modifiers changed from: private */
    public void highscore(int i) {
        if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true)).booleanValue()) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    MediaPlayer.create(Otazka4.this, C1760R.raw.applause7).start();
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
            Intent intent = new Intent(this, Otazka5.class);
            this.mCountDownTimer.cancel();
            intent.putExtra("some_key4", this.pomocnapromenna4);
            intent.putExtra("some_keyp4", this.pomocnapromennap4);
            intent.putExtra("some_keyt4", this.pomocnapromennat4);
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
            intent.putExtra("pomocnapromenna", this.pomocnapromenna4);
            intent.putExtra("pomocnapromennap", this.pomocnapromennap4);
            intent.putExtra("pomocnapromennat", this.pomocnapromennat4);
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
