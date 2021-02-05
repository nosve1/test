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

public class Otazka10 extends AppCompatActivity implements RewardedVideoAdListener {
    private static boolean activityVisible;
    Button Zvuk;

    /* renamed from: a */
    final int f44a = 0;

    /* renamed from: a8 */
    Button f45a8;
    ArrayList<Integer> arl = new ArrayList<>();

    /* renamed from: b */
    final int f46b = 0;

    /* renamed from: b8 */
    Button f47b8;
    Button b8p;
    Button button;
    Button button9_1;
    Button buttonp9_1;
    Button buttont9_1;

    /* renamed from: c8 */
    Button f48c8;
    int castka;

    /* renamed from: d8 */
    Button f49d8;
    Button d8p;
    Button dvere;
    RadioGroup fuhrer1;
    boolean gameOver = false;

    /* renamed from: i */
    int f50i = 0;
    int[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23};
    TextView label;
    int level = 10;
    TextView lkriz_1;
    TextView lkriz_2;
    TextView lkriz_3;
    TextView lkriz_4;
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
    int pomocnapromenna10;
    int pomocnapromennap10;
    int pomocnapromennat10;

    /* renamed from: r */
    Random f51r;
    RadioGroup radioGroupreky;
    TextView reky1chyba;
    MediaPlayer spatna;
    TextView textview11;
    TextView textview2;
    TextView textview3;
    TextView textview4;
    TextView textview5;
    TextView textview6;
    TextView textview7;
    TextView textview8;
    TextView textview9;

    /* renamed from: u1 */
    Button f52u1;

    /* renamed from: u2 */
    Button f53u2;

    /* renamed from: u3 */
    Button f54u3;

