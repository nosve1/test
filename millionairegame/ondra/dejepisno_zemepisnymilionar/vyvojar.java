package com.millionairegame.ondra.dejepisno_zemepisnymilionar;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.p003v7.app.AppCompatActivity;
import android.widget.TextView;

public class vyvojar extends AppCompatActivity {
    TextView vyvojar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView((int) C1760R.layout.vyvojar);
        Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true));
        Intent intent = new Intent(this, BackgroundSoundService.class);
        intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
        if (!valueOf.booleanValue()) {
            stopService(intent);
        } else {
            startService(intent);
        }
        this.vyvojar = (TextView) findViewById(C1760R.C1762id.vyvojar);
        TextView textView = this.vyvojar;
        textView.setText("There are two checkpoints - 1000$ and 20 000$. When you answer these questions correct then you preserve the checkpoint value." + System.getProperty("line.separator") + System.getProperty("line.separator") + "There are three helps - audience vote, 50-50 and a phone call to a friend." + System.getProperty("line.separator") + System.getProperty("line.separator") + "You may click on the doors icon before making an answer and keep the already earned money.");
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
