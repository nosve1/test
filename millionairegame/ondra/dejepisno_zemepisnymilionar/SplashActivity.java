package com.millionairegame.ondra.dejepisno_zemepisnymilionar;

import android.content.Intent;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C1760R.layout.splash);
        new Thread() {
            public void run() {
                Intent intent;
                try {
                    super.run();
                    sleep(2000);
                    intent = new Intent(SplashActivity.this, MainActivity.class);
                } catch (Exception unused) {
                    intent = new Intent(SplashActivity.this, MainActivity.class);
                } catch (Throwable th) {
                    SplashActivity.this.startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    SplashActivity.this.finish();
                    throw th;
                }
                SplashActivity.this.startActivity(intent);
                SplashActivity.this.finish();
            }
        }.start();
    }
}
