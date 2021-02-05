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

public class Otazka12 extends AppCompatActivity implements RewardedVideoAdListener {
    private static boolean activityVisible;
    Button Zvuk;

    /* renamed from: a */
    final int f65a = 0;
    Button a12_1;
    ArrayList<Integer> arl = new ArrayList<>();

    /* renamed from: b */
    final int f66b = 0;
    Button b12_1;
    Button button;
    Button button11_1;
    Button buttonp11_1;
    Button buttont11_1;
    Button c12_1;
    int castka;
    Button d12_1;
    Button dvere;
    RadioGroup fuhrer1;
    boolean gameOver = false;

    /* renamed from: i */
    int f67i = 0;
    int[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    TextView label;
    int level = 12;
    int losovane;
    CountDownTimer mCountDownTimer;
    /* access modifiers changed from: private */
    public InterstitialAd mInterstitialAd;
    ProgressBar mProgressBar;
    private RewardedVideoAd mRewardedVideoAd;
    Button novahra;
    TextView oko_1;
    TextView oko_2;
    TextView oko_3;
    TextView oko_4;
    TextView otazka2;
    TextView otazkau;
    TextView otazkau500k;
    TextView otazkaza;
    int pomocnapromenna12;
    int pomocnapromennap12;
    int pomocnapromennat12;

    /* renamed from: r */
    Random f68r;
    RadioGroup radioGroupreky;
    TextView reky1chyba;
    MediaPlayer spatna;
    TextView textview13;
    TextView textview2;
    TextView textview3;
    TextView textview4;
    TextView textview5;
    TextView textview6;
    TextView textview7;
    TextView textview8;
    TextView textview9;

    /* renamed from: u1 */
    Button f69u1;

    /* renamed from: u2 */
    Button f70u2;

    /* renamed from: u3 */
    Button f71u3;

    /* renamed from: u4 */
    Button f72u4;
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
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_12", 0);
        int i = sharedPreferences.getInt("x", -1) + 1;
        System.out.println(i + "!!!!");
        SharedPreferences sharedPreferences2 = getSharedPreferences("zodpovezene_12", 0);
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
        this.f68r = new Random();
        this.castka = 0;
        if (this.arl.size() == 0) {
            sharedPreferences.edit().clear().commit();
            sharedPreferences2.edit().clear().commit();
            int i5 = getSharedPreferences("zodpovezene_12", 0).getInt("x", -1) + 1;
            System.out.println(i5 + "!!!!");
            SharedPreferences sharedPreferences3 = getSharedPreferences("zodpovezene_12", 0);
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
        this.losovane = this.f68r.nextInt(this.arl.size());
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
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(Otazka12.this);
                Boolean valueOf = Boolean.valueOf(defaultSharedPreferences.getBoolean("ZVUK", true));
                Intent intent = new Intent(Otazka12.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                if (valueOf.booleanValue()) {
                    SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                    edit.putBoolean("ZVUK", false);
                    edit.commit();
                    Otazka12.this.stopService(intent);
                    Otazka12.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukvypnuto);
                    return;
                }
                SharedPreferences.Editor edit2 = defaultSharedPreferences.edit();
                edit2.putBoolean("ZVUK", true);
                edit2.commit();
                Otazka12.this.startService(intent);
                Otazka12.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukzapnuto);
            }
        });
        this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f69u1.setTextColor(-1);
        this.f69u1.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f70u2.setTextColor(-1);
        this.f70u2.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f71u3.setTextColor(-1);
        this.f71u3.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f72u4.setTextColor(-1);
        this.f72u4.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
        this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
        this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
        this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
        this.up1.setTextColor(-1);
        this.up2.setTextColor(-1);
        this.up3.setTextColor(-1);
        this.up4.setTextColor(-1);
        this.textview6 = (TextView) findViewById(C1760R.C1762id.textView6);
        this.textview6.setTextColor(-1);
        this.otazkaza = (TextView) findViewById(C1760R.C1762id.otazkaza);
        this.otazkaza.setText("160 000$ Question");
        this.mProgressBar = (ProgressBar) findViewById(C1760R.C1762id.progressBar3);
        this.mProgressBar.setProgress(this.f67i);
        this.mCountDownTimer = new CountDownTimer(40000, 1000) {
            public void onTick(long j) {
                Log.v("Log_tag", "Tick of Progress" + Otazka12.this.f67i + j);
                Otazka12 otazka12 = Otazka12.this;
                otazka12.f67i = otazka12.f67i + 1;
                Otazka12.this.mProgressBar.setProgress((Otazka12.this.f67i * 100) / 40);
            }

            public void onFinish() {
                Otazka12.this.f67i++;
                Otazka12.this.mProgressBar.setProgress(100);
                Otazka12.this.uzivatelOdpovedel = false;
                Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 0, 0);
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
        int i9 = getIntent().getExtras().getInt("some_key11");
        int i10 = getIntent().getExtras().getInt("some_keyp11");
        if (getIntent().getExtras().getInt("some_keyt11") == 1) {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(false);
            this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
            this.pomocnapromennat12 = 1;
        } else {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(true);
        }
        if (i10 == 1) {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(false);
            this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
            this.pomocnapromennap12 = 1;
        } else {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(true);
        }
        if (i9 == 1) {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(false);
            this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
            this.pomocnapromenna12 = 1;
        } else {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(true);
        }
        this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f69u1.setEnabled(true);
        this.f70u2.setEnabled(true);
        this.f71u3.setEnabled(true);
        this.f72u4.setEnabled(true);
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
            this.otazkau.setText("Which one of these lakes is the smallest?");
            this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f69u1.setText("LAKE VICTORIA");
            this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f70u2.setText("LAKE BAIKAL");
            this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f71u3.setText("LAKE SUPERIOR");
            this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f72u4.setText("LAKE LADOGA");
            this.castka = 1000000;
            this.f72u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.Spravna(4);
                }
            });
            this.f69u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f70u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f71u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unl.setEnabled(false);
                    Otazka12.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up1.setText("24%");
                    Otazka12.this.up2.setText("23%");
                    Otazka12.this.up3.setText("26%");
                    Otazka12.this.up4.setText("27%");
                    Otazka12.this.pomocnapromenna12 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unp.setEnabled(false);
                    Otazka12.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka12.this.f70u2 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka12.this.f70u2.setEnabled(false);
                    Otazka12.this.f70u2.setVisibility(4);
                    Otazka12.this.f69u1 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka12.this.f69u1.setEnabled(false);
                    Otazka12.this.f69u1.setVisibility(4);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up2.setVisibility(4);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up1.setVisibility(4);
                    Otazka12.this.pomocnapromennap12 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unt.setEnabled(false);
                    Otazka12.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka12.this);
                    builder.setMessage((CharSequence) "Ramsay: Hello, I’m sorry but I have no idea.");
                    builder.create().show();
                    Otazka12.this.pomocnapromennat12 = 1;
                }
            });
        } else if (this.losovane == 2) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Quechua is spoken in?");
            this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f69u1.setText("NEPAL");
            this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f70u2.setText("PERU");
            this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f71u3.setText("GREENLAND");
            this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f72u4.setText("ETHIOPIA");
            this.castka = 1000000;
            this.f70u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.Spravna(2);
                }
            });
            this.f69u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f71u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f72u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unl.setEnabled(false);
                    Otazka12.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up1.setText("22%");
                    Otazka12.this.up2.setText("25%");
                    Otazka12.this.up3.setText("22%");
                    Otazka12.this.up4.setText("31%");
                    Otazka12.this.pomocnapromenna12 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unp.setEnabled(false);
                    Otazka12.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka12.this.f71u3 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka12.this.f71u3.setEnabled(false);
                    Otazka12.this.f71u3.setVisibility(4);
                    Otazka12.this.f72u4 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka12.this.f72u4.setEnabled(false);
                    Otazka12.this.f72u4.setVisibility(4);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up3.setVisibility(4);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up4.setVisibility(4);
                    Otazka12.this.pomocnapromennap12 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unt.setEnabled(false);
                    Otazka12.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka12.this);
                    builder.setMessage((CharSequence) "Michael: Hey, sorry but I don’t know.");
                    builder.create().show();
                    Otazka12.this.pomocnapromennat12 = 1;
                }
            });
        } else if (this.losovane == 3) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these units is named after an Italian noble?");
            this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f69u1.setText("PASCAL");
            this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f70u2.setText("VOLT");
            this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f71u3.setText("HERTZ");
            this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f72u4.setText("OHM");
            this.castka = 1000000;
            this.f70u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.Spravna(2);
                }
            });
            this.f69u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f71u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f72u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unl.setEnabled(false);
                    Otazka12.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up1.setText("29%");
                    Otazka12.this.up2.setText("33%");
                    Otazka12.this.up3.setText("18%");
                    Otazka12.this.up4.setText("20%");
                    Otazka12.this.pomocnapromenna12 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unp.setEnabled(false);
                    Otazka12.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka12.this.f71u3 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka12.this.f71u3.setEnabled(false);
                    Otazka12.this.f71u3.setVisibility(4);
                    Otazka12.this.f72u4 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka12.this.f72u4.setEnabled(false);
                    Otazka12.this.f72u4.setVisibility(4);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up3.setVisibility(4);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up4.setVisibility(4);
                    Otazka12.this.pomocnapromennap12 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unt.setEnabled(false);
                    Otazka12.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka12.this);
                    builder.setMessage((CharSequence) "Marry: Hi, it’s either Volt or Pascal.");
                    builder.create().show();
                    Otazka12.this.pomocnapromennat12 = 1;
                }
            });
        } else if (this.losovane == 4) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many letters does Spanish alphabet have?");
            this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f69u1.setText("26");
            this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f70u2.setText("27");
            this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f71u3.setText("28");
            this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f72u4.setText("29");
            this.castka = 1000000;
            this.f70u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.Spravna(2);
                }
            });
            this.f69u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f71u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f72u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unl.setEnabled(false);
                    Otazka12.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up1.setText("22%");
                    Otazka12.this.up2.setText("25%");
                    Otazka12.this.up3.setText("25%");
                    Otazka12.this.up4.setText("28%");
                    Otazka12.this.pomocnapromenna12 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unp.setEnabled(false);
                    Otazka12.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka12.this.f71u3 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka12.this.f71u3.setEnabled(false);
                    Otazka12.this.f71u3.setVisibility(4);
                    Otazka12.this.f69u1 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka12.this.f69u1.setEnabled(false);
                    Otazka12.this.f69u1.setVisibility(4);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up3.setVisibility(4);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up1.setVisibility(4);
                    Otazka12.this.pomocnapromennap12 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unt.setEnabled(false);
                    Otazka12.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka12.this);
                    builder.setMessage((CharSequence) "Ronald: Hi, it’s 26 for sure.");
                    builder.create().show();
                    Otazka12.this.pomocnapromennat12 = 1;
                }
            });
        } else if (this.losovane == 5) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("The Bible was not originally written in which one of these languages?");
            this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f69u1.setText("ARAMAIC");
            this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f70u2.setText("LATIN");
            this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f71u3.setText("GREEK");
            this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f72u4.setText("HEBREW");
            this.castka = 1000000;
            this.f70u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.Spravna(2);
                }
            });
            this.f69u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f71u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f72u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unl.setEnabled(false);
                    Otazka12.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up1.setText("25%");
                    Otazka12.this.up2.setText("21%");
                    Otazka12.this.up3.setText("28%");
                    Otazka12.this.up4.setText("26%");
                    Otazka12.this.pomocnapromenna12 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unp.setEnabled(false);
                    Otazka12.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka12.this.f69u1 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka12.this.f69u1.setEnabled(false);
                    Otazka12.this.f69u1.setVisibility(4);
                    Otazka12.this.f72u4 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka12.this.f72u4.setEnabled(false);
                    Otazka12.this.f72u4.setVisibility(4);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up1.setVisibility(4);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up4.setVisibility(4);
                    Otazka12.this.pomocnapromennap12 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unt.setEnabled(false);
                    Otazka12.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka12.this);
                    builder.setMessage((CharSequence) "Sasha: Hello, I don’t know.");
                    builder.create().show();
                    Otazka12.this.pomocnapromennat12 = 1;
                }
            });
        } else if (this.losovane == 6) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Albert Einstein was born in which one of these cities?");
            this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f69u1.setText("ULM");
            this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f70u2.setText("REUTLINGEN");
            this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f71u3.setText("AUGSBURG");
            this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f72u4.setText("WÜRZBURG");
            this.castka = 1000000;
            this.f69u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.Spravna(1);
                }
            });
            this.f70u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f71u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f72u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unl.setEnabled(false);
                    Otazka12.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up1.setText("28%");
                    Otazka12.this.up2.setText("25%");
                    Otazka12.this.up3.setText("24%");
                    Otazka12.this.up4.setText("23%");
                    Otazka12.this.pomocnapromenna12 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unp.setEnabled(false);
                    Otazka12.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka12.this.f71u3 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka12.this.f71u3.setEnabled(false);
                    Otazka12.this.f71u3.setVisibility(4);
                    Otazka12.this.f72u4 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka12.this.f72u4.setEnabled(false);
                    Otazka12.this.f72u4.setVisibility(4);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up3.setVisibility(4);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up4.setVisibility(4);
                    Otazka12.this.pomocnapromennap12 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unt.setEnabled(false);
                    Otazka12.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka12.this);
                    builder.setMessage((CharSequence) "Andrew: Hey, sorry but I have no idea.");
                    builder.create().show();
                    Otazka12.this.pomocnapromennat12 = 1;
                }
            });
        } else if (this.losovane == 7) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Battle of Salamis was won by?");
            this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f69u1.setText("PERSIA");
            this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f70u2.setText("GREECE");
            this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f71u3.setText("OTTOMAN EMPIRE");
            this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f72u4.setText("ROME");
            this.castka = 1000000;
            this.f70u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.Spravna(2);
                }
            });
            this.f69u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f71u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f72u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unl.setEnabled(false);
                    Otazka12.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up1.setText("30%");
                    Otazka12.this.up2.setText("31%");
                    Otazka12.this.up3.setText("22%");
                    Otazka12.this.up4.setText("17%");
                    Otazka12.this.pomocnapromenna12 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unp.setEnabled(false);
                    Otazka12.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka12.this.f71u3 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka12.this.f71u3.setEnabled(false);
                    Otazka12.this.f71u3.setVisibility(4);
                    Otazka12.this.f69u1 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka12.this.f69u1.setEnabled(false);
                    Otazka12.this.f69u1.setVisibility(4);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up3.setVisibility(4);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up1.setVisibility(4);
                    Otazka12.this.pomocnapromennap12 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unt.setEnabled(false);
                    Otazka12.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka12.this);
                    builder.setMessage((CharSequence) "Janna: Hi, Greece won for sure.");
                    builder.create().show();
                    Otazka12.this.pomocnapromennat12 = 1;
                }
            });
        } else if (this.losovane == 8) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which team did not participate in the semifinals of the 2010 World Hockey Championship?");
            this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f69u1.setText("CZECH REPUBLIC");
            this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f70u2.setText("SWEDEN");
            this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f71u3.setText("GERMANY");
            this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f72u4.setText("FINLAND");
            this.castka = 1000000;
            this.f72u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.Spravna(4);
                }
            });
            this.f69u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f70u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f71u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unl.setEnabled(false);
                    Otazka12.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up1.setText("4%");
                    Otazka12.this.up2.setText("29%");
                    Otazka12.this.up3.setText("35%");
                    Otazka12.this.up4.setText("32%");
                    Otazka12.this.pomocnapromenna12 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unp.setEnabled(false);
                    Otazka12.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka12.this.f70u2 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka12.this.f70u2.setEnabled(false);
                    Otazka12.this.f70u2.setVisibility(4);
                    Otazka12.this.f69u1 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka12.this.f69u1.setEnabled(false);
                    Otazka12.this.f69u1.setVisibility(4);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up2.setVisibility(4);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up1.setVisibility(4);
                    Otazka12.this.pomocnapromennap12 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unt.setEnabled(false);
                    Otazka12.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka12.this);
                    builder.setMessage((CharSequence) "Martin: Hey, the correct answer is either Sweden or Finland.");
                    builder.create().show();
                    Otazka12.this.pomocnapromennat12 = 1;
                }
            });
        } else if (this.losovane == 9) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Abuja is the capital of?");
            this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f69u1.setText("NIGERIA");
            this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f70u2.setText("GABON");
            this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f71u3.setText("CAMEROON");
            this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f72u4.setText("CONGO");
            this.castka = 1000000;
            this.f69u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.Spravna(1);
                }
            });
            this.f70u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f71u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f72u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unl.setEnabled(false);
                    Otazka12.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up1.setText("27%");
                    Otazka12.this.up2.setText("25%");
                    Otazka12.this.up3.setText("27%");
                    Otazka12.this.up4.setText("21%");
                    Otazka12.this.pomocnapromenna12 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unp.setEnabled(false);
                    Otazka12.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka12.this.f70u2 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka12.this.f70u2.setEnabled(false);
                    Otazka12.this.f70u2.setVisibility(4);
                    Otazka12.this.f71u3 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka12.this.f71u3.setEnabled(false);
                    Otazka12.this.f71u3.setVisibility(4);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up2.setVisibility(4);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up3.setVisibility(4);
                    Otazka12.this.pomocnapromennap12 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unt.setEnabled(false);
                    Otazka12.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka12.this);
                    builder.setMessage((CharSequence) "Thomas: Hi, Abuja is the capital of Nigeria!");
                    builder.create().show();
                    Otazka12.this.pomocnapromennat12 = 1;
                }
            });
        } else if (this.losovane == 10) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("John F. Kennedy was assassinated in which city?");
            this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f69u1.setText("DALLAS");
            this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f70u2.setText("HOUSTON");
            this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f71u3.setText("BOSTON");
            this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f72u4.setText("DETROIT");
            this.castka = 1000000;
            this.f69u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.Spravna(1);
                }
            });
            this.f70u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f71u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f72u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unl.setEnabled(false);
                    Otazka12.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up1.setText("29%");
                    Otazka12.this.up2.setText("28%");
                    Otazka12.this.up3.setText("26%");
                    Otazka12.this.up4.setText("17%");
                    Otazka12.this.pomocnapromenna12 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unp.setEnabled(false);
                    Otazka12.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka12.this.f72u4 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka12.this.f72u4.setEnabled(false);
                    Otazka12.this.f72u4.setVisibility(4);
                    Otazka12.this.f70u2 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka12.this.f70u2.setEnabled(false);
                    Otazka12.this.f70u2.setVisibility(4);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up4.setVisibility(4);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up2.setVisibility(4);
                    Otazka12.this.pomocnapromennap12 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unt.setEnabled(false);
                    Otazka12.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka12.this);
                    builder.setMessage((CharSequence) "Boris: Hello, sorry but I can’t help you.");
                    builder.create().show();
                    Otazka12.this.pomocnapromennat12 = 1;
                }
            });
        } else if (this.losovane == 11) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these football players is not Croatian?");
            this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f69u1.setText("MILORAD MRDAK");
            this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f70u2.setText("DAVOR ŠUKER");
            this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f71u3.setText("DADO PRŠO");
            this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f72u4.setText("DARIJO SRNA");
            this.castka = 1000000;
            this.f69u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.Spravna(1);
                }
            });
            this.f70u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f71u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f72u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unl.setEnabled(false);
                    Otazka12.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up1.setText("26%");
                    Otazka12.this.up2.setText("22%");
                    Otazka12.this.up3.setText("27%");
                    Otazka12.this.up4.setText("25%");
                    Otazka12.this.pomocnapromenna12 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unp.setEnabled(false);
                    Otazka12.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka12.this.f70u2 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka12.this.f70u2.setEnabled(false);
                    Otazka12.this.f70u2.setVisibility(4);
                    Otazka12.this.f72u4 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka12.this.f72u4.setEnabled(false);
                    Otazka12.this.f72u4.setVisibility(4);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up2.setVisibility(4);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up4.setVisibility(4);
                    Otazka12.this.pomocnapromennap12 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unt.setEnabled(false);
                    Otazka12.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka12.this);
                    builder.setMessage((CharSequence) "Vince: Hi, sorry but I don’t know.");
                    builder.create().show();
                    Otazka12.this.pomocnapromennat12 = 1;
                }
            });
        } else if (this.losovane == 12) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these is mined in the mine Chuquicamata?");
            this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f69u1.setText("COPPER");
            this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f70u2.setText("SILVER");
            this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f71u3.setText("GOLD");
            this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f72u4.setText("DIAMONDS");
            this.castka = 1000000;
            this.f69u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.Spravna(1);
                }
            });
            this.f70u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f71u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f72u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unl.setEnabled(false);
                    Otazka12.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up1.setText("27%");
                    Otazka12.this.up2.setText("23%");
                    Otazka12.this.up3.setText("23%");
                    Otazka12.this.up4.setText("27%");
                    Otazka12.this.pomocnapromenna12 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unp.setEnabled(false);
                    Otazka12.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka12.this.f72u4 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka12.this.f72u4.setEnabled(false);
                    Otazka12.this.f72u4.setVisibility(4);
                    Otazka12.this.f70u2 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka12.this.f70u2.setEnabled(false);
                    Otazka12.this.f70u2.setVisibility(4);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up4.setVisibility(4);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up2.setVisibility(4);
                    Otazka12.this.pomocnapromennap12 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unt.setEnabled(false);
                    Otazka12.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka12.this);
                    builder.setMessage((CharSequence) "Renley: Hi, I unfortunately have no idea..");
                    builder.create().show();
                    Otazka12.this.pomocnapromennat12 = 1;
                }
            });
        } else if (this.losovane == 13) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many Oscars does the composer Ennio Morricone have so far?");
            this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f69u1.setText("2");
            this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f70u2.setText("4");
            this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f71u3.setText("1");
            this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f72u4.setText("3");
            this.castka = 1000000;
            this.f69u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.Spravna(1);
                }
            });
            this.f70u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f71u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f72u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unl.setEnabled(false);
                    Otazka12.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up1.setText("27%");
                    Otazka12.this.up2.setText("23%");
                    Otazka12.this.up3.setText("23%");
                    Otazka12.this.up4.setText("27%");
                    Otazka12.this.pomocnapromenna12 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unp.setEnabled(false);
                    Otazka12.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka12.this.f72u4 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka12.this.f72u4.setEnabled(false);
                    Otazka12.this.f72u4.setVisibility(4);
                    Otazka12.this.f70u2 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka12.this.f70u2.setEnabled(false);
                    Otazka12.this.f70u2.setVisibility(4);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up4.setVisibility(4);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up2.setVisibility(4);
                    Otazka12.this.pomocnapromennap12 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unt.setEnabled(false);
                    Otazka12.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka12.this);
                    builder.setMessage((CharSequence) "John: Hello, sorry but I have no idea.");
                    builder.create().show();
                    Otazka12.this.pomocnapromennat12 = 1;
                }
            });
        } else if (this.losovane == 14) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these did not star in the movie “Dunkirk”?");
            this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f69u1.setText("TOM HARDY");
            this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f70u2.setText("CHRISTIAN BALE");
            this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f71u3.setText("MARK RYLANCE");
            this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f72u4.setText("AUNERIN BANARD");
            this.castka = 1000000;
            this.f70u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.Spravna(2);
                }
            });
            this.f69u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f71u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f72u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unl.setEnabled(false);
                    Otazka12.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up1.setText("20%");
                    Otazka12.this.up2.setText("32%");
                    Otazka12.this.up3.setText("21%");
                    Otazka12.this.up4.setText("27%");
                    Otazka12.this.pomocnapromenna12 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unp.setEnabled(false);
                    Otazka12.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka12.this.f69u1 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka12.this.f69u1.setEnabled(false);
                    Otazka12.this.f69u1.setVisibility(4);
                    Otazka12.this.f71u3 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka12.this.f71u3.setEnabled(false);
                    Otazka12.this.f71u3.setVisibility(4);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up1.setVisibility(4);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up3.setVisibility(4);
                    Otazka12.this.pomocnapromennap12 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unt.setEnabled(false);
                    Otazka12.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka12.this);
                    builder.setMessage((CharSequence) "Sonya: Hi, I think the correct answer is Christian Bale, I’m not sure though.");
                    builder.create().show();
                    Otazka12.this.pomocnapromennat12 = 1;
                }
            });
        } else if (this.losovane == 15) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who composed the music for movies such as “The Shawshank Redemption” or “The Green Mile”?");
            this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f69u1.setText("ENNIO MORRICONE");
            this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f70u2.setText("HANS ZIMMER");
            this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f71u3.setText("THOMAS NEWMAN");
            this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f72u4.setText("HOWARD SHORE");
            this.castka = 1000000;
            this.f71u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.Spravna(3);
                }
            });
            this.f69u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f70u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f72u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unl.setEnabled(false);
                    Otazka12.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up1.setText("24%");
                    Otazka12.this.up2.setText("23%");
                    Otazka12.this.up3.setText("30%");
                    Otazka12.this.up4.setText("23%");
                    Otazka12.this.pomocnapromenna12 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unp.setEnabled(false);
                    Otazka12.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka12.this.f70u2 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka12.this.f70u2.setEnabled(false);
                    Otazka12.this.f70u2.setVisibility(4);
                    Otazka12.this.f69u1 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka12.this.f69u1.setEnabled(false);
                    Otazka12.this.f69u1.setVisibility(4);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up2.setVisibility(4);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up1.setVisibility(4);
                    Otazka12.this.pomocnapromennap12 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unt.setEnabled(false);
                    Otazka12.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka12.this);
                    builder.setMessage((CharSequence) "Maria: Hi, I’m sorry but I don’t know.");
                    builder.create().show();
                    Otazka12.this.pomocnapromennat12 = 1;
                }
            });
        } else if (this.losovane == 16) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("One of the main gold-mining Australian cities is named?");
            this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f69u1.setText("LEONORA");
            this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f70u2.setText("MOUNT MAGNET");
            this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f71u3.setText("KALGOORLIA");
            this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f72u4.setText("LASBOK");
            this.castka = 1000000;
            this.f71u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.Spravna(3);
                }
            });
            this.f69u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f70u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.f72u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.gameOver2(Otazka12.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka12.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unl.setEnabled(false);
                    Otazka12.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.up1.setText("24%");
                    Otazka12.this.up2.setText("23%");
                    Otazka12.this.up3.setText("30%");
                    Otazka12.this.up4.setText("23%");
                    Otazka12.this.pomocnapromenna12 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unp.setEnabled(false);
                    Otazka12.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka12.this.f70u2 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka12.this.f70u2.setEnabled(false);
                    Otazka12.this.f70u2.setVisibility(4);
                    Otazka12.this.f69u1 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka12.this.f69u1.setEnabled(false);
                    Otazka12.this.f69u1.setVisibility(4);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up2.setVisibility(4);
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up1.setVisibility(4);
                    Otazka12.this.pomocnapromennap12 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka12.this.unt.setEnabled(false);
                    Otazka12.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka12.this);
                    builder.setMessage((CharSequence) "Maya: Hey, it’s Kalgoorlia for sure.");
                    builder.create().show();
                    Otazka12.this.pomocnapromennat12 = 1;
                }
            });
        }
        this.dvere = (Button) findViewById(C1760R.C1762id.dvere);
        this.dvere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Otazka12.this.castka = 1000000;
                Otazka12.this.gameOver();
                if (Otazka12.this.castka > Otazka12.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                    Otazka12.this.highscore(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
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
        this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f69u1.setEnabled(false);
        this.f70u2.setEnabled(false);
        this.f71u3.setEnabled(false);
        this.f72u4.setEnabled(false);
        if (i != 0) {
            int parseColor = Color.parseColor("#ffaa00");
            this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
            this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
            this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
            this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
            if (i == 1) {
                this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f69u1.setTextColor(parseColor);
                this.f69u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up1.setTextColor(parseColor);
            } else if (i == 2) {
                this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f70u2.setTextColor(parseColor);
                this.f70u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up2.setTextColor(parseColor);
            } else if (i == 3) {
                this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f71u3.setTextColor(parseColor);
                this.f71u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up3.setTextColor(parseColor);
            } else if (i == 4) {
                this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f72u4.setTextColor(parseColor);
                this.f72u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up4.setTextColor(parseColor);
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    int parseColor = Color.parseColor("#fcff0202");
                    int parseColor2 = Color.parseColor("#1dc700");
                    Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                    Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                    Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                    Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                    Otazka12.this.f69u1 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka12.this.f70u2 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka12.this.f71u3 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka12.this.f72u4 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f178u4);
                    if (i == 1) {
                        Otazka12.this.f69u1.setTextColor(parseColor);
                        Otazka12.this.f69u1.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka12.this.up1.setTextColor(parseColor);
                    } else if (i == 2) {
                        Otazka12.this.f70u2.setTextColor(parseColor);
                        Otazka12.this.f70u2.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka12.this.up2.setTextColor(parseColor);
                    } else if (i == 3) {
                        Otazka12.this.f71u3.setTextColor(parseColor);
                        Otazka12.this.f71u3.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka12.this.up3.setTextColor(parseColor);
                    } else if (i == 4) {
                        Otazka12.this.f72u4.setTextColor(parseColor);
                        Otazka12.this.f72u4.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka12.this.up4.setTextColor(parseColor);
                    }
                    if (i2 == 1) {
                        Otazka12.this.f69u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka12.this.f69u1.setTextColor(parseColor2);
                        Otazka12.this.up1.setTextColor(parseColor2);
                    } else if (i2 == 2) {
                        Otazka12.this.f70u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka12.this.f70u2.setTextColor(parseColor2);
                        Otazka12.this.up2.setTextColor(parseColor2);
                    } else if (i2 == 3) {
                        Otazka12.this.f71u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka12.this.f71u3.setTextColor(parseColor2);
                        Otazka12.this.up3.setTextColor(parseColor2);
                    } else if (i2 == 4) {
                        Otazka12.this.f72u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka12.this.f72u4.setTextColor(parseColor2);
                        Otazka12.this.up4.setTextColor(parseColor2);
                    }
                    Intent intent = new Intent(Otazka12.this, BackgroundSoundService.class);
                    intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                    Otazka12.this.stopService(intent);
                    Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka12.this).getBoolean("ZVUK", true));
                    Otazka12.this.spatna = MediaPlayer.create(Otazka12.this, C1760R.raw.spatna2);
                    if (z && valueOf.booleanValue()) {
                        Otazka12.this.spatna.start();
                    }
                }
            }, 1500);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Otazka12.this.alertDialog();
                    if (Otazka12.this.mInterstitialAd.isLoaded()) {
                        Otazka12.this.mInterstitialAd.show();
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
        this.castka = 80000;
        Intent intent2 = new Intent(this, PopActivity.class);
        intent2.putExtra("Level", this.level);
        intent2.putExtra("Castka", this.castka);
        intent2.putExtra("pomocnapromenna", this.pomocnapromenna12);
        intent2.putExtra("pomocnapromennap", this.pomocnapromennap12);
        intent2.putExtra("pomocnapromennat", this.pomocnapromennat12);
        startActivity(intent2);
        this.mCountDownTimer.cancel();
    }

    /* access modifiers changed from: private */
    public void Spravna(final int i) {
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_12", 0);
        int i2 = sharedPreferences.getInt("x", -1) + 1;
        SharedPreferences.Editor edit = getSharedPreferences("zodpovezene_12", 0).edit();
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
        this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f69u1.setEnabled(false);
        this.f70u2.setEnabled(false);
        this.f71u3.setEnabled(false);
        this.f72u4.setEnabled(false);
        if (i == 1) {
            this.f69u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f69u1.setTextColor(parseColor);
            this.f69u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up1.setTextColor(parseColor);
        } else if (i == 2) {
            this.f70u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f70u2.setTextColor(parseColor);
            this.f70u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up2.setTextColor(parseColor);
        } else if (i == 3) {
            this.f71u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f71u3.setTextColor(parseColor);
            this.f71u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up3.setTextColor(parseColor);
        } else {
            this.f72u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f72u4.setTextColor(parseColor);
            this.f72u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up4.setTextColor(parseColor);
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka12.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                Otazka12.this.stopService(intent);
                int parseColor = Color.parseColor("#1dc700");
                Otazka12.this.up1 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up1);
                Otazka12.this.up2 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up2);
                Otazka12.this.up3 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up3);
                Otazka12.this.up4 = (TextView) Otazka12.this.findViewById(C1760R.C1762id.up4);
                if (i == 1) {
                    Otazka12.this.f69u1 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka12.this.f69u1.setTextColor(parseColor);
                    Otazka12.this.f69u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka12.this.up1.setTextColor(parseColor);
                } else if (i == 2) {
                    Otazka12.this.f70u2 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka12.this.f70u2.setTextColor(parseColor);
                    Otazka12.this.f70u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka12.this.up2.setTextColor(parseColor);
                } else if (i == 3) {
                    Otazka12.this.f71u3 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka12.this.f71u3.setTextColor(parseColor);
                    Otazka12.this.f71u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka12.this.up3.setTextColor(parseColor);
                } else {
                    Otazka12.this.f72u4 = (Button) Otazka12.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka12.this.f72u4.setTextColor(parseColor);
                    Otazka12.this.f72u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka12.this.up4.setTextColor(parseColor);
                }
                if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka12.this).getBoolean("ZVUK", true)).booleanValue()) {
                    MediaPlayer.create(Otazka12.this, C1760R.raw.applause2).start();
                }
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka12.this, Otazka13.class);
                intent.putExtra("some_key12", Otazka12.this.pomocnapromenna12);
                intent.putExtra("some_keyp12", Otazka12.this.pomocnapromennap12);
                intent.putExtra("some_keyt12", Otazka12.this.pomocnapromennat12);
                Otazka12.this.startActivity(intent);
                CustomIntent.customType(Otazka12.this, "left-to-right");
            }
        }, 2500);
    }

    /* access modifiers changed from: private */
    public void highscore(int i) {
        if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true)).booleanValue()) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    MediaPlayer.create(Otazka12.this, C1760R.raw.applause7).start();
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
            Intent intent = new Intent(this, Otazka13.class);
            this.mCountDownTimer.cancel();
            intent.putExtra("some_key12", this.pomocnapromenna12);
            intent.putExtra("some_keyp12", this.pomocnapromennap12);
            intent.putExtra("some_keyt12", this.pomocnapromennat12);
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
            intent.putExtra("pomocnapromenna", this.pomocnapromenna12);
            intent.putExtra("pomocnapromennap", this.pomocnapromennap12);
            intent.putExtra("pomocnapromennat", this.pomocnapromennat12);
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
