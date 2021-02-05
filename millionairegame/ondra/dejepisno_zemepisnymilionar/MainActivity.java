package com.millionairegame.ondra.dejepisno_zemepisnymilionar;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.p003v7.app.AlertDialog;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button Zvuk;
    Button highscore;
    Button novahra;
    Button ovyvojari;
    Button specialnipodekovani;
    int spusteno;

    public void onBackPressed() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C1760R.layout.vychozi);
        this.Zvuk = (Button) findViewById(C1760R.C1762id.zvuk);
        Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true));
        Intent intent = new Intent(this, BackgroundSoundService.class);
        intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
        if (!valueOf.booleanValue()) {
            stopService(intent);
            this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukvypnuto);
        } else {
            startService(intent);
            this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukzapnuto);
        }
        this.spusteno = getSharedPreferences("pocet_spusteni", 0).getInt("pocet", 1);
        if (this.spusteno == 6) {
            new AlertDialog.Builder(this).setTitle((CharSequence) "RATE APP").setMessage((CharSequence) "Your feedback is important to us! Please rate this app on Google Play.").setPositiveButton((CharSequence) "RATE", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + MainActivity.this.getApplicationContext().getPackageName()));
                    intent.addFlags(1208483840);
                    try {
                        MainActivity.this.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        MainActivity mainActivity = MainActivity.this;
                        mainActivity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=" + MainActivity.this.getApplicationContext().getPackageName())));
                    }
                }
            }).setNegativeButton((CharSequence) "NO, THANKS", (DialogInterface.OnClickListener) null).show();
        }
        this.spusteno++;
        SharedPreferences.Editor edit = getSharedPreferences("pocet_spusteni", 0).edit();
        edit.putInt("pocet", this.spusteno);
        edit.commit();
        this.Zvuk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                Boolean valueOf = Boolean.valueOf(defaultSharedPreferences.getBoolean("ZVUK", true));
                Intent intent = new Intent(MainActivity.this, BackgroundSoundService.class);
                intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
                if (valueOf.booleanValue()) {
                    SharedPreferences.Editor edit = defaultSharedPreferences.edit();
                    edit.putBoolean("ZVUK", false);
                    edit.commit();
                    MainActivity.this.stopService(intent);
                    MainActivity.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukvypnuto);
                    return;
                }
                SharedPreferences.Editor edit2 = defaultSharedPreferences.edit();
                edit2.putBoolean("ZVUK", true);
                edit2.commit();
                MainActivity.this.startService(intent);
                MainActivity.this.Zvuk.setBackgroundResource(C1760R.C1761drawable.zvukzapnuto);
            }
        });
        setFinishOnTouchOutside(false);
        this.novahra = (Button) findViewById(C1760R.C1762id.novahra);
        this.novahra.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, otazka1.class));
            }
        });
        this.ovyvojari = (Button) findViewById(C1760R.C1762id.ovyvojari);
        this.ovyvojari.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, vyvojar.class));
            }
        });
        this.specialnipodekovani = (Button) findViewById(C1760R.C1762id.specialnipodekovani);
        this.specialnipodekovani.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, podekovani.class));
            }
        });
        this.highscore = (Button) findViewById(C1760R.C1762id.bhighscore);
        this.highscore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, highscore.class));
            }
        });
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
        Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true));
        Intent intent = new Intent(this, BackgroundSoundService.class);
        intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
        if (valueOf.booleanValue()) {
            startService(intent);
        } else {
            stopService(intent);
        }
    }
}
