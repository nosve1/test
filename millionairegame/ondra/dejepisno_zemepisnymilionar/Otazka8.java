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

public class Otazka8 extends AppCompatActivity implements RewardedVideoAdListener {
    private static boolean activityVisible;
    Button Zvuk;

    /* renamed from: a */
    final int f151a = 0;

    /* renamed from: a6 */
    Button f152a6;
    ArrayList<Integer> arl = new ArrayList<>();

    /* renamed from: b */
    final int f153b = 0;

    /* renamed from: b6 */
    Button f154b6;
    Button b6p;
    Button button7_1;
    Button buttonp7_1;
    Button buttont7_1;

    /* renamed from: c6 */
    Button f155c6;
    Button c6p;
    int castka;

    /* renamed from: d6 */
    Button f156d6;
    Button dvere;
    RadioGroup fuhrer1;
    boolean gameOver = false;

    /* renamed from: i */
    int f157i = 0;
    int[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46};
    TextView label;
    int level = 8;
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
    int pomocnapromenna8;
    int pomocnapromennap8;
    int pomocnapromennat8;
    TextView procen1;
    TextView procen2;
    TextView procen3;
    TextView procen4;

    /* renamed from: r */
    Random f158r;
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
    Button f159u1;

    /* renamed from: u2 */
    Button f160u2;

    /* renamed from: u3 */
    Button f161u3;

