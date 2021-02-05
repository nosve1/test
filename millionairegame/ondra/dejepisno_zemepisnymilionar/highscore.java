package com.millionairegame.ondra.dejepisno_zemepisnymilionar;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.p003v7.app.AlertDialog;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class highscore extends AppCompatActivity {
    int castka;
    TextView highscore;
    Button nova;
    Button vynulovat;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView((int) C1760R.layout.highscore);
        Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true));
        Intent intent = new Intent(this, BackgroundSoundService.class);
        intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
        if (!valueOf.booleanValue()) {
            stopService(intent);
        } else {
            startService(intent);
        }
        this.vynulovat = (Button) findViewById(C1760R.C1762id.vynulovat);
        this.vynulovat.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(highscore.this);
                builder.setMessage((CharSequence) "Do you really want to reset your highscore?").setCancelable(false).setPositiveButton((CharSequence) "YES", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SharedPreferences.Editor edit = highscore.this.getSharedPreferences("GAME_DATA", 0).edit();
                        edit.putInt("HIGH_SCORE", 0);
                        edit.commit();
                        highscore.this.highscore.setText("0$");
                    }
                }).setNegativeButton((CharSequence) "NO", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                builder.create().show();
            }
        });
        this.nova = (Button) findViewById(C1760R.C1762id.nova);
        this.nova.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                highscore.this.startActivity(new Intent(highscore.this, otazka1.class));
            }
        });
        this.highscore = (TextView) findViewById(C1760R.C1762id.highscore);
        int intExtra = getIntent().getIntExtra("SCORE", 0);
        SharedPreferences sharedPreferences = getSharedPreferences("GAME_DATA", 0);
        int i = sharedPreferences.getInt("HIGH_SCORE", 0);
        if (intExtra > i) {
            if (intExtra == 1000) {
                this.highscore.setText("100$");
            }
            if (intExtra == 2000) {
                this.highscore.setText("200$");
            }
            if (intExtra == 3000) {
                this.highscore.setText("300$");
            }
            if (intExtra == 5000) {
                this.highscore.setText("500$");
            }
            if (intExtra == 10000) {
                this.highscore.setText("1 000$");
            }
            if (intExtra == 20000) {
                this.highscore.setText("2 000$");
            }
            if (intExtra == 40000) {
                this.highscore.setText("5 000$");
            }
            if (intExtra == 80000) {
                this.highscore.setText("10 000$");
            }
            if (intExtra == 160000) {
                this.highscore.setText("20 000$");
            }
            if (intExtra == 500000) {
                this.highscore.setText("40 000$");
            }
            if (intExtra == 1000000) {
                this.highscore.setText("80 000$");
            }
            if (intExtra == 3000000) {
                this.highscore.setText("160 000$");
            }
            if (intExtra == 5000000) {
                this.highscore.setText("500 000$");
            }
            if (intExtra == 10000000) {
                this.highscore.setText("1 000 000$");
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("HIGH_SCORE", intExtra);
            edit.commit();
            return;
        }
        if (i == 1000) {
            this.highscore.setText("100$");
        }
        if (i == 2000) {
            this.highscore.setText("200$");
        }
        if (i == 3000) {
            this.highscore.setText("300$");
        }
        if (i == 5000) {
            this.highscore.setText("500$");
        }
        if (i == 10000) {
            this.highscore.setText("1 000$");
        }
        if (i == 20000) {
            this.highscore.setText("2 000$");
        }
        if (i == 40000) {
            this.highscore.setText("5 000$");
        }
        if (i == 80000) {
            this.highscore.setText("10 000$");
        }
        if (i == 160000) {
            this.highscore.setText("20 000$");
        }
        if (i == 500000) {
            this.highscore.setText("40 000$");
        }
        if (i == 1000000) {
            this.highscore.setText("80 000$");
        }
        if (i == 3000000) {
            this.highscore.setText("160 000$");
        }
        if (i == 5000000) {
            this.highscore.setText("500 000$");
        }
        if (i == 10000000) {
            this.highscore.setText("1 000 000$");
        }
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
