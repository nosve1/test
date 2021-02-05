package com.millionairegame.ondra.dejepisno_zemepisnymilionar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;

public class podekovani extends AppCompatActivity {
    EditText edittext;
    EditText edittext10;
    EditText edittext11;
    EditText edittext12;
    EditText edittext9;
    ScrollView scrollView;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView((int) C1760R.layout.podekovani);
        Boolean valueOf = Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(this).getBoolean("ZVUK", true));
        Intent intent = new Intent(this, BackgroundSoundService.class);
        intent.setAction("com.millionairegame.ondra.dejepisno_zemepisnymilionar.BackgroundSoundService");
        if (!valueOf.booleanValue()) {
            stopService(intent);
        } else {
            startService(intent);
        }
        this.edittext9 = (EditText) findViewById(C1760R.C1762id.edittext9);
        this.edittext10 = (EditText) findViewById(C1760R.C1762id.edittext10);
        this.edittext11 = (EditText) findViewById(C1760R.C1762id.edittext11);
        this.edittext12 = (EditText) findViewById(C1760R.C1762id.edittext12);
        this.edittext = (EditText) findViewById(C1760R.C1762id.edittext);
        ((Button) findViewById(C1760R.C1762id.poslat)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String obj = podekovani.this.edittext9.getText().toString();
                String obj2 = podekovani.this.edittext10.getText().toString();
                String obj3 = podekovani.this.edittext11.getText().toString();
                String obj4 = podekovani.this.edittext12.getText().toString();
                String obj5 = podekovani.this.edittext.getText().toString();
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra("android.intent.extra.EMAIL", new String[]{"questionsmillionaire@gmail.com"});
                intent.putExtra("android.intent.extra.SUBJECT", "QUESTION SUGGEST");
                intent.putExtra("android.intent.extra.TEXT", "Thank you! We will review your suggestion and if appropriate then there's a high chance it will appear in the future update!" + System.getProperty("line.separator") + System.getProperty("line.separator") + obj5 + System.getProperty("line.separator") + System.getProperty("line.separator") + obj + System.getProperty("line.separator") + obj3 + System.getProperty("line.separator") + obj2 + System.getProperty("line.separator") + obj4);
                intent.setType("message/rfc822");
                podekovani.this.startActivity(Intent.createChooser(intent, "Send Email"));
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