    /* renamed from: u4 */
    Button f162u4;
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
        this.f158r = new Random();
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_8", 0);
        int i = sharedPreferences.getInt("x", -1) + 1;
        System.out.println(i + "!!!!");
        SharedPreferences sharedPreferences2 = getSharedPreferences("zodpovezene_8", 0);
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
        this.f158r = new Random();
        this.castka = 0;
        if (this.arl.size() == 0) {
            sharedPreferences.edit().clear().commit();
            sharedPreferences2.edit().clear().commit();
            int i5 = getSharedPreferences("zodpovezene_8", 0).getInt("x", -1) + 1;
            System.out.println(i5 + "!!!!");
            SharedPreferences sharedPreferences3 = getSharedPreferences("zodpovezene_8", 0);
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
        this.losovane = this.f158r.nextInt(this.arl.size());
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
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(Otazka8.this);
                Boolean valueOf = Boolean.valueOf(defaultSharedPreferences.getBoolean("ZVUK", true));
                Intent intent = new Intent(Otazka8.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                if (valueOf.booleanValue()) {
                    SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                    edit.putBoolean("ZVUK", false);
                    edit.commit();
                    Otazka8.this.stopService(intent);
                    Otazka8.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukvypnuto);
                    return;
                }
                SharedPreferences.Editor edit2 = defaultSharedPreferences.edit();
                edit2.putBoolean("ZVUK", true);
                edit2.commit();
                Otazka8.this.startService(intent);
                Otazka8.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukzapnuto);
            }
        });
        this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f159u1.setTextColor(-1);
        this.f159u1.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f160u2.setTextColor(-1);
        this.f160u2.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f161u3.setTextColor(-1);
        this.f161u3.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f162u4.setTextColor(-1);
        this.f162u4.setBackgroundResource(C1760R.C1761drawable.button_bg);
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
        this.textview2.setText("1K");
        this.textview2.setBackgroundResource(C1760R.C1761drawable.textview2);
        this.textview2.setTypeface(Typeface.DEFAULT_BOLD);
        this.textview3 = (TextView) findViewById(C1760R.C1762id.textView3);
        this.textview3.setText("2K");
        this.textview3.setBackgroundResource(C1760R.C1761drawable.textview);
        this.textview3.setTypeface(Typeface.DEFAULT);
        this.textview4 = (TextView) findViewById(C1760R.C1762id.textView4);
        this.textview4.setText("5K");
        this.textview5 = (TextView) findViewById(C1760R.C1762id.textView5);
        this.textview5.setText("10K");
        this.textview6 = (TextView) findViewById(C1760R.C1762id.textView6);
        this.textview6.setText("20K");
        this.textview6.setBackgroundResource(C1760R.C1761drawable.textview2);
        this.textview6.setTypeface(Typeface.DEFAULT_BOLD);
        this.textview7 = (TextView) findViewById(C1760R.C1762id.textView7);
        this.textview7.setText("40K");
        this.textview7.setBackgroundResource(C1760R.C1761drawable.textview);
        this.textview7.setTypeface(Typeface.DEFAULT);
        this.textview8 = (TextView) findViewById(C1760R.C1762id.textView8);
        this.textview8.setText("80K");
        this.otazkaza = (TextView) findViewById(C1760R.C1762id.otazkaza);
        this.otazkaza.setText("10 000$ Question");
        this.mProgressBar = (ProgressBar) findViewById(C1760R.C1762id.progressBar3);
        this.mProgressBar.setProgress(this.f157i);
        this.mCountDownTimer = new CountDownTimer(40000, 1000) {
            public void onTick(long j) {
                Log.v("Log_tag", "Tick of Progress" + Otazka8.this.f157i + j);
                Otazka8 otazka8 = Otazka8.this;
                otazka8.f157i = otazka8.f157i + 1;
                Otazka8.this.mProgressBar.setProgress((Otazka8.this.f157i * 100) / 40);
            }

            public void onFinish() {
                Otazka8.this.f157i++;
                Otazka8.this.mProgressBar.setProgress(100);
                Otazka8.this.uzivatelOdpovedel = false;
                Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 0, 0);
            }
        };
        this.mCountDownTimer.start();
        int i9 = getIntent().getExtras().getInt("some_key7");
        int i10 = getIntent().getExtras().getInt("some_keyp7");
        if (getIntent().getExtras().getInt("some_keyt7") == 1) {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(false);
            this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
            this.pomocnapromennat8 = 1;
        } else {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(true);
        }
        if (i10 == 1) {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(false);
            this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
            this.pomocnapromennap8 = 1;
        } else {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(true);
        }
        if (i9 == 1) {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(false);
            this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
            this.pomocnapromenna8 = 1;
        } else {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(true);
        }
        this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f159u1.setEnabled(true);
        this.f160u2.setEnabled(true);
        this.f161u3.setEnabled(true);
        this.f162u4.setEnabled(true);
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
            this.otazkau.setText("Cancer of which part of the body is called abdominis?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("STOMACH");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("PROSTATE");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("SKIN");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("LUNGS");
            this.castka = 40000;
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(1);
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("29%");
                    Otazka8.this.up2.setText("20%");
                    Otazka8.this.up3.setText("27%");
                    Otazka8.this.up4.setText("24%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Liam: I would say the correct answer is A.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 2) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which year was the punk-rock band Sum 41 founded?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("1984");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("1989");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("1996");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText(NativeAppInstallAd.ASSET_ICON);
            this.castka = 40000;
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(3);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("14%");
                    Otazka8.this.up2.setText("29%");
                    Otazka8.this.up3.setText("31%");
                    Otazka8.this.up4.setText("26%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Charles: Hey, I do not know the correct answer but it is definitely one of the numbers in the middle.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 3) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Latin word that stands for brain is?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("ENCEPHALON");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("SPINALIS");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("CEREBELLUM");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("TIBIA");
            this.castka = 40000;
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(1);
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("30%");
                    Otazka8.this.up2.setText("23%");
                    Otazka8.this.up3.setText("25%");
                    Otazka8.this.up4.setText("22%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.f162u4 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka8.this.f162u4.setEnabled(false);
                    Otazka8.this.f162u4.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up4.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Gabe: Hi, I think it is encephalon.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 4) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who discovered electromagnetic induction?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("ALESSANDRO VOLTA");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("GEORG OHM");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("NIKOLA TESLA");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("MICHAEL FARADAY");
            this.castka = 40000;
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(4);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("19%");
                    Otazka8.this.up2.setText("17%");
                    Otazka8.this.up3.setText("28%");
                    Otazka8.this.up4.setText("36%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Paul: Hello! D) - Michael Faraday is correct.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 5) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What was the codename of the Normandy landings?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("ANTHROPOID");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("BARBAROSSA");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("OVERLORD");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("HERKULES");
            this.castka = 40000;
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(3);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("6%");
                    Otazka8.this.up2.setText("29%");
                    Otazka8.this.up3.setText("39%");
                    Otazka8.this.up4.setText("26%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Therese: Hi, in my opininon it is C) - Overload.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 6) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these states can not be found on the Borneo island?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("MALAYSIA");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("INDONESIA");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("BRUNEI");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("VANUATU");
            this.castka = 40000;
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(4);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("13%");
                    Otazka8.this.up2.setText("13%");
                    Otazka8.this.up3.setText("34%");
                    Otazka8.this.up4.setText("40%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Henry: Hello, I think it is D).");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 7) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Net ball came from which country?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("USSR");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("ENGLAND");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("BRAZIL");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("CZECHOSLOVAKIA");
            this.castka = 40000;
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(4);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("19%");
                    Otazka8.this.up2.setText("25%");
                    Otazka8.this.up3.setText("27%");
                    Otazka8.this.up4.setText("29%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Zlatan: Hi, it is D for sure.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 8) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Wolfgang A. Mozart had an arch nemesis. Who was it?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("SALIERI");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("BEETHOVEN");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("BACH");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("VIVALDI");
            this.castka = 40000;
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(1);
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("35%");
                    Otazka8.this.up2.setText("22%");
                    Otazka8.this.up3.setText("18%");
                    Otazka8.this.up4.setText("25%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Jill: Hey, possibly Salieri.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 9) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Ural and Altai orogeny happened in which geological era?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("PALEOZOIC");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("MESOZOIC");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("CENOZOIC");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("QUATERNARY");
            this.castka = 40000;
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(1);
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("29%");
                    Otazka8.this.up2.setText("28%");
                    Otazka8.this.up3.setText("26%");
                    Otazka8.this.up4.setText("17%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f162u4 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka8.this.f162u4.setEnabled(false);
                    Otazka8.this.f162u4.setVisibility(4);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up4.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Becky: Hey, it is either Paleozoic or Mesozoic.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 10) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who is the counterpart of Jean Valjean?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("JAVERT");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("BAUDELAIRE");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("COURBET");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("TAINE");
            this.castka = 40000;
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(1);
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("38%");
                    Otazka8.this.up2.setText("14%");
                    Otazka8.this.up3.setText("19%");
                    Otazka8.this.up4.setText("29%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f162u4 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka8.this.f162u4.setEnabled(false);
                    Otazka8.this.f162u4.setVisibility(4);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up4.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Adéla: Hi, it is the officer Javert.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 11) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these is an abbreviation of Russia’s social network similiar to Facebook?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("DB");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("RS");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("OP");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("VK");
            this.castka = 40000;
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(4);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("13%");
                    Otazka8.this.up2.setText("24%");
                    Otazka8.this.up3.setText("21%");
                    Otazka8.this.up4.setText("42%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Patrick: Hi, it is D) - VK.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 12) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many benzen nucleuses are there in antracen?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("1");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("2");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("3");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("4");
            this.castka = 40000;
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(3);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("15%");
                    Otazka8.this.up2.setText("28%");
                    Otazka8.this.up3.setText("31%");
                    Otazka8.this.up4.setText("26%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Jessie: Hello, antracen has 3 for sure.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 13) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is etymology concerned with?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("INSECT");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("ORIGIN OF A WORD");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("RULERS");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("WAYS OF PAYMENT");
            this.castka = 40000;
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(2);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("29%");
                    Otazka8.this.up2.setText("38%");
                    Otazka8.this.up3.setText("16%");
                    Otazka8.this.up4.setText("17%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f162u4 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka8.this.f162u4.setEnabled(false);
                    Otazka8.this.f162u4.setVisibility(4);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up4.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Kristián: Čau. Fakt netuším.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 14) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which country was Adolf Hitler born?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("AUSTRIA");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("SWITZERLAND");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("GERMANY");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("LICHTEJNŠTEJNSKO");
            this.castka = 40000;
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(1);
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("45%");
                    Otazka8.this.up2.setText("31%");
                    Otazka8.this.up3.setText("23%");
                    Otazka8.this.up4.setText("1%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f162u4 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka8.this.f162u4.setEnabled(false);
                    Otazka8.this.f162u4.setVisibility(4);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up4.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Amber: Hi, I know for sure that he was born in Austria.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 15) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("During which part of the year is the Earth the closest to the Sun?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("SPRING");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("SUMMER");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("FALL");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("WINTER");
            this.castka = 40000;
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(4);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("12%");
                    Otazka8.this.up2.setText("42%");
                    Otazka8.this.up3.setText("8%");
                    Otazka8.this.up4.setText("38%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Nadya: Hi, it is the closest during winter.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 16) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which dictator was born in Switzerland?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("DONALD TRUMP");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("KIM CHONG UN");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("ADOLF HITLER");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("FRANCISCO FRANCO");
            this.castka = 40000;
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(2);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("1%");
                    Otazka8.this.up2.setText("39%");
                    Otazka8.this.up3.setText("41%");
                    Otazka8.this.up4.setText("19%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Lena: Hello, it was Kim Chong Un for sure.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 17) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Inner wall of artery is called?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("MYOCARDIUM");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("ENDOTHELIUM");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("ENTODERM");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("LUMEN");
            this.castka = 40000;
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(2);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("15%");
                    Otazka8.this.up2.setText("37%");
                    Otazka8.this.up3.setText("17%");
                    Otazka8.this.up4.setText("31%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Marty: Hey, I am pretty sure the correct answer is endothelium.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 18) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is knörr?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("SPINE COMPLAINT");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("VIKINGS SHIP");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("LARGE DRUM");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("KNOCK IN GERMAN");
            this.castka = 40000;
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(2);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("24%");
                    Otazka8.this.up2.setText("41%");
                    Otazka8.this.up3.setText("23%");
                    Otazka8.this.up4.setText("12%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Allie: Hello, I sadly have no idea.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 19) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these is not situated south of the equator?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("LESOTHO");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("BRUNEI");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("TIMOR");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("RWANDA");
            this.castka = 40000;
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(2);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("22%");
                    Otazka8.this.up2.setText("27%");
                    Otazka8.this.up3.setText("26%");
                    Otazka8.this.up4.setText("25%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f162u4 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka8.this.f162u4.setEnabled(false);
                    Otazka8.this.f162u4.setVisibility(4);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up4.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Harry: Hey, I honestly have no idea.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 20) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who wrote the novel Bel Ami?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("GUY DE MAUPASSANT");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("ÉMILE ZOLA");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("GUSTAV FLAUBERT");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("ALPHONSE DAUDET");
            this.castka = 40000;
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(1);
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("28%");
                    Otazka8.this.up2.setText("26%");
                    Otazka8.this.up3.setText("27%");
                    Otazka8.this.up4.setText("19%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.f162u4 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka8.this.f162u4.setEnabled(false);
                    Otazka8.this.f162u4.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up4.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Nathalie: Hi, it was Maupassant for sure.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 21) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("50°C is about?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("90 Fahrenheit");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("110 Fahrenheit");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("120 Fahrenheit");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("130 Fahrenheit");
            this.castka = 40000;
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(3);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("17%");
                    Otazka8.this.up2.setText("24%");
                    Otazka8.this.up3.setText("31%");
                    Otazka8.this.up4.setText("28%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f162u4 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka8.this.f162u4.setEnabled(false);
                    Otazka8.this.f162u4.setVisibility(4);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up4.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Michelle: Hello, it is either 120 or 130.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 22) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("WW1 ended during which month?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("AUGUST");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("SEPTEMBER");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("OCTOBER");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("NOVEMBER");
            this.castka = 40000;
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(4);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("22%");
                    Otazka8.this.up2.setText("27%");
                    Otazka8.this.up3.setText("18%");
                    Otazka8.this.up4.setText("33%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Randy: Hi, it is either november or september.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 23) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these is Marshall Bruce Mathers III.?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("50 CENT");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("MACKLEMORE");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("EMINEM");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("WIZ KHALIFA");
            this.castka = 40000;
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(3);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("27%");
                    Otazka8.this.up2.setText("28%");
                    Otazka8.this.up3.setText("28%");
                    Otazka8.this.up4.setText("17%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Joanne: Hey, I am sorry but I do not know.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 24) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Science about animals’s infectious diseases is named?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("ZOOTOXICOLOGY");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("CRYPTOZOOLOGY");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("GRADOLOGY");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("EPIZOOTIOLOGY");
            this.castka = 40000;
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(4);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("34%");
                    Otazka8.this.up2.setText("17%");
                    Otazka8.this.up3.setText("11%");
                    Otazka8.this.up4.setText("38%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Ryan: Hey. It is epizootiology.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 25) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these is not situated on the West Coast of USA?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("WASHINGTON");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("OREGON");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("CALIFORNIA");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("MONTANA");
            this.castka = 40000;
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(4);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("40%");
                    Otazka8.this.up2.setText("17%");
                    Otazka8.this.up3.setText("3%");
                    Otazka8.this.up4.setText("40%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Andrew: Hi, this one is pretty easy, it is Montana.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 26) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these elements does not exist?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("LUTETIUM");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("CALIFORNIUM");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("EINSTEINIUM");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("SKLODOWIUM");
            this.castka = 40000;
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(4);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("12%");
                    Otazka8.this.up2.setText("29%");
                    Otazka8.this.up3.setText("24%");
                    Otazka8.this.up4.setText("35%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Marshall: Hello, Sklodowium does not exist.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 27) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Blue colored mineral of aluminium is called?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("AMETHYST");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("SAPHIRE");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("AVANTURIN");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("MALACHITE");
            this.castka = 40000;
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(2);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("27%");
                    Otazka8.this.up2.setText("28%");
                    Otazka8.this.up3.setText("23%");
                    Otazka8.this.up4.setText("22%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Claire: Hi! I know it is saphire for sure.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 28) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these is know for bioluminiscence?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("CELLAR SPIDER");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("HUMAN");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("FIREFLY");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("FEMALE MOSQUITOS");
            this.castka = 40000;
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(3);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("25%");
                    Otazka8.this.up2.setText("22%");
                    Otazka8.this.up3.setText("28%");
                    Otazka8.this.up4.setText("25%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Thomas: Hello, the correct answer is firefly.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 29) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many lobes does left lung have?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("2");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("3");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("4");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("5");
            this.castka = 40000;
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(1);
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("43%");
                    Otazka8.this.up2.setText("40%");
                    Otazka8.this.up3.setText("14%");
                    Otazka8.this.up4.setText("3%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Gabe: Hi, not even I know this.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 30) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Thyroid cartilage can be found close to which one of these?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("SACRUM");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("LARYNX");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("LIVER");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("HEART");
            this.castka = 40000;
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(2);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("14%");
                    Otazka8.this.up2.setText("51%");
                    Otazka8.this.up3.setText("12%");
                    Otazka8.this.up4.setText("23%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.f162u4 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka8.this.f162u4.setEnabled(false);
                    Otazka8.this.f162u4.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up4.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Kate: Hello, it can be found near larynx.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 31) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What does the word pandemic mean?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("MASS ILLNESS");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("DESTRUCTION OF BACTERIES");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("INCUBATION PERIOD");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("DEATH CAUSED BY VIRAL INFECTION");
            this.castka = 40000;
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(1);
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("34%");
                    Otazka8.this.up2.setText("18%");
                    Otazka8.this.up3.setText("23%");
                    Otazka8.this.up4.setText("25%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.f162u4 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka8.this.f162u4.setEnabled(false);
                    Otazka8.this.f162u4.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up4.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Boris: Čau, to bohužel nevím.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 32) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("On which one of these flags can we find trapezoid?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("KUWAIT");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("SYRIA");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("JORDAN");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("EGYPT");
            this.castka = 40000;
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(1);
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("29%");
                    Otazka8.this.up2.setText("21%");
                    Otazka8.this.up3.setText("28%");
                    Otazka8.this.up4.setText("22%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f162u4 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka8.this.f162u4.setEnabled(false);
                    Otazka8.this.f162u4.setVisibility(4);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up4.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Lindsey: Hi, I do not know.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 33) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("On which river is the capital of Cambodia Phnompenh situated?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("MEKONG");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("BRAHMAPUTRA");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("GANGES");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("CHAO PHRAYA");
            this.castka = 40000;
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(1);
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("32%");
                    Otazka8.this.up2.setText("29%");
                    Otazka8.this.up3.setText("17%");
                    Otazka8.this.up4.setText("22%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.f162u4 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka8.this.f162u4.setEnabled(false);
                    Otazka8.this.f162u4.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up4.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Henry: Hi! The correct answer is Mekong!");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 34) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many Vertebrea thoracicae does human have?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("6");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("8");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("10");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("12");
            this.castka = 40000;
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(4);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("25%");
                    Otazka8.this.up2.setText("25%");
                    Otazka8.this.up3.setText("24%");
                    Otazka8.this.up4.setText("26%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Nathalie: Hi, the answer is definitely 12!");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 35) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How did Robinson Crusoe name his friend?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("THURSDAY");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("FRIDAY");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("SATURDAY");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("SUNDAY");
            this.castka = 40000;
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(2);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("35%");
                    Otazka8.this.up2.setText("35%");
                    Otazka8.this.up3.setText("18%");
                    Otazka8.this.up4.setText("12%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Will: Hey, I am sorry but I have no idea.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 36) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Larva stage of which animal is named amfiblastula?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("CLAMS");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("PLANARIAN");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("GASTROPOD");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("PARAZOA");
            this.castka = 40000;
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(4);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("29%");
                    Otazka8.this.up2.setText("10%");
                    Otazka8.this.up3.setText("27%");
                    Otazka8.this.up4.setText("34%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Dave: Hello, I do not know the correct answer.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 37) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which of these langugaes is the least used one?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("CHINESE");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("SPANISH");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("ENGLISH");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("FRENCH");
            this.castka = 40000;
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(4);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("17%");
                    Otazka8.this.up2.setText("32%");
                    Otazka8.this.up3.setText("18%");
                    Otazka8.this.up4.setText("33%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Jane: Hi, I guess it is French.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 38) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where is the seat of the company Apple?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("SACRAMENTO");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("NEW YORK");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("LOS ANGELES");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("CUPERTINO");
            this.castka = 40000;
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(4);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("28%");
                    Otazka8.this.up2.setText("20%");
                    Otazka8.this.up3.setText("23%");
                    Otazka8.this.up4.setText("29%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Nicky: Hi, I do not know either.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 39) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which programming language does Apple use?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("PHP");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("JAVA");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("SWIFT");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("PYTHON");
            this.castka = 40000;
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(3);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("22%");
                    Otazka8.this.up2.setText("23%");
                    Otazka8.this.up3.setText("28%");
                    Otazka8.this.up4.setText("27%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Vanda: Hello, it is Swift for sure!");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 40) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In area of which country can we find Lake Victoria?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("UGANDA");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("KENYA");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("RWANDA");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("TANZANIA");
            this.castka = 40000;
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(3);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("26%");
                    Otazka8.this.up2.setText("17%");
                    Otazka8.this.up3.setText("32%");
                    Otazka8.this.up4.setText("25%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f162u4 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka8.this.f162u4.setEnabled(false);
                    Otazka8.this.f162u4.setVisibility(4);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up4.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "John: Hi, I think it is Rwanda. I am not sure though.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 41) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these painter lost his ear?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("PABLO PICASSO");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("REMBRANDT VAN RIJN");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("VINCENT VAN GOGH");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("MICHELANGELO BUONAROTTI");
            this.castka = 40000;
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(3);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("18%");
                    Otazka8.this.up2.setText("28%");
                    Otazka8.this.up3.setText("29%");
                    Otazka8.this.up4.setText("25%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.f162u4 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka8.this.f162u4.setEnabled(false);
                    Otazka8.this.f162u4.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up4.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Debbie: Hey, I am sorry but I have no idea.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 42) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What is the name of the man who founded the company Ford?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("HENRY FORD");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("GEORGE FORD");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("RICHARD FORD");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("JAMES FORD");
            this.castka = 40000;
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(1);
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("28%");
                    Otazka8.this.up2.setText("23%");
                    Otazka8.this.up3.setText("22%");
                    Otazka8.this.up4.setText("27%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f162u4 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka8.this.f162u4.setEnabled(false);
                    Otazka8.this.f162u4.setVisibility(4);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setEnabled(false);
                    Otazka8.this.f161u3.setVisibility(4);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up4.setVisibility(4);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up3.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Bethanny: Hi, I am 100% sure it was Henry Ford!");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 43) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who is the biggest producer of olives in the world?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("MOROCCO");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("GREECE");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("SYRIA");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("SPAIN");
            this.castka = 40000;
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(4);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("14%");
                    Otazka8.this.up2.setText("29%");
                    Otazka8.this.up3.setText("14%");
                    Otazka8.this.up4.setText("43%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Connor: Hi, I know this one, it is Spain.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 44) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("A single AU (astronomical unit) is about?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("133 500 000 KM");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("187 500 000 KM");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("124 500 000 KM");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("149 500 000 KM");
            this.castka = 40000;
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(4);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("21%");
                    Otazka8.this.up2.setText("29%");
                    Otazka8.this.up3.setText("14%");
                    Otazka8.this.up4.setText("36%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Hailey: Hi, the correct answer is 149 500 000 KM.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 45) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who is the founder of the porn magazine Hustler?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("ANDY KAUFMAN");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("LARRY PAGE");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("DONALD TRUMP");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("LARRY FLYNT");
            this.castka = 40000;
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(4);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("26%");
                    Otazka8.this.up2.setText("29%");
                    Otazka8.this.up3.setText("4%");
                    Otazka8.this.up4.setText("41%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Richard: Hi, I am sorry but I do not know.");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 46) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What did John Williams become famous for?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("LITERATURE");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("CAR MANUFACTURING");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText("INVENTION OF SAXOPHONE");
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText("MOVIE MUSIC");
            this.castka = 40000;
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(4);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("26%");
                    Otazka8.this.up2.setText("24%");
                    Otazka8.this.up3.setText("9%");
                    Otazka8.this.up4.setText("41%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Richard: Hi, it is movie music for sure!");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        } else if (this.losovane == 46) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which year was the company Google founded?");
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setText("1992");
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setText("2000");
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setText(NativeAppInstallAd.ASSET_CALL_TO_ACTION);
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setText(NativeAppInstallAd.ASSET_STORE);
            this.castka = 40000;
            this.f162u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.Spravna(4);
                }
            });
            this.f159u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f160u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.f161u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.gameOver2(Otazka8.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka8.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unl.setEnabled(false);
                    Otazka8.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.up1.setText("9%");
                    Otazka8.this.up2.setText("24%");
                    Otazka8.this.up3.setText("26%");
                    Otazka8.this.up4.setText("41%");
                    Otazka8.this.pomocnapromenna8 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unp.setEnabled(false);
                    Otazka8.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setEnabled(false);
                    Otazka8.this.f159u1.setVisibility(4);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setEnabled(false);
                    Otazka8.this.f160u2.setVisibility(4);
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up1.setVisibility(4);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up2.setVisibility(4);
                    Otazka8.this.pomocnapromennap8 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka8.this.unt.setEnabled(false);
                    Otazka8.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka8.this);
                    builder.setMessage((CharSequence) "Richard: Hello, it was founded in 2005!");
                    builder.create().show();
                    Otazka8.this.pomocnapromennat8 = 1;
                }
            });
        }
        this.dvere = (Button) findViewById(C1760R.C1762id.dvere);
        this.dvere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Otazka8.this.castka = 40000;
                Otazka8.this.gameOver();
                if (Otazka8.this.castka > Otazka8.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                    Otazka8.this.highscore(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
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
        this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f159u1.setEnabled(false);
        this.f160u2.setEnabled(false);
        this.f161u3.setEnabled(false);
        this.f162u4.setEnabled(false);
        if (i != 0) {
            int parseColor = Color.parseColor("#ffaa00");
            this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
            this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
            this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
            this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
            if (i == 1) {
                this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f159u1.setTextColor(parseColor);
                this.f159u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up1.setTextColor(parseColor);
            } else if (i == 2) {
                this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f160u2.setTextColor(parseColor);
                this.f160u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up2.setTextColor(parseColor);
            } else if (i == 3) {
                this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f161u3.setTextColor(parseColor);
                this.f161u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up3.setTextColor(parseColor);
            } else if (i == 4) {
                this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f162u4.setTextColor(parseColor);
                this.f162u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up4.setTextColor(parseColor);
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    int parseColor = Color.parseColor("#fcff0202");
                    int parseColor2 = Color.parseColor("#1dc700");
                    Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                    Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                    Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                    Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f162u4 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f178u4);
                    if (i == 1) {
                        Otazka8.this.f159u1.setTextColor(parseColor);
                        Otazka8.this.f159u1.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka8.this.up1.setTextColor(parseColor);
                    } else if (i == 2) {
                        Otazka8.this.f160u2.setTextColor(parseColor);
                        Otazka8.this.f160u2.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka8.this.up2.setTextColor(parseColor);
                    } else if (i == 3) {
                        Otazka8.this.f161u3.setTextColor(parseColor);
                        Otazka8.this.f161u3.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka8.this.up3.setTextColor(parseColor);
                    } else if (i == 4) {
                        Otazka8.this.f162u4.setTextColor(parseColor);
                        Otazka8.this.f162u4.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka8.this.up4.setTextColor(parseColor);
                    }
                    if (i2 == 1) {
                        Otazka8.this.f159u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka8.this.f159u1.setTextColor(parseColor2);
                        Otazka8.this.up1.setTextColor(parseColor2);
                    } else if (i2 == 2) {
                        Otazka8.this.f160u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka8.this.f160u2.setTextColor(parseColor2);
                        Otazka8.this.up2.setTextColor(parseColor2);
                    } else if (i2 == 3) {
                        Otazka8.this.f161u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka8.this.f161u3.setTextColor(parseColor2);
                        Otazka8.this.up3.setTextColor(parseColor2);
                    } else if (i2 == 4) {
                        Otazka8.this.f162u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka8.this.f162u4.setTextColor(parseColor2);
                        Otazka8.this.up4.setTextColor(parseColor2);
                    }
                    Intent intent = new Intent(Otazka8.this, BackgroundSoundService.class);
                    intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                    Otazka8.this.stopService(intent);
                    Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka8.this).getBoolean("ZVUK", true));
                    Otazka8.this.spatna = MediaPlayer.create(Otazka8.this, C1760R.raw.spatna2);
                    if (z && valueOf.booleanValue()) {
                        Otazka8.this.spatna.start();
                    }
                }
            }, 1500);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Otazka8.this.alertDialog();
                    if (Otazka8.this.mInterstitialAd.isLoaded()) {
                        Otazka8.this.mInterstitialAd.show();
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
        this.castka = 5000;
        Intent intent2 = new Intent(this, PopActivity.class);
        intent2.putExtra("Level", this.level);
        intent2.putExtra("Castka", this.castka);
        intent2.putExtra("pomocnapromenna", this.pomocnapromenna8);
        intent2.putExtra("pomocnapromennap", this.pomocnapromennap8);
        intent2.putExtra("pomocnapromennat", this.pomocnapromennat8);
        startActivity(intent2);
        this.mCountDownTimer.cancel();
    }

    /* access modifiers changed from: private */
    public void Spravna(final int i) {
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_8", 0);
        int i2 = sharedPreferences.getInt("x", -1) + 1;
        SharedPreferences.Editor edit = getSharedPreferences("zodpovezene_8", 0).edit();
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
        this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f159u1.setEnabled(false);
        this.f160u2.setEnabled(false);
        this.f161u3.setEnabled(false);
        this.f162u4.setEnabled(false);
        if (i == 1) {
            this.f159u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f159u1.setTextColor(parseColor);
            this.f159u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up1.setTextColor(parseColor);
        } else if (i == 2) {
            this.f160u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f160u2.setTextColor(parseColor);
            this.f160u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up2.setTextColor(parseColor);
        } else if (i == 3) {
            this.f161u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f161u3.setTextColor(parseColor);
            this.f161u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up3.setTextColor(parseColor);
        } else {
            this.f162u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f162u4.setTextColor(parseColor);
            this.f162u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up4.setTextColor(parseColor);
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka8.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                Otazka8.this.stopService(intent);
                int parseColor = Color.parseColor("#1dc700");
                Otazka8.this.up1 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up1);
                Otazka8.this.up2 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up2);
                Otazka8.this.up3 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up3);
                Otazka8.this.up4 = (TextView) Otazka8.this.findViewById(C1760R.C1762id.up4);
                if (i == 1) {
                    Otazka8.this.f159u1 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka8.this.f159u1.setTextColor(parseColor);
                    Otazka8.this.f159u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka8.this.up1.setTextColor(parseColor);
                } else if (i == 2) {
                    Otazka8.this.f160u2 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka8.this.f160u2.setTextColor(parseColor);
                    Otazka8.this.f160u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka8.this.up2.setTextColor(parseColor);
                } else if (i == 3) {
                    Otazka8.this.f161u3 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka8.this.f161u3.setTextColor(parseColor);
                    Otazka8.this.f161u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka8.this.up3.setTextColor(parseColor);
                } else {
                    Otazka8.this.f162u4 = (Button) Otazka8.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka8.this.f162u4.setTextColor(parseColor);
                    Otazka8.this.f162u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka8.this.up4.setTextColor(parseColor);
                }
                if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka8.this).getBoolean("ZVUK", true)).booleanValue()) {
                    MediaPlayer.create(Otazka8.this, C1760R.raw.applause2).start();
                }
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka8.this, Otazka9.class);
                intent.putExtra("some_key8", Otazka8.this.pomocnapromenna8);
                intent.putExtra("some_keyp8", Otazka8.this.pomocnapromennap8);
                intent.putExtra("some_keyt8", Otazka8.this.pomocnapromennat8);
                Otazka8.this.startActivity(intent);
                CustomIntent.customType(Otazka8.this, "left-to-right");
            }
        }, 2500);
    }

    /* access modifiers changed from: private */
    public void highscore(int i) {
        if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true)).booleanValue()) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    MediaPlayer.create(Otazka8.this, C1760R.raw.applause7).start();
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
            Intent intent = new Intent(this, Otazka9.class);
            this.mCountDownTimer.cancel();
            intent.putExtra("some_key8", this.pomocnapromenna8);
            intent.putExtra("some_keyp8", this.pomocnapromennap8);
            intent.putExtra("some_keyt8", this.pomocnapromennat8);
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
            intent.putExtra("pomocnapromenna", this.pomocnapromenna8);
            intent.putExtra("pomocnapromennap", this.pomocnapromennap8);
            intent.putExtra("pomocnapromennat", this.pomocnapromennat8);
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
