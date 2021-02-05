package com.millionairegame.ondra.dejepisno_zemepisnymilionar;

import android.content.Intent;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Youwin extends AppCompatActivity {
    Button button2;
    Button button3;
    int castka;
    TextView highscore;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView((int) C1760R.layout.youwin);
        this.castka = 10000000;
        if (this.castka > getSharedPreferences("GAME_DATA", 0).getInt("HIGH_SCORE", 0)) {
            highscore2();
        }
        this.button2 = (Button) findViewById(C1760R.C1762id.button2);
        this.button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Youwin.this.startActivity(new Intent(Youwin.this, otazka1.class));
            }
        });
        this.button3 = (Button) findViewById(C1760R.C1762id.button3);
        this.button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Youwin.this.startActivity(new Intent(Youwin.this, MainActivity.class));
            }
        });
    }

    private void highscore2() {
        Intent intent = new Intent(getApplicationContext(), highscore.class);
        intent.putExtra("SCORE", this.castka);
        startActivity(intent);
    }
}
