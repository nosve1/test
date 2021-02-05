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
import java.util.ArrayList;
import java.util.Random;

public class Otazka14 extends AppCompatActivity {
    private static boolean activityVisible;
    Button Zvuk;

    /* renamed from: a */
    final int f81a = 0;
    ArrayList<Integer> arl = new ArrayList<>();

    /* renamed from: b */
    final int f82b = 0;
    Button button;
    int castka;
    Button dvere;
    RadioGroup fuhrer1;
    boolean gameOver = false;

    /* renamed from: i */
    int f83i = 0;
    int[] items = {1, 2, 3, 4, 5, 6, 7};
    TextView label;
    int level = 14;
    int losovane;
    CountDownTimer mCountDownTimer;
    ProgressBar mProgressBar;
    Button novahra;
    TextView otazka2;
    TextView otazkau;
    TextView otazkau500k;
    TextView otazkaza;

    /* renamed from: r */
    Random f84r;
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
    Button f85u1;

    /* renamed from: u2 */
    Button f86u2;

    /* renamed from: u3 */
    Button f87u3;

    /* renamed from: u4 */
    Button f88u4;
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

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView((int) C1760R.layout.univerzalni);
        this.arl.clear();
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_14", 0);
        int i = sharedPreferences.getInt("x", -1) + 1;
        System.out.println(i + "!!!!");
        SharedPreferences sharedPreferences2 = getSharedPreferences("zodpovezene_14", 0);
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
        this.f84r = new Random();
        this.castka = 0;
        if (this.arl.size() == 0) {
            sharedPreferences.edit().clear().commit();
            sharedPreferences2.edit().clear().commit();
            int i5 = getSharedPreferences("zodpovezene_14", 0).getInt("x", -1) + 1;
            System.out.println(i5 + "!!!!");
            SharedPreferences sharedPreferences3 = getSharedPreferences("zodpovezene_14", 0);
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
        this.losovane = this.f84r.nextInt(this.arl.size());
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
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(Otazka14.this);
                Boolean valueOf = Boolean.valueOf(defaultSharedPreferences.getBoolean("ZVUK", true));
                Intent intent = new Intent(Otazka14.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                if (valueOf.booleanValue()) {
                    SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                    edit.putBoolean("ZVUK", false);
                    edit.commit();
                    Otazka14.this.stopService(intent);
                    Otazka14.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukvypnuto);
                    return;
                }
                SharedPreferences.Editor edit2 = defaultSharedPreferences.edit();
                edit2.putBoolean("ZVUK", true);
                edit2.commit();
                Otazka14.this.startService(intent);
                Otazka14.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukzapnuto);
            }
        });
        this.f85u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f85u1.setTextColor(-1);
        this.f85u1.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f86u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f86u2.setTextColor(-1);
        this.f86u2.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f87u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f87u3.setTextColor(-1);
        this.f87u3.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.f88u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f88u4.setTextColor(-1);
        this.f88u4.setBackgroundResource(C1760R.C1761drawable.button_bg);
        this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
        this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
        this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
        this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
        this.up1.setTextColor(-1);
        this.up2.setTextColor(-1);
        this.up3.setTextColor(-1);
        this.up4.setTextColor(-1);
        this.textview8 = (TextView) findViewById(C1760R.C1762id.textView8);
        this.textview8.setTextColor(-1);
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
        this.otazkaza = (TextView) findViewById(C1760R.C1762id.otazkaza);
        this.otazkaza.setText("1 000 000$ Question");
        this.mProgressBar = (ProgressBar) findViewById(C1760R.C1762id.progressBar3);
        this.mProgressBar.setProgress(this.f83i);
        this.mCountDownTimer = new CountDownTimer(40000, 1000) {
            public void onTick(long j) {
                Log.v("Log_tag", "Tick of Progress" + Otazka14.this.f83i + j);
                Otazka14 otazka14 = Otazka14.this;
                otazka14.f83i = otazka14.f83i + 1;
                Otazka14.this.mProgressBar.setProgress((Otazka14.this.f83i * 100) / 40);
            }

            public void onFinish() {
                Otazka14.this.f83i++;
                Otazka14.this.mProgressBar.setProgress(100);
                Otazka14.this.uzivatelOdpovedel = false;
                Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 0, 0);
            }
        };
        this.mCountDownTimer.start();
        int i9 = getIntent().getExtras().getInt("some_key13");
        int i10 = getIntent().getExtras().getInt("some_keyp13");
        if (getIntent().getExtras().getInt("some_keyt13") == 1) {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(false);
            this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
        } else {
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setEnabled(true);
        }
        if (i10 == 1) {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(false);
            this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
        } else {
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setEnabled(true);
        }
        if (i9 == 1) {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(false);
            this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
        } else {
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setEnabled(true);
        }
        this.f85u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f86u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f87u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f88u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f85u1.setEnabled(true);
        this.f86u2.setEnabled(true);
        this.f87u3.setEnabled(true);
        this.f88u4.setEnabled(true);
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
            this.otazkau.setText("Which one of these writers is not a figure of Romanticism?");
            this.f85u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f85u1.setText("WILLIAM WORDWORTH");
            this.f86u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f86u2.setText("THOMAS MOORE");
            this.f87u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f87u3.setText("EDWARD GIBBON");
            this.f88u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f88u4.setText("JOHN KEATS");
            this.castka = 5000000;
            this.f87u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.Spravna(3);
                }
            });
            this.f85u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.f86u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.f88u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unl.setEnabled(false);
                    Otazka14.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka14.this.up1 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up1);
                    Otazka14.this.up2 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up2);
                    Otazka14.this.up3 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up3);
                    Otazka14.this.up4 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up4);
                    Otazka14.this.up1.setText("26%");
                    Otazka14.this.up2.setText("27%");
                    Otazka14.this.up3.setText("26%");
                    Otazka14.this.up4.setText("21%");
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unp.setEnabled(false);
                    Otazka14.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka14.this.f85u1 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka14.this.f85u1.setEnabled(false);
                    Otazka14.this.f85u1.setVisibility(4);
                    Otazka14.this.f88u4 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka14.this.f88u4.setEnabled(false);
                    Otazka14.this.f88u4.setVisibility(4);
                    Otazka14.this.up1 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up1);
                    Otazka14.this.up1.setVisibility(4);
                    Otazka14.this.up4 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up4);
                    Otazka14.this.up4.setVisibility(4);
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unt.setEnabled(false);
                    Otazka14.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka14.this);
                    builder.setMessage((CharSequence) "Abby: Hello, I unfortunately don’t know the correct answer...");
                    builder.create().show();
                }
            });
        } else if (this.losovane == 2) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In 1972 the chess grandmaster Boris Spassky was beaten by?");
            this.f85u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f85u1.setText("CAPABLANCA");
            this.f86u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f86u2.setText("FISCHER");
            this.f87u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f87u3.setText("SMYSLOV");
            this.f88u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f88u4.setText("HÜBNER");
            this.castka = 5000000;
            this.f86u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.Spravna(2);
                }
            });
            this.f85u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 1, 2);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.f87u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 3, 2);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.f88u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 4, 2);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unl.setEnabled(false);
                    Otazka14.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka14.this.up1 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up1);
                    Otazka14.this.up2 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up2);
                    Otazka14.this.up3 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up3);
                    Otazka14.this.up4 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up4);
                    Otazka14.this.up1.setText("22%");
                    Otazka14.this.up2.setText("28%");
                    Otazka14.this.up3.setText("21%");
                    Otazka14.this.up4.setText("29%");
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unp.setEnabled(false);
                    Otazka14.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka14.this.f85u1 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka14.this.f85u1.setEnabled(false);
                    Otazka14.this.f85u1.setVisibility(4);
                    Otazka14.this.f87u3 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka14.this.f87u3.setEnabled(false);
                    Otazka14.this.f87u3.setVisibility(4);
                    Otazka14.this.up1 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up1);
                    Otazka14.this.up1.setVisibility(4);
                    Otazka14.this.up3 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up3);
                    Otazka14.this.up3.setVisibility(4);
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unt.setEnabled(false);
                    Otazka14.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka14.this);
                    builder.setMessage((CharSequence) "Matgew: Hi, since I’m really fond of chess, I know for sure that it was Bobby Fischer.");
                    builder.create().show();
                }
            });
        } else if (this.losovane == 3) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In 1625 which one of these became the king of England?");
            this.f85u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f85u1.setText("JACOB I.");
            this.f86u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f86u2.setText("JACOB II.");
            this.f87u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f87u3.setText("CHARLES I.");
            this.f88u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f88u4.setText("CHARLES II.");
            this.castka = 5000000;
            this.f87u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.Spravna(3);
                }
            });
            this.f85u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.f86u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.f88u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unl.setEnabled(false);
                    Otazka14.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka14.this.up1 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up1);
                    Otazka14.this.up2 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up2);
                    Otazka14.this.up3 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up3);
                    Otazka14.this.up4 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up4);
                    Otazka14.this.up1.setText("27%");
                    Otazka14.this.up2.setText("25%");
                    Otazka14.this.up3.setText("25%");
                    Otazka14.this.up4.setText("23%");
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unp.setEnabled(false);
                    Otazka14.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka14.this.f86u2 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka14.this.f86u2.setEnabled(false);
                    Otazka14.this.f86u2.setVisibility(4);
                    Otazka14.this.f88u4 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka14.this.f88u4.setEnabled(false);
                    Otazka14.this.f88u4.setVisibility(4);
                    Otazka14.this.up2 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up2);
                    Otazka14.this.up2.setVisibility(4);
                    Otazka14.this.up4 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up4);
                    Otazka14.this.up4.setVisibility(4);
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unt.setEnabled(false);
                    Otazka14.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka14.this);
                    builder.setMessage((CharSequence) "Martin: Hey, it’s either Jacob I. or Charles I..");
                    builder.create().show();
                }
            });
        } else if (this.losovane == 4) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Battle of Wogastisburg took place in which year?");
            this.f85u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f85u1.setText("622");
            this.f86u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f86u2.setText("624");
            this.f87u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f87u3.setText("628");
            this.f88u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f88u4.setText("631");
            this.castka = 5000000;
            this.f88u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.Spravna(4);
                }
            });
            this.f85u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.f86u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.f87u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unl.setEnabled(false);
                    Otazka14.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka14.this.up1 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up1);
                    Otazka14.this.up2 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up2);
                    Otazka14.this.up3 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up3);
                    Otazka14.this.up4 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up4);
                    Otazka14.this.up1.setText("22%");
                    Otazka14.this.up2.setText("27%");
                    Otazka14.this.up3.setText("27%");
                    Otazka14.this.up4.setText("26%");
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unp.setEnabled(false);
                    Otazka14.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka14.this.f85u1 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka14.this.f85u1.setEnabled(false);
                    Otazka14.this.f85u1.setVisibility(4);
                    Otazka14.this.f87u3 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka14.this.f87u3.setEnabled(false);
                    Otazka14.this.f87u3.setVisibility(4);
                    Otazka14.this.up1 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up1);
                    Otazka14.this.up1.setVisibility(4);
                    Otazka14.this.up3 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up3);
                    Otazka14.this.up3.setVisibility(4);
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unt.setEnabled(false);
                    Otazka14.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka14.this);
                    builder.setMessage((CharSequence) "Nathalie: Hello, I’m sorry but I’m afraid I can’t help you.");
                    builder.create().show();
                }
            });
        } else if (this.losovane == 5) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("In which of these following years was the Nobel Prize for literature not awarded?");
            this.f85u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f85u1.setText("1916");
            this.f86u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f86u2.setText("1939");
            this.f87u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f87u3.setText("1935");
            this.f88u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f88u4.setText("1944");
            this.castka = 5000000;
            this.f87u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.Spravna(3);
                }
            });
            this.f85u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.f86u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.f88u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unl.setEnabled(false);
                    Otazka14.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka14.this.up1 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up1);
                    Otazka14.this.up2 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up2);
                    Otazka14.this.up3 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up3);
                    Otazka14.this.up4 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up4);
                    Otazka14.this.up1.setText("25%");
                    Otazka14.this.up2.setText("25%");
                    Otazka14.this.up3.setText("25%");
                    Otazka14.this.up4.setText("25%");
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unp.setEnabled(false);
                    Otazka14.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka14.this.f88u4 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka14.this.f88u4.setEnabled(false);
                    Otazka14.this.f88u4.setVisibility(4);
                    Otazka14.this.f86u2 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka14.this.f86u2.setEnabled(false);
                    Otazka14.this.f86u2.setVisibility(4);
                    Otazka14.this.up4 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up4);
                    Otazka14.this.up4.setVisibility(4);
                    Otazka14.this.up2 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up2);
                    Otazka14.this.up2.setVisibility(4);
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unt.setEnabled(false);
                    Otazka14.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka14.this);
                    builder.setMessage((CharSequence) "Jill: Hi, I have no clue.");
                    builder.create().show();
                }
            });
        } else if (this.losovane == 6) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Who composed the music for the TV series Miami Vice?");
            this.f85u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f85u1.setText("RAMIN DJAWADI");
            this.f86u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f86u2.setText("HANS ZIMMER");
            this.f87u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f87u3.setText("JAN HAMMER ML.");
            this.f88u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f88u4.setText("JAN P. MUCHOW");
            this.castka = 5000000;
            this.f87u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.Spravna(3);
                }
            });
            this.f85u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 1, 3);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.f86u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 2, 3);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.f88u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 4, 3);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unl.setEnabled(false);
                    Otazka14.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka14.this.up1 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up1);
                    Otazka14.this.up2 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up2);
                    Otazka14.this.up3 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up3);
                    Otazka14.this.up4 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up4);
                    Otazka14.this.up1.setText("22%");
                    Otazka14.this.up2.setText("26%");
                    Otazka14.this.up3.setText("26%");
                    Otazka14.this.up4.setText("26%");
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unp.setEnabled(false);
                    Otazka14.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka14.this.f88u4 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka14.this.f88u4.setEnabled(false);
                    Otazka14.this.f88u4.setVisibility(4);
                    Otazka14.this.f86u2 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka14.this.f86u2.setEnabled(false);
                    Otazka14.this.f86u2.setVisibility(4);
                    Otazka14.this.up4 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up4);
                    Otazka14.this.up4.setVisibility(4);
                    Otazka14.this.up2 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up2);
                    Otazka14.this.up2.setVisibility(4);
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unt.setEnabled(false);
                    Otazka14.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka14.this);
                    builder.setMessage((CharSequence) "Jeremy: Hi, I’m sorry but I have no clue.");
                    builder.create().show();
                }
            });
        } else if (this.losovane == 7) {
            this.otazkau = (TextView) findViewById(C1760R.C1762id.otazkau);
            this.otazkau.setText("Which one of these movies was not shot by the italian director Sergio Leone?");
            this.f85u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f85u1.setText("TENKRÁT NA ZÁPADĚ");
            this.f86u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f86u2.setText("HLAVU DOLŮ");
            this.f87u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f87u3.setText("PRO PÁR DOLARŮ NAVÍC");
            this.f88u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f88u4.setText("LEGENDA O 1900");
            this.castka = 5000000;
            this.f88u4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.Spravna(4);
                }
            });
            this.f85u1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 1, 4);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.f86u2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 2, 4);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.f87u3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.gameOver2(Otazka14.this.uzivatelOdpovedel, 3, 4);
                    if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                        Otazka14.this.highscore(3500);
                    }
                }
            });
            this.unl = (Button) findViewById(C1760R.C1762id.unl);
            this.unl.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unl.setEnabled(false);
                    Otazka14.this.unl.setBackgroundResource(C1760R.C1761drawable.lide2);
                    Otazka14.this.up1 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up1);
                    Otazka14.this.up2 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up2);
                    Otazka14.this.up3 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up3);
                    Otazka14.this.up4 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up4);
                    Otazka14.this.up1.setText("28%");
                    Otazka14.this.up2.setText("19%");
                    Otazka14.this.up3.setText("25%");
                    Otazka14.this.up4.setText("28%");
                }
            });
            this.unp = (Button) findViewById(C1760R.C1762id.unp);
            this.unp.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unp.setEnabled(false);
                    Otazka14.this.unp.setBackgroundResource(C1760R.C1761drawable.pade2);
                    Otazka14.this.f86u2 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka14.this.f86u2.setEnabled(false);
                    Otazka14.this.f86u2.setVisibility(4);
                    Otazka14.this.f85u1 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka14.this.f85u1.setEnabled(false);
                    Otazka14.this.f85u1.setVisibility(4);
                    Otazka14.this.up2 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up2);
                    Otazka14.this.up2.setVisibility(4);
                    Otazka14.this.up1 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up1);
                    Otazka14.this.up1.setVisibility(4);
                }
            });
            this.unt = (Button) findViewById(C1760R.C1762id.unt);
            this.unt.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Otazka14.this.unt.setEnabled(false);
                    Otazka14.this.unt.setBackgroundResource(C1760R.C1761drawable.pritel2);
                    AlertDialog.Builder builder = new AlertDialog.Builder(Otazka14.this);
                    builder.setMessage((CharSequence) "Denis: Hello, sorry but I have no clue.");
                    builder.create().show();
                }
            });
        }
        this.dvere = (Button) findViewById(C1760R.C1762id.dvere);
        this.dvere.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Otazka14.this.castka = 5000000;
                Otazka14.this.gameOver();
                if (Otazka14.this.castka > Otazka14.this.getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
                    Otazka14.this.highscore(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void gameOver2(final boolean z, final int i, final int i2) {
        this.gameOver = true;
        this.mCountDownTimer.cancel();
        this.castka = 160000;
        this.f85u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f86u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f87u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f88u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f85u1.setEnabled(false);
        this.f86u2.setEnabled(false);
        this.f87u3.setEnabled(false);
        this.f88u4.setEnabled(false);
        if (i != 0) {
            int parseColor = Color.parseColor("#ffaa00");
            this.up1 = (TextView) findViewById(C1760R.C1762id.up1);
            this.up2 = (TextView) findViewById(C1760R.C1762id.up2);
            this.up3 = (TextView) findViewById(C1760R.C1762id.up3);
            this.up4 = (TextView) findViewById(C1760R.C1762id.up4);
            if (i == 1) {
                this.f85u1 = (Button) findViewById(C1760R.C1762id.f175u1);
                this.f85u1.setTextColor(parseColor);
                this.f85u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up1.setTextColor(parseColor);
            } else if (i == 2) {
                this.f86u2 = (Button) findViewById(C1760R.C1762id.f176u2);
                this.f86u2.setTextColor(parseColor);
                this.f86u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up2.setTextColor(parseColor);
            } else if (i == 3) {
                this.f87u3 = (Button) findViewById(C1760R.C1762id.f177u3);
                this.f87u3.setTextColor(parseColor);
                this.f87u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up3.setTextColor(parseColor);
            } else if (i == 4) {
                this.f88u4 = (Button) findViewById(C1760R.C1762id.f178u4);
                this.f88u4.setTextColor(parseColor);
                this.f88u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
                this.up4.setTextColor(parseColor);
            }
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    int parseColor = Color.parseColor("#fcff0202");
                    int parseColor2 = Color.parseColor("#1dc700");
                    Otazka14.this.up1 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up1);
                    Otazka14.this.up2 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up2);
                    Otazka14.this.up3 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up3);
                    Otazka14.this.up4 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up4);
                    Otazka14.this.f85u1 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka14.this.f86u2 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka14.this.f87u3 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka14.this.f88u4 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f178u4);
                    if (i == 1) {
                        Otazka14.this.f85u1.setTextColor(parseColor);
                        Otazka14.this.f85u1.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka14.this.up1.setTextColor(parseColor);
                    } else if (i == 2) {
                        Otazka14.this.f86u2.setTextColor(parseColor);
                        Otazka14.this.f86u2.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka14.this.up2.setTextColor(parseColor);
                    } else if (i == 3) {
                        Otazka14.this.f87u3.setTextColor(parseColor);
                        Otazka14.this.f87u3.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka14.this.up3.setTextColor(parseColor);
                    } else if (i == 4) {
                        Otazka14.this.f88u4.setTextColor(parseColor);
                        Otazka14.this.f88u4.setBackgroundResource(C1760R.C1761drawable.buttonwrong);
                        Otazka14.this.up4.setTextColor(parseColor);
                    }
                    if (i2 == 1) {
                        Otazka14.this.f85u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka14.this.f85u1.setTextColor(parseColor2);
                        Otazka14.this.up1.setTextColor(parseColor2);
                    } else if (i2 == 2) {
                        Otazka14.this.f86u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka14.this.f86u2.setTextColor(parseColor2);
                        Otazka14.this.up2.setTextColor(parseColor2);
                    } else if (i2 == 3) {
                        Otazka14.this.f87u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka14.this.f87u3.setTextColor(parseColor2);
                        Otazka14.this.up3.setTextColor(parseColor2);
                    } else if (i2 == 4) {
                        Otazka14.this.f88u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                        Otazka14.this.f88u4.setTextColor(parseColor2);
                        Otazka14.this.up4.setTextColor(parseColor2);
                    }
                    Intent intent = new Intent(Otazka14.this, BackgroundSoundService.class);
                    intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                    Otazka14.this.stopService(intent);
                    Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka14.this).getBoolean("ZVUK", true));
                    Otazka14.this.spatna = MediaPlayer.create(Otazka14.this, C1760R.raw.spatna2);
                    if (z && valueOf.booleanValue()) {
                        Otazka14.this.spatna.start();
                    }
                }
            }, 1500);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Otazka14.this.alertDialog();
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
        this.castka = 500000;
        Intent intent2 = new Intent(this, PopActivity.class);
        intent2.putExtra("Level", this.level);
        intent2.putExtra("Castka", this.castka);
        intent2.putExtra("pomocnapromenna", 1);
        intent2.putExtra("pomocnapromennap", 1);
        intent2.putExtra("pomocnapromennat", 1);
        startActivity(intent2);
        this.mCountDownTimer.cancel();
    }

    /* access modifiers changed from: private */
    public void Spravna(final int i) {
        SharedPreferences sharedPreferences = getSharedPreferences("zodpovezene_14", 0);
        int i2 = sharedPreferences.getInt("x", -1) + 1;
        SharedPreferences.Editor edit = getSharedPreferences("zodpovezene_14", 0).edit();
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
        this.f85u1 = (Button) findViewById(C1760R.C1762id.f175u1);
        this.f86u2 = (Button) findViewById(C1760R.C1762id.f176u2);
        this.f87u3 = (Button) findViewById(C1760R.C1762id.f177u3);
        this.f88u4 = (Button) findViewById(C1760R.C1762id.f178u4);
        this.f85u1.setEnabled(false);
        this.f86u2.setEnabled(false);
        this.f87u3.setEnabled(false);
        this.f88u4.setEnabled(false);
        if (i == 1) {
            this.f85u1 = (Button) findViewById(C1760R.C1762id.f175u1);
            this.f85u1.setTextColor(parseColor);
            this.f85u1.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up1.setTextColor(parseColor);
        } else if (i == 2) {
            this.f86u2 = (Button) findViewById(C1760R.C1762id.f176u2);
            this.f86u2.setTextColor(parseColor);
            this.f86u2.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up2.setTextColor(parseColor);
        } else if (i == 3) {
            this.f87u3 = (Button) findViewById(C1760R.C1762id.f177u3);
            this.f87u3.setTextColor(parseColor);
            this.f87u3.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up3.setTextColor(parseColor);
        } else {
            this.f88u4 = (Button) findViewById(C1760R.C1762id.f178u4);
            this.f88u4.setTextColor(parseColor);
            this.f88u4.setBackgroundResource(C1760R.C1761drawable.buttonwaiting);
            this.up4.setTextColor(parseColor);
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(Otazka14.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                Otazka14.this.stopService(intent);
                int parseColor = Color.parseColor("#1dc700");
                Otazka14.this.up1 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up1);
                Otazka14.this.up2 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up2);
                Otazka14.this.up3 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up3);
                Otazka14.this.up4 = (TextView) Otazka14.this.findViewById(C1760R.C1762id.up4);
                if (i == 1) {
                    Otazka14.this.f85u1 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f175u1);
                    Otazka14.this.f85u1.setTextColor(parseColor);
                    Otazka14.this.f85u1.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka14.this.up1.setTextColor(parseColor);
                } else if (i == 2) {
                    Otazka14.this.f86u2 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f176u2);
                    Otazka14.this.f86u2.setTextColor(parseColor);
                    Otazka14.this.f86u2.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka14.this.up2.setTextColor(parseColor);
                } else if (i == 3) {
                    Otazka14.this.f87u3 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f177u3);
                    Otazka14.this.f87u3.setTextColor(parseColor);
                    Otazka14.this.f87u3.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka14.this.up3.setTextColor(parseColor);
                } else {
                    Otazka14.this.f88u4 = (Button) Otazka14.this.findViewById(C1760R.C1762id.f178u4);
                    Otazka14.this.f88u4.setTextColor(parseColor);
                    Otazka14.this.f88u4.setBackgroundResource(C1760R.C1761drawable.buttoncorrect);
                    Otazka14.this.up4.setTextColor(parseColor);
                }
                if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(Otazka14.this).getBoolean("ZVUK", true)).booleanValue()) {
                    MediaPlayer.create(Otazka14.this, C1760R.raw.applause7).start();
                }
            }
        }, 1500);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Otazka14.this.startActivity(new Intent(Otazka14.this, Youwin.class));
            }
        }, 2500);
    }

    /* access modifiers changed from: private */
    public void highscore(int i) {
        if (Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true)).booleanValue()) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    MediaPlayer.create(Otazka14.this, C1760R.raw.applause7).start();
                }
            }, (long) i);
        }
        SharedPreferences sharedPreferences = getSharedPreferences("GAME_DATA", 0);
        sharedPreferences.getInt("HIGH_SCORE", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("HIGH_SCORE", this.castka);
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

    /* access modifiers changed from: private */
    public void alertDialog() {
        this.castka = 20000;
        if (this.gameOver && isActivityVisible()) {
            Intent intent = new Intent(this, PopActivity.class);
            intent.putExtra("Level", this.level);
            intent.putExtra("Castka", this.castka);
            intent.putExtra("pomocnapromenna", 1);
            intent.putExtra("pomocnapromennap", 1);
            intent.putExtra("pomocnapromennat", 1);
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