    /* renamed from: u4 */
    Button f55u4;
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
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_10", 0);
        int i = sharedPreferences.getInt("x", -1) + 1;
        System.out.println(i + "!!!!");
        SharedPreferences sharedPreferences2 = getSharedPreferences("zodpovezene_10", 0);
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
        this.f51r = new Random();
        this.castka = 0;
        if (this.arl.size() == 0) {
            sharedPreferences.edit().clear().commit();
            sharedPreferences2.edit().clear().commit();
            int i5 = getSharedPreferences("zodpovezene_10", 0).getInt("x", -1) + 1;
            System.out.println(i5 + "!!!!");
            SharedPreferences sharedPreferences3 = getSharedPreferences("zodpovezene_10", 0);
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
        this.losovane = this.f51r.nextInt(this.arl.size());
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
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(Otazka10.this);
                Boolean valueOf = Boolean.valueOf(defaultSharedPreferences.getBoolean("ZVUK", true));
                Intent intent = new Intent(Otazka10.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                if (valueOf.booleanValue()) {
                    SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                    edit.putBoolean("ZVUK", false);
                    edit.commit();
                    Otazka10.this.stopService(intent);
                    Otazka10.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukvypnuto);
                    return;
                }
                SharedPreferences.Editor edit2 = defaultSharedPreferences.edit();
                edit2.putBoolean("ZVUK", true);
                edit2.commit();
                Otazka10.this.startService(intent);
                Otazka10.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukzapnuto);
            }
        });
        this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f52u1.setTextColor(-1);
        this.f52u1.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f53u2.setTextColor(-1);
        this.f53u2.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f54u3.setTextColor(-1);
        this.f54u3.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f55u4.setTextColor(-1);
        this.f55u4.setBackgroundResource(C1760R.C1761drawable.button_bg);
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
        this.textview2.setText("5K");
        this.textview3 = (TextView) findViewById(C1760R.C1762id.textView3);
        this.textview3.setText("10K");
        this.textview4 = (TextView) findViewById(C1760R.C1762id.textView4);
        this.textview4.setText("20K");
        this.textview4.setBackgroundResource(C1760R.C1761drawable.textview2);
        this.textview4.setTypeface(Typeface.DEFAULT_BOLD);
        this.textview5 = (TextView) findViewById(C1760R.C1762id.textView5);
        this.textview5.setText("40K");
        this.textview5.setBackgroundResource(C1760R.C1761drawable.textview);
        this.textview5.setTypeface(Typeface.DEFAULT);
        this.textview6 = (TextView) findViewById(C1760R.C1762id.textView6);
        this.textview6.setText("80K");
        this.textview6.setBackgroundResource(C1760R.C1761drawable.textview);
        this.textview6.setTypeface(Typeface.DEFAULT);
        this.textview7 = (TextView) findViewById(C1760R.C1762id.textView7);
        this.textview7.setText("160K");
        this.textview8 = (TextView) findViewById(C1760R.C1762id.textView8);
        this.textview8.setText("500K");
        this.otazkaza = (TextView) findViewById(C1760R.C1762id.otazkaza);
        this.otazkaza.setText("40 000$ Question");
        this.mProgressBar = (ProgressBar) findViewById(C1760R.C1762id.progressBar3);
        this.mProgressBar.setProgress(this.f50i);
        this.mCountDownTimer = new CountDownTimer(40000, 1000) {
            public void onTick(long j) {
                Log.v("Log_tag", "Tick of Progress" + Otazka10.this.f50i + j);
                Otazka10 otazka10 = Otazka10.this;
                otazka10.f50i = otazka10.f50i + 1;
                Otazka10.this.mProgressBar.setProgress((Otazka10.this.f50i * 100) / 40);
            }

            public void onFinish() {
                Otazka10.this.f50i++;
                Otazka10.this.mProgressBar.setProgress(100);
                Otazka10.this.uzivatelOdpovedel = false;
                Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 0, 0);
            }
        };
        this.mCountDownTimer.start();
        int i9 = getIntent().getExtras().getInt("some_key9");
        int i10 = getIntent().getExtras().getInt("some_keyp9");
        if (getIntent().getExtras().getInt("some_keyt9") == 1) {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(false);
            this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
            this.pomocnapromennat10 = 1;
        } else {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(true);
        }
        if (i10 == 1) {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(false);
            this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
            this.pomocnapromennap10 = 1;
        } else {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(true);
        }
        if (i9 == 1) {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(false);
            this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
            this.pomocnapromenna10 = 1;
        } else {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(true);
        }
        this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f52u1.setEnabled(true);
        this.f53u2.setEnabled(true);
        this.f54u3.setEnabled(true);
        this.f55u4.setEnabled(true);
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
            this.otazkau.setText("After which battle did the Red Cross come into existence?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("BATTLE OF MAGENTA");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("BATTLE OF VILÁGOS");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("BATTLE OF SOLFERINO");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("BATTLE OF SEDAN");
            setFinishOnTouchOutside(false);
            this.castka = 160000;
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(3);
                }
            });
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("28%");
                    Otazka10.this.up2.setText("18%");
                    Otazka10.this.up3.setText("29%");
                    Otazka10.this.up4.setText("25%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f53u2 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka10.this.f55u4 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up4.setVisibility(4);
                    Otazka10.this.up2.setVisibility(4);
                    Otazka10.this.f55u4.setVisibility(4);
                    Otazka10.this.f53u2.setVisibility(4);
                    Otazka10.this.f53u2.setEnabled(false);
                    Otazka10.this.f55u4.setEnabled(false);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Thadeus: It was probably the Battle of Solferino, I’m not sure though.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 2) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these is not a moon of Jupiter?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("IO");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("CALLISTO");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("DACTYL");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("GANYMEDES");
            this.castka = 160000;
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(3);
                }
            });
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("23%");
                    Otazka10.this.up2.setText("20%");
                    Otazka10.this.up3.setText("30%");
                    Otazka10.this.up4.setText("17%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f55u4 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka10.this.f55u4.setEnabled(false);
                    Otazka10.this.f55u4.setVisibility(4);
                    Otazka10.this.f53u2 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka10.this.f53u2.setEnabled(false);
                    Otazka10.this.f53u2.setVisibility(4);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up4.setVisibility(4);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up2.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Paul: Hi, I am sorry but I do not know the correct asnwer.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 3) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("On Serbian-Romanian border, there is a dam situated on the river Danube, what is it called?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("THREE GEORGES DAM");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("DUBASARI DAM");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("MRATINJE DAM");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("PORTILE DE FIER");
            this.castka = 160000;
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(4);
                }
            });
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("13%");
                    Otazka10.this.up2.setText("21%");
                    Otazka10.this.up3.setText("28%");
                    Otazka10.this.up4.setText("38%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f54u3 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka10.this.f54u3.setEnabled(false);
                    Otazka10.this.f54u3.setVisibility(4);
                    Otazka10.this.f52u1 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka10.this.f52u1.setEnabled(false);
                    Otazka10.this.f52u1.setVisibility(4);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up3.setVisibility(4);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up1.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Lucy: Hi, I only know that it is not the Three Georges Dam.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 4) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Where did the House Of Stuart rule originally?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("WALES");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("IRELAND");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("NORMANDY");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("SCOTLAND");
            this.castka = 160000;
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(4);
                }
            });
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("25%");
                    Otazka10.this.up2.setText("27%");
                    Otazka10.this.up3.setText("19%");
                    Otazka10.this.up4.setText("29%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f54u3 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka10.this.f54u3.setEnabled(false);
                    Otazka10.this.f54u3.setVisibility(4);
                    Otazka10.this.f52u1 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka10.this.f52u1.setEnabled(false);
                    Otazka10.this.f52u1.setVisibility(4);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up3.setVisibility(4);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up1.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Boris: Hey, probably Scotland.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 5) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("La liberté guidant le peuple is a painting by?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("EUGENÉ DELACROIX");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("THÉODORE GÉRICAULT");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("CLAUDE MONET");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("FRANCISCO GOYA");
            this.castka = 160000;
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(1);
                }
            });
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("28%");
                    Otazka10.this.up2.setText("27%");
                    Otazka10.this.up3.setText("25%");
                    Otazka10.this.up4.setText("20%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f55u4 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka10.this.f55u4.setEnabled(false);
                    Otazka10.this.f55u4.setVisibility(4);
                    Otazka10.this.f54u3 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka10.this.f54u3.setEnabled(false);
                    Otazka10.this.f54u3.setVisibility(4);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up4.setVisibility(4);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up3.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Luke: Hello, it is either A) or B).");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 6) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these French decadents was shot by Paul Verlaine?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("BAUDELAIRE");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("RIMBAUD");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("MALLÁRM");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("VOLTAIRE");
            this.castka = 160000;
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(2);
                }
            });
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("26%");
                    Otazka10.this.up2.setText("29%");
                    Otazka10.this.up3.setText("26%");
                    Otazka10.this.up4.setText("19%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f55u4 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka10.this.f55u4.setEnabled(false);
                    Otazka10.this.f55u4.setVisibility(4);
                    Otazka10.this.f52u1 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka10.this.f52u1.setEnabled(false);
                    Otazka10.this.f52u1.setVisibility(4);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up4.setVisibility(4);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up1.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Mario: Hi, I have no idea.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 7) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Oeconomicus is a book written by?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("TSAKALOTOS");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("PAPADIMOS");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("SÓKRATES");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("XENOFON");
            this.castka = 160000;
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(4);
                }
            });
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("24%");
                    Otazka10.this.up2.setText("24%");
                    Otazka10.this.up3.setText("26%");
                    Otazka10.this.up4.setText("26%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f53u2 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka10.this.f53u2.setEnabled(false);
                    Otazka10.this.f53u2.setVisibility(4);
                    Otazka10.this.f52u1 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka10.this.f52u1.setEnabled(false);
                    Otazka10.this.f52u1.setVisibility(4);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up2.setVisibility(4);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up1.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Dan: Hello, the correct answer is Xenofon.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 8) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("From which current country did Stalin come from?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("ARMENIA");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("RUSSIA");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("GEORGIA");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("KAZACHSTAN");
            this.castka = 160000;
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(3);
                }
            });
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("29%");
                    Otazka10.this.up2.setText("20%");
                    Otazka10.this.up3.setText("26%");
                    Otazka10.this.up4.setText("25%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f53u2 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka10.this.f53u2.setEnabled(false);
                    Otazka10.this.f53u2.setVisibility(4);
                    Otazka10.this.f55u4 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka10.this.f55u4.setEnabled(false);
                    Otazka10.this.f55u4.setVisibility(4);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up2.setVisibility(4);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up4.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Annie: Hi, he was definitely from Georgia.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 9) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these is call the Emerald Island?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("ICELAND");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("IRELAND");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("GOTLAND");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("CORSICA");
            this.castka = 160000;
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(2);
                }
            });
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("28%");
                    Otazka10.this.up2.setText("28%");
                    Otazka10.this.up3.setText("22%");
                    Otazka10.this.up4.setText("22%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f54u3 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka10.this.f54u3.setEnabled(false);
                    Otazka10.this.f54u3.setVisibility(4);
                    Otazka10.this.f55u4 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka10.this.f55u4.setEnabled(false);
                    Otazka10.this.f55u4.setVisibility(4);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up3.setVisibility(4);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up4.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Jeremy: Hi, I don’t know.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 10) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Louis XIV was the French king for how many years?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("14");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("31");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("67");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("72");
            this.castka = 160000;
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(4);
                }
            });
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("14%");
                    Otazka10.this.up2.setText("26%");
                    Otazka10.this.up3.setText("29%");
                    Otazka10.this.up4.setText("31%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f54u3 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka10.this.f54u3.setEnabled(false);
                    Otazka10.this.f54u3.setVisibility(4);
                    Otazka10.this.f53u2 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka10.this.f53u2.setEnabled(false);
                    Otazka10.this.f53u2.setVisibility(4);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up3.setVisibility(4);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up2.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Charles: Hey, it was definitely more than 50 years but I  don’t know how many more exactly.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 11) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which heartworm causes dracunculiasis?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("EYE WORM");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("LYMPHATIC WORM");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("GUINEA WORM");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("COILED WORM");
            this.castka = 160000;
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(3);
                }
            });
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("26%");
                    Otazka10.this.up2.setText("26%");
                    Otazka10.this.up3.setText("28%");
                    Otazka10.this.up4.setText("20%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f52u1 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka10.this.f52u1.setEnabled(false);
                    Otazka10.this.f52u1.setVisibility(4);
                    Otazka10.this.f55u4 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka10.this.f55u4.setEnabled(false);
                    Otazka10.this.f55u4.setVisibility(4);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up1.setVisibility(4);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up4.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Jaine: Hi, it is definitely the Guinea worm.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 12) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these were not written by Wolfgang Amadeus Mozart?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("THE MARIAGE OF FIGARO");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("EINE KLEINE NACHTMUSIK");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("MATTHAUS PASSION");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("DIE ZAUBERFLOTE");
            this.castka = 160000;
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(3);
                }
            });
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("6%");
                    Otazka10.this.up2.setText("10%");
                    Otazka10.this.up3.setText("43%");
                    Otazka10.this.up4.setText("41%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f53u2 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka10.this.f53u2.setEnabled(false);
                    Otazka10.this.f53u2.setVisibility(4);
                    Otazka10.this.f52u1 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka10.this.f52u1.setEnabled(false);
                    Otazka10.this.f52u1.setVisibility(4);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up2.setVisibility(4);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up1.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Alex: Hey! I can’t decide between C) and D).");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 13) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Aleutian Islands are situated in which sea?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("BERING SEA");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("NORWEGIAN SEA");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("TASMAN SEA");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("CARIBBEAN SEA");
            this.castka = 160000;
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(1);
                }
            });
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("26%");
                    Otazka10.this.up2.setText("23%");
                    Otazka10.this.up3.setText("25%");
                    Otazka10.this.up4.setText("26%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f54u3 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka10.this.f54u3.setEnabled(false);
                    Otazka10.this.f54u3.setVisibility(4);
                    Otazka10.this.f53u2 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka10.this.f53u2.setEnabled(false);
                    Otazka10.this.f53u2.setVisibility(4);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up3.setVisibility(4);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up2.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Tony: Hi, I don’t know the correct answer.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 14) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Bubo is which animal?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("BUZZARD");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("OWL");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("CUCKOO");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("SWAN");
            this.castka = 160000;
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(2);
                }
            });
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("26%");
                    Otazka10.this.up2.setText("29%");
                    Otazka10.this.up3.setText("25%");
                    Otazka10.this.up4.setText("20%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f52u1 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka10.this.f52u1.setEnabled(false);
                    Otazka10.this.f52u1.setVisibility(4);
                    Otazka10.this.f55u4 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka10.this.f55u4.setEnabled(false);
                    Otazka10.this.f55u4.setVisibility(4);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up1.setVisibility(4);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up4.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Anna: Hi, it is an owl for sure.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 15) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Captain Morgan is an alcoholic beverage that comes from which country?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("MEXICO");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("CUBA");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("JAMAICA");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("USA");
            this.castka = 160000;
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(3);
                }
            });
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("21%");
                    Otazka10.this.up2.setText("27%");
                    Otazka10.this.up3.setText("29%");
                    Otazka10.this.up4.setText("23%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f52u1 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka10.this.f52u1.setEnabled(false);
                    Otazka10.this.f52u1.setVisibility(4);
                    Otazka10.this.f53u2 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka10.this.f53u2.setEnabled(false);
                    Otazka10.this.f53u2.setVisibility(4);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up1.setVisibility(4);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up2.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Ellie: Hello, I’m sorry but I have no idea.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 16) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Donlad Trump starred in which one of these movies?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("HOME ALONE 2");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("THE TWILIGHT SAGA: BREAKING DAWN");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("LORD OF THE RINGS");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("THE MAZE RUNNER");
            this.castka = 160000;
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(1);
                }
            });
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("29%");
                    Otazka10.this.up2.setText("21%");
                    Otazka10.this.up3.setText("27%");
                    Otazka10.this.up4.setText("23%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f53u2 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka10.this.f53u2.setEnabled(false);
                    Otazka10.this.f53u2.setVisibility(4);
                    Otazka10.this.f54u3 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka10.this.f54u3.setEnabled(false);
                    Otazka10.this.f54u3.setVisibility(4);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up2.setVisibility(4);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up3.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Mathew: Hi, I don’t know either.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 17) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these jails became a symbol of Soviet terror?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("LUBYANKA");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("LJUTOMER");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("LJUTA");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("LUBLICA");
            this.castka = 160000;
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(1);
                }
            });
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("27%");
                    Otazka10.this.up2.setText("26%");
                    Otazka10.this.up3.setText("23%");
                    Otazka10.this.up4.setText("24%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f55u4 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka10.this.f55u4.setEnabled(false);
                    Otazka10.this.f55u4.setVisibility(4);
                    Otazka10.this.f54u3 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka10.this.f54u3.setEnabled(false);
                    Otazka10.this.f54u3.setVisibility(4);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up4.setVisibility(4);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up3.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Mathew: Hey! It was Lubyanka!");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 18) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Edgar Allan Poe married?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("HIS SISTER");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("HIS COUSIN");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("HIS AUNT");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("PRESIDENT’S WIFE");
            this.castka = 160000;
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(2);
                }
            });
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("29%");
                    Otazka10.this.up2.setText("31%");
                    Otazka10.this.up3.setText("24%");
                    Otazka10.this.up4.setText("16%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f52u1 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka10.this.f52u1.setEnabled(false);
                    Otazka10.this.f52u1.setVisibility(4);
                    Otazka10.this.f54u3 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka10.this.f54u3.setEnabled(false);
                    Otazka10.this.f54u3.setVisibility(4);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up1.setVisibility(4);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up3.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Jill: Hello, he married his cousin.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 19) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("What does the letter K in abbreviation IKEA mean?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("KAMPARD");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("KADAVER");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("KOMPANI");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("KORTEGE");
            this.castka = 160000;
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(1);
                }
            });
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("31%");
                    Otazka10.this.up2.setText("22%");
                    Otazka10.this.up3.setText("24%");
                    Otazka10.this.up4.setText("23%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f53u2 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka10.this.f53u2.setEnabled(false);
                    Otazka10.this.f53u2.setVisibility(4);
                    Otazka10.this.f55u4 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka10.this.f55u4.setEnabled(false);
                    Otazka10.this.f55u4.setVisibility(4);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up2.setVisibility(4);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up4.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Ben: Hi, I’m sorry but I have no idea.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 20) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("How many valves does trumpet have?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("2");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("3");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("4");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("5");
            this.castka = 160000;
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(2);
                }
            });
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("14%");
                    Otazka10.this.up2.setText("29%");
                    Otazka10.this.up3.setText("29%");
                    Otazka10.this.up4.setText("28%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f55u4 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka10.this.f55u4.setEnabled(false);
                    Otazka10.this.f55u4.setVisibility(4);
                    Otazka10.this.f54u3 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka10.this.f54u3.setEnabled(false);
                    Otazka10.this.f54u3.setVisibility(4);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up4.setVisibility(4);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up3.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Rebeca: Hi, B) is the correct answer.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 21) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Benito Juaréz was a president of which country?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("MEXICO");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("SPAIN");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("CUBA");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("PORTUGAL");
            this.castka = 500000;
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(1);
                }
            });
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("31%");
                    Otazka10.this.up2.setText("22%");
                    Otazka10.this.up3.setText("28%");
                    Otazka10.this.up4.setText("19%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f54u3 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka10.this.f54u3.setEnabled(false);
                    Otazka10.this.f54u3.setVisibility(4);
                    Otazka10.this.f55u4 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka10.this.f55u4.setEnabled(false);
                    Otazka10.this.f55u4.setVisibility(4);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up3.setVisibility(4);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up4.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Thomas: Hey, he was the president of Mexico.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 22) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Run To The Hills is a song by which band?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("THE BEATLES");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("IRON MAIDEN");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("THE ROLLING STONES");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("METALLICA");
            this.castka = 500000;
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(2);
                }
            });
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("16%");
                    Otazka10.this.up2.setText("31%");
                    Otazka10.this.up3.setText("25%");
                    Otazka10.this.up4.setText("28%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f54u3 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka10.this.f54u3.setEnabled(false);
                    Otazka10.this.f54u3.setVisibility(4);
                    Otazka10.this.f55u4 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka10.this.f55u4.setEnabled(false);
                    Otazka10.this.f55u4.setVisibility(4);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up3.setVisibility(4);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up4.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Rebeca: Hi, I think it was Iron Maiden.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        } else if (this.losovane == 23) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Nimzowitsch Defence is used in which one of these?");
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setText("CHESS");
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setText("CS:GO");
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setText("CONTRACT BRIDGE");
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setText("POKER");
            this.castka = 500000;
            this.f52u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.Spravna(1);
                }
            });
            this.f53u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 2, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f54u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 3, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.f55u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.gameOver2(Otazka10.this.uzivatelOdpovedel, 4, 1);
                    if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka10.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unl.setEnabled(false);
                    Otazka10.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.up1.setText("35%");
                    Otazka10.this.up2.setText("28%");
                    Otazka10.this.up3.setText("22%");
                    Otazka10.this.up4.setText("15%");
                    Otazka10.this.pomocnapromenna10 = 1;
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unp.setEnabled(false);
                    Otazka10.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka10.this.f54u3 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka10.this.f54u3.setEnabled(false);
                    Otazka10.this.f54u3.setVisibility(4);
                    Otazka10.this.f53u2 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka10.this.f53u2.setEnabled(false);
                    Otazka10.this.f53u2.setVisibility(4);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up3.setVisibility(4);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up2.setVisibility(4);
                    Otazka10.this.pomocnapromennap10 = 1;
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka10.this.unt.setEnabled(false);
                    Otazka10.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka10.this);
                    builder.setMessage((CharSequence) "Andrew: Hello, the answer is definitely chess.");
                    builder.create().show();
                    Otazka10.this.pomocnapromennat10 = 1;
                }
            });
        }
        this.dvere = (Button) findViewById(C1760R.C1762id.dvere);
        this.dvere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Otazka10.this.gameOver();
                if (Otazka10.this.castka > Otazka10.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                    Otazka10.this.highscore(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
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
        this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f52u1.setEnabled(false);
        this.f53u2.setEnabled(false);
        this.f54u3.setEnabled(false);
        this.f55u4.setEnabled(false);
        if (i != 0) {
            int parseColor = Color.parseColor("#ffaa00");
            this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
            this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
            this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
            this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
            if (i == 1) {
                this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f52u1.setTextColor(parseColor);
                this.f52u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up1.setTextColor(parseColor);
            } else if (i == 2) {
                this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f53u2.setTextColor(parseColor);
                this.f53u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up2.setTextColor(parseColor);
            } else if (i == 3) {
                this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f54u3.setTextColor(parseColor);
                this.f54u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up3.setTextColor(parseColor);
            } else if (i == 4) {
                this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f55u4.setTextColor(parseColor);
                this.f55u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up4.setTextColor(parseColor);
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    int parseColor = Color.parseColor("#fcff0202");
                    int parseColor2 = Color.parseColor("#1dc700");
                    Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                    Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                    Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                    Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                    Otazka10.this.f52u1 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka10.this.f53u2 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka10.this.f54u3 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka10.this.f55u4 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f178u4);
                    if (i == 1) {
                        Otazka10.this.f52u1.setTextColor(parseColor);
                        Otazka10.this.f52u1.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka10.this.up1.setTextColor(parseColor);
                    } else if (i == 2) {
                        Otazka10.this.f53u2.setTextColor(parseColor);
                        Otazka10.this.f53u2.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka10.this.up2.setTextColor(parseColor);
                    } else if (i == 3) {
                        Otazka10.this.f54u3.setTextColor(parseColor);
                        Otazka10.this.f54u3.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka10.this.up3.setTextColor(parseColor);
                    } else if (i == 4) {
                        Otazka10.this.f55u4.setTextColor(parseColor);
                        Otazka10.this.f55u4.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka10.this.up4.setTextColor(parseColor);
                    }
                    if (i2 == 1) {
                        Otazka10.this.f52u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka10.this.f52u1.setTextColor(parseColor2);
                        Otazka10.this.up1.setTextColor(parseColor2);
                    } else if (i2 == 2) {
                        Otazka10.this.f53u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka10.this.f53u2.setTextColor(parseColor2);
                        Otazka10.this.up2.setTextColor(parseColor2);
                    } else if (i2 == 3) {
                        Otazka10.this.f54u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka10.this.f54u3.setTextColor(parseColor2);
                        Otazka10.this.up3.setTextColor(parseColor2);
                    } else if (i2 == 4) {
                        Otazka10.this.f55u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka10.this.f55u4.setTextColor(parseColor2);
                        Otazka10.this.up4.setTextColor(parseColor2);
                    }
                    Intent intent = new Intent(Otazka10.this, BackgroundSoundService.class);
                    intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                    Otazka10.this.stopService(intent);
                    Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka10.this).getBoolean("ZVUK", true));
                    Otazka10.this.spatna = MediaPlayer.create(Otazka10.this, C1760R.raw.spatna2);
                    if (z && valueOf.booleanValue()) {
                        Otazka10.this.spatna.start();
                    }
                }
            }, 1500);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Otazka10.this.alertDialog();
                    if (Otazka10.this.mInterstitialAd.isLoaded()) {
                        Otazka10.this.mInterstitialAd.show();
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
        this.castka = 20000;
        Intent intent2 = new Intent(this, PopActivity.class);
        intent2.putExtra("Level", this.level);
        intent2.putExtra("Castka", this.castka);
        intent2.putExtra("pomocnapromenna", this.pomocnapromenna10);
        intent2.putExtra("pomocnapromennap", this.pomocnapromennap10);
        intent2.putExtra("pomocnapromennat", this.pomocnapromennat10);
        startActivity(intent2);
        this.mCountDownTimer.cancel();
    }

    /* access modifiers changed from: private */
    public void Spravna(final int i) {
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_10", 0);
        int i2 = sharedPreferences.getInt("x", -1) + 1;
        SharedPreferences.Editor edit = getSharedPreferences("zodpovezene_10", 0).edit();
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
        this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f52u1.setEnabled(false);
        this.f53u2.setEnabled(false);
        this.f54u3.setEnabled(false);
        this.f55u4.setEnabled(false);
        if (i == 1) {
            this.f52u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f52u1.setTextColor(parseColor);
            this.f52u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up1.setTextColor(parseColor);
        } else if (i == 2) {
            this.f53u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f53u2.setTextColor(parseColor);
            this.f53u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up2.setTextColor(parseColor);
        } else if (i == 3) {
            this.f54u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f54u3.setTextColor(parseColor);
            this.f54u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up3.setTextColor(parseColor);
        } else {
            this.f55u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f55u4.setTextColor(parseColor);
            this.f55u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up4.setTextColor(parseColor);
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka10.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                Otazka10.this.stopService(intent);
                int parseColor = Color.parseColor("#1dc700");
                Otazka10.this.up1 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up1);
                Otazka10.this.up2 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up2);
                Otazka10.this.up3 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up3);
                Otazka10.this.up4 = (TextView) Otazka10.this.findViewById(C1760R.C1762id.up4);
                if (i == 1) {
                    Otazka10.this.f52u1 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka10.this.f52u1.setTextColor(parseColor);
                    Otazka10.this.f52u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka10.this.up1.setTextColor(parseColor);
                } else if (i == 2) {
                    Otazka10.this.f53u2 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka10.this.f53u2.setTextColor(parseColor);
                    Otazka10.this.f53u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka10.this.up2.setTextColor(parseColor);
                } else if (i == 3) {
                    Otazka10.this.f54u3 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka10.this.f54u3.setTextColor(parseColor);
                    Otazka10.this.f54u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka10.this.up3.setTextColor(parseColor);
                } else {
                    Otazka10.this.f55u4 = (Button) Otazka10.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka10.this.f55u4.setTextColor(parseColor);
                    Otazka10.this.f55u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka10.this.up4.setTextColor(parseColor);
                }
                if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka10.this).getBoolean("ZVUK", true)).booleanValue()) {
                    MediaPlayer.create(Otazka10.this, C1760R.raw.applause2).start();
                }
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka10.this, Otazka11.class);
                intent.putExtra("some_key10", Otazka10.this.pomocnapromenna10);
                intent.putExtra("some_keyp10", Otazka10.this.pomocnapromennap10);
                intent.putExtra("some_keyt10", Otazka10.this.pomocnapromennat10);
                Otazka10.this.startActivity(intent);
                CustomIntent.customType(Otazka10.this, "left-to-right");
            }
        }, 2500);
    }

    /* access modifiers changed from: private */
    public void highscore(int i) {
        if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true)).booleanValue()) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    MediaPlayer.create(Otazka10.this, C1760R.raw.applause7).start();
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
            Intent intent = new Intent(this, Otazka11.class);
            this.mCountDownTimer.cancel();
            intent.putExtra("some_key10", this.pomocnapromenna10);
            intent.putExtra("some_keyp10", this.pomocnapromennap10);
            intent.putExtra("some_keyt10", this.pomocnapromennat10);
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
            intent.putExtra("pomocnapromenna", this.pomocnapromenna10);
            intent.putExtra("pomocnapromennap", this.pomocnapromennap10);
            intent.putExtra("pomocnapromennat", this.pomocnapromennat10);
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
